package com.winnertel.ems.epon.iad.inventory.model;

/**
 * 1..32
 */
public class IADNode extends InventoryNode {

    String iadId;
    String fLabel;
    String version;

    boolean hasChild = false; //added by Zhou Chao, 2010/5/18

    public IADNode(String iadId, String aLabel) {
        this.iadId = iadId;
        fLabel = aLabel;
    }

    public String getSearchId() {
        return iadId;
    }

    public boolean haveChild() { //modified by Zhou Chao, 2010/5/18
        return hasChild;
    }

    public String toString() {
        return fLabel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setHasChild(boolean hasChild) { //added by Zhou Chao, 2010/5/18
        this.hasChild = hasChild;
    }

}