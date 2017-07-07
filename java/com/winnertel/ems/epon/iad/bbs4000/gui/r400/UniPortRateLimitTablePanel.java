/**
 * Created by Zhou Chao, 2010/3/15
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.UniPortRateLimitTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class UniPortRateLimitTablePanel extends UPanel {

/*
    private JLabel tfUniPortRateLimitDeviceIndex = new JLabel();
    private JLabel tfUniPortRateLimitCardIndex = new JLabel();
    private JLabel tfUniPortRateLimitPortIndex = new JLabel();
*/

    private IntegerTextField tfUniPortInCIR = new IntegerTextField();
    private IntegerTextField tfUniPortInCBS = new IntegerTextField();
    private IntegerTextField tfUniPortInEBS = new IntegerTextField();
    private IntegerTextField tfUniPortOutCIR = new IntegerTextField();
    /*
    private IntegerTextField tfUniPortOutCBS = new IntegerTextField();
    private IntegerTextField tfUniPortOutPBS = new IntegerTextField();
    */
    private IntegerTextField tfUniPortOutPIR = new IntegerTextField();

    private int[] uniPortInRateLimitEnableVList = new int[]{1, 2,};
    private String[] uniPortInRateLimitEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniPortInRateLimitEnable = new JComboBox(uniPortInRateLimitEnableTList);

    private int[] uniPortOutRateLimitEnableVList = new int[]{1, 2,};
    private String[] uniPortOutRateLimitEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfUniPortOutRateLimitEnable = new JComboBox(uniPortOutRateLimitEnableTList);

/*
    private final String uniPortRateLimitDeviceIndex = fStringMap.getString("uniPortRateLimitDeviceIndex") + " : ";
    private final String uniPortRateLimitCardIndex = fStringMap.getString("uniPortRateLimitCardIndex") + " : ";
    private final String uniPortRateLimitPortIndex = fStringMap.getString("uniPortRateLimitPortIndex") + " : ";
*/
    private final String uniPortInCIR = fStringMap.getString("uniPortInCIR") + " : ";
    private final String uniPortInCBS = fStringMap.getString("uniPortInCBS") + " : ";
    private final String uniPortInEBS = fStringMap.getString("uniPortInEBS") + " : ";
    private final String uniPortOutCIR = fStringMap.getString("uniPortOutCIR") + " : ";
    /*
    private final String uniPortOutCBS = fStringMap.getString("uniPortOutCBS") + " : ";
    private final String uniPortOutPBS = fStringMap.getString("uniPortOutPBS") + " : ";
    */
    private final String uniPortOutPIR = fStringMap.getString("uniPortOutPIR") + " : ";
    private final String uniPortInRateLimitEnable = fStringMap.getString("uniPortInRateLimitEnable") + " : ";
    private final String uniPortOutRateLimitEnable = fStringMap.getString("uniPortOutRateLimitEnable") + " : ";

    public UniPortRateLimitTablePanel(IApplication app) {
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
        baseInfoPanel.add(new JLabel(uniPortRateLimitDeviceIndex));
        baseInfoPanel.add(tfUniPortRateLimitDeviceIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortRateLimitCardIndex));
        baseInfoPanel.add(tfUniPortRateLimitCardIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortRateLimitPortIndex));
        baseInfoPanel.add(tfUniPortRateLimitPortIndex);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(uniPortInCIR));
        tfUniPortInCIR.setName(fStringMap.getString("uniPortInCIR"));
        baseInfoPanel.add(tfUniPortInCIR);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortInCBS));
        tfUniPortInCBS.setName(fStringMap.getString("uniPortInCBS"));
        baseInfoPanel.add(tfUniPortInCBS);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortInEBS));
        tfUniPortInEBS.setName(fStringMap.getString("uniPortInEBS"));
        baseInfoPanel.add(tfUniPortInEBS);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortOutCIR));
        tfUniPortOutCIR.setName(fStringMap.getString("uniPortOutCIR"));
        baseInfoPanel.add(tfUniPortOutCIR);
        baseInfoPanel.add(new HSpacer());

        /*
        baseInfoPanel.add(new JLabel(uniPortOutCBS));
        tfUniPortOutCBS.setName(fStringMap.getString("uniPortOutCBS"));
        baseInfoPanel.add(tfUniPortOutCBS);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortOutPBS));
        tfUniPortOutPBS.setName(fStringMap.getString("uniPortOutPBS"));
        baseInfoPanel.add(tfUniPortOutPBS);
        baseInfoPanel.add(new HSpacer());
        */

        baseInfoPanel.add(new JLabel(uniPortOutPIR));
        tfUniPortOutPIR.setName(fStringMap.getString("uniPortOutPIR"));
        baseInfoPanel.add(tfUniPortOutPIR);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortInRateLimitEnable));
        tfUniPortInRateLimitEnable.setName(fStringMap.getString("uniPortInRateLimitEnable"));
        baseInfoPanel.add(tfUniPortInRateLimitEnable);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(uniPortOutRateLimitEnable));
        tfUniPortOutRateLimitEnable.setName(fStringMap.getString("uniPortOutRateLimitEnable"));
        baseInfoPanel.add(tfUniPortOutRateLimitEnable);
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
        UniPortRateLimitTable mbean = (UniPortRateLimitTable) getModel();
        if (mbean == null)
            return;

