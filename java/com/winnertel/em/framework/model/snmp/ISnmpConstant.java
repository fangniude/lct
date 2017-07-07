package com.winnertel.em.framework.model.snmp;

public interface ISnmpConstant {
    public static byte SNMP_GET = com.winnertel.snmp.beans.SnmpTarget.SNMPGET;
    public static byte SNMP_GET_BULK = com.winnertel.snmp.beans.SnmpTarget.SNMPGETBULK;
    public static byte SNMP_GET_NEXT = com.winnertel.snmp.beans.SnmpTarget.SNMPGETNEXT;
    public static byte SNMP_SET = com.winnertel.snmp.beans.SnmpTarget.SNMPSET;
    public static byte SNMP_TRAP = com.winnertel.snmp.beans.SnmpTarget.SNMPTRAP;
    public static byte SNMP_TRAP_V2 = com.winnertel.snmp.beans.SnmpTarget.SNMPV2TRAP;

    public static int VERSION1 = com.winnertel.snmp.beans.SnmpTarget.VERSION1;
    public static int VERSION2C = com.winnertel.snmp.beans.SnmpTarget.VERSION2C;
    public static int VERSION3 = com.winnertel.snmp.beans.SnmpTarget.VERSION3;

    public static byte INTEGER = com.winnertel.snmp.snmp2.DefaultSnmpAPI.INTEGER;
    public static byte STRING = com.winnertel.snmp.snmp2.DefaultSnmpAPI.STRING;
    public static byte IP_ADDRESS = com.winnertel.snmp.snmp2.DefaultSnmpAPI.IPADDRESS;
    public static byte MAC_ADDRESS = 100;
    public static byte OCTETS = 101;
    public static byte COUNTER = com.winnertel.snmp.snmp2.DefaultSnmpAPI.COUNTER;
    public static byte COUNTER64 = com.winnertel.snmp.snmp2.DefaultSnmpAPI.COUNTER64;
    public static byte GAUGE = com.winnertel.snmp.snmp2.DefaultSnmpAPI.GAUGE;
    public static byte TIME_TICKS = com.winnertel.snmp.snmp2.DefaultSnmpAPI.TIMETICKS;
    public static byte OBJID = com.winnertel.snmp.snmp2.DefaultSnmpAPI.OBJID;

    public static byte GETBULK_REQ_MSG = com.winnertel.snmp.snmp2.DefaultSnmpAPI.GETBULK_REQ_MSG;
    public static byte GETNEXT_REQ_MSG = com.winnertel.snmp.snmp2.DefaultSnmpAPI.GETNEXT_REQ_MSG;
    public static byte GET_REQ_MSG = com.winnertel.snmp.snmp2.DefaultSnmpAPI.GET_REQ_MSG;
    public static byte SET_REQ_MSG = com.winnertel.snmp.snmp2.DefaultSnmpAPI.SET_REQ_MSG;

    public static final int SNMP_ERR_GENERR = com.winnertel.snmp.beans.SnmpErrorMessages.SNMP_ERR_GENERR;

    public static final byte ENDOFMIBVIEW = com.winnertel.snmp.snmp2.DefaultSnmpAPI.ENDOFMIBVIEWEXP;
    public static final int ENDOFMIBVIEWEXP = com.winnertel.snmp.beans.SnmpErrorMessages.ENDOFMIBVIEWEXP;
}
