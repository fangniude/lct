package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

@Root(name = "root", strict = false)
public class OltBase {
    @Path("system")
    @Element(name = "system_node", required = false)
    private OltSystem system;

    @Path("vlan")
    @ElementList(inline = true, type = OltVlan.class, required = false)
    private List<OltVlan> vlanList;

    @Path("qinq")
    @ElementList(inline = true, type = OltQinQ.class, required = false)
    private List<OltQinQ> qinqList;

    public OltBase() {
    }

    public OltBase(OltSystem system, List<OltVlan> vlanList, List<OltQinQ> qinqList) {
        this.system = system;
        this.vlanList = vlanList;
        this.qinqList = qinqList;
    }

    public static String toXml(OltBase data) {
        try {
            StringWriter out = new StringWriter();
            new Persister().write(data, out);
            return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static OltBase fromXml(String xml) {
        try {
            OltBase result = new Persister().read(OltBase.class, xml);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public OltSystem getSystem() {
        return system;
    }

    public void setSystem(OltSystem system) {
        this.system = system;
    }

    public List<OltVlan> getVlanList() {
        OltVlan oltVlan = new OltVlan("1", "name", "mem", "tag");
        OltVlan oltVlan1 = new OltVlan("2", "name1", "mem1", "tag1");
        OltVlan oltVlan2 = new OltVlan("3", "name2", "mem2", "tag2");
        return Arrays.asList(oltVlan, oltVlan1, oltVlan2);
//        return vlanList;
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
}
