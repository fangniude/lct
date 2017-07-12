package com.winnertel.lct.batch.proxy;

import java.util.Map;

public class XmlRow {
    private XmlRowIndex index;
    private Map<String, Object> data;

    public XmlRow(XmlRowIndex index, Map<String, Object> data) {
        this.index = index;
        this.data = data;
    }

    public XmlRow(IndexType[] indexTypes, Map<String, Object> map) {
        this(new XmlRowIndex(indexTypes, map), map);
    }

    public XmlRowIndex getIndex() {
        return index;
    }

    public void setIndex(XmlRowIndex index) {
        this.index = index;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
