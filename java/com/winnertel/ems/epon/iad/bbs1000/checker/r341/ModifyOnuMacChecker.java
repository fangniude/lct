package com.winnertel.ems.epon.iad.bbs1000.checker.r341;

import javax.swing.JOptionPane;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Onu2CtcTable;
//import com.winnertel.ems.epon.iad.bbs1000.mib.r330.Dot3Onu2CtcTable;
import com.winnertel.ems.epon.iad.bbs1000.mib.r341.Dot3Onu2CtcValidOnuMacTable;

public class ModifyOnuMacChecker extends BaseChecker {

	private IApplication fApplication;
	public ModifyOnuMacChecker(IApplication app) {
		super(app);
		fApplication = app;
	}

	@Override
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {

	    Dot3Onu2CtcValidOnuMacTable onuMacTable = (Dot3Onu2CtcValidOnuMacTable)selectedMibBeans[0];
	    Dot3Onu2CtcTable mbean = new Dot3Onu2CtcTable(fApplication.getSnmpProxy());
        mbean.setUtsDot3Onu2CtcModuleId(onuMacTable.getUtsDot3OnuValidOnuMacModuleId());
        mbean.setUtsDot3Onu2CtcDeviceId(1);
        mbean.setUtsDot3Onu2CtcPortId(onuMacTable.getUtsDot3OnuValidOnuMacPortId());
        mbean.setUtsDot3Onu2CtcLogicalPortId(onuMacTable.getUtsDot3OnuValidOnuMacAppLPortId());
        try {
            mbean.retrieve();

        } catch (MibBeanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(mbean.getUtsDot3Onu2SNumberValid()!=null&&mbean.getUtsDot3Onu2SNumberValid()==2)//sn valid
        {
            String msg = fApplication.getActiveDeviceManager().getGuiComposer().getString("Err_SN_Configured");
            MessageDialog.showInfoMessageDialog(fApplication, msg);
            return false;
        }
        // NMS00060620
        String warningTitle = fApplication.getActiveDeviceManager().getGuiComposer().getString("Risky Operation Prompt");
        String warningMessage = fApplication.getActiveDeviceManager().getGuiComposer().getString("CONTINUE_HINT");

        int confirmResult = JOptionPane.showConfirmDialog(fApplication.getTopMostFrame(),
        		warningMessage,
        		warningTitle,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);

		return confirmResult == JOptionPane.OK_OPTION;
	}

}
