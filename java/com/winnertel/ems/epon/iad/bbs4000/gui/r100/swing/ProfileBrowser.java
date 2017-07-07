/**
 * Created by Zhou Chao, 2009/2/13
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.gui.util.InstanceCreator;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.*;

public class ProfileBrowser {

    private IApplication fApplication = null;

    public ProfileBrowser(IApplication app) {
        fApplication = app;
    }

    //Sample:
    //  tableView: "OnuUPUTMProfTable_Panel"
    //  leafView: "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPUTMProfTablePanel"
    public Component getComponent(String tableView, String leafView) {
        ViewComposer guiComposer = (ViewComposer) fApplication.getActiveDeviceManager().getProperties().get("ViewComposer");
        if (guiComposer == null) {
            guiComposer = new ViewComposer(fApplication);
            fApplication.getActiveDeviceManager().getProperties().put("ViewComposer", guiComposer);
        }
        //IGuiComposer guiComposer = fApplication.getActiveDeviceManager().getGuiComposer();

        //construct 'table' panel
        SnmpTablePane tablePanel = guiComposer.composeSnmpTablePane(tableView);
        tablePanel.refresh();

        SnmpTable table = tablePanel.getTable();
        if (table.getRowCount() < 2) {
            //construct 'leaf' panel
            UPanel leafPanel = InstanceCreator.instantiatePanel(fApplication, leafView);
            if (table.getRowCount() > 0) {
                leafPanel.setModel(((SnmpTableModel) table.getModel()).getRow(0));
                leafPanel.refresh();
            }

            return leafPanel;
        }

        return tablePanel;
    }

    //Sample:
    //  tableView: "OnuUPUTMProfTable_Panel"
    //  leafView: "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPUTMProfTablePanel"
    public Component getComponent(String tableView, String leafView, long[] indexes, String prefix) {
        ViewComposer guiComposer = (ViewComposer) fApplication.getActiveDeviceManager().getProperties().get("ViewComposer");
        if (guiComposer == null) {
            guiComposer = new ViewComposer(fApplication);
            fApplication.getActiveDeviceManager().getProperties().put("ViewComposer", guiComposer);
        }
        //IGuiComposer guiComposer = fApplication.getActiveDeviceManager().getGuiComposer();

        //construct 'table' panel
        SnmpTablePane tablePanel = guiComposer.composeSnmpTablePane(tableView);

        //filter invalid data
        SnmpMibBean bean = (SnmpMibBean) tablePanel.getModel();
        for (int i = 0; i < indexes.length; i++) {
            bean.setIndex(i, indexes[i]);
        }
        bean.setIndexPrefix(prefix);
        tablePanel.refresh();

        SnmpTable table = tablePanel.getTable();
        if (table.getRowCount() < 2) {
            //construct 'leaf' panel
            UPanel leafPanel = InstanceCreator.instantiatePanel(fApplication, leafView);
            if (table.getRowCount() > 0) {
                leafPanel.setModel(((SnmpTableModel) table.getModel()).getRow(0));

                //don't refresh the view panel immediately because the profile chooser in this panel need to get the window Ancestor of the panel.
//                leafPanel.refresh();
            }

            return leafPanel;
        }

        return tablePanel;
    }

}