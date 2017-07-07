package com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.base.FormattedField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dot3OnuEtherPortVlanN1Panel extends JPanel implements ActionListener {
    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    private JComboBox vlanNumber = new JComboBox();
    private HexTextField tpidField = new HexTextField(5);
    private IntegerTextField tagField = new IntegerTextField();
    private FormattedField[] sourceFieldList = new FormattedField[20];

    public Dot3OnuEtherPortVlanN1Panel(IApplication app) {
        fApplication = app;
        if(fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }

        init();
        initForm();
    }

    private void init() {
        JPanel targetPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 5, NTLayout.LEFT, NTLayout.TOP, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        targetPanel.setLayout(layout);

        targetPanel.add(new JLabel(fStringMap.getString("target-tpid") + fStringMap.getString("postfix_hex")));
        targetPanel.add(tpidField);
        targetPanel.add(new JLabel(fStringMap.getString("target-tag") + fStringMap.getString("postfix_decimal")));
        targetPanel.add(tagField);
        targetPanel.add(new HSpacer());

        layout = new NTLayout(1, 3, NTLayout.LEFT, NTLayout.TOP, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel numberPanel = new JPanel(layout);

        numberPanel.add(new JLabel(fStringMap.getString("source-vlan-number")));
        for(int i = 1; i < 11; i++) {
            vlanNumber.addItem(i);
        }
        vlanNumber.addActionListener(this);
        numberPanel.add(vlanNumber);
        numberPanel.add(new HSpacer());

        layout = new NTLayout(5, 8, NTLayout.LEFT, NTLayout.TOP, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        JPanel sourcePanel = new JPanel(layout);

        for(int i = 0; i < 10; i++) {
            HexTextField strVlanField = new HexTextField();
            strVlanField.setColumns(5);
            sourceFieldList[i*2] = strVlanField;
            sourcePanel.add(new JLabel(fStringMap.getString("source-tpid") + (i+1) + fStringMap.getString("postfix_hex")));
            sourcePanel.add(strVlanField);

            IntegerTextField intVlanField = new IntegerTextField();
            intVlanField.setColumns(5);
            sourceFieldList[i*2 + 1] = intVlanField;
            sourcePanel.add(new JLabel(fStringMap.getString("source-tag") + (i+1) + fStringMap.getString("postfix_decimal")));
            sourcePanel.add(intVlanField);
        }


        layout = new NTLayout(4, 1, NTLayout.LEFT, NTLayout.TOP, 5, 5);
        setLayout(layout);
        layout.setMargins(6, 10, 6, 10);
        add(targetPanel);
        add(numberPanel);
        add(sourcePanel);
        add(new VSpacer());
//        setPreferredSize(new Dimension(450, 550));
    }

    private void initForm() {
        tpidField.setDefaultString("0");
        tpidField.setLenScope(1, 4);
        tagField.setValueScope(0, 4094);

        for(int i = 0; i < sourceFieldList.length; i++) {
            if(i % 2 == 1) {
                ((IntegerTextField) sourceFieldList[i]).setValueScope(0, 4094);
            }
            if(i % 2 == 0) {
                ((HexTextField) sourceFieldList[i]).setDefaultString("0");
                ((HexTextField) sourceFieldList[i]).setLenScope(1, 4);
            }
        }
    }

    public boolean validateFrom() {
        for(int i = 0; i < sourceFieldList.length; i++) {
            if(i % 2 == 0) {
                int seq = i / 2 + 1;
                String label = fStringMap.getString("source-tpid") + seq + ": ";
                try {
                    Integer theValue = Integer.valueOf(((HexTextField) sourceFieldList[i]).getValue(), 16);
                    if(theValue.intValue() < 0 || theValue.intValue() > 65535) {
                        MessageDialog.showInfoMessageDialog(fApplication, label + fStringMap.getString("Err_hex"));
                        return false;
                    }
                } catch(Exception e) {
                    MessageDialog.showInfoMessageDialog(fApplication, label + fStringMap.getString("Err_hex"));
                    return false;
                }
            } else {

            }
        }
        return true;
    }

    public void setValue(byte[] value) {
        int cursor = 0;
//        vlanNumber.setSelectedItem(value[cursor++]);

        tpidField.setValue(Integer.toHexString(getInt(value[cursor++], value[cursor++])));
        tagField.setValue(getInt(value[cursor++], value[cursor++]));

        try {
        	int position = cursor;
            for(int i = 0; i < sourceFieldList.length / 2; i++) {
                ((HexTextField) sourceFieldList[i * 2]).setValue(Integer.toHexString(getInt(value[cursor++], value[cursor++])));
                ((IntegerTextField) sourceFieldList[i * 2 + 1]).setValue(getInt(value[cursor++], value[cursor++]));
            }
            cursor = position;
            for(int i = sourceFieldList.length / 2 - 1; i >= 0; i--) {
                ((HexTextField) sourceFieldList[i * 2]).setValue(Integer.toHexString(getInt(value[cursor++], value[cursor++])));
                ((IntegerTextField) sourceFieldList[i * 2 + 1]).setValue(getInt(value[cursor++], value[cursor++]));
                if(Integer.valueOf(((HexTextField)sourceFieldList[i * 2]).getValue()) != 0 && 
                		((IntegerTextField)sourceFieldList[i * 2 + 1]).getValue() != 0) {
                	vlanNumber.setSelectedItem(i * 2 + 1);
                	break;
                }
            }
            
//            for(int i = 0; i < sourceFieldList.length; i++) {
//            	if(i % 2 == 0) {
//                    ((HexTextField) sourceFieldList[i]).setValue(Integer.toHexString(getInt(value[cursor++], value[cursor++])));
//                }
//                if(i % 2 == 1) {
//                	((IntegerTextField) sourceFieldList[i]).setValue(getInt(value[cursor++], value[cursor++]));
//                	if(Integer.valueOf(((HexTextField)sourceFieldList[i - 1]).getValue()) != 0 && 
//                    		((IntegerTextField)sourceFieldList[i]).getValue() != 0) {
//                    	vlanNumber.setSelectedItem(i);
//                    	break;
//                    }
//                }
//            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        fireNumberChangedEvent(true);
    }

    public byte[] getValue() {
        byte[] b = new byte[44];

//        Integer number = (Integer)vlanNumber.getSelectedItem();

//        b[3] = (byte)number.intValue();

        byte[] tpid = getByteArray(Integer.valueOf(tpidField.getValue(), 16).intValue());
        System.arraycopy(tpid, 0, b, 0, 2);

        byte[] tag = getByteArray(tagField.getValue());
        System.arraycopy(tag, 0, b, 2, 2);

        for(int i = 0; i < sourceFieldList.length; i++) {
            byte[] value;
            if(i % 2 == 0) {
                value = getByteArray(Integer.valueOf(((HexTextField) sourceFieldList[i]).getValue(), 16).intValue());
            } else {
                value = getByteArray(((IntegerTextField) sourceFieldList[i]).getValue());
            }

            System.arraycopy(value, 0, b, 4 + i * 2, value.length);
        }

        return b;
    }

    private int getInt(byte b1, byte b2) {
        return (b1 & 0xFF) << 8 | (b2 & 0xFF);
    }

    private byte[] getByteArray(int i) {
        byte[] b = new byte[2];
        b[1] = (byte) i;
        i = i >> 8;
        b[0] = (byte) i;
        return b;
    }

    public void setEnabled(boolean b) {
        vlanNumber.setEnabled(b);
        tpidField.setEnabled(b);
        tagField.setEnabled(b);

        if(b) {
        	if(tpidField.getValue()!=null && tpidField.getValue().trim().length() != 0 && Integer.valueOf(tpidField.getValue()) == 0)
        		tpidField.setValue("8100");
        }
        else {
        	tpidField.setValue("0");
        }
        fireNumberChangedEvent(b);
    }

    protected void fireNumberChangedEvent(boolean enabled) {
        Integer number = (Integer)vlanNumber.getSelectedItem();

        for(int i = 0; i < sourceFieldList.length; i++) {
        	boolean blfield = enabled & (i < (number*2));
            sourceFieldList[i].setEnabled(enabled & (i < (number*2)));
            if(sourceFieldList[i] instanceof HexTextField) {
            	if(!blfield) ((HexTextField)sourceFieldList[i]).setValue("0");
            	else if(((HexTextField)sourceFieldList[i]).getValue()!=null && ((HexTextField)sourceFieldList[i]).getValue().equals("0"))
            		((HexTextField)sourceFieldList[i]).setValue("8100");
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        fireNumberChangedEvent(true);
    }
}
