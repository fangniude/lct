package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.PortBasedVLAN;
import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.EthIfExtTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.ems.epon.gui.util.GUIUtilities;
import com.winnertel.ems.epon.iad.util.GuiUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class VlanListChooser extends JDialog implements ActionListener
{
  protected IApplication fApplication;
  protected NeFileSystem fileSystem;
  protected DefaultListModel vlanListModel;
  protected int[] selectedVlanList = null;
  protected int superVlan = 1;

  private JPanel jPanel = null;
  private JScrollPane scrollPane = null;
  private JPanel buttonPanel = null;
  private JList vlanList = null;
  private JButton okButton = null;
  private JButton cancelButton = null;

  public VlanListChooser(IApplication theApplication)
  {
    fApplication = theApplication;
    fileSystem = new NeFileSystem(fApplication);
    initialize();
  }

  public VlanListChooser(IApplication theApplication, Dialog dialog)
  {
    super(dialog, true);

    fApplication = theApplication;
    fileSystem = new NeFileSystem(fApplication);
    initialize();
  }

  public VlanListChooser(IApplication theApplication, Frame frame)
  {
    super(frame, true);

    fApplication = theApplication;
    fileSystem = new NeFileSystem(fApplication);
    initialize();
  }

  /**
   * get the super SVI member VLAN list.
   * 1. get all the VLAN list.
   * 2. get the layer-3 vlan list, remove it from vlan list.
   * 3. get the super SVI list, remove it from vlan list.
   * 4. remove the super SVI meber list from vlan list.
   * 5. remove the super SVI from vlan list, if the super SVI is specified.
   * 6. remove the vlan which has not one same port as member at least, if the super SVI is specified.
   */
  public void refresh()
  {
    ArrayList vlanList = new ArrayList();

    //step 1.
    PortBasedVLAN vlanBean = new PortBasedVLAN(fApplication.getSnmpProxy());
    Vector vList = BeanService.refreshTableBean(fApplication, vlanBean);

    for(int i = 0; i < vList.size(); i++)
    {
      vlanList.add(((PortBasedVLAN)vList.get(i)).getUtsLagExtDot1qVlanIndex());
    }

    //step 2, 3.
    EthIfExtTable ethBean = new EthIfExtTable(fApplication.getSnmpProxy());
    Vector eList = BeanService.refreshTableBean(fApplication, ethBean);

    for(int i = 0; i < eList.size(); i++)
    {
      EthIfExtTable eTable = (EthIfExtTable)eList.get(i);

      if(eTable.getUtsEthIfExtVlanId() != 0 && eTable.getUtsEthIfExtSwitchMode() == 2)
      {
        vlanList.remove(eTable.getUtsEthIfExtVlanId());
      }
    }

    //step 4.
    SuperSVITable sviTable = new SuperSVITable(fApplication.getSnmpProxy());
    Vector sList = BeanService.refreshTableBean(fApplication, sviTable);

    for(int i = 0; i < sList.size(); i++)
    {
      SuperSVITable svi = (SuperSVITable)sList.get(i);
      if(svi.getUtsIntfSuperSVIVlanId() != superVlan)
      {
        int[] member = ConfigUtility.VlanMappingToVlanArray(svi.getUtsIntfSuperSVIVlanMemberBitmap());
        for(int j = 0; j < member.length; j++)
        {
          vlanList.remove(new Integer(member[j]));
        }
      }
    }

    //step 5, 6
    if(superVlan > 1)
    {
      vlanList.remove(new Integer(superVlan));

      PortBasedVLAN vlan = getVlanBean(vList, superVlan);

      int[] portList = ConfigUtility.portMappingToPortArray(vlan.getUtsLagExtDot1qVlanPortListPorts());

      int i = 0;
      while(i < vlanList.size())
      {
        PortBasedVLAN v = getVlanBean(vList, ((Integer)vlanList.get(i)).intValue());
        int[] vPortList = ConfigUtility.portMappingToPortArray(v.getUtsLagExtDot1qVlanPortListPorts());

        if(!hasSamePort(portList, vPortList))
        {
          vlanList.remove(i);
        }
        else
        {
          i++;
        }
      }
    }

    vlanListModel.removeAllElements();

    for(int i = 0; i < vlanList.size(); i++)
    {
      vlanListModel.addElement(vlanList.get(i));
    }
  }

  private PortBasedVLAN getVlanBean(Vector list, int id)
  {
    for(int i = 0; i < list.size(); i++)
    {
      PortBasedVLAN vlan = (PortBasedVLAN)list.get(i);

      if(vlan.getUtsLagExtDot1qVlanIndex() == id)
      {
        return vlan;
      }
    }

    return null;
  }

  private boolean hasSamePort( int[] superVlanPort, int[] ports )
  {
    for( int i=0; i<superVlanPort.length; i++ )
    {
      for( int j=0;j<ports.length; j++ )
      {
        if( superVlanPort[i] ==  ports[j] )
        {
          return true;
        }
      }
    }
    return false;
  }

  public void setSuperVlan(int id)
  {
    superVlan = id;
  }

  public int[] getSelectedVlanList()
  {
    return selectedVlanList;
  }

  public void setSelctedVlanList(int[] list)
  {
    vlanList.clearSelection();

    if(list != null)
    {
      for(int i = 0; i < list.length; i++)
      {
        int index = vlanListModel.indexOf(list[i]);
        vlanList.addSelectionInterval(index, index);
      }
    }
  }

  public void setSelectedVlanList(String[] list)
  {
    vlanList.clearSelection();

    if(list != null)
    {
      try
      {
        for(int i = 0; i < list.length; i++)
        {
          int index = vlanListModel.indexOf(new Integer(list[i]));
          vlanList.addSelectionInterval(index, index);
        }
      }
      catch(Exception e)
      {
        vlanList.clearSelection();
      }
    }
  }

  /**
   * This method initializes this
   *
   */
  private void initialize() {
    this.setTitle(fApplication.getActiveDeviceManager().getGuiComposer().getString("Select_VLAN_List"));
    this.setSize(new Dimension(400, 400));
    this.setContentPane(getJPanel());
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    Container c = SwingUtilities.getWindowAncestor(this);
    if(this.getParent() != null && c != this.getParent())
      GuiUtils.centerFrameDialog((JDialog)this.getParent(), this);
    else
      GUIUtilities.centerDesktopDialog(this);
  }

  /**
   * This method initializes jPanel
   *
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel()
  {
    if (jPanel == null)
    {
      jPanel = new JPanel();
      jPanel.setLayout(new BorderLayout());
      jPanel.add(getScrollPane(), BorderLayout.CENTER);
      jPanel.add(getJPanel1(), BorderLayout.SOUTH);
    }
    return jPanel;
  }
  /**
   * This method initializes jScrollPane
   *
   * @return javax.swing.JScrollPane
   */
  private JScrollPane getScrollPane()
  {
    if (scrollPane == null)
    {
      scrollPane = new JScrollPane();
      scrollPane.setViewportView(getVlanList());
    }
    return scrollPane;
  }
  /**
   * This method initializes jPanel1
   *
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel1()
  {
    if (buttonPanel == null)
    {
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridBagLayout());
      buttonPanel.add(getOkButton(), new GridBagConstraints());
      buttonPanel.add(getCancelButton(), new GridBagConstraints());
    }
    return buttonPanel;
  }
  /**
   * This method initializes jList
   *
   * @return javax.swing.JList
   */
  private JList getVlanList()
  {
    if (vlanList == null)
    {
      vlanListModel = new DefaultListModel();
      vlanList = new JList(vlanListModel);
//      vlanList.setCellRenderer(new VlanListTreeCellRenderer());
      vlanList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    return vlanList;
  }
  /**
   * This method initializes jButton
   *
   * @return javax.swing.JButton
   */
  private JButton getOkButton()
  {
    if (okButton == null)
    {
      okButton = new JButton();
      okButton.setPreferredSize(new Dimension(80, 30));
      okButton.setActionCommand("OK");
      okButton.setText(fApplication.getGlobalStringMap().getString("OK"));
      okButton.addActionListener(this);
    }
    return okButton;
  }
  /**
   * This method initializes jButton1
   *
   * @return javax.swing.JButton
   */
  private JButton getCancelButton()
  {
    if (cancelButton == null)
    {
      cancelButton = new JButton();
      cancelButton.setPreferredSize(new Dimension(80, 30));
      cancelButton.setActionCommand("Cancel");
      cancelButton.setText(fApplication.getGlobalStringMap().getString("Cancel"));
      cancelButton.addActionListener(this);
    }
    return cancelButton;
  }

  public static void main(String[] args)
  {
    NeFileChooser fileChooser = new NeFileChooser(null);
    fileChooser.show();
  }

  public void actionPerformed(ActionEvent event)
  {
    String action = event.getActionCommand();
    if(action.equals("OK"))
    {
      if(!vlanList.isSelectionEmpty())
      {
        Object[] o = vlanList.getSelectedValues();
        selectedVlanList = new int[o.length];

        for(int i = 0; i < o.length; i++)
        {
          selectedVlanList[i] = ((Integer)o[i]).intValue();
        }

        dispose();
      }
    }
    else
    {
      selectedVlanList = null;
      dispose();
    }
  }
}

/*
class VlanListTreeCellRenderer extends DefaultTreeCellRenderer
{
  Icon closeFolderIcon = null;
  Icon openFolderIcon = null;
  Icon fileIcon = null;

  public VlanListTreeCellRenderer() {
    closeFolderIcon = createImageIcon("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/close_folder.gif");
    openFolderIcon = createImageIcon("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/open_folder.gif");
    fileIcon = createImageIcon("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/file.gif");
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                boolean sel, boolean expanded,
                                                boolean leaf, int row,
                                                boolean hasFocus) {
    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
    if(node.isRoot())
    {
      if(expanded)
        this.setIcon(openFolderIcon);
      else
        this.setIcon(closeFolderIcon);
    }
    else
    {
      NeFileSystem.File file = (NeFileSystem.File)node.getUserObject();

      if(file.isDirectory())
      {
        if(expanded)
          this.setIcon(openFolderIcon);
        else
          this.setIcon(closeFolderIcon);
      }
      else
      {
        this.setIcon(fileIcon);
      }
    }

    return this;
  }

  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = NeFileTreeCellRenderer.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    }
    else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}*/
