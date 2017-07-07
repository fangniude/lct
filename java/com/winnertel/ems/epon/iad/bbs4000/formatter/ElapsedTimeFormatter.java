/*
 * @(#)ElapsedTimeFormatter.java
 * Created on 2006-10-20, ����10:44:09
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * TODO: add function declaration here
 *
 * @version 1.0.0, 2006-10-20
 * @author  ZhouTao(zhoutao@utstar.com)
 */
public class ElapsedTimeFormatter extends SnmpFieldFormatter {
    public ElapsedTimeFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {

        Integer value = (Integer) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
        if (value == null || value.intValue() == 0 ) {
        	return "N/A";
        }
        
        return value.toString();
    }
} // ElapsedTimeFormatter