package com.winnertel.ems.epon.iad.bbs4000.gui.r210;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PortDiagnosisMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The PortDiagnosisMBeanPanel class. Created by DVM Creator
 */
public class PortDiagnosisMBeanPanel extends UPanel {

	private JLabel tfUtsDot3OltPortDiagnosisModuleId = new JLabel();

//	private JLabel tfUtsDot3OltPortDiagnosisDeviceId = new JLabel();

	private JLabel tfUtsDot3OltPortDiagnosisPortId = new JLabel();

	private JProgressBar pbDiagnosisStatus = new JProgressBar(0, 100 );

	private JLabel tfUtsDot3OltPortDiagnosisResult = new JLabel();

	private final String utsDot3OltPortDiagnosisModuleId = fStringMap
			.getString("utsDot3OltPortDiagnosisModuleId")
			+ " : ";
//	private final String utsDot3OltPortDiagnosisDeviceId = fStringMap
//			.getString("utsDot3OltPortDiagnosisDeviceId")
//			+ " : ";
	private final String utsDot3OltPortDiagnosisPortId = fStringMap
			.getString("utsDot3OltPortDiagnosisPortId")
			+ " : ";
//	private final String utsDot3OltPortDiagnosisAction = fStringMap
//			.getString("utsDot3OltPortDiagnosisAction")
//			+ " : ";
	private final String utsDot3OltPortDiagnosisStatus = fStringMap
			.getString("utsDot3OltPortDiagnosisStatus")
			+ " : ";
	private final String utsDot3OltPortDiagnosisResult = fStringMap
			.getString("utsDot3OltPortDiagnosisResult")
			+ " : ";

	SnmpTablePane tablePane = null;
	public PortDiagnosisMBeanPanel(IApplication app) {
		super(app);

		init();
	}

	public void initGui() {
		
		IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
		tablePane = (SnmpTablePane)composer.composeSnmpTablePane( "OnuDiagnosisTableDetail_Panel" );		

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsDot3OltPortDiagnosisModuleId));
		baseInfoPanel.add(tfUtsDot3OltPortDiagnosisModuleId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltPortDiagnosisPortId));
		baseInfoPanel.add(tfUtsDot3OltPortDiagnosisPortId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltPortDiagnosisStatus));
		baseInfoPanel.add( pbDiagnosisStatus );
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsDot3OltPortDiagnosisResult));
		baseInfoPanel.add(tfUtsDot3OltPortDiagnosisResult);
		baseInfoPanel.add(new HSpacer());

		JPanel allPanel = new JPanel();
		layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
		layout.setMargins(6, 10, 6, 10);
		allPanel.setLayout(layout);
		allPanel.add(baseInfoPanel);
		allPanel.add(new VSpacer());
		
		setLayout(new BorderLayout());
		add( tablePane, BorderLayout.CENTER );
		add( allPanel, BorderLayout.SOUTH );
	}

	protected void initForm() {
		tablePane.refresh();
		tablePane.getTable().getSelectionModel( ).addListSelectionListener( new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				SnmpTableModel tableModel = (SnmpTableModel) tablePane.getTable().getModel();
				SnmpMibBean bean = tableModel.getRow(tablePane.getTable().getSelectedRow());
				setModel( bean );
			}
		});
		
		startAutoRefresh( );
	}

	public void refresh() {

		PortDiagnosisMBean mbean = (PortDiagnosisMBean) getModel();
		if ( mbean == null ) return;

		tfUtsDot3OltPortDiagnosisModuleId.setText(mbean
				.getUtsDot3OltPortDiagnosisModuleId().toString());
//		tfUtsDot3OltPortDiagnosisDeviceId.setText(mbean
//				.getUtsDot3OltPortDiagnosisDeviceId().toString());
		tfUtsDot3OltPortDiagnosisPortId.setText(mbean
				.getUtsDot3OltPortDiagnosisPortId().toString());
		pbDiagnosisStatus.setValue( mbean.getUtsDot3OltPortDiagnosisStatus().intValue() );
		tfUtsDot3OltPortDiagnosisResult.setText(mbean
				.getUtsDot3OltPortDiagnosisResult());

	}

	public void updateModel() {
	}

	public int getIndexFromValue(int[] list, int v) {
		for (int i = 0; i != list.length; i++) {
			if (list[i] == v)
				return i;
		}
		return 0;
	}
	
	protected void startAutoRefresh( ) {
		TimerTask task = new TimerTask( ) {
			
			public void run() {
				refreshProgress( );
			}
		};
		
		Timer timer = new Timer( );
		timer.schedule(task, 0L, 500L);
	}
	
	protected void refreshProgress( ) {
		PortDiagnosisMBean mbean = (PortDiagnosisMBean) getModel();
		if ( mbean == null ) return;
		try {
			mbean.retrieve();
			pbDiagnosisStatus.setValue( mbean.getUtsDot3OltPortDiagnosisStatus().intValue() );
		} catch (MibBeanException e) {
			e.printStackTrace();
		}
	}
}
