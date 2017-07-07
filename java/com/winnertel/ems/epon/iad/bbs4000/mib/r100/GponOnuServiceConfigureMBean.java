/**
 * Created by Zhou Chao, 2008/9/28
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class GponOnuServiceConfigureMBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgServiceSubscription = "onuCfgServiceSubscription";
    public static final String onuCfgUpstreamTrafficMappingType = "onuCfgUpstreamTrafficMappingType";
    public static final String onuCfgUpstreamTrafficMappingProfileIndex = "onuCfgUpstreamTrafficMappingProfileIndex";
    public static final String onuCfgTcontVirtualPortBindingType = "onuCfgTcontVirtualPortBindingType";
    public static final String onuCfgTcontVirtualPortBindingProfileIndex = "onuCfgTcontVirtualPortBindingProfileIndex";
    public static final String onuCfgSecurityCapability = "onuCfgSecurityCapability";
    public static final String onuCfgSecurityMode = "onuCfgSecurityMode";

    //public static final String onuCfgOnuMulticastFilterMode = "onuCfgOnuMulticastFilterMode";
    //public static final String onuCfgOnuMulticastGemPortNo = "onuCfgOnuMulticastGemPortNo";
    //public static final String onuCfgOnuStaticMulticastGroupsProfileIndex = "onuCfgOnuStaticMulticastGroupsProfileIndex";

    public GponOnuServiceConfigureMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgServiceSubscription, new SnmpMibBeanProperty(onuCfgServiceSubscription, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.10", ISnmpConstant.GAUGE));
        initProperty(onuCfgUpstreamTrafficMappingType, new SnmpMibBeanProperty(onuCfgUpstreamTrafficMappingType, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.6", ISnmpConstant.INTEGER));
        initProperty(onuCfgUpstreamTrafficMappingProfileIndex, new SnmpMibBeanProperty(onuCfgUpstreamTrafficMappingProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.7", ISnmpConstant.GAUGE));
        initProperty(onuCfgTcontVirtualPortBindingType, new SnmpMibBeanProperty(onuCfgTcontVirtualPortBindingType, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.8", ISnmpConstant.INTEGER));
        initProperty(onuCfgTcontVirtualPortBindingProfileIndex, new SnmpMibBeanProperty(onuCfgTcontVirtualPortBindingProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.9", ISnmpConstant.GAUGE));
        initProperty(onuCfgSecurityCapability, new SnmpMibBeanProperty(onuCfgSecurityCapability, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.25", ISnmpConstant.GAUGE));
        initProperty(onuCfgSecurityMode, new SnmpMibBeanProperty(onuCfgSecurityMode, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.26", ISnmpConstant.GAUGE));

        //initProperty(onuCfgOnuMulticastFilterMode, new SnmpMibBeanProperty(onuCfgOnuMulticastFilterMode, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.48", ISnmpConstant.INTEGER));
        //initProperty(onuCfgOnuMulticastGemPortNo, new SnmpMibBeanProperty(onuCfgOnuMulticastGemPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.49", ISnmpConstant.GAUGE));
        //initProperty(onuCfgOnuStaticMulticastGroupsProfileIndex, new SnmpMibBeanProperty(onuCfgOnuStaticMulticastGroupsProfileIndex, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.50", ISnmpConstant.GAUGE));

        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.57", ISnmpConstant.INTEGER));
    }

    public Integer getOnuCfgSlotNo() {
        return (Integer) getIndex(0);
    }

    public void setOnuCfgSlotNo(Integer aOnuCfgSlotNo) {
        setIndex(0, aOnuCfgSlotNo);
    }

    public Integer getOnuCfgPortNo() {
        return (Integer) getIndex(1);
    }

    public void setOnuCfgPortNo(Integer aOnuCfgPortNo) {
        setIndex(1, aOnuCfgPortNo);
    }

    public Integer getOnuCfgLogicalPortNo() {
        return (Integer) getIndex(2);
    }

    public void setOnuCfgLogicalPortNo(Integer aOnuCfgLogicalPortNo) {
        setIndex(2, aOnuCfgLogicalPortNo);
    }

    public Integer getOnuCfgUpstreamTrafficMappingType() {
        return (Integer) getProperty(onuCfgUpstreamTrafficMappingType).getValue();
    }

    public void setOnuCfgUpstreamTrafficMappingType(Integer aOnuCfgUpstreamTrafficMappingType) {
        getProperty(onuCfgUpstreamTrafficMappingType).setValue(aOnuCfgUpstreamTrafficMappingType);
    }

    public Long getOnuCfgUpstreamTrafficMappingProfileIndex() {
        return (Long) getProperty(onuCfgUpstreamTrafficMappingProfileIndex).getValue();
    }

    public void setOnuCfgUpstreamTrafficMappingProfileIndex(Long aOnuCfgUpstreamTrafficMappingProfileIndex) {
        getProperty(onuCfgUpstreamTrafficMappingProfileIndex).setValue(aOnuCfgUpstreamTrafficMappingProfileIndex);
    }

    public Integer getOnuCfgTcontVirtualPortBindingType() {
        return (Integer) getProperty(onuCfgTcontVirtualPortBindingType).getValue();
    }

    public void setOnuCfgTcontVirtualPortBindingType(Integer aOnuCfgTcontVirtualPortBindingType) {
        getProperty(onuCfgTcontVirtualPortBindingType).setValue(aOnuCfgTcontVirtualPortBindingType);
    }

    public Long getOnuCfgTcontVirtualPortBindingProfileIndex() {
        return (Long) getProperty(onuCfgTcontVirtualPortBindingProfileIndex).getValue();
    }

    public void setOnuCfgTcontVirtualPortBindingProfileIndex(Long aOnuCfgTcontVirtualPortBindingProfileIndex) {
        getProperty(onuCfgTcontVirtualPortBindingProfileIndex).setValue(aOnuCfgTcontVirtualPortBindingProfileIndex);
    }

    public Long getOnuCfgServiceSubscription() {
        return (Long) getProperty(onuCfgServiceSubscription).getValue();
    }

    public void setOnuCfgServiceSubscription(Long aOnuCfgServiceSubscription) {
        getProperty(onuCfgServiceSubscription).setValue(aOnuCfgServiceSubscription);
    }

    public Long getOnuCfgSecurityCapability() {
        return (Long) getProperty(onuCfgSecurityCapability).getValue();
    }

    public void setOnuCfgSecurityCapability(Long aOnuCfgSecurityCapability) {
        getProperty(onuCfgSecurityCapability).setValue(aOnuCfgSecurityCapability);
    }

    public Long getOnuCfgSecurityMode() {
        return (Long) getProperty(onuCfgSecurityMode).getValue();
    }

    public void setOnuCfgSecurityMode(Long aOnuCfgSecurityMode) {
        getProperty(onuCfgSecurityMode).setValue(aOnuCfgSecurityMode);
    }

    /*
    public Integer getOnuCfgOnuMulticastFilterMode() {
        return (Integer) getProperty(onuCfgOnuMulticastFilterMode).getValue();
    }

    public void setOnuCfgOnuMulticastFilterMode(Integer aOnuCfgOnuMulticastFilterMode) {
        getProperty(onuCfgOnuMulticastFilterMode).setValue(aOnuCfgOnuMulticastFilterMode);
    }

    public Long getOnuCfgOnuMulticastGemPortNo() {
        return (Long) getProperty(onuCfgOnuMulticastGemPortNo).getValue();
    }

    public void setOnuCfgOnuMulticastGemPortNo(Long aOnuCfgOnuMulticastGemPortNo) {
        getProperty(onuCfgOnuMulticastGemPortNo).setValue(aOnuCfgOnuMulticastGemPortNo);
    }

    public Long getOnuCfgOnuStaticMulticastGroupsProfileIndex() {
        return (Long) getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex).getValue();
    }

    public void setOnuCfgOnuStaticMulticastGroupsProfileIndex(Long aOnuCfgOnuStaticMulticastGroupsProfileIndex) {
        getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex).setValue(aOnuCfgOnuStaticMulticastGroupsProfileIndex);
    }
    */

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgServiceSubscription));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareRead(getProperty(onuCfgSecurityCapability));
        prepareRead(getProperty(onuCfgSecurityMode));

        //prepareRead(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareRead(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareRead(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgServiceSubscription));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareRead(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareRead(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareRead(getProperty(onuCfgSecurityCapability));
        prepareRead(getProperty(onuCfgSecurityMode));

        //prepareRead(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareRead(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareRead(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

        setRowsPerFetch(50);
        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(onuCfgServiceSubscription));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareSave(getProperty(onuCfgSecurityMode));

        //prepareSave(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareSave(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareSave(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

        return save();
    }

    public boolean add() throws MibBeanException {
        prepareSave(getProperty(onuCfgServiceSubscription));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingType));
        prepareSave(getProperty(onuCfgUpstreamTrafficMappingProfileIndex));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingType));
        prepareSave(getProperty(onuCfgTcontVirtualPortBindingProfileIndex));
        prepareSave(getProperty(onuCfgSecurityMode));

        //prepareSave(getProperty(onuCfgOnuMulticastFilterMode));
        //prepareSave(getProperty(onuCfgOnuMulticastGemPortNo));
        //prepareSave(getProperty(onuCfgOnuStaticMulticastGroupsProfileIndex));

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