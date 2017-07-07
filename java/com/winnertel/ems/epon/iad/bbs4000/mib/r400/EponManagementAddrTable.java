/**
 * Created by Zhou Chao, 2010/5/13
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class EponManagementAddrTable extends SnmpMibBean {

    public static final String eponManagementAddrName = "eponManagementAddrName";
    public static final String eponManagementAddrTAddress = "eponManagementAddrTAddress";
    public static final String eponManagementAddrCommunity = "eponManagementAddrCommunity";

    public EponManagementAddrTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(eponManagementAddrName, new SnmpMibBeanProperty(eponManagementAddrName, ".1.3.6.1.4.1.17409.2.2.11.3.1.1.1", ISnmpConstant.IP_ADDRESS));
        initProperty(eponManagementAddrTAddress, new SnmpMibBeanProperty(eponManagementAddrTAddress, ".1.3.6.1.4.1.17409.2.2.11.3.1.1.2", ISnmpConstant.OCTETS));
        initProperty(eponManagementAddrCommunity, new SnmpMibBeanProperty(eponManagementAddrCommunity, ".1.3.6.1.4.1.17409.2.2.11.3.1.1.3", ISnmpConstant.STRING));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.17409.2.2.11.3.1.1.4", ISnmpConstant.INTEGER));
    }

    public String getEponManagementAddrName() {
        return (String) getIndex(0);
    }

    public void setEponManagementAddrName(String aEponManagementAddrName) {
        setIndex(0, aEponManagementAddrName);
    }

    public byte[] getEponManagementAddrTAddress() {
        return (byte[]) getProperty(eponManagementAddrTAddress).getValue();
    }

    public void setEponManagementAddrTAddress(byte[] aEponManagementAddrTAddress) {
        getProperty(eponManagementAddrTAddress).setValue(aEponManagementAddrTAddress);
    }

    public String getEponManagementAddrCommunity() {
    	String v=(String) getProperty(eponManagementAddrCommunity).getValue();
    	try{
	    	byte[] b =v.getBytes();
	    	int i=0;
	    	for(i=0;i<b.length;i++)
	    		if(b[i]==0)break;
	    	return new String(b,0,i);
    	}catch(Exception e){
    		return v;
    	}
    }

    public void setEponManagementAddrCommunity(String aEponManagementAddrCommunity) {
        getProperty(eponManagementAddrCommunity).setValue(aEponManagementAddrCommunity);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(eponManagementAddrTAddress));
        prepareRead(getProperty(eponManagementAddrCommunity));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(eponManagementAddrTAddress));
        prepareRead(getProperty(eponManagementAddrCommunity));

        return loadAll(new int[]{4});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(eponManagementAddrTAddress));
        prepareSave(getProperty(eponManagementAddrCommunity));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(eponManagementAddrTAddress));
        prepareSave(getProperty(eponManagementAddrCommunity));

        setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}