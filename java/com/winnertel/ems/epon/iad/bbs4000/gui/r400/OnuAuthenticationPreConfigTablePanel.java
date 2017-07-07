/**
 * Created by Zhou Chao, 2010/7/6
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuAuthenticationPreConfigTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuAuthenticationPreConfigTablePanel extends UPanel {

    private StringTextField tfOnuAuthenOnuId = new StringTextField();

    private MacAddressField tfOnuAuthenMacAddress = new MacAddressField();

    private int[] onuAuthenActionVList = new int[]{1, 2,};
    private String[] onuAuthenActionTList = new String[]{
            fStringMap.getString("accept"),
            fStringMap.getString("reject"),
    };
    private JComboBox tfOnuAuthenAction = new JComboBox(onuAuthenActionTList);

    private final String onuAuthenOnuId = fStringMap.getString("onuAuthenOnuId") + " : ";
    private final String onuAuthenMacAddress = fStringMap.getString("onuAuthenMacAddress") + " : ";
    private final String onuAuthenAction = fStringMap.getString("onuAuthenAction") + " : ";

    public OnuAuthenticationPreConfigTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuAuthenOnuId));
        baseInfoPanel.add(tfOnuAuthenOnuId);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuAuthenMacAddress));
        tfOnuAuthenMacAddress.setName(fStringMap.getString("onuAuthenMacAddress"));
        baseInfoPanel.add(tfOnuAuthenMacAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuAuthenAction));
        tfOnuAuthenAction.setName(fStringMap.getString("onuAuthenAction"));
        baseInfoPanel.add(tfOnuAuthenAction);
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
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuAuthenOnuId.setEditable(true);
            return;
        } else {
            tfOnuAuthenOnuId.setEditable(false);
        }

        OnuAuthenticationPreConfigTable mbean = (OnuAuthenticationPreConfigTable) getModel();
        if (mbean == null)
            return;

        String eponDeviceIndex = formatEponDeviceIndex(mbean.getOnuAuthenOnuId());
        tfOnuAuthenOnuId.setValue(eponDeviceIndex);

        tfOnuAuthenMacAddress.setValue(mbean.getOnuAuthenMacAddress());

        tfOnuAuthenAction.setSelectedIndex(getIndexFromValue(onuAuthenActionVList, mbean.getOnuAuthenAction()));
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new OnuAuthenticationPreConfigTable(fApplication.getSnmpProxy()));

        OnuAuthenticationPreConfigTable mbean = (OnuAuthenticationPreConfigTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            int eponDeviceIndex = convertEponDeviceIndex(tfOnuAuthenOnuId.getValue());
            mbean.setOnuAuthenOnuId(eponDeviceIndex);
        }

        mbean.setOnuAuthenMacAddress(tfOnuAuthenMacAddress.getValue());

        mbean.setOnuAuthenAction(new Integer(onuAuthenActionVList[tfOnuAuthenAction.getSelectedIndex()]));
    }

    private String formatEponDeviceIndex(int index) {
        StringBuffer sb = new StringBuffer();

        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[array.length - 1 - i] = index & 0xFF;
            index = index >> 8;
        }

        if (array[1] == 0x3F)
            return "lg" + array[2];

        if (array[0] > 0) {
            sb.append(array[0]).append("/");
        }

        sb.append(array[1]).append("/").append(array[2]);

        if (array[3] != 0) {
            sb.append("/").append(array[3]);
        }

        return sb.toString();
    }

    private int convertEponDeviceIndex(String index) {
        int instance = 0;

        int[] array = new int[4];
        if (index != null && index.length() > 0) {
            if (index.startsWith("lg")) {
                array[1] = 0x3F;
            } else {
                String[] indexes = index.split("/");
                if (indexes != null && indexes.length > 0) {
                    for (int i = 0; i < array.length; i++) {
                        if (indexes.length > i)
                            array[i] = Integer.parseInt(indexes[i]) & 0xFF;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            instance += ((array[array.length - 1 - i] & 0xFF) << (i * 8));
        }

        return instance;
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}