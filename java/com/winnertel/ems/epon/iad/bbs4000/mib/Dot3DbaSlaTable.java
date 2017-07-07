package com.winnertel.ems.epon.iad.bbs4000.mib;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.StringTokenizer;
import java.util.Vector;


/**
 * The Dot3DbaSlaTable class. Created by QuickDVM
 */
public class Dot3DbaSlaTable extends SnmpMibBean {
    public static final String ifOnuIndex = "ifOnuIndex";

    public static final String utsDot3DbaSlaModuleId = "utsDot3DbaSlaModuleId";

    public static final String utsDot3DbaSlaPortId = "utsDot3DbaSlaPortId";

    public static final String utsDot3DbaSlaLogicalPortId = "utsDot3DbaSlaLogicalPortId";

    public static final String utsDot3DbaSlaUpCommittedBandwidth = "utsDot3DbaSlaUpCommittedBandwidth";

    public static final String utsDot3DbaSlaUpMaxBandwidth = "utsDot3DbaSlaUpMaxBandwidth";

    public static final String utsDot3DbaSlaVLANID = "utsDot3DbaSlaVLANID";

    public static final String utsDot3DbaSlaUNIMaxMACAddress = "utsDot3DbaSlaUNIMaxMACAddress";

    public static final String utsDot3DbaSlaIPAddress = "utsDot3DbaSlaIPAddress";

    public static final String utsDot3DbaSlaSubnetMask = "utsDot3DbaSlaSubnetMask";

    public static final String utsDot3DbaSlaCallingStationId = "utsDot3DbaSlaCallingStationId";

    public static final String utsDot3DbaSlaPlatoClass = "utsDot3DbaSlaPlatoClass";

    public static final String utsDot3DbaSlaBindingMacAddress = "utsDot3DbaSlaBindingMacAddress";

    public static final String utsDot3DbaSlaDownPolicingEnable = "utsDot3DbaSlaDownPolicingEnable";

    public static final String utsDot3DbaSlaDownMaxBandwidth = "utsDot3DbaSlaDownMaxBandwidth";

    public static final String utsDot3DbaSlaDownMaxBurstSize = "utsDot3DbaSlaDownMaxBurstSize";

    public static final String utsDot3DbaSlaP2PPolicingEnable = "utsDot3DbaSlaP2PPolicingEnable";

    public static final String utsDot3DbaSlaP2PPolicingONUList = "utsDot3DbaSlaP2PPolicingONUList";

    public static final String utsDot3DbaSlaP2PMaxBandwidth = "utsDot3DbaSlaP2PMaxBandwidth";

    public static final String utsDot3DbaSlaP2PMaxBurstSize = "utsDot3DbaSlaP2PMaxBurstSize";

    ISnmpProxy Proxy;

    private String onuLabel = "";

