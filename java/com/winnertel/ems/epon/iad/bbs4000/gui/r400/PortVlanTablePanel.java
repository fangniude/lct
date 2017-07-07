package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r400.EponDeviceIndexFormatter;
import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ViewComposer;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PortVlanTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * The PortVlanTablePanel class.
 * Created by DVM Creator
 */
public class PortVlanTablePanel extends UPanel implements ItemListener, ActionListener {

    private StringTextField tfPvlanDeviceIndex = new StringTextField();

    private IntegerTextField tfPvlanCardIndex = new IntegerTextField();

    private IntegerTextField tfPvlanPortIndex = new IntegerTextField();

    private HexTextField tfVlanTagTpid = new HexTextField();

    private int[] vlanTagCfiVList = new int[]{
            1, 2,};
    private String[] vlanTagCfiTList = new String[]{
            fStringMap.getString("true"),
            fStringMap.getString("false"),
    };
    private JComboBox tfVlanTagCfi = new JComboBox(vlanTagCfiTList);
    private IntegerTextField tfVlanTagPriority = new IntegerTextField();

    private IntegerTextField tfVlanPVid = new IntegerTextField();

    private int[] vlanModeVList = new int[]{
            0,1,2,3,4,5};
    private String[] vlanModeTList = new String[]{
            fStringMap.getString("transparent"),
            fStringMap.getString("tag"),
            fStringMap.getString("translation"),
            fStringMap.getString("aggregation"),
            fStringMap.getString("trunk"),
            fStringMap.getString("stacking"),
    };
    private JComboBox tfVlanMode = new JComboBox(vlanModeTList);

    private JButton transaltionButton = new JButton(fStringMap.getString("translation_item"));
    private ViewComposer composer = new ViewComposer(fApplication);


    private final String pvlanDeviceIndex = fStringMap.getString("pvlanDeviceIndex") + " : ";
    private final String pvlanCardIndex = fStringMap.getString("pvlanCardIndex") + " : ";
    private final String pvlanPortIndex = fStringMap.getString("pvlanPortIndex") + " : ";
    private final String vlanTagTpid = fStringMap.getString("vlanTagTpid") + " : ";
    private final String vlanTagCfi = fStringMap.getString("vlanTagCfi") + " : ";
    private final String vlanTagPriority = fStringMap.getString("vlanTagPriority") + " : ";
    private final String vlanPVid = fStringMap.getString("vlanPVid") + " : ";
    private final String vlanMode = fStringMap.getString("vlanMode") + " : ";

