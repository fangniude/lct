package com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.base.FormattedField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;

public class Dot3OnuEtherPortVlanTrunkPanel extends JPanel {
    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    private FormattedField[] vlanFieldList = new FormattedField[32];

    public Dot3OnuEtherPortVlanTrunkPanel(IApplication app) {
        fApplication = app;
        if(fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }

        init();
        initForm();
    }

    private void init() {
        NTLayout layout = new NTLayout(8, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);

        for(int i = 1; i <= 16; i++) {
            HexTextField strVlanField = new HexTextField();
            strVlanField.setColumns(5);
            vlanFieldList[(i - 1) * 2] = strVlanField;
            add(new JLabel(fStringMap.getString("TPID") + i + fStringMap.getString("postfix_hex")));
            add(strVlanField);

            IntegerTextField intVlanField = new IntegerTextField();
            intVlanField.setColumns(5);
            vlanFieldList[(i - 1) * 2 + 1] = intVlanField;
            add(new JLabel(fStringMap.getString("tag") + i + fStringMap.getString("postfix_decimal")));
            add(intVlanField);
        }

//    setPreferredSize(new Dimension(450, 550));
    }

    private void initForm() {
        for(int i = 0; i < vlanFieldList.length; i++) {
            if(i % 2 == 1) {
                ((IntegerTextField) vlanFieldList[i]).setValueScope(0, 4094);
            }
            if(i % 2 == 0) {
                ((HexTextField) vlanFieldList[i]).setDefaultString("0");
                ((HexTextField) vlanFieldList[i]).setLenScope(1, 4);
            }
        }
    }

    public boolean validateFrom() {
        for(int i = 0; i < vlanFieldList.length; i++) {
            if(i % 2 == 0) {
                int seq = i / 2 + 1;
                String label = fStringMap.getString("TPID") + seq + ": ";
                try {
                    Integer theValue = Integer.valueOf(((HexTextField) vlanFieldList[i]).getValue(), 16);
                    if(theValue.intValue() < 0 || theValue.intValue() > 65535) {
                        MessageDialog.showInfoMessageDialog(fApplication, label + fStringMap.getString("Err_hex"));
                        return false;
                    }
                } catch(Exception e) {
                    MessageDialog.showInfoMessageDialog(fApplication, label + fStringMap.getString("Err_hex"));
                    return false;
                }
            }
        }
        return true;
    }

    public void setValue(byte[] value) {
        try {
            if(value != null && value.length > 0) {
                for(int i = 0; i < vlanFieldList.length / 2; i++) {
                    ((HexTextField) vlanFieldList[i * 2]).setValue(Integer.toHexString(getInt(value[i * 4], value[i * 4 + 1])));
                    ((IntegerTextField) vlanFieldList[i * 2 + 1]).setValue(getInt(value[i * 4 + 2], value[i * 4 + 3]));
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getValue() {
        byte[] b = new byte[64];
        for(int i = 0; i < vlanFieldList.length; i++) {
            byte[] value;
            if(i % 2 == 0) {
                value = getByteArray(Integer.valueOf(((HexTextField) vlanFieldList[i]).getValue(), 16).intValue());
            } else {
                value = getByteArray(((IntegerTextField) vlanFieldList[i]).getValue());
            }
            System.arraycopy(value, 0, b, i * 2, value.length);
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
        super.setEnabled(b);

        for(int i = 0; i < vlanFieldList.length; i++) {
            vlanFieldList[i].setEnabled(b);
        }
    }
}
