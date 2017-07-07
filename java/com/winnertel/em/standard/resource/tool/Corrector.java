package com.winnertel.em.standard.resource.tool;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.filter.ContentFilter;
import org.jdom.input.SAXBuilder;
import org.jdom.input.SAXHandler;
import org.jdom.output.XMLOutputter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.*;

public class Corrector {

    private Corrector() {
    }

    static class Locale_Encoding {
        private static Map encoding = new HashMap();

        static {
            encoding.put(Locale.US, "iso-8859-1");
            encoding.put(Locale.CHINA, "gb2312");
        }

        final static String getEncoding(Locale loc) {
            Object encode = encoding.get(loc);
            if (encode != null) {
                return encode.toString();
            }
            return "iso-8859-1";
        }

        final static String getEncoding(String file) {
            Iterator keys = encoding.keySet().iterator();
            while (keys.hasNext()) {
                Locale aKey = (Locale) keys.next();
                if (file.endsWith("_" + aKey.getLanguage() + "_" + aKey.getCountry() + ".xml")) {
                    return encoding.get(aKey).toString();
                }
            }
            return "iso-8859-1";
        }
    }


    private void sort(String file, boolean remove) throws Exception {
        class StringElement implements Comparable {
            String key;
            String value;

            StringElement(String aKey, String aValue) {
                key = aKey;
                value = aValue;
            }

            public int compareTo(Object o) {
                if (o instanceof StringElement) {
                    String aKey = ((StringElement) o).key;
                    return key.toLowerCase().compareTo(aKey.toLowerCase());
                }
                return -1;
            }
        }
        ;
        if (file.indexOf("StringMap") == -1) {
            System.out.println("the function support stringMap file only");
            return;
        }
        Map map = null;
        List list = null;
        if (remove) {
            map = new TreeMap();
        } else {
            list = new ArrayList();
        }
        SAXBuilder builder = new SAXBuilder();
        Document tDoc = builder.build(file);
        Element tRoot = tDoc.getRootElement();
        Iterator elements = tRoot.getChildren("String").iterator();
        while (elements.hasNext()) {
            Element tEle = (Element) elements.next();
            if (remove) {
                map.put(tEle.getAttributeValue("key"), tEle.getAttributeValue("value"));
            } else {
                list.add(new StringElement(tEle.getAttributeValue("key"), tEle.getAttributeValue("value")));
            }
        }
        if (remove) {
            elements = map.keySet().iterator();
        } else {
            Collections.sort(list);
            elements = list.iterator();
        }
        tRoot.removeChildren("String");
        while (elements.hasNext()) {
            Object key = elements.next();
            Element tEle = new Element("String");
            if (remove) {
                tEle.setAttribute("key", key.toString());
                tEle.setAttribute("value", map.get(key).toString());
            } else {
                StringElement se = (StringElement) key;
                tEle.setAttribute("key", se.key);
                tEle.setAttribute("value", se.value);
            }
            tRoot.addContent(tEle);
        }
        XMLOutputter outputer = new XMLOutputter("    ", true);
        outputer.setEncoding(Locale_Encoding.getEncoding(file));
        outputer.setLineSeparator("\n");
        outputer.output(tDoc, new FileOutputStream(file));
    }

    private String getFilePath(String resource, String file, Locale loc) {
        if (loc == null) {
            loc = Locale.US;
        }
        int index = resource.lastIndexOf(File.separator);
        if (index != -1) {
            return resource.substring(0, index + 1) + file +
                    "_" + loc.getLanguage() + "_" + loc.getCountry() + ".xml";
        }
        return resource;
    }

    private void correctMenuToolBar(String menuFile) {
        if (!menuFile.endsWith("MenuToolBar.xml")) {
            return;
        }
        Map menus = getMenuResource(menuFile);

        String stringMapFile = getFilePath(menuFile, "StringMap", Locale.CHINA);
        correctStringMap(stringMapFile, menus);
        stringMapFile = getFilePath(menuFile, "StringMap", Locale.US);
        correctStringMap(stringMapFile, menus);
    }

    private void correctTabbedPane(String tabbedFile) {
        if (!tabbedFile.endsWith("TabbedPanel.xml")) {
            return;
        }
    }

