package com.winnertel.ems.epon.iad.bbs4000.mib.r310;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2CtcValidOnuMacTable;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;
import com.winnertel.em.standard.snmp.gui.formatter.MacAddressFormatter;

import java.util.Vector;

public class Dot3UnboundOnuTable extends SnmpMibBean {

    public static final String utsDot3UnboundOnuModuleId = "utsDot3UnboundOnuModuleId";
    public static final String utsDot3UnboundOnuPortId = "utsDot3UnboundOnuPortId";
    public static final String utsDot3UnboundOnuLlid = "utsDot3UnboundOnuLlid";
    public static final String utsDot3UnboundOnuPonMacAddr = "utsDot3UnboundOnuPonMacAddr";
    public static final String utsDot3UnboundOnuPonLoid = "utsDot3UnboundOnuPonLoid";
    public static final String utsDot3UnboundOnuPonPassword = "utsDot3UnboundOnuPonPassword";
    public static final String utsDot3UnboundOnuId = "utsDot3UnboundOnuId";

    private String onuLabel = null;

    public Dot3UnboundOnuTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsDot3UnboundOnuModuleId, new SnmpMibBeanProperty(utsDot3UnboundOnuModuleId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.1", ISnmpConstant.INTEGER));
        initProperty(utsDot3UnboundOnuPortId, new SnmpMibBeanProperty(utsDot3UnboundOnuPortId, ".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.2", ISnmpConstant.INTEGER));
        initProperty(utsDot3UnboundOnuLlid, new SnmpMibBeanProperty(utsDot3UnboundOnuLlid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.3", ISnmpConstant.INTEGER));
        initProperty(utsDot3UnboundOnuPonMacAddr, new SnmpMibBeanProperty(utsDot3UnboundOnuPonMacAddr, ".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.4", ISnmpConstant.MAC_ADDRESS));
        initProperty(utsDot3UnboundOnuPonLoid, new SnmpMibBeanProperty(utsDot3UnboundOnuPonLoid, ".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.5", ISnmpConstant.STRING));
        initProperty(utsDot3UnboundOnuPonPassword, new SnmpMibBeanProperty(utsDot3UnboundOnuPonPassword, ".1.3.6.1.4.1.45121.1800.2.3.1.2.2.1.1.6", ISnmpConstant.STRING));
        initProperty(utsDot3UnboundOnuId, new SnmpMibBeanProperty(utsDot3UnboundOnuId, "", ISnmpConstant.INTEGER));
    }

    public Integer getUtsDot3UnboundOnuModuleId() {
        return (Integer) getIndex(0);
    }

    public void setUtsDot3UnboundOnuModuleId(Integer aUtsDot3UnboundOnuModuleId) {
        setIndex(0, aUtsDot3UnboundOnuModuleId);
    }

    public Integer getUtsDot3UnboundOnuPortId() {
        return (Integer) getIndex(1);
    }

    public void setUtsDot3UnboundOnuPortId(Integer aUtsDot3UnboundOnuPortId) {
        setIndex(1, aUtsDot3UnboundOnuPortId);
    }

    public Integer getUtsDot3UnboundOnuLlid() {
        return (Integer) getIndex(2);
    }

    public void setUtsDot3UnboundOnuLlid(Integer aUtsDot3UnboundOnuLlid) {
        setIndex(2, aUtsDot3UnboundOnuLlid);
    }

    public byte[] getUtsDot3UnboundOnuPonMacAddr() {
        return (byte[]) getProperty(utsDot3UnboundOnuPonMacAddr).getValue();
    }

    public void setUtsDot3UnboundOnuPonMacAddr(byte[] aUtsDot3UnboundOnuPonMacAddr) {
        getProperty(utsDot3UnboundOnuPonMacAddr).setValue(aUtsDot3UnboundOnuPonMacAddr);
    }
    
    public String getUtsDot3UnboundOnuPonLoid() {
        return (String) getProperty(utsDot3UnboundOnuPonLoid).getValue();
    }

    public void setUtsDot3UnboundOnuPonLoid(String aUtsDot3UnboundOnuPonLoid) {
        getProperty(utsDot3UnboundOnuPonLoid).setValue(aUtsDot3UnboundOnuPonLoid);
    }
    
    public String getUtsDot3UnboundOnuPonPassword() {
        return (String) getProperty(utsDot3UnboundOnuPonPassword).getValue();
    }

    public void setUtsDot3UnboundOnuPonPassword(String aUtsDot3UnboundOnuPonPassword) {
        getProperty(utsDot3UnboundOnuPonPassword).setValue(aUtsDot3UnboundOnuPonPassword);
    }
    

    public Integer getUtsDot3UnboundOnuId() {
        return (Integer) getProperty(utsDot3UnboundOnuId).getValue();
    }

    public void setUtsDot3UnboundOnuId(Integer aUtsDot3UnboundOnuId) {
        getProperty(utsDot3UnboundOnuId).setValue(aUtsDot3UnboundOnuId);
    }

    public String getOnuLabel() {
        return onuLabel;
    }

    public void setOnuLabel(String s) {
        onuLabel = s;
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsDot3UnboundOnuPonMacAddr));
        prepareRead(getProperty(utsDot3UnboundOnuPonLoid));
        prepareRead(getProperty(utsDot3UnboundOnuPonPassword));

        boolean b = load();

//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                String mac = ConfigUtility.OctetToMacAddress(getUtsDot3UnboundOnuPonMacAddr());
//                setOnuLabel(onuMgmtMgr.getOnuLabel(mac));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return b;
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsDot3UnboundOnuPonMacAddr));
        prepareRead(getProperty(utsDot3UnboundOnuPonLoid));
        prepareRead(getProperty(utsDot3UnboundOnuPonPassword));

        Vector v = loadAll(new int[]{1, 1, 1});

//        if (!DebugMode.isDebug()) {
//            try {
//                OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                for (int i = 0; i < v.size(); i++) {
//                    Dot3UnboundOnuTable bean = (Dot3UnboundOnuTable) v.get(i);
//                    String mac = ConfigUtility.OctetToMacAddress(bean.getUtsDot3UnboundOnuPonMacAddr());
//                    bean.setOnuLabel(onuMgmtMgr.getOnuLabel(mac));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return v;
    }

    public boolean modify() throws MibBeanException {
        Dot3Onu2CtcValidOnuMacTable binding = new Dot3Onu2CtcValidOnuMacTable(fSnmpProxy);
        binding.setUtsDot3OnuValidOnuMacModuleId(getUtsDot3UnboundOnuModuleId());
        binding.setUtsDot3OnuValidOnuMacDeviceId(1);
        binding.setUtsDot3OnuValidOnuMacPortId(getUtsDot3UnboundOnuPortId());
        binding.setUtsDot3OnuValidOnuMacAppLPortId(getUtsDot3UnboundOnuId());
        binding.setUtsDot3ValidOnuMacAddr(getUtsDot3UnboundOnuPonMacAddr());

        return binding.modify();
    }

    public String toString() {
        if (onuLabel != null) {
            return onuLabel;
        }

        return MacAddressFormatter.format(getUtsDot3UnboundOnuPonMacAddr());
    }

}