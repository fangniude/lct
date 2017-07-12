package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@Root(name = "onu_cfg", strict = false)
public class OnuCfg {
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

    public OnuCfg() {
    }

    public OnuCfg(String id, String upMaxBw, String downMaxBw, String upCommittedBw, String downCommittedBw, String upFixBw, String upBurstSize, String downBurstSize, String upPriority) {
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

    public OnuCfg(String id, String upMaxBw, String downMaxBw, String upCommittedBw, String downCommittedBw, String upFixBw, String upBurstSize, String downBurstSize, String upPriority, String mxuIpAddress, String mxuIpMask, String mxuGateway, String mxuCVlan, String mxuSVlan, String mxuPriority) {
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

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("index.0", id);
        map.put("upMaxBw", upMaxBw);
        map.put("downMaxBw", downMaxBw);
        map.put("upCommittedBw", upCommittedBw);
        map.put("downCommittedBw", downCommittedBw);
        map.put("upFixBw", upFixBw);
        map.put("upBurstSize", upBurstSize);
        map.put("downBurstSize", downBurstSize);
        map.put("upPriority", upPriority);
        map.put("mxuIpAddress", mxuIpAddress);
        map.put("mxuIpMask", mxuIpMask);
        map.put("mxuGateway", mxuGateway);
        map.put("mxuCVlan", mxuCVlan);
        map.put("mxuSVlan", mxuSVlan);
        map.put("mxuPriority", mxuPriority);
        return map;
    }

    public static OnuCfg valueOf(Map<String, Object> map) {
        OnuCfg cfg = new OnuCfg();
        cfg.setId(String.valueOf(map.get("index.0")));
        cfg.setUpMaxBw(String.valueOf(map.get("upMaxBw")));
        cfg.setDownMaxBw(String.valueOf(map.get("downMaxBw")));
        cfg.setUpCommittedBw(String.valueOf(map.get("upCommittedBw")));
        cfg.setDownCommittedBw(String.valueOf(map.get("downCommittedBw")));
        cfg.setUpFixBw(String.valueOf(map.get("upFixBw")));
        cfg.setUpBurstSize(String.valueOf(map.get("upBurstSize")));
        cfg.setDownBurstSize(String.valueOf(map.get("downBurstSize")));
        cfg.setUpPriority(String.valueOf(map.get("upPriority")));
        cfg.setMxuIpAddress(String.valueOf(map.get("mxuIpAddress")));
        cfg.setMxuIpMask(String.valueOf(map.get("mxuIpMask")));
        cfg.setMxuGateway(String.valueOf(map.get("mxuGateway")));
        cfg.setMxuCVlan(String.valueOf(map.get("mxuCVlan")));
        cfg.setMxuSVlan(String.valueOf(map.get("mxuSVlan")));
        cfg.setMxuPriority(String.valueOf(map.get("mxuPriority")));
        return cfg;
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
