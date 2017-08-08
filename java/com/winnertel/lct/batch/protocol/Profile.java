package com.winnertel.lct.batch.protocol;

import com.winnertel.lct.batch.gui.TransformUtils;
import com.winnertel.lct.batch.proxy.TableName;
import com.winnertel.lct.batch.proxy.XmlTable;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Root(name = "root", strict = false)
public class Profile {

    @Path("onu")
    @ElementList(inline = true, type = ProfileOnu.class, required = false)
    private List<ProfileOnu> onuList;

    @Path("uni")
    @ElementList(inline = true, type = ProfileUni.class, required = false)
    private List<ProfileUni> uniList;

    public Profile() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public Profile(List<ProfileOnu> onuList, List<ProfileUni> uniList) {
        this.onuList = onuList;
        this.uniList = uniList;
    }

    public static Profile fromMap(Map<TableName, XmlTable> tableMap) {
        XmlTable onuTable = tableMap.get(TableName.ProfileOnu);
        XmlTable uniTable = tableMap.get(TableName.ProfileUni);

        List<ProfileOnu> onuList;
        if (onuTable != null) {
            onuList = onuTable.select().stream().map(ProfileOnu::valueOf).sorted(Comparator.comparingInt(b -> TransformUtils.idSortNum(b.getId()))).collect(Collectors.toList());
        } else {
            onuList = new ArrayList<>();
        }

        List<ProfileUni> uniList;
        if (onuTable != null) {
            uniList = uniTable.select().stream().map(ProfileUni::valueOf).sorted(Comparator.comparingInt(b -> TransformUtils.idSortNum(b.getId()))).collect(Collectors.toList());
        } else {
            uniList = new ArrayList<>();
        }

        return new Profile(onuList, uniList);
    }

    public void toMap(Map<TableName, XmlTable> tableMap) {
        XmlTable onuTable = new XmlTable(TableName.ProfileOnu);
        onuList.stream().map(ProfileOnu::toMap).forEach(onuTable::save);

        XmlTable uniTable = new XmlTable(TableName.ProfileUni);
        uniList.stream().map(ProfileUni::toMap).forEach(uniTable::save);

        tableMap.put(TableName.ProfileOnu, onuTable);
        tableMap.put(TableName.ProfileUni, uniTable);
    }

    public static Profile fromFile(File profileFile) {
        try {
            return new Persister().read(Profile.class, profileFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Profile();
    }

    public void toFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(toXml());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Profile fromXml(String xml) {
        try {
            return new Persister().read(Profile.class, xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toXml() {
        try {
            StringWriter out = new StringWriter();
            new Persister(new Format("<?xml version=\"1.0\" encoding=\"utf-8\"?>")).write(this, out);
            return out.toString().replaceAll("   ", "\t");
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
