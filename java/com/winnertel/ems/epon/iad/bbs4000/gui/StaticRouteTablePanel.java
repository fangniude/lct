package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SecondIPAddressTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.StaticRouteTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * The StaticRouteTablePanel class. Created by DVM Creator
 */
public class StaticRouteTablePanel extends UPanel
{

	private IPAddressField tfUtsStaticRouteIpAddress = new IPAddressField();

	private IPAddressField tfUtsStaticRouteSubnetMask = new IPAddressField(IPAddressField.IPMASK);

	private IPAddressField tfUtsStaticRouteNextHop = new IPAddressField();
	
	private JList tfUtsStaticRouteNextHopHint = new JList();

	private IntegerTextField tfUtsStaticRouteMetric = new IntegerTextField();

	private final String utsStaticRouteIpAddress = fStringMap
			.getString("utsStaticRouteIpAddress")
			+ " : ";

	private final String utsStaticRouteSubnetMask = fStringMap
			.getString("utsStaticRouteSubnetMask")
			+ " : ";

	private final String utsStaticRouteNextHop = fStringMap
			.getString("utsStaticRouteNextHop")
			+ " : ";

	private final String utsStaticRouteNextHopHint = fStringMap.getString("utsStaticRouteNextHopHint") + " : ";

	private final String utsStaticRouteIfIndex = fStringMap
			.getString("utsStaticRouteIfIndex")
			+ " : ";

	private final String utsStaticRouteMetric = fStringMap
			.getString("utsStaticRouteMetric")
			+ " : ";

	private List networkDestList = new ArrayList();

