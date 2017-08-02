/**
 * Created by Zhou Chao, 2008/10/23
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOltMultiVlanToMultiGEMPortMapMBean extends SnmpMibBean {

    public static final String oltMultiVlantoMultiGEMPorMapIndex = "oltMultiVlantoMultiGEMPorMapIndex";
    public static final String multicastVLANIDStart = "multicastVLANIDStart";
    public static final String multicastVLANIDStop = "multicastVLANIDStop";
    public static final String oltMultiVlantoMultiGEMPorMapOltGEMPortNo = "oltMultiVlantoMultiGEMPorMapOltGEMPortNo";

    public GponOltMultiVlanToMultiGEMPortMapMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(oltMultiVlantoMultiGEMPorMapIndex, new SnmpMibBeanProperty(oltMultiVlantoMultiGEMPorMapIndex, ".1.3.6.1.4.1.45121.1.3.10.5.2.17.1.1", ISnmpConstant.GAUGE));
        initProperty(multicastVLANIDStart, new SnmpMibBeanProperty(multicastVLANIDStart, ".1.3.6.1.4.1.45121.1.3.10.5.2.17.1.2", ISnmpConstant.GAUGE));
        initProperty(multicastVLANIDStop, new SnmpMibBeanProperty(multicastVLANIDStop, ".1.3.6.1.4.1.45121.1.3.10.5.2.17.1.3", ISnmpConstant.GAUGE));
        initProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo, new SnmpMibBeanProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.2.17.1.4", ISnmpConstant.GAUGE));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.2.17.1.5", ISnmpConstant.INTEGER));
    }

    public Long getOltMultiVlantoMultiGEMPorMapIndex() {
        return (Long) getIndex(0);
    }

    public void setOltMultiVlantoMultiGEMPorMapIndex(Long aOltMultiVlantoMultiGEMPorMapIndex) {
        setIndex(0, aOltMultiVlantoMultiGEMPorMapIndex);
    }

    public Long getMulticastVLANIDStart() {
        return (Long) getProperty(multicastVLANIDStart).getValue();
    }

    public void setMulticastVLANIDStart(Long aMulticastVLANIDStart) {
        getProperty(multicastVLANIDStart).setValue(aMulticastVLANIDStart);
    }

    public Long getMulticastVLANIDStop() {
        return (Long) getProperty(multicastVLANIDStop).getValue();
    }

    public void setMulticastVLANIDStop(Long aMulticastVLANIDStop) {
        getProperty(multicastVLANIDStop).setValue(aMulticastVLANIDStop);
    }

    public Long getOltMultiVlantoMultiGEMPorMapOltGEMPortNo() {
        return (Long) getProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo).getValue();
    }

    public void setOltMultiVlantoMultiGEMPorMapOltGEMPortNo(Long aOltMultiVlantoMultiGEMPorMapOltGEMPortNo) {
        getProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo).setValue(aOltMultiVlantoMultiGEMPorMapOltGEMPortNo);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(multicastVLANIDStart));
        prepareRead(getProperty(multicastVLANIDStop));
        prepareRead(getProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(multicastVLANIDStart));
        prepareRead(getProperty(multicastVLANIDStop));
        prepareRead(getProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo));

        return loadAll(new int[]{2});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(multicastVLANIDStart));
        prepareSave(getProperty(multicastVLANIDStop));
        prepareSave(getProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo));

        return save();
    }

    public boolean add() throws MibBeanException {
    	 prepareSave(getProperty(multicastVLANIDStart));
         prepareSave(getProperty(multicastVLANIDStop));
         prepareSave(getProperty(oltMultiVlantoMultiGEMPorMapOltGEMPortNo));
        setRowStatus(4);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

    public boolean delete() throws MibBeanException {
        setRowStatus(6);
        prepareSave(getProperty(ROW_STATUS));

        return save();
    }

}