package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.ems.epon.iad.bbs1000.gui.swing.BBS1000OnuFilterPanel;
import com.winnertel.ems.epon.iad.bbs1000.gui.swing.BBS1000OnuTablePane;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.BBS4000OnuTablePane;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnuFilterPanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.IMainApplet;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.standard.gui.action.GotoAction;

import java.awt.event.ActionEvent;
import java.util.Map;

/**
 * Created by HZ20192
 * Date: 2011-9-22
 *
 * @author Li Pengpeng
 */
public class GotoOnuCtcTable extends BaseAction {
    private static final long serialVersionUID = -2145360896628088225L;
    private Map<String, String> fParaMap;

    public GotoOnuCtcTable(IApplication anApplication, Map<String, String> para) {
        super(anApplication);
        this.fParaMap = para;
    }

    public void executeAction(ActionEvent e) {
        GotoAction gotoAction = new GotoAction(fApplication, "Configuration", "ONU_BaseInfo", "Dot3Onu2CtcTable_Panel", new BaseAction(fApplication) {
            private static final long serialVersionUID = 1L;

            @Override
            public void executeAction(ActionEvent e) throws Exception {

                IMainApplet mainApplet = fApplication.getMainApplet();
                String neType = mainApplet.getParameter("neType");
                if ("FBW5000".equals(neType)) {
                    BBS4000OnuTablePane panel = (BBS4000OnuTablePane) e.getSource();
                    OnuFilterPanel filterPanel = panel.getFilterPane();
                    filterPanel.setSelectedOnu(fParaMap.get("logicalPort"));
                    panel.refreshTable();
                } else if (neType.startsWith("BBS1000")) {
                    BBS1000OnuTablePane panel = (BBS1000OnuTablePane) e.getSource();
                    BBS1000OnuFilterPanel filterPanel = panel.getFilterPane();
                    filterPanel.setSelectedOnu(fParaMap.get("logicalPort"));
                    panel.refreshTable();
                }

            }
        });
        gotoAction.actionPerformed(e);
    }

}
