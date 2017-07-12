package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@Root(name = "olt_vlan", strict = false)
public class OltVlan {
    @Attribute(name = "vlan_id", required = false)
    private String id;
    @Attribute(name = "vlan_name", required = false)
    private String name;
    @Attribute(name = "vlan_member", required = false)
    private String member;
    @Attribute(name = "vlan_tagmember", required = false)
    private String tagMember;

    public OltVlan() {
    }

    public OltVlan(String id, String name, String member, String tagMember) {
        this.id = id;
        this.name = name;
        this.member = member;
        this.tagMember = tagMember;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("index.0", id);
        map.put("name", name);
        map.put("member", member);
        map.put("tagMember", tagMember);
        return map;
    }

    public static OltVlan valueOf(Map<String, Object> map) {
        OltVlan vlan = new OltVlan();
        vlan.setId(String.valueOf(map.get("index.0")));
        vlan.setName(String.valueOf(map.get("name")));
        vlan.setMember(String.valueOf(map.get("member")));
        vlan.setTagMember(String.valueOf(map.get("tagMember")));
        return vlan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getTagMember() {
        return tagMember;
    }

    public void setTagMember(String tagMember) {
        this.tagMember = tagMember;
    }
}
