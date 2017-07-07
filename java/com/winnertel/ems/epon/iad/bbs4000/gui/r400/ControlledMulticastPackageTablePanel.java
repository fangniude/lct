/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.ControlledMulticastPackageTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.IgmpProxyParaTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ControlledMulticastPackageTablePanel extends UPanel {

    private IntegerTextField tfCmIndex = new IntegerTextField();

    private StringTextField tfCmName = new StringTextField();
    private JCheckBox[] tfCmProxyList = null;

    private int[] multicastUserAuthorityVList = new int[]{
            1, 2, 3,};
    private String[] multicastUserAuthorityTList = new String[]{
            fStringMap.getString("permit"), //1
            fStringMap.getString("preview"), //2
            fStringMap.getString("deny"), //3
    };
    private JComboBox tfMulticastUserAuthority = new JComboBox(multicastUserAuthorityTList);

    private IntegerTextField tfMaxRequestChannelNum = new IntegerTextField();
    private IntegerTextField tfSinglePreviewTime = new IntegerTextField();
    private IntegerTextField tfTotalPreviewTime = new IntegerTextField();
    private IntegerTextField tfPreviewResetTime = new IntegerTextField();
    private IntegerTextField tfPreviewCount = new IntegerTextField();

    JPanel proxyListPanel = new JPanel();

    private final String cmIndex = fStringMap.getString("cmIndex") + " : ";
    private final String cmName = fStringMap.getString("cmName") + " : ";
//    private final String cmProxyList = fStringMap.getString("cmProxyList") + " : ";
    private final String multicastUserAuthority = fStringMap.getString("multicastUserAuthority") + " : ";
    private final String maxRequestChannelNum = fStringMap.getString("maxRequestChannelNum") + " : ";
    private final String singlePreviewTime = fStringMap.getString("singlePreviewTime") + " : ";
    private final String totalPreviewTime = fStringMap.getString("totalPreviewTime") + " : ";
    private final String previewResetTime = fStringMap.getString("previewResetTime") + " : ";
    private final String previewCount = fStringMap.getString("previewCount") + " : ";

    public ControlledMulticastPackageTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(8, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(10, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(cmIndex));
        baseInfoPanel.add(tfCmIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(cmName));
        tfCmName.setName(fStringMap.getString("cmName"));
        baseInfoPanel.add(tfCmName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastUserAuthority));
        tfMulticastUserAuthority.setName(fStringMap.getString("multicastUserAuthority"));
        baseInfoPanel.add(tfMulticastUserAuthority);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(maxRequestChannelNum));
        tfMaxRequestChannelNum.setName(fStringMap.getString("maxRequestChannelNum"));
        baseInfoPanel.add(tfMaxRequestChannelNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(singlePreviewTime));
        tfSinglePreviewTime.setName(fStringMap.getString("singlePreviewTime"));
        baseInfoPanel.add(tfSinglePreviewTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(totalPreviewTime));
        tfTotalPreviewTime.setName(fStringMap.getString("totalPreviewTime"));
        baseInfoPanel.add(tfTotalPreviewTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(previewResetTime));
        tfPreviewResetTime.setName(fStringMap.getString("previewResetTime"));
        baseInfoPanel.add(tfPreviewResetTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(previewCount));
        tfPreviewCount.setName(fStringMap.getString("previewCount"));
        baseInfoPanel.add(tfPreviewCount);
        baseInfoPanel.add(new HSpacer());

        layout = new NTLayout(5, 4, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        proxyListPanel.setLayout(layout);
        proxyListPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("cmProxyList")));

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(proxyListPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfCmName.setLenScope(0, 256);
    }

    public void refresh() {
        IgmpProxyParaTable proxy = new IgmpProxyParaTable(fApplication.getSnmpProxy());
        Vector list = BeanService.refreshTableBean(fApplication, proxy);

        tfCmProxyList = new JCheckBox[list.size()];
        proxyListPanel.removeAll();

        int row = list.size()/4 + 1;

        NTLayout layout = new NTLayout(row, 4, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        proxyListPanel.setLayout(layout);

        for(int i = 0; i < list.size(); i++) {
            IgmpProxyParaTable one = (IgmpProxyParaTable)list.get(i);
            tfCmProxyList[i] = new JCheckBox(String.valueOf(one.getProxyIndex()));

            proxyListPanel.add(tfCmProxyList[i]);

//            if(i % 4 == 3) {
//                proxyListPanel.add(new HSpacer());
//            }
        }

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfCmIndex.setEditable(true);
            return;
        } else {
            tfCmIndex.setEditable(false);
        }

        ControlledMulticastPackageTable mbean = (ControlledMulticastPackageTable) getModel();
        if (mbean == null)
            return;

        tfCmIndex.setValue(mbean.getCmIndex());

        tfCmName.setValue(mbean.getCmName());
        setProxyList(mbean.getCmProxyList());
        tfMulticastUserAuthority.setSelectedIndex(getIndexFromValue(multicastUserAuthorityVList, mbean.getMulticastUserAuthority()));
        tfMaxRequestChannelNum.setValue(mbean.getMaxRequestChannelNum());
        tfSinglePreviewTime.setValue(mbean.getSinglePreviewTime());
        tfTotalPreviewTime.setValue(mbean.getTotalPreviewTime());
        tfPreviewResetTime.setValue(mbean.getPreviewResetTime());
        tfPreviewCount.setValue(mbean.getPreviewCount());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new ControlledMulticastPackageTable(fApplication.getSnmpProxy()));

        ControlledMulticastPackageTable mbean = (ControlledMulticastPackageTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setCmIndex(new Integer(tfCmIndex.getValue()));
        }

        mbean.setCmName(tfCmName.getValue());
        mbean.setCmProxyList(getProxyList());
        mbean.setMulticastUserAuthority(new Integer(multicastUserAuthorityVList[tfMulticastUserAuthority.getSelectedIndex()]));
        mbean.setMaxRequestChannelNum(new Integer(tfMaxRequestChannelNum.getValue()));
        mbean.setSinglePreviewTime(new Integer(tfSinglePreviewTime.getValue()));
        mbean.setTotalPreviewTime(new Integer(tfTotalPreviewTime.getValue()));
        mbean.setPreviewResetTime(new Integer(tfPreviewResetTime.getValue()));
        mbean.setPreviewCount(new Integer(tfPreviewCount.getValue()));
    }

    byte[] getProxyList() {
        byte[] value = new byte[100];

        for(int i = 0; i < tfCmProxyList.length; i++) {
            if (!tfCmProxyList[i].isSelected()) continue;
            int proxy = Integer.parseInt(tfCmProxyList[i].getText());

            int offset = (proxy-1)/8;
            int count = (proxy-1)%8;

            value[offset] += (0x80 >> count);
        }

        return value;
    }

    void setProxyList(byte[] value) {
        for(int i = 0; i < tfCmProxyList.length; i++) {
            tfCmProxyList[i].setSelected(false);
        }

        for(int i = 0; i < value.length; i++) {
            for(int j = 0; j < 8; j++) {
                if((value[i] & (0x80>>j)) != 0) {
                    String proxy = String.valueOf(i*8 + j + 1);
                    int offset = 0;
                    for(; offset < tfCmProxyList.length; offset++) {
                        if(tfCmProxyList[offset].getText().equals(proxy)) {
                            tfCmProxyList[offset].setSelected(true);
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