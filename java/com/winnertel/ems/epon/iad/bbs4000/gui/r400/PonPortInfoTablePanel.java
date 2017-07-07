/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PonPortInfoTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class PonPortInfoTablePanel extends UPanel {

/*
    private JLabel tfPonDeviceIndex = new JLabel();
    private JLabel tfPonCardIndex = new JLabel();
    private JLabel tfPonPortIndex = new JLabel();

    private int[] ponPortTypeVList = new int[]{1, 2, 3, 4,};
    private String[] ponPortTypeTList = new String[]{
            fStringMap.getString("ge-epon"), //1
            fStringMap.getString("tenge-epon"), //2
            fStringMap.getString("gpon"), //3
            fStringMap.getString("other"), //4
    };
    private JComboBox tfPonPortType = new JComboBox(ponPortTypeTList);

    private int[] ponOperationStatusVList = new int[]{1, 2, 3,};
    private String[] ponOperationStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfPonOperationStatus = new JComboBox(ponOperationStatusTList);
*/

    private int[] ponPortAdminStatusVList = new int[]{1, 2, 3,};
    private String[] ponPortAdminStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfPonPortAdminStatus = new JComboBox(ponPortAdminStatusTList);

/*
    private JLabel tfPonPortMaxOnuNumSupport = new JLabel();
    private JLabel tfPonPortUpOnuNum = new JLabel();
*/

    private int[] ponPortEncryptModeVList = new int[]{1, 2, 3,};
    private String[] ponPortEncryptModeTList = new String[]{
            fStringMap.getString("aes128"), //1
            fStringMap.getString("ctcTripleChurning"), //2
            fStringMap.getString("other"), //3
    };
    private JComboBox tfPonPortEncryptMode = new JComboBox(ponPortEncryptModeTList);

    private IntegerTextField tfPonPortEncryptKeyExchangeTime = new IntegerTextField();

    private int[] ponPortIsolationEnableVList = new int[]{1, 2,};
    private String[] ponPortIsolationEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfPonPortIsolationEnable = new JComboBox(ponPortIsolationEnableTList);

    //private IntegerTextField tfMaxBandwidth = new IntegerTextField();
    //private JLabel tfActualBandwidthInUse = new JLabel();
    //private JLabel tfRemainBandwidth = new JLabel();

    private int[] perfStats15minuteEnableVList = new int[]{1, 2,};
    private String[] perfStats15minuteEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfPerfStats15minuteEnable = new JComboBox(perfStats15minuteEnableTList);

    private int[] perfStats24hourEnableVList = new int[]{1, 2,};
    private String[] perfStats24hourEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfPerfStats24hourEnable = new JComboBox(perfStats24hourEnableTList);

    private IntegerTextField tfPonPortMacAddrLearnMaxNum = new IntegerTextField();

/*
    private final String ponDeviceIndex = fStringMap.getString("ponDeviceIndex") + " : ";
    private final String ponCardIndex = fStringMap.getString("ponCardIndex") + " : ";
    private final String ponPortIndex = fStringMap.getString("ponPortIndex") + " : ";
    private final String ponPortType = fStringMap.getString("ponPortType") + " : ";
    private final String ponOperationStatus = fStringMap.getString("ponOperationStatus") + " : ";
*/
    private final String ponPortAdminStatus = fStringMap.getString("ponPortAdminStatus") + " : ";
/*
    private final String ponPortMaxOnuNumSupport = fStringMap.getString("ponPortMaxOnuNumSupport") + " : ";
    private final String ponPortUpOnuNum = fStringMap.getString("ponPortUpOnuNum") + " : ";
*/
    private final String ponPortEncryptMode = fStringMap.getString("ponPortEncryptMode") + " : ";
    private final String ponPortEncryptKeyExchangeTime = fStringMap.getString("ponPortEncryptKeyExchangeTime") + " : ";
    private final String ponPortIsolationEnable = fStringMap.getString("ponPortIsolationEnable") + " : ";
    //private final String maxBandwidth = fStringMap.getString("maxBandwidth") + " : ";
    //private final String actualBandwidthInUse = fStringMap.getString("actualBandwidthInUse") + " : ";
    //private final String remainBandwidth = fStringMap.getString("remainBandwidth") + " : ";
    private final String perfStats15minuteEnable = fStringMap.getString("perfStats15minuteEnable") + " : ";
    private final String perfStats24hourEnable = fStringMap.getString("perfStats24hourEnable") + " : ";
    private final String ponPortMacAddrLearnMaxNum = fStringMap.getString("ponPortMacAddrLearnMaxNum") + " : ";

    public PonPortInfoTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

/*
        baseInfoPanel.add(new JLabel(ponDeviceIndex));
        baseInfoPanel.add(tfPonDeviceIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponCardIndex));
        baseInfoPanel.add(tfPonCardIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponPortIndex));
        baseInfoPanel.add(tfPonPortIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponPortType));
        baseInfoPanel.add(tfPonPortType);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponOperationStatus));
        baseInfoPanel.add(tfPonOperationStatus);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(ponPortAdminStatus));
        tfPonPortAdminStatus.setName(fStringMap.getString("ponPortAdminStatus"));
        baseInfoPanel.add(tfPonPortAdminStatus);
        baseInfoPanel.add(new HSpacer());

/*
        baseInfoPanel.add(new JLabel(ponPortMaxOnuNumSupport));
        baseInfoPanel.add(tfPonPortMaxOnuNumSupport);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponPortUpOnuNum));
        baseInfoPanel.add(tfPonPortUpOnuNum);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(ponPortEncryptMode));
        tfPonPortEncryptMode.setName(fStringMap.getString("ponPortEncryptMode"));
        baseInfoPanel.add(tfPonPortEncryptMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponPortEncryptKeyExchangeTime));
        tfPonPortEncryptKeyExchangeTime.setName(fStringMap.getString("ponPortEncryptKeyExchangeTime"));
        baseInfoPanel.add(tfPonPortEncryptKeyExchangeTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponPortIsolationEnable));
        tfPonPortIsolationEnable.setName(fStringMap.getString("ponPortIsolationEnable"));
        baseInfoPanel.add(tfPonPortIsolationEnable);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(maxBandwidth));
        //tfMaxBandwidth.setName(fStringMap.getString("maxBandwidth"));
        //baseInfoPanel.add(tfMaxBandwidth);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(actualBandwidthInUse));
        //baseInfoPanel.add(tfActualBandwidthInUse);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(remainBandwidth));
        //baseInfoPanel.add(tfRemainBandwidth);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(perfStats15minuteEnable));
        tfPerfStats15minuteEnable.setName(fStringMap.getString("perfStats15minuteEnable"));
        baseInfoPanel.add(tfPerfStats15minuteEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(perfStats24hourEnable));
        tfPerfStats24hourEnable.setName(fStringMap.getString("perfStats24hourEnable"));
        baseInfoPanel.add(tfPerfStats24hourEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(ponPortMacAddrLearnMaxNum));
        tfPonPortMacAddrLearnMaxNum.setName(fStringMap.getString("ponPortMacAddrLearnMaxNum"));
        baseInfoPanel.add(tfPonPortMacAddrLearnMaxNum);
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
        PonPortInfoTable mbean = (PonPortInfoTable) getModel();
        if (mbean == null)
            return;

/*
        tfPonDeviceIndex.setText(mbean.getPonDeviceIndex() != null ? mbean.getPonDeviceIndex().toString() : "");
        tfPonCardIndex.setText(mbean.getPonCardIndex() != null ? mbean.getPonCardIndex().toString() : "");
        tfPonPortIndex.setText(mbean.getPonPortIndex() != null ? mbean.getPonPortIndex().toString() : "");
        tfPonPortType.setSelectedIndex(getIndexFromValue(ponPortTypeVList, mbean.getPonPortType()));
        tfPonOperationStatus.setSelectedIndex(getIndexFromValue(ponOperationStatusVList, mbean.getPonOperationStatus()));
*/
        tfPonPortAdminStatus.setSelectedIndex(getIndexFromValue(ponPortAdminStatusVList, mbean.getPonPortAdminStatus()));
/*
        tfPonPortMaxOnuNumSupport.setText(mbean.getPonPortMaxOnuNumSupport() != null ? mbean.getPonPortMaxOnuNumSupport().toString() : "");
        tfPonPortUpOnuNum.setText(mbean.getPonPortUpOnuNum() != null ? mbean.getPonPortUpOnuNum().toString() : "");
*/
        tfPonPortEncryptMode.setSelectedIndex(getIndexFromValue(ponPortEncryptModeVList, mbean.getPonPortEncryptMode()));
        tfPonPortEncryptKeyExchangeTime.setValue(mbean.getPonPortEncryptKeyExchangeTime());
        tfPonPortIsolationEnable.setSelectedIndex(getIndexFromValue(ponPortIsolationEnableVList, mbean.getPonPortIsolationEnable()));
        //tfMaxBandwidth.setValue(mbean.getMaxBandwidth());
        //tfActualBandwidthInUse.setText(mbean.getActualBandwidthInUse() != null ? mbean.getActualBandwidthInUse().toString() : "");
        //tfRemainBandwidth.setText(mbean.getRemainBandwidth() != null ? mbean.getRemainBandwidth().toString() : "");
        tfPerfStats15minuteEnable.setSelectedIndex(getIndexFromValue(perfStats15minuteEnableVList, mbean.getPerfStats15minuteEnable()));
        tfPerfStats24hourEnable.setSelectedIndex(getIndexFromValue(perfStats24hourEnableVList, mbean.getPerfStats24hourEnable()));
        tfPonPortMacAddrLearnMaxNum.setValue(mbean.getPonPortMacAddrLearnMaxNum());
    }

    public void updateModel() {
        PonPortInfoTable mbean = (PonPortInfoTable) getModel();
        if (mbean == null)
            return;

        mbean.setPonPortAdminStatus(new Integer(ponPortAdminStatusVList[tfPonPortAdminStatus.getSelectedIndex()]));
        mbean.setPonPortEncryptMode(new Integer(ponPortEncryptModeVList[tfPonPortEncryptMode.getSelectedIndex()]));
        mbean.setPonPortEncryptKeyExchangeTime(new Integer(tfPonPortEncryptKeyExchangeTime.getValue()));
        mbean.setPonPortIsolationEnable(new Integer(ponPortIsolationEnableVList[tfPonPortIsolationEnable.getSelectedIndex()]));
        //mbean.setMaxBandwidth(new Integer(tfMaxBandwidth.getValue()));
        mbean.setPerfStats15minuteEnable(new Integer(perfStats15minuteEnableVList[tfPerfStats15minuteEnable.getSelectedIndex()]));
        mbean.setPerfStats24hourEnable(new Integer(perfStats24hourEnableVList[tfPerfStats24hourEnable.getSelectedIndex()]));
        mbean.setPonPortMacAddrLearnMaxNum(new Integer(tfPonPortMacAddrLearnMaxNum.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}