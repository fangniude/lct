package com.winnertel.ems.epon.iad.bbs1000.checker.r341;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Olt2PonProtectionMBean;

public class AddPonProtectionChecker extends BaseChecker {
    IApplication fApplication;

    public AddPonProtectionChecker(IApplication app) {
        super(app);
        this.fApplication = app;
    }

    public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans) {
    	Set<String> port1 = new HashSet<String>();
    	Set<String> port2 = new HashSet<String>();

    	BBS1000CardMibBean cardMBean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector cardList = BeanService.refreshTableBean(fApplication, cardMBean);
        ModuleType moduleType = new ModuleType();

        for(int i = 0; cardList!=null && i < cardList.size(); i++) {
        	BBS1000CardMibBean card = (BBS1000CardMibBean) cardList.get(i);
            if(moduleType.isLTMModule(card.getUtsEponModuleBoardType())) {
                for(int j = 1; j <= 4; j++) {
                	port1.add(card.getUtsEponModuleBoardPhyId() + "/" + j);
                	port2.add(card.getUtsEponModuleBoardPhyId() + "/" + j);
                }
            }
        }

        Dot3Olt2PonProtectionMBean allMbean = new Dot3Olt2PonProtectionMBean(fApplication.getSnmpProxy());

        Vector v = BeanService.refreshTableBean(fApplication, allMbean);
        for(int i = 0; i < v.size(); i++) {
        	port1.remove(((Dot3Olt2PonProtectionMBean) v.get(i)).getUtsPonTrunckProtectionPort1Interface());
        	port1.remove(((Dot3Olt2PonProtectionMBean) v.get(i)).getUtsPonTrunckProtectionPort2Interface());
        	port2.remove(((Dot3Olt2PonProtectionMBean) v.get(i)).getUtsPonTrunckProtectionPort1Interface());
        	port2.remove(((Dot3Olt2PonProtectionMBean) v.get(i)).getUtsPonTrunckProtectionPort2Interface());
        }
        
        if(port1.isEmpty() || port2.isEmpty() || port1.size()==1 && port2.size()==1 && port1.toString().equals(port2.toString())){
        	MessageDialog.showInfoMessageDialog(fApplication, fApplication.getActiveDeviceManager().getGuiComposer().getString("Info_PonTrunkProtection_NoAvailablePort"));
        	return false;
        }

        return true;
    }
}