    public Dot3DbaSlaTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        Proxy = aSnmpProxy;
        init();
    }

    protected void init() {
        initProperty(ifOnuIndex, new SnmpMibBeanProperty(ifOnuIndex,
                ".1.3.6.1.2.1.2.2.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaModuleId,
                new SnmpMibBeanProperty(utsDot3DbaSlaModuleId,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.1",
                        ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaPortId, new SnmpMibBeanProperty(utsDot3DbaSlaPortId, ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.2",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaLogicalPortId,
                new SnmpMibBeanProperty(utsDot3DbaSlaLogicalPortId,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.3",
                        ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaUpCommittedBandwidth,
                new SnmpMibBeanProperty(utsDot3DbaSlaUpCommittedBandwidth,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.4",
                        ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaUpMaxBandwidth,
                new SnmpMibBeanProperty(utsDot3DbaSlaUpMaxBandwidth,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.5",
                        ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaVLANID, new SnmpMibBeanProperty(utsDot3DbaSlaVLANID, ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.13",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaUNIMaxMACAddress, new SnmpMibBeanProperty(utsDot3DbaSlaUNIMaxMACAddress,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.14",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaIPAddress,
                new SnmpMibBeanProperty(utsDot3DbaSlaIPAddress,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.17",
                        ISnmpConstant.STRING));
        initProperty(utsDot3DbaSlaSubnetMask,
                new SnmpMibBeanProperty(utsDot3DbaSlaSubnetMask,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.18",
                        ISnmpConstant.STRING));
        initProperty(utsDot3DbaSlaCallingStationId,
                new SnmpMibBeanProperty(utsDot3DbaSlaCallingStationId,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.23",
                        ISnmpConstant.MAC_ADDRESS));
        initProperty(utsDot3DbaSlaPlatoClass, new SnmpMibBeanProperty(utsDot3DbaSlaPlatoClass,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.24",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaBindingMacAddress,
                new SnmpMibBeanProperty(utsDot3DbaSlaBindingMacAddress,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.25",
                        ISnmpConstant.MAC_ADDRESS));
        initProperty(utsDot3DbaSlaDownPolicingEnable, new SnmpMibBeanProperty(utsDot3DbaSlaDownPolicingEnable,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.26",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaDownMaxBandwidth, new SnmpMibBeanProperty(utsDot3DbaSlaDownMaxBandwidth,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.27",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaDownMaxBurstSize, new SnmpMibBeanProperty(utsDot3DbaSlaDownMaxBurstSize,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.28",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaP2PPolicingEnable, new SnmpMibBeanProperty(utsDot3DbaSlaP2PPolicingEnable,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.36",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaP2PPolicingONUList,
                new SnmpMibBeanProperty(utsDot3DbaSlaP2PPolicingONUList,
                        ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.37",
                        ISnmpConstant.OCTETS));
        initProperty(utsDot3DbaSlaP2PMaxBandwidth, new SnmpMibBeanProperty(utsDot3DbaSlaP2PMaxBandwidth,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.38",
                ISnmpConstant.INTEGER));
        initProperty(utsDot3DbaSlaP2PMaxBurstSize, new SnmpMibBeanProperty(utsDot3DbaSlaP2PMaxBurstSize,
                ".1.3.6.1.4.1.41355.1800.2.3.1.4.2.1.1.39",
                ISnmpConstant.INTEGER));

    }

    public Integer getIfOnuIndex() {
        return (Integer) getIndex(0);
    }

    public void setIfOnuIndex(Integer aIfIndex) {
        setIndex(0, aIfIndex);
    }

    public Integer getUtsDot3DbaSlaModuleId() {
        return (Integer) getProperty(utsDot3DbaSlaModuleId).getValue();
    }

    public void setUtsDot3DbaSlaModuleId(Integer aUtsDot3DbaSlaModuleId) {
        getProperty(utsDot3DbaSlaModuleId).setValue(aUtsDot3DbaSlaModuleId);
    }

    public Integer getUtsDot3DbaSlaPortId() {
        return (Integer) getProperty(utsDot3DbaSlaPortId).getValue();
    }

    public void setUtsDot3DbaSlaPortId(Integer aUtsDot3DbaSlaPortId) {
        getProperty(utsDot3DbaSlaPortId).setValue(aUtsDot3DbaSlaPortId);
    }

    public Integer getUtsDot3DbaSlaLogicalPortId() {
        return (Integer) getProperty(utsDot3DbaSlaLogicalPortId).getValue();
    }

    public void setUtsDot3DbaSlaLogicalPortId(Integer aUtsDot3DbaSlaLogicalPortId) {
        getProperty(utsDot3DbaSlaLogicalPortId).setValue(aUtsDot3DbaSlaLogicalPortId);
    }

    public Integer getUtsDot3DbaSlaUpCommittedBandwidth() {
        return (Integer) getProperty(utsDot3DbaSlaUpCommittedBandwidth)
                .getValue();
    }

    public void setUtsDot3DbaSlaUpCommittedBandwidth(Integer aUtsDot3DbaSlaUpCommittedBandwidth) {
        getProperty(utsDot3DbaSlaUpCommittedBandwidth).setValue(aUtsDot3DbaSlaUpCommittedBandwidth);
    }

    public Integer getUtsDot3DbaSlaUpMaxBandwidth() {
        return (Integer) getProperty(utsDot3DbaSlaUpMaxBandwidth).getValue();
    }

    public void setUtsDot3DbaSlaUpMaxBandwidth(Integer aUtsDot3DbaSlaUpMaxBandwidth) {
        getProperty(utsDot3DbaSlaUpMaxBandwidth).setValue(aUtsDot3DbaSlaUpMaxBandwidth);
    }

    public Integer getUtsDot3DbaSlaVLANID() {
        return (Integer) getProperty(utsDot3DbaSlaVLANID).getValue();
    }

    public void setUtsDot3DbaSlaVLANID(Integer aUtsDot3DbaSlaVLANID) {
        getProperty(utsDot3DbaSlaVLANID).setValue(aUtsDot3DbaSlaVLANID);
    }

    public Integer getUtsDot3DbaSlaUNIMaxMACAddress() {
        return (Integer) getProperty(utsDot3DbaSlaUNIMaxMACAddress).getValue();
    }

    public void setUtsDot3DbaSlaUNIMaxMACAddress(Integer aUtsDot3DbaSlaUNIMaxMACAddress) {
        getProperty(utsDot3DbaSlaUNIMaxMACAddress).setValue(aUtsDot3DbaSlaUNIMaxMACAddress);
    }

    public String getUtsDot3DbaSlaIPAddress() {
        return (String) getProperty(utsDot3DbaSlaIPAddress).getValue();
    }

    public void setUtsDot3DbaSlaIPAddress(String aUtsDot3DbaSlaIPAddress) {
        getProperty(utsDot3DbaSlaIPAddress).setValue(aUtsDot3DbaSlaIPAddress);
    }

    public String getUtsDot3DbaSlaSubnetMask() {
        return (String) getProperty(utsDot3DbaSlaSubnetMask).getValue();
    }

    public void setUtsDot3DbaSlaSubnetMask(String aUtsDot3DbaSlaSubnetMask) {
        getProperty(utsDot3DbaSlaSubnetMask).setValue(aUtsDot3DbaSlaSubnetMask);
    }

    public byte[] getUtsDot3DbaSlaCallingStationId() {
        return (byte[]) getProperty(utsDot3DbaSlaCallingStationId).getValue();
    }

    public void setUtsDot3DbaSlaCallingStationId(byte[] aUtsDot3DbaSlaCallingStationId) {
        getProperty(utsDot3DbaSlaCallingStationId).setValue(aUtsDot3DbaSlaCallingStationId);
    }

    public Integer getUtsDot3DbaSlaPlatoClass() {
        return (Integer) getProperty(utsDot3DbaSlaPlatoClass).getValue();
    }

    public void setUtsDot3DbaSlaPlatoClass(Integer aUtsDot3DbaSlaPlatoClass) {
        getProperty(utsDot3DbaSlaPlatoClass).setValue(aUtsDot3DbaSlaPlatoClass);
    }

    public byte[] getUtsDot3DbaSlaBindingMacAddress() {
        return (byte[]) getProperty(utsDot3DbaSlaBindingMacAddress).getValue();
    }

    public void setUtsDot3DbaSlaBindingMacAddress(byte[] aUtsDot3DbaSlaBindingMacAddress) {
        getProperty(utsDot3DbaSlaBindingMacAddress).setValue(aUtsDot3DbaSlaBindingMacAddress);
    }

    public Integer getUtsDot3DbaSlaDownPolicingEnable() {
        return (Integer) getProperty(utsDot3DbaSlaDownPolicingEnable)
                .getValue();
    }

    public void setUtsDot3DbaSlaDownPolicingEnable(Integer aUtsDot3DbaSlaDownPolicingEnable) {
        getProperty(utsDot3DbaSlaDownPolicingEnable).setValue(aUtsDot3DbaSlaDownPolicingEnable);
    }

    public Integer getUtsDot3DbaSlaDownMaxBandwidth() {
        return (Integer) getProperty(utsDot3DbaSlaDownMaxBandwidth).getValue();
    }

    public void setUtsDot3DbaSlaDownMaxBandwidth(Integer aUtsDot3DbaSlaDownMaxBandwidth) {
        getProperty(utsDot3DbaSlaDownMaxBandwidth).setValue(aUtsDot3DbaSlaDownMaxBandwidth);
    }

    public Integer getUtsDot3DbaSlaDownMaxBurstSize() {
        return (Integer) getProperty(utsDot3DbaSlaDownMaxBurstSize).getValue();
    }

    public void setUtsDot3DbaSlaDownMaxBurstSize(Integer aUtsDot3DbaSlaDownMaxBurstSize) {
        getProperty(utsDot3DbaSlaDownMaxBurstSize).setValue(aUtsDot3DbaSlaDownMaxBurstSize);
    }

    public Integer getUtsDot3DbaSlaP2PPolicingEnable() {
        return (Integer) getProperty(utsDot3DbaSlaP2PPolicingEnable).getValue();
    }

    public void setUtsDot3DbaSlaP2PPolicingEnable(Integer aUtsDot3DbaSlaP2PPolicingEnable) {
        getProperty(utsDot3DbaSlaP2PPolicingEnable).setValue(aUtsDot3DbaSlaP2PPolicingEnable);
    }

    public byte[] getUtsDot3DbaSlaP2PPolicingONUList() {
        return (byte[])getProperty(utsDot3DbaSlaP2PPolicingONUList).getValue();
    }

    public void setUtsDot3DbaSlaP2PPolicingONUList(byte[] aUtsDot3DbaSlaP2PPolicingONUList) {
        getProperty(utsDot3DbaSlaP2PPolicingONUList).setValue(aUtsDot3DbaSlaP2PPolicingONUList);
    }

    public Integer getUtsDot3DbaSlaP2PMaxBandwidth() {
        return (Integer) getProperty(utsDot3DbaSlaP2PMaxBandwidth).getValue();
    }

    public void setUtsDot3DbaSlaP2PMaxBandwidth(Integer aUtsDot3DbaSlaP2PMaxBandwidth) {
        getProperty(utsDot3DbaSlaP2PMaxBandwidth).setValue(aUtsDot3DbaSlaP2PMaxBandwidth);
    }

    public Integer getUtsDot3DbaSlaP2PMaxBurstSize() {
        return (Integer) getProperty(utsDot3DbaSlaP2PMaxBurstSize).getValue();
    }

    public void setUtsDot3DbaSlaP2PMaxBurstSize(Integer aUtsDot3DbaSlaP2PMaxBurstSize) {
        getProperty(utsDot3DbaSlaP2PMaxBurstSize).setValue(aUtsDot3DbaSlaP2PMaxBurstSize);
    }

    public String getOnuLabel()
    {
      return onuLabel;
    }

    public void setOnuLabel(String s)
    {
      onuLabel = s;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3DbaSlaModuleId));
        prepareRead(super.getProperty(utsDot3DbaSlaPortId));
        prepareRead(super.getProperty(utsDot3DbaSlaLogicalPortId));
        prepareRead(super.getProperty(utsDot3DbaSlaUpCommittedBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaUpMaxBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaVLANID));
        prepareRead(super.getProperty(utsDot3DbaSlaUNIMaxMACAddress));
        prepareRead(super.getProperty(utsDot3DbaSlaIPAddress));
        prepareRead(super.getProperty(utsDot3DbaSlaSubnetMask));
        prepareRead(super.getProperty(utsDot3DbaSlaCallingStationId));
        prepareRead(super.getProperty(utsDot3DbaSlaPlatoClass));
        prepareRead(super.getProperty(utsDot3DbaSlaBindingMacAddress));
        prepareRead(super.getProperty(utsDot3DbaSlaDownPolicingEnable));
        prepareRead(super.getProperty(utsDot3DbaSlaDownMaxBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaDownMaxBurstSize));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PPolicingEnable));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PPolicingONUList));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PMaxBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PMaxBurstSize));

        boolean b = load();
//        if(!DebugMode.isDebug())
//        {
//          try
//          {
//            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//
//            String mac = ConfigUtility.OctetToMacAddress(getUtsDot3DbaSlaBindingMacAddress());
//
//            setOnuLabel(onuMgmtMgr.getOnuLabel(mac));
//          }
//          catch(Exception e)
//          {
//            e.printStackTrace();
//          }
//        }

        return b;
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(utsDot3DbaSlaModuleId));
        prepareRead(super.getProperty(utsDot3DbaSlaPortId));
        prepareRead(super.getProperty(utsDot3DbaSlaLogicalPortId));
        prepareRead(super.getProperty(utsDot3DbaSlaUpCommittedBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaUpMaxBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaVLANID));
        prepareRead(super.getProperty(utsDot3DbaSlaUNIMaxMACAddress));
        prepareRead(super.getProperty(utsDot3DbaSlaIPAddress));
        prepareRead(super.getProperty(utsDot3DbaSlaSubnetMask));
        prepareRead(super.getProperty(utsDot3DbaSlaCallingStationId));
        prepareRead(super.getProperty(utsDot3DbaSlaPlatoClass));
        prepareRead(super.getProperty(utsDot3DbaSlaBindingMacAddress));
        prepareRead(super.getProperty(utsDot3DbaSlaDownPolicingEnable));
        prepareRead(super.getProperty(utsDot3DbaSlaDownMaxBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaDownMaxBurstSize));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PPolicingEnable));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PPolicingONUList));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PMaxBandwidth));
        prepareRead(super.getProperty(utsDot3DbaSlaP2PMaxBurstSize));

        setRowsToFetch(128);

        Vector v = loadAll(new int[] {1});

