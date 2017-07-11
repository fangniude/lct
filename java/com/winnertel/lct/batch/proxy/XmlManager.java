package com.winnertel.lct.batch.proxy;

import com.winnertel.lct.batch.protocol.OltBase;
import com.winnertel.lct.batch.protocol.OnuBase;
import com.winnertel.lct.batch.protocol.Profile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XmlManager {
    private static Map<String, XmlManager> map = new ConcurrentHashMap<>();
    private final String host;
    private final OltBase oltBase;
    private final OnuBase onuBase;
    private final Profile profile;

    public static synchronized XmlManager getInstance(String host) {
        XmlManager manager = map.getOrDefault(host, new XmlManager(host));
        map.putIfAbsent(host, manager);
        return manager;
    }

    private XmlManager(String host) {
        this.host = host;
        // todo read from config file, create if not exist
        this.oltBase = new OltBase();
        this.onuBase = new OnuBase();
        this.profile = new Profile();
    }

    public OltBase getOltBase() {
        return this.oltBase;
    }

    public OnuBase getOnuBase() {
        return onuBase;
    }

    public Profile getProfile() {
        return profile;
    }
}
