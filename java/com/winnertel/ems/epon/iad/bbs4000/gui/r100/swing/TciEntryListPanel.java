package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yang Yizai , 2009-2-27
 */
public class TciEntryListPanel extends JPanel {
    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;
    private IntegerTextField[] tciEntryListField = new IntegerTextField[24];
    private JComboBox[] cfiList = new JComboBox[12];
    private int[] cfiVList = new int[]{0,1};
    private String[] cfiTList = new String[]{};
    public TciEntryListPanel(IApplication app){
        fApplication = app;
        if (fApplication.getActiveDeviceManager() != null) {
          fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }

        init();
        initForm();
    }
    
    public void init(){
        JPanel listPanel = new JPanel();
        NTLayout layout = new NTLayout(12, 6, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        listPanel.setLayout(layout);
        String[] cfiTList = new String[]{fStringMap.getString("standard_mac"),fStringMap.getString("nonstandard_mac")};
        for(int i = 1; i <= 12; i++)
        {

          IntegerTextField intVlanField = new IntegerTextField();
          tciEntryListField[(i-1)*2] = intVlanField;
          listPanel.add(new JLabel(fStringMap.getString("VID") + i ));
          listPanel.add(intVlanField);

//          intVlanField = new IntegerTextField();
//          tciEntryListField[(i-1)*3+1] = intVlanField;
          listPanel.add(new JLabel(fStringMap.getString("CFI") + i ));
//          listPanel.add(intVlanField);
          cfiList[i-1] = new JComboBox(cfiTList);
          listPanel.add(cfiList[i-1]);
          
          intVlanField = new IntegerTextField();
          listPanel.add(new JLabel(fStringMap.getString("802.1p priority") + i ));
          tciEntryListField[(i-1)*2+1] = intVlanField;
          listPanel.add(intVlanField);

        }

        setLayout(new BorderLayout());
        add( new JScrollPane(listPanel));
        
    }
    
    public void initForm(){
            for(int j=1; j<=12;j++){
                tciEntryListField[(j-1)*2].setValueScope(0, 4095);
//                tciEntryListField[(j-1)*3+1].setValueScope(0, 1);
                tciEntryListField[(j-1)*2+1].setValueScope(0, 7);
            }
    }
    
    public void setTciEntryList(byte[] value){
        for(int i=0; i<value.length/2; i++)
        { 
            tciEntryListField[i*2].setValue(((value[i*2]&0x0F)*256)+(value[i*2+1]&0xFF));
            cfiList[i].setSelectedIndex((value[i*2]&0x10)!=0?1:0);
            tciEntryListField[i*2+1].setValue((value[i*2]&0xFF)>>5);
        }
    }
    
    public byte[] getTciEntryList(){
        byte[] b = new byte[24];
        int vid = 0;
        int cfi = 0;
        int priority = 0;
        for(int i=0; i<12; i++){
                byte[] value;
                vid = tciEntryListField[i*2].getValue();
//                cfi = tciEntryListField[i*2+1].getValue();
                cfi = cfiList[i].getSelectedIndex();
                priority = tciEntryListField[i*2+1].getValue();
                value = getByteArray(vid, cfi, priority);
                System.arraycopy(value, 0, b, i*2, value.length);
        }
        
        return b;
    }
    
    public byte[] getByteArray(int vid, int cfi, int priority){
        byte[] b = new byte[2];
        b[1] = (byte)(vid&0x00FF);
        b[0] = (byte)(((vid&0x0F00)>>8)|((cfi<<4)&0x10)|((priority<<5)&0xE0));
        return b;
    }
    
    public void setEnabled(boolean isEnable){
        super.setEnabled(isEnable);
        for(int i = 0; i<tciEntryListField.length; i++)
            tciEntryListField[i].setEnabled(isEnable);
        for(int j = 0; j<cfiList.length; j++)
            cfiList[j].setEnabled(isEnable);
    }
    
    public void setTciEntryFieldEnabled(int tciEntryNumber){
        for(int i=1; i<=tciEntryNumber;i++){
            tciEntryListField[(i-1)*2].setEnabled(true);
//            tciEntryListField[(i-1)*3+1].setEnabled(true);
            cfiList[i-1].setEnabled(true);
            tciEntryListField[(i-1)*2+1].setEnabled(true);
        }
        while(tciEntryNumber<12){
            tciEntryListField[(tciEntryNumber)*2].setEnabled(false);
            tciEntryListField[(tciEntryNumber)*2].setValue(0);
            tciEntryListField[(tciEntryNumber)*2+1].setEnabled(false);
            tciEntryListField[(tciEntryNumber)*2+1].setValue(0);
            cfiList[tciEntryNumber].setEnabled(false);
            cfiList[tciEntryNumber].setSelectedIndex(0);
            tciEntryNumber++;
        }
    }
    
}
