package com.winnertel.ems.epon.iad.bbs1000.model;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;

import java.util.Vector;

public class BBS1000NE {

    private IApplication fApplication;

    public BBS1000NE(IApplication application) {
        this.fApplication = application;
    }

    public Vector getEPMCardList() {
        Vector v = new Vector();

        BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector cardList = bean.retrieveAll();
        for (int i = 0; cardList != null && i < cardList.size(); i++) {
            BBS1000CardMibBean card = (BBS1000CardMibBean) cardList.get(i);
            if (card.getUtsEponModuleBoardPhyId() < 3 && card.getUtsEponModuleBoardState() == 3) {
                v.add("" + card.getUtsEponModuleBoardPhyId());
            }
        }

        return v;
    }

    public Vector getEPMCardListInBackground() {
        Vector v = new Vector();

        BBS1000CardMibBean bean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector cardList = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; cardList != null && i < cardList.size(); i++) {
            BBS1000CardMibBean card = (BBS1000CardMibBean) cardList.get(i);
            if (card.getUtsEponModuleBoardPhyId() < 3 && card.getUtsEponModuleBoardState() == 3) {
                v.add("" + card.getUtsEponModuleBoardPhyId());
            }
        }

        return v;
    }

    public int getPonSplitRatio() {
        int split = 64;

        String ver = fApplication.getActiveDeviceManager().getVersion();
        if (ver != null && (ver.startsWith("2.32") || ver.startsWith("3.1.") || ver.startsWith("3.3.") || ver.startsWith("3.4."))) {
            split = 64;
        }

        return split;
    }

    /**
     * return the port number on one module.
     *
     * @return
     */
    public int getPortCount() {
        return 4;
    }

}