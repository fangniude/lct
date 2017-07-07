/**
 * Modified by Zhouchao, 2011/5/26
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.FileSystemGroup;
import com.winnertel.em.framework.IApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NeFileSystem {

    protected IApplication fApplication;

    public NeFileSystem(IApplication theApplication) {
        fApplication = theApplication;
    }

    public File[] list(File dir) throws IOException {
        if (dir.isFile)
            throw new IOException(dir + " is not a directory.");

        return list(dir.getAbsoluteName());
    }

    public File[] list(String dir) throws IOException {
        FileSystemGroup bean = new FileSystemGroup(fApplication.getSnmpProxy());
        StringBuffer sb = new StringBuffer();

        try {
            bean.setUtsFileSystemCommand(new Integer(FileSystemGroup.File_System_Command_List));
            bean.setUtsFileSystemListDirectory(dir);
            bean.setUtsFileSystemCommandStationId(dir);

            bean.modify();

            boolean end = false;
            while (!end) {
                bean.retrieve();
                sb.append(bean.getUtsFileSystemListDirectoryResult());
                if (bean.isEnd())
                    end = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());
        }

        //if (!dir.equals(bean.getUtsFileSystemCommandStationId()))
        //  continue;
        List fileList = parseFileList(dir, sb.toString());

        Collections.sort(fileList);

        return (File[]) fileList.toArray(new File[0]);
    }

    private static List parseFileList(String dir, String fileList) {
        StringTokenizer st = new StringTokenizer(fileList, ";");
        ArrayList list = new ArrayList(st.countTokens());
        while (st.hasMoreTokens()) {
            String temp = st.nextToken().trim();

            //trim "'" around the string.
            if (temp.startsWith("'") && temp.endsWith("'")) {
                temp = temp.substring(1, temp.length() - 1);
            }

            File file = composeFile(dir, temp);
            if (file != null) {
                list.add(file);
            }
        }

        return list;
    }

    private static File composeFile(String path, String str) {
        if (str == null)
            return null;

        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        if (!tokenizer.hasMoreTokens())
            return null;

        String name = tokenizer.nextToken();
        if (name.equals(".") || name.equals(".."))
            return null;

        File file = new File(name);
        file.setPath(path);

        if (tokenizer.countTokens() > 3) { //directory
            file.setDirectory(true);
            tokenizer.nextToken();
        } else {
            file.setFile(true);
        }

        return file;
    }

    public static class File implements Comparable {
        public static final String File_Separator = "/";

        String name = "";
        String path = "";
        boolean isFile = true;

        public File(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getAbsoluteName() {
            if ((path != null) && (!path.equals("")))
                return path + File_Separator + name;
            else
                return name;
        }

        public boolean isFile() {
            return isFile;
        }

        public void setFile(boolean isFile) {
            this.isFile = isFile;
        }

        public boolean isDirectory() {
            return !isFile;
        }

        public void setDirectory(boolean isDirectory) {
            isFile = !isDirectory;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String toString() {
            return name;
        }

        public int compareTo(Object o) {
            if (name == null)
                return -1;

            if (o == null)
                return 1;
            if (!(o instanceof File))
                return 1;

            File file = (File) o;
            //directory is upon on the file.
            if (isFile && file.isDirectory())
                return 1;

            if (!isFile && file.isFile())
                return -1;

            return name.compareTo(o.toString());
        }
    }

}