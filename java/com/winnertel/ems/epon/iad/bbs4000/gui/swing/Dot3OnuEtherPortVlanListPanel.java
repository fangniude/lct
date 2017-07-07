package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

public class Dot3OnuEtherPortVlanListPanel extends JPanel implements ActionListener{
  protected IApplication fApplication = null;
  protected DvmStringMap fStringMap = null;

  private JList mutilcastVlanList = new JList();
  private Vector vlanVector = new Vector(64);

  private JButton addButton = new JButton();
  private JButton removeButton = new JButton();

  public Dot3OnuEtherPortVlanListPanel(IApplication app) {
    fApplication = app;
    if (fApplication.getActiveDeviceManager() != null) {
      fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
    }

    init();
  }

  private void init() {
    JPanel buttonPanel = new JPanel();
    NTLayout layout = new NTLayout(6, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    buttonPanel.setLayout(layout);
    buttonPanel.add(new HSpacer());
    buttonPanel.add(new HSpacer());

    URL url = getClass().getResource("images/icon_add.gif");
    if(url != null)
    {
      addButton.setIcon(new ImageIcon(url));
    }
    else
    {
      addButton.setText("+");
    }
    addButton.setPreferredSize(new Dimension(20, 20));
    addButton.addActionListener(this);
    buttonPanel.add(addButton);

    url = getClass().getResource("images/icon_delete.gif");
    if(url != null)
    {
      removeButton.setIcon(new ImageIcon(url));
    }
    else
    {
      removeButton.setText("+");
    }
    removeButton.setPreferredSize(new Dimension(20, 20));
    removeButton.addActionListener(this);
    buttonPanel.add(removeButton);
    buttonPanel.add(new HSpacer());
    buttonPanel.add(new HSpacer());

    JPanel mVlanListPanel = new JPanel();
    BorderLayout layout3 = new BorderLayout();
    layout3.setHgap(10);
    mVlanListPanel.setLayout(layout3);
//    mVlanListPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("Multicast_Vlan_Panel")));

//    mutilcastVlanList.setPreferredSize(new Dimension(180, 200));
//    mutilcastVlanList.setBorder(BorderFactory.createEtchedBorder());
    JScrollPane mutilcastVlanListPane = new  JScrollPane(mutilcastVlanList);
    mutilcastVlanListPane.setPreferredSize(new Dimension(180, 200));
    mutilcastVlanListPane.setBorder(BorderFactory.createEtchedBorder());

    mVlanListPanel.add(mutilcastVlanListPane, BorderLayout.CENTER);
    mVlanListPanel.add(buttonPanel, BorderLayout.EAST);

    setLayout(new BorderLayout());
    add( new JScrollPane(mVlanListPanel));

    setPreferredSize(new Dimension(450, 550));
  }

  public void setMulticastVlanList(byte[] value) {
    vlanVector.clear();
    try
    {
      for(int i = 0; i < value.length/2; i++)
      {
        int v = getInt(value[i*2], value[i*2+1]);
        if(v > 0)
        {
          vlanVector.add("" + v);
        }
      }

      mutilcastVlanList.setListData(vlanVector);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public byte[] getMulticastVlanList() {
    byte[] b = new byte[128];

    try
    {
      for(int i = 0; i < vlanVector.size(); i++)
      {
        byte[] value = getByteArray(Integer.parseInt((String)vlanVector.get(i)));
        System.arraycopy(value, 0, b, i*2, value.length);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return b;
  }

  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if(source == addButton)
    {
      if(vlanVector.size() > 64)
      {
        JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Vlan_Id_Is_More_Than_64"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
        return;
      }

      String input = JOptionPane.showInputDialog(this, fStringMap.getString("Msg_Input_Vlan_Id"), "1");
      if(input == null) return;

      try
      {
        int vlanId = Integer.parseInt(input.trim());
        if(vlanId <= 0 || vlanId > 4094)
        {
          JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Is_Invalid"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
          return;
        }

        insertVlanId(vlanId);
      }
      catch(Exception ex)
      {
        JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Is_Invalid"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
      }
    }
    else if(source == removeButton)
    {
      removeSelectedVlanId();
    }
  }

  protected void insertVlanId(int vlanId)
  {
    if(vlanVector.contains("" + vlanId))
    {
      JOptionPane.showMessageDialog(this, fStringMap.getString("Err_Input_Vlan_Id_Exist"), fStringMap.getString("Error"), JOptionPane.WARNING_MESSAGE);
      return;
    }

    vlanVector.add("" + vlanId);
    mutilcastVlanList.setListData(vlanVector);

    mutilcastVlanList.setSelectedValue("" + vlanId, true);
  }

  protected void removeSelectedVlanId()
  {
    Object[] vlan = mutilcastVlanList.getSelectedValues();

    for(int i = 0; i < vlan.length; i++)
    {
      vlanVector.remove(vlan[i]);
    }

    mutilcastVlanList.setListData(vlanVector);

    if(vlanVector.size() > 0)
    {
      mutilcastVlanList.setSelectedIndex(vlanVector.size() - 1);
    }
  }

  private int getInt(byte b1, byte b2)
  {
    return (255 & b1) * 256 + (255 & b2);
  }

  private byte[] getByteArray(int i)
  {
    byte[] b = new byte[2];
    b[1] = (byte)i;
    i = i>>8;
    b[0] = (byte)i;
    return b;
  }
}
