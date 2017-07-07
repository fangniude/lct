package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPIPAddressRangeMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolDefaultRouterTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolExcludeTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolIncludeTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.DHCPPoolTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.command.RefreshAllCommand;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-9-6
 * Time: 14:46:50
 * To change this template use File | Settings | File Templates.
 */
public class DHCPIPAddressRangePanel extends UPanel {

    private JLabel lName = new JLabel( fStringMap.getString( "utsDHCPPoolName" ) + ":" );
    private JLabel lIPAddress = new JLabel( fStringMap.getString( "utsDHCPPoolNetworkAddress") + ":" );
    private JLabel lMask = new JLabel( fStringMap.getString("utsDHCPPoolNetworkMask") + ":" );
    private JLabel lGateway = new JLabel( fStringMap.getString("DHCPIPAddressDefaultGateway") + ":" );

    private StringTextField tfName = new StringTextField();
    private IPAddressField tfIPAddress = new IPAddressField();
    private IPAddressField tfMask = new IPAddressField(true);
    private IPAddressField tfGateway  = new IPAddressField();

    private SnmpTablePane tablepanel1;
    private SnmpTablePane tablepanel2;


    CardLayout card = new CardLayout();
    JPanel panecard = new JPanel();
    JPanel[] panes = new JPanel[2];


    public DHCPIPAddressRangePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {


//
        JPanel allPanel = new JPanel();
        NTLayout layout = new NTLayout(3, 1, NTLayout.CENTER, NTLayout.CENTER, 5, 3);
//        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);


        JPanel infopanel = new JPanel();
        layout = new NTLayout(  2,4,NTLayout.FILL,NTLayout.CENTER,5,3);
        infopanel.setLayout(layout);
        infopanel.setBorder(BorderFactory.createTitledBorder( fStringMap.getString("DHCPIPAddressPoolInformation")));
        infopanel.setPreferredSize(new Dimension(800,100));

        infopanel.add(lName);
        infopanel.add(tfName);
        tfName.setEditable(false);
        tfName.setPreferredSize(new Dimension(150,20));
        infopanel.add(lMask);
        infopanel.add(tfMask);
        tfMask.setEditable(false);

        infopanel.add(lIPAddress);
        infopanel.add(tfIPAddress);
        tfIPAddress.setEditable(false);
        infopanel.add(lGateway);
        infopanel.add(tfGateway);
        tfGateway.setEditable(false);

        allPanel.add(infopanel);

        JPanel includePanel = new JPanel();
        layout = new NTLayout(1,1,NTLayout.CENTER,NTLayout.CENTER,5,3);
        includePanel.setLayout(layout);
        includePanel.setBorder(BorderFactory.createTitledBorder( fStringMap.getString("utsDHCPPoolIncludedIpAddress")) );

        IGuiComposer composer1 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel1 = (SnmpTablePane) composer1.composeSnmpTablePane( "DHCPPoolIncludeTable" );
        tablepanel1.setPreferredSize(new Dimension(400, 300));
        includePanel.add(tablepanel1);


        JPanel excludePanel = new JPanel();
        layout = new NTLayout(1,1,NTLayout.CENTER,NTLayout.CENTER,5,3);
        excludePanel.setLayout(layout);
        excludePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("utsDHCPPoolExcludedIpAddress")));

        IGuiComposer composer2 = fApplication.getActiveDeviceManager().getGuiComposer();
        tablepanel2 = (SnmpTablePane) composer2.composeSnmpTablePane("DHCPPoolExcludeTable");
        tablepanel2.setPreferredSize(new Dimension(100, 200));
        tablepanel2.setPreferredSize(new Dimension(400, 300));
        excludePanel.add(tablepanel2);


        JPanel ipPanel = new JPanel();
        layout = new NTLayout(1,2,NTLayout.CENTER,NTLayout.CENTER,5,3);
        ipPanel.setLayout(layout);
        ipPanel.add(includePanel);
        ipPanel.add(excludePanel);

        allPanel.add(ipPanel);
        allPanel.add(new VSpacer());

        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    public void refresh() {

        DHCPIPAddressRangeMBean mbean = (DHCPIPAddressRangeMBean) getModel();
        DHCPPoolTable tmbean = new DHCPPoolTable(fApplication.getSnmpProxy());
        DHCPPoolTable one = new DHCPPoolTable(fApplication.getSnmpProxy());
        try {
            Vector v = tmbean.retrieveAll();
            for(int i=0;i<v.size();i++){
                one = (DHCPPoolTable)v.get(i);
                if(one.getUtsDHCPPoolName().equals(mbean.getUtsDHCPPoolName())){
                    break;
                }
            }
        }catch (MibBeanException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        DHCPPoolIncludeTableMBean mbean1 = (DHCPPoolIncludeTableMBean)tablepanel1.getModel();
        DHCPIPAddressRangeMBean mbean3 = (DHCPIPAddressRangeMBean)getModel();
        mbean1.setPoolName(mbean.getUtsDHCPPoolName());

        tablepanel1.refresh();
        mbean3.setName(mbean.getUtsDHCPPoolName());
        DHCPPoolExcludeTableMBean mbean2 = (DHCPPoolExcludeTableMBean)tablepanel2.getModel();
        mbean2.setPoolName(mbean.getUtsDHCPPoolName());
        tablepanel2.refresh();

        tfName.setValue(mbean.getUtsDHCPPoolName());
        tfIPAddress.setValue(one.getUtsDHCPPoolNetworkAddress());
        tfMask.setValue(one.getUtsDHCPPoolNetworkMask());
        DHCPPoolDefaultRouterTable gatewaymbean = new DHCPPoolDefaultRouterTable(fApplication.getSnmpProxy());
        Vector v = new Vector();
        try {
            v = gatewaymbean.retrieveAll();
        } catch (MibBeanException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if(v!=null){
            for(int i=0;i<v.size();i++){
                DHCPPoolDefaultRouterTable gateone = (DHCPPoolDefaultRouterTable)v.get(i);
                if(gateone.getUtsDHCPPoolName().equals(mbean.getUtsDHCPPoolName())){
                    tfGateway.setValue(gateone.getUtsDHCPPoolDefaultRouterIpAddress());
                }
            }
        }
    }

    public boolean validateFrom(){
        
        return true;
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

    void show(int result){
        panecard.removeAll();
        panecard.add(panes[result-1],"panes"+result);
        card.show(panecard,"panes"+result);
        this.repaint();
    }

    public void afterUpdateModel() {
        GuiUtil.getParentDialog( this ).dispose();

        new RefreshAllCommand(fApplication, fTable).execute();
    }
}

