/**
 * Created by Zhou Chao, 2009/2/12
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuServiceConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUPCUTMProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUPUTMProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanIdUpTrafficMapProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanIdVlanPriBitUpTrafficMapProfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanPriBitsUpTrafficMapProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class UpstreamTrafficMappingProfileIndexFormatter extends SnmpFieldFormatter {

    public UpstreamTrafficMappingProfileIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        if (aMibBean instanceof GponOnuServiceConfigureMBean) {
            GponOnuServiceConfigureMBean mbean = (GponOnuServiceConfigureMBean) aMibBean;
            int upstreamTrafficMappingType = (mbean.getOnuCfgUpstreamTrafficMappingType() != null) ? mbean.getOnuCfgUpstreamTrafficMappingType() : 0;
            return getUpstreamTrafficMappingProfileName(upstreamTrafficMappingType, mbean.getOnuCfgUpstreamTrafficMappingProfileIndex());
        }

        return "";
    }

    private String getUpstreamTrafficMappingProfileName(int type, long index) {
		String name = String.valueOf(index);

		if (type == 1) {        //
        // Upstream Traffic Mapping Profile Table
        //   upstreamTrafficMappingType
        //     1: ONU User Port (table: OnuUPUTMProfTable_Panel, panel: )
        //     2: ONU VLAN ID (table: , panel: OnuVlanIdUpTrafficMapProfTable_Panel)
        //     3: ONU VLAN Priority Bits (table: , panel: OnuVlanPriBitsUpTrafficMapProfTable_Panel)
        //     4: ONU VLAN ID and VLAN Priority Bits (table: , panel: OnuVlanIdVlanPriBitUpTrafficMapProfTable_Panel)
        //     5, 6: (reserved) ()
        //     7, 8: ONU User Port and CoS (table: OnuUPCUTMProfTable_Panel, panel: )
        //

    		OnuUPUTMProfTable bean = new OnuUPUTMProfTable(fApplication.getSnmpProxy());
    		bean.setOnuUsrPortUpTrafficMapProfIndex1(index);
    		bean.setOnuUsrPortUpTrafficMapProfIndex2(0L);
    		try {
    			bean.retrieve();
                name = bean.getOnuUsrPortUpTrafficMapProfileName() != null ? bean.getOnuUsrPortUpTrafficMapProfileName() : String.valueOf(index);
    		} catch (MibBeanException e) {
    		}
        } else if (type == 2) {
        	OnuVlanIdUpTrafficMapProfTable bean = new OnuVlanIdUpTrafficMapProfTable(fApplication.getSnmpProxy());
            bean.setOnuVlanIdUpTrafficMapProfIndex1(index);
            bean.setOnuVlanIdUpTrafficMapProfIndex2(0L);

    		try {
    			bean.retrieve();
                name = bean.getOnuVlanIdUpTrafficMapProfileName() != null ? bean.getOnuVlanIdUpTrafficMapProfileName() : String.valueOf(index);
    		} catch (MibBeanException e) {
    		}
        } else if (type == 3) {
        	OnuVlanPriBitsUpTrafficMapProfTable bean = new OnuVlanPriBitsUpTrafficMapProfTable(fApplication.getSnmpProxy());
            bean.setOnuVlanPriBitsUpTrafficMapProfIndex1(index);
            bean.setOnuVlanPriBitsUpTrafficMapProfIndex2(0L);

    		try {
    			bean.retrieve();
                name = bean.getOnuVlanPriBitsUpTrafficMapProfileName() != null ? bean.getOnuVlanPriBitsUpTrafficMapProfileName() : String.valueOf(index);
    		} catch (MibBeanException e) {
    		}
        } else if (type == 4) {
        	OnuVlanIdVlanPriBitUpTrafficMapProfTable bean = new OnuVlanIdVlanPriBitUpTrafficMapProfTable(fApplication.getSnmpProxy());
            bean.setOnuVlanIdVlanPriBitUpTrafficMapProfIndex1(index);
            bean.setOnuVlanIdVlanPriBitUpTrafficMapProfIndex2(0L);

    		try {
    			bean.retrieve();
                name = bean.getOnuVlanIdVlanPriBitUpTrafficMapProfileName() != null ? bean.getOnuVlanIdVlanPriBitUpTrafficMapProfileName() : String.valueOf(index);
    		} catch (MibBeanException e) {
    		}
        } else if (type == 7 || type == 8) {
        	OnuUPCUTMProfTable bean = new OnuUPCUTMProfTable(fApplication.getSnmpProxy());
            bean.setOnuUsrPortCoSUpTrafficMapProfIndex1(index);
            bean.setOnuUsrPortCoSUpTrafficMapProfIndex2(0L);

    		try {
    			bean.retrieve();
                name = bean.getOnuUsrPortCoSUpTrafficMapProfileName() != null ? bean.getOnuUsrPortCoSUpTrafficMapProfileName() : String.valueOf(index);
    		} catch (MibBeanException e) {
    		}
        }

		return name;
    }

}