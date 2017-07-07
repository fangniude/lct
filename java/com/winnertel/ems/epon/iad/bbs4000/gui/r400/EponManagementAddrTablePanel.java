/**
 * Created by Zhou Chao, 2010/5/13
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.EponManagementAddrTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class EponManagementAddrTablePanel extends UPanel {

//    private StringTextField tfEponManagementAddrName = new StringTextField();
    private IPAddressField tfEponManagementAddrTAddress = new IPAddressField();
    private IntegerTextField tfEponManagementAddrTPort = new IntegerTextField();
    private StringTextField tfEponManagementAddrCommunity = new StringTextField();

    private final String eponManagementAddrName = fStringMap.getString("eponManagementAddrName") + " : ";
    private final String eponManagementAddrTAddress = fStringMap.getString("eponManagementAddrTAddress") + " : ";
    private final String eponManagementAddrTPort = fStringMap.getString("eponManagementAddrTPort") + " : ";
    private final String eponManagementAddrCommunity = fStringMap.getString("eponManagementAddrCommunity") + " : ";

    public EponManagementAddrTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

//        baseInfoPanel.add(new JLabel(eponManagementAddrName));
//        baseInfoPanel.add(tfEponManagementAddrName);
//        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(eponManagementAddrTAddress));
        tfEponManagementAddrTAddress.setName(fStringMap.getString("eponManagementAddrTAddress"));
        baseInfoPanel.add(tfEponManagementAddrTAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(eponManagementAddrTPort));
        tfEponManagementAddrTPort.setName(fStringMap.getString("eponManagementAddrTPort"));
        baseInfoPanel.add(tfEponManagementAddrTPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(eponManagementAddrCommunity));
        tfEponManagementAddrCommunity.setName(fStringMap.getString("eponManagementAddrCommunity"));
        baseInfoPanel.add(tfEponManagementAddrCommunity);
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
        tfEponManagementAddrTPort.setDefaultValue(162);
        tfEponManagementAddrCommunity.setLenScope(0, 64);
    }

    public void refresh() {
//        if (SnmpAction.IType.ADD.equals(fCommand)) {
//            tfEponManagementAddrName.setEditable(true);
//            return;
//        } else {
//            tfEponManagementAddrName.setEditable(false);
//        }

        EponManagementAddrTable mbean = (EponManagementAddrTable) getModel();
        if (mbean == null)
            return;

//        tfEponManagementAddrName.setText(mbean.getEponManagementAddrName());

        byte[] data = mbean.getEponManagementAddrTAddress();
        if (data != null && data.length >= 8) {
            tfEponManagementAddrTAddress.setValue(formatDotString(data, 0, 4));
            tfEponManagementAddrTPort.setValue(formatInteger(data, 4, 4));
        }

        tfEponManagementAddrCommunity.setValue(mbean.getEponManagementAddrCommunity());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new EponManagementAddrTable(fApplication.getSnmpProxy()));

        EponManagementAddrTable mbean = (EponManagementAddrTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
//            mbean.setEponManagementAddrName(tfEponManagementAddrName.getValue());
            mbean.setEponManagementAddrName(tfEponManagementAddrTAddress.getIPString());
        }

        byte[] tAddress = tfEponManagementAddrTAddress.getValue();
        byte[] tPort = transformInteger(tfEponManagementAddrTPort.getValue(), 4);
        byte[] data = new byte[8];
        System.arraycopy(tAddress, 0, data, 0, 4);
        System.arraycopy(tPort, 0, data, 4, 4);
        mbean.setEponManagementAddrTAddress(data);

        mbean.setEponManagementAddrCommunity(tfEponManagementAddrCommunity.getValue());
    }

    private String formatDotString(byte[] value, int start, int len) {
        if (value == null)
            return "";

        StringBuffer sb = new StringBuffer();
        for (int i = start; (i < (start + len)) && (i < value.length); i++) {
            int bi = value[i] & 0xff;
            sb.append(bi);
            if (i < len - 1) {
                sb.append(".");
            }
        }

        return sb.toString();
    }


    private int formatInteger(byte[] value, int start, int len) {
        if (value == null)
            return 0;

        int n = 0;
        for (int i = start; (i < (start + len)) && (i < value.length); i++) {
            int bi = value[i] & 0xff;
            n += bi;
        }

        return n;
    }

    private byte[] transformInteger(int value, int size) {
        if (size <= 0)
            return null;

        byte[] b = new byte[size];

        int n = value;
        for (int i = 0; i < size; i++) {
            b[size - i - 1] = (byte) (n & 0xff);
            n = n >> 8;
        }

        return b;
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}