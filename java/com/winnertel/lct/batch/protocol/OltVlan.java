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

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("olt.vlan.id", id);
        map.put("olt.vlan.name", name);
        map.put("olt.vlan.member", member);
        map.put("olt.vlan.tagMember", tagMember);
        return map;
    }
}
