/**
 * Created by Zhou Chao, 2010/3/15
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniAttributeTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UniAttributeTablePanel extends UPanel {

/*
    private JLabel tfUniAttributeDeviceIndex = new JLabel();
    private JLabel tfUniAttributeCardIndex = new JLabel();
    private JLabel tfUniAttributePortIndex = new JLabel();
*/

    private int[] uniAdminStatusVList = new int[]{1, 2, 3,};
    private String[] uniAdminStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfUniAdminStatus = new JComboBox(uniAdminStatusTList);

/*
    private int[] uniOperationStatusVList = new int[]{1, 2, 3,};
    private String[] uniOperationStatusTList = new String[]{
            fStringMap.getString("up"), //1
            fStringMap.getString("down"), //2
            fStringMap.getString("testing"), //3
    };
    private JComboBox tfUniOperationStatus = new JComboBox(uniOperationStatusTList);

    private int[] uniPerfStats15minuteEnableVList = new int[]{1, 2,};
    private String[] uniPerfStats15minuteEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniPerfStats15minuteEnable = new JComboBox(uniPerfStats15minuteEnableTList);

    private int[] uniPerfStats24hourEnableVList = new int[]{1, 2,};
    private String[] uniPerfStats24hourEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniPerfStats24hourEnable = new JComboBox(uniPerfStats24hourEnableTList);

    private JLabel tfUniLastChangeTime = new JLabel();

    private int[] uniIsolationEnableVList = new int[]{1, 2,};
    private String[] uniIsolationEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniIsolationEnable = new JComboBox(uniIsolationEnableTList);

    private IntegerTextField tfUniMacAddrLearnMaxNum = new IntegerTextField();
*/

    private int[] uniAutoNegotiationEnableVList = new int[]{1, 2,};
    private String[] uniAutoNegotiationEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniAutoNegotiationEnable = new JComboBox(uniAutoNegotiationEnableTList);

    private String[] autoNegoAbilityTList = new String[] {
            fStringMap.getString("tenBaseTFullDuplex"), fStringMap.getString("tenBaseTHalfDuplex"),
            fStringMap.getString("hundredBaseTFullDuplex"), fStringMap.getString("hundredBaseTHalfDuplex"),
            fStringMap.getString("thousandBaseTFullDuplex"), fStringMap.getString("thousandBaseTHalfDuplex"),
            fStringMap.getString("thousandBaseXFullDuplex"), fStringMap.getString("thousandBaseXHalfDuplex"),
            fStringMap.getString("fdxPause"), fStringMap.getString("fdxApause"),
            fStringMap.getString("fdxSpause"), fStringMap.getString("fdxBpause"),
    };
    private JCheckBox[] tfAutoNegoAbility = new JCheckBox[12];
/*
    private final String uniAttributeDeviceIndex = fStringMap.getString("uniAttributeDeviceIndex") + " : ";
    private final String uniAttributeCardIndex = fStringMap.getString("uniAttributeCardIndex") + " : ";
    private final String uniAttributePortIndex = fStringMap.getString("uniAttributePortIndex") + " : ";
*/
    private final String uniAdminStatus = fStringMap.getString("uniAdminStatus") + " : ";
/*
    private final String uniOperationStatus = fStringMap.getString("uniOperationStatus") + " : ";
    private final String uniPerfStats15minuteEnable = fStringMap.getString("uniPerfStats15minuteEnable") + " : ";
    private final String uniPerfStats24hourEnable = fStringMap.getString("uniPerfStats24hourEnable") + " : ";
    private final String uniLastChangeTime = fStringMap.getString("uniLastChangeTime") + " : ";
    private final String uniIsolationEnable = fStringMap.getString("uniIsolationEnable") + " : ";
    private final String uniMacAddrLearnMaxNum = fStringMap.getString("uniMacAddrLearnMaxNum") + " : ";
*/
    private final String uniAutoNegotiationEnable = fStringMap.getString("uniAutoNegotiationEnable") + " : ";
    //private final String uniAutoNegotiationLocalTechAbility = fStringMap.getString("uniAutoNegotiationLocalTechAbility") + " : ";
    //private final String uniAutoNegotiationAdvertisedTechAbility = fStringMap.getString("uniAutoNegotiationAdvertisedTechAbility") + " : ";

    public UniAttributeTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

