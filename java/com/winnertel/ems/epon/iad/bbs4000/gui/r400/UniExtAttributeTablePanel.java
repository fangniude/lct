/**
 * Created by Zhou Chao, 2010/6/22
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniExtAttributeTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UniExtAttributeTablePanel extends UPanel {
    private JLabel tfUniExtAttributeCardIndex = new JLabel();
    private JLabel tfUniExtAttributePortIndex = new JLabel();
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

/*
    private JLabel tfUniLastChangeTime = new JLabel();
*/

    private int[] uniIsolationEnableVList = new int[]{1, 2,};
    private String[] uniIsolationEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniIsolationEnable = new JComboBox(uniIsolationEnableTList);

    private IntegerTextField tfUniMacAddrLearnMaxNum = new IntegerTextField();

    private final String uniExtAttributeCardIndex = fStringMap.getString("uniExtAttributeCardIndex") + " : ";
    private final String uniExtAttributePortIndex = fStringMap.getString("uniExtAttributePortIndex") + " : ";
    private final String uniPerfStats15minuteEnable = fStringMap.getString("uniPerfStats15minuteEnable") + " : ";
    private final String uniPerfStats24hourEnable = fStringMap.getString("uniPerfStats24hourEnable") + " : ";
/*
    private final String uniLastChangeTime = fStringMap.getString("uniLastChangeTime") + " : ";
*/
    private final String uniIsolationEnable = fStringMap.getString("uniIsolationEnable") + " : ";
    private final String uniMacAddrLearnMaxNum = fStringMap.getString("uniMacAddrLearnMaxNum") + " : ";

    public UniExtAttributeTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());


        baseInfoPanel.add(new JLabel(uniExtAttributeCardIndex));
        baseInfoPanel.add(tfUniExtAttributeCardIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniExtAttributePortIndex));
        baseInfoPanel.add(tfUniExtAttributePortIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(uniPerfStats15minuteEnable));
        tfUniPerfStats15minuteEnable.setName(fStringMap.getString("uniPerfStats15minuteEnable"));
        baseInfoPanel.add(tfUniPerfStats15minuteEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPerfStats24hourEnable));
        tfUniPerfStats24hourEnable.setName(fStringMap.getString("uniPerfStats24hourEnable"));
        baseInfoPanel.add(tfUniPerfStats24hourEnable);
        baseInfoPanel.add(new HSpacer());

/*
        baseInfoPanel.add(new JLabel(uniLastChangeTime));
        tfUniLastChangeTime.setName(fStringMap.getString("uniLastChangeTime"));
        baseInfoPanel.add(tfUniLastChangeTime);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(uniIsolationEnable));
        tfUniIsolationEnable.setName(fStringMap.getString("uniIsolationEnable"));
        baseInfoPanel.add(tfUniIsolationEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniMacAddrLearnMaxNum));
        tfUniMacAddrLearnMaxNum.setName(fStringMap.getString("uniMacAddrLearnMaxNum"));
        baseInfoPanel.add(tfUniMacAddrLearnMaxNum);
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
        UniExtAttributeTable mbean = (UniExtAttributeTable) getModel();
        if (mbean == null)
            return;


        tfUniExtAttributeCardIndex.setText(mbean.getUniExtAttributeCardIndex() != null ? mbean.getUniExtAttributeCardIndex().toString() : "");
        tfUniExtAttributePortIndex.setText(mbean.getUniExtAttributePortIndex() != null ? mbean.getUniExtAttributePortIndex().toString() : "");

        tfUniPerfStats15minuteEnable.setSelectedIndex(getIndexFromValue(uniPerfStats15minuteEnableVList, mbean.getUniPerfStats15minuteEnable()));
        tfUniPerfStats24hourEnable.setSelectedIndex(getIndexFromValue(uniPerfStats24hourEnableVList, mbean.getUniPerfStats24hourEnable()));
/*
        tfUniLastChangeTime.setText(mbean.getUniLastChangeTime() != null ? mbean.getUniLastChangeTime().toString() : "");
*/
        tfUniIsolationEnable.setSelectedIndex(getIndexFromValue(uniIsolationEnableVList, mbean.getUniIsolationEnable()));
        tfUniMacAddrLearnMaxNum.setValue(mbean.getUniMacAddrLearnMaxNum());
    }

    public void updateModel() {
        UniExtAttributeTable mbean = (UniExtAttributeTable) getModel();
        if (mbean == null)
            return;

        mbean.setUniPerfStats15minuteEnable(new Integer(uniPerfStats15minuteEnableVList[tfUniPerfStats15minuteEnable.getSelectedIndex()]));
        mbean.setUniPerfStats24hourEnable(new Integer(uniPerfStats24hourEnableVList[tfUniPerfStats24hourEnable.getSelectedIndex()]));
        mbean.setUniIsolationEnable(new Integer(uniIsolationEnableVList[tfUniIsolationEnable.getSelectedIndex()]));
        mbean.setUniMacAddrLearnMaxNum(new Integer(tfUniMacAddrLearnMaxNum.getValue()));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}