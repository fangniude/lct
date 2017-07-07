/**
 * Created by Zhou Chao, 2010/3/8
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.OnuCapabilityTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class OnuCapabilityTablePanel extends UPanel {

/*
    private JLabel tfOnuCapabilityDeviceIndex = new JLabel();

    private JLabel tfOnuGePortNum = new JLabel();
    private JLabel tfOnuGePortBitmap = new JLabel();
    private JLabel tfOnuFePortNum = new JLabel();
    private JLabel tfOnuFePortBitmap = new JLabel();
    private JLabel tfOnuQueueNumUplink = new JLabel();
    private JLabel tfOnuMaxQueueNumUplink = new JLabel();
    private JLabel tfOnuQueueNumDownlink = new JLabel();
    private JLabel tfOnuMaxQueueNumDownlink = new JLabel();
*/

    private int[] onuFecEnableVList = new int[]{1, 2,};
    private String[] onuFecEnableTList = new String[]{
            fStringMap.getString("true"), //1
            fStringMap.getString("false"), //2
    };
    private JComboBox tfOnuFecEnable = new JComboBox(onuFecEnableTList);

/*
    private int[] onuEncryptModeVList = new int[]{1, 2, 3,};
    private String[] onuEncryptModeTList = new String[]{
            fStringMap.getString("aes128"), //1
            fStringMap.getString("ctcTripleChurning"), //2
            fStringMap.getString("other"), //3
    };
    private JComboBox tfOnuEncryptMode = new JComboBox(onuEncryptModeTList);

    private JLabel tfOnuEncryptKeyExchangeTime = new JLabel();
*/

/*
    private final String onuCapabilityDeviceIndex = fStringMap.getString("onuCapabilityDeviceIndex") + " : ";
    private final String onuGePortNum = fStringMap.getString("onuGePortNum") + " : ";
    private final String onuGePortBitmap = fStringMap.getString("onuGePortBitmap") + " : ";
    private final String onuFePortNum = fStringMap.getString("onuFePortNum") + " : ";
    private final String onuFePortBitmap = fStringMap.getString("onuFePortBitmap") + " : ";
    private final String onuQueueNumUplink = fStringMap.getString("onuQueueNumUplink") + " : ";
    private final String onuMaxQueueNumUplink = fStringMap.getString("onuMaxQueueNumUplink") + " : ";
    private final String onuQueueNumDownlink = fStringMap.getString("onuQueueNumDownlink") + " : ";
    private final String onuMaxQueueNumDownlink = fStringMap.getString("onuMaxQueueNumDownlink") + " : ";
*/
    private final String onuFecEnable = fStringMap.getString("onuFecEnable") + " : ";
/*
    private final String onuEncryptMode = fStringMap.getString("onuEncryptMode") + " : ";
    private final String onuEncryptKeyExchangeTime = fStringMap.getString("onuEncryptKeyExchangeTime") + " : ";
*/

    public OnuCapabilityTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

/*
        baseInfoPanel.add(new JLabel(onuCapabilityDeviceIndex));
        baseInfoPanel.add(tfOnuCapabilityDeviceIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuGePortNum));
        baseInfoPanel.add(tfOnuGePortNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuGePortBitmap));
        baseInfoPanel.add(tfOnuGePortBitmap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuFePortNum));
        baseInfoPanel.add(tfOnuFePortNum);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuFePortBitmap));
        baseInfoPanel.add(tfOnuFePortBitmap);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuQueueNumUplink));
        baseInfoPanel.add(tfOnuQueueNumUplink);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMaxQueueNumUplink));
        baseInfoPanel.add(tfOnuMaxQueueNumUplink);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuQueueNumDownlink));
        baseInfoPanel.add(tfOnuQueueNumDownlink);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuMaxQueueNumDownlink));
        baseInfoPanel.add(tfOnuMaxQueueNumDownlink);
        baseInfoPanel.add(new HSpacer());
*/

        baseInfoPanel.add(new JLabel(onuFecEnable));
        tfOnuFecEnable.setName(fStringMap.getString("onuFecEnable"));
        baseInfoPanel.add(tfOnuFecEnable);
        baseInfoPanel.add(new HSpacer());

/*
        baseInfoPanel.add(new JLabel(onuEncryptMode));
        baseInfoPanel.add(tfOnuEncryptMode);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuEncryptKeyExchangeTime));
        baseInfoPanel.add(tfOnuEncryptKeyExchangeTime);
        baseInfoPanel.add(new HSpacer());
*/

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
        OnuCapabilityTable mbean = (OnuCapabilityTable) getModel();
        if (mbean == null)
            return;

/*
        tfOnuCapabilityDeviceIndex.setText(mbean.getOnuCapabilityDeviceIndex() != null ? mbean.getOnuCapabilityDeviceIndex().toString() : "");
        tfOnuGePortNum.setText(mbean.getOnuGePortNum() != null ? mbean.getOnuGePortNum().toString() : "");
        tfOnuGePortBitmap.setText(mbean.getOnuGePortBitmap());
        tfOnuFePortNum.setText(mbean.getOnuFePortNum() != null ? mbean.getOnuFePortNum().toString() : "");
        tfOnuFePortBitmap.setText(mbean.getOnuFePortBitmap());
        tfOnuQueueNumUplink.setText(mbean.getOnuQueueNumUplink() != null ? mbean.getOnuQueueNumUplink().toString() : "");
        tfOnuMaxQueueNumUplink.setText(mbean.getOnuMaxQueueNumUplink() != null ? mbean.getOnuMaxQueueNumUplink().toString() : "");
        tfOnuQueueNumDownlink.setText(mbean.getOnuQueueNumDownlink() != null ? mbean.getOnuQueueNumDownlink().toString() : "");
        tfOnuMaxQueueNumDownlink.setText(mbean.getOnuMaxQueueNumDownlink() != null ? mbean.getOnuMaxQueueNumDownlink().toString() : "");
*/
        if(mbean.getOnuFecEnable() != null)
            tfOnuFecEnable.setSelectedIndex(getIndexFromValue(onuFecEnableVList, mbean.getOnuFecEnable()));
/*
        tfOnuEncryptMode.setSelectedIndex(getIndexFromValue(onuEncryptModeVList, mbean.getOnuEncryptMode()));
        tfOnuEncryptKeyExchangeTime.setText(mbean.getOnuEncryptKeyExchangeTime() != null ? mbean.getOnuEncryptKeyExchangeTime().toString() : "");
*/
    }

    public void updateModel() {
        OnuCapabilityTable mbean = (OnuCapabilityTable) getModel();
        if (mbean == null)
            return;

        mbean.setOnuFecEnable(new Integer(onuFecEnableVList[tfOnuFecEnable.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}