package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.IndexAutoGenField;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVoipSvcProTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GponOnuVoipSvcProTablePanel class.
 * Created by DVM Creator
 */
public class GponOnuVoipSvcProTablePanel extends UPanel {

    private IndexAutoGenField tfOnuVoipSvcProfileIndex = new IndexAutoGenField(fApplication,1);

    private StringTextField tfOnuVoipSvcProfileName = new StringTextField();

    private JComboBox tfOnuVoIPVirtualPortNo = new JComboBox();

    private int[] onuVoIPConfigMethodVList = new int[]{1, 3, 4, 5, 2,};
    private String[] onuVoIPConfigMethodTList = new String[]{
            fStringMap.getString("do-not-configure"), fStringMap.getString("file"),
            fStringMap.getString("tr-69"), fStringMap.getString("sip"),
            fStringMap.getString("omci"),};
    private JComboBox tfOnuVoIPConfigMethod = new JComboBox(
            onuVoIPConfigMethodTList);
    private IPAddressField tfOnuVoIPConfigServerAddress = new IPAddressField();

    private StringTextField tfOnuVoIPConfigScriptLocation = new StringTextField();

    private final String onuVoipSvcProfileIndex = fStringMap
            .getString("onuVoipSvcProfileIndex")
            + " : ";
    private final String onuVoipSvcProfileName = fStringMap
            .getString("onuVoipSvcProfileName")
            + " : ";
    private final String onuVoIPVirtualPortNo = fStringMap
            .getString("onuVoIPVirtualPortNo")
            + " : ";
    private final String onuVoIPConfigMethod = fStringMap
            .getString("onuVoIPConfigMethod")
            + " : ";
    private final String onuVoIPConfigServerAddress = fStringMap
            .getString("onuVoIPConfigServerAddress")
            + " : ";
    private final String onuVoIPConfigScriptLocation = fStringMap
            .getString("onuVoIPConfigScriptLocation")
            + " : ";

//  private SnmpApplyButton btApply;
//  private SnmpRefreshButton btRefresh;