/*
        baseInfoPanel.add(new JLabel(uniAttributeDeviceIndex));
        baseInfoPanel.add(tfUniAttributeDeviceIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniAttributeCardIndex));
        baseInfoPanel.add(tfUniAttributeCardIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniAttributePortIndex));
        baseInfoPanel.add(tfUniAttributePortIndex);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(uniAdminStatus));
        tfUniAdminStatus.setName(fStringMap.getString("uniAdminStatus"));
        baseInfoPanel.add(tfUniAdminStatus);
        baseInfoPanel.add(new HSpacer());

/*
        baseInfoPanel.add(new JLabel(uniOperationStatus));
        tfUniOperationStatus.setName(fStringMap.getString("uniOperationStatus"));
        baseInfoPanel.add(tfUniOperationStatus);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPerfStats15minuteEnable));
        tfUniPerfStats15minuteEnable.setName(fStringMap.getString("uniPerfStats15minuteEnable"));
        baseInfoPanel.add(tfUniPerfStats15minuteEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPerfStats24hourEnable));
        tfUniPerfStats24hourEnable.setName(fStringMap.getString("uniPerfStats24hourEnable"));
        baseInfoPanel.add(tfUniPerfStats24hourEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniLastChangeTime));
        tfUniLastChangeTime.setName(fStringMap.getString("uniLastChangeTime"));
        baseInfoPanel.add(tfUniLastChangeTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniIsolationEnable));
        tfUniIsolationEnable.setName(fStringMap.getString("uniIsolationEnable"));
        baseInfoPanel.add(tfUniIsolationEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMacAddrLearnMaxNum));
        tfUniMacAddrLearnMaxNum.setName(fStringMap.getString("uniMacAddrLearnMaxNum"));
        baseInfoPanel.add(tfUniMacAddrLearnMaxNum);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(uniAutoNegotiationEnable));
        tfUniAutoNegotiationEnable.setName(fStringMap.getString("uniAutoNegotiationEnable"));
        baseInfoPanel.add(tfUniAutoNegotiationEnable);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(uniAutoNegotiationLocalTechAbility));
        //cbUniAutoNegotiationLocalTechAbility.setName(fStringMap.getString("uniAutoNegotiationLocalTechAbility"));
        //baseInfoPanel.add(cbUniAutoNegotiationLocalTechAbility);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(uniAutoNegotiationAdvertisedTechAbility));
        //cbUniAutoNegotiationAdvertisedTechAbility.setName(fStringMap.getString("uniAutoNegotiationAdvertisedTechAbility"));
        //baseInfoPanel.add(cbUniAutoNegotiationAdvertisedTechAbility);
        //baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(uniAutoNegotiationRestart));
        //tfUniAutoNegotiationRestart.setName(fStringMap.getString("uniAutoNegotiationRestart"));
        //baseInfoPanel.add(tfUniAutoNegotiationRestart);
        //baseInfoPanel.add(new HSpacer());

        JPanel abilityPanel = new JPanel();
        layout = new NTLayout(3, 4, NTLayout.FILL, NTLayout.FILL, 5, 3);
        abilityPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("uniAutoNegotiationAdvertisedTechAbility")));
        abilityPanel.setLayout(layout);
        for(int i = 0; i < tfAutoNegoAbility.length; i++) {
            tfAutoNegoAbility[i] = new JCheckBox(autoNegoAbilityTList[i]);
            abilityPanel.add(tfAutoNegoAbility[i]);
        }

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(abilityPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    public void refresh() {
        UniAttributeTable mbean = (UniAttributeTable) getModel();
        if (mbean == null)
            return;

/*
        tfUniAttributeDeviceIndex.setText(mbean.getUniAttributeDeviceIndex() != null ? mbean.getUniAttributeDeviceIndex().toString() : "");
        tfUniAttributeCardIndex.setText(mbean.getUniAttributeCardIndex() != null ? mbean.getUniAttributeCardIndex().toString() : "");
        tfUniAttributePortIndex.setText(mbean.getUniAttributePortIndex() != null ? mbean.getUniAttributePortIndex().toString() : "");
*/
        tfUniAdminStatus.setSelectedIndex(getIndexFromValue(uniAdminStatusVList, mbean.getUniAdminStatus()));
