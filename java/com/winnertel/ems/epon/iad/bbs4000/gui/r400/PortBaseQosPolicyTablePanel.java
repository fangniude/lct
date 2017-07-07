/**
 * Created by Zhou Chao, 2010/5/26
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PortBaseQosPolicyTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class PortBaseQosPolicyTablePanel extends UPanel {

    private int[] baseQosPolicyModeVList = new int[]{1, 2, 3, 4,};
    private String[] baseQosPolicyModeTList = new String[]{
            fStringMap.getString("sp"), //1
            fStringMap.getString("wrr"), //2
            fStringMap.getString("spWrr"), //3
            fStringMap.getString("wfp"), //4
    };
    private JComboBox tfBaseQosPolicyMode = new JComboBox(baseQosPolicyModeTList);

    private IntegerTextField[] tfBaseQosPolicyWeightOctet = null;
    private IntegerTextField[] tfBaseQosPolicySpBandwidthRange = null;

    private final String baseQosPolicyMode = fStringMap.getString("portBaseQosPolicyMode") + " : ";
    private final String baseQosPolicyWeightOctet = fStringMap.getString("portBaseQosPolicyWeightOctet") + " : ";
    private final String baseQosPolicySpBandwidthRange = fStringMap.getString("portBaseQosPolicySpBandwidthRange") + " : ";

    public PortBaseQosPolicyTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(baseQosPolicyMode));
        baseInfoPanel.add(tfBaseQosPolicyMode);
        baseInfoPanel.add(new HSpacer());

        //BaseQosPolicyWeightOctet panel
        JPanel baseQosPolicyWeightOctetPanel = new JPanel();
        NTLayout layout1 = new NTLayout(2, 9, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        baseQosPolicyWeightOctetPanel.setLayout(layout1);
        baseQosPolicyWeightOctetPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(baseQosPolicyWeightOctet)));

        tfBaseQosPolicyWeightOctet = new IntegerTextField[8];
        for (int i = 0; i < tfBaseQosPolicyWeightOctet.length; i++) {
            tfBaseQosPolicyWeightOctet[i] = new IntegerTextField();
            baseQosPolicyWeightOctetPanel.add(new JLabel(fStringMap.getString("weight") + i));
            baseQosPolicyWeightOctetPanel.add(tfBaseQosPolicyWeightOctet[i]);

            if(i % 4 == 3) {
                baseQosPolicyWeightOctetPanel.add(new HSpacer());
            }
        }

        //BaseQosPolicySpBandwidthRange panel
        JPanel baseQosPolicySpBandwidthRangePanel = new JPanel();
        NTLayout layout2 = new NTLayout(2, 9, NTLayout.FILL, NTLayout.FILL, 5, 5);
        layout2.setMargins(6, 10, 6, 10);
        baseQosPolicySpBandwidthRangePanel.setLayout(layout2);
        baseQosPolicySpBandwidthRangePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(baseQosPolicySpBandwidthRange)));

        tfBaseQosPolicySpBandwidthRange = new IntegerTextField[8];
        for (int i = 0; i < tfBaseQosPolicySpBandwidthRange.length; i++) {
            tfBaseQosPolicySpBandwidthRange[i] = new IntegerTextField();
            baseQosPolicySpBandwidthRangePanel.add(new JLabel(fStringMap.getString("bandwidth") + i));
            baseQosPolicySpBandwidthRangePanel.add(tfBaseQosPolicySpBandwidthRange[i]);

            if(i % 4 == 3) {
                baseQosPolicySpBandwidthRangePanel.add(new HSpacer());
            }
        }

        tfBaseQosPolicyMode.addActionListener(new ActionListener() {
            public void itemStateChanged(ItemEvent e) {
            }

            public void actionPerformed(ActionEvent e) {
                int mode = tfBaseQosPolicyMode.getSelectedIndex() + 1;
                initWeightPanel(mode);
                initBandwidthRangePanel();
            }
        });

        JPanel allPanel = new JPanel();
        layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(baseQosPolicyWeightOctetPanel);
        allPanel.add(baseQosPolicySpBandwidthRangePanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(new JScrollPane(allPanel), BorderLayout.CENTER);
    }

    protected void initForm() {
        initBandwidthRangePanel();
    }

    public void initWeightPanel(int mode) {
        if (mode == 2 || mode == 3) { //wrr & spWrr
            for (int i = 0; i < tfBaseQosPolicyWeightOctet.length; i++) {
                tfBaseQosPolicyWeightOctet[i].setValue(0);
                tfBaseQosPolicyWeightOctet[i].setEditable(true);
            }
        } else { //sp & wfp
            for (int i = 0; i < tfBaseQosPolicyWeightOctet.length; i++) {
                tfBaseQosPolicyWeightOctet[i].setValue(0);
                tfBaseQosPolicyWeightOctet[i].setEditable(false);
            }
        }
    }

    public void initBandwidthRangePanel() {
        for (int i = 0; i < tfBaseQosPolicySpBandwidthRange.length; i++) {
            tfBaseQosPolicySpBandwidthRange[i].setValue(0);
            tfBaseQosPolicySpBandwidthRange[i].setEditable(true);
        }
    }

    public boolean validateFrom() {
        int n = 0;
        for (int i = 0; i < tfBaseQosPolicyWeightOctet.length; i++) {
            n += tfBaseQosPolicyWeightOctet[i].getValue();
        }

        boolean result = (n == 0 || n == 100);
        if (!result)
            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_Weight_Is_Invalid"));

        return result;
    }

    public void refresh() {
        PortBaseQosPolicyTable mbean = (PortBaseQosPolicyTable) getModel();
        if (mbean == null)
            return;

        tfBaseQosPolicyMode.setSelectedIndex(getIndexFromValue(baseQosPolicyModeVList, mbean.getPortBaseQosPolicyMode()));
        //initWeightPanel(mbean.getPortBaseQosPolicyMode()); //manually trigger 'addItemListener'
        setBaseQosPolicyWeightOctet(mbean.getPortBaseQosPolicyMode(), mbean.getPortBaseQosPolicyWeightOctet());
        setBaseQosPolicySpBandwidthRange(mbean.getPortBaseQosPolicySpBandwidthRange());
    }

    public void updateModel() {
        PortBaseQosPolicyTable mbean = (PortBaseQosPolicyTable) getModel();
        if (mbean == null)
            return;

        mbean.setPortBaseQosPolicyMode(new Integer(baseQosPolicyModeVList[tfBaseQosPolicyMode.getSelectedIndex()]));
        mbean.setPortBaseQosPolicyWeightOctet(getBaseQosPolicyWeightOctet(mbean.getPortBaseQosPolicyMode()));
        mbean.setPortBaseQosPolicySpBandwidthRange(getBaseQosPolicySpBandwidthRange());
    }

    private byte[] getBaseQosPolicyWeightOctet(int mode) {
        if (mode == 2 || mode == 3) { //wrr & spWrr
            return getByteMap(tfBaseQosPolicyWeightOctet);
        } else { //sp & wfp
            byte[] b = new byte[tfBaseQosPolicyWeightOctet.length];
            //for (int i = 0; (i < tfBaseQosPolicyWeightOctet.length); i++)
            //    b[i] = 0;

            return b;
        }
    }

    private void setBaseQosPolicyWeightOctet(int mode, byte[] queueMap) {
        if (mode == 2 || mode == 3) { //wrr & spWrr
            setByteMap(tfBaseQosPolicyWeightOctet, queueMap);
        } else { //sp & wfp
            for (int i = 0; i < tfBaseQosPolicyWeightOctet.length; i++)
                tfBaseQosPolicyWeightOctet[i].setValue(0);
        }
    }

    private byte[] getByteMap(IntegerTextField[] objs) {
        byte[] b = new byte[objs.length];
        for (int i = 0; (i < objs.length); i++)
            b[i] = (byte) objs[i].getValue();

        return b;
    }

    private void setByteMap(IntegerTextField[] objs, byte[] mibValue) {
        //for (int i = 0; i < objs.length; i++)
        //    objs[i].setValue(0);
        for (int i = 0; (i < mibValue.length) && (i <= objs.length); i++)
            objs[i].setValue((int) mibValue[i]);
    }

    private byte[] getBaseQosPolicySpBandwidthRange() {
        return get4BytesMap(tfBaseQosPolicySpBandwidthRange);
    }

    private void setBaseQosPolicySpBandwidthRange(byte[] queueMap) {
        set4BytesMap(tfBaseQosPolicySpBandwidthRange, queueMap);
    }

    private byte[] get4BytesMap(IntegerTextField[] objs) {
        int n = 4;
        byte[] b = new byte[objs.length * n];
        for (int i = 0; i < objs.length; i++) {
            for (int j = 0; j < n; j++) {
                b[i*n + j] = (byte) ((objs[i].getValue() >> (8 * (n - j - 1))) & 0xFF);
            }
        }

        return b;
    }

    private void set4BytesMap(IntegerTextField[] objs, byte[] mibValue) {
        int n = 4;
        //for (int i = 0; i < objs.length; i++)
        //    objs[i].setValue(0);
        for (int i = 0; (i < mibValue.length/n) && (i < objs.length); i++) {
            byte[] b = new byte[n];
            System.arraycopy(mibValue, i * n, b, 0, n);
            int t = 0;
            for (int j = 0; j < b.length; j++)
                t += (((int) b[j]) & 0xFF) << (8 * (b.length - 1 - j));
            objs[i].setValue(t);
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