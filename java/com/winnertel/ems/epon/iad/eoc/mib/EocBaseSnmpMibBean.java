package com.winnertel.ems.epon.iad.eoc.mib;

import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-5-25
 * Time: 14:02:54
 * To change this template use File | Settings | File Templates.
 */
public class EocBaseSnmpMibBean extends SnmpMibBean {
    public EocBaseSnmpMibBean(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
    }

    //public String MIB_Head1 = ".1.3.6.1.4.1.22764.3.1";   //.1.3.6.1.4.1.17409.2.4;          
    public String MIB_Head1 = ".1.3.6.1.4.1.17409.2.4";
    public String MIB_Head2 = ".1.3.6.1.4.1.22764.1";   //.1.3.6.1.4.1.17409.2.1;
    public String MIB_Head3 = ".1.3.6.1.4.1.22764.2";   //.1.3.6.1.4.1.17409.2.2;


    protected void init() {
        //nothing
    }

}