    private void correctTableForm(String tableFormFile) {
        if (!tableFormFile.endsWith("TableForm.xml")) {
            return;
        }
        Map fields = getFieldsResource(tableFormFile, Locale.CHINA);//tableform resorce file
        String stringMapFile = getFilePath(tableFormFile, "StringMap", Locale.CHINA);
        correctStringMap(stringMapFile, fields);
        fields = getFieldsResource(tableFormFile, Locale.US);//tableform resorce file
        stringMapFile = getFilePath(tableFormFile, "StringMap", Locale.US);
        correctStringMap(stringMapFile, fields);
    }

    private void correctFunctionTree(String functionFile) {
        if (!functionFile.endsWith("FunctionTree.xml")) {
            return;
        }
        Map fields = getFunctionTreeResource(functionFile);

        String stringMapFile = getFilePath(functionFile, "StringMap", Locale.CHINA);
        correctStringMap(stringMapFile, fields);
        stringMapFile = getFilePath(functionFile, "StringMap", Locale.US);
        correctStringMap(stringMapFile, fields);
    }

    private void correctStringMap(String stringMapFile, final Map fields) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Map stringCache = new TreeMap();
        try {
            Document doc = saxBuilder.build(stringMapFile);//string map file
            Element root = doc.getRootElement();
            List strings = root.getChildren("String");
            Iterator iter = strings.iterator();
            while (iter.hasNext()) {
                Element string = (Element) iter.next();
                String name = string.getAttributeValue("key");
                Object obj = fields.get(name);
                if (obj != null) {
                    if (obj.toString().startsWith("$$$")) {//especially for the $$${Button Text}
                        string.setAttribute("value", (String) obj.toString().substring(3));
                        stringCache.put(name, obj);
                    } else {
                        string.setAttribute("key", (String) obj);
                        stringCache.put(obj, string.getAttributeValue("value"));
                    }
                }
                stringCache.put(name, string.getAttributeValue("value"));
            }
            //check if fields has the more elements need to put
            iter = fields.keySet().iterator();
            while (iter.hasNext()) {
                Object key = iter.next();
                if (stringCache.get(key) == null) {
                    Element tmp = new Element("String");
                    tmp.setAttribute("key", (String) key);
                    tmp.setAttribute("value", (String) fields.get(key));
                    root.addContent(tmp);
                }
            }
            List comments = root.getContent(new ContentFilter(ContentFilter.TEXT));
            while (comments.size() != 0) {
                Text text = (Text) comments.get(0);
                text.detach();
            }
            XMLOutputter outputer = new XMLOutputter("    ", true);
            outputer.setEncoding(Locale_Encoding.getEncoding(Locale.CHINA));//encoding
            outputer.setLineSeparator("\n");
            outputer.output(doc, new FileOutputStream(stringMapFile));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void help() {
        System.out.println("[Usage:]");
        System.out.println("Corrector -correct dirName");
        System.out.println("\tto correct the resource file in the directory");
        System.out.println("Corrector -sort file");
        System.out.println("\tto sort the stringMap file");
        System.out.println("Corrector -removeDuplicate file");
        System.out.println("\tto sort the stringMap file and remove duplicate entries");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            help();
            return;
        }
        Corrector corrector = new Corrector();
        if (args[0].equalsIgnoreCase("-correct") || args[0].equalsIgnoreCase("correct")) {

            File file = new File(args[1]);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int x = 0; x < files.length; x++) {
                    corrector.correctTableForm(files[x].getAbsolutePath());
                    corrector.correctFunctionTree(files[x].getAbsolutePath());
                    corrector.correctMenuToolBar(files[x].getAbsolutePath());
                    corrector.correctTabbedPane(files[x].getAbsolutePath());
                }
            }
            System.out.println("Corrector finished!");
        } else if (args[0].equalsIgnoreCase("-removeDuplicate") || args[0].equalsIgnoreCase("removeDuplicate")) {
            try {
                corrector.sort(args[1], true);
            } catch (Exception ex) {
                System.out.println("Error in sort " + ex.getMessage());
            }
        } else {
            try {
                corrector.sort(args[1], false);
            } catch (Exception ex) {
                System.out.println("Error in sort " + ex.getMessage());
            }
        }
    }

    private Map getMenuResource(String menuFile) {
        final Map retValue = new TreeMap();
        try {
            SAXBuilder saxBuilder = new SAXBuilder() {
                protected SAXHandler createContentHandler() throws Exception {
                    return new SAXHandler() {
                        public void startElement(String uri, String localName, String qname, Attributes aAttributes)
                                throws SAXException {
                            super.startElement(uri, localName, qname, aAttributes);
                            if (qname.equals("Menu")) {
                                String id = getCurrentElement().getAttributeValue("id");
                                String name = getCurrentElement().getAttributeValue("name");
                                if (id == null) {
                                    id = name;
                                }
                                retValue.put(id, name);
                            } else if (qname.equals("MenuItem")) {
                                String id = getCurrentElement().getAttributeValue("id");
                                String name = getCurrentElement().getAttributeValue("name");
                                if (id == null) {
                                    id = name;
                                }
                                retValue.put(id, name);
                            }
                        }
                    };
                }
            };
            saxBuilder.build(menuFile);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return retValue;
    }

    private Map getFieldsResource(String tableFromFile, Locale loc) {
        Map retValue = new TreeMap();
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document doc = saxBuilder.build(tableFromFile);
            Element root = doc.getRootElement();
            List fields = root.getChild("FieldList").getChildren("Field");
            Iterator iter = fields.iterator();
            while (iter.hasNext()) {
                Element field = (Element) iter.next();
                String name = field.getAttributeValue("name");
                String label = field.getAttributeValue("label");
                retValue.put(name, label);
            }
            List panels = root.getChild("TablePanelList").getChildren("Panel");
            iter = panels.iterator();
            Map globalStrings = getGlobalString(loc);
            while (iter.hasNext()) {
                Element panel = (Element) iter.next();
                List buttons = panel.getChildren("Button");
                Iterator buttonIter = buttons.iterator();
                while (buttonIter.hasNext()) {
                    Element button = (Element) buttonIter.next();
                    String type = button.getAttributeValue("type");
                    String text = button.getAttributeValue("text");
                    /**
                     * because the migrator of previous version ignore the predefined button,
                     * so the stringMap should not have the information about button, that's mean
                     * the button information should be insert(not modify) in.if unfortunatelly Corrector
                     * found it existed, it use $$$ as Flag.
                     */
                    if (text == null) {
                        text = type;
                        Object obj = globalStrings.get(text);
                        if (obj != null) {
                            retValue.put(text, "$$$" + obj);
                        } else {
                            retValue.put(text, "$$$" + text);
                        }
                    } else {
                        retValue.put(text, "$$$" + text);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retValue;
    }

    private Map getGlobalString(Locale loc) {
        final Map retValue = new TreeMap();
        String resourcePath = "com/winnertel/em/standard/resource/GlobalStringMap_"
                + loc.getLanguage() + "_" + loc.getCountry() + ".xml";
        try {
            URL url = Corrector.class.getClassLoader().getResource(resourcePath);
            SAXBuilder saxBuilder = new SAXBuilder() {
                protected SAXHandler createContentHandler() throws Exception {
                    return new SAXHandler() {
                        public void startElement(String uri, String localName, String qname, Attributes aAttributes)
                                throws SAXException {
                            super.startElement(uri, localName, qname, aAttributes);
                            if (qname.equals("String")) {
                                retValue.put(getCurrentElement().getAttributeValue("key"),
                                        getCurrentElement().getAttributeValue("value"));
                            }
                        }
                    };
                }
            };
            saxBuilder.build(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retValue;
    }

    private Map getFunctionTreeResource(String functionFile) {
        final Map retValue = new TreeMap();
        try {
            SAXBuilder saxBuilder = new SAXBuilder() {
                protected SAXHandler createContentHandler() throws Exception {
                    return new SAXHandler() {
                        public void startElement(String uri, String localName, String qname, Attributes aAttributes)
                                throws SAXException {
                            super.startElement(uri, localName, qname, aAttributes);
                            if (qname.equals("Node")) {
                                retValue.put(getCurrentElement().getAttributeValue("id"),
                                        getCurrentElement().getAttributeValue("text"));
                            }
                        }
                    };
                }
            };
            saxBuilder.build(functionFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retValue;
    }


}
