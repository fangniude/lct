package com.winnertel.em.standard.snmp.tool;

import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class MibBeanCodeGenerator {
    private ILogger fLogger = LoggerController.createLogger(MibBeanCodeGenerator.class);

    private final String STYLE_SHEET = "com/winnertel/em/standard/snmp/tool/SnmpMibBean.xsl";
    private final String SYSTEM_ID = "com/winnertel/em/standard/snmp/tool/SnmpMibBean.dtd";

    private Transformer fTransformer = null;
    private DocumentBuilder fParser = null;


    public MibBeanCodeGenerator() throws Exception {
        initParser();
        initTransformer();
    }


    public void generate(File sourceDir, File targetDir) {
        if (sourceDir == null || !sourceDir.isDirectory()
                || targetDir == null || !targetDir.isDirectory()) {
            throw new IllegalArgumentException("Invalid source directory or target directory");
        }

        File[] sourceFileList = sourceDir.listFiles(new MibBeanFileFilter());
        for (int i = 0; i < sourceFileList.length; i++) {
            File sourceFile = sourceFileList[i];
            if (sourceFile.isFile()) {
                generateFile(sourceFile, targetDir);
            } else if (sourceFile.isDirectory()) {
                generate(sourceFile, targetDir);
            }
        }
    }


    /**
     * Generate a SNMP MIB bean java class according to the configuration file.
     *
     * @param source a file contains information of the SNMP MIB bean
     */
    public void generateFile(File source, File targetDir) {
        if (source == null || !source.isFile()) {
            throw new IllegalArgumentException("Invalid source file");
        }

        String targetFileName = null;
        File target = null;
        try {
            Document doc = fParser.parse(source);
            Element root = doc.getDocumentElement();
            String fullClassName = root.getAttribute("package") + "."
                    + root.getAttribute("class");
            targetFileName = fullClassName.replace('.', File.separatorChar) + ".java";
            target = new File(targetDir.getPath() + File.separatorChar + targetFileName);
            // create the dirs for the target file
            String targetPath = target.getPath();
            new File(targetPath.substring(0, targetPath.lastIndexOf(File.separatorChar))).mkdirs();

            CharArrayWriter caw = new CharArrayWriter();
            StreamResult sout = new StreamResult(caw);
            fTransformer.transform(new DOMSource(doc), sout);

            CharArrayReader car = new CharArrayReader(caw.toCharArray());
            wirteInUnixFormat(car, target);
            fLogger.debug("Source file=" + source + ", Target file=" + target + "    [Done]");
        } catch (Exception ex) {
            fLogger.debug("Error in generate source code from " + source
                    + " to " + target, ex);
        }

    }

    private void wirteInUnixFormat(CharArrayReader aReader, File aTarget) {
        try {
            BufferedReader br = new LineNumberReader(aReader);
            StringWriter sw = new StringWriter();
            String line = null;
            while ((line = br.readLine()) != null) {
                sw.write(line);
                sw.write('\n');
            }
            br.close();
            sw.close();

            StringBuffer sb = sw.getBuffer();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aTarget)));
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (Exception ex) {
            fLogger.error("Failed to wirte file:" + aTarget);
        }
    }


    private void initTransformer() throws Exception {
        InputStream is = getInputStream(STYLE_SHEET);
        StreamSource ss = new StreamSource(is);
        fTransformer = TransformerFactory.newInstance().newTransformer(ss);
    }

    private void initParser() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        fParser = factory.newDocumentBuilder();
    }

    private InputStream getInputStream(String file) {
        return getClass().getClassLoader().getResourceAsStream(file);
    }


    private class MibBeanFileFilter implements FileFilter {
        private final String FILE_POSTFIX = ".mbean";


        public boolean accept(File pathname) {
            if (pathname.isDirectory()) {
                return true;
            } else if (pathname.isFile()) {
                return pathname.getName().endsWith(FILE_POSTFIX);
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java MibBeanCodeGenerator " +
                    "SourceDirectory TargetDirectory");
            System.exit(-1);
        }

        File source = new File(args[0]);
        File target = new File(args[1]);

        if (!source.exists() || !target.exists()) {
            System.err.println("No such directory: " + source);
            System.exit(-1);
        }

        try {
            new MibBeanCodeGenerator().generate(source, target);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
