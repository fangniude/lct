/**
 * Created by Zhou Chao, 2010/5/10
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.IgmpProxyParaTable;
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

public class IgmpProxyParaTablePanel extends UPanel {

    private IntegerTextField tfProxyIndex = new IntegerTextField();

    private StringTextField tfProxyName = new StringTextField();
    private IPAddressField tfProxySrcIPAddress = new IPAddressField();
    private IntegerTextField tfProxyMulticastVID = new IntegerTextField();
    private IPAddressField tfProxyMulticastIPAddress = new IPAddressField(IPAddressField.IPMULTICAST);
    private LongTextField tfMulticastAssuredBW = new LongTextField();
    private LongTextField tfMulticastMaxBW = new LongTextField();

    private final String proxyIndex = fStringMap.getString("proxyIndex") + " : ";
    private final String proxyName = fStringMap.getString("proxyName") + " : ";
    private final String proxySrcIPAddress = fStringMap.getString("proxySrcIPAddress") + " : ";
    private final String proxyMulticastVID = fStringMap.getString("proxyMulticastVID") + " : ";
    private final String proxyMulticastIPAddress = fStringMap.getString("proxyMulticastIPAddress") + " : ";
    private final String multicastAssuredBW = fStringMap.getString("multicastAssuredBW") + " : ";
    private final String multicastMaxBW = fStringMap.getString("multicastMaxBW") + " : ";

    public IgmpProxyParaTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(proxyIndex));
        baseInfoPanel.add(tfProxyIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(proxyName));
        tfProxyName.setName(fStringMap.getString("proxyName"));
        baseInfoPanel.add(tfProxyName);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(proxySrcIPAddress));
        tfProxySrcIPAddress.setName(fStringMap.getString("proxySrcIPAddress"));
        baseInfoPanel.add(tfProxySrcIPAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(proxyMulticastVID));
        tfProxyMulticastVID.setName(fStringMap.getString("proxyMulticastVID"));
        baseInfoPanel.add(tfProxyMulticastVID);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(proxyMulticastIPAddress));
        tfProxyMulticastIPAddress.setName(fStringMap.getString("proxyMulticastIPAddress"));
        baseInfoPanel.add(tfProxyMulticastIPAddress);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastAssuredBW));
        tfMulticastAssuredBW.setName(fStringMap.getString("multicastAssuredBW"));
        baseInfoPanel.add(tfMulticastAssuredBW);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(multicastMaxBW));
        tfMulticastMaxBW.setName(fStringMap.getString("multicastMaxBW"));
        baseInfoPanel.add(tfMulticastMaxBW);
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
        tfProxyName.setLenScope(0, 256);
        tfMulticastAssuredBW.setDefaultValue(0);
        tfMulticastMaxBW.setDefaultValue(0);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfProxyIndex.setEditable(true);
            return;
        } else {
            tfProxyIndex.setEditable(false);
        }

        IgmpProxyParaTable mbean = (IgmpProxyParaTable) getModel();
        if (mbean == null)
            return;

        tfProxyIndex.setText(mbean.getProxyIndex().toString());

        tfProxyName.setValue(mbean.getProxyName());
        tfProxySrcIPAddress.setValue(mbean.getProxySrcIPAddress());
        tfProxyMulticastVID.setValue(mbean.getProxyMulticastVID());
        tfProxyMulticastIPAddress.setValue(mbean.getProxyMulticastIPAddress());

        if(mbean.getMulticastAssuredBW() != null)
            tfMulticastAssuredBW.setValue(mbean.getMulticastAssuredBW());

        if(mbean.getMulticastMaxBW() != null)
            tfMulticastMaxBW.setValue(mbean.getMulticastMaxBW());
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new IgmpProxyParaTable(fApplication.getSnmpProxy()));

        IgmpProxyParaTable mbean = (IgmpProxyParaTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setProxyIndex(tfProxyIndex.getValue());
        }

        mbean.setProxyName(tfProxyName.getValue());
        mbean.setProxySrcIPAddress(tfProxySrcIPAddress.getIPString());
        mbean.setProxyMulticastVID(new Integer(tfProxyMulticastVID.getValue()));
        mbean.setProxyMulticastIPAddress(tfProxyMulticastIPAddress.getIPString());
        mbean.setMulticastAssuredBW(tfMulticastAssuredBW.getValue());
        mbean.setMulticastMaxBW(tfMulticastMaxBW.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}