package com.winnertel.lct.batch.protocol;

import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlRowIndex;
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
        this(new OltSystem(), new ArrayList<OltVlan>(), new ArrayList<>());
    }

    public OltBase(OltSystem system, List<OltVlan> vlanList, List<OltQinQ> qinqList) {
        this.system = system;
        this.vlanList = vlanList;
        this.qinqList = qinqList;
    }

    public static OltBase fromMap(Map<TableName, XmlTable> tableMap) {
        XmlTable systemTable = tableMap.get(TableName.OltSystem);
        XmlTable vlanTable = tableMap.get(TableName.OltVlan);
        XmlTable qinqTable = tableMap.get(TableName.OltQinQ);

        OltSystem oltSystem = OltSystem.valueOf(systemTable.selectOne(new XmlRowIndex("0")));

        List<OltVlan> vlanList;
        if (vlanTable != null) {
            vlanList = vlanTable.select().stream().map(OltVlan::valueOf).collect(Collectors.toList());
        } else {
            vlanList = new ArrayList<>();
        }

        List<OltQinQ> qinqList;
        if (vlanTable != null) {
            qinqList = qinqTable.select().stream().map(OltQinQ::valueOf).collect(Collectors.toList());
        } else {
            qinqList = new ArrayList<>();
        }

        return new OltBase(oltSystem, vlanList, qinqList);
    }

    public void toMap(Map<TableName, XmlTable> tableMap) {
        XmlTable systemTable = new XmlTable(TableName.OltSystem);
        systemTable.save(system.toMap());

        XmlTable vlanTable = new XmlTable(TableName.OltVlan);
        vlanList.stream().map(OltVlan::toMap).forEach(vlanTable::save);

        XmlTable qinqTable = new XmlTable(TableName.OltQinQ);
        qinqList.stream().map(OltQinQ::toMap).forEach(qinqTable::save);

        tableMap.put(TableName.OltSystem, systemTable);
        tableMap.put(TableName.OltVlan, vlanTable);
        tableMap.put(TableName.OltQinQ, qinqTable);
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
            new Persister(new Format(0, "<?xml version=\"1.0\" encoding=\"utf-8\"?>")).write(this, oltFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static OltBase fromXml(String xml) {
        try {
            return new Persister().read(OltBase.class, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
}
