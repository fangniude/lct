package com.winnertel.lct.batch.proxy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class XmlTable {
    private TableName tableName;
    private Map<String, XmlRow> rowMap;

    public XmlTable(TableName tableName) {
        this(tableName, new ConcurrentHashMap<>());
    }

    public XmlTable(TableName tableName, Map<String, XmlRow> rowMap) {
        this.tableName = tableName;
        this.rowMap = rowMap;
    }

    public List<Map<String, Object>> select() {
        return rowMap.values().stream().map(XmlRow::getData).collect(Collectors.toList());
    }

    public Map<String, Object> selectOne(XmlRowIndex index) {
        return rowMap.get(index.toString()).getData();
    }

    public void insert(Map<String, Object> map) {
        XmlRow row = new XmlRow(tableName.indexTypes(), map);

        if (rowMap.containsKey(row.getIndex().toString())) {
            throw new RuntimeException("row has exist.");
        } else {
            rowMap.put(row.getIndex().toString(), row);
        }
    }

    public void update(Map<String, Object> map) {
        XmlRow row = new XmlRow(tableName.indexTypes(), map);

        if (rowMap.containsKey(row.getIndex().toString())) {
            rowMap.put(row.getIndex().toString(), row);
        } else {
            throw new RuntimeException("row has not exist.");
        }
    }

    public void delete(Map<String, Object> map) {
        XmlRowIndex index = new XmlRowIndex(tableName.indexTypes(), map);
        rowMap.remove(index.toString());
    }
}
