package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: Rox
 * Date: 2010-7-5
 * Time: 14:43:35
 */
public class ActionValueFormatter extends SnmpFieldFormatter {

    public ActionValueFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
    	byte[] data = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
    	if(fApplication.getActiveDeviceManager().getType().toLowerCase().indexOf("onu")>=0
    			||fApplication.getActiveDeviceManager().getType().toLowerCase().indexOf("clt2168")>=0){
    		//if is onu;
    		if(data.length==0)return "";
    		if(data[0]==2){
    			//vlan
    			return ((data[3]&0xFF) << 8) | data[4]&0xff;
    		}
	        try {
	            if (data != null && data.length > 4) {
	                return ((data[3]&0xFF) << 8) | data[4];
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    	}else
    	{
	        try {
	            if (data != null && data.length > 4) {
	                return ((data[3]&0xFF) << 8) | data[4];
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    	}

        return "";
    }

}