package com.winnertel.em.standard.resource.tool;

import com.winnertel.em.framework.resource.IResourceManager;
import com.winnertel.em.standard.resource.DocumentLoader;
import com.winnertel.em.standard.resource.ResourceManager;
import org.jdom.Comment;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.*;

public class Migrator {

    private Migrator() {
    }

    private static Map globalCaches = new TreeMap();

    private static void writeContent(Map values, File stringMap, String encoding, String resourceFileName) {
        try {
            Document doc = new SAXBuilder().build(stringMap);
            Element root = doc.getRootElement();
            root.addContent(new Comment("Inserting " + resourceFileName + " Migration..."));
            Iterator keys = values.keySet().iterator();
            while (keys.hasNext()) {
                Object key = keys.next();
                Object value = values.get(key);
                Element stringElement = new Element("String");
                stringElement.setAttribute("key", (String) key);
                stringElement.setAttribute("value", (String) value);

                root.addContent(stringElement);
            }
            root.addContent(new Comment("End Migration..."));
            XMLOutputter outputer = new XMLOutputter("    ", true);
            outputer.setEncoding(encoding);
            outputer.setLineSeparator("\n");
            outputer.output(doc, new FileOutputStream(stringMap));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static File getStringMapFile(String originalFile, Locale locale) {
        int pathIndex = originalFile.lastIndexOf(File.separator);
        String path = originalFile.substring(0, pathIndex);
        return new File(path + File.separator + IResourceManager.FILE_STRING_MAP +
                "_" + locale.getLanguage() +
                "_" + locale.getCountry() + ".xml");
    }

    private static String getLocaleFilename(String filename, Locale locale) {
        int len = "_zh_CN".length();
        String tmp = filename.substring(0, filename.lastIndexOf(".xml") - len);
        return tmp + "_" + locale.getLanguage() + "_" + locale.getCountry() + ".xml";
    }


    public static Element buildDocument(String filename) {
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            Document doc = saxBuilder.build(filename);
            return doc.getRootElement();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static boolean buildFunctionTree(String chn, String eng, Map chineseValue, Map englishValue) {
        if (chineseValue == null || englishValue == null) {
            return false;
        }
        Element chnRoot = buildDocument(chn);
        Element engRoot = buildDocument(eng);
        if (chnRoot == null || engRoot == null) {
            return false;
        }
        List chn_trees = chnRoot.getChildren("FunctionTree");
        List eng_trees = engRoot.getChildren("FunctionTree");
        for (int x = 0; x < chn_trees.size(); x++) {
            Element chn_tree = (Element) chn_trees.get(x);
            Element eng_tree = (Element) eng_trees.get(x);
            List chn_nodes = chn_tree.getChildren("Node");
            List eng_nodes = eng_tree.getChildren("Node");
            for (int y = 0; y < chn_nodes.size(); y++) {
                Element chn_node = (Element) chn_nodes.get(y);
                Element eng_node = (Element) eng_nodes.get(y);
                saveTreeNode(chn_node, eng_node, chineseValue, englishValue);
            }
        }
        return true;
    }

    private static void saveTreeNode(Element chn_node, Element eng_node, Map chineseValue, Map englishValue) {
        String eng_id = eng_node.getAttributeValue("id");
        String eng_text = eng_node.getAttributeValue("text");
        if (eng_text == null) {
            eng_text = eng_id;
        }
        englishValue.put(eng_text, eng_text);
        String chn_text = chn_node.getAttributeValue("text");
        chineseValue.put(eng_text, chn_text);
        List chn_nodes = chn_node.getChildren("Node");
        List eng_nodes = eng_node.getChildren("Node");
        for (int x = 0; x < chn_nodes.size(); x++) {
            Element chnNode = (Element) chn_nodes.get(x);
            Element engNode = (Element) eng_nodes.get(x);
            saveTreeNode(chnNode, engNode, chineseValue, englishValue);
        }
    }

    private static boolean buildTabbedPane(String chn, String eng, Map chineseValue, Map englishValue) {
        if (chineseValue == null || englishValue == null) {
            return false;
        }
        Element chnRoot = buildDocument(chn);
        Element engRoot = buildDocument(eng);
        if (chnRoot == null || engRoot == null) {
            return false;
        }
        List chn_tps = chnRoot.getChildren("TabbedPane");
        List eng_tps = engRoot.getChildren("TabbedPane");
        for (int x = 0; x < chn_tps.size(); x++) {
            Element chn_tp = (Element) chn_tps.get(x);
            Element eng_tp = (Element) eng_tps.get(x);
            List chn_panels = chn_tp.getChildren("Panel");
            List eng_panels = eng_tp.getChildren("Panel");
            for (int y = 0; y < chn_panels.size(); y++) {
                Element chn_panel = (Element) chn_panels.get(y);
                Element eng_panel = (Element) eng_panels.get(y);
                String eng_name = eng_panel.getAttributeValue("name");
                String chn_name = chn_panel.getAttributeValue("name");
                englishValue.put(eng_name, eng_name);
                chineseValue.put(eng_name, chn_name);
            }
        }
        return true;
    }

    private static boolean buildTableForm(String chn, String eng, Map chineseValue, Map englishValue) {
        if (chineseValue == null || englishValue == null) {
            return false;
        }
        Element chnRoot = buildDocument(chn);
        Element engRoot = buildDocument(eng);
        if (chnRoot == null || engRoot == null) {
            return false;
        }
        List chn_panels = chnRoot.getChild("TablePanelList").getChildren("Panel");
        List eng_panels = engRoot.getChild("TablePanelList").getChildren("Panel");
        for (int x = 0; x < chn_panels.size(); x++) {
            Element chn_panel = (Element) chn_panels.get(x);
            Element eng_panel = (Element) eng_panels.get(x);
            String chn_name = chn_panel.getAttributeValue("name");
            String eng_name = eng_panel.getAttributeValue("name");
            if (chn_name == null) {
                chn_name = eng_name;
            }
            chineseValue.put(eng_name, chn_name);
            englishValue.put(eng_name, eng_name);

            List chn_buttons = chn_panel.getChildren("Button");
            List eng_buttons = eng_panel.getChildren("Button");
            for (int y = 0; y < chn_buttons.size(); y++) {
                Element chn_button = (Element) chn_buttons.get(y);
                Element eng_button = (Element) eng_buttons.get(y);
                String eng_type = eng_button.getAttributeValue("type");
                String eng_text = eng_button.getAttributeValue("text");
                if (eng_text == null) {
                    eng_text = getGlobalString(eng_type, Locale.US);
                }
                englishValue.put(eng_text, eng_text);

                String chn_text = chn_button.getAttributeValue("text");
                if (chn_text == null) {
                    chn_text = getGlobalString(eng_type, Locale.CHINA);
                }
                chineseValue.put(eng_text, chn_text);
            }

        }
        List chn_fields = chnRoot.getChild("FieldList").getChildren("Field");
        List eng_fields = engRoot.getChild("FieldList").getChildren("Field");
        for (int x = 0; x < chn_fields.size(); x++) {
            Element chn_field = (Element) chn_fields.get(x);
            Element eng_field = (Element) eng_fields.get(x);
            String eng_label = eng_field.getAttributeValue("label");
            String eng_name = eng_field.getAttributeValue("name");
            if (eng_label == null) {
                eng_label = eng_name;
            }
            englishValue.put(eng_label, eng_label);

            String chn_label = chn_field.getAttributeValue("label");
            if (chn_label == null) {
                chn_label = eng_label;
            }
            chineseValue.put(eng_label, chn_label);
            if (chn_field.getChild("Mib") != null && eng_field.getChild("Mib") != null) {
                List chn_entries = chn_field.getChild("Mib").getChild("ValueMap").getChildren("Entry");
                List eng_entries = eng_field.getChild("Mib").getChild("ValueMap").getChildren("Entry");
                for (int y = 0; y < chn_entries.size(); y++) {
                    Element chn_entry = (Element) chn_entries.get(y);
                    Element eng_entry = (Element) eng_entries.get(y);
                    String eng_display = eng_entry.getAttributeValue("display");
                    englishValue.put(eng_display, eng_display);
                    String chn_display = chn_entry.getAttributeValue("display");
                    chineseValue.put(eng_display, chn_display);
                }
            }
        }
        return true;
    }

    private static String getGlobalString(String text, Locale loc) {
        Object repo = globalCaches.get(loc.getLanguage());
        if (repo == null) {
            repo = initGlobalCaches(loc);
        }

        Object obj = ((Map) repo).get(text);
        if (obj == null) {
            return text;
        }
        return obj.toString();
    }

    private static Object initGlobalCaches(Locale loc) {
        Map repo = new TreeMap();
        String file = "GlobalStringMap" + "_" + loc.getLanguage() + "_" + loc.getCountry() + ".xml";
        URL url = ResourceManager.class.getResource(file);
        Element root = DocumentLoader.buildDocument(url);
        if (root == null) {
            return repo;
        }
        Iterator strings = root.getChildren("String").iterator();
        while (strings.hasNext()) {
            Element string = (Element) strings.next();
            repo.put(string.getAttributeValue("key"), string.getAttributeValue("value"));
        }
        globalCaches.put(loc.getLanguage(), repo);
        return repo;
    }

    private static boolean buildMenuToolBar(String chn, String eng, Map chineseValue, Map englishValue) {
        if (chineseValue == null || englishValue == null) {
            return false;
        }
        Element chnRoot = buildDocument(chn);
        Element engRoot = buildDocument(eng);
        if (chnRoot == null || engRoot == null) {
            return false;
        }
        List chn_bars = chnRoot.getChild("MenuBarList").getChildren("MenuBar");
        List eng_bars = engRoot.getChild("MenuBarList").getChildren("MenuBar");
        for (int x = 0; x < chn_bars.size(); x++) {
            Element chn_bar = (Element) chn_bars.get(x);
            Element eng_bar = (Element) eng_bars.get(x);
            List chn_menus = chn_bar.getChildren("Menu");
            List eng_menus = eng_bar.getChildren("Menu");
            for (int y = 0; y < chn_menus.size(); y++) {
                Element chn_mi = (Element) chn_menus.get(y);
                Element eng_mi = (Element) eng_menus.get(y);
                saveMenuProperties(chn_mi, eng_mi, chineseValue, englishValue);
            }
        }
        chn_bars = chnRoot.getChild("PopupMenuList").getChildren("PopupMenu");
        eng_bars = engRoot.getChild("PopupMenuList").getChildren("PopupMenu");
        for (int x = 0; x < chn_bars.size(); x++) {
            Element chn_bar = (Element) chn_bars.get(x);
            Element eng_bar = (Element) eng_bars.get(x);
            saveMenuProperties(chn_bar, eng_bar, chineseValue, englishValue);
        }
        return true;
    }

    private static boolean saveMenuProperties(Element chn_mi, Element eng_mi, Map chnValue, Map engValue) {
        saveMenuItemProperties(chn_mi, eng_mi, chnValue, engValue);

        List chn_mis = chn_mi.getChildren("MenuItem");
        List eng_mis = eng_mi.getChildren("MenuItem");
        for (int x = 0; x < chn_mis.size(); x++) {
            saveMenuItemProperties((Element) chn_mis.get(x), (Element) eng_mis.get(x),
                    chnValue, engValue);
        }
        List chn_ms = chn_mi.getChildren("Menu");
        List eng_ms = eng_mi.getChildren("Menu");
        for (int x = 0; x < chn_ms.size(); x++) {
            saveMenuProperties((Element) chn_ms.get(x), (Element) eng_ms.get(x),
                    chnValue, engValue);
        }
        return true;
    }

    private static boolean saveMenuItemProperties(Element chn_mi, Element eng_mi, Map chnValue, Map engValue) {
        String eid = eng_mi.getAttributeValue("id");
        String ename = eng_mi.getAttributeValue("name");
        if (eid == null) {
            eid = ename;
        }
        if (eid != null && ename != null) {
            if (eid.equalsIgnoreCase("-") || ename.equalsIgnoreCase("-")) {
                return true;
            } else {
                engValue.put(eid, ename);
            }
        }
        String cname = chn_mi.getAttributeValue("name");
        if (cname != null) {
            chnValue.put(eid, cname);
        }
        return true;
    }

    private static boolean migrate2(String filename) throws Exception {
        Map chineseValue = new TreeMap();
        Map englishValue = new TreeMap();

        String name = filename.substring(filename.lastIndexOf(File.separator) + 1);

        String chineseFile = getLocaleFilename(filename, Locale.CHINA);
        String englishFile = getLocaleFilename(filename, Locale.US);

        if (name.startsWith(IResourceManager.FILE_MENU_TOOL_BAR)) {
            buildMenuToolBar(chineseFile, englishFile, chineseValue, englishValue);
        } else if (name.startsWith(IResourceManager.FILE_FUNCTION_TREE)) {
            buildFunctionTree(chineseFile, englishFile, chineseValue, englishValue);
        } else if (name.startsWith(IResourceManager.FILE_SHELF_VIEW)) {
            //do nothing
        } else if (name.startsWith(IResourceManager.FILE_TABBED_PANEL)) {
            buildTabbedPane(chineseFile, englishFile, chineseValue, englishValue);
        } else if (name.startsWith(IResourceManager.FILE_TABLE_FORM)) {
            buildTableForm(chineseFile, englishFile, chineseValue, englishValue);
        } else {
            throw new Exception("Not accept " + name);
        }

        System.out.println("start migrate " + name);
        System.out.println("chinese keys =" + chineseValue.size());
        System.out.println("english keys =" + englishValue.size());

        writeContent(chineseValue, getStringMapFile(filename, Locale.CHINA), "gb2312", name);
        writeContent(englishValue, getStringMapFile(filename, Locale.US), "iso-8859-1", name);
        return true;
    }

    private static void help() {
        System.out.println("Migrate -command -filename[optional]");
        System.out.println("command: -gui:  gui display");
        System.out.println("         -text: non-gui display");
        System.out.println("         -help: show this message");
        System.out.println("filename:the file need migrated");
    }

    private static void showGui() {
        JFileChooser chooser = new JFileChooser("..") {
            public void approveSelection() {
                File selected = getSelectedFile();
                File[] files = selected.listFiles();
                StringBuffer comment = new StringBuffer("");
                for (int x = 0; x < files.length; x++) {
                    if (files[x].getAbsolutePath().endsWith("_en_US.xml")) {
                        continue;
                    } else if (files[x].isDirectory()) {
                        continue;
                    }
                    try {
                        if (migrate2(files[x].getAbsolutePath())) {
                            System.out.println(files[x].getAbsolutePath() + " migrate successfully!\n");
                            backupFile(files[x]);
                            comment.append("migrate " + files[x].getAbsolutePath() + " successfully!\n");
                        } else {
                            System.out.println(files[x].getAbsolutePath() + " migrate fail!\n");
                        }
                    } catch (Exception ex) {
                        System.out.println("migrate " + ex);
                    }
                }
                if (comment.toString().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "No resource need migrator!");
                } else {
                    JOptionPane.showMessageDialog(null, comment.toString());
                }
                if (globalCaches != null) {
                    globalCaches.clear();
                }
            }

            public void cancelSelection() {
                super.cancelSelection();
                if (globalCaches != null) {
                    globalCaches.clear();
                }
                globalCaches = null;
                System.exit(1);
            }
        };
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(null);
    }

    private static void backupFile(File selected) {
        int pathIndex = selected.getAbsolutePath().lastIndexOf(File.separator);
        int fileIndex = selected.getAbsolutePath().indexOf("_", pathIndex);
        String file = selected.getAbsolutePath().substring(pathIndex + 1, fileIndex);
        File enFile = new File(
                selected.getAbsolutePath().substring(0, pathIndex) +
                        File.separator + file + "_en_US.xml");
        if (enFile.exists()) {
            enFile.renameTo(new File(
                    selected.getAbsolutePath().substring(0, pathIndex) +
                            File.separator + file + ".xml"));
        }
        selected.renameTo(new File(selected.getAbsolutePath() + ".bak"));
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            help();
            return;
        }
        String command = args[0];
        if ("-gui".equalsIgnoreCase(command)) {
            showGui();
        } else if ("-text".equalsIgnoreCase(command)) {
            if (args.length == 1) {
                System.out.println("filename missed!");
                return;
            }
            try {
                if (migrate2(args[1])) {
                    System.out.println("Resource migrate successfully!");
                } else {
                    System.out.println("Resource migrate fail!");
                }
            } catch (Exception ex) {
                System.out.println("migrate " + ex);
            }
        } else {
            help();
        }
    }


}
