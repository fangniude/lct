package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;
import java.util.List;

@Root(name = "root", strict = false)
public class OnuBase {
    @Path("onu")
    @ElementList(inline = true, type = OnuMacBind.class, required = false)
    private List<OnuMacBind> qinqList;
    @Path("onu")
    @ElementList(inline = true, type = OnuCfg.class, required = false)
    private List<OnuCfg> onuCfg;
    @Path("uni")
    @ElementList(inline = true, type = OnuUni.class, required = false)
    private List<OnuUni> onuUni;

    public OnuBase() {
    }

    public OnuBase(List<OnuMacBind> qinqList, List<OnuCfg> onuCfg, List<OnuUni> onuUni) {
        this.qinqList = qinqList;
        this.onuCfg = onuCfg;
        this.onuUni = onuUni;
    }

    public static String toXml(OnuBase data) {
        try {
            StringWriter out = new StringWriter();
            new Persister().write(data, out);
            return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static OnuBase fromXml(String xml) {
        try {
            OnuBase result = new Persister().read(OnuBase.class, xml);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<OnuMacBind> getQinqList() {
        return qinqList;
    }

    public void setQinqList(List<OnuMacBind> qinqList) {
        this.qinqList = qinqList;
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
