package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.TciEntryListPanel;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVlanFilterProfileTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The OnuVlanFilterProfileTablePanel class.
 * Created by Yang Yizai
 */
public class OnuVlanFilterProfileTablePanel extends UPanel {

    private IndexAutoGenField tfOnuVlanFilterProfileIndex = new IndexAutoGenField(fApplication,1);
    private StringTextField tfOnuVlanFilterProfileName = new StringTextField();
    private JComboBox tfOnuVlanFilterProfileTciEntryNumber = new JComboBox();
    private TciEntryListPanel tfOnuVlanFilterProfileTciEntryList = new TciEntryListPanel(fApplication);
    private JComboBox tfOnuVlanFilterProfileForwardOperation = new JComboBox();

    private final String onuVlanFilterProfileIndex = fStringMap.getString("onuVlanFilterProfileIndex") + " : ";
    private final String onuVlanFilterProfileName = fStringMap.getString("onuVlanFilterProfileName") + " : ";
    private final String onuVlanFilterProfileTciEntryNumber = fStringMap.getString("onuVlanFilterProfileTciEntryNumber")+ " : ";
    private final String onuVlanFilterProfileTciEntryList = fStringMap.getString("onuVlanFilterProfileTciEntryList")+ " : ";
    private final String onuVlanFilterProfileForwardOperation = fStringMap.getString("onuVlanFilterProfileForwardOperation")+ " : ";

    public OnuVlanFilterProfileTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuVlanFilterProfileIndex));
        baseInfoPanel.add(tfOnuVlanFilterProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanFilterProfileName));
        tfOnuVlanFilterProfileName.setName(fStringMap.getString("onuVlanFilterProfileName"));
        baseInfoPanel.add(tfOnuVlanFilterProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanFilterProfileTciEntryNumber));
        tfOnuVlanFilterProfileTciEntryNumber.setName(fStringMap.getString("onuVlanFilterProfileTciEntryNumber"));
        baseInfoPanel.add(tfOnuVlanFilterProfileTciEntryNumber);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanFilterProfileTciEntryList));
        tfOnuVlanFilterProfileTciEntryList.setName(fStringMap.getString("onuVlanFilterProfileTciEntryList"));
        baseInfoPanel.add(tfOnuVlanFilterProfileTciEntryList);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVlanFilterProfileForwardOperation));
        tfOnuVlanFilterProfileForwardOperation.setName(fStringMap.getString("onuVlanFilterProfileForwardOperation"));
        baseInfoPanel.add(tfOnuVlanFilterProfileForwardOperation);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(long i=0; i<=21; i++)
            tfOnuVlanFilterProfileForwardOperation.addItem(i);
        for(long i=0; i<=12; i++)
            tfOnuVlanFilterProfileTciEntryNumber.addItem(i);
        tfOnuVlanFilterProfileTciEntryNumber.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                
                tfOnuVlanFilterProfileTciEntryList.setTciEntryFieldEnabled(tfOnuVlanFilterProfileTciEntryNumber.getSelectedIndex());
            }
            
        });
    }

    protected void initForm() {

        tfOnuVlanFilterProfileTciEntryNumber.setSelectedItem(0);
        tfOnuVlanFilterProfileIndex.setValueScope(0,2, 128);
        tfOnuVlanFilterProfileName.setValue("New Profile");

    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)){
            tfOnuVlanFilterProfileIndex.setEnabled(true);
            tfOnuVlanFilterProfileIndex.setTable(fTable);
            tfOnuVlanFilterProfileIndex.refresh();
            tfOnuVlanFilterProfileTciEntryList.setTciEntryFieldEnabled(tfOnuVlanFilterProfileTciEntryNumber.getSelectedIndex());
            return;
        }
            
        OnuVlanFilterProfileTable mbean = (OnuVlanFilterProfileTable) getModel();

        tfOnuVlanFilterProfileIndex.setValue(0,mbean.getOnuVlanFilterProfileIndex());
        tfOnuVlanFilterProfileName.setValue(mbean.getOnuVlanFilterProfileName());
        int value = mbean.getOnuVlanFilterProfileTciEntryNumber().intValue();
        tfOnuVlanFilterProfileTciEntryNumber.setSelectedIndex(value);
        tfOnuVlanFilterProfileTciEntryList.setTciEntryFieldEnabled(value);
         tfOnuVlanFilterProfileTciEntryList.setTciEntryList(mbean.getOnuVlanFilterProfileTciEntryList());
        tfOnuVlanFilterProfileForwardOperation.setSelectedIndex(mbean.getOnuVlanFilterProfileForwardOperation().intValue());


    }

    public void updateModel() {
              
        if (SnmpAction.IType.ADD.equals(fCommand))  setModel(new OnuVlanFilterProfileTable(fApplication.getSnmpProxy()));
           OnuVlanFilterProfileTable mbean = (OnuVlanFilterProfileTable) getModel();
              
        if (SnmpAction.IType.ADD.equals(fCommand)) {
              mbean.setOnuVlanFilterProfileIndex(tfOnuVlanFilterProfileIndex.getValue(0));
         }
              
      mbean.setOnuVlanFilterProfileName( new String(tfOnuVlanFilterProfileName.getValue()));
      mbean.setOnuVlanFilterProfileTciEntryNumber(new Long(tfOnuVlanFilterProfileTciEntryNumber.getSelectedIndex()));
      mbean.setOnuVlanFilterProfileTciEntryList( tfOnuVlanFilterProfileTciEntryList.getTciEntryList());
      mbean.setOnuVlanFilterProfileForwardOperation(new Long(tfOnuVlanFilterProfileForwardOperation.getSelectedIndex()));
    }

    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuVlanFilterProfileIndex.increaseIndexValue();
    }
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
