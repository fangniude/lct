package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@Root(name = "onu_uni", strict = false)
public class ProfileUni {
    public enum Field {
        vlanMode, vlanTag, passVlan, vlanTpid, policingEnable, policingCir, policingCbs, policingEbs, dsCir, dsPir, dsEnable, loopDetect
    }

    @Attribute(name = "onu_uni_id", required = false)
    private String id;

    @Attribute(name = "onu_vlan_mode", required = false)
    private String vlanMode;

    @Attribute(name = "onu_vlan_tag", required = false)
    private String vlanTag;

    @Attribute(name = "onu_vlan_trunk", required = false)
    private String passVlan;

    @Attribute(name = "onu_vlan_tpid", required = false)
    private String vlanTpid;

    @Attribute(name = "policing_enable", required = false)
    private String policingEnable;

    @Attribute(name = "policing_cir", required = false)
    private String policingCir;

    @Attribute(name = "policing_cbs", required = false)
    private String policingCbs;

    @Attribute(name = "policing_ebs", required = false)
    private String policingEbs;

    @Attribute(name = "ds_cir", required = false)
    private String dsCir;

    @Attribute(name = "ds_pir", required = false)
    private String dsPir;

    @Attribute(name = "ds_enable", required = false)
    private String dsEnable;

    @Attribute(name = "loop_detect", required = false)
    private String loopDetect;

    public ProfileUni() {
    }

    public ProfileUni(String id, String vlanMode, String vlanTag, String vlanTpid, String policingEnable, String policingCir, String policingCbs, String policingEbs, String dsCir, String dsPir, String dsEnable, String loopDetect) {
        this.id = id;
        this.vlanMode = vlanMode;
        this.vlanTag = vlanTag;
        this.vlanTpid = vlanTpid;
        this.policingEnable = policingEnable;
        this.policingCir = policingCir;
        this.policingCbs = policingCbs;
        this.policingEbs = policingEbs;
        this.dsCir = dsCir;
        this.dsPir = dsPir;
        this.dsEnable = dsEnable;
        this.loopDetect = loopDetect;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("index.0", id);
        map.put(Field.vlanMode.name(), vlanMode);
        map.put(Field.vlanTag.name(), vlanTag);
        map.put(Field.passVlan.name(), passVlan);
        map.put(Field.vlanTpid.name(), vlanTpid);
        map.put(Field.policingEnable.name(), policingEnable);
        map.put(Field.policingCir.name(), policingCir);
        map.put(Field.policingCbs.name(), policingCbs);
        map.put(Field.policingEbs.name(), policingEbs);
        map.put(Field.dsCir.name(), dsCir);
        map.put(Field.dsPir.name(), dsPir);
        map.put(Field.dsEnable.name(), dsEnable);
        map.put(Field.loopDetect.name(), loopDetect);
        return map;
    }

    public static ProfileUni valueOf(Map<String, Object> map) {
        ProfileUni uni = new ProfileUni();
        uni.setId(valueOf(map.get("index.0")));
        uni.setVlanMode(valueOf(map.get(Field.vlanMode.name())));
        uni.setVlanTag(valueOf(map.get(Field.vlanTag.name())));
        uni.setPassVlan(valueOf(map.get(Field.passVlan.name())));
        uni.setVlanTpid(valueOf(map.get(Field.vlanTpid.name())));
        uni.setPolicingEnable(valueOf(map.get(Field.policingEnable.name())));
        uni.setPolicingCir(valueOf(map.get(Field.policingCir.name())));
        uni.setPolicingCbs(valueOf(map.get(Field.policingCbs.name())));
        uni.setPolicingEbs(valueOf(map.get(Field.policingEbs.name())));
        uni.setDsCir(valueOf(map.get(Field.dsCir.name())));
        uni.setDsPir(valueOf(map.get(Field.dsPir.name())));
        uni.setDsEnable(valueOf(map.get(Field.dsEnable.name())));
        uni.setLoopDetect(valueOf(map.get(Field.loopDetect.name())));
        return uni;
    }

    public static String valueOf(Object o) {
        if (o == null) {
            return null;
        } else {
            return String.valueOf(o);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVlanMode() {
        return vlanMode;
    }

    public void setVlanMode(String vlanMode) {
        this.vlanMode = vlanMode;
    }

    public String getVlanTag() {
        return vlanTag;
    }

    public void setVlanTag(String vlanTag) {
        this.vlanTag = vlanTag;
    }

    public String getPassVlan() {
        return passVlan;
    }

    public void setPassVlan(String passVlan) {
        this.passVlan = passVlan;
    }

    public String getVlanTpid() {
        return vlanTpid;
    }

    public void setVlanTpid(String vlanTpid) {
        this.vlanTpid = vlanTpid;
    }

    public String getPolicingEnable() {
        return policingEnable;
    }

    public void setPolicingEnable(String policingEnable) {
        this.policingEnable = policingEnable;
    }

    public String getPolicingCir() {
        return policingCir;
    }

    public void setPolicingCir(String policingCir) {
        this.policingCir = policingCir;
    }

    public String getPolicingCbs() {
        return policingCbs;
    }

    public void setPolicingCbs(String policingCbs) {
        this.policingCbs = policingCbs;
    }

    public String getPolicingEbs() {
        return policingEbs;
    }

    public void setPolicingEbs(String policingEbs) {
        this.policingEbs = policingEbs;
    }

    public String getDsCir() {
        return dsCir;
    }

    public void setDsCir(String dsCir) {
        this.dsCir = dsCir;
    }

    public String getDsPir() {
        return dsPir;
    }

    public void setDsPir(String dsPir) {
        this.dsPir = dsPir;
    }

    public String getDsEnable() {
        return dsEnable;
    }

    public void setDsEnable(String dsEnable) {
        this.dsEnable = dsEnable;
    }

    public String getLoopDetect() {
        return loopDetect;
    }

    public void setLoopDetect(String loopDetect) {
        this.loopDetect = loopDetect;
    }
}
