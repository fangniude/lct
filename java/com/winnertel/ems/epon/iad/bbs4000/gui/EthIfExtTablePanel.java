package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.LinkAggregation;
import com.winnertel.ems.epon.iad.bbs4000.mib.SecondIPAddressTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * The EthIfExtTablePanel class. Created by DVM Creator
 */
public class EthIfExtTablePanel extends UPanel
{

	private JComboBox tfIfIndex = new JComboBox();

	private IPAddressField tfUtsEthIfExtIpAddress = new IPAddressField();

	private IPAddressField tfUtsEthIfExtIpNetmask = new IPAddressField(IPAddressField.IPMASK);

	private int[] utsEthIfExtAdminStatusVList = new int[]
	{ 1, 2, };

	private String[] utsEthIfExtAdminStatusTList = new String[]
	{ fStringMap.getString("up"), fStringMap.getString("down"), };

	private JComboBox tfUtsEthIfExtAdminStatus = new JComboBox(
			utsEthIfExtAdminStatusTList);

	private final String ifIndex = fStringMap.getString("ifIndex") + " : ";

//	private final String utsEthIfExtPortType = fStringMap
//			.getString("utsEthIfExtPortType")
//			+ " : ";

	private final String utsEthIfExtIpAddress = fStringMap
			.getString("utsEthIfExtIpAddress")
			+ " : ";

	private final String utsEthIfExtIpNetmask = fStringMap
			.getString("utsEthIfExtIpNetmask")
			+ " : ";


	private final String utsEthIfExtAdminStatus = fStringMap
			.getString("utsEthIfExtAdminStatus")
			+ " : ";


	public EthIfExtTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(4, 3, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
		
		baseInfoPanel.add(new JLabel(ifIndex));
		baseInfoPanel.add(tfIfIndex);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEthIfExtIpAddress));
		tfUtsEthIfExtIpAddress.setName(fStringMap
				.getString("utsEthIfExtIpAddress"));
		baseInfoPanel.add(tfUtsEthIfExtIpAddress);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEthIfExtIpNetmask));
		tfUtsEthIfExtIpNetmask.setName(fStringMap
				.getString("utsEthIfExtIpNetmask"));
		baseInfoPanel.add(tfUtsEthIfExtIpNetmask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsEthIfExtAdminStatus));
		tfUtsEthIfExtAdminStatus.setName(fStringMap
				.getString("utsEthIfExtAdminStatus"));
		baseInfoPanel.add(tfUtsEthIfExtAdminStatus);
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
		tfIfIndex.removeAllItems();

		if (SnmpAction.IType.ADD.equals(fCommand))
		{
			String[] ports = getPortCanChangeToLayer3();
			for( int i=0; i<ports.length; i++ )
			{
				tfIfIndex.addItem( ports[i] );
			}
			
			return;
		}

		EthIfExtTable mbean = (EthIfExtTable) getModel();

		tfIfIndex.addItem(ConfigUtility.formatIfIndex((mbean.getUtsEthIfExtIfIndex().toString())));
//		tfUtsEthIfExtIpAddress.setEditable( false );
		tfUtsEthIfExtIpAddress.setValue(mbean.getUtsEthIfExtIpAddress());
