package com.winnertel.lct.batch.proxy;

import com.winnertel.lct.batch.protocol.Olt;
import com.winnertel.lct.batch.protocol.OltBase;
import com.winnertel.lct.batch.protocol.OnuBase;
import com.winnertel.lct.batch.protocol.Profile;
import org.apache.commons.net.tftp.TFTP;
import org.apache.commons.net.tftp.TFTPClient;

import java.io.*;
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
        fromDisk();
        return tableMap.get(tableName).select();
    }

    public Map<String, Object> selectOne(TableName tableName, XmlRowIndex index) {
        fromDisk();
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

    public void save(TableName tableName, Map<String, Object> map) {
        tableMap.get(tableName).save(map);
        toDisk();
    }

    public void delete(TableName tableName, Map<String, Object> map) {
        tableMap.get(tableName).delete(map);
        toDisk();
    }

    public void toDisk() {
        OltBase.fromMap(tableMap).toFile(oltFile);
        OnuBase.fromMap(tableMap).toFile(onuFile);
        Profile.fromMap(tableMap).toFile(profileFile);
    }

    public void fromDisk() {
        OltBase.fromFile(oltFile).toMap(tableMap);
        OnuBase.fromFile(onuFile).toMap(tableMap);
        Profile.fromFile(profileFile).toMap(tableMap);
    }

    public void sendOltBase() {
        sendXml2Olt("oltbase.xml", oltFile);
    }

    public void sendOnuBase() {
        sendXml2Olt("onubase.xml", onuFile);
    }

    public void sendOnuProfile() {
        sendXml2Olt("onuprofile.xml", profileFile);
    }

    public void input(File file) {
        sendXml2Olt("olt.xml", file);
    }

    public void output(File file) {
        getXmlFromOlt("olt.xml", file);
    }

    public void sync() {
        File file = new File("tmp");
        getXmlFromOlt("olt.xml", file);
        if (file.length() > 0) {
            Olt olt = Olt.fromFile(file);
            new OltBase(olt.getSystem(), olt.getVlanList(), olt.getQinqList()).toFile(oltFile);
            new OnuBase(olt.getMacList(), olt.getOnuCfg(), olt.getOnuUni()).toFile(onuFile);
            fromDisk();
            if (file.exists()) {
                file.delete();
            }

            if (System.currentTimeMillis() - oltFile.lastModified() > 5000 || System.currentTimeMillis() - onuFile.lastModified() > 5000) {
                throw new RuntimeException("sync fail.");
            }
        } else {
            throw new RuntimeException("get olt.xml file error.");
        }
    }

    private void sendXml2Olt(String fileName, File file) {
        TFTPClient client = new TFTPClient();
        try {
            client.open();
            try (InputStream in = new FileInputStream(file)) {
                client.sendFile(fileName, TFTP.OCTET_MODE, in, host);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("tftp put error, fileName: %s", fileName), e);
        }
    }

    private void getXmlFromOlt(String fileName, File file) {
        TFTPClient client = new TFTPClient();
        try {
            client.open();
            try (OutputStream out = new FileOutputStream(file)) {
                int i = client.receiveFile(fileName, TFTP.OCTET_MODE, out, host);
                if (i <= 0) {
                    throw new RuntimeException(String.format("tftp get error, fileName: %s", fileName));
                }
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("tftp get error, fileName: %s", fileName), e);
        }
    }

    public static void main(String[] args) {
        XmlDataBase db = XmlDataBase.getInstance("192.168.1.2");
        System.out.println(db);
    }
}
