package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3DbaSlaTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3UnboundOnuTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.GuiUtil;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The Dot3UnboundOnuTablePanel class. Created by DVM Creator
 */
public class Dot3UnboundOnuTablePanel extends UPanel
{

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

	private final String utsDot3UnboundOnuLlid = fStringMap
			.getString("utsDot3UnboundOnuLlid")
			+ " : ";
//
//	private final String utsDot3UnboundOnuPonMacAddr = fStringMap
//			.getString("utsDot3UnboundOnuPonMacAddr")
//			+ " : ";

	public Dot3UnboundOnuTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

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

		baseInfoPanel.add(new JLabel(utsDot3UnboundOnuLlid));
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

	protected void initForm()
	{

		tfUtsDot3UnboundOnuLogicid.setValueScope(1,32);

	}

	public void refresh()
	{
		
//		Dot3UnboundOnuTable mbean = (Dot3UnboundOnuTable) getModel();
//
//		tfUtsDot3UnboundOnuModuleId.setText(mbean
//				.getUtsDot3UnboundOnuModuleId().toString());
//		tfUtsDot3UnboundOnuPortId.setText(mbean.getUtsDot3UnboundOnuPortId()
//				.toString());
		tfUtsDot3UnboundOnuLogicid.setValue(0);
//		tfUtsDot3UnboundOnuPonMacAddr.setValue(mbean
//				.getUtsDot3UnboundOnuPonMacAddr());

	}

	public void updateModel()
	{
		Dot3DbaSlaTable dbambean = new Dot3DbaSlaTable(fApplication.getSnmpProxy());
    Dot3UnboundOnuTable unboundmbean = (Dot3UnboundOnuTable) getModel();
    int moduleID = unboundmbean.getUtsDot3UnboundOnuModuleId().intValue();
    int portID = unboundmbean.getUtsDot3UnboundOnuPortId().intValue();
    int logicID = tfUtsDot3UnboundOnuLogicid.getValue();
    String ifIndex = moduleID+"/"+portID+"/"+logicID;
    dbambean.setIfOnuIndex(new Integer(ConfigUtility.generateIfIndex(ifIndex)));
    dbambean.setUtsDot3DbaSlaBindingMacAddress(unboundmbean.getUtsDot3UnboundOnuPonMacAddr());
    
    try {
      dbambean.modify();
      /*UnboundOnuMgmtMgr onuMgmtMgr = (UnboundOnuMgmtMgr) ClientUtility.getObjectFactory().getSystemMgr(-1, "UnboundOnuMgmtMgr");
      if(onuMgmtMgr != null)
      {
        String mac = ConfigUtility.OctetToMacAddress(unboundmbean.getUtsDot3UnboundOnuPonMacAddr());

        UnboundOnuMOD onu = new UnboundOnuMOD();
        onu.setCardId("" + moduleID);
        onu.setPortId("" + portID);
        onu.setLlId("" + logicID);
        onu.setNeName(fApplication.getActiveDeviceManager().getName());
        onu.setMacAddress(mac);

        onuMgmtMgr.deleteUnbindOnu(onu);
      }*/

    } catch (Exception e) {
        e.printStackTrace();
    }
	}

	public int getIndexFromValue(int[] list, int v)
	{
		for (int i = 0; i != list.length; i++)
		{
			if (list[i] == v)
				return i;
		}
		return 0;
	}
    public void afterUpdateModel() {
        GuiUtil.getParentDialog( this ).dispose();
                        
    }
}