    public GponOnuVoipSvcProTablePanel(IApplication app) {
        super(app);
        setModel(new GponOnuVoipSvcProTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {

//    btApply = new SnmpApplyButton(fApplication, this);
//    btApply.getAction()
//        .putValue(BaseAction.ID, "Modify_GponOnuVoipSvcProTable");
//    btRefresh = new SnmpRefreshButton(fApplication, this);
//    JPanel buttonsPanel = new JPanel();
//    buttonsPanel.add(btApply);
//    buttonsPanel.add(btRefresh);

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(onuVoipSvcProfileIndex));
        baseInfoPanel.add(tfOnuVoipSvcProfileIndex.getIndexPanel(0));
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoipSvcProfileName));
        tfOnuVoipSvcProfileName.setName(fStringMap
                .getString("onuVoipSvcProfileName"));
        tfOnuVoipSvcProfileName.setValue("New Profile");
        baseInfoPanel.add(tfOnuVoipSvcProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoIPVirtualPortNo));
        tfOnuVoIPVirtualPortNo
                .setName(fStringMap.getString("onuVoIPVirtualPortNo"));
        baseInfoPanel.add(tfOnuVoIPVirtualPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoIPConfigMethod));
        tfOnuVoIPConfigMethod.setName(fStringMap.getString("onuVoIPConfigMethod"));
        baseInfoPanel.add(tfOnuVoIPConfigMethod);
        baseInfoPanel.add(new HSpacer());
        tfOnuVoIPConfigMethod.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(onuVoIPConfigMethodVList[tfOnuVoIPConfigMethod.getSelectedIndex()]==3){
					tfOnuVoIPConfigServerAddress.setEnabled(true);
				}
				else 
					tfOnuVoIPConfigServerAddress.setEnabled(false);
			}
        	
        });

        baseInfoPanel.add(new JLabel(onuVoIPConfigServerAddress));
        tfOnuVoIPConfigServerAddress.setName(fStringMap
                .getString("onuVoIPConfigServerAddress"));
        baseInfoPanel.add(tfOnuVoIPConfigServerAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoIPConfigScriptLocation));
        tfOnuVoIPConfigScriptLocation.setName(fStringMap
                .getString("onuVoIPConfigScriptLocation"));
        baseInfoPanel.add(tfOnuVoIPConfigScriptLocation);
        baseInfoPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        for(int i=1;i<=40;i++){
        	tfOnuVoIPVirtualPortNo.addItem(i);	
        }

        // add(buttonsPanel, BorderLayout.SOUTH);

    }

    protected void initForm() {

        tfOnuVoipSvcProfileIndex.setValueScope(0,2, 1024);

        tfOnuVoIPConfigScriptLocation.setLenScope(0, 63);
        tfOnuVoIPConfigScriptLocation.setValue("voipscript ");
        tfOnuVoIPConfigMethod.setSelectedIndex(getIndexFromValue(onuVoIPConfigMethodVList, 3));

    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfOnuVoipSvcProfileIndex.setEnabled(true);
            tfOnuVoipSvcProfileIndex.setTable(fTable);
            tfOnuVoipSvcProfileIndex.refresh();
            return;
        } else
            tfOnuVoipSvcProfileIndex.setEnabled(false);

        GponOnuVoipSvcProTable mbean = (GponOnuVoipSvcProTable) getModel();
        BeanService.refreshBean(fApplication, mbean);

        tfOnuVoipSvcProfileIndex.setValue(0,mbean.getOnuVoipSvcProfileIndex());
        tfOnuVoipSvcProfileName.setValue(mbean.getOnuVoipSvcProfileName());
        tfOnuVoIPVirtualPortNo.setSelectedItem(mbean.getOnuVoIPVirtualPortNo().intValue());
        tfOnuVoIPConfigMethod.setSelectedIndex(getIndexFromValue(
                onuVoIPConfigMethodVList, mbean.getOnuVoIPConfigMethod().intValue()));
        tfOnuVoIPConfigServerAddress
                .setValue(mbean.getOnuVoIPConfigServerAddress());
        tfOnuVoIPConfigScriptLocation.setValue(mbean
                .getOnuVoIPConfigScriptLocation());
        if(onuVoIPConfigMethodVList[tfOnuVoIPConfigMethod.getSelectedIndex()]!=3){
        	tfOnuVoIPConfigServerAddress.setEnabled(false);
        }
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new GponOnuVoipSvcProTable(fApplication.getSnmpProxy()));
        GponOnuVoipSvcProTable mbean = (GponOnuVoipSvcProTable) getModel();
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setOnuVoipSvcProfileIndex(tfOnuVoipSvcProfileIndex.getValue(0));
        }
        mbean.setOnuVoipSvcProfileName(new String(tfOnuVoipSvcProfileName
                .getValue()));
        mbean
                .setOnuVoIPVirtualPortNo(new Integer(tfOnuVoIPVirtualPortNo.getSelectedItem().toString()));
        mbean.setOnuVoIPConfigMethod(new Integer(
                onuVoIPConfigMethodVList[tfOnuVoIPConfigMethod.getSelectedIndex()]));
        if(onuVoIPConfigMethodVList[tfOnuVoIPConfigMethod.getSelectedIndex()]==3)
        mbean.setOnuVoIPConfigServerAddress(new String(tfOnuVoIPConfigServerAddress
                .getIPString()));
        mbean.setOnuVoIPConfigScriptLocation(new String(
                tfOnuVoIPConfigScriptLocation.getValue()));

    }
    
    public void afterUpdateModel(){
        if(SnmpAction.IType.ADD.equals(fCommand))
            tfOnuVoipSvcProfileIndex.increaseIndexValue(); 
    }
    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}