//		tfUtsEthIfExtIpNetmask.setEditable( false );
		tfUtsEthIfExtIpNetmask.setValue(mbean.getUtsEthIfExtIpNetmask());
		
		// disable edit of IP Address if configured in Second IP table
		try {
			tfUtsEthIfExtIpAddress.setEditable( true );
			tfUtsEthIfExtIpNetmask.setEditable( true );

			SecondIPAddressTable secIPAddrTblMBean = new SecondIPAddressTable( fApplication.getSnmpProxy() );
			Vector secIPAddrTblVec = secIPAddrTblMBean.retrieveAll();
			int thisIfExtIdx = mbean.getUtsEthIfExtIfIndex().intValue();
			for ( int i = 0; i < secIPAddrTblVec.size(); i++ ) {
				SecondIPAddressTable tmpSecIPAddrTbl = (SecondIPAddressTable)secIPAddrTblVec.elementAt(i);
				int tmpIfExtIdx = tmpSecIPAddrTbl.getUtsIfSecondIpIfIndex().intValue();
				if ( thisIfExtIdx == tmpIfExtIdx ) {
					tfUtsEthIfExtIpAddress.setEditable( false );
					tfUtsEthIfExtIpNetmask.setEditable( false );
					break;
				}
			}
			
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
		
		tfUtsEthIfExtAdminStatus.setSelectedIndex(getIndexFromValue(
				utsEthIfExtAdminStatusVList, mbean.getUtsEthIfExtAdminStatus().intValue()));
	}

	public boolean validateFrom() {
		try {
      String thisIdx = (String)tfIfIndex.getSelectedItem();
      String thisIPAddr = tfUtsEthIfExtIpAddress.getIPString();
      String thisIPMask = tfUtsEthIfExtIpNetmask.getIPString();

      if ( thisIPAddr.equals("0.0.0.0") ) {
        String error = fStringMap.getString("Err_IP_Is_Zero");
        MessageDialog.showInfoMessageDialog( fApplication, error );
        return false;
      }

      if ( thisIPMask.equals("0.0.0.0") ) {
        String error = fStringMap.getString("Err_Netmask_Is_Zero");
        MessageDialog.showInfoMessageDialog( fApplication, error );
        return false;
      }

			// validate EthIfExt Table's ip address, network mask, etc.
			EthIfExtTable ifExtMBean = new EthIfExtTable( fApplication.getSnmpProxy() );
			Vector ifExtVec = ifExtMBean.retrieveAll();
			
			for ( int i = 0; ifExtVec != null && i < ifExtVec.size(); i++ ) {
				EthIfExtTable tmpIfExtTbl = (EthIfExtTable)ifExtVec.elementAt(i);
				String tmpIdx = ConfigUtility.formatIfIndex( tmpIfExtTbl.getUtsEthIfExtIfIndex().toString() );
				String tmpIPAddr = tmpIfExtTbl.getUtsEthIfExtIpAddress();
				String tmpIPMask = tmpIfExtTbl.getUtsEthIfExtIpNetmask();
				
				if ( tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0") ) continue;

				String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);

				String thisNetAddr = ConfigUtility.getSubnetAddress( thisIPAddr, netMask);
				String tmpNetAddr = ConfigUtility.getSubnetAddress( tmpIPAddr, netMask);

				if ( (!thisIdx.equals(tmpIdx)) && thisNetAddr.equals( tmpNetAddr ) ) {
          String error = fStringMap.getString("Err_Duplicate_IP_In_Layer3");
					MessageDialog.showInfoMessageDialog( fApplication, error );
					return false;
				}
			}
			
			// validate second ip address ip address, network mask, etc.
			SecondIPAddressTable secIPAddrMBean = new SecondIPAddressTable( fApplication.getSnmpProxy() );
			Vector secIPAddrVec = secIPAddrMBean.retrieveAll();
			
			if ( thisIPAddr.equals("0.0.0.0") ) {
        String error = fStringMap.getString("Err_IP_Is_Zero");
				MessageDialog.showInfoMessageDialog( fApplication, error );
				return false;
			}
			
			if ( thisIPMask.equals("0.0.0.0") ) {
        String error = fStringMap.getString("Err_Netmask_Is_Zero");
				MessageDialog.showInfoMessageDialog( fApplication, error );
				return false;
			}

			for ( int i = 0; secIPAddrVec != null && i < secIPAddrVec.size(); i++ ) {
				SecondIPAddressTable secIPAddrTbl = (SecondIPAddressTable)secIPAddrVec.elementAt(i);
				String tmpIPAddr = secIPAddrTbl.getUtsIfSecondIpAddress();
				String tmpIPMask = secIPAddrTbl.getUtsIfSecondIpNetmask();
				
				if ( tmpIPAddr.equals("0.0.0.0") && tmpIPMask.equals("0.0.0.0") ) continue;

				String netMask = ConfigUtility.compareNetMask(thisIPMask, tmpIPMask);

				String thisNetAddr = ConfigUtility.getSubnetAddress( thisIPAddr, netMask);
				String tmpNetAddr = ConfigUtility.getSubnetAddress( tmpIPAddr, netMask);
				
				if ( thisNetAddr.equals( tmpNetAddr ) ) {
          String error = fStringMap.getString("Err_Duplicate_IP_In_Second_Layer3");
					MessageDialog.showInfoMessageDialog( fApplication, error );
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
			setModel(new EthIfExtTable(fApplication.getSnmpProxy()));

		EthIfExtTable mbean = (EthIfExtTable) getModel();
		
		if (SnmpAction.IType.ADD.equals(fCommand))
		{
			mbean.setIfIndex( new Integer( ConfigUtility.generateIfIndex( tfIfIndex.getSelectedItem().toString() )));
			mbean.setUtsEthIfExtSwitchMode(new Integer( 2 ));
		}

		mbean.setUtsEthIfExtIpAddress( tfUtsEthIfExtIpAddress.getIPString() );
		mbean.setUtsEthIfExtIpNetmask( tfUtsEthIfExtIpNetmask.getIPString() );
		mbean.setUtsEthIfExtAdminStatus(new Integer(
				utsEthIfExtAdminStatusVList[tfUtsEthIfExtAdminStatus.getSelectedIndex()]));
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
	
	/**
	 * some layer2 interface cannot configured to layer3
	 * 1.vlan belongs to SuperSVI
	 * 2.port belongs to link aggregation
	 * 
	 * @return
	 */
	private String[] getPortCanChangeToLayer3()
	{
		ArrayList list = new ArrayList();
		ISnmpProxy aSnmpProxy = fApplication.getSnmpProxy();

		try {
			EthIfExtTable ifExtMBean = new EthIfExtTable( aSnmpProxy );
			Vector ifExtVec = ifExtMBean.retrieveRealAll();

			for ( int i = 0; i < ifExtVec.size(); i++ ) {
				EthIfExtTable tmpIfExtTbl = (EthIfExtTable)ifExtVec.elementAt(i);
				int portType = tmpIfExtTbl.getUtsEthIfExtPortType().intValue();

				if ( portType == 1 ) {
					if ( tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 1 ||
							( tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 2 &&
							tmpIfExtTbl.getUtsEthIfExtIpAddress().equals("0.0.0.0") ) ) {
						list.add( tmpIfExtTbl.getUtsEthIfExtModuleId() + "/" + tmpIfExtTbl.getUtsEthIfExtPortId() );
					}
				} else if ( portType == 2 ) {
					if ( tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 1 ) {
						list.add( "lg" + tmpIfExtTbl.getUtsEthIfExtLinkAggGroupId() );
					}
				} else if ( portType == 4 ) {
					if ( tmpIfExtTbl.getUtsEthIfExtSwitchMode().intValue() == 1 ) {
						list.add( "vlan" + tmpIfExtTbl.getUtsEthIfExtVlanId() );
					}
				}
			}

			// remove port that in Link Aggregation set
			LinkAggregation lgMBean = new LinkAggregation( aSnmpProxy );
			Vector lgVec = lgMBean.retrieveAll();
			if ( lgVec == null ) lgVec = new Vector(0);

			Set l2PortInLGSet = new HashSet();
			for ( int i = 0; i < lgVec.size(); i++ ) {
				LinkAggregation tmpLGMBean = (LinkAggregation)lgVec.get(i);

				String[] array = ConfigUtility.portMappingToStringArray(tmpLGMBean.getUtsLagExtDot3adAggPortListPorts());

				for (int j = 0; j < array.length; j++) {
					l2PortInLGSet.add(array[j]);
				}
			}

			for ( Iterator iter =  l2PortInLGSet.iterator(); iter.hasNext(); ) {
				list.remove( iter.next() );
			}

      //remove the vlan constained by Super VLAN.
      SuperSVITable sviTable = new SuperSVITable(aSnmpProxy);
      Vector sviVector = sviTable.retrieveAll();
      for(int i = 0; i < sviVector.size(); i++)
      {
        SuperSVITable svi = (SuperSVITable)sviVector.get(i);
        int[] vlan = ConfigUtility.VlanMappingToVlanArray(svi.getUtsIntfSuperSVIVlanMemberBitmap());
        for(int j = 0; j < vlan.length; j++)
        {
          list.remove("vlan" + vlan[j]);
        }
      }

			// remove port and LG defined in VLAN table
			// 2006-11-16, remove this restriction as this operation has been supported by NE
/*			PortBasedVLAN portVLANMBean = new PortBasedVLAN( aSnmpProxy );
			Vector vLANVec = portVLANMBean.retrieveAll();
			if ( vLANVec == null ) vLANVec = new Vector(0);

			for ( int i = 0; i < vLANVec.size(); i++ ) {
				PortBasedVLAN tmpPortVLAN = (PortBasedVLAN)vLANVec.elementAt(i);
				int tmpvlanIdx = tmpPortVLAN.getUtsLagExtDot1qVlanIndex().intValue();

				if ( tmpvlanIdx == 1 ) continue;

				Set portListsStr = parsePortListString ( tmpPortVLAN.getUtsLagExtDot1qVlanPortListPorts() );

				for ( Iterator iter = portListsStr.iterator(); iter.hasNext(); ) {
					list.remove( iter.next() );
				}
			}
*/
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}

		return ( String[] )list.toArray( new String[0]);
	}

	protected Set parsePortListString( String portListString ) {
		
		Set portListSet = new HashSet();

		String[] portListArray = portListString.split(" ");
		
		for ( int i = 0; i < portListArray.length; i++ ) {
			
			// parse link aggreagration
			if ( portListArray[i].indexOf("lg") == 0 ) {
				portListSet.add( portListArray[i] );
				continue;
			}

			// parse port list
			String[] tmpPortRange = portListArray[i].split("/");
			if( tmpPortRange.length == 2 ) {
				int begB, begE, endB, endE;
				String[] tmpBegSlotRange = tmpPortRange[0].split("-");
				if( tmpBegSlotRange.length == 1 ) {
					begB = begE = Integer.parseInt( tmpBegSlotRange[0] );
				} else if ( tmpBegSlotRange.length == 2 ) {
					begB = Integer.parseInt( tmpBegSlotRange[0]);
					begE = Integer.parseInt( tmpBegSlotRange[1]);
				} else {
					continue;
				}
				
				String[] tmpEndSlotRange = tmpPortRange[1].split("-");
				if ( tmpEndSlotRange.length == 1 ) {
					endB = endE = Integer.parseInt( tmpEndSlotRange[0]);
				} else if ( tmpEndSlotRange.length == 2 ) {
					endB = Integer.parseInt( tmpEndSlotRange[0]);
					endE = Integer.parseInt( tmpEndSlotRange[1]);
				} else {
					continue;
				}

				for ( int begI = begB; begI <= begE; begI++ ) {
					for ( int endI = endB; endI <= endE; endI++ ) {
						portListSet.add( begI + "/" + endI );
					}
				}
			}
		}

		return portListSet;
	}

}
