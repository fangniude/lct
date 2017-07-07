/**
 * Created by Zhou Chao, 2008/10/01 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnuFilterPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuDynamicMultiGroupMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.Application;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GponOnuDynamicMultiGroupPanel extends UPanel implements ActionListener {

    private boolean initialized = false;

    private SnmpTablePane snmpTablePanel = null;

    private OnuFilterPanel filterPane = null;

    public GponOnuDynamicMultiGroupPanel(IApplication app) {
        super(app);
        setModel(new GponOnuDynamicMultiGroupMBean(app.getSnmpProxy()));
        init();
    }

    private void initialize() {
        if (!initialized) {
            initialized = true;

            //initGui();
            setLayout(new BorderLayout());
            add(getFilterPane(), BorderLayout.NORTH);
            add(getTablePane(), BorderLayout.CENTER);

            //initForm();
        }
    }

    public void initGui() {
        //setLayout(new BorderLayout());
        //add(getFilterPane(), BorderLayout.NORTH);
        //add(getTablePane(), BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    private JPanel getFilterPane() {
        if (filterPane == null) {
            filterPane = new OnuFilterPanel(fApplication);
            filterPane.addActionListener(this);
        }

        return filterPane;
    }

    private SnmpTablePane getTablePane() {
        if (snmpTablePanel == null) {
            IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
            snmpTablePanel = (SnmpTablePane) composer1.composeSnmpTablePane("GponOnuDynamicMultiGroup_Panel");
        }

        return snmpTablePanel;
    }

    public void refresh() {
        initialize();

        if (filterPane != null)
            filterPane.refresh();

        actionPerformed(null); //force the table pane refresh the data.
    }

    public void updateModel() {
    }

    public void actionPerformed(ActionEvent e) {
        GponOnuDynamicMultiGroupMBean bean = (GponOnuDynamicMultiGroupMBean) snmpTablePanel.getModel();
        if (filterPane.getSelectedSlotId() == 0) { //select all
            bean.setIndex(0, "0");
            bean.setIndex(1, "0");
            bean.setIndex(2, "64");
            bean.setIndexPrefix(null); //set 0 to disable this attribute.
        } else {
            if (filterPane.getSelectedPortId() == 0) { //select all
                bean.setIndex(0, "" + (filterPane.getSelectedSlotId() - 1));
                bean.setIndex(1, "4");
                bean.setIndex(2, "64");
                bean.setIndexPrefix(filterPane.getSelectedSlotId() + ".");
            } else {
                if (filterPane.getSelectedOnuId() == 0) { //select all
                    bean.setIndex(0, "" + filterPane.getSelectedSlotId());
                    bean.setIndex(1, "" + (filterPane.getSelectedPortId() - 1));
                    bean.setIndex(2, "64");
                    bean.setIndexPrefix(filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId() + ".");
                } else {
                    bean.setIndex(0, "" + filterPane.getSelectedSlotId());
                    bean.setIndex(1, "" + filterPane.getSelectedPortId());
                    bean.setIndex(2, "" + (filterPane.getSelectedOnuId() - 1));
                    bean.setIndexPrefix(filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId() + "." + filterPane.getSelectedOnuId());
                }
            }
        }

        snmpTablePanel.refresh();
    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap.getString(s);
    }

    public static void main(String[] args) { //for test
        Application app = new Application(new Locale("en", "US"));
        GponOnuDynamicMultiGroupPanel panel = new GponOnuDynamicMultiGroupPanel(app);
        panel.setVisible(true);
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}