	public StaticRouteTablePanel(IApplication app)
	{
		super(app);

		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(7, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsStaticRouteIpAddress));
		tfUtsStaticRouteIpAddress.setName(fStringMap
				.getString("utsStaticRouteIpAddress"));
		baseInfoPanel.add(tfUtsStaticRouteIpAddress);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsStaticRouteSubnetMask));
		tfUtsStaticRouteSubnetMask.setName(fStringMap
				.getString("utsStaticRouteSubnetMask"));
		baseInfoPanel.add(tfUtsStaticRouteSubnetMask);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsStaticRouteNextHop));
		tfUtsStaticRouteNextHop.setName(fStringMap
				.getString("utsStaticRouteNextHop"));
		baseInfoPanel.add(tfUtsStaticRouteNextHop);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsStaticRouteNextHopHint));
		tfUtsStaticRouteNextHopHint.setName(fStringMap.getString("utsStaticRouteNextHopHint"));
		tfUtsStaticRouteNextHopHint.setEnabled( false );
		JScrollPane tmpScrollPane = new JScrollPane( tfUtsStaticRouteNextHopHint);
		tmpScrollPane.setPreferredSize( new Dimension(200, 120) );
		baseInfoPanel.add( tmpScrollPane );
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsStaticRouteMetric));
		tfUtsStaticRouteMetric.setName(fStringMap
				.getString("utsStaticRouteMetric"));
		baseInfoPanel.add(tfUtsStaticRouteMetric);
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

		tfUtsStaticRouteMetric.setValueScope(1, 255);

	}

	public void refresh()
	{
		try {
			// update next hop Hint JList
			tfUtsStaticRouteNextHopHint.removeAll();
			Vector listDataVec = new Vector();

      EthIfExtTable ethIfExtTblMbean = new EthIfExtTable( fApplication.getSnmpProxy() );
      Vector ethIfExtTblVec = ethIfExtTblMbean.retrieveAll();
			for ( int i = 0; i < ethIfExtTblVec.size(); i++ ) {
				EthIfExtTable tmpEthIfExtTbl = (EthIfExtTable)ethIfExtTblVec.elementAt(i);
				listDataVec.add( tmpEthIfExtTbl.getUtsEthIfExtIpAddress() + " / " + tmpEthIfExtTbl.getUtsEthIfExtIpNetmask() );
			}

      SecondIPAddressTable secondIpBean = new SecondIPAddressTable(fApplication.getSnmpProxy());
      Vector secondIpVec = secondIpBean.retrieveAll();

      for ( int i = 0; i < secondIpVec.size(); i++ ) {
        SecondIPAddressTable secondIpTbl = (SecondIPAddressTable)secondIpVec.elementAt(i);
        listDataVec.add( secondIpTbl.getUtsIfSecondIpAddress() + " / " + secondIpTbl.getUtsIfSecondIpNetmask());
      }

			tfUtsStaticRouteNextHopHint.setListData( listDataVec );
		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
		
		if (SnmpAction.IType.ADD.equals(fCommand))
			return;

		StaticRouteTable mbean = (StaticRouteTable) getModel();

		tfUtsStaticRouteIpAddress.setValue(mbean.getUtsStaticRouteIpAddress());
		tfUtsStaticRouteSubnetMask.setValue(mbean.getUtsStaticRouteSubnetMask());
		tfUtsStaticRouteNextHop.setValue(mbean.getUtsStaticRouteNextHop());
		tfUtsStaticRouteMetric.setValue(mbean.getUtsStaticRouteMetric().intValue());

		// tfUtsStaticRouteStatus.setSelectedIndex(getIndexFromValue(utsStaticRouteStatusVList,mbean.getUtsStaticRouteStatus().intValue()));

	}

	public boolean validateFrom() {

		try {
			// get all network destinations
			networkDestList.clear();
			StaticRouteTable staticRouteTblMBean = new StaticRouteTable( fApplication.getSnmpProxy() );
			Vector staticRouteTblVec = staticRouteTblMBean.retrieveAll();

			for ( int i = 0; i < staticRouteTblVec.size(); i++ ) {
				StaticRouteTable tmpStaticRouteTbl = (StaticRouteTable)staticRouteTblVec.elementAt(i);
				networkDestList.add( tmpStaticRouteTbl.getUtsStaticRouteIpAddress() );
			}
		} catch ( Exception ex) {
			ex.printStackTrace();
		}

		// check if there are already 4 records in the table
		String thisNetworkDest = tfUtsStaticRouteIpAddress.getIPString();
		int counter = 0;
		for ( int i = 0; i < networkDestList.size(); i++ ) {
			if ( networkDestList.get(i).equals( thisNetworkDest ) )
				counter++;
		}
		if ( counter >= 4 ) {
        String error = fStringMap.getString("Err_More_4_Static_Route");
    		MessageDialog.showInfoMessageDialog( fApplication, error );
    		return false;
		}

		// check if the next hop ip address is valid
		String thisNextHopAddr = tfUtsStaticRouteNextHop.getIPString();
		ListModel tmpListModel = tfUtsStaticRouteNextHopHint.getModel();
		int iCounter = 0;
		for ( iCounter = 0; iCounter < tmpListModel.getSize(); iCounter++ ) {
			String[] tmpNextHopNetAddrArray = ((String)tmpListModel.getElementAt(iCounter)).split("/");
			if ( tmpNextHopNetAddrArray!=null && tmpNextHopNetAddrArray.length == 2 ) {
				
				if ( thisNextHopAddr.equals(tmpNextHopNetAddrArray[0].trim()) ) {
            String error = fStringMap.getString("Err_Next_Hop_IP_Exist");
		    		MessageDialog.showInfoMessageDialog( fApplication, error );
		    		return false;
				}

				String tmpNetAddr = ConfigUtility.getSubnetAddress( tmpNextHopNetAddrArray[0].trim(), 
						tmpNextHopNetAddrArray[1].trim() );

				String thisNetAddr = ConfigUtility.getSubnetAddress( thisNextHopAddr.trim(), 
						tmpNextHopNetAddrArray[1].trim() );

				if ( tmpNetAddr!=null && tmpNetAddr.equals(thisNetAddr) ) {
					break;
				}
			}
		}
		if ( iCounter == tmpListModel.getSize() ) {
        String error = fStringMap.getString("Err_Next_Hop_Ip_Is_Invalid");
    		MessageDialog.showInfoMessageDialog( fApplication, error );
    		return false;
		}

		// check if Network Destination is valid
		String thisNetworkMask = tfUtsStaticRouteSubnetMask.getIPString();
		String tmpNetworkDest = ConfigUtility.getSubnetAddress( thisNetworkDest.trim(), thisNetworkMask.trim() );
		if ( !thisNetworkDest.equals( tmpNetworkDest) ) {
        String error = fStringMap.getString("Err_Destination_IP_Is_Invalid");
    		MessageDialog.showInfoMessageDialog( fApplication, error);
    		return false;
		}

		return true;
	}

	public void updateModel()
	{
		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new StaticRouteTable(fApplication.getSnmpProxy()));

		StaticRouteTable mbean = (StaticRouteTable) getModel();

		 if (SnmpAction.IType.ADD.equals(fCommand)) {
			 mbean.setUtsStaticRouteIpAddress(new String(tfUtsStaticRouteIpAddress
						.getIPString()));
			 mbean.setUtsStaticRouteSubnetMask(new String(tfUtsStaticRouteSubnetMask
					.getIPString()));
			 mbean.setUtsStaticRouteNextHop(new String(tfUtsStaticRouteNextHop
						.getIPString()));
		 }


		mbean.setUtsStaticRouteMetric(new Integer(tfUtsStaticRouteMetric
				.getValue()));
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
