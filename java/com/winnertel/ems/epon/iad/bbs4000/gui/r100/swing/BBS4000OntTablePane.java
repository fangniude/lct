package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BBS4000OntTablePane extends UPanel implements ActionListener {

    private OntFilterPanel filterPane = null;
    private SnmpTablePane snmpPanel;

    public BBS4000OntTablePane(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        filterPane = new OntFilterPanel(fApplication);
        filterPane.addActionListener(this);

        setLayout(new BorderLayout());
        add(filterPane, BorderLayout.NORTH);
    }

    protected void initForm() {
    }

    public void refresh() {
        filterPane.refresh();

        if (snmpPanel == null) {
            IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
            snmpPanel = (SnmpTablePane) composer.composeSnmpTablePane(getName());
            add(snmpPanel, BorderLayout.CENTER);
        }

        //force the table pane refresh the data.
        actionPerformed(null);
    }

    /*
    public void actionPerformed(ActionEvent e) {
        SnmpMibBean bean = (SnmpMibBean) snmpPanel.getModel();
        if (filterPane.getSelectedSlotId() == 0) { //select all
            bean.setIndex(0, null);
            bean.setIndex(1, null);
            bean.setIndex(2, null);
            bean.setIndexPrefix(null); //set null to disable this attribute.
        } else {
            if (filterPane.getSelectedPortId() == 0) { //select all
                bean.setIndex(0, "" + filterPane.getSelectedSlotId());
                bean.setIndex(1, "1");
                bean.setIndex(2, "0");
                bean.setIndexPrefix(filterPane.getSelectedSlotId() + ".");
            } else {
                if (filterPane.getSelectedOntId() == 0) { //select all
                    bean.setIndex(0, "" + filterPane.getSelectedSlotId());
                    bean.setIndex(1, "" + filterPane.getSelectedPortId());
                    bean.setIndex(2, "0");
                    bean.setIndexPrefix(filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId());
                } else {
                    bean.setIndex(0, "" + filterPane.getSelectedSlotId());
                    bean.setIndex(1, "" + filterPane.getSelectedPortId());
                    bean.setIndex(2, "" + (filterPane.getSelectedOntId() - 1));
                    bean.setIndexPrefix(filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId() + "." + filterPane.getSelectedOntId());
                }
            }
        }

        snmpPanel.refresh();
    }
    */

    public void actionPerformed(ActionEvent e) {
        SnmpMibBean bean = (SnmpMibBean) snmpPanel.getModel();
        String[] index = getIndex(getName());
        if (index != null) {
            for (int i = 0; i < index.length; i++) {
                bean.setIndex(i, index[i]);
            }
        }

        bean.setIndexPrefix(getIndexPrefix());

        snmpPanel.refresh();
    }

    private String[] getIndex(String panel) {
        String[] index = null;

        if (panel.equals("GponOnuEthUniCfg_Panel") || panel.equals("GponOnuVirtualPortConfigure_Panel")) {
            index = new String[4];

            //fill the index.
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();

                if (filterPane.getSelectedPortId() == 0) {
                    index[1] = "1";
                    index[2] = "1";
                } else {
                    index[1] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOntId() == 0) {
                        index[2] = "1";
                    } else {
                        index[2] = "" + filterPane.getSelectedOntId();
                    }
                }

                index[3] = "0";
            }
        } else {
            index = new String[3];

            //fill the index.
            if (filterPane.getSelectedSlotId() != 0) {
                index[0] = "" + filterPane.getSelectedSlotId();
                if (filterPane.getSelectedPortId() == 0) {
                    index[1] = "1";
                    index[2] = "0";
                } else {
                    index[1] = "" + filterPane.getSelectedPortId();
                    if (filterPane.getSelectedOntId() == 0) {
                        index[2] = "0";
                    } else {
                        index[2] = "" + (filterPane.getSelectedOntId() - 1);
                    }
                }
            }
        }

        return index;
    }

    private String getIndexPrefix() {
        if (filterPane.getSelectedSlotId() != 0) { //select all
            if (filterPane.getSelectedPortId() == 0) { //select all
                return "" + filterPane.getSelectedSlotId();
            } else {
                if (filterPane.getSelectedOntId() == 0) { //select all
                    return filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId();
                } else {
                    return filterPane.getSelectedSlotId() + "." + filterPane.getSelectedPortId() + "." + filterPane.getSelectedOntId();
                }
            }
        }

        return null;
    }

}