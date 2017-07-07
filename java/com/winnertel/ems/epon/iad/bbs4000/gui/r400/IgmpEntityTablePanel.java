/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.IgmpEntityTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class IgmpEntityTablePanel extends UPanel {

    private int[] igmpModeVList = new int[]{1, 2,};
    private String[] igmpModeTList = new String[]{
            fStringMap.getString("centralized"), //1
            fStringMap.getString("distributedwithcm"), //2
            fStringMap.getString("disabled"), //3
            fStringMap.getString("distributedwocm"), //4
    };
    private JComboBox tfIgmpMode = new JComboBox(igmpModeTList);

    private IntegerTextField tfMaxQueryResponseTime = new IntegerTextField();
    private IntegerTextField tfRobustVariable = new IntegerTextField();
    private IntegerTextField tfQueryInterval = new IntegerTextField();
    private IntegerTextField tfLastMemberQueryInterval = new IntegerTextField();
    private IntegerTextField tfLastMemberQueryCount = new IntegerTextField();

    private int[] igmpVersionVList = new int[]{1, 2, 3,};
    private String[] igmpVersionTList = new String[]{
            fStringMap.getString("v1"), //1
            fStringMap.getString("v2"), //2
            fStringMap.getString("v3"), //3
    };
    private JComboBox tfIgmpVersion = new JComboBox(igmpVersionTList);

    private final String igmpMode = fStringMap.getString("igmpMode") + " : ";
    private final String maxQueryResponseTime = fStringMap.getString("maxQueryResponseTime") + " : ";
    private final String robustVariable = fStringMap.getString("robustVariable") + " : ";
    private final String queryInterval = fStringMap.getString("queryInterval") + " : ";
    private final String lastMemberQueryInterval = fStringMap.getString("lastMemberQueryInterval") + " : ";
    private final String lastMemberQueryCount = fStringMap.getString("lastMemberQueryCount") + " : ";
    private final String igmpVersion = fStringMap.getString("igmpVersion") + " : ";

    public IgmpEntityTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(igmpMode));
        tfIgmpMode.setName(fStringMap.getString("igmpMode"));
        baseInfoPanel.add(tfIgmpMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(maxQueryResponseTime));
        tfMaxQueryResponseTime.setName(fStringMap.getString("maxQueryResponseTime"));
        baseInfoPanel.add(tfMaxQueryResponseTime);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(robustVariable));
        tfRobustVariable.setName(fStringMap.getString("robustVariable"));
        baseInfoPanel.add(tfRobustVariable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(queryInterval));
        tfQueryInterval.setName(fStringMap.getString("queryInterval"));
        baseInfoPanel.add(tfQueryInterval);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(lastMemberQueryInterval));
        tfLastMemberQueryInterval.setName(fStringMap.getString("lastMemberQueryInterval"));
        baseInfoPanel.add(tfLastMemberQueryInterval);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(lastMemberQueryCount));
        tfLastMemberQueryCount.setName(fStringMap.getString("lastMemberQueryCount"));
        baseInfoPanel.add(tfLastMemberQueryCount);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(igmpVersion));
        tfIgmpVersion.setName(fStringMap.getString("igmpVersion"));
        baseInfoPanel.add(tfIgmpVersion);
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
        IgmpEntityTable mbean = (IgmpEntityTable) getModel();
        if (mbean == null)
            return;

        tfIgmpMode.setSelectedIndex(getIndexFromValue(igmpModeVList, mbean.getIgmpMode()));
        tfMaxQueryResponseTime.setValue(mbean.getMaxQueryResponseTime()/10);
        tfRobustVariable.setValue(mbean.getRobustVariable());
        tfQueryInterval.setValue(mbean.getQueryInterval());
        tfLastMemberQueryInterval.setValue(mbean.getLastMemberQueryInterval()/10);
        tfLastMemberQueryCount.setValue(mbean.getLastMemberQueryCount());
        tfIgmpVersion.setSelectedIndex(getIndexFromValue(igmpVersionVList, mbean.getIgmpVersion()));
    }

    public void updateModel() {
        IgmpEntityTable mbean = (IgmpEntityTable) getModel();
        if (mbean == null)
            return;

        mbean.setIgmpMode(new Integer(igmpModeVList[tfIgmpMode.getSelectedIndex()]));
        mbean.setMaxQueryResponseTime(new Integer(tfMaxQueryResponseTime.getValue()*10));
        mbean.setRobustVariable(new Integer(tfRobustVariable.getValue()));
        mbean.setQueryInterval(new Integer(tfQueryInterval.getValue()));
        mbean.setLastMemberQueryInterval(new Integer(tfLastMemberQueryInterval.getValue()*10));
        mbean.setLastMemberQueryCount(new Integer(tfLastMemberQueryCount.getValue()));
        mbean.setIgmpVersion(new Integer(igmpVersionVList[tfIgmpVersion.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}