/*
        tfUniPortRateLimitDeviceIndex.setText(mbean.getUniPortRateLimitDeviceIndex() != null ? mbean.getUniPortRateLimitDeviceIndex().toString() : "");
        tfUniPortRateLimitCardIndex.setText(mbean.getUniPortRateLimitCardIndex() != null ? mbean.getUniPortRateLimitCardIndex().toString() : "");
        tfUniPortRateLimitPortIndex.setText(mbean.getUniPortRateLimitPortIndex() != null ? mbean.getUniPortRateLimitPortIndex().toString() : "");
*/
        tfUniPortInCIR.setValue(mbean.getUniPortInCIR());
        tfUniPortInCBS.setValue(mbean.getUniPortInCBS());
        tfUniPortInEBS.setValue(mbean.getUniPortInEBS());
        tfUniPortOutCIR.setValue(mbean.getUniPortOutCIR());
        /*
        tfUniPortOutCBS.setValue(mbean.getUniPortOutCBS());
        tfUniPortOutPBS.setValue(mbean.getUniPortOutPBS());
        */
        tfUniPortOutPIR.setValue(mbean.getUniPortOutPIR());
        tfUniPortInRateLimitEnable.setSelectedIndex(getIndexFromValue(uniPortInRateLimitEnableVList, mbean.getUniPortInRateLimitEnable()));
        tfUniPortOutRateLimitEnable.setSelectedIndex(getIndexFromValue(uniPortOutRateLimitEnableVList, mbean.getUniPortOutRateLimitEnable()));
    }

    public void updateModel() {
        UniPortRateLimitTable mbean = (UniPortRateLimitTable) getModel();
        if (mbean == null)
            return;

        mbean.setUniPortInCIR(new Integer(tfUniPortInCIR.getValue()));
        mbean.setUniPortInCBS(new Integer(tfUniPortInCBS.getValue()));
        mbean.setUniPortInEBS(new Integer(tfUniPortInEBS.getValue()));
        mbean.setUniPortOutCIR(new Integer(tfUniPortOutCIR.getValue()));
        /*
        mbean.setUniPortOutCBS(new Integer(tfUniPortOutCBS.getValue()));
        mbean.setUniPortOutPBS(new Integer(tfUniPortOutPBS.getValue()));
        */
        mbean.setUniPortOutPIR(new Integer(tfUniPortOutPIR.getValue()));
        mbean.setUniPortInRateLimitEnable(new Integer(uniPortInRateLimitEnableVList[tfUniPortInRateLimitEnable.getSelectedIndex()]));
        mbean.setUniPortOutRateLimitEnable(new Integer(uniPortOutRateLimitEnableVList[tfUniPortOutRateLimitEnable.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}