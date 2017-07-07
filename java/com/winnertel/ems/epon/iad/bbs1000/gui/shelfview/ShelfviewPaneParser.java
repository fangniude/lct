package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview;

//import com.utstar.util.XMLBasicParser;

import java.util.Vector;

import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

import java.util.List;
import java.util.Iterator;
import java.net.URL;


public class ShelfviewPaneParser {
    String filename = "com/winnertel/em/broadband/ne2024al/r1_0/shelfview/shelfviewpane.xml";

    public class DeviceCategory {
        private String type;
        private String version;
        private Vector trapVec = new Vector();
        private Vector deviceModuleVec = new Vector();
        private Vector resourceFileVec = new Vector();

        public DeviceCategory() {
        }

        public String getType() {
            return type;
        }

        public String getVersion() {
            return version;
        }

        public Vector getTrapVec() {
            return trapVec;
        }

        public Vector getDeviceModuleVec() {
            return deviceModuleVec;
        }

        public Vector getResourceFileVec() {
            return resourceFileVec;
        }

        public void setType(String _inpara) {
            type = _inpara;
        }

        public void setVersion(String _inpara) {
            version = _inpara;
        }

        public void setTrapVec(Vector _inpara) {
            trapVec = _inpara;
        }

        public void setDeviceModuleVec(Vector _inpara) {
            deviceModuleVec = _inpara;
        }

        public void setResourceFileVec(Vector _inpara) {
            resourceFileVec = _inpara;
        }
    }

    public class DeviceModule {
        private String name;
        private String optional;
        private Vector deviceObjectVec = new Vector();

        public DeviceModule() {
        }

        public String getName() {
            return name;
        };
        public String getOptional() {
            return optional;
        };
        public Vector getDeviceObjectVec() {
            return deviceObjectVec;
        };
        public void setName(String _inpara) {
            name = _inpara;
        };
        public void setOptional(String _inpara) {
            optional = _inpara;
        };
        public void setDeviceObjectVec(Vector _inpara) {
            deviceObjectVec = _inpara;
        };
    }


    public class DeviceObject {
        private String id;
        private String category;
        private String onLook;
        private String offLook;

        public DeviceObject() {
        }

        public String getId() {
            return id;
        }

        public String getCategory() {
            return category;
        }

        public String getOnLook() {
            return onLook;
        }

        public String getOffLook() {
            return offLook;
        }

        public void setId(String _inpara) {
            id = _inpara;
        }

        public void setCategory(String _inpara) {
            category = _inpara;
        }

        public void setOnLook(String _inpara) {
            onLook = _inpara;
        }

        public void setOffLook(String _inpara) {
            offLook = _inpara;
        }
    }

    public class ResourceFile {
        private String filetype;
        private String spmodule;
        private String filename;

        public ResourceFile() {
        }

        public String getFileType() {
            return filetype;
        }

        public String getSpModule() {
            return spmodule;
        }

        public String getFileName() {
            return filename;
        }

        public void setFileType(String _inpara) {
            filetype = _inpara;
        }

        public void setSpModule(String _inpara) {
            spmodule = _inpara;
        }

        public void setFileName(String _inpara) {
            filename = _inpara;
        }
    }

    private Vector deviceCategoryVec = new Vector();

    public Vector getDeviceCategoryVec() {
        return deviceCategoryVec;
    }


    private DeviceCategory curDeviceCategory;
    private DeviceModule curDeviceModule;
    private DeviceObject curDeviceObject;
    private ResourceFile curResourceFile;
    private Vector curDeviceModuleVec;
    private Vector curDeviceObjectVec;
    private Vector curResorceFileVec;

    public ShelfviewPaneParser() {
    }

    public ShelfviewPaneParser(String sXmlFile) {
        filename = sXmlFile;
    }

    URL getUrl(String filename) {
        URL url = getClass().getClassLoader().getResource(filename);
        return url;
    }