//        if(!DebugMode.isDebug())
//        {
//          try
//          {
//            OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//            String neName = ClientUtility.getNeNameByNeIp(fSnmpProxy.getTargetHost());
//
//            Map map = onuMgmtMgr.getOnuLabelMap(neName);
//
//            for(int i = 0; i < v.size(); i++)
//            {
//              Dot3DbaSlaTable bean = (Dot3DbaSlaTable)v.get(i);
//
//              String key = neName + bean.getUtsDot3DbaSlaModuleId() + "/" + bean.getUtsDot3DbaSlaPortId() + "/" + bean.getUtsDot3DbaSlaLogicalPortId();
//              if(map.get(key) != null)
//              {
//                bean.setOnuLabel((String)map.get(key));
//              }
//            }
//          }
//          catch(Exception e)
//          {
//            e.printStackTrace();
//          }
//        }

        return v;
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(utsDot3DbaSlaUpCommittedBandwidth));
        prepareSave(getProperty(utsDot3DbaSlaUpMaxBandwidth));
        prepareSave(getProperty(utsDot3DbaSlaVLANID));
        prepareSave(getProperty(utsDot3DbaSlaUNIMaxMACAddress));
        prepareSave(getProperty(utsDot3DbaSlaPlatoClass));
        prepareSave(getProperty(utsDot3DbaSlaBindingMacAddress));
        prepareSave(getProperty(utsDot3DbaSlaDownPolicingEnable));
        prepareSave(getProperty(utsDot3DbaSlaDownMaxBandwidth));
        prepareSave(getProperty(utsDot3DbaSlaDownMaxBurstSize));
        prepareSave(getProperty(utsDot3DbaSlaP2PPolicingEnable));
        prepareSave(getProperty(utsDot3DbaSlaP2PPolicingONUList));
        prepareSave(getProperty(utsDot3DbaSlaP2PMaxBandwidth));
        prepareSave(getProperty(utsDot3DbaSlaP2PMaxBurstSize));

        return save();
    }

    public boolean add() throws MibBeanException {
        return false;
    }

    public void BatchModify(Vector v, int UCBandwidth, int UMBandwidth, int UMMacaddress, int DMBandwidth,
                            int DMBurstSize, int DPolicing, int Plato) throws MibBeanException {
        if (v != null) {
            for (int i = 0; i < v.size(); i++) {
                String index = (String) v.get(i);
                StringTokenizer tokens = new StringTokenizer(index, "/");
                String strCard = tokens.nextElement().toString();
                String strPort = tokens.nextElement().toString();
                String strOnu = tokens.nextElement().toString();
                int cardID = Integer.parseInt(strCard.substring(strCard.indexOf(' ') + 1));
                int portID = Integer.parseInt(strPort.substring(strPort.indexOf(' ') + 1));
                int onuID = Integer.parseInt(strOnu.substring(strOnu.indexOf(' ') + 1));
                int cpindex = ConfigUtility.generateIfIndex(cardID + "/" + portID);

                Dot3DbaSlaTable mbean = new Dot3DbaSlaTable(Proxy);
                mbean.setIfOnuIndex(new Integer(cpindex + onuID));
                mbean.setUtsDot3DbaSlaUpCommittedBandwidth(new Integer(UCBandwidth));
                mbean.setUtsDot3DbaSlaUpMaxBandwidth(new Integer(UMBandwidth));
                mbean.setUtsDot3DbaSlaUNIMaxMACAddress(new Integer(UMMacaddress));
                mbean.setUtsDot3DbaSlaDownMaxBandwidth(new Integer(DMBandwidth));
                mbean.setUtsDot3DbaSlaDownMaxBurstSize(new Integer(DMBurstSize));
                mbean.setUtsDot3DbaSlaDownPolicingEnable(new Integer(DPolicing));
                mbean.setUtsDot3DbaSlaPlatoClass(new Integer(Plato));
                mbean.prepareSave(mbean.getProperty(utsDot3DbaSlaUpCommittedBandwidth));
                mbean.prepareSave(mbean.getProperty(utsDot3DbaSlaUpMaxBandwidth));
                mbean.prepareSave(mbean.getProperty(utsDot3DbaSlaUNIMaxMACAddress));
                mbean.prepareSave(mbean.getProperty(utsDot3DbaSlaPlatoClass));
                mbean.prepareSave(mbean.getProperty(utsDot3DbaSlaDownPolicingEnable));
                mbean.prepareSave(mbean.getProperty(utsDot3DbaSlaDownMaxBandwidth));
                mbean.prepareSave(mbean.getProperty(utsDot3DbaSlaDownMaxBurstSize));
//                mbean.setRowStatus(new Integer(1));
//                mbean.prepareSave(mbean.getProperty(ROW_STATUS));

                mbean.save();
            }
        }
    }


}
