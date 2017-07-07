package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 2010-8-9
 * Time: 18:06:16
 * To change this template use File | Settings | File Templates.
 */
public class ModEoCRealTimeStatisticSubTable extends SnmpMibBean {
    public static final String modEoCRealTimeStatisticCBATCardIndex = "modEoCRealTimeStatisticCBATCardIndex";
    public static final String modEoCRealTimeStatisticCNUIndex = "modEoCRealTimeStatisticCNUIndex";
    public static final String modEoCRealTimeStatisticTxByte = "modEoCRealTimeStatisticTxByte";
    public static final String modEoCRealTimeStatisticRxByte = "modEoCRealTimeStatisticRxByte";
    public static final String modEoCRealTimeStatisticTxPkt = "modEoCRealTimeStatisticTxPkt";
    public static final String modEoCRealTimeStatisticRxPkt = "modEoCRealTimeStatisticRxPkt";
    public static final String modEoCRealTimeStatisticTxBcast = "modEoCRealTimeStatisticTxBcast";
    public static final String modEoCRealTimeStatisticRxBcast = "modEoCRealTimeStatisticRxBcast";
    public static final String modEoCRealTimeStatisticTxMcast = "modEoCRealTimeStatisticTxMcast";
    public static final String modEoCRealTimeStatisticRxMcast = "modEoCRealTimeStatisticRxMcast";
    public static final String modEoCRealTimeStatisticRxCrc = "modEoCRealTimeStatisticRxCrc";
    public static final String modEoCRealTimeStatisticTxShort = "modEoCRealTimeStatisticTxShort";
    public static final String modEoCRealTimeStatisticRxShort = "modEoCRealTimeStatisticRxShort";
    public static final String modEoCRealTimeStatisticTxDropped = "modEoCRealTimeStatisticTxDropped";
    public static final String modEoCRealTimeStatisticRxDropped = "modEoCRealTimeStatisticRxDropped";
    public static final String modEoCRealTimeStatisticAveragePreFEC = "modEoCRealTimeStatisticAveragePreFEC";
    public static final String modEoCRealTimeStatisticReset = "modEoCRealTimeStatisticReset";

    public ModEoCRealTimeStatisticSubTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {

    }
}
