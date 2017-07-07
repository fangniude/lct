package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.NeFileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuUpgradeHwTypeTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Modified by Zhou Chao, 2008/12/17
public class OnuUpgradeHwTypeTablePanel extends UPanel {

    private int[] onuUpgradeHwTypeHwTypeVList = new int[]{1, 2, 3, 4,};
    private String[] onuUpgradeHwTypeHwTypeTList = new String[]{
            fStringMap.getString("ONT1001t"),
            fStringMap.getString("ONT408t"),
            fStringMap.getString("B1205"),
            fStringMap.getString("ONT404t"),
    };
    private JComboBox tfOnuUpgradeHwTypeHwType = new JComboBox(onuUpgradeHwTypeHwTypeTList);

    private StringTextField tfOnuUpgradeHwTypeHwRevision = new StringTextField();
    private JComboBox tfOnuUpgradeHwTypeOnuUpgradeTarget = new JComboBox();

    private int[] onuUpgradeHwTypeMethodVList = new int[]{1, /*2,*/ 3,};
    private String[] onuUpgradeHwTypeMethodTList = new String[]{
            fStringMap.getString("manual"),
            /*fStringMap.getString("scheduled"),*/
            fStringMap.getString("automatic"),
    };
    private JComboBox tfOnuUpgradeHwTypeMethod = new JComboBox(onuUpgradeHwTypeMethodTList);

    //private StringTextField tfOnuUpgradeHwTypeFwRevision = new StringTextField();
    private StringTextField tfOnuUpgradeHwTypeImageName = new StringTextField();

    private final String onuUpgradeHwTypeHwType = fStringMap.getString("onuUpgradeHwTypeHwType") + ": ";
    private final String onuUpgradeHwTypeHwRevision = fStringMap.getString("onuUpgradeHwTypeHwRevision") + ": ";
    private final String onuUpgradeHwTypeOnuUpgradeTarget = fStringMap.getString("onuUpgradeHwTypeOnuUpgradeTarget") + ": ";
    private final String onuUpgradeHwTypeMethod = fStringMap.getString("onuUpgradeHwTypeMethod") + ": ";
    //private final String onuUpgradeHwTypeFwRevision = fStringMap.getString("onuUpgradeHwTypeFwRevision") + ": ";
    private final String onuUpgradeHwTypeImageName = fStringMap.getString("onuUpgradeHwTypeImageName") + ": ";

    private JButton btFileChooser = new JButton("...");

    public OnuUpgradeHwTypeTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuUpgradeHwTypeHwType));
        tfOnuUpgradeHwTypeHwType.setName(fStringMap.getString("onuUpgradeHwTypeHwType"));
        baseInfoPanel.add(tfOnuUpgradeHwTypeHwType);
        baseInfoPanel.add(new HSpacer());

        tfOnuUpgradeHwTypeOnuUpgradeTarget.addItem(fStringMap.getString("ONT"));
        for (int i = 1; i <= 253; i++) {
            tfOnuUpgradeHwTypeOnuUpgradeTarget.addItem(fStringMap.getString("Circuit") + " " + i);
        }
        tfOnuUpgradeHwTypeOnuUpgradeTarget.addItem(fStringMap.getString("MPU"));
        baseInfoPanel.add(new JLabel(onuUpgradeHwTypeOnuUpgradeTarget));
        tfOnuUpgradeHwTypeOnuUpgradeTarget.setName(fStringMap.getString("onuUpgradeHwTypeOnuUpgradeTarget"));
        baseInfoPanel.add(tfOnuUpgradeHwTypeOnuUpgradeTarget);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeHwTypeMethod));
        tfOnuUpgradeHwTypeMethod.setName(fStringMap.getString("onuUpgradeHwTypeMethod"));
        baseInfoPanel.add(tfOnuUpgradeHwTypeMethod);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeHwTypeHwRevision));
        tfOnuUpgradeHwTypeHwRevision.setName(fStringMap.getString("onuUpgradeHwTypeHwRevision"));
        tfOnuUpgradeHwTypeHwRevision.setEnabled(false);
        baseInfoPanel.add(tfOnuUpgradeHwTypeHwRevision);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(onuUpgradeHwTypeFwRevision));
        //tfOnuUpgradeHwTypeFwRevision.setName(fStringMap.getString("onuUpgradeHwTypeFwRevision"));
        //baseInfoPanel.add(tfOnuUpgradeHwTypeFwRevision);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuUpgradeHwTypeImageName));
        tfOnuUpgradeHwTypeImageName.setName(fStringMap.getString("onuUpgradeHwTypeImageName"));
        JPanel filechoose = new JPanel();
        layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        filechoose.setLayout(layout);
        filechoose.add(tfOnuUpgradeHwTypeImageName);
        filechoose.add(btFileChooser);
        btFileChooser.setPreferredSize(new Dimension(20, 20));
        baseInfoPanel.add(filechoose);
        baseInfoPanel.add(new HSpacer());
        btFileChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NeFileChooser chooser = new NeFileChooser(fApplication, (JDialog) SwingUtilities.getWindowAncestor(OnuUpgradeHwTypeTablePanel.this), new String[]{"flash:"});
                chooser.show();
                if (chooser.getSelectedFile() != null) {
                    tfOnuUpgradeHwTypeImageName.setValue(chooser.getSelectedFile().getAbsoluteName());
                }
            }
        });

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
        tfOnuUpgradeHwTypeHwRevision.setLenScope(0, 63);
        //tfOnuUpgradeHwTypeFwRevision.setLenScope(0, 63);
        tfOnuUpgradeHwTypeImageName.setLenScope(0, 63);
    }

    public boolean validateFrom() {
        if (tfOnuUpgradeHwTypeImageName.getValue().trim().equals("")) {
            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Upgrade_FileIs_Null"));
            return false;
        }

        return true;
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuUpgradeHwTypeHwType.setEnabled(true);
            //OLT doesn't support this item, so disable it.
//            tfOnuUpgradeHwTypeHwRevision.setEnabled(true);
            tfOnuUpgradeHwTypeOnuUpgradeTarget.setEnabled(true);
            tfOnuUpgradeHwTypeMethod.setEnabled(true);
            return;
        } else {
            tfOnuUpgradeHwTypeHwType.setEnabled(false);
            tfOnuUpgradeHwTypeHwRevision.setEnabled(false);
            tfOnuUpgradeHwTypeOnuUpgradeTarget.setEnabled(false);
            tfOnuUpgradeHwTypeMethod.setEnabled(false);
        }

        OnuUpgradeHwTypeTable mbean = (OnuUpgradeHwTypeTable) getModel();
        if (mbean == null)
            return;

        tfOnuUpgradeHwTypeHwType.setSelectedIndex(getIndexFromValue(onuUpgradeHwTypeHwTypeVList, mbean.getOnuUpgradeHwTypeHwType()));
        tfOnuUpgradeHwTypeHwRevision.setValue(mbean.getOnuUpgradeHwTypeHwRevision());
        tfOnuUpgradeHwTypeOnuUpgradeTarget.setSelectedIndex(mbean.getOnuUpgradeHwTypeOnuUpgradeTarget() - 1);
        tfOnuUpgradeHwTypeMethod.setSelectedIndex(getIndexFromValue(onuUpgradeHwTypeMethodVList, mbean.getOnuUpgradeHwTypeMethod()));
        //tfOnuUpgradeHwTypeFwRevision.setValue(mbean.getOnuUpgradeHwTypeFwRevision());

        tfOnuUpgradeHwTypeImageName.setEnabled(mbean.getOnuUpgradeHwTypeImageName() != null);
        tfOnuUpgradeHwTypeImageName.setValue(mbean.getOnuUpgradeHwTypeImageName());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuUpgradeHwTypeTable(fApplication.getSnmpProxy()));

        OnuUpgradeHwTypeTable mbean = (OnuUpgradeHwTypeTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setOnuUpgradeHwTypeHwType(onuUpgradeHwTypeHwTypeVList[tfOnuUpgradeHwTypeHwType.getSelectedIndex()]);
            if(tfOnuUpgradeHwTypeHwRevision.isEnabled())
                mbean.setOnuUpgradeHwTypeHwRevision(tfOnuUpgradeHwTypeHwRevision.getValue());
            mbean.setOnuUpgradeHwTypeOnuUpgradeTarget(tfOnuUpgradeHwTypeOnuUpgradeTarget.getSelectedIndex() + 1);
            mbean.setOnuUpgradeHwTypeMethod(onuUpgradeHwTypeMethodVList[tfOnuUpgradeHwTypeMethod.getSelectedIndex()]);
        }

        //mbean.setOnuUpgradeHwTypeFwRevision(tfOnuUpgradeHwTypeFwRevision.getValue());

        if (tfOnuUpgradeHwTypeImageName.isEnabled())
            mbean.setOnuUpgradeHwTypeImageName(tfOnuUpgradeHwTypeImageName.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}