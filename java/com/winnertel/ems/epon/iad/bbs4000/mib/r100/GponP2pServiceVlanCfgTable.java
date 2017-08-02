package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The GponOnuMulticastOperProfTable class.
 * Created by QuickDVM
 */
public class GponP2pServiceVlanCfgTable extends SnmpMibBean {
    public static final String p2pServiceVlan = "p2pServiceVlan";

    public GponP2pServiceVlanCfgTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(p2pServiceVlan, new SnmpMibBeanProperty(p2pServiceVlan, ".1.3.6.1.4.1.45121.1.3.10.5.1002.1.1.1", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.45121.1.3.10.5.1002.1.1.100", ISnmpConstant.INTEGER));
    }

    public Integer getP2pServiceVlan() {
        return (Integer) getIndex(0);
    }

    public void setP2pServiceVlan(Integer aP2pServiceVlan) {
        setIndex(0, aP2pServiceVlan);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(super.getProperty(p2pServiceVlan));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(super.getProperty(p2pServiceVlan));

        return loadAll(new int[]{1});
    }

    public boolean add() throws MibBeanException {
        super.setRowStatus(new Integer(4));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }

    public boolean delete() throws MibBeanException {
        super.setRowStatus(new Integer(6));
        prepareSave(getProperty(ROW_STATUS));
        return save();
    }
}