    public PortVlanTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(pvlanDeviceIndex));
        baseInfoPanel.add(tfPvlanDeviceIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(pvlanCardIndex));
        baseInfoPanel.add(tfPvlanCardIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(pvlanPortIndex));
        baseInfoPanel.add(tfPvlanPortIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(vlanTagTpid));
        tfVlanTagTpid.setName(fStringMap.getString("vlanTagTpid"));
        baseInfoPanel.add(tfVlanTagTpid);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(vlanTagCfi));
        tfVlanTagCfi.setName(fStringMap.getString("vlanTagCfi"));
        baseInfoPanel.add(tfVlanTagCfi);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(vlanTagPriority));
        tfVlanTagPriority.setName(fStringMap.getString("vlanTagPriority"));
        baseInfoPanel.add(tfVlanTagPriority);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(vlanPVid));
        tfVlanPVid.setName(fStringMap.getString("vlanPVid"));
        baseInfoPanel.add(tfVlanPVid);
        baseInfoPanel.add(new HSpacer());


        JPanel panel = new JPanel();
        panel.add(tfVlanMode);
        panel.add(transaltionButton);
        transaltionButton.addActionListener(this);
        baseInfoPanel.add(new JLabel(vlanMode));
        tfVlanMode.setName(fStringMap.getString("vlanMode"));
        baseInfoPanel.add(panel);
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
        tfVlanTagPriority.setValueScope(0, 7);
        tfPvlanDeviceIndex.setEditable(false);
        tfPvlanCardIndex.setEditable(false);
        tfPvlanPortIndex.setEditable(false);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) return;

        PortVlanTable mbean = (PortVlanTable) getModel();

        try{
            String deviceIndex=(new EponDeviceIndexFormatter(fApplication)).format( mbean,"pvlanDeviceIndex").toString();
            tfPvlanDeviceIndex.setText( deviceIndex );
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //tfPvlanDeviceIndex.setText(mbean.getPvlanDeviceIndex().toString());

        tfPvlanCardIndex.setText(mbean.getPvlanCardIndex().toString());
        tfPvlanPortIndex.setText(mbean.getPvlanPortIndex().toString());
        tfVlanTagTpid.setValue( format(mbean.getVlanTagTpid()));
        tfVlanTagCfi.setSelectedIndex(getIndexFromValue(vlanTagCfiVList, mbean.getVlanTagCfi().intValue()));
        tfVlanTagPriority.setValue(mbean.getVlanTagPriority().intValue());
        tfVlanPVid.setValue(mbean.getVlanPVid().intValue());
        tfVlanMode.setSelectedIndex(getIndexFromValue(vlanModeVList, mbean.getVlanMode().intValue()));

        itemStateChanged(null);
    }

    public void updateModel() {
        PortVlanTable mbean = (PortVlanTable) getModel();

        mbean.setVlanTagTpid(generate(tfVlanTagTpid.getValue()));
        mbean.setVlanTagCfi(new Integer(vlanTagCfiVList[tfVlanTagCfi.getSelectedIndex()]));
        mbean.setVlanTagPriority(new Integer(tfVlanTagPriority.getValue()));
        mbean.setVlanPVid(new Integer(tfVlanPVid.getValue()));
        mbean.setVlanMode(new Integer(vlanModeVList[tfVlanMode.getSelectedIndex()]));
    }

    public void afterUpdateModel() {
        itemStateChanged(null);
    }

    String format(byte[] tpid) {
        int id = ((tpid[0]&0xFF) << 8) | (tpid[1]&0xFF);

        return Integer.toHexString(id);
    }

    byte[] generate(String tpid) {
        int id = Integer.valueOf(tpid, 16);

        byte[] b = new byte[2];

        b[0] = (byte)(id >> 8);
        b[1] = (byte)id;

        return b;
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }


    public void itemStateChanged(ItemEvent e) {
        if (tfVlanMode.getSelectedIndex() == 2 || tfVlanMode.getSelectedIndex() == 5){
            transaltionButton.setEnabled(true);
        }else{
            transaltionButton.setEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        Window win = SwingUtilities.getWindowAncestor(this);


        SnmpDialog dlg = new SnmpDialog(win, fApplication, fStringMap.getString("translation_item"), "", "Q");

        UPanel panel;
        if (tfVlanMode.getSelectedIndex() == 2){
            panel = composer.composeIconSnmpTablePane("PortVlanTranslationTable_Panel_In_Vlan_Mode", win);
        } else if (tfVlanMode.getSelectedIndex() == 5){
            panel = composer.composeIconSnmpTablePane("PortQinQConfigTable_Panel", win);
        } else {
            return;
        }

        SnmpTableModel model = (SnmpTableModel)panel.getTable().getModel();
        SnmpMibBean bean = model.getMibBean();

        PortVlanTable vlan = (PortVlanTable) getModel();
        bean.setIndex(0, new Long(vlan.getPvlanDeviceIndex()));
        bean.setIndex(1, new Long(vlan.getPvlanCardIndex()));
        bean.setIndex(2, vlan.getPvlanPortIndex());
        bean.setIndexPrefix(vlan.getPvlanDeviceIndex() + "." + vlan.getPvlanCardIndex() + "." + vlan.getPvlanPortIndex());

        panel.refresh();
        dlg.setPanel(panel);
        dlg.setTable(panel.getTable());
        dlg.pack();
        dlg.setVisible(true);
    }
}