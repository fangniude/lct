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

public class GponOnuImageInfoMBean extends SnmpMibBean {

    public static final String onuCfgSlotNo = "onuCfgSlotNo";
    public static final String onuCfgPortNo = "onuCfgPortNo";
    public static final String onuCfgLogicalPortNo = "onuCfgLogicalPortNo";
    public static final String onuCfgOnuImageInstance0Version = "onuCfgOnuImageInstance0Version";
    public static final String onuCfgOnuImageInstance0Valid = "onuCfgOnuImageInstance0Valid";
    public static final String onuCfgOnuImageInstance0Activate = "onuCfgOnuImageInstance0Activate";
    public static final String onuCfgOnuImageInstance0Commit = "onuCfgOnuImageInstance0Commit";
    public static final String onuCfgOnuImageInstance1Version = "onuCfgOnuImageInstance1Version";
    public static final String onuCfgOnuImageInstance1Valid = "onuCfgOnuImageInstance1Valid";
    public static final String onuCfgOnuImageInstance1Activate = "onuCfgOnuImageInstance1Activate";
    public static final String onuCfgOnuImageInstance1Commit = "onuCfgOnuImageInstance1Commit";

    public GponOnuImageInfoMBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(onuCfgSlotNo, new SnmpMibBeanProperty(onuCfgSlotNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.1", ISnmpConstant.INTEGER));
        initProperty(onuCfgPortNo, new SnmpMibBeanProperty(onuCfgPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.2", ISnmpConstant.INTEGER));
        initProperty(onuCfgLogicalPortNo, new SnmpMibBeanProperty(onuCfgLogicalPortNo, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.3", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Version, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Version, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.34", ISnmpConstant.STRING));
        initProperty(onuCfgOnuImageInstance0Valid, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Valid, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.35", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Activate, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Activate, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.36", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance0Commit, new SnmpMibBeanProperty(onuCfgOnuImageInstance0Commit, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.37", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Version, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Version, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.38", ISnmpConstant.STRING));
        initProperty(onuCfgOnuImageInstance1Valid, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Valid, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.39", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Activate, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Activate, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.40", ISnmpConstant.INTEGER));
        initProperty(onuCfgOnuImageInstance1Commit, new SnmpMibBeanProperty(onuCfgOnuImageInstance1Commit, ".1.3.6.1.4.1.41355.1.3.10.5.1.5.1.41", ISnmpConstant.INTEGER));

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

    public String getOnuCfgOnuImageInstance0Version() {
        return ((String) getProperty(onuCfgOnuImageInstance0Version).getValue()).trim();
    }

    public void setOnuCfgOnuImageInstance0Version(String aOnuCfgOnuImageInstance0Version) {
        getProperty(onuCfgOnuImageInstance0Version).setValue(aOnuCfgOnuImageInstance0Version);
    }

    public Integer getOnuCfgOnuImageInstance0Valid() {
        return (Integer) getProperty(onuCfgOnuImageInstance0Valid).getValue();
    }

    public void setOnuCfgOnuImageInstance0Valid(Integer aOnuCfgOnuImageInstance0Valid) {
        getProperty(onuCfgOnuImageInstance0Valid).setValue(aOnuCfgOnuImageInstance0Valid);
    }

    public Integer getOnuCfgOnuImageInstance0Activate() {
        return (Integer) getProperty(onuCfgOnuImageInstance0Activate).getValue();
    }

    public void setOnuCfgOnuImageInstance0Activate(Integer aOnuCfgOnuImageInstance0Activate) {
        getProperty(onuCfgOnuImageInstance0Activate).setValue(aOnuCfgOnuImageInstance0Activate);
    }

    public Integer getOnuCfgOnuImageInstance0Commit() {
        return (Integer) getProperty(onuCfgOnuImageInstance0Commit).getValue();
    }

    public void setOnuCfgOnuImageInstance0Commit(Integer aOnuCfgOnuImageInstance0Commit) {
        getProperty(onuCfgOnuImageInstance0Commit).setValue(aOnuCfgOnuImageInstance0Commit);
    }

    public String getOnuCfgOnuImageInstance1Version() {
        return ((String) getProperty(onuCfgOnuImageInstance1Version).getValue()).trim();
    }

    public void setOnuCfgOnuImageInstance1Version(String aOnuCfgOnuImageInstance1Version) {
        getProperty(onuCfgOnuImageInstance1Version).setValue(aOnuCfgOnuImageInstance1Version);
    }

    public Integer getOnuCfgOnuImageInstance1Valid() {
        return (Integer) getProperty(onuCfgOnuImageInstance1Valid).getValue();
    }

    public void setOnuCfgOnuImageInstance1Valid(Integer aOnuCfgOnuImageInstance1Valid) {
        getProperty(onuCfgOnuImageInstance1Valid).setValue(aOnuCfgOnuImageInstance1Valid);
    }

    public Integer getOnuCfgOnuImageInstance1Activate() {
        return (Integer) getProperty(onuCfgOnuImageInstance1Activate).getValue();
    }

    public void setOnuCfgOnuImageInstance1Activate(Integer aOnuCfgOnuImageInstance1Activate) {
        getProperty(onuCfgOnuImageInstance1Activate).setValue(aOnuCfgOnuImageInstance1Activate);
    }

    public Integer getOnuCfgOnuImageInstance1Commit() {
        return (Integer) getProperty(onuCfgOnuImageInstance1Commit).getValue();
    }

    public void setOnuCfgOnuImageInstance1Commit(Integer aOnuCfgOnuImageInstance1Commit) {
        getProperty(onuCfgOnuImageInstance1Commit).setValue(aOnuCfgOnuImageInstance1Commit);
    }

    public String getCurrentVersion() {
        //active and valid
        if(getOnuCfgOnuImageInstance0Activate() == 1 && getOnuCfgOnuImageInstance0Valid() == 1) {
            return getOnuCfgOnuImageInstance0Version();
        } else if(getOnuCfgOnuImageInstance1Activate() == 1 && getOnuCfgOnuImageInstance1Valid() == 1) {
            return getOnuCfgOnuImageInstance1Version();
        }
        
        return "invalid";
    }

    public void setCurrentVersion(String ver) {
        
    }

    public String getCurrentInstance() {
        //active
        if(getOnuCfgOnuImageInstance0Activate() == 1) {
            return "imageinstance0";
        } else if(getOnuCfgOnuImageInstance1Activate() == 1) {
            return "imageinstance1";
        }

        return "invalid";
    }

    public void setCurrentInstance(String instance) {

    }

    public String getBootVersion() {
        //commit
        if(getOnuCfgOnuImageInstance0Commit() == 1) {
            return getOnuCfgOnuImageInstance0Version();
        } else if(getOnuCfgOnuImageInstance1Commit() == 1) {
            return getOnuCfgOnuImageInstance1Version();
        }

        return "invalid";
    }

    public void setBootVersion(String ver) {
        
    }

    public String getBootInstance() {
        //commit
        if(getOnuCfgOnuImageInstance0Commit() == 1) {
            return "imageinstance0";
        } else if(getOnuCfgOnuImageInstance1Commit() == 1) {
            return "imageinstance1";
        }

        return "invalid";
    }

    public void setBootInstance(String instance) {

    }
    
    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(onuCfgOnuImageInstance0Version));
        prepareRead(getProperty(onuCfgOnuImageInstance0Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance0Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance0Commit));
        prepareRead(getProperty(onuCfgOnuImageInstance1Version));
        prepareRead(getProperty(onuCfgOnuImageInstance1Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance1Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance1Commit));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(onuCfgOnuImageInstance0Version));
        prepareRead(getProperty(onuCfgOnuImageInstance0Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance0Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance0Commit));
        prepareRead(getProperty(onuCfgOnuImageInstance1Version));
        prepareRead(getProperty(onuCfgOnuImageInstance1Valid));
        prepareRead(getProperty(onuCfgOnuImageInstance1Activate));
        prepareRead(getProperty(onuCfgOnuImageInstance1Commit));

        setRowsPerFetch(50);
        return loadAll(new int[]{1, 1, 1});
    }

}