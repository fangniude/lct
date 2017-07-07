package com.winnertel.em.broadband.common.util;

import com.winnertel.client.util.NmsClientUtil;
import com.winnertel.common.topo.api.UAPIProxy;
import com.winnertel.common.topo.discovery.model.NodeEntityInfo;
import com.winnertel.inms.topoui.UTopoUIContext;
import com.winnertel.nms.lite.LiteContext;
import com.winnertel.nms.lite.util.xml.XMLBasicParser;
import com.winnertel.nms.version.CompanyInfo;
import com.winnertel.nms.version.VersionInfoConstant;
import com.winnertel.nms.version.inf.VersionInfoInf;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;

public class OEMClientUtils {
    public static CompanyInfo getCompanyInfo() {
        try {
            VersionInfoInf versionInfoInf = (VersionInfoInf) UTopoUIContext.getFrontEndRepo().lookupObjectInRegistry(VersionInfoConstant.VERSION_INFO_SERVICE);
            return versionInfoInf.getVersionInfo().getCompanyInfo();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return null;

    }

    public static String getLabelByNEType(String aNEType) {
        if (LiteContext.isLCTModel()) {
            return getOEMDisplayDirect(aNEType);
        }

        try {
            if (sysProfile == null) {
                UAPIProxy proxy = (UAPIProxy) NmsClientUtil.getAPI(UAPIProxy.API_NAME);
                sysProfile = proxy.getSystemProfile();
            }
            NodeEntityInfo entityInfo = (NodeEntityInfo) sysProfile.get(NodeEntityInfo.KEY_NAME);
            return entityInfo.getMOTypeLabel(aNEType);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }

    public static String getNETypeByLabel(String aLabel) {
        if (LiteContext.isLCTModel()) {
            return getOEMKeyByValueDirect(aLabel);
        }
        try {
            if (sysProfile == null) {
                UAPIProxy proxy = (UAPIProxy) NmsClientUtil.getAPI(UAPIProxy.API_NAME);
                sysProfile = proxy.getSystemProfile();
            }
            NodeEntityInfo entityInfo = (NodeEntityInfo) sysProfile.get(NodeEntityInfo.KEY_NAME);
            return entityInfo.getNETypeByLabe(aLabel);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }

    private static String getOEMDisplayDirect(String key) {
        if( fProperty == null ) {
            init();
        }
        OEMValue v = fProperty.get(key);
        if (v == null) {
            return key;
        }
        if (Locale.CHINA.equals(Locale.getDefault())) {
            return v.zhName;
        } else {
            return v.enName;
        }
    }

    private static String getOEMKeyByValueDirect(String oemValue) {
        if( fProperty == null ) {
            init();
        }
        Iterator<String> keys = fProperty.keySet().iterator();

        while (keys.hasNext()) {
            String key = (String) keys.next();
            OEMValue v = fProperty.get(key);
            if (Locale.CHINA.equals(Locale.getDefault())) {
                if (v.zhName.equals(oemValue)) {
                    return key;
                }
            } else {
                if (v.enName.equals(oemValue)) {
                    return key;
                }
            }
        }
        return oemValue;
    }

    private static void init() {

        fProperty = new HashMap<String, OEMValue>();

        try {
            new XMLBasicParser( new FileInputStream( OEM_RESOURCE_PATH ) ) {
                @Override
                protected boolean handleData(String sNodeName, String sNodeVal, Hashtable htAttr, boolean isLeaf) {
                    if( "NETYPE".equalsIgnoreCase(sNodeName) ) {
                        try {
                            String id = htAttr.get("id").toString();
                            String zh_name = htAttr.get("zh_name").toString();
                            String en_name = htAttr.get("en_name").toString();

                            fProperty.put(id, new OEMValue(id, zh_name, en_name));
                        } catch ( Exception ex ) {
                            ex.printStackTrace();
                        }

                    }
                    return true;
                }
            }.doLoad();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }

    }

    private static Hashtable sysProfile;
    private static HashMap<String, OEMValue> fProperty = null;

    private static final String OEM_RESOURCE_PATH = System.getProperty("user.dir") + "/conf/netype.conf";

    static  class OEMValue {
        public String id;
        public String zhName;
        public String enName;

        OEMValue(String id, String zhName, String enName) {
            super();
            this.id = id;
            this.zhName = zhName;
            this.enName = enName;
        }


    }
}
