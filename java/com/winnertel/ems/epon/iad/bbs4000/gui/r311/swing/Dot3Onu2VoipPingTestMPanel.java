package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipPingTestResultTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.Dot3Onu2VoipPingTestTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;

import java.awt.*;

public class Dot3Onu2VoipPingTestMPanel extends UPanel {

	private UPanel voipPingTestPanel;
    private SnmpTablePane voipPingTestResultPanel;
//	private UPanel voipPingTestResultPanel;
    
	public Dot3Onu2VoipPingTestMPanel(IApplication app) {
		super(app);
		init();
	}

	@Override
	protected void initGui() {
		voipPingTestPanel = new Dot3Onu2VoipPingTestTablePanel(fApplication);
		voipPingTestPanel.setPreferredSize(new Dimension(900, 200));

		IGuiComposer composer = fApplication.getActiveDeviceManager()
				.getGuiComposer();
		voipPingTestResultPanel = (SnmpTablePane) composer
				.composeSnmpTablePane("Dot3Onu2VoipPingTestResultTable_Panel");
//		voipPingTestResultPanel = new Dot3Onu2VoipPingTestResultTablePanel(fApplication);
		voipPingTestResultPanel.setPreferredSize(new Dimension(900, 200));

		setLayout(new BorderLayout());
		add(voipPingTestPanel, BorderLayout.CENTER);
		add(voipPingTestResultPanel, BorderLayout.SOUTH);
		
	}

	@Override
	public void refresh() {
		voipPingTestPanel.refresh();
//		try {
//			voipPingTestResultPanel.getModel().retrieve();
//		}
//		catch(Exception e){}
		voipPingTestResultPanel.refresh();
	}
	
	public void setModel(IMibBean aModel) {
		super.setModel(aModel);
		voipPingTestPanel.setModel(aModel);
		Dot3Onu2VoipPingTestTable bean = (Dot3Onu2VoipPingTestTable)aModel;
		
		Dot3Onu2VoipPingTestResultTable resultBean = (Dot3Onu2VoipPingTestResultTable)voipPingTestResultPanel.getModel();
		if(resultBean == null)
			resultBean = new Dot3Onu2VoipPingTestResultTable(fApplication.getSnmpProxy());
		resultBean.setUtsDot3Onu2VoipModuleId(bean.getUtsDot3Onu2VoipModuleId());
		resultBean.setUtsDot3Onu2VoipDeviceId(bean.getUtsDot3Onu2VoipDeviceId());
		resultBean.setUtsDot3Onu2VoipPortId(bean.getUtsDot3Onu2VoipPortId());
		resultBean.setUtsDot3Onu2VoipLogicalPortId(bean.getUtsDot3Onu2VoipLogicalPortId());
		resultBean.setIndexPrefix(bean.getUtsDot3Onu2VoipModuleId()+"."+bean.getUtsDot3Onu2VoipDeviceId()+"."+
				bean.getUtsDot3Onu2VoipPortId()+"."+bean.getUtsDot3Onu2VoipLogicalPortId());
		voipPingTestResultPanel.setModel(resultBean);
    }
}