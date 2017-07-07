package com.winnertel.ems.epon.iad.bbs4000.model;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.PonSysMaxOpticalSplitterRatio;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.BeanService;

import java.util.Vector;

public class BBS4000NE {

    private IApplication fApplication;

    public BBS4000NE(IApplication application) {
        this.fApplication = application;
    }

    public Vector getEPMCardList() {
        Vector v = new Vector();

        ModuleType moduleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector cardList = bean.retrieveAll();
        for (int i = 0; cardList != null && i < cardList.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) cardList.get(i);
            if (moduleType.isEPMModule(card.getUtsEponModuleBoardType().intValue())) {
                v.add("" + card.getUtsEponModuleBoardPhyId());
            }
        }

        return v;
    }

    public Vector getEPMCardListInBackground() {
        Vector v = new Vector();

        ModuleType moduleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector cardList = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; cardList != null && i < cardList.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) cardList.get(i);
            if (moduleType.isEPMModule(card.getUtsEponModuleBoardType().intValue())) {
                v.add("" + card.getUtsEponModuleBoardPhyId());
            }
        }

        return v;
    }

    public int getPonSplitRatio() {
        int split = 32;

        String ver = null;
        if (fApplication != null && fApplication.getActiveDeviceManager() != null)
            ver = fApplication.getActiveDeviceManager().getVersion();
        if (ver != null) {
            PonSysMaxOpticalSplitterRatio bean = new PonSysMaxOpticalSplitterRatio(fApplication.getSnmpProxy());
            BeanService.refreshBean(fApplication, bean);
            Integer utsPonSysMaxOpticalSplitterRatio = bean.getUtsPonSysMaxOpticalSplitterRatio();
            if (utsPonSysMaxOpticalSplitterRatio != null) {// has split in MIB
                split = utsPonSysMaxOpticalSplitterRatio;
            } else {// has not in MIB, here is some version need to set
                if (ver.startsWith("2.1.")) {
                    split = 64;
                } else if (ver.startsWith("3.1")) {
                } else if (ver.startsWith("3.")) { // added by Zhou Chao, 2008/8/4
                    split = 64;
                } else if (ver.startsWith("1.")) { // added by Zhou Chao, 2009/1/6
                    split = 64;
                } else if (ver.startsWith("2.2")) {
                    split = 40;
                }
            }
        }

        return split;
    }

    /**
     * return the port number on one module.
     *
     * @return
     */
    public int getPortCount() {
//        int count = 4;

//        String ver = null;
//        if (fApplication != null && fApplication.getActiveDeviceManager() != null)
//            ver = fApplication.getActiveDeviceManager().getVersion();
//
//        // BBS4000 v1.0(GPON) only supports 2 ports in GPM module.
//        if (ver != null && ver.equals("1.0.0")) {
//            count = 2;
//        }

        return 4;
    }

}