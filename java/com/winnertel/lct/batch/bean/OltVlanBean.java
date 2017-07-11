package com.winnertel.lct.batch.bean;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.lct.batch.proxy.XmlProxy;

import java.util.Vector;

public class OltVlanBean extends SnmpMibBean {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String MEMBER = "member";
    public static final String TAG_MEMBER = "tagMember";

    public OltVlanBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    @Override
    protected void init() {
        initProperty(ID, new SnmpMibBeanProperty(ID, "olt.vlan.id", ISnmpConstant.INTEGER));
        initProperty(NAME, new SnmpMibBeanProperty(NAME, "olt.vlan.name", ISnmpConstant.STRING));
        initProperty(MEMBER, new SnmpMibBeanProperty(MEMBER, "olt.vlan.member", ISnmpConstant.STRING));
        initProperty(TAG_MEMBER, new SnmpMibBeanProperty(TAG_MEMBER, "olt.vlan.tagMember", ISnmpConstant.STRING));
    }


    public Integer getId() {
        return (Integer) getIndex(0);
    }

    public void setId(Integer id) {
        setIndex(0, id);
    }

    public String getName() {
        return (String) getProperty(NAME).getValue();
    }

    public void setName(String name) {
        getProperty(OltVlanBean.NAME).setValue(name);
    }

    public String getMember() {
        return (String) getProperty(MEMBER).getValue();
    }

    public void setMember(String member) {
        getProperty(MEMBER).setValue(member);
    }

    public String getTagMember() {
        return (String) getProperty(TAG_MEMBER).getValue();
    }

    public void setTagMember(String tagMember) {
        getProperty(TAG_MEMBER).setValue(tagMember);
    }


    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(NAME));
        prepareRead(getProperty(MEMBER));
        prepareRead(getProperty(TAG_MEMBER));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(NAME));
        prepareRead(getProperty(MEMBER));
        prepareRead(getProperty(TAG_MEMBER));

        return loadAll(new int[]{1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(NAME));
        prepareSave(getProperty(MEMBER));
        prepareSave(getProperty(TAG_MEMBER));
        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(ID));
        prepareSave(getProperty(NAME));
        prepareSave(getProperty(MEMBER));
        prepareSave(getProperty(TAG_MEMBER));

        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public static void main(String[] args) throws MibBeanException {
        OltVlanBean bean = new OltVlanBean(new XmlProxy("192.168.1.2"));
        Vector vector = bean.retrieveAll();
        System.out.println(vector);
    }

    public String toString() {
        return "vlan" + getId();
    }

}
