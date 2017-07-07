/*
 * @(#)RTTFormatter.java
 * Created on 2006-10-23, ����10:48:20
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3OnuRTT;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * TODO: add function declaration here
 *
 * @version 1.0.0, 2006-10-23
 * @author  ZhouTao(zhoutao@utstar.com)
 */
public class RTTFormatter extends SnmpFieldFormatter {
    public RTTFormatter(IApplication anApplication) {
        super(anApplication);
    }
    
    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {

    	Dot3OnuRTT onuRTTMBean = (Dot3OnuRTT)aMibBean;

    	Integer regState = onuRTTMBean.getUtsDot3OnuRegistrationState();
    	Integer rttValue = onuRTTMBean.getUtsDot3OnuRTT();

    	if ( regState.intValue() == 3 ) {
    		if ( rttValue.intValue() > 0 ) {
    			return String.valueOf( (int)(rttValue.intValue() * 3.2) );
    		} else if ( rttValue.intValue() == 0 ) {
    			return "<3.2";
    		}
    	}

    	return "N/A";
    }
}
