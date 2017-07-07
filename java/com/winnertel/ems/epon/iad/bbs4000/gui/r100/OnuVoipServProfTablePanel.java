/**
 * Title          :   OnuVoipServProfTablePanel.java
 * Description    :   UTStarcom Network Management System
 * Copyright      :   Copyright (c) 2008
 * Company        :   UTStarcom
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OnuVoipServProfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Shen Dayong
 *         Create on 2008-10-2
 *         Modify by HZ21044
 */

public class OnuVoipServProfTablePanel extends UPanel {

    private LongTextField tfVoipServiceProfileIndex = new LongTextField();

    private StringTextField tfOnuVoipServProfileName = new StringTextField();

    private IntegerTextField tfOnuVoIPVirtualPortNo = new IntegerTextField();

    private int[] onuVoIPConfigMethodVList = new int[]{1, 2, 3, 4, 5,};
    private String[] onuVoIPConfigMethodTList = new String[]{
            fStringMap.getString("do-not-configure"),
            fStringMap.getString("omci"),
            fStringMap.getString("file-via-TFTP"),
            fStringMap.getString("tr-69"),
            fStringMap.getString("sip"),};

    private JComboBox tfOnuVoIPConfigMethod = new JComboBox(onuVoIPConfigMethodTList);
    private IPAddressField tfOnuVoIPConfigServerAddress = new IPAddressField();

    private final String voipServiceProfileIndex = fStringMap.getString("voipServiceProfileIndex") + " : ";
    private final String onuVoipServProfileName = fStringMap.getString("onuVoipServProfileName") + " : ";
    private final String onuVoIPVirtualPortNo = fStringMap.getString("onuVoIPVirtualPortNo") + " : ";
    private final String onuVoIPConfigMethod = fStringMap.getString("onuVoIPConfigMethod") + " : ";
    private final String onuVoIPConfigServerAddress = fStringMap.getString("onuVoIPConfigServerAddress") + " : ";

    public OnuVoipServProfTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(5, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(voipServiceProfileIndex));
        baseInfoPanel.add(tfVoipServiceProfileIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoipServProfileName));
        tfOnuVoipServProfileName.setName(fStringMap.getString("onuVoipServProfileName"));
        baseInfoPanel.add(tfOnuVoipServProfileName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoIPVirtualPortNo));
        tfOnuVoIPVirtualPortNo.setName(fStringMap.getString("onuVoIPVirtualPortNo"));
        baseInfoPanel.add(tfOnuVoIPVirtualPortNo);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoIPConfigMethod));
        tfOnuVoIPConfigMethod.setName(fStringMap.getString("onuVoIPConfigMethod"));
        baseInfoPanel.add(tfOnuVoIPConfigMethod);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(onuVoIPConfigServerAddress));
        tfOnuVoIPConfigServerAddress.setName(fStringMap.getString("onuVoIPConfigServerAddress"));
        baseInfoPanel.add(tfOnuVoIPConfigServerAddress);
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
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfVoipServiceProfileIndex.setEditable(true);
            return;
        } else {
            tfVoipServiceProfileIndex.setEditable(false);
        }
        OnuVoipServProfTable mbean = (OnuVoipServProfTable) getModel();

        tfVoipServiceProfileIndex.setText(mbean.getVoipServiceProfileIndex().toString());
        tfOnuVoipServProfileName.setValue(mbean.getOnuVoipServProfileName());
        tfOnuVoIPVirtualPortNo.setValue(mbean.getOnuVoIPVirtualPortNo().intValue());
        tfOnuVoIPConfigMethod.setSelectedIndex(getIndexFromValue(onuVoIPConfigMethodVList,
                mbean.getOnuVoIPConfigMethod().intValue()));
        tfOnuVoIPConfigServerAddress.setValue(mbean.getOnuVoIPConfigServerAddress());
    }

    public void updateModel() {

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new OnuVoipServProfTable(fApplication.getSnmpProxy()));
        }

        OnuVoipServProfTable mbean = (OnuVoipServProfTable) getModel();

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            //  here set the value of index
            mbean.setVoipServiceProfileIndex(tfVoipServiceProfileIndex.getValue());
        }


        mbean.setOnuVoipServProfileName(tfOnuVoipServProfileName.getValue());
        mbean.setOnuVoIPVirtualPortNo(new Integer(tfOnuVoIPVirtualPortNo.getValue()));
        mbean.setOnuVoIPConfigMethod(new Integer(onuVoIPConfigMethodVList[tfOnuVoIPConfigMethod.getSelectedIndex()]));
        mbean.setOnuVoIPConfigServerAddress(tfOnuVoIPConfigServerAddress.getIPString());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }

}