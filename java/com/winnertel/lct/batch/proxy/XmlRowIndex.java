package com.winnertel.lct.batch.proxy;

import java.util.Map;
import java.util.StringJoiner;

public class XmlRowIndex {
    private String[] indexes;

    public XmlRowIndex(String... indexes) {
        this.indexes = indexes;
    }

    public XmlRowIndex(IndexType[] indexTypes, Map<String, Object> map) {
        this.indexes = new String[indexTypes.length];
        for (int i = 0; i < indexTypes.length; i++) {
            this.indexes[i] = String.valueOf(map.getOrDefault(String.format("index.%d", i), ""));
        }
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("_");
        for (String index : indexes) {
            joiner.add(index);
        }
        return joiner.toString();
    }

    public static XmlRowIndex fromString(String index) {
        return new XmlRowIndex(index.split("_"));
    }
}
