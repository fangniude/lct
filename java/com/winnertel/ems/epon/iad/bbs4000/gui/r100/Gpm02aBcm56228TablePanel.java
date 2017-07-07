/**
 * Created by Zhou Chao, 2009/2/21
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.QueueModeWeightField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.Gpm02aBcm56228TableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Gpm02aBcm56228TablePanel extends UPanel {

    private JLabel tfUtsGpm02aBcm56228ModuleId = new JLabel();
    //private JLabel tfUtsGpm02aBcm56228DeviceId = new JLabel();
    private QueueModeWeightField weightPanel = new QueueModeWeightField(fApplication);
    private final String utsGpm02aBcm56228ModuleId = fStringMap.getString("utsGpm02aBcm56228ModuleId") + ": ";
    //private final String utsGpm02aBcm56228DeviceId = fStringMap.getString("utsGpm02aBcm56228DeviceId") + ": ";
    private final String utsGpm02aBcm56228SchedulingMode = fStringMap.getString("utsGpm02aBcm56228SchedulingMode") + ": ";
    private final String utsGpm02aBcm56228SchedulingWeight = fStringMap.getString("utsGpm02aBcm56228SchedulingWeight") + ": ";

    public Gpm02aBcm56228TablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsGpm02aBcm56228ModuleId));
        baseInfoPanel.add(tfUtsGpm02aBcm56228ModuleId);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(utsGpm02aBcm56228DeviceId));
        //baseInfoPanel.add(tfUtsGpm02aBcm56228DeviceId);
        //baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsGpm02aBcm56228SchedulingMode));
        baseInfoPanel.add(weightPanel.getModePanel());
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsGpm02aBcm56228SchedulingWeight));
        baseInfoPanel.add(weightPanel.getWeightPanel());
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
        Gpm02aBcm56228TableMBean mbean = (Gpm02aBcm56228TableMBean) getModel();
        if (mbean == null)
            return;

        tfUtsGpm02aBcm56228ModuleId.setText(mbean.getUtsGpm02aBcm56228ModuleId().toString());
        //tfUtsGpm02aBcm56228DeviceId.setText(mbean.getUtsGpm02aBcm56228DeviceId().toString());

        weightPanel.setSelectedModeIndex(-1); //for trigger 'itemStateChanged' event
        weightPanel.setModeValue(mbean.getUtsGpm02aBcm56228SchedulingMode());

        weightPanel.setWeightEnabled(mbean.getUtsGpm02aBcm56228SchedulingMode() != 1);
        weightPanel.setWeightValue(mbean.getUtsGpm02aBcm56228SchedulingWeight());
    }

    public void updateModel() {
        Gpm02aBcm56228TableMBean mbean = (Gpm02aBcm56228TableMBean) getModel();
        if (mbean == null)
            return;

        mbean.setUtsGpm02aBcm56228SchedulingMode(weightPanel.getModeValue());

        if (weightPanel.isWeightEnabled())
            mbean.setUtsGpm02aBcm56228SchedulingWeight(weightPanel.getWeightValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }



}