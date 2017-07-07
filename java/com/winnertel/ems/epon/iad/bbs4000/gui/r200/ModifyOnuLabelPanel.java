package com.winnertel.ems.epon.iad.bbs4000.gui.r200;

import com.winnertel.ems.epon.iad.bbs4000.mib.r200.OnuMonitorTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class ModifyOnuLabelPanel extends UPanel {
    private JLabel tfIfOnuIndex = new JLabel();
    private StringTextField tfOnuLabel = new StringTextField();

    private final String ifOnuIndex = getString("ifOnuIndex") + " : ";
    private final String onuLabel = getString("onuLabel") + " : ";

    public ModifyOnuLabelPanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(ifOnuIndex));
        baseInfoPanel.add(tfIfOnuIndex);
        baseInfoPanel.add(new HSpacer());


        baseInfoPanel.add(new JLabel(onuLabel));
        tfOnuLabel.setName(getString("onuLabel"));
        baseInfoPanel.add(tfOnuLabel);
        baseInfoPanel.add(new HSpacer());

        setLayout(new BorderLayout());
        add(baseInfoPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
    }

    public void refresh() {
        OnuMonitorTable mbean = (OnuMonitorTable) getModel();
        if (mbean == null)
            return;

        tfIfOnuIndex.setText(mbean.getIfOnuIndex().toString());
        tfOnuLabel.setValue(mbean.getOnuLabel());
    }

    public void updateModel() {
        OnuMonitorTable mbean = (OnuMonitorTable) getModel();
        if (mbean == null)
            return;
//
//        if (!fApplication.isDebug()) {
//            try {
//                String newLabel = tfOnuLabel.getValue().trim();
//                if (!newLabel.equals(mbean.getOnuLabel())) {
//                    OnuMgmtMgr onuMgmtMgr = (OnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "OnuMgmtMgr");
//                    onuMgmtMgr.modifyOnuLabel(Main.getApplet().getClientID(),Dot3Onu2CtcSerialNumberFormatter.getMacAddress(mbean.getUtsDot3Onu2SerialNumber()), newLabel);
//
//                    mbean.setOnuLabel(tfOnuLabel.getValue());
//                }
//
//            } catch (RemoteException e) {
//                e.printStackTrace();
//                MessageDialog.showOperationFailedDialog(fApplication);
//            }
//        } else {
//            mbean.setOnuLabel(tfOnuLabel.getValue());
//        }

        mbean.setOnuLabel(tfOnuLabel.getValue());

    }

    @Override
    public boolean validateFrom() {
        if ("".equals(tfOnuLabel.getValue().trim())) {
            return false;
        } else {
            return true;
        }
    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap != null ? fStringMap.getString(s) : s;
    }

}