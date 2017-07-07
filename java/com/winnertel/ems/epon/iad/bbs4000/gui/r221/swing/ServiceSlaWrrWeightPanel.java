package com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;

public class ServiceSlaWrrWeightPanel extends JPanel {
    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    private IntegerTextField[] fieldList = new IntegerTextField[8];

    public ServiceSlaWrrWeightPanel(IApplication app) {
        fApplication = app;
        if(fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }

        init();
        initForm();
    }

    private void init() {
        NTLayout layout = new NTLayout(2, 8, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        setBorder(BorderFactory.createEtchedBorder());

        for(int i = 0; i < 8; i++) {
            fieldList[i] = new IntegerTextField();
            fieldList[i].setValueScope(0, 100);
            add(new JLabel(fStringMap.getString("queue") + i));
            add(fieldList[i]);
        }

//        setPreferredSize(new Dimension(450, 550));
    }

    private void initForm() {
    }

    public boolean validateFrom() {
        return true;
    }

    public void setValue(byte[] value) {
        try {
            for(int i = 0; value!=null && value.length!=0 && i < fieldList.length; i++) {
                fieldList[i].setValue(value[i]);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getValue() {
        byte[] b = new byte[8];
        for(int i = 0; i < fieldList.length; i++) {
            int value = fieldList[i].getValue();
            b[i] = (byte) (value);
        }

        return b;
    }

    private int getInt(byte b1, byte b2) {
        return (b1 & 0xFF) << 8 | (b2 & 0xFF);
    }

    public void setEnabled(int number) {
        for(int i = 0; i < fieldList.length; i++) {
            fieldList[i].setEnabled(i < number);
        }
    }
}