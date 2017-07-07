package com.winnertel.ems.epon.iad.bbs4000.gui.r221.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;

public class ServerSlaQueueItemPanel extends JPanel {
    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    private JComboBox[] queueList = new JComboBox[8];

    public ServerSlaQueueItemPanel(IApplication app) {
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
//        setBorder(BorderFactory.createEtchedBorder());

        Integer[] valueList = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
        for(int i = 0; i < 8; i++) {

            queueList[i] = new JComboBox(valueList);
            add(new JLabel(fStringMap.getString("queue") + i));
            add(queueList[i]);
        }

//        setPreferredSize(new Dimension(450, 550));
    }

    private void initForm() {
    }

    public boolean validateFrom() {
        return true;
    }

    public void setValue(byte[] value) {
        for(int i = 0; i < value.length; i++) {
            queueList[i].setSelectedItem(value[i]);
        }
    }

    public byte[] getValue() {
        byte[] b = new byte[8];
        for(int i = 0; i < queueList.length; i++) {
            Integer queue = (Integer)queueList[i].getSelectedItem();

            if(queue != null) {
                b[i] = queue.byteValue();
            }
        }

        return b;
    }

    public void setEnabled(int number) {
        for(int i = 0; i < queueList.length; i++) {
            queueList[i].setEnabled(i < number);
        }
    }
}
