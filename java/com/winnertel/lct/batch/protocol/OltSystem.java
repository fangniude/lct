package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@Root(name = "system_node", strict = false)
public class OltSystem {
    public enum Field {
        name, location, contact, mgmtVlan, macAgeing, macAuth, vlanTransParent, globalP2p, mgmtIp
    }

    @Attribute(name = "system_name", required = false)
    private String name;
    @Attribute(name = "system_location", required = false)
    private String location;
    @Attribute(name = "system_contact", required = false)
    private String contact;
    @Attribute(name = "mgmt_vlan", required = false)
    private String mgmtVlan;
    @Attribute(name = "mac_ageing", required = false)
    private String macAgeing;
    @Attribute(name = "onu_auth_mode", required = false)
    private String macAuth;
    @Attribute(name = "vlan_transparent", required = false)
    private String vlanTransParent;
    @Attribute(name = "global_p2p", required = false)
    private String globalP2p;
    @Attribute(name = "mgmt_ip", required = false)
    private String mgmtIp;

    public OltSystem() {
    }

    public OltSystem(String name, String location, String contact, String mgmtVlan, String macAgeing, String macAuth, String vlanTransParent, String globalP2p, String mgmtIp) {
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.mgmtVlan = mgmtVlan;
        this.macAgeing = macAgeing;
        this.macAuth = macAuth;
        this.vlanTransParent = vlanTransParent;
        this.globalP2p = globalP2p;
        this.mgmtIp = mgmtIp;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("index.0", "0");
        map.put(Field.name.name(), name);
        map.put(Field.location.name(), location);
        map.put(Field.contact.name(), contact);
        map.put(Field.mgmtVlan.name(), mgmtVlan);
        map.put(Field.macAgeing.name(), macAgeing);
        map.put(Field.macAuth.name(), macAuth);
        map.put(Field.vlanTransParent.name(), vlanTransParent);
        map.put(Field.globalP2p.name(), globalP2p);
        map.put(Field.mgmtIp.name(), mgmtIp);
        return map;
    }

    public static OltSystem valueOf(Map<String, Object> map) {
        OltSystem system = new OltSystem();
        system.setName(valueOf(map.get(Field.name.name())));
        system.setLocation(valueOf(map.get(Field.location.name())));
        system.setContact(valueOf(map.get(Field.contact.name())));
        system.setMgmtVlan(valueOf(map.get(Field.mgmtVlan.name())));
        system.setMacAgeing(valueOf(map.get(Field.macAgeing.name())));
        system.setMacAuth(valueOf(map.get(Field.macAuth.name())));
        system.setVlanTransParent(valueOf(map.get(Field.vlanTransParent.name())));
        system.setGlobalP2p(valueOf(map.get(Field.globalP2p.name())));
        system.setMgmtIp(valueOf(map.get(Field.mgmtIp.name())));
        return system;
    }

    public static String valueOf(Object o) {
        if (o == null) {
            return null;
        } else {
            return String.valueOf(o);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMgmtVlan() {
        return mgmtVlan;
    }

    public void setMgmtVlan(String mgmtVlan) {
        this.mgmtVlan = mgmtVlan;
    }

    public String getMacAgeing() {
        return macAgeing;
    }

    public void setMacAgeing(String macAgeing) {
        this.macAgeing = macAgeing;
    }

    public String getMacAuth() {
        return macAuth;
    }

    public void setMacAuth(String macAuth) {
        this.macAuth = macAuth;
    }

    public String getVlanTransParent() {
        return vlanTransParent;
    }

    public void setVlanTransParent(String vlanTransParent) {
        this.vlanTransParent = vlanTransParent;
    }

    public String getGlobalP2p() {
        return globalP2p;
    }

    public void setGlobalP2p(String globalP2p) {
        this.globalP2p = globalP2p;
    }

    public String getMgmtIp() {
        return mgmtIp;
    }

    public void setMgmtIp(String mgmtIp) {
        this.mgmtIp = mgmtIp;
    }
}