    /*
    <Device type="2024AL" version="1.1,1.0,1.0.1,1.0.2">
        <Module name="general" optional="fixed">
           <Object id="ACTIVE_LED" category="port"  onType="Active_Led_Up" offType="Active_Led_Down"/>
        </Module>
        <Module name="uplink" optional="fixed">
           <Object id="UPLINK_DATA_1" category="port"  onType="UPLink_data_Led" offType="UPLink_data_Led"/>
           <Object id="UPLINK_DATA_2" category="port"  onType="UPLink_data_Led" offType="UPLink_data_Led"/>
        </Module>
        <Module name="ethernet" optional="fixed">
           <Object id="PORT_1" category="port"  onType="Top_EthPort_Up" offType="Top_EthPort_Down"/>
        </Module>
        <Trap mibid=".1.3.6.1.6.3.1.1.5.3"></Trap>
        <File type="dataSourceFile" spmodule="default" name="com/winnertel/em/broadband/ne2024al/r1_0/shelfview/2024AL_template.xml"  />
    </Device>
    */
    public void loadDocument() {
        SAXBuilder builder = new SAXBuilder();
        Element rootnode = null;
        try {
            URL url = getUrl(filename);
            if (url == null) return;
            Document doc = builder.build(url);
            rootnode = doc.getRootElement();
        } catch (JDOMException e) {
            e.printStackTrace();  //To change body of catch statement use Options | File Templates.
        }

        List lDevice = rootnode.getChildren("Device");
        Iterator it = lDevice.iterator();
        while (it.hasNext()) {
            Element eDevice = (Element) it.next();
            curDeviceCategory = new DeviceCategory();
            curDeviceCategory.setType((String) eDevice.getAttributeValue("type"));
            curDeviceCategory.setVersion((String) eDevice.getAttributeValue("version"));

            deviceCategoryVec.add(curDeviceCategory);
            curDeviceModuleVec = new Vector();
            curDeviceCategory.setDeviceModuleVec(curDeviceModuleVec);

            List lModule = eDevice.getChildren("Module");
            Iterator itmd = lModule.iterator();
            while (itmd.hasNext()) {
                Element eModule = (Element) itmd.next();

                curDeviceModule = new DeviceModule();
                curDeviceModule.setName((String) eModule.getAttributeValue("name"));
                curDeviceModule.setOptional((String) eModule.getAttributeValue("optional"));
                curDeviceModuleVec.add(curDeviceModule);

                curDeviceObjectVec = new Vector();
                curDeviceModule.setDeviceObjectVec(curDeviceObjectVec);

                List lObject = eModule.getChildren("Object");
                Iterator itobj = lObject.iterator();
                while (itobj.hasNext()) {
                    Element eObject = (Element) itobj.next();

                    curDeviceObject = new DeviceObject();
                    curDeviceObject.setId((String) eObject.getAttributeValue("id"));
                    curDeviceObject.setCategory((String) eObject.getAttributeValue("category"));
                    curDeviceObject.setOnLook((String) eObject.getAttributeValue("onType"));
                    curDeviceObject.setOffLook((String) eObject.getAttributeValue("offType"));
                    curDeviceObjectVec.add(curDeviceObject);
                }
            }

            //parse all trap oids
            List lTrap = eDevice.getChildren("Trap");
            Iterator itTrap = lTrap.iterator();
            while (itTrap.hasNext()) {
                Element eTrap = (Element) itTrap.next();
                curDeviceCategory.getTrapVec().add((String) eTrap.getAttributeValue("mibid"));
            }
            //parse all kinds of resource file for shlefview
            List lFile = eDevice.getChildren("File");
            Iterator itFile = lFile.iterator();
            while (itFile.hasNext()) {
                Element eFile = (Element) itFile.next();
                curResourceFile = new ResourceFile();
                curResourceFile.setFileType((String) eFile.getAttributeValue("type"));
                curResourceFile.setSpModule((String) eFile.getAttributeValue("spmodule"));
                curResourceFile.setFileName((String) eFile.getAttributeValue("name"));
                curDeviceCategory.getResourceFileVec().add(curResourceFile);
            }
        }
    }

//    public static void main(String[] args) {
//        ShelfviewPaneParser devparser = new ShelfviewPaneParser("com/winnertel/em/broadband/ne2024al/r1_0/shelfview/shelfviewpanel.xml");
//        devparser.loadDocument();
//
//        Vector vec = devparser.getDeviceCategoryVec();
//        for (int i = 0; i < vec.size(); i++) {
//            ShelfviewPaneParser.DeviceCategory anDeviceCategory = (ShelfviewPaneParser.DeviceCategory) vec.elementAt(i);
//            System.out.println("==" + anDeviceCategory.getType() + " " + anDeviceCategory.getVersion());
//            Vector anDeviceModuleVec = (Vector) anDeviceCategory.getDeviceModuleVec();
//            for (int j = 0; j < anDeviceModuleVec.size(); j++) {
//                ShelfviewPaneParser.DeviceModule anDeviceModule = (ShelfviewPaneParser.DeviceModule) anDeviceModuleVec.elementAt(j);
//                System.out.println("====" + anDeviceModule.getName() + " " + anDeviceModule.getOptional());
//                Vector objvec = (Vector) anDeviceModule.getDeviceObjectVec();
//                for (int k = 0; k < objvec.size(); k++) {
//                    ShelfviewPaneParser.DeviceObject anDeviceObject = (ShelfviewPaneParser.DeviceObject) objvec.elementAt(k);
//                    System.out.println("======" + anDeviceObject.getId());
//                }
//            }
//            Vector trapVec = (Vector) anDeviceCategory.getTrapVec();
//            for (int l = 0; l < trapVec.size(); l++) {
//                System.out.println("==" + trapVec.elementAt(l));
//            }
//        }
//    }
}
