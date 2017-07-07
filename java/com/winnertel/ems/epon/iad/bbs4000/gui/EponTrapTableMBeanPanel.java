package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.EponTrapTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The EponTrapTableMBeanPanel class.
 * Created by DVM Creator
 */
public class EponTrapTableMBeanPanel extends UPanel {

    private IPAddressField tfUtsEponTrapDestIP = new IPAddressField();

    private IntegerTextField tfUtsEponTrapUDPPort = new IntegerTextField();

    private StringTextField tfUtsEponTrapCommunityString = new StringTextField();

//    private int[] utsEponTrapStateVList = new int[]{
//        1, 2, 5, 4, 3, 6, };
//    private String[] utsEponTrapStateTList = new String[]{
//        fStringMap.getString("active"),
//        fStringMap.getString("notInService"),
//        fStringMap.getString("createAndWait"),
//        fStringMap.getString("createAndGo"),
//        fStringMap.getString("notReady"),
//        fStringMap.getString("destroy"),
//    };
//    private JComboBox tfUtsEponTrapState = new JComboBox(utsEponTrapStateTList);


    private final String utsEponTrapDestIP = fStringMap.getString("utsEponTrapDestIP") + " : ";
    private final String utsEponTrapUDPPort = fStringMap.getString("utsEponTrapUDPPort") + " : ";
    private final String utsEponTrapCommunityString = fStringMap.getString("utsEponTrapCommunityString") + " : ";


    public EponTrapTableMBeanPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsEponTrapDestIP));
        tfUtsEponTrapDestIP.setName(fStringMap.getString("utsEponTrapDestIP"));
        baseInfoPanel.add(tfUtsEponTrapDestIP);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEponTrapUDPPort));
        tfUtsEponTrapUDPPort.setName(fStringMap.getString("utsEponTrapUDPPort"));
        baseInfoPanel.add(tfUtsEponTrapUDPPort);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(utsEponTrapCommunityString));
        tfUtsEponTrapCommunityString.setName(fStringMap.getString("utsEponTrapCommunityString"));
        baseInfoPanel.add(tfUtsEponTrapCommunityString);
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

        tfUtsEponTrapUDPPort.setValueScope(1, 65535);
        tfUtsEponTrapUDPPort.setDefaultValue(162);
        tfUtsEponTrapCommunityString.setLenScope(0, 32);
        tfUtsEponTrapCommunityString.setValue("public");


    }
    
    public boolean validateFrom() {
    	if (SnmpAction.IType.ADD.equals(fCommand)) {
    		int rowcount = ((SnmpTable)this.getTable()).getRowCount();
    		String ipaddress = tfUtsEponTrapDestIP.getIPString();
    		for(int i = 0; i < rowcount; i++) {
    			if(((SnmpTable)this.getTable()).getValueAt(i, 0).toString().equals(ipaddress)){
    				MessageDialog.showInfoMessageDialog(fApplication,
    					fStringMap.getString("Err_UtsEponTrapDestIP_Value"));
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {

            return;
        }
        if (SnmpAction.IType.MODIFY.equals(fCommand)) {

            tfUtsEponTrapDestIP.setEditable(false);
        }
        EponTrapTableMBean mbean = (EponTrapTableMBean) getModel();

        tfUtsEponTrapDestIP.setValue(mbean.getUtsEponTrapDestIP());
        tfUtsEponTrapUDPPort.setValue(mbean.getUtsEponTrapUDPPort().intValue());
        tfUtsEponTrapCommunityString.setValue(mbean.getUtsEponTrapCommunityString());
//          tfUtsEponTrapState.setSelectedIndex(getIndexFromValue(utsEponTrapStateVList,mbean.getUtsEponTrapState().intValue()));

    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) setModel(new EponTrapTableMBean(fApplication.getSnmpProxy()));

        EponTrapTableMBean mbean = (EponTrapTableMBean) getModel();


        mbean.setUtsEponTrapDestIP(new String(tfUtsEponTrapDestIP.getIPString()));
        mbean.setUtsEponTrapUDPPort(new Integer(tfUtsEponTrapUDPPort.getValue()));
        mbean.setUtsEponTrapCommunityString(new String(tfUtsEponTrapCommunityString.getValue()));
//          mbean.setUtsEponTrapState(new Integer(utsEponTrapStateVList[tfUtsEponTrapState.getSelectedIndex()]));
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    public void afterUpdateModel() {
        GuiUtil.getParentDialog( this ).dispose();

    }

}
