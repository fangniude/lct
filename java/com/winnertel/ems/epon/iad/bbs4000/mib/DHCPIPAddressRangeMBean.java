package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.ems.epon.snmp.SnmpUtility;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-7
 * Time: 17:33:15
 * To change this template use File | Settings | File Templates.
 */
public class DHCPIPAddressRangeMBean extends SnmpMibBean
{
	public static final String utsDHCPPoolName = "utsDHCPPoolName";
    public static final String utsDHCPPoolIncludedIpAddress = "utsDHCPPoolIncludedIpAddress";
//    public static final String utsDHCPPoolIncludedHighIpAddress = "utsDHCPPoolIncludedHighIpAddress";
    public static final String utsDHCPPoolExcludedIpAddress = "utsDHCPPoolExcludedIpAddress";
//    public static final String utsDHCPPoolExcludedHighIpAddress = "utsDHCPPoolExcludedHighIpAddress";

    ISnmpProxy snmpProxy;
    String poolname;

	public DHCPIPAddressRangeMBean(ISnmpProxy aSnmpProxy)
	{
		super(aSnmpProxy);
        snmpProxy = aSnmpProxy;
		init();
	}
    public void setName(String name){
        poolname = name;
    }

    public String getName(){
        return poolname;
    }

	protected void init()
	{
		initProperty(utsDHCPPoolName, new SnmpMibBeanProperty(utsDHCPPoolName,
				".1.3.6.1.4.1.45121.1800.2.2.1.6.3.2.1.1", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolIncludedIpAddress, new SnmpMibBeanProperty(utsDHCPPoolIncludedIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.11.1.2", ISnmpConstant.STRING));
//        initProperty(utsDHCPPoolIncludedHighIpAddress, new SnmpMibBeanProperty(utsDHCPPoolIncludedHighIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.11.1.3", ISnmpConstant.STRING));
        initProperty(utsDHCPPoolExcludedIpAddress, new SnmpMibBeanProperty(utsDHCPPoolExcludedIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.5.1.2", ISnmpConstant.STRING));
//        initProperty(utsDHCPPoolExcludedHighIpAddress, new SnmpMibBeanProperty(utsDHCPPoolExcludedHighIpAddress, ".1.3.6.1.4.1.45121.1800.2.2.1.6.3.5.1.3", ISnmpConstant.STRING));

		initProperty(ROW_STATUS,new SnmpMibBeanProperty(ROW_STATUS,".1.3.6.1.4.1.45121.1800.2.2.1.6.3.4.1.4",
						ISnmpConstant.INTEGER));

	}

	public String getUtsDHCPPoolName()
	{
		String a = (String) getIndex(0);

		return SnmpUtility.generateStringIndex(a);
	}

	public void setUtsDHCPPoolName(String aUtsDHCPPoolName)
	{
		setIndex(0, aUtsDHCPPoolName);
	}

    public String getUtsDHCPPoolIncludedIpAddress() {
        String index0 = (String) getIndex(0);
        StringTokenizer st = new StringTokenizer(index0, ".");
		int num = Integer.parseInt( st.nextToken() );
        String temp = "";
        for(int i=0;i<num+1;i++){
            temp = st.nextToken();
        }
        String index = temp;
        while(st.hasMoreTokens()){
            index += "."+st.nextToken();
        }
        return index;


    }

    public void setUtsDHCPPoolIncludedIpAddress(String aUtsDHCPPoolIncludedLowIpAddress) {
        setIndex(1, aUtsDHCPPoolIncludedLowIpAddress);
    }


//    public String getUtsDHCPPoolIncludedHighIpAddress() {
//        return (String) getProperty(utsDHCPPoolIncludedHighIpAddress).getValue();
//    }
//
//    public void setUtsDHCPPoolIncludedHighIpAddress(String aUtsDHCPPoolIncludedHighIpAddress) {
//        getProperty(utsDHCPPoolIncludedHighIpAddress).setValue(aUtsDHCPPoolIncludedHighIpAddress);
//    }

     public String getUtsDHCPPoolExcludedIpAddress() {
//         String endip = getUtsDHCPPoolExcludedHighIpAddress();

//         return (String) getIndex(1)+"--"+endip;
         return (String) getIndex(1);

    }

    public void setUtsDHCPPoolExcludedIpAddress(String aUtsDHCPPoolExcludedIpAddress) {
        setIndex(1, aUtsDHCPPoolExcludedIpAddress);
    }


//    public String getUtsDHCPPoolExcludedHighIpAddress() {
//        return (String) getProperty(utsDHCPPoolExcludedHighIpAddress).getValue();
//    }
//
//    public void setUtsDHCPPoolExcludedHighIpAddress(String aUtsDHCPPoolExcludedHighIpAddress) {
//        getProperty(utsDHCPPoolExcludedHighIpAddress).setValue(aUtsDHCPPoolExcludedHighIpAddress);
//    }


	public boolean retrieve() throws MibBeanException
	{

		return load();
	}

	public Vector retrieveAll() throws MibBeanException
	{
        prepareRead(getProperty(utsDHCPPoolIncludedIpAddress));
//        prepareRead(getProperty(utsDHCPPoolIncludedHighIpAddress));
        prepareRead(getProperty(utsDHCPPoolExcludedIpAddress));
//        prepareRead(getProperty(utsDHCPPoolExcludedHighIpAddress));

        DHCPPoolIncludeTableMBean imbean = new DHCPPoolIncludeTableMBean(snmpProxy);
        Vector iv = imbean.retrieveAll();
        DHCPPoolExcludeTableMBean embean = new DHCPPoolExcludeTableMBean(snmpProxy);
        Vector ev = embean.retrieveAll();
        DHCPPoolTable tmbean = new DHCPPoolTable(snmpProxy);
        Vector namev = tmbean.retrieveAll();
		return getRecord(iv,ev,namev);
	}

	public boolean modify() throws MibBeanException
	{
		prepareSave(getProperty(utsDHCPPoolName));

		return save();
	}

	public boolean add() throws MibBeanException
	{
		super.setRowStatus(new Integer(4));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

	public boolean delete() throws MibBeanException
	{
		super.setRowStatus(new Integer(6));
		prepareSave(getProperty(ROW_STATUS));
		return save();
	}

    Vector getRecord(Vector iv,Vector ev,Vector namev){
        Vector result = new Vector();
        int i=0,j=0,t=0;
        if(namev==null) return result;
        for(i=0 ; i<namev.size() ; i++){
            DHCPPoolTable onename = (DHCPPoolTable)namev.get(i);
            String sname = onename.getUtsDHCPPoolName();
            String include = "";
            String exclude = "";
            if(iv!=null){
                for(j=0;j<iv.size();j++){
                    DHCPPoolIncludeTableMBean onein = (DHCPPoolIncludeTableMBean)iv.get(j);
                    if(!onein.getUtsDHCPPoolName().equals(sname)) continue;
                    else{
                        include += onein.getUtsDHCPPoolIncludedLowIpAddress()+"--"+
                                onein.getUtsDHCPPoolIncludedHighIpAddress()+";";
                    }
                }
            }
            if(ev!=null){
                for(t = 0;t<ev.size();t++){

                    DHCPPoolExcludeTableMBean oneex = (DHCPPoolExcludeTableMBean)ev.get(t);
                    if(!oneex.getUtsDHCPPoolName().equals(sname))  continue;
                    else{
                        exclude += oneex.getUtsDHCPPoolExcludedLowIpAddress()+"--"+
                                oneex.getUtsDHCPPoolExcludedHighIpAddress()+";";
                    }

                }
            }
            DHCPIPAddressRangeMBean mbean = new DHCPIPAddressRangeMBean(snmpProxy);
            mbean.setUtsDHCPPoolName(SnmpUtility.formatStringIndex(sname)+"."+
                     new String(include));
            mbean.setUtsDHCPPoolExcludedIpAddress(exclude);
//            mbean.setUtsDHCPPoolIncludedIpAddress(include);
            result.add(mbean);

        }

        return result;
    }

}
