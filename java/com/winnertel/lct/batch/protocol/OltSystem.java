package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@Root(name = "system_node", strict = false)
public class OltSystem {
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
    @Attribute(name = "mac_auth", required = false)
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
        map.put("name", name);
        map.put("location", location);
        map.put("contact", contact);
        map.put("mgmtVlan", mgmtVlan);
        map.put("macAgeing", macAgeing);
        map.put("macAuth", macAuth);
        map.put("vlanTransParent", vlanTransParent);
        map.put("globalP2p", globalP2p);
        map.put("mgmtIp", mgmtIp);
        return map;
    }

    public static OltSystem valueOf(Map<String, Object> map) {
        OltSystem system = new OltSystem();
        system.setName(String.valueOf(map.get("name")));
        system.setLocation(String.valueOf(map.get("location")));
        system.setContact(String.valueOf(map.get("contact")));
        system.setMgmtVlan(String.valueOf(map.get("mgmtVlan")));
        system.setMacAgeing(String.valueOf(map.get("macAgeing")));
        system.setMacAuth(String.valueOf(map.get("macAuth")));
        system.setVlanTransParent(String.valueOf(map.get("vlanTransParent")));
        system.setGlobalP2p(String.valueOf(map.get("globalP2p")));
        system.setMgmtIp(String.valueOf(map.get("mgmtIp")));
        return system;
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
