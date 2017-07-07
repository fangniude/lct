package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.EthInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.PortTreeNodeBuilder;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.SuperVlanInterface;
import com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel.VlanInterface;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SVIMemberVlanListInputPanel extends JPanel implements ActionListener, KeyListener {
  protected IApplication fApplication = null;
  protected DvmStringMap fStringMap = null;

  private StringTextField vlanListField = new StringTextField();
  private JButton button = new JButton("...");

  private int sviId = 0;
  private boolean validated = true;

  public SVIMemberVlanListInputPanel(IApplication app) {
    fApplication = app;
    if (fApplication.getActiveDeviceManager() != null) {
      fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
    }

    init();
  }

  private void init() {
    NTLayout layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 0, 0);
    layout.setMargins(0, 0, 0, 0);
    setLayout(layout);

    vlanListField.setLenScope(0, 520);
    vlanListField.addKeyListener(this);
    add(vlanListField);
    button.addActionListener(this);
    button.setPreferredSize(new Dimension(20, 20));
    add(button);

//    setPreferredSize(new Dimension(450, 550));
  }

  public byte[] getVlanList() {
    String value = vlanListField.getValue();
    return ConfigUtility.VlanArrayToVlanMapping(value.split(" "));
  }

  public void setVlanList(byte[] list) {
    vlanListField.setValue(ConfigUtility.VlanMappingToVlanString(list));
  }

  public void setSuperSVI(int vlanId) {
    sviId = vlanId;
  }

  public String validateForm() {
    //user input the vlan list manually.
    if (!validated && !vlanListField.getValue().trim().equals("")) {
      //check...
      String member = vlanListField.getValue();
    	if( member == null )
    	{
        return fStringMap.getString("Err_SVI_Member_Is_Empty");
    	}
    	String[] members = member.split( " " );
    	if( members.length == 0 )
    	{
        return fStringMap.getString("Err_SVI_Member_Is_Empty");
    	}

    	/**
    	 * super SVI and it's vlan member should have one same port
    	 *
    	 */
      try
      {

        int index = checkHaveSamePort( sviId, members);
        if( index != -1 )
        {
          return "VLAN " + index + fStringMap.getString("Err_VLAN_No_Same_Member_With_SVI");
        }
      }
      catch(NumberFormatException e)
      {
        return fStringMap.getString("Err_SVI_Member_Is_Invalid");
      }

      /**
    	 * can not contain itself/layer three interface/not exist interface/in other super svi
    	 *
    	 * =>should be layer two interface & cannot belong to other || vlan1
    	 */
    	EthInterface[] layer2Vlan = getLayer2Vlan( );

    	String[] allMembers = getAllMember( sviId );

    	for( int i=0; i<members.length; i++ )
    	{
    		if( members[i].length() == 0 || members[i].equals( "1" ))
    		{
    			continue;  //caused by String.split() method
    		}

        if ( sviId == Integer.parseInt(members[i]) ) {
          return fStringMap.getString("Err_SVI_Bound_TO_SVI");

        }

    		boolean existInLayer2 = false;
    		for( int j=0; j<layer2Vlan.length; j++ )
    		{
    			if( members[i].equals( layer2Vlan[j].getInterfaceID().substring( 4 ) ) )
    			{
    				existInLayer2 = true;
    			}
    		}

    		if( !existInLayer2 )
    		{
          return fStringMap.getString("Err_Member_VLAN_Not_Layer2_1")
           + members[i] + fStringMap.getString("Err_Member_VLAN_Not_Layer2_2");
    		}

    		for( int j=0; j<allMembers.length; j++ )
    		{
    			if( members[i].equals( allMembers[j] ) )
    			{
            return fStringMap.getString("Err_Sub_VLAN_Only_Bound_To_One_SVI")
             + members[i] + fStringMap.getString("Err_Sub_VLAN_Only_Bound_To_One_SVI_2");
    			}
    		}
    	}
    }

    return null;
  }

  private EthInterface[] getLayer2Vlan() {
    ArrayList list = new ArrayList();
    PortTreeNodeBuilder builder = new PortTreeNodeBuilder(this.fApplication.getSnmpProxy());
    EthInterface[] layer2Interface = builder.getLayer2EthInterface();

    for (int i = 0; i < layer2Interface.length; i++) {
      if (layer2Interface[i].getInterfaceID().indexOf("vlan") != -1) {
        list.add(layer2Interface[i]);
      }
    }

    return (EthInterface[]) list.toArray(new EthInterface[0]);
  }

  private SuperVlanInterface[] getSuperVlanInterface() {
    return SuperVlanInterface.getSuperVlanInterface(this.fApplication.getSnmpProxy());
  }

  private String[] getAllMember(int vlanID) {
    ArrayList list = new ArrayList();
    SuperVlanInterface[] superVlan = getSuperVlanInterface();

    for (int i = 0; i < superVlan.length; i++) {
      if (vlanID == Integer.parseInt(superVlan[i].getVlanId())) {
        continue;
      }
      byte[] members = superVlan[i].getVlanMember();

      int[] vlan = ConfigUtility.VlanMappingToVlanArray(members);
      for (int j = 0; j < vlan.length; j++) {
        list.add("" + vlan[j]);
      }
    }
    return (String[]) list.toArray(new String[0]);
  }

  /**
   * @param vlanID
   * @param members
   * @return vlan id has no same port with superSVI, -1 means all ports are ok.
   */
  private int checkHaveSamePort(int vlanID, String[] members) {
    int[] superVlanPorts = null;
    ArrayList membersPort = new ArrayList();

    VlanInterface[] vlanInterface = VlanInterface.getVlanInterface(this.fApplication.getSnmpProxy());

    for (int i = 0; i < vlanInterface.length; i++) {
      if (vlanInterface[i].getVlanId() == vlanID) {
        superVlanPorts = ConfigUtility.portMappingToPortArray(vlanInterface[i].getPortList());
      }

      for (int j = 0; j < members.length; j++) {
        if (vlanInterface[i].getVlanId() == Integer.parseInt(members[j])) {
          membersPort.add(vlanInterface[i]);
        }
      }
    }

    for (int i = 0; i < membersPort.size(); i++) {
      int[] ports = ConfigUtility.portMappingToPortArray(((VlanInterface) membersPort.get(i)).getPortList());
      if (!hasSamePort(superVlanPorts, ports)) {
        return ((VlanInterface) membersPort.get(i)).getVlanId();
      }
    }

    return -1;
  }

  private boolean hasSamePort(int[] superVlanPort, int[] ports) {
    for (int i = 0; i < superVlanPort.length; i++) {
      for (int j = 0; j < ports.length; j++) {
        if (superVlanPort[i] == ports[j]) {
          return true;
        }
      }
    }
    return false;
  }

  public void actionPerformed(ActionEvent e) {
    VlanListChooser chooser = new VlanListChooser(fApplication, (JDialog) SwingUtilities.getWindowAncestor(this));
    chooser.setSuperVlan(sviId);
    chooser.refresh();
    chooser.setSelectedVlanList(vlanListField.getValue().split(" "));
    chooser.setVisible(true);

    int[] vlanList = chooser.getSelectedVlanList();
    if (vlanList != null) {
      StringBuffer sb = new StringBuffer();

      for(int i = 0; i < vlanList.length; i++)
      {
        sb.append(vlanList[i]).append(" ");
      }

      vlanListField.setValue(sb.toString().trim());
      //
      validated = true;
    }
  }

  public void keyTyped(KeyEvent e) {
    validated = false;
  }

  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
  }
}
