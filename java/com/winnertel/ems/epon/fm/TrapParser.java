package com.winnertel.ems.epon.fm;

import com.winnertel.snmp.snmp2.SnmpPDU;

public interface TrapParser {
    public void parse(SnmpPDU pdu);
}
