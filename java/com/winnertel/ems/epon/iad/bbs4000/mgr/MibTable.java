package com.winnertel.ems.epon.iad.bbs4000.mgr;

import java.util.ArrayList;
import java.util.List;

public class MibTable {
    /**
     * The OID in number format.
     */
    private String mibTableName;
    private String oid;

    // String=specId
    private List items = new ArrayList();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMibTableName() {
        return mibTableName;
    }

    public void setMibTableName(String mibTableName) {
        this.mibTableName = mibTableName;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
