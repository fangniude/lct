package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Root(name = "root", strict = false)
public class Olt {
    @Path("system")
    @Element(name = "system_node", required = false)
    private OltSystem system;

    @Path("vlan")
    @ElementList(inline = true, type = OltVlan.class, required = false)
    private List<OltVlan> vlanList = new ArrayList<>();

    @Path("qinq")
    @ElementList(inline = true, type = OltQinQ.class, required = false)
    private List<OltQinQ> qinqList = new ArrayList<>();

    @Path("onu")
    @ElementList(inline = true, type = OnuMac.class, required = false)
    private List<OnuMac> macList;
    @Path("onu")
    @ElementList(inline = true, type = OnuCfg.class, required = false)
    private List<OnuCfg> onuCfg;
    @Path("uni")
    @ElementList(inline = true, type = OnuUni.class, required = false)
    private List<OnuUni> onuUni;

    public Olt() {
        this(new OltSystem(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Olt(OltSystem system, List<OltVlan> vlanList, List<OltQinQ> qinqList, List<OnuMac> macList, List<OnuCfg> onuCfg, List<OnuUni> onuUni) {
        this.system = system;
        this.vlanList = vlanList;
        this.qinqList = qinqList;
        this.macList = macList;
        this.onuCfg = onuCfg;
        this.onuUni = onuUni;
    }

    public static Olt fromFile(File oltFile) {
        try {
            return new Persister().read(Olt.class, oltFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Olt();
    }

    public OltSystem getSystem() {
        return system;
    }

    public void setSystem(OltSystem system) {
        this.system = system;
    }

    public List<OltVlan> getVlanList() {
        return vlanList;
    }

    public void setVlanList(List<OltVlan> vlanList) {
        this.vlanList = vlanList;
    }

    public List<OltQinQ> getQinqList() {
        return qinqList;
    }

    public void setQinqList(List<OltQinQ> qinqList) {
        this.qinqList = qinqList;
    }

    public List<OnuMac> getMacList() {
        return macList;
    }

    public void setMacList(List<OnuMac> macList) {
        this.macList = macList;
    }

    public List<OnuCfg> getOnuCfg() {
        return onuCfg;
    }

    public void setOnuCfg(List<OnuCfg> onuCfg) {
        this.onuCfg = onuCfg;
    }

    public List<OnuUni> getOnuUni() {
        return onuUni;
    }

    public void setOnuUni(List<OnuUni> onuUni) {
        this.onuUni = onuUni;
    }
}
