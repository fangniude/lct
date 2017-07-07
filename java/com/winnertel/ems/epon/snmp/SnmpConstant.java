package com.winnertel.ems.epon.snmp;

import com.winnertel.snmp.beans.SnmpTarget;
import com.winnertel.snmp.snmp2.*;

public class SnmpConstant {
	public static String READ_COMMUNITY = "public";
	public static String WRITE_COMMUNITY = "private";
	public static int PORT = 161;
	public static int VERSION = SnmpTarget.VERSION2C;
	public static int TIMEOUT = 6;
	public static int RETRIES = 1;

	public static final int ACTIVE = 1;
    public static final int NOT_IN_SERVICE = 2;
    public static final int NOT_READY = 3;
    public static final int CREATE_AND_GO = 4;
    public static final int CREATE_AND_WAIT = 5;
    public static final int DESTROY = 6;
    
    // SNMP version constants
    public static int VERSION1 = SnmpTarget.VERSION1;
	public static int VERSION2C = SnmpTarget.VERSION2C;
	public static int VERSION3 = SnmpTarget.VERSION3;

    // define constant for SnmpVar subclass types.
    public static final int INTEGER = 101;
    public static final int IP_ADDRESS = 102;
    public static final int COUNTER = 103;
    public static final int GAUGE = 104;
    public static final int TIME_TICKS = 105;
    public static final int STRING = 106;
    public static final int MAC_ADDRESS = 107;
    public static final int OCTET_STRING = 108;
    public static final int OBJECT_ID = 109;
    
    public static SnmpVar createSnmpVar(Object value, int type ) {
        SnmpVar result = null;
        
        switch (type) {
            case SnmpConstant.INTEGER:
            	if (value instanceof Integer){
            		result = new SnmpInt(((Integer) value).intValue());
            	} else if (value instanceof String) {
            		result = new SnmpInt(Integer.parseInt((String) value));
            	}
                break;                
            case SnmpConstant.IP_ADDRESS:
                if (value instanceof byte[]) {
                    result = new SnmpIpAddress((byte[]) value);
                } else if (value instanceof String) {
                    result = new SnmpIpAddress((String) value);
                } 
                break;
            case SnmpConstant.COUNTER:
            	if (value instanceof Long){
            		result = new SnmpCounter(((Long) value).longValue());
            	} else if (value instanceof String) {
            		result = new SnmpCounter(Long.parseLong((String) value));
            	} 
                break;
            case SnmpConstant.GAUGE:
            	if (value instanceof Long){
            		result = new SnmpGauge(((Long) value).longValue());
            	} else if (value instanceof String) {
            		result = new SnmpGauge(Long.parseLong((String) value));
            	} 
                break;
            case SnmpConstant.TIME_TICKS:
            	if (value instanceof Long){
            		result = new SnmpTimeticks(((Long) value).longValue());
            	} else if (value instanceof String) {
            		result = new SnmpTimeticks(Long.parseLong((String) value));
            	}
                break;
            case SnmpConstant.STRING:
                if (value == null) {
                	result = new SnmpString("");
                } else if (value instanceof String) {
                	result = new SnmpString((String) value);
                }
                break;
            case SnmpConstant.MAC_ADDRESS:
            	if (value instanceof byte[]) {
                    result = new SnmpString((byte[]) value);
                } else if (value instanceof String) {
                    result = new SnmpString((String) value);
                } 
                break;
            case SnmpConstant.OCTET_STRING:
            	if (value instanceof byte[]) {
                    result = new SnmpString((byte[]) value);
                } else if (value instanceof String) {
                    result = new SnmpString((String) value);
                }
                break;
            case SnmpConstant.OBJECT_ID:
            	if (value instanceof int[]) {
                    result = new SnmpOID((int[]) value);
                } else if (value instanceof String) {
                    result = new SnmpOID((String) value);
                }
                break;
        }
 
        return result;
    }
}
