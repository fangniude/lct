package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PonPortInfoTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniAttributeTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-6-28
 * Time: 18:43:59
 * To change this template use File | Settings | File Templates.
 */
public class EponDeviceIndexPanel extends JPanel implements ActionListener {

    private JRadioButton rb_OLT = new JRadioButton();
    private JRadioButton rb_ONU = new JRadioButton();
    private JRadioButton rb_UNI = new JRadioButton();

    private ButtonGroup bg = new ButtonGroup();

    public JComboBox tfPvtDeviceIndex = new JComboBox();
    public JComboBox tfPvtOnuNUM = new JComboBox();

    public LongTextField tfPvtCardIndex = new LongTextField();
    public IntegerTextField tfPvtPortIndex = new IntegerTextField();

    DvmStringMap fStringMap;
    IApplication fApplication;

    //private final String pvtDeviceType = ;
    //private final String pvtDeviceIndex = ;
    //private final String pvtOnuNum =  + " : ";
    //private final String pvtCardIndex = ;
    //private final String pvtPortIndex = ;

    public EponDeviceIndexPanel(DvmStringMap strMap, IApplication iApp) {
        fStringMap = strMap;
        fApplication = iApp;

        initGUI();
//        initData();
    }


    private Vector pon_PortList;
    private Vector sni_PortList;

    private void initGUI() {

        JPanel radioGroupPanel = new JPanel();

        NTLayout layout_radioGroup = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 2, 2);
        layout_radioGroup.setMargins(1, 2, 1, 2);
        radioGroupPanel.setLayout(layout_radioGroup);

        rb_OLT.setText("OLT/SNI");
        rb_ONU.setText("ONU");
        rb_UNI.setText("UNI");

        radioGroupPanel.add(rb_OLT);
        radioGroupPanel.add(rb_ONU);
        radioGroupPanel.add(rb_UNI);

        bg.add(rb_OLT);
        bg.add(rb_ONU);
        bg.add(rb_UNI);

        rb_OLT.addActionListener(this);
        rb_ONU.addActionListener(this);
        rb_UNI.addActionListener(this);

        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        this.setLayout(layout);
        this.setBorder(BorderFactory.createEtchedBorder());


        JLabel lb1 = new JLabel(fStringMap.getString("pvtDeviceType") + " : ");
        lb1.setPreferredSize(new Dimension(120, 25));
        this.add(lb1);
        radioGroupPanel.setPreferredSize(new Dimension(220, 25));
        this.add(radioGroupPanel);
        this.add(new HSpacer(30));

        JLabel lb2 = new JLabel(fStringMap.getString("pvtDeviceIndex") + " : ");
        //lb2.setPreferredSize(new Dimension(120,20));
        this.add(lb2);
        //tfPvtDeviceIndex.setPreferredSize(new Dimension(150,20)); 
        this.add(tfPvtDeviceIndex);
        this.add(new HSpacer());

        //tfPvtDeviceIndex.addActionListener(this);

        for (int i = 1; i <= 64; i++) {
            tfPvtOnuNUM.addItem(String.valueOf(i));
        }
        tfPvtOnuNUM.setEditable(false);
        this.add(new JLabel(fStringMap.getString("pvtOnuNum")));
        this.add(tfPvtOnuNUM);
        this.add(new HSpacer());

        this.add(new JLabel(fStringMap.getString("pvtCardIndex") + " : "));
        this.add(tfPvtCardIndex);
        this.add(new HSpacer());


        this.add(new JLabel(fStringMap.getString("pvtPortIndex") + " : "));
        this.add(tfPvtPortIndex);
        this.add(new HSpacer());

