package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3UnboundOnuTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

public class Dot3UnboundOnuTablePanel extends UPanel {

//	private JLabel tfUtsDot3UnboundOnuModuleId = new JLabel();

//	private JLabel tfUtsDot3UnboundOnuPortId = new JLabel();

    private IntegerTextField tfUtsDot3UnboundOnuLogicid = new IntegerTextField();

//
//	private MacAddressField tfUtsDot3UnboundOnuPonMacAddr = new MacAddressField();
//
//	private final String utsDot3UnboundOnuModuleId = fStringMap
//			.getString("utsDot3UnboundOnuModuleId")
//			+ " : ";
//
//	private final String utsDot3UnboundOnuPortId = fStringMap
//			.getString("utsDot3UnboundOnuPortId")
//			+ " : ";

    private final String utsDot3UnboundOnuLogicid = fStringMap
            .getString("utsDot3UnboundOnuLogicid")
            + " : ";
//
//	private final String utsDot3UnboundOnuPonMacAddr = fStringMap
//			.getString("utsDot3UnboundOnuPonMacAddr")
//			+ " : ";

    public Dot3UnboundOnuTablePanel(IApplication app) {
        super(app);

        init();
    }

    public void initGui() {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5,
                5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
//
//		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuModuleId));
//		baseInfoPanel.add(tfUtsDot3UnboundOnuModuleId);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuPortId));
//		baseInfoPanel.add(tfUtsDot3UnboundOnuPortId);
//		baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsDot3UnboundOnuLogicid));
        baseInfoPanel.add(tfUtsDot3UnboundOnuLogicid);
        baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuPonMacAddr));
//		tfUtsDot3UnboundOnuPonMacAddr.setValue( "00:00:00:00:00:00" );
//		baseInfoPanel.add(tfUtsDot3UnboundOnuPonMacAddr);
//		baseInfoPanel.add(new HSpacer());

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
        tfUtsDot3UnboundOnuLogicid.setValueScope(1, 64);
    }

    public void refresh() {
		Dot3UnboundOnuTable mbean = (Dot3UnboundOnuTable) getModel();

        tfUtsDot3UnboundOnuLogicid.setValue(mbean.getUtsDot3UnboundOnuLlid());
    }

    public void updateModel() {
        Dot3UnboundOnuTable unbound = (Dot3UnboundOnuTable) getModel();

        unbound.setUtsDot3UnboundOnuId(tfUtsDot3UnboundOnuLogicid.getValue());
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }
        return 0;
    }
}
