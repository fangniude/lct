package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "olt_qinq", strict = false)
public class OltQinQ {

    @Attribute(name = "pon_id", required = false)
    private String id;

    @Attribute(name = "qinq_index", required = false)
    private String index;

    @Attribute(name = "qinq_startvlan", required = false)
    private String startVlan;

    @Attribute(name = "qinq_endvlan", required = false)
    private String endVlan;

    @Attribute(name = "qinq_ethertype", required = false)
    private String etherType;

    @Attribute(name = "qinq_newvlan", required = false)
    private String newVlan;

    public OltQinQ() {
    }

    public OltQinQ(String id, String index, String startVlan, String endVlan, String etherType, String newVlan) {
        this.id = id;
        this.index = index;
        this.startVlan = startVlan;
        this.endVlan = endVlan;
        this.etherType = etherType;
        this.newVlan = newVlan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getStartVlan() {
        return startVlan;
    }

    public void setStartVlan(String startVlan) {
        this.startVlan = startVlan;
    }

    public String getEndVlan() {
        return endVlan;
    }

    public void setEndVlan(String endVlan) {
        this.endVlan = endVlan;
    }

    public String getEtherType() {
        return etherType;
    }

    public void setEtherType(String etherType) {
        this.etherType = etherType;
    }

    public String getNewVlan() {
        return newVlan;
    }

    public void setNewVlan(String newVlan) {
        this.newVlan = newVlan;
    }
}