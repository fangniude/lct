package com.winnertel.ems.lct;

import java.util.Hashtable;
import java.util.Properties;

public abstract class LctNode {

    protected NodeMeta fMeta = new NodeMeta();

    private String fNodeVersion;
    private String fLocalPassword;
    private String fGlobalPassword;

    public NodeMeta getMeta() {
        return fMeta;
    }

    public String getNodeType() {
        return fMeta.getNodeType();
    }

    public void setNodeType(String aNodeType) {
        fMeta.setNodeType(aNodeType);
    }

    public String getNodeVersion() {
        return fNodeVersion;
    }

    public void setNodeVersion(String aNodeVersion) {
        fNodeVersion = aNodeVersion;
    }

    public String getNodeAddress() {
        return fMeta.getNodeAddress();
    }

    public void setNodeAddress(String aNodeAddress) {
        fMeta.setNodeAddress(aNodeAddress);
    }

    public String getReadCommunity() {
        return fMeta.getReadCommunity();
    }

    public void setReadCommunity(String aReadCommunity) {
        fMeta.setReadCommunity(aReadCommunity);
    }

    public String getWriteCommunity() {
        return fMeta.getWriteCommunity();
    }

    public void setWriteCommunity(String aWriteCommunity) {
        fMeta.setWriteCommunity(aWriteCommunity);
    }

    public String getLocalPassword() {
        return fLocalPassword;
    }

    public void setLocalPassword(String aLocalPassword) {
        fLocalPassword = aLocalPassword;
    }

    public String getGlobalPassword() {
        return fGlobalPassword;
    }

    public void setGlobalPassword(String aGlobalPassword) {
        fGlobalPassword = aGlobalPassword;
    }

    public LctNode() {
    }

    public boolean supportAccount() {
        return false;
    }

    public String getFullNodeAddress() {
        return getNodeAddress();
    }

    public void init(String neType, String ipAddr, Hashtable ht) {
        setNodeAddress(ipAddr);
        setNodeType(neType);

        if (ht != null) {
            if (ht.get("read_community") != null) {
                setReadCommunity((String) ht.get("read_community"));
            }

            if (ht.get("write_community") != null) {
                setWriteCommunity((String) ht.get("write_community"));
            }
        }

        retrieveNodeVersion();
    }

    public String toString() {
        return "IP=" + getNodeAddress() + ";TYPE=" + getNodeType();
    }

    public boolean isVersionCheckingEnabled() {
        return true;
    }

    protected abstract void retrieveNodeVersion();

    public static class NodeTypeMapping {

        public static Object[] getSupportedTypes() {
            return LctMain.getSupportedTypes();
        }

        public static boolean isSupportedNode(LctNode node) {
            return LctMain.isSupportedNode(node);
        }

        private static Class getLctNodeImpl(String neType) {
            if (neType == null) {
                return null;
            }
            String implBase = "com.winnertel.ems.lct.CommunityCtrlNode";
            //TODO: need a configuration file for specific ne type.

            if( neType.startsWith("GOT6000")) {
                implBase = "com.winnertel.ems.lct.impl.GOT6000LCTNode";
            }


            try {
                Class k = Class.forName(implBase);
                if (LctNode.class.isAssignableFrom(k)) {
                    return k;
                }
            } catch (Exception e) {
                System.err.println("Cannot find the expected LctNode implementing...");
                e.printStackTrace(System.err);
            }

            return null;
        }
    }

    public static LctNode createNode(String neType, String ipAddr, Hashtable ht) {
        Class klass = NodeTypeMapping.getLctNodeImpl(neType);
        if (klass != null) {
            try {
                LctNode node = (LctNode) klass.newInstance();
                node.init(neType, ipAddr, ht);
                return node;
            } catch (Exception e) {
                e.printStackTrace(System.err);
                return null;
            }
        }

        return null;
    }

    public Properties fillLctProperties(Properties p) {
        return p;
    }

    public Properties getProperties() {
        return new Properties();
    }

}