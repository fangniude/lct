/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.ControlledMulticastPackageTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.ControlledMulticastUserAuthorityTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ControlledMulticastUserAuthorityTablePanel extends UPanel {
    EponDeviceIndexPanel deviceIndex = new EponDeviceIndexPanel(fStringMap,fApplication);
    private JCheckBox[] tfMulticastPackageList = null;
    private LongTextField tfIgmpGlobalBW = new LongTextField();

    JPanel proxyListPanel = new JPanel();

    private final String igmpGlobalBW = fStringMap.getString("igmpGlobalBW") + " : ";

    public ControlledMulticastUserAuthorityTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(igmpGlobalBW));
        tfIgmpGlobalBW.setName(fStringMap.getString("igmpGlobalBW"));
        baseInfoPanel.add(tfIgmpGlobalBW);
        baseInfoPanel.add(new HSpacer());

        layout = new NTLayout(5, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        proxyListPanel.setLayout(layout);
        proxyListPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("multicastPackageList")));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(deviceIndex);
        allPanel.add(baseInfoPanel);
        allPanel.add(proxyListPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        deviceIndex.initData();
    }

    public void refresh() {
        ControlledMulticastPackageTable packageTable = new ControlledMulticastPackageTable(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, packageTable);

        tfMulticastPackageList = new JCheckBox[list.size()];
        proxyListPanel.removeAll();

        int row = list.size()/4 + 1;

        NTLayout layout = new NTLayout(row, 4, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        proxyListPanel.setLayout(layout);
        
        for(int i = 0; i < list.size(); i++) {
            ControlledMulticastPackageTable one = (ControlledMulticastPackageTable)list.get(i);
            tfMulticastPackageList[i] = new JCheckBox(String.valueOf(one.getCmIndex()));

            proxyListPanel.add(tfMulticastPackageList[i]);

//            if(i % 4 == 3) {
//                proxyListPanel.add(new HSpacer());
//            }
        }

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            deviceIndex.setEnabled(true);
            return;
        } else {
            deviceIndex.setEnabled(false);
        }

        ControlledMulticastUserAuthorityTable mbean = (ControlledMulticastUserAuthorityTable) getModel();
        if (mbean == null)
            return;

        deviceIndex.setEponDeviceIndex(mbean.getCmDeviceIndex());
        deviceIndex.setOnuCardId(mbean.getCmCardIndex());
        deviceIndex.setOnuPortId(mbean.getCmPortIndex());
        setProxyList(mbean.getMulticastPackageList());
        tfIgmpGlobalBW.setValue(mbean.getIgmpGlobalBW());
    }

    public boolean validateFrom() {
        if (SnmpAction.IType.ADD.equals(fCommand)){
            if (!deviceIndex.validateFrom()){
                return false;
            }
        }

        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new ControlledMulticastUserAuthorityTable(fApplication.getSnmpProxy()));
        }

        ControlledMulticastUserAuthorityTable mbean = (ControlledMulticastUserAuthorityTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setCmDeviceIndex(deviceIndex.getEponDeviceIndex());
            mbean.setCmCardIndex((int)deviceIndex.getOnuCardId());
            mbean.setCmPortIndex(deviceIndex.getOnuPortId());
        }

        mbean.setMulticastPackageList(getProxyList());
        mbean.setIgmpGlobalBW(tfIgmpGlobalBW.getValue());
    }

    byte[] getProxyList() {
        byte[] value = new byte[100];

        for(int i = 0; i < tfMulticastPackageList.length; i++) {
            if (!tfMulticastPackageList[i].isSelected()) continue;
            int proxy = Integer.parseInt(tfMulticastPackageList[i].getText());

            int offset = (proxy-1)/8;
            int count = (proxy-1)%8;

            value[offset] += (0x80 >> count);
        }

        return value;
    }

    void setProxyList(byte[] value) {
        for(int i = 0; i < tfMulticastPackageList.length; i++) {
            tfMulticastPackageList[i].setSelected(false);
        }

        for(int i = 0; i < value.length; i++) {
            for(int j = 0; j < 8; j++) {
                if((value[i] & (0x80>>j)) != 0) {
                    String proxy = String.valueOf(i*8 + j + 1);
                    int offset = 0;
                    for(; offset < tfMulticastPackageList.length; offset++) {
                        if(tfMulticastPackageList[offset].getText().equals(proxy)) {
                            tfMulticastPackageList[offset].setSelected(true);
                        }
                    }
                }
            }
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}