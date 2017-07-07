/**
 * Created by Zhou Chao, 2008/10/23
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOltMultiGroupToMultiVlanMapMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class GponOltMultiGroupToMultiVlanMapPanel extends UPanel {

    private IndexAutoGenField tfOltMultiGrouptoMultiVlanMapIndex = new IndexAutoGenField(fApplication,1);
    private IPAddressField tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart = new IPAddressField(IPAddressField.IPMULTICAST);
    private IPAddressField tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop = new IPAddressField(IPAddressField.IPMULTICAST);
    private IntegerTextField tfOltMultiGrouptoMultiVlanMapVlanID = new IntegerTextField();

    private final String oltMultiGrouptoMultiVlanMapIndex = fStringMap.getString("oltMultiGrouptoMultiVlanMapIndex") + ": ";
    private final String oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart = fStringMap.getString("oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart") + ": ";
    private final String oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop = fStringMap.getString("oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop") + ": ";
    private final String oltMultiGrouptoMultiVlanMapVlanID = fStringMap.getString("oltMultiGrouptoMultiVlanMapVlanID") + ": ";

    public GponOltMultiGroupToMultiVlanMapPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(oltMultiGrouptoMultiVlanMapIndex));
        baseInfoPanel.add(tfOltMultiGrouptoMultiVlanMapIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart));
        tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart.setName(fStringMap.getString("oltMultiGrouptoMultiVlanMapMulticastGroupAddressStart"));
        baseInfoPanel.add(tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop));
        tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop.setName(fStringMap.getString("oltMultiGrouptoMultiVlanMapMulticastGroupAddressStop"));
        baseInfoPanel.add(tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(oltMultiGrouptoMultiVlanMapVlanID));
        tfOltMultiGrouptoMultiVlanMapVlanID.setName(fStringMap.getString("oltMultiGrouptoMultiVlanMapVlanID"));
        baseInfoPanel.add(tfOltMultiGrouptoMultiVlanMapVlanID);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfOltMultiGrouptoMultiVlanMapVlanID.setValueScope(1, 4094);
        tfOltMultiGrouptoMultiVlanMapIndex.setValueScope(0,2, Long.MAX_VALUE);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOltMultiGrouptoMultiVlanMapIndex.setEnabled(true);
            tfOltMultiGrouptoMultiVlanMapIndex.setTable(fTable);
            tfOltMultiGrouptoMultiVlanMapIndex.refresh();
            return;
        }
        GponOltMultiGroupToMultiVlanMapMBean mbean = (GponOltMultiGroupToMultiVlanMapMBean) getModel();
        if (mbean == null)
            return;

        tfOltMultiGrouptoMultiVlanMapIndex.setValue(0,mbean.getOltMultiGrouptoMultiVlanMapIndex());

        tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart.setEnabled(mbean.getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart() != null);
        tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart.setValue(mbean.getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart() != null ? mbean.getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart() : "");

        tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop.setEnabled(mbean.getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop() != null);
        tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop.setValue(mbean.getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop() != null ? mbean.getOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop() : "");

        tfOltMultiGrouptoMultiVlanMapVlanID.setEnabled(mbean.getOltMultiGrouptoMultiVlanMapVlanID() != null);
        tfOltMultiGrouptoMultiVlanMapVlanID.setValue(mbean.getOltMultiGrouptoMultiVlanMapVlanID() != null ? mbean.getOltMultiGrouptoMultiVlanMapVlanID() : 0);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new GponOltMultiGroupToMultiVlanMapMBean(fApplication.getSnmpProxy()));
            tfOltMultiGrouptoMultiVlanMapIndex.setEnabled(true);
        } else
            tfOltMultiGrouptoMultiVlanMapIndex.setEnabled(false);
        GponOltMultiGroupToMultiVlanMapMBean mbean = (GponOltMultiGroupToMultiVlanMapMBean) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            //mbean.set ??(new Integer( ? ?.getValue()));
            mbean.setOltMultiGrouptoMultiVlanMapIndex(tfOltMultiGrouptoMultiVlanMapIndex.getValue(0));
        }

        if (tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart.isEnabled())
            mbean.setOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart(tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStart.getIPString());

        if (tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop.isEnabled())
            mbean.setOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop(tfOltMultiGrouptoMultiVlanMapMulticastGroupAddressStop.getIPString());

        if (tfOltMultiGrouptoMultiVlanMapVlanID.isEnabled())
            mbean.setOltMultiGrouptoMultiVlanMapVlanID(tfOltMultiGrouptoMultiVlanMapVlanID.getValue());
    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOltMultiGrouptoMultiVlanMapIndex.increaseIndexValue();
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}