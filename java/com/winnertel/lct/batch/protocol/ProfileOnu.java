package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@Root(name = "onu_cfg", strict = false)
public class ProfileOnu {
    public enum Field {
        upMaxBw, downMaxBw, upCommittedBw, downCommittedBw, upFixBw, upBurstSize, downBurstSize, upPriority, mxuIpAddress, mxuIpMask, mxuGateway, mxuCVlan, mxuSVlan, mxuPriority
    }

    @Attribute(name = "onu_cfg_id", required = false)
    private String id;
    @Attribute(name = "up_max_bw", required = false)
    private String upMaxBw;
    @Attribute(name = "down_max_bw", required = false)
    private String downMaxBw;
    @Attribute(name = "up_committed_bw", required = false)
    private String upCommittedBw;
    @Attribute(name = "down_committed_bw", required = false)
    private String downCommittedBw;
    @Attribute(name = "up_fix_bw", required = false)
    private String upFixBw;
    @Attribute(name = "up_burst_size", required = false)
    private String upBurstSize;
    @Attribute(name = "down_burst_size", required = false)
    private String downBurstSize;
    @Attribute(name = "up_priority", required = false)
    private String upPriority;
    @Attribute(name = "mxuMgmtGlb_ip_address", required = false)
    private String mxuIpAddress;
    @Attribute(name = "mxuMgmtGlb_ip_mask", required = false)
    private String mxuIpMask;
    @Attribute(name = "mxuMgmtGlb_gateway", required = false)
    private String mxuGateway;
    @Attribute(name = "mxuMgmtGlb_cvlan", required = false)
    private String mxuCVlan;
    @Attribute(name = "mxuMgmtGlb_svlan", required = false)
    private String mxuSVlan;
    @Attribute(name = "mxuMgmtGlb_priority", required = false)
    private String mxuPriority;

    public ProfileOnu() {
    }

    public ProfileOnu(String id, String upMaxBw, String downMaxBw, String upCommittedBw, String downCommittedBw, String upFixBw, String upBurstSize, String downBurstSize, String upPriority, String mxuIpAddress, String mxuIpMask, String mxuGateway, String mxuCVlan, String mxuSVlan, String mxuPriority) {
        this.id = id;
        this.upMaxBw = upMaxBw;
        this.downMaxBw = downMaxBw;
        this.upCommittedBw = upCommittedBw;
        this.downCommittedBw = downCommittedBw;
        this.upFixBw = upFixBw;
        this.upBurstSize = upBurstSize;
        this.downBurstSize = downBurstSize;
        this.upPriority = upPriority;
        this.mxuIpAddress = mxuIpAddress;
        this.mxuIpMask = mxuIpMask;
        this.mxuGateway = mxuGateway;
        this.mxuCVlan = mxuCVlan;
        this.mxuSVlan = mxuSVlan;
        this.mxuPriority = mxuPriority;
    }

    public ProfileOnu(String id, String upMaxBw, String downMaxBw, String upCommittedBw, String downCommittedBw, String upFixBw, String upBurstSize, String downBurstSize, String upPriority) {
        this.id = id;
        this.upMaxBw = upMaxBw;
        this.downMaxBw = downMaxBw;
        this.upCommittedBw = upCommittedBw;
        this.downCommittedBw = downCommittedBw;
        this.upFixBw = upFixBw;
        this.upBurstSize = upBurstSize;
        this.downBurstSize = downBurstSize;
        this.upPriority = upPriority;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("index.0", id);
        map.put(Field.upMaxBw.name(), upMaxBw);
        map.put(Field.downMaxBw.name(), downMaxBw);
        map.put(Field.upCommittedBw.name(), upCommittedBw);
        map.put(Field.downCommittedBw.name(), downCommittedBw);
        map.put(Field.upFixBw.name(), upFixBw);
        map.put(Field.upBurstSize.name(), upBurstSize);
        map.put(Field.downBurstSize.name(), downBurstSize);
        map.put(Field.upPriority.name(), upPriority);
        map.put(Field.mxuIpAddress.name(), mxuIpAddress);
        map.put(Field.mxuIpMask.name(), mxuIpMask);
        map.put(Field.mxuGateway.name(), mxuGateway);
        map.put(Field.mxuCVlan.name(), mxuCVlan);
        map.put(Field.mxuSVlan.name(), mxuSVlan);
        map.put(Field.mxuPriority.name(), mxuPriority);
        return map;
    }

