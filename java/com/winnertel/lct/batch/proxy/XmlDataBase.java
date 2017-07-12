package com.winnertel.lct.batch.proxy;

import com.winnertel.lct.batch.protocol.OltBase;
import com.winnertel.lct.batch.protocol.OnuBase;
import com.winnertel.lct.batch.protocol.Profile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XmlDataBase {
    private static Map<String, XmlDataBase> map = new ConcurrentHashMap<>();
    private final String host;

    private Map<TableName, XmlTable> tableMap = new ConcurrentHashMap<>();

    private final File oltFile;
    private final File onuFile;
    private final File profileFile;

    private XmlDataBase(String host) {
        this.host = host;
        oltFile = createFileIfNotExist("oltbase");
        onuFile = createFileIfNotExist("onubase");
        profileFile = createFileIfNotExist("onuprofile");
        init();
    }

    private void init() {
        tableMap.put(TableName.OltSystem, new XmlTable(TableName.OltSystem));
        tableMap.put(TableName.OltVlan, new XmlTable(TableName.OltVlan));
        tableMap.put(TableName.OltQinQ, new XmlTable(TableName.OltQinQ));
        tableMap.put(TableName.OnuMac, new XmlTable(TableName.OnuMac));
        tableMap.put(TableName.OnuCfg, new XmlTable(TableName.OnuCfg));
        tableMap.put(TableName.OnuUni, new XmlTable(TableName.OnuUni));
        tableMap.put(TableName.ProfileOnu, new XmlTable(TableName.ProfileOnu));
        tableMap.put(TableName.ProfileUni, new XmlTable(TableName.ProfileUni));

        fromDisk();
    }

    private File createFileIfNotExist(String fileName) {
        File oltFile = new File(String.format("data%s%s%s%s.xml", File.separator, host, File.separator, fileName));
        if (!oltFile.exists()) {
            try {
                File parentFile = oltFile.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                oltFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return oltFile;
    }

    public static synchronized XmlDataBase getInstance(String host) {
        if (map.containsKey(host)) {
            return map.get(host);
        } else {
            XmlDataBase db = new XmlDataBase(host);
            map.put(host, db);
            return db;
        }
    }

    public List<Map<String, Object>> select(TableName tableName) {
        return tableMap.get(tableName).select();
    }

    public Map<String, Object> selectOne(TableName tableName, XmlRowIndex index) {
        return tableMap.get(tableName).selectOne(index);
    }

    public void insert(TableName tableName, Map<String, Object> map) {
        tableMap.get(tableName).insert(map);
        toDisk();
    }

    public void update(TableName tableName, Map<String, Object> map) {
        tableMap.get(tableName).update(map);
        toDisk();
    }

    public void delete(TableName tableName, Map<String, Object> map) {
        tableMap.get(tableName).delete(map);
        toDisk();
    }

    public void toDisk() {
        OltBase.fromMap(tableMap).toFile(oltFile);
        OnuBase.fromMap(tableMap); // todo to file
        Profile.fromMap(tableMap);
    }

    public void fromDisk() {
        OltBase.fromFile(oltFile).toMap(tableMap);
    }

    public static void main(String[] args) {
        XmlDataBase db = XmlDataBase.getInstance("192.168.1.100");
        System.out.println(db);
    }
}
