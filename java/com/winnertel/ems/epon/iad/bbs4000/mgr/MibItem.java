package com.winnertel.ems.epon.iad.bbs4000.mgr;

import com.winnertel.em.framework.model.snmp.ISnmpConstant;

public class MibItem implements ISnmpConstant {
    public MibItem() {
    }

    /**
     * The id in tableversionspec.xml field id
     */
    private String specId;
    /**
     * The OID in number format.
     */
    private String oid;

    /**
     * The snmp type definition.
     */
    private int type;

    /**
     * is index 0 means none.1,2,3 means the index sequence.
     */
    private boolean index = false;

    /**
     * Currently Just used by OCTECT and String type.
     */
    private long minLen = -1;

    /**
     * Currently Just used by OCTECT and String type.
     */
    private long maxLen = -1;

    private boolean readOnly = true;

    private boolean visable = true;

    private boolean rowStatus = false;

    public MibItem(String specId, String oid, int type) {
        this.specId = specId;

        this.oid = oid;
        this.type = type;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isFixedLen() {
        return minLen == maxLen;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getMinLen() {
        return minLen;
    }

    public void setMinLen(long minLen) {
        this.minLen = minLen;
    }

    public long getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(long maxLen) {
        this.maxLen = maxLen;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public boolean isIndex() {
        return index;
    }

    public void setIndex(boolean index) {
        this.index = index;
    }

    public boolean isVisable() {
        return visable;
    }

    public void setVisable(boolean visable) {
        this.visable = visable;
    }

    public boolean isRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(boolean rowStatus) {
        this.rowStatus = rowStatus;
    }
}
