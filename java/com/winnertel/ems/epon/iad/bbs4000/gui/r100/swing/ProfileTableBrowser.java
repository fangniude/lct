/**
 * Created by Zhou Chao, 2009/2/13
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.*;

public class ProfileTableBrowser {

    private IApplication fApplication = null;
    private SnmpTable table = null;

    public ProfileTableBrowser(IApplication app) {
        fApplication = app;
    }

    public SnmpTable getTable() {
        return table;
    }

    //Sample:
    //  tableView: "OnuUPUTMProfTable_Panel"
    public Component getComponent(String tableView) {
        ViewComposer guiComposer = (ViewComposer) fApplication.getActiveDeviceManager().getProperties().get("ViewComposer");
        if (guiComposer == null) {
            guiComposer = new ViewComposer(fApplication);
            fApplication.getActiveDeviceManager().getProperties().put("ViewComposer", guiComposer);
        }
        //IGuiComposer guiComposer = fApplication.getActiveDeviceManager().getGuiComposer();

        //construct 'table' panel
        SnmpTablePane tablePanel = guiComposer.composeSnmpTablePane(tableView);
        table = tablePanel.getTable();
        tablePanel.refresh();

        return tablePanel;
    }

    //Sample:
    //  tableView: "OnuUPUTMProfTable_Panel"
    public Component getComponent(String tableView, long[] indexes, String prefix) {
        ViewComposer guiComposer = (ViewComposer) fApplication.getActiveDeviceManager().getProperties().get("ViewComposer");
        if (guiComposer == null) {
            guiComposer = new ViewComposer(fApplication);
            fApplication.getActiveDeviceManager().getProperties().put("ViewComposer", guiComposer);
        }
        //IGuiComposer guiComposer = fApplication.getActiveDeviceManager().getGuiComposer();

        //construct 'table' panel
        SnmpTablePane tablePanel = guiComposer.composeSnmpTablePane(tableView);
        table = tablePanel.getTable();

        //filter invalid data
        SnmpMibBean bean = (SnmpMibBean) tablePanel.getModel();
        for (int i = 0; i < indexes.length; i++) {
            bean.setIndex(i, indexes[i]);
        }
        bean.setIndexPrefix(prefix);
        tablePanel.refresh();

        return tablePanel;
    }

}