        //this.setPreferredSize(new Dimension(400,180));
    }

    public void initData() {
        pon_PortList = new Vector();
        sni_PortList = new Vector();

        PonPortInfoTable ponPortMBean = new PonPortInfoTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, ponPortMBean);
        for (int i = 0; i < v.size(); i++) {
            PonPortInfoTable eachBean = (PonPortInfoTable) v.get(i);
            pon_PortList.add(eachBean.getPonDeviceIndex() + "/" + eachBean.getPonCardIndex() + "/" + eachBean.getPonPortIndex());
        }

        SniAttributeTable sniPortMBean = new SniAttributeTable(fApplication.getSnmpProxy());
        v = BeanService.refreshTableBean(fApplication, sniPortMBean);
        for (int i = 0; i < v.size(); i++) {
            SniAttributeTable eachBean = (SniAttributeTable) v.get(i);
            sni_PortList.add(eachBean.getSniAttributeDeviceIndex() + "/" + eachBean.getSniAttributeCardIndex() + "/" + eachBean.getSniAttributePortIndex());
        }

        rb_OLT.setSelected(true);
        handleOltSelectedEvent();
    }

    public boolean validateFrom() {
        if (tfPvtDeviceIndex.getSelectedItem() == null) {
            MessageDialog.showErrorMessageDialog(fApplication, fStringMap.getString("Err_SelectADeviceIndex"));
            return false;
        }

        return true;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == tfPvtDeviceIndex) {
            /*
            String selPort= (String)tfPvtDeviceIndex.getSelectedItem();
            for (int i=0;i<allPonPortList.size();i++){
                if(allPonPortList.elementAt(i).equals(selPort)){
                    tfPvtOnuNUM.setEnabled(true);
                    tfPvtCardIndex.setEditable(true);
                    tfPvtPortIndex.setEditable(true);

                    break;
                }
            }

            for (int i=0;i<allSniPortList.size();i++){
                if(allSniPortList.elementAt(i).equals(selPort)){
                    tfPvtOnuNUM.setSelectedItem("0");
                    tfPvtOnuNUM.setEnabled(false);

                    tfPvtCardIndex.setText("0");
                    tfPvtCardIndex.setEditable(false);
                    tfPvtPortIndex.setText("0");
                    tfPvtPortIndex.setEditable(false);

                }
            }   */

        } else if (source == rb_OLT) {
            if (rb_OLT.isSelected()) {
                handleOltSelectedEvent();
            }
        } else if (source == rb_ONU) {
            if (rb_ONU.isSelected()) {
                handleOnuSelectedEvent();
            }


        } else if (source == rb_UNI) {
            if (rb_UNI.isSelected()) {
                handleUniSelectedEvent();

            }
        }
    }

    private void handleUniSelectedEvent() {
        tfPvtDeviceIndex.removeAllItems();
        if (pon_PortList != null) {
            for (int i = 0; i < pon_PortList.size(); i++) {
                tfPvtDeviceIndex.addItem(pon_PortList.elementAt(i));
            }
        }

        tfPvtOnuNUM.setEnabled(true);

        tfPvtCardIndex.setText("0");
        tfPvtCardIndex.setEditable(true);
        tfPvtPortIndex.setText("0");
        tfPvtPortIndex.setEditable(true);
    }

    private void handleOnuSelectedEvent() {
        tfPvtDeviceIndex.removeAllItems();
        if (pon_PortList != null) {
            for (int i = 0; i < pon_PortList.size(); i++) {
                tfPvtDeviceIndex.addItem(pon_PortList.elementAt(i));
            }
        }

        tfPvtOnuNUM.setEnabled(true);

        tfPvtCardIndex.setText("0");
        tfPvtCardIndex.setEditable(false);
        tfPvtPortIndex.setText("0");
        tfPvtPortIndex.setEditable(false);
    }

    private void handleOltSelectedEvent() {
        tfPvtDeviceIndex.removeAllItems();

        if (sni_PortList != null) {
            for (int i = 0; i < sni_PortList.size(); i++) {
                tfPvtDeviceIndex.addItem(sni_PortList.elementAt(i));
            }
        }

        if (pon_PortList != null) {
            for (int i = 0; i < pon_PortList.size(); i++) {
                tfPvtDeviceIndex.addItem(pon_PortList.elementAt(i));
            }
        }

        tfPvtOnuNUM.setEnabled(false);

        tfPvtCardIndex.setText("0");
        tfPvtCardIndex.setEditable(false);
        tfPvtPortIndex.setText("0");
        tfPvtPortIndex.setEditable(false);
    }

    public long getEponDeviceIndex() {
        int retCode = 0;

        String port = (String)tfPvtDeviceIndex.getSelectedItem();
        int idx1 = port.indexOf("/");
        int idx2 = port.indexOf("/", idx1 + 1);

        retCode = retCode | (Integer.parseInt(port.substring(0, idx1)) << 24);
        retCode = retCode | (Integer.parseInt(port.substring(idx1 + 1, idx2)) << 16);
        retCode = retCode | (Integer.parseInt(port.substring(idx2 + 1)) << 8);

        if (rb_ONU.isSelected() || rb_UNI.isSelected()) {
            retCode = retCode | Integer.parseInt((String)tfPvtOnuNUM.getSelectedItem());
        }

        return retCode;
    }

    public void setEponDeviceIndex(long index) {
        tfPvtDeviceIndex.setSelectedItem((index >> 24) + "/" + ((index >> 16)&0xFF) + "/" + ((index >> 8)&0xFF));

        int onuId = (int)(index & 0xFF);

        if(onuId != 0) {
            rb_ONU.setSelected(true);
        } else {
            rb_OLT.setSelected(true);
        }
    }

    public long getOnuCardId() {
        return tfPvtCardIndex.getValue();
    }

    public void setOnuCardId(long card) {
        if(card != 0) {
            rb_UNI.setSelected(true);
        }

        tfPvtCardIndex.setValue(card);
    }

    public int getOnuPortId() {
        return tfPvtPortIndex.getValue();
    }

    public void setOnuPortId(int port) {
        if(port != 0) {
            rb_UNI.setSelected(true);
        }

        tfPvtPortIndex.setValue(port);
    }

    public void setEnabled(boolean enable) {
        super.setEnabled(enable);

        rb_OLT.setEnabled(enable);
        rb_ONU.setEnabled(enable);
        rb_UNI.setEnabled(enable);

        tfPvtDeviceIndex.setEnabled(enable);
        tfPvtOnuNUM.setEnabled(enable);
        tfPvtCardIndex.setEnabled(enable);
        tfPvtPortIndex.setEnabled(enable);

        if(enable) { //validate the states of the componments.
            if(rb_OLT.isSelected()) {
                handleOltSelectedEvent();
            } else if(rb_ONU.isSelected()) {
                handleOnuSelectedEvent();
            } else if(rb_UNI.isSelected()) {
                handleUniSelectedEvent();
            }
        }
    }
}
