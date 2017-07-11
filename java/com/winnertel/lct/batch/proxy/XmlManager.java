package com.winnertel.lct.batch.proxy;

import com.winnertel.lct.batch.protocol.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class XmlManager {
    private static Map<String, XmlManager> map = new ConcurrentHashMap<>();
    private final String host;
    private final OltBase oltBase;
    private final File oltFile;
    private final File onuFile;
    private final File profileFile;
    //    private final OnuBase onuBase;
//    private final Profile profile;

    public static synchronized XmlManager getInstance(String host) {
        if (map.containsKey(host)) {
            return map.get(host);
        } else {
            XmlManager manager = new XmlManager(host);
            map.put(host, manager);
            return manager;
        }
    }

    private XmlManager(String host) {
        this.host = host;
        oltFile = createFileIfNotExist("oltbase");
        onuFile = createFileIfNotExist("onubase");
        profileFile = createFileIfNotExist("onuprofile");

        this.oltBase = OltBase.fromFile(oltFile);

//        this.onuBase = new OnuBase();
//        this.profile = new Profile();
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

    public List<Map<String, Object>> readAll(XmlTable xmlTable) {
        switch (xmlTable) {
            case OltSystem:
                break;
            case OltVlan:
                List<OltVlan> vlanList = oltBase.getVlanList();
                return vlanList.stream().map(OltVlan::toMap).collect(Collectors.toList());
            case OltQinQ:
                break;
            default:
                return null;
        }
        return null;
    }

    public Map<String, Object> read(XmlTable xmlTable) {
        return null;
    }

    public void add(XmlTable xmlTable, Map<String, Object> map) {
        OltVlan vlan = OltVlan.valueOf(map);
        oltBase.getVlanList().add(vlan);
        oltBase.toFile(oltFile);
    }

    public void modify(XmlTable xmlTable, Map<String, Object> map) {
        OltVlan vlan = OltVlan.valueOf(map);
        oltBase.getVlanList().add(vlan);
        oltBase.toFile(oltFile);
    }

    public void delete(XmlTable xmlTable, Map<String, Object> map) {
        System.out.println("delete");
    }
}
