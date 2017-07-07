/**
 * Created by Zhou Chao, 2008/9/30 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing.ProfileBrowser;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuEthUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuPotsUniCfgMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuServiceConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVirtualPortConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.GponOnuVoipConfigureMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltPonLinkCfgTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import javax.swing.*;
import java.awt.*;

public class GponProfileViewPanel extends UPanel {

    private static long MAX_INDEX = 999999;

    private ProfileBrowser browser = null;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private String name = ""; //(Reserved)

    public GponProfileViewPanel(IApplication app) {
        super(app);
        browser = new ProfileBrowser(app);
        init();
    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap.getString(s);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initGui() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(700, 400));
    }

    protected void initForm() {
    }

    public void refresh() {
        IMibBean mibean = getModel();
        if (mibean == null)
            return;

        long index = 0;
        String tableView = "";
        String leafView = "";
        long[] indexes = null;
        String prefix = "";

        tabbedPane.removeAll();

        if (mibean instanceof GponOnuServiceConfigureMBean) {
            GponOnuServiceConfigureMBean mbean = (GponOnuServiceConfigureMBean) mibean;

            int upstreamTrafficMappingType = (mbean.getOnuCfgUpstreamTrafficMappingType() != null) ? mbean.getOnuCfgUpstreamTrafficMappingType() : 0;
            index = (mbean.getOnuCfgUpstreamTrafficMappingProfileIndex() != null) ? mbean.getOnuCfgUpstreamTrafficMappingProfileIndex() : 0;

            /**
             * Upstream Traffic Mapping Profile Table
             *   upstreamTrafficMappingType
             *     1: ONU User Port (table: OnuUPUTMProfTable_Panel, panel: com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPUTMProfTablePanel)
             *     2: ONU VLAN ID (table: , panel: )
             *     3: ONU VLAN Priority Bits (table: , panel: )
             *     4: ONU VLAN ID and VLAN Priority Bits (table: , panel: )
             *     5, 6: (reserved) ()
             *     7, 8: ONU User Port and CoS (table: OnuUPCUTMProfTable_Panel, panel: com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPCUTMProfTablePanel)
             */
            if (upstreamTrafficMappingType == 1) {
                tableView = "OnuUPUTMProfTable_Panel";
                leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPUTMProfTablePanel";
                indexes = new long[]{index - 1, MAX_INDEX};
                prefix = String.valueOf(index);
                tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
            } else if (upstreamTrafficMappingType == 2) {
                tableView = "OnuVlanIdUpTrafficMapProfTable_Panel";
                leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuVlanIdUpTrafficMapProfTablePanel";
                indexes = new long[]{index - 1, MAX_INDEX};
                prefix = String.valueOf(index);
                tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
            } else if (upstreamTrafficMappingType == 3) {
                tableView = "OnuVlanPriBitsUpTrafficMapProfTable_Panel";
                leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuVlanPriBitsUpTrafficMapProfTablePanel";
                indexes = new long[]{index - 1, MAX_INDEX};
                prefix = String.valueOf(index);
                tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
            } else if (upstreamTrafficMappingType == 4) {
                tableView = "OnuVlanIdVlanPriBitUpTrafficMapProfTable_Panel";
                leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuVlanIdVlanPriBitUpTrafficMapProfTablePanel";
                indexes = new long[]{index - 1, MAX_INDEX};
                prefix = String.valueOf(index);
                tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
            } else if (upstreamTrafficMappingType == 7 || upstreamTrafficMappingType == 8) {
                tableView = "OnuUPCUTMProfTable_Panel";
                leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuUPCUTMProfTablePanel";
                indexes = new long[]{index - 1, MAX_INDEX};
                prefix = String.valueOf(index);
                tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
            }

            index = (mbean.getOnuCfgTcontVirtualPortBindingProfileIndex() != null) ? mbean.getOnuCfgTcontVirtualPortBindingProfileIndex() : 0;
            tableView = "OnuTcontVPortBindProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuTcontVPortBindProfTablePanel";
            indexes = new long[]{index - 1, MAX_INDEX};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            /* (Reserved)
            index = (mbean.getOnuCfgOnuStaticMulticastGroupsProfileIndex() != null) ? mbean.getOnuCfgOnuStaticMulticastGroupsProfileIndex() : 0;
            tableView = "OnuStaticMultiGroupProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuStaticMultiGroupProfTablePanel";
            indexes = new long[]{index - 1, MAX_INDEX};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
            */
        }

        if (mibean instanceof GponOnuVoipConfigureMBean) {
            GponOnuVoipConfigureMBean mbean = (GponOnuVoipConfigureMBean) mibean;

            index = (mbean.getOnuCfgOnuVoIPServiceProfileIndex() != null) ? mbean.getOnuCfgOnuVoIPServiceProfileIndex() : 0;
            tableView = "GponOnuVoipSvcProTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.GponOnuVoipSvcProTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
        }

        if (mibean instanceof OltPonLinkCfgTable) {
            OltPonLinkCfgTable mbean = (OltPonLinkCfgTable) mibean;

            index = (mbean.getOltPonLinkCfgProtocolProfileIndex() != null) ? mbean.getOltPonLinkCfgProtocolProfileIndex() : 0;
            tableView = "OltGponProtocolProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OltGponProtocolProfTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
        }

        if (mibean instanceof GponOnuVirtualPortConfigureMBean) {
            GponOnuVirtualPortConfigureMBean mbean = (GponOnuVirtualPortConfigureMBean) mibean;

            index = (mbean.getOnuVirtualPortCfgoltVLANTranslationProfileIndex() != null) ? mbean.getOnuVirtualPortCfgoltVLANTranslationProfileIndex() : 0;
            tableView = "OltVlanTransProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OltVlanTransProfTablePanel";
            indexes = new long[]{index - 1, MAX_INDEX};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuVirtualPortCfgOnuMACFilterProfileIndex() != null) ? mbean.getOnuVirtualPortCfgOnuMACFilterProfileIndex() : 0;
            tableView = "GponOnuMacFilterProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.GponOnuMacFilterProfTablePanel";
            indexes = new long[]{index - 1, MAX_INDEX};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex() != null) ? mbean.getOnuVirtualPortCfgOnuMACFilterPreassignProfileIndex() : 0;
            tableView = "OnuMacFilterPreassignProTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuMacFilterPreassignProTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            /* (Reserved)
            index = (mbean.getOnuVirtualPortCfgOnuVlanFilterProfileIndex() != null) ? mbean.getOnuVirtualPortCfgOnuVlanFilterProfileIndex() : 0;
            tableView = "OnuVlanFilterProfileTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuVlanFilterProfileTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
            */
        }

        if (mibean instanceof GponOnuEthUniCfgMBean) {
            GponOnuEthUniCfgMBean mbean = (GponOnuEthUniCfgMBean) mibean;

            index = (mbean.getOnuEthUniCfgOnuVLANTranslationProfileIndex() != null) ? mbean.getOnuEthUniCfgOnuVLANTranslationProfileIndex() : 0;
            tableView = "OnuVlanTransProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuVlanTransProfTablePanel";
            indexes = new long[]{index - 1, MAX_INDEX};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuEthUniCfgOnuMulticastOperationProfileIndex() != null) ? mbean.getOnuEthUniCfgOnuMulticastOperationProfileIndex() : 0;
            tableView = "GponOnuMulticastOperProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.GponOnuMulticastOperProfTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex() != null) ? mbean.getOnuEthUniCfgOnuStaticMulticastGroupsProfileIndex() : 0;
            tableView = "OnuStaticMultiGroupProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuStaticMultiGroupProfTablePanel";
            indexes = new long[]{index - 1, MAX_INDEX};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuEthUniCfgEthernetUNIProfileIndex() != null) ? mbean.getOnuEthUniCfgEthernetUNIProfileIndex() : 0;
            tableView = "OnuEthUniCfgProTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuEthUniCfgProTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuEthUniCfgOnuMACFilterProfileIndex() != null) ? mbean.getOnuEthUniCfgOnuMACFilterProfileIndex() : 0;
            tableView = "GponOnuMacFilterProfTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.GponOnuMacFilterProfTablePanel";
            indexes = new long[]{index - 1, MAX_INDEX};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuEthUniCfgOnuMACFilterPreassignProfileIndex() != null) ? mbean.getOnuEthUniCfgOnuMACFilterPreassignProfileIndex() : 0;
            tableView = "OnuMacFilterPreassignProTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuMacFilterPreassignProTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));

            index = (mbean.getOnuEthUniCfgOnuVlanFilterProfileIndex() != null) ? mbean.getOnuEthUniCfgOnuVlanFilterProfileIndex() : 0;
            tableView = "OnuVlanFilterProfileTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.OnuVlanFilterProfileTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
        }

        if (mibean instanceof GponOnuPotsUniCfgMBean) {
            GponOnuPotsUniCfgMBean mbean = (GponOnuPotsUniCfgMBean) mibean;

            index = (mbean.getOnuPotsUniCfgOnuVoIPServiceProfileIndex() != null) ? mbean.getOnuPotsUniCfgOnuVoIPServiceProfileIndex() : 0;
            tableView = "GponOnuVoipSvcProTable_Panel";
            leafView = "com.winnertel.ems.epon.iad.bbs4000.gui.r100.GponOnuVoipSvcProTablePanel";
            indexes = new long[]{index - 1};
            prefix = String.valueOf(index);
            tabbedPane.addTab(getString(tableView), new JScrollPane(browser.getComponent(tableView, leafView, indexes, prefix)));
        }

        if (tabbedPane.getTabCount() > 0)
            tabbedPane.setSelectedIndex(0);

        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            JScrollPane pane = (JScrollPane) tabbedPane.getComponentAt(i);
            UPanel panel = (UPanel) pane.getViewport().getComponent(0);

            //all the view panel except snmptablepane are not refresh, so refresh them after they are added into the tabbedpane. 
            if (!(panel instanceof SnmpTablePane)) {
                panel.refresh();
            }
        }
    }

    public void updateModel() {
    }

}