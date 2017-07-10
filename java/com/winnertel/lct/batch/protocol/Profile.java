package com.winnertel.lct.batch.protocol;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;
import java.util.List;

@Root(name = "root", strict = false)
public class Profile {

    @Path("onu")
    @ElementList(inline = true, type = ProfileOnu.class, required = false)
    private List<ProfileOnu> onuList;

    @Path("uni")
    @ElementList(inline = true, type = ProfileUni.class, required = false)
    private List<ProfileUni> uniList;

    public Profile() {
    }

    public Profile(List<ProfileOnu> onuList, List<ProfileUni> uniList) {
        this.onuList = onuList;
        this.uniList = uniList;
    }

    public static String toXml(Profile data) {
        try {
            StringWriter out = new StringWriter();
            new Persister().write(data, out);
            return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Profile fromXml(String xml) {
        try {
            Profile result = new Persister().read(Profile.class, xml);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProfileOnu> getOnuList() {
        return onuList;
    }

    public void setOnuList(List<ProfileOnu> onuList) {
        this.onuList = onuList;
    }

    public List<ProfileUni> getUniList() {
        return uniList;
    }

    public void setUniList(List<ProfileUni> uniList) {
        this.uniList = uniList;
    }
}
