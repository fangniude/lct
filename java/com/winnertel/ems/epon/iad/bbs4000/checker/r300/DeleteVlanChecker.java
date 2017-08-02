/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.checker.r300;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.SuperVlanInterface;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.HostRouteTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.PortBasedVLAN;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.snmp.snmp2.DefaultSnmpException;

import java.util.Vector;

public class DeleteVlanChecker extends BaseChecker {

    private IApplication fApplication;

    public DeleteVlanChecker(IApplication app) {
        super(app);
        fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
        PortBasedVLAN mbean = (PortBasedVLAN) selectedMibBeans[0];

        String errMsg = checkVlanID(mbean);
        if (errMsg != null) {
            MessageDialog.showInfoMessageDialog(fApplication, errMsg);
            return false;
        }

        errMsg = checkDeleteVlanID(mbean);
        if (errMsg != null) {
            MessageDialog.showInfoMessageDialog(fApplication, errMsg);
            return false;
        }

        return true;
    }

    private String checkVlanID(PortBasedVLAN mbean) {
        String errMsg = null;
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
        int id = mbean.getUtsLagExtDot1qVlanIndex().intValue();

//        if (1006 <= id && id <= 1133) {
//            return "VLAN " + id + composer.getString("Err_Forbid_Delete_Reserved_VLAN");
//        }

        try {
/**
            String[] oids = new String[]{".1.3.6.1.4.1.45121.1800.2.1.1.4.1.14.0"};
            Object[] rowData = fApplication.getSnmpProxy().loadRow(oids);

            int mode = 0;
            if (rowData != null && rowData.length != 0 && rowData[0] != null) {
                mode = Integer.parseInt(rowData[0].toString().trim());
            }

            if (mode == 2) { //unique-tag-handling-mode
*/
        	String[] oids = new String[]{".1.3.6.1.4.1.45121.1800.2.1.1.2.1.0"};
                Object[] value = fApplication.getSnmpProxy().loadRow(oids);
                if (value != null && value.length != 0 && value[0] != null) {
                    int onuVlanBaseID = Integer.parseInt(value[0].toString().trim());
                    if (onuVlanBaseID <= id && id <= onuVlanBaseID + 19) {
                        return "VLAN " + id + composer.getString("Err_Forbid_Delete_ONU_VLAN") + onuVlanBaseID + "," + (onuVlanBaseID + 19) + ").";
                    }
                }
//            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (DefaultSnmpException e) {
            e.printStackTrace();
        }

        return errMsg;
    }

    private String checkDeleteVlanID(PortBasedVLAN mbean) {
        String errMsg = null;
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();

        int id = mbean.getUtsLagExtDot1qVlanIndex().intValue();
        if (id == 1) {
            return "VLAN " + id + composer.getString("Err_Forbid_Delete_Default_VLAN");
        }

        try {
            EthIfExtTable ifExtMBean = new EthIfExtTable(fApplication.getSnmpProxy());
            Vector ifExtVec = ifExtMBean.retrieveRealAll();

            for (int i = 0; i < ifExtVec.size(); i++) {
                EthIfExtTable tmpL2PortTbl = (EthIfExtTable) ifExtVec.elementAt(i);
                int tmpVlanID = tmpL2PortTbl.getUtsEthIfExtVlanId().intValue();
                int tmpPortType = tmpL2PortTbl.getUtsEthIfExtPortType().intValue();
                int tmpSwitchMode = tmpL2PortTbl.getUtsEthIfExtSwitchMode().intValue();

                if (tmpVlanID == id && (tmpPortType == 4 || tmpPortType == 5) && tmpSwitchMode == 2) {
                    return composer.getString("Err_Forbid_Delete_Layer3_VLAN_1") + id + composer.getString("Err_Forbid_Delete_Layer3_VLAN_2");
                }
            }
        } catch (MibBeanException e1) {
            e1.printStackTrace();
        }

        SuperVlanInterface[] superVlan = SuperVlanInterface.getSuperVlanInterface(fApplication.getSnmpProxy());
        for (int i = 0; i < superVlan.length; i++) {
            int[] array = ConfigUtility.VlanMappingToVlanArray(superVlan[i].getVlanMember());
            for (int j = 0; j < array.length; j++) {
                if (id == array[j]) {
                    return composer.getString("Err_Forbid_Delete_Super_SVI_1") + id + composer.getString("Err_Forbid_Delete_Super_SVI_2");
                }
            }
        }

        HostRouteTable host = new HostRouteTable(fApplication.getSnmpProxy());
        try {
            Vector hostVec = host.retrieveAll();
            if (hostVec != null) {
                for (int i = 0; i < hostVec.size(); i++) {
                    HostRouteTable record = (HostRouteTable) hostVec.get(i);

                    if (id == record.getUtsHostRouteVlanId().intValue()) {
                        return "VLAN " + id + composer.getString("Err_Forbid_Delete_VLAN_In_Host_Or_ARP");
                    }
                }
            }
        } catch (MibBeanException e) {
            e.printStackTrace();
        }

        return errMsg;
    }

}