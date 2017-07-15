package com.winnertel.lct.batch.protocol;

import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlTable;
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
public class OnuBase {
    @Path("onu")
    @ElementList(inline = true, type = OnuMac.class, required = false)
    private List<OnuMac> macList;
    @Path("onu")
    @ElementList(inline = true, type = OnuCfg.class, required = false)
    private List<OnuCfg> onuCfg;
    @Path("uni")
    @ElementList(inline = true, type = OnuUni.class, required = false)
    private List<OnuUni> onuUni;

    public OnuBase() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public OnuBase(List<OnuMac> macList, List<OnuCfg> onuCfg, List<OnuUni> onuUni) {
        this.macList = macList;
        this.onuCfg = onuCfg;
        this.onuUni = onuUni;
    }

    public static OnuBase fromMap(Map<TableName, XmlTable> tableMap) {
        XmlTable macTable = tableMap.get(TableName.OnuMac);
        XmlTable cfgTable = tableMap.get(TableName.OnuCfg);
        XmlTable uniTable = tableMap.get(TableName.OnuUni);

        List<OnuMac> macList;
        if (macTable != null) {
            macList = macTable.select().stream().map(OnuMac::valueOf).collect(Collectors.toList());
        } else {
            macList = new ArrayList<>();
        }

        List<OnuCfg> cfgList;
        if (cfgTable != null) {
            cfgList = cfgTable.select().stream().map(OnuCfg::valueOf).collect(Collectors.toList());
        } else {
            cfgList = new ArrayList<>();
        }

        List<OnuUni> uniList;
        if (cfgTable != null) {
            uniList = uniTable.select().stream().map(OnuUni::valueOf).collect(Collectors.toList());
        } else {
            uniList = new ArrayList<>();
        }

        return new OnuBase(macList, cfgList, uniList);
    }

    public void toMap(Map<TableName, XmlTable> tableMap) {
        XmlTable macTable = new XmlTable(TableName.OnuMac);
        macList.stream().map(OnuMac::toMap).forEach(macTable::save);

        XmlTable cfgTable = new XmlTable(TableName.OnuCfg);
        onuCfg.stream().map(OnuCfg::toMap).forEach(cfgTable::save);

        XmlTable uniTable = new XmlTable(TableName.OnuUni);
        onuUni.stream().map(OnuUni::toMap).forEach(uniTable::save);

        tableMap.put(TableName.OnuMac, macTable);
        tableMap.put(TableName.OnuCfg, cfgTable);
        tableMap.put(TableName.OnuUni, uniTable);
    }

    public static OnuBase fromFile(File onuFile) {
        try {
            return new Persister().read(OnuBase.class, onuFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new OnuBase();
    }

    public void toFile(File onuFile) {
        try {
            new Persister(new Format("<?xml version=\"1.0\" encoding=\"utf-8\"?>")).write(this, onuFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static OnuBase fromXml(String xml) {
        try {
            return new Persister().read(OnuBase.class, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toXml(OnuBase data) {
        try {
            StringWriter out = new StringWriter();
            new Persister(new Format("<?xml version=\"1.0\" encoding=\"utf-8\"?>")).write(data, out);
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