    public static ProfileOnu valueOf(Map<String, Object> map) {
        ProfileOnu cfg = new ProfileOnu();
        cfg.setId(valueOf(map.get("index.0")));
        cfg.setUpMaxBw(valueOf(map.get(Field.upMaxBw.name())));
        cfg.setDownMaxBw(valueOf(map.get(Field.downMaxBw.name())));
        cfg.setUpCommittedBw(valueOf(map.get(Field.upCommittedBw.name())));
        cfg.setDownCommittedBw(valueOf(map.get(Field.downCommittedBw.name())));
        cfg.setUpFixBw(valueOf(map.get(Field.upFixBw.name())));
        cfg.setUpBurstSize(valueOf(map.get(Field.upBurstSize.name())));
        cfg.setDownBurstSize(valueOf(map.get(Field.downBurstSize.name())));
        cfg.setUpPriority(valueOf(map.get(Field.upPriority.name())));
        cfg.setMxuIpAddress(valueOf(map.get(Field.mxuIpAddress.name())));
        cfg.setMxuIpMask(valueOf(map.get(Field.mxuIpMask.name())));
        cfg.setMxuGateway(valueOf(map.get(Field.mxuGateway.name())));
        cfg.setMxuCVlan(valueOf(map.get(Field.mxuCVlan.name())));
        cfg.setMxuSVlan(valueOf(map.get(Field.mxuSVlan.name())));
        cfg.setMxuPriority(valueOf(map.get(Field.mxuPriority.name())));
        return cfg;
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

    public String getUpMaxBw() {
        return upMaxBw;
    }

    public void setUpMaxBw(String upMaxBw) {
        this.upMaxBw = upMaxBw;
    }

    public String getDownMaxBw() {
        return downMaxBw;
    }

    public void setDownMaxBw(String downMaxBw) {
        this.downMaxBw = downMaxBw;
    }

    public String getUpCommittedBw() {
        return upCommittedBw;
    }

    public void setUpCommittedBw(String upCommittedBw) {
        this.upCommittedBw = upCommittedBw;
    }

    public String getDownCommittedBw() {
        return downCommittedBw;
    }

    public void setDownCommittedBw(String downCommittedBw) {
        this.downCommittedBw = downCommittedBw;
    }

    public String getUpFixBw() {
        return upFixBw;
    }

    public void setUpFixBw(String upFixBw) {
        this.upFixBw = upFixBw;
    }

    public String getUpBurstSize() {
        return upBurstSize;
    }

    public void setUpBurstSize(String upBurstSize) {
        this.upBurstSize = upBurstSize;
    }

    public String getDownBurstSize() {
        return downBurstSize;
    }

    public void setDownBurstSize(String downBurstSize) {
        this.downBurstSize = downBurstSize;
    }

    public String getUpPriority() {
        return upPriority;
    }

    public void setUpPriority(String upPriority) {
        this.upPriority = upPriority;
    }

    public String getMxuIpAddress() {
        return mxuIpAddress;
    }

    public void setMxuIpAddress(String mxuIpAddress) {
        this.mxuIpAddress = mxuIpAddress;
    }

    public String getMxuIpMask() {
        return mxuIpMask;
    }

    public void setMxuIpMask(String mxuIpMask) {
        this.mxuIpMask = mxuIpMask;
    }

    public String getMxuGateway() {
        return mxuGateway;
    }

    public void setMxuGateway(String mxuGateway) {
        this.mxuGateway = mxuGateway;
    }

    public String getMxuCVlan() {
        return mxuCVlan;
    }

    public void setMxuCVlan(String mxuCVlan) {
        this.mxuCVlan = mxuCVlan;
    }

    public String getMxuSVlan() {
        return mxuSVlan;
    }

    public void setMxuSVlan(String mxuSVlan) {
        this.mxuSVlan = mxuSVlan;
    }

    public String getMxuPriority() {
        return mxuPriority;
    }

    public void setMxuPriority(String mxuPriority) {
        this.mxuPriority = mxuPriority;
    }
}
