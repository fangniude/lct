package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@Root(name = "onu_attr", strict = false)
public class OnuMacBind {
    @Attribute(name = "onu_id", required = false)
    private String id;
    @Attribute(name = "onu_mac", required = false)
    private String mac;
    @Attribute(name = "onu_desc", required = false)
    private String desc;

    public OnuMacBind() {
    }

    public OnuMacBind(String id, String mac, String desc) {
        this.id = id;
        this.mac = mac;
        this.desc = desc;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("index.0", id);
        map.put("mac", mac);
        map.put("desc", desc);
        return map;
    }

    public static OnuMacBind valueOf(Map<String, Object> map) {
        OnuMacBind mac = new OnuMacBind();
        mac.setId(String.valueOf(map.get("index.0")));
        mac.setMac(String.valueOf(map.get("mac")));
        mac.setDesc(String.valueOf(map.get("desc")));
        return mac;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
