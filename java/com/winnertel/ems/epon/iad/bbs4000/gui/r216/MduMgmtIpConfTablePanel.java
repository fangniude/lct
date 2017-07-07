/**
 * Created by Zhou Chao, 2009/11/3
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r216;

import com.winnertel.ems.epon.iad.bbs4000.mib.r216.MduMgmtIpConfTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;
import com.winnertel.nms.lite.client.rmi.ScoaAPI;
import com.winnertel.nms.lite.momodel.ManagedElement;

import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.util.List;

public class MduMgmtIpConfTablePanel extends UPanel {

    private IPAddressField tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr = new IPAddressField();
    private IPAddressField tfUtsDot3Onu2CtcMduMgmtIpConfIpMask = new IPAddressField(IPAddressField.IPMASK);
    private IPAddressField tfUtsDot3Onu2CtcMduMgmtIpConfGw = new IPAddressField();

    private IntegerTextField tfUtsDot3Onu2CtcMduMgmtIpConfCvlan = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcMduMgmtIpConfSvlan = new IntegerTextField();
    private IntegerTextField tfUtsDot3Onu2CtcMduMgmtIpConfDataPrio = new IntegerTextField();

    private final String utsDot3Onu2CtcMduMgmtIpConfIpAddr = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpAddr") + ": ";
    private final String utsDot3Onu2CtcMduMgmtIpConfIpMask = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpMask") + ": ";
    private final String utsDot3Onu2CtcMduMgmtIpConfGw = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfGw") + ": ";
    private final String utsDot3Onu2CtcMduMgmtIpConfCvlan = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfCvlan") + ": ";
    private final String utsDot3Onu2CtcMduMgmtIpConfSvlan = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfSvlan") + ": ";
    private final String utsDot3Onu2CtcMduMgmtIpConfDataPrio = fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfDataPrio") + ": ";

    private String oldIpAddress = null;

    public MduMgmtIpConfTablePanel(IApplication app) {
        super(app);
        init();
    }

    protected void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(6, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfIpAddr));
        tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr.setName(fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpAddr"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfIpMask));
        tfUtsDot3Onu2CtcMduMgmtIpConfIpMask.setName(fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfIpMask"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfIpMask);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfGw));
        tfUtsDot3Onu2CtcMduMgmtIpConfGw.setName(fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfGw"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfGw);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfCvlan));
        tfUtsDot3Onu2CtcMduMgmtIpConfCvlan.setName(fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfCvlan"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfCvlan);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfSvlan));
        tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setName(fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfSvlan"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfSvlan);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3Onu2CtcMduMgmtIpConfDataPrio));
        tfUtsDot3Onu2CtcMduMgmtIpConfDataPrio.setName(fStringMap.getString("utsDot3Onu2CtcMduMgmtIpConfDataPrio"));
        baseInfoPanel.add(tfUtsDot3Onu2CtcMduMgmtIpConfDataPrio);
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
        tfUtsDot3Onu2CtcMduMgmtIpConfCvlan.setValueScope(1, 4094);

        tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setValueScope(0, 4094);
        tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setValue(0);

        tfUtsDot3Onu2CtcMduMgmtIpConfDataPrio.setValueScope(0, 7);
        tfUtsDot3Onu2CtcMduMgmtIpConfDataPrio.setValue(5);
    }

    public void refresh() {
        MduMgmtIpConfTable mbean = (MduMgmtIpConfTable) getModel();
        if (mbean == null)
            return;

        tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr.setValue(mbean.getUtsDot3Onu2CtcMduMgmtIpConfIpAddr() != null ? mbean.getUtsDot3Onu2CtcMduMgmtIpConfIpAddr() : "");
        tfUtsDot3Onu2CtcMduMgmtIpConfIpMask.setValue(mbean.getUtsDot3Onu2CtcMduMgmtIpConfIpMask() != null ? mbean.getUtsDot3Onu2CtcMduMgmtIpConfIpMask() : "");
        tfUtsDot3Onu2CtcMduMgmtIpConfGw.setValue(mbean.getUtsDot3Onu2CtcMduMgmtIpConfGw() != null ? mbean.getUtsDot3Onu2CtcMduMgmtIpConfGw() : "");

        tfUtsDot3Onu2CtcMduMgmtIpConfCvlan.setValue(mbean.getUtsDot3Onu2CtcMduMgmtIpConfCvlan());
        tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.setValue((mbean.getUtsDot3Onu2CtcMduMgmtIpConfSvlan() >= 0 && mbean.getUtsDot3Onu2CtcMduMgmtIpConfSvlan() <= 4094) ? mbean.getUtsDot3Onu2CtcMduMgmtIpConfSvlan() : 0);
        tfUtsDot3Onu2CtcMduMgmtIpConfDataPrio.setValue((mbean.getUtsDot3Onu2CtcMduMgmtIpConfDataPrio() >= 0 && mbean.getUtsDot3Onu2CtcMduMgmtIpConfDataPrio() <= 7) ? mbean.getUtsDot3Onu2CtcMduMgmtIpConfDataPrio() : 5);
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            setModel(new MduMgmtIpConfTable(fApplication.getSnmpProxy()));
        }

        MduMgmtIpConfTable mbean = (MduMgmtIpConfTable) getModel();
        if (mbean == null)
            return;

        oldIpAddress = mbean.getUtsDot3Onu2CtcMduMgmtIpConfIpAddr();
        mbean.setUtsDot3Onu2CtcMduMgmtIpConfIpAddr(tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr.getIPString());
        mbean.setUtsDot3Onu2CtcMduMgmtIpConfIpMask(tfUtsDot3Onu2CtcMduMgmtIpConfIpMask.getIPString());
        mbean.setUtsDot3Onu2CtcMduMgmtIpConfGw(tfUtsDot3Onu2CtcMduMgmtIpConfGw.getIPString());

        mbean.setUtsDot3Onu2CtcMduMgmtIpConfCvlan(tfUtsDot3Onu2CtcMduMgmtIpConfCvlan.getValue());
        mbean.setUtsDot3Onu2CtcMduMgmtIpConfSvlan(tfUtsDot3Onu2CtcMduMgmtIpConfSvlan.getValue());
        mbean.setUtsDot3Onu2CtcMduMgmtIpConfDataPrio(tfUtsDot3Onu2CtcMduMgmtIpConfDataPrio.getValue());
    }

    public void afterUpdateModel() {
//        if(!DebugMode.isDebug()) {
            if(!tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr.getIPString().equals(oldIpAddress)) {
                try {
                    List list = ScoaAPI.getApiFactory().getRemoteTopoAPI().getMEListByAddress(oldIpAddress);

                    if(list != null && list.size() > 0) {
                        String msg = fStringMap.getString("Modify_IP_IN_TOPO");
                        if(JOptionPane.OK_OPTION == MessageDialog.showConfirmDialog(fApplication, msg)) {
                            ManagedElement me = (ManagedElement)list.get(0);

                            me.setIpAddress(tfUtsDot3Onu2CtcMduMgmtIpConfIpAddr.getIPString());

                            ScoaAPI.getApiFactory().getRemoteTopoAPI().updateMO(me);
                        }
                    }
                } catch(RemoteException e) {
                    e.printStackTrace();
                }
            }
//        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}