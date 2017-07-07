package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.EthInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.PortTreeNodeBuilder;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SecondIPAddressTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * The SecondIPAddressTablePanel class. Created by DVM Creator
 */
public class SecondIPAddressTablePanel extends UPanel
{

	private JComboBox tfUtsIfSecondIpIfIndex = new JComboBox();

	private IPAddressField tfUtsIfSecondIpAddress = new IPAddressField();

	private IPAddressField tfUtsIfSecondIpNetmask = new IPAddressField(IPAddressField.IPMASK);

	private final String utsIfSecondIpIfIndex = fStringMap
			.getString("utsIfSecondIpIfIndex")
			+ " : ";

	private final String utsIfSecondIpAddress = fStringMap
			.getString("utsIfSecondIpAddress")
			+ " : ";

	private final String utsIfSecondIpNetmask = fStringMap
			.getString("utsIfSecondIpNetmask")
			+ " : ";

	public SecondIPAddressTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsIfSecondIpIfIndex));
		baseInfoPanel.add(tfUtsIfSecondIpIfIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIfSecondIpAddress));
		tfUtsIfSecondIpAddress.setName(fStringMap
				.getString("utsIfSecondIpAddress"));
		baseInfoPanel.add(tfUtsIfSecondIpAddress);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsIfSecondIpNetmask));
		tfUtsIfSecondIpNetmask.setName(fStringMap
				.getString("utsIfSecondIpNetmask"));
		baseInfoPanel.add(tfUtsIfSecondIpNetmask);
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

	protected void initForm()
	{

	}

	public void refresh()
	{

		if (SnmpAction.IType.ADD.equals(fCommand))
		{
			
			tfUtsIfSecondIpIfIndex.removeAllItems();
			
			ISnmpProxy aSnmpProxy = fApplication.getSnmpProxy();
			PortTreeNodeBuilder builder = new PortTreeNodeBuilder( aSnmpProxy );
			EthInterface[] threeLayerInterface = builder.getLayer3EthInterface();
			
			for( int i=0; i< threeLayerInterface.length; i++ )
			{
				tfUtsIfSecondIpIfIndex.addItem( threeLayerInterface[i].getInterfaceID() ); 
			}
			
			return;
		}
		SecondIPAddressTable mbean = (SecondIPAddressTable) getModel();

//		tfUtsIfSecondIpIfIndex.setText(mbean.getUtsIfSecondIpIfIndex()
//				.toString());
		tfUtsIfSecondIpAddress.setValue(mbean.getUtsIfSecondIpAddress());
		tfUtsIfSecondIpNetmask.setValue(mbean.getUtsIfSecondIpNetmask());
		// tfUtsIfSecondIpStatus.setSelectedIndex(getIndexFromValue(utsIfSecondIpStatusVList,mbean.getUtsIfSecondIpStatus().intValue()));

	}

	public boolean validateFrom() {
		try {
      String thisIPAddr = tfUtsIfSecondIpAddress.getIPString();
      String thisIPMask = tfUtsIfSecondIpNetmask.getIPString();

      if ( thisIPAddr.equals("0.0.0.0") ) {
        MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_IP_Is_Zero") );
        return false;
      }

      if ( thisIPMask.equals("0.0.0.0") ) {
        MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_Netmask_Is_Zero") );
        return false;
      }

			// validate second ip address ip address, network mask, etc.
			SecondIPAddressTable secIPAddrMBean = new SecondIPAddressTable( fApplication.getSnmpProxy() );
			Vector secIPAddrVec = secIPAddrMBean.retrieveAll();
			
			for ( int i = 0; secIPAddrVec != null && i < secIPAddrVec.size(); i++ ) {
				SecondIPAddressTable secIPAddrTbl = (SecondIPAddressTable)secIPAddrVec.elementAt(i);
				String tmpIPAddr = secIPAddrTbl.getUtsIfSecondIpAddress();
				String tmpIPMask = secIPAddrTbl.getUtsIfSecondIpNetmask();
				
				if ( tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0") ) continue;

				String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);

				String thisNetAddr = ConfigUtility.getSubnetAddress( thisIPAddr, netMask);
				String tmpNetAddr = ConfigUtility.getSubnetAddress( tmpIPAddr, netMask);
				
				if (thisNetAddr.equals( tmpNetAddr ) ) {
					MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_Duplicate_IP_In_Second_Layer3") );
					return false;
				}
			}

			// validate EthIfExt Table's ip address, network mask, etc.
			EthIfExtTable ifExtMBean = new EthIfExtTable( fApplication.getSnmpProxy() );
			Vector ifExtVec = ifExtMBean.retrieveAll();

			if ( thisIPAddr.equals("0.0.0.0") ) {
				MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_IP_Is_Zero") );
				return false;
			}

			if ( thisIPMask.equals("0.0.0.0") ) {
				MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_Netmask_Is_Zero") );
				return false;
			}

			for ( int i = 0; ifExtVec != null && i < ifExtVec.size(); i++ ) {
				EthIfExtTable tmpIfExtTbl = (EthIfExtTable)ifExtVec.elementAt(i);
				String tmpIPAddr = tmpIfExtTbl.getUtsEthIfExtIpAddress();
				String tmpIPMask = tmpIfExtTbl.getUtsEthIfExtIpNetmask();
				
				if ( tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0") ) continue;

				String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);

				String thisNetAddr = ConfigUtility.getSubnetAddress( thisIPAddr, netMask);
				String tmpNetAddr = ConfigUtility.getSubnetAddress( tmpIPAddr, netMask);
				
				if ( thisNetAddr.equals( tmpNetAddr ) ) {
					MessageDialog.showInfoMessageDialog( fApplication, fStringMap.getString("Err_Duplicate_IP_In_Layer3") );
					return false;
				}
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
		
		return true;	
	}

	public void updateModel()
	{

		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new SecondIPAddressTable(fApplication.getSnmpProxy()));

		SecondIPAddressTable mbean = (SecondIPAddressTable) getModel();

		 if (SnmpAction.IType.ADD.equals(fCommand)) 
		 {
		 // here set the value of index
			 mbean.setUtsIfSecondIpIfIndex( new Integer(ConfigUtility.generateIfIndex( tfUtsIfSecondIpIfIndex.getSelectedItem().toString()) ) );
		 }

		mbean.setUtsIfSecondIpAddress(tfUtsIfSecondIpAddress.getIPString());
		mbean.setUtsIfSecondIpNetmask(tfUtsIfSecondIpNetmask.getIPString());
		// mbean.setUtsIfSecondIpStatus(new
		// Integer(utsIfSecondIpStatusVList[tfUtsIfSecondIpStatus.getSelectedIndex()]));
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

}