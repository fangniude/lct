/**
 * Created by Zhou Chao, 2009/10/26
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuLaserTxOnOffCfgTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class OnuLaserTxOnOffCfgTablePanel extends UPanel {

    private JComboBox tfOnuLaserTxOnOffCfgSlotNo = new JComboBox();
    private JComboBox tfOnuLaserTxOnOffCfgPortNo = new JComboBox();
    private JComboBox tfOnuLaserTxOnOffCfgLogicalPortNo = new JComboBox();

    private int[] onuLaserTxOnOffCfgSwitchVList = new int[]{2, 1,};
    private String[] onuLaserTxOnOffCfgSwitchTList = new String[]{
            fStringMap.getString("off"),
            fStringMap.getString("on"),
    };
    private JComboBox tfOnuLaserTxOnOffCfgSwitch = new JComboBox(onuLaserTxOnOffCfgSwitchTList);

    private LongTextField tfOnuLaserTxOnOffCfgOnTimer = new LongTextField();

    private final String onuLaserTxOnOffCfgSlotNo = fStringMap.getString("onuLaserTxOnOffCfgSlotNo") + ": ";
    private final String onuLaserTxOnOffCfgPortNo = fStringMap.getString("onuLaserTxOnOffCfgPortNo") + ": ";
    private final String onuLaserTxOnOffCfgLogicalPortNo = fStringMap.getString("onuLaserTxOnOffCfgLogicalPortNo") + ": ";
    private final String onuLaserTxOnOffCfgSwitch = fStringMap.getString("onuLaserTxOnOffCfgSwitch") + ": ";
    private final String onuLaserTxOnOffCfgOnTimer = fStringMap.getString("onuLaserTxOnOffCfgOnTimer") + ": ";

    private BBS4000NE ne = null;

    public OnuLaserTxOnOffCfgTablePanel(IApplication app) {
        super(app);
        ne = new BBS4000NE(fApplication);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuLaserTxOnOffCfgSlotNo));
        baseInfoPanel.add(tfOnuLaserTxOnOffCfgSlotNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLaserTxOnOffCfgPortNo));
        baseInfoPanel.add(tfOnuLaserTxOnOffCfgPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLaserTxOnOffCfgLogicalPortNo));
        baseInfoPanel.add(tfOnuLaserTxOnOffCfgLogicalPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLaserTxOnOffCfgSwitch));
        tfOnuLaserTxOnOffCfgSwitch.setName(fStringMap.getString("onuLaserTxOnOffCfgSwitch"));
        baseInfoPanel.add(tfOnuLaserTxOnOffCfgSwitch);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuLaserTxOnOffCfgOnTimer));
        tfOnuLaserTxOnOffCfgOnTimer.setName(fStringMap.getString("onuLaserTxOnOffCfgOnTimer"));
        baseInfoPanel.add(tfOnuLaserTxOnOffCfgOnTimer);
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
        tfOnuLaserTxOnOffCfgOnTimer.setValueScope(1, 1800);
        tfOnuLaserTxOnOffCfgOnTimer.setValue(300);
    }

    public void refresh() {
        //-------------------
        //Slot
        tfOnuLaserTxOnOffCfgSlotNo.removeAllItems();
        BaseModuleType fModuleType = new ModuleType();
        BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, bean);
        for (int i = 0; i < list.size(); i++) {
            BBS4000CardMibBean card = (BBS4000CardMibBean) list.get(i);
            if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuLaserTxOnOffCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
            } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                tfOnuLaserTxOnOffCfgSlotNo.addItem(fStringMap.getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
            }
        }
        //Port
        tfOnuLaserTxOnOffCfgPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPortCount(); i++) {
            tfOnuLaserTxOnOffCfgPortNo.addItem(fStringMap.getString("Port") + " " + i);
        }
        //Logical Port
        tfOnuLaserTxOnOffCfgLogicalPortNo.removeAllItems();
        for (int i = 1; i <= ne.getPonSplitRatio(); i++) {
            tfOnuLaserTxOnOffCfgLogicalPortNo.addItem(fStringMap.getString("ONT") + " " + i);
        }

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuLaserTxOnOffCfgSlotNo.setEnabled(true);
            tfOnuLaserTxOnOffCfgPortNo.setEnabled(true);
            tfOnuLaserTxOnOffCfgLogicalPortNo.setEnabled(true);
            return;
        } else {
            tfOnuLaserTxOnOffCfgSlotNo.setEnabled(false);
            tfOnuLaserTxOnOffCfgPortNo.setEnabled(false);
            tfOnuLaserTxOnOffCfgLogicalPortNo.setEnabled(false);
        }

        OnuLaserTxOnOffCfgTable mbean = (OnuLaserTxOnOffCfgTable) getModel();

        tfOnuLaserTxOnOffCfgSlotNo.setSelectedItem((mbean.getOnuLaserTxOnOffCfgSlotNo() != null) ? fStringMap.getString("Slot") + " " + mbean.getOnuLaserTxOnOffCfgSlotNo().toString() : "");
        tfOnuLaserTxOnOffCfgPortNo.setSelectedItem((mbean.getOnuLaserTxOnOffCfgPortNo() != null) ? fStringMap.getString("Port") + " " + mbean.getOnuLaserTxOnOffCfgPortNo().toString() : "");
        tfOnuLaserTxOnOffCfgLogicalPortNo.setSelectedItem((mbean.getOnuLaserTxOnOffCfgLogicalPortNo() != null) ? fStringMap.getString("ONT") + " " + mbean.getOnuLaserTxOnOffCfgLogicalPortNo().toString() : "");
        tfOnuLaserTxOnOffCfgSwitch.setSelectedIndex(getIndexFromValue(onuLaserTxOnOffCfgSwitchVList, mbean.getOnuLaserTxOnOffCfgSwitch()));
        tfOnuLaserTxOnOffCfgOnTimer.setValue(mbean.getOnuLaserTxOnOffCfgOnTimer() != null ? mbean.getOnuLaserTxOnOffCfgOnTimer().intValue() : 0);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuLaserTxOnOffCfgTable(fApplication.getSnmpProxy()));

        OnuLaserTxOnOffCfgTable mbean = (OnuLaserTxOnOffCfgTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setOnuLaserTxOnOffCfgSlotNo(getSelectedSlotId());
            mbean.setOnuLaserTxOnOffCfgPortNo(getSelectedPortId());
            mbean.setOnuLaserTxOnOffCfgLogicalPortNo(getSelectedOnuId());
        }

        mbean.setOnuLaserTxOnOffCfgSwitch(onuLaserTxOnOffCfgSwitchVList[tfOnuLaserTxOnOffCfgSwitch.getSelectedIndex()]);
        mbean.setOnuLaserTxOnOffCfgOnTimer(tfOnuLaserTxOnOffCfgOnTimer.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

    public int getSelectedSlotId() {
        if (tfOnuLaserTxOnOffCfgSlotNo.getSelectedItem() != null) {
            String item = (String) tfOnuLaserTxOnOffCfgSlotNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (tfOnuLaserTxOnOffCfgPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuLaserTxOnOffCfgPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (tfOnuLaserTxOnOffCfgLogicalPortNo.getSelectedItem() != null) {
            String item = (String) tfOnuLaserTxOnOffCfgLogicalPortNo.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

}