/*
        tfUniOperationStatus.setSelectedIndex(getIndexFromValue(uniOperationStatusVList, mbean.getUniOperationStatus()));
        tfUniPerfStats15minuteEnable.setSelectedIndex(getIndexFromValue(uniPerfStats15minuteEnableVList, mbean.getUniPerfStats15minuteEnable()));
        tfUniPerfStats24hourEnable.setSelectedIndex(getIndexFromValue(uniPerfStats24hourEnableVList, mbean.getUniPerfStats24hourEnable()));
        tfUniLastChangeTime.setText(mbean.getUniLastChangeTime() != null ? mbean.getUniLastChangeTime().toString() : "");
        tfUniIsolationEnable.setSelectedIndex(getIndexFromValue(uniIsolationEnableVList, mbean.getUniIsolationEnable()));
        tfUniMacAddrLearnMaxNum.setValue(mbean.getUniMacAddrLearnMaxNum());
*/
        tfUniAutoNegotiationEnable.setSelectedIndex(getIndexFromValue(uniAutoNegotiationEnableVList, mbean.getUniAutoNegotiationEnable()));

        //cbUniAutoNegotiationLocalTechAbility.setText(mbean.getUniAutoNegotiationLocalTechAbility());
        //cbUniAutoNegotiationAdvertisedTechAbility.setValue(mbean.getUniAutoNegotiationAdvertisedTechAbility());
        setAutoNegoAbility(mbean.getUniAutoNegotiationAdvertisedTechAbility());
    }

    public void updateModel() {
        UniAttributeTable mbean = (UniAttributeTable) getModel();
        if (mbean == null)
            return;

        mbean.setUniAdminStatus(new Integer(uniAdminStatusVList[tfUniAdminStatus.getSelectedIndex()]));
/*
        mbean.setUniPerfStats15minuteEnable(new Integer(uniPerfStats15minuteEnableVList[tfUniPerfStats15minuteEnable.getSelectedIndex()]));
        mbean.setUniPerfStats24hourEnable(new Integer(uniPerfStats24hourEnableVList[tfUniPerfStats24hourEnable.getSelectedIndex()]));
        mbean.setUniIsolationEnable(new Integer(uniIsolationEnableVList[tfUniIsolationEnable.getSelectedIndex()]));
        mbean.setUniMacAddrLearnMaxNum(new Integer(tfUniMacAddrLearnMaxNum.getValue()));
*/
        mbean.setUniAutoNegotiationEnable(new Integer(uniAutoNegotiationEnableVList[tfUniAutoNegotiationEnable.getSelectedIndex()]));

        //mbean.setUniAutoNegotiationAdvertisedTechAbility(new ? ? (cbUniAutoNegotiationAdvertisedTechAbility.getValue()));
        mbean.setUniAutoNegotiationAdvertisedTechAbility(getAutoNegoAbility());
    }

    byte[] getAutoNegoAbility() {
        byte[] ability = new byte[4];

        for(int i = 0; i < tfAutoNegoAbility.length; i++) {
            int offset = (i + 1) / 8;
            int count = (i + 1) % 8;

            if(tfAutoNegoAbility[i].isSelected()) {
                ability[offset] = (byte)(ability[offset] | (0x80 >> count));
            }
        }

        return ability;
    }

    void setAutoNegoAbility(byte[] ability) {
        if(ability != null) {
            for(int i = 0; i < ability.length; i++) {
                for(int j = 0; j < 8; j++) {
                    int index = i * 8 + j - 1;

                    if(index >= ability.length) {
                        return;
                    }

                    if(index >= 0) {
                        if((ability[i] & (0x80 >> j)) != 0) {
                            tfAutoNegoAbility[index].setSelected(true);
                        } else {
                            tfAutoNegoAbility[index].setSelected(false);
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