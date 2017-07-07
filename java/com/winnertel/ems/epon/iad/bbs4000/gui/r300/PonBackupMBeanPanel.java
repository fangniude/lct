/**
 * Created by Zhou Chao, 2008/8/2 (for BBS4000 v3.0.0)
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.ems.epon.iad.bbs4000.mib.r300.Dot3Olt2PortTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r300.PonBackupMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PonBackupMBeanPanel extends UPanel {

    private JLabel tfUtsSrcPonPort = new JLabel();
    private JComboBox tfUtsDesPonPort = new JComboBox();

    private final String utsSrcPonPort = fStringMap.getString("utsSrcPonPort") + ": ";
    private final String utsDesPonPort = fStringMap.getString("utsDesPonPort") + ": ";

    private boolean modified = false;

    public PonBackupMBeanPanel(IApplication app) {
        super(app);
        setModel(new Dot3Olt2PortTable(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5); //modified by Zhou Chao, 2008/8/2
        layout.setMargins(7, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsSrcPonPort));
        baseInfoPanel.add(tfUtsSrcPonPort);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDesPonPort));
        tfUtsDesPonPort.setName(fStringMap.getString("utsDesPonPort"));
        baseInfoPanel.add(tfUtsDesPonPort);
        baseInfoPanel.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    public void refresh() {
        if(!modified) {
            PonBackupMBean mbean = (PonBackupMBean) getModel();

            tfUtsSrcPonPort.setText(mbean.getUtsSrcPonModuleId() + "/" + mbean.getUtsSrcPonPortId());

            tfUtsDesPonPort.removeAllItems();
            Dot3Olt2PortTable table = new Dot3Olt2PortTable(fApplication.getSnmpProxy());
            Vector v = BeanService.refreshTableBean(fApplication, table);

            for(int i = 0; i < v.size(); i++) {
                Dot3Olt2PortTable port = (Dot3Olt2PortTable)v.get(i);

                if(!(port.getUtsDot3OltModuleId().equals(mbean.getUtsSrcPonModuleId()) && port.getUtsDot3OltPortId().equals(mbean.getUtsSrcPonPortId()))) {
                    tfUtsDesPonPort.addItem(port.getUtsDot3OltModuleId() + "/" + port.getUtsDot3OltPortId());
                }
            }
        }

        modified = false;
    }

    public void updateModel() {
        PonBackupMBean mbean = (PonBackupMBean) getModel();

        String port = (String) tfUtsDesPonPort.getSelectedItem();
        int index = port.indexOf('/');
        mbean.setUtsBackupPonModuleId(Integer.parseInt(port.substring(0, index)));
        mbean.setUtsBackupPonPortId(Integer.parseInt(port.substring(index + 1)));

        modified = true;
    }
}