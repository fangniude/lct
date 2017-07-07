package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.InterfaceTableLgMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-18
 * Time: 14:28:42
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceTableLgMBeanPanel extends UPanel {

    private int[] ifAdminStatusVList = new int[]{
        1, 2, };
    private String[] ifAdminStatusTList = new String[]{
        fStringMap.getString("Up"),
        fStringMap.getString("Down"),
    };
    private JComboBox tfIfAdminStatus = new JComboBox(ifAdminStatusTList);

    private final String ifAdminStatus = fStringMap.getString("ifAdminStatus") + " : ";


    public InterfaceTableLgMBeanPanel(IApplication app) {
        super(app);
        setModel(new InterfaceTableLgMBean(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());



        baseInfoPanel.add(new JLabel(ifAdminStatus));
        tfIfAdminStatus.setName(fStringMap.getString("ifAdminStatus"));
        tfIfAdminStatus.setPreferredSize( new Dimension(100,25));
        baseInfoPanel.add(tfIfAdminStatus);
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

    public boolean validateFrom(){
//        InterfaceTableLgMBean mbean = (InterfaceTableLgMBean) getModel();
//        String index = ConfigUtility.formatIfIndex("" + mbean.getIfIndex());
//        if(index.indexOf("lg")!=-1){
//            JOptionPane.showMessageDialog(this,"The update operation is not allowed for " +
//                    "Link Aggregation.");
//            return false;
//        }
        return true;
    }

    public void refresh() {

        InterfaceTableLgMBean mbean = (InterfaceTableLgMBean) getModel();

        tfIfAdminStatus.setSelectedIndex(getIndexFromValue(ifAdminStatusVList, mbean.getIfAdminStatus().intValue()));



    }

    public void updateModel() {

        InterfaceTableLgMBean mbean = (InterfaceTableLgMBean) getModel();


        mbean.setIfAdminStatus(new Integer(ifAdminStatusVList[tfIfAdminStatus.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
