package com.winnertel.lct.batch.protocol;

import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlTable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Root(name = "root", strict = false)
public class OltBase {
    @Path("system")
    @Element(name = "system_node", required = false)
    private OltSystem system;

    @Path("vlan")
    @ElementList(inline = true, type = OltVlan.class, required = false)
    private List<OltVlan> vlanList = new ArrayList<>();

    @Path("qinq")
    @ElementList(inline = true, type = OltQinQ.class, required = false)
    private List<OltQinQ> qinqList = new ArrayList<>();

    public OltBase() {
    }

    public OltBase(OltSystem system, List<OltVlan> vlanList, List<OltQinQ> qinqList) {
        this.system = system;
        this.vlanList = vlanList;
        this.qinqList = qinqList;
    }

    public static OltBase fromFile(File oltFile) {
        try {
            return new Persister().read(OltBase.class, oltFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new OltBase();
    }

    public void toFile(File oltFile) {
        try {
            new Persister(new Format("<?xml version=\"1.0\" encoding=\"utf-8\"?>")).write(this, oltFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String toXml(OltBase data) {
        try {
            StringWriter out = new StringWriter();
            new Persister(new Format("<?xml version=\"1.0\" encoding=\"utf-8\"?>")).write(data, out);
            return out.toString();
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
//        OltVlan oltVlan = new OltVlan(1, "name", "mem", "tag");
//        OltVlan oltVlan1 = new OltVlan(2, "name1", "mem1", "tag1");
//        OltVlan oltVlan2 = new OltVlan(3, "name2", "mem2", "tag2");
//        return Arrays.asList(oltVlan, oltVlan1, oltVlan2);
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

    public static OltBase fromMap(Map<TableName, XmlTable> tableMap) {
        XmlTable sysTable = tableMap.get(TableName.OltVlan);
        List<OltVlan> oltVlanList;
        if (sysTable != null) {
            oltVlanList = sysTable.select().stream().map(OltVlan::valueOf).collect(Collectors.toList());
        } else {
            oltVlanList = new ArrayList<>();
        }
        return new OltBase(new OltSystem(), oltVlanList, new ArrayList<>());
    }

    public void toMap(Map<TableName, XmlTable> tableMap) {
        XmlTable vlanTable = new XmlTable(TableName.OltVlan);
        vlanList.stream().map(OltVlan::toMap).forEach(map -> {
            vlanTable.insert(map);
        });
        tableMap.put(TableName.OltVlan, vlanTable);
    }
}
