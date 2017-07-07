package com.winnertel.ems.epon.iad.bbs4000.gui.r311.swing;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.EthInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.PortTreeNodeBuilder;
import com.winnertel.ems.epon.iad.bbs4000.mib.r311.IgmpCacheTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The IgmpCacheTablePanel class. Created by DVM Creator
 */
public class IgmpCacheTablePanel extends UPanel
{

    private JComboBox tfUtsIgmpCacheIfIndex = new JComboBox();

    private IPAddressField tfUtsIgmpCacheGroupAddress = new IPAddressField( IPAddressField.IPMULTICAST );

//	private int[] utsIgmpCacheTypeVList = new int[]
//	{ 2, 1, };
//
//	private String[] utsIgmpCacheTypeTList = new String[]
//	{ fStringMap.getString("dynamic"), fStringMap.getString("static"), };
//
//	private JComboBox tfUtsIgmpCacheType = new JComboBox(utsIgmpCacheTypeTList);
//
//	private JLabel tfUtsIgmpCacheLastReporter = new JLabel();
//
//	private JLabel tfUtsIgmpCacheExpiryTime = new JLabel();

//	private int[] utsIgmpCacheStatusVList = new int[]
//	{ 1, 2, 5, 4, 3, 6, };
//
//	private String[] utsIgmpCacheStatusTList = new String[]
//	{ fStringMap.getString("active"), fStringMap.getString("notInService"),
//			fStringMap.getString("createAndWait"),
//			fStringMap.getString("createAndGo"),
//			fStringMap.getString("notReady"), fStringMap.getString("destroy"), };

//	private JComboBox tfUtsIgmpCacheStatus = new JComboBox(
//			utsIgmpCacheStatusTList);

    private final String utsIgmpCacheIfIndex = fStringMap
            .getString("utsIgmpCacheIfIndex")
            + " : ";

    private final String utsIgmpCacheGroupAddress = fStringMap
            .getString("utsIgmpCacheGroupAddress")
            + " : ";


//	private final String utsIgmpCacheType = fStringMap
//			.getString("utsIgmpCacheType")
//			+ " : ";
//
//	private final String utsIgmpCacheLastReporter = fStringMap
//			.getString("utsIgmpCacheLastReporter")
//			+ " : ";
//
//	private final String utsIgmpCacheExpiryTime = fStringMap
//			.getString("utsIgmpCacheExpiryTime")
//			+ " : ";

    public IgmpCacheTablePanel(IApplication app)
    {
        super(app);

        init();
    }

    public void initGui()
    {

        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5,
                5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(utsIgmpCacheIfIndex));
        tfUtsIgmpCacheIfIndex.setPreferredSize( new Dimension(100,25));
        baseInfoPanel.add(tfUtsIgmpCacheIfIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(utsIgmpCacheGroupAddress));
        tfUtsIgmpCacheGroupAddress.setValue( "224.0.2.0" );
        tfUtsIgmpCacheGroupAddress.setPreferredSize( new Dimension(100,25));
        baseInfoPanel.add(tfUtsIgmpCacheGroupAddress);
        baseInfoPanel.add(new HSpacer());

//		baseInfoPanel.add(new JLabel(utsIgmpCacheType));
//		tfUtsIgmpCacheType.setName(fStringMap.getString("utsIgmpCacheType"));
//		baseInfoPanel.add(tfUtsIgmpCacheType);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsIgmpCacheLastReporter));
//		baseInfoPanel.add(tfUtsIgmpCacheLastReporter);
//		baseInfoPanel.add(new HSpacer());
//
//		baseInfoPanel.add(new JLabel(utsIgmpCacheExpiryTime));
//		baseInfoPanel.add(tfUtsIgmpCacheExpiryTime);
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

    }

    public void refresh()
    {
        tfUtsIgmpCacheIfIndex.removeAllItems();

        PortTreeNodeBuilder builder = new PortTreeNodeBuilder( this.fApplication.getSnmpProxy() );
        EthInterface[] layer3Interface = builder.getLayer3EthInterface();

        for( int i=0; i< layer3Interface.length; i++ )
        {
            tfUtsIgmpCacheIfIndex.addItem( layer3Interface[i].getInterfaceID() );
        }

//		tfUtsIgmpCacheType.setSelectedIndex(getIndexFromValue(
//				utsIgmpCacheTypeVList, mbean.getUtsIgmpCacheType().intValue()));
//		tfUtsIgmpCacheLastReporter.setText(mbean.getUtsIgmpCacheLastReporter());
//		tfUtsIgmpCacheExpiryTime.setText(mbean.getUtsIgmpCacheExpiryTime()
//				.toString());
//		tfUtsIgmpCacheStatus.setSelectedIndex(getIndexFromValue(
//				utsIgmpCacheStatusVList, mbean.getUtsIgmpCacheStatus()
//						.intValue()));

    }

  public boolean validateFrom()
  {
    if(tfUtsIgmpCacheIfIndex.getSelectedItem() == null)
    {
      String error = fStringMap.getString("Err_If_Index_Is_Null");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }

    return true;
  }
    public void updateModel()
    {

        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new IgmpCacheTable(fApplication.getSnmpProxy()));

        IgmpCacheTable mbean = (IgmpCacheTable) getModel();

         if (SnmpAction.IType.ADD.equals(fCommand)) {
         // here set the value of index
             mbean.setUtsIgmpCacheIfIndex(new Integer(ConfigUtility.generateIfIndex( tfUtsIgmpCacheIfIndex.getSelectedItem().toString() )));
             mbean.setUtsIgmpCacheGroupAddress( tfUtsIgmpCacheGroupAddress.getIPString() );

             mbean.setUtsIgmpCacheType(new Integer(1));
         }



//		mbean.setUtsIgmpCacheStatus(new Integer(
//						utsIgmpCacheStatusVList[tfUtsIgmpCacheStatus
//								.getSelectedIndex()]));
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