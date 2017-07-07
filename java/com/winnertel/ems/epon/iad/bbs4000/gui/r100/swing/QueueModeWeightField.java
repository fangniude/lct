package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class QueueModeWeightField  {

    private IApplication fApplication;
    private IGuiComposer fStringMap ;
    private int[] modeVList = new int[]{1, 2, 3,};
    private String[] modeTList ;
    private JComboBox cbMode ;
    private JPanel modePanel = new JPanel();
    private JPanel weightPanel = new JPanel();
    
    
    private int OBJ_NUM = 8;
    private JComboBox[] cbBits = new JComboBox[OBJ_NUM];
    private byte[] data = new byte[OBJ_NUM];

    public QueueModeWeightField(IApplication app) {
        super();
        fApplication = app;
        fStringMap = fApplication.getActiveDeviceManager().getGuiComposer();
        initGui();
    }

    public void initGui() {
        modeTList = new String[]{
                fStringMap.getString("sp"),
                fStringMap.getString("wrr"),
                fStringMap.getString("spwrr"),
        };
        cbMode = new JComboBox(modeTList);
        
        NTLayout layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.LEFT, 5, 5);
        modePanel.setLayout(layout);
        modePanel.add(cbMode);
        modePanel.add(new HSpacer());
        layout = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        weightPanel.setLayout(layout);
        weightPanel.setBorder(BorderFactory.createEtchedBorder());
        for (int i = 0; i < OBJ_NUM; i++) {
            weightPanel.add(new JLabel(fStringMap.getString("Queue") + " " + (i + 1) + ": "));
            cbBits[i] = new JComboBox();
            weightPanel.add(cbBits[i]);
        }
        
        cbMode.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (cbMode.getSelectedIndex() == 1) { //WRR
                    setWeightEnabled(true);
                    loadWeightData(1, 127);
                } else if (cbMode.getSelectedIndex() == 2) { //SPWRR
                    setWeightEnabled(true);
                    loadWeightData(0, 127);
                } else { //SP
                    setWeightEnabled(false);
                    loadWeightData(1, 127);
                }
            }
        });
        loadWeightData(1, 127);
    }

    public void clearData() {
        for (int i = 0; i < OBJ_NUM; i++) {
            cbBits[i].removeAllItems();
        }
    }

    public void setWeightEnabled(boolean flag) {
        for (int i = 0; i < OBJ_NUM; i++) {
            cbBits[i].setEnabled(flag);
        }
    }
    
    public void setEnabled(boolean flag){
        
    }

    public boolean isWeightEnabled() {
        return cbBits[0].isEnabled();
    }

    public void loadWeightData(int start, int end) {
        clearData();

        for (int n = start; n <= end; n++) {
            for (int i = 0; i < OBJ_NUM; i++) {
                cbBits[i].addItem("" + n);
            }
        }
    }

    public void setWeightValue(byte[] data) {
        for (int i = 0; i < OBJ_NUM; i++) {
            cbBits[i].setSelectedIndex(0);
        }
        for (int i = 0; i < data.length && i < OBJ_NUM; i++) {
            int diff = ("0".equals(cbBits[i].getItemAt(0).toString()) ? 0 : -1);
            int index = data[i] < 0 ? 0 : (data[i] & 0xFF) + diff;
            if (index < cbBits[i].getItemCount())
                cbBits[i].setSelectedIndex(index);
        }
    }

    public byte[] getWeightValue() {
        for (int i = 0; i < OBJ_NUM; i++) {
            int index = cbBits[i].getSelectedIndex();
            if ("0".equals(cbBits[i].getItemAt(0).toString()))
                data[i] = (byte) index;
            else
                data[i] = (byte) (index + 1);
        }

        return data;
    }
    
    public void setModeValue(int modeValue){
        for (int i = 0; i != modeVList.length; i++) {
            if (modeVList[i] == modeValue)
            {cbMode.setSelectedIndex(i);
            break;
            }
        }

               
    }
    
    public int getModeValue(){
        int value = 0;
        value = modeVList[cbMode.getSelectedIndex()];
        return value;
    }
    
    public void setSelectedModeIndex(int index){
        cbMode.setSelectedIndex(index);
    }
    
    public JPanel getModePanel(){
        return modePanel;
    }
    
    public JPanel getWeightPanel(){
        return weightPanel;
    }
    
}

