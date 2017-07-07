package com.winnertel.ems.epon.iad.bbs4000.mgr;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

public class TftpGetbulkTable extends SnmpMibBean {
    public static final String utsTftpGetbulkId = "utsTftpGetbulkId";
    public static final String utsTftpGetbulkInstanceId = "utsTftpGetbulkInstanceId";
    public static final String utsTftpGetbulkTransactionId = "utsTftpGetbulkTransactionId";
    public static final String utsTftpGetbulkTransactionStatus = "utsTftpGetbulkTransactionStatus";

    public TftpGetbulkTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(utsTftpGetbulkTransactionId, new SnmpMibBeanProperty(utsTftpGetbulkTransactionId, ".1.3.6.1.4.1.41355.1800.2.1.1.4.8.1.3", ISnmpConstant.INTEGER));
        initProperty(utsTftpGetbulkTransactionStatus, new SnmpMibBeanProperty(utsTftpGetbulkTransactionStatus, ".1.3.6.1.4.1.41355.1800.2.1.1.4.8.1.4", ISnmpConstant.INTEGER));
        initProperty(ROW_STATUS, new SnmpMibBeanProperty(ROW_STATUS, ".1.3.6.1.4.1.41355.1800.2.1.1.4.8.1.100", ISnmpConstant.INTEGER));
    }

    public Integer getUtsTftpGetbulkId() {
        return (Integer) getIndex(0);
    }

    public void setUtsTftpGetbulkId(Integer aUtsTftpGetbulkId) {
        setIndex(0, aUtsTftpGetbulkId);
    }

    public Integer getUtsTftpGetbulkInstanceId() {
        return (Integer) getIndex(1);
    }

    public void setUtsTftpGetbulkInstanceId(Integer aUtsTftpGetbulkInstanceId) {
        setIndex(1, aUtsTftpGetbulkInstanceId);
    }

    public Integer getUtsTftpGetbulkTransactionId() {
        return (Integer) getProperty(utsTftpGetbulkTransactionId).getValue();
    }

    public void setUtsTftpGetbulkTransactionId(Integer aUtsTftpGetbulkTransactionId) {
        getProperty(utsTftpGetbulkTransactionId).setValue(aUtsTftpGetbulkTransactionId);
    }

    public Integer getUtsTftpGetbulkTransactionStatus() {
        return (Integer) getProperty(utsTftpGetbulkTransactionStatus).getValue();
    }

    public void setUtsTftpGetbulkTransactionStatus(Integer aUtsTftpGetbulkTransactionStatus2) {
        getProperty(utsTftpGetbulkTransactionStatus).setValue(aUtsTftpGetbulkTransactionStatus2);
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(utsTftpGetbulkTransactionId));
        prepareRead(getProperty(utsTftpGetbulkTransactionStatus));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(utsTftpGetbulkTransactionId));
        prepareRead(getProperty(utsTftpGetbulkTransactionStatus));

        return loadAll(new int[]{1});
    }

    public boolean add() throws MibBeanException {
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
