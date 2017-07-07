package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

public class BBS1000PortSelectionPanel extends JPanel implements ItemListener{
  protected IApplication fApplication = null;
  protected DvmStringMap fStringMap = null;
  protected boolean isDynamic = false;
  protected JCheckBox[] boxes = null;
  protected JCheckBox selectAll = new JCheckBox();

  public BBS1000PortSelectionPanel(IApplication app) {
    this(app, false);
  }

  public BBS1000PortSelectionPanel(IApplication app, boolean dynamic) {
    fApplication = app;
    isDynamic = dynamic;
    fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());

    init();
    createUI();
  }

  private void init() {
    if(isDynamic)
    {
      try
      {
        BBS1000CardMibBean mbean = new BBS1000CardMibBean(fApplication.getSnmpProxy());
        Vector v = mbean.retrieveAll();
        if(v != null)
        {
          int i = 0;
          while(i < v.size())
          {
            BBS1000CardMibBean card = (BBS1000CardMibBean)v.get(i);

            if(card.getUtsEponModuleBoardState()!= null && card.getUtsEponModuleBoardState() == 3)//active
            {
              i++;
            }
            else
            {
              v.remove(i);
            }
          }

          i = 0;
          boxes = new JCheckBox[v.size() * 4];
          for(int j = 0; j < v.size(); j++)
          {
            int cardId = ((BBS1000CardMibBean)v.get(j)).getUtsEponModuleBoardPhyId().intValue();

            for(int k = 1; k <=4 ; k++)
            {
              boxes[i] = new JCheckBox(cardId + "/" + k);
              i++;
            }
          }
        }
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      boxes = new JCheckBox[12];

      for(int i = 1; i <=3; i++)
      {
        for(int j = 1; j <= 4; j++)
        {
          boxes[(i-1) * 4 + j - 1] = new JCheckBox(i + "/" + j);
        }
      }
    }

    selectAll.setText(fStringMap.getString("Select_All"));
    selectAll.addItemListener(this);

    for(int i = 0; i < boxes.length; i++)
    {
      boxes[i].addItemListener(this);
    }
  }

  private void createUI()
  {
    int rows = boxes.length / 4 + 1;
    NTLayout layout = new NTLayout(rows, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    this.setLayout(layout);

    for(int i = 0; i < boxes.length; i++)
    {
      add(boxes[i]);
    }

    add(selectAll);
//    add(new HSpacer());
//    add(new HSpacer());
//    add(new HSpacer());
  }

  public void setEnabled(boolean b)
  {
    super.setEnabled(b);

    selectAll.setEnabled(b);
    if(boxes != null)
    {
      for(int i = 0; i < boxes.length; i++)
      {
        boxes[i].setEnabled(b);
      }
    }
  }

  public void itemStateChanged(ItemEvent e) {
    JCheckBox box = (JCheckBox)e.getSource();

    if(box == selectAll)
    {
      if(boxes != null)
      {
        for(int i = 0; i < boxes.length; i++)
        {
          boxes[i].setSelected(e.getStateChange() == ItemEvent.SELECTED);
        }
      }
    }
    else
    {
      if(e.getStateChange() != ItemEvent.SELECTED)
      {
        selectAll.removeItemListener(this);
        selectAll.setSelected(false);
        selectAll.addItemListener(this);
      }
    }
  }

  public String[] getSelectedPorts()
  {
    Vector v = new Vector();

    if(boxes != null)
    {
      for(int i = 0; i < boxes.length; i++)
      {
        if(boxes[i].isSelected())
        {
          v.add(boxes[i].getText());
        }
      }
    }

    return (String[])v.toArray(new String[0]);
  }

  public void setSelectedPorts(byte[] ports)
  {

  }

  public void setSelectedPorts(String[] ports)
  {
    removeAllSelectedPorts();
    if(ports != null)
    {
      for(int i = 0; i < ports.length; i++)
      {
        addSelectedPort(ports[i]);
      }
    }
  }

  public void addSelectedPort(String port)
  {
    for(int i = 0; i < boxes.length; i++)
    {
      if(boxes[i].getText().equals(port))
      {
        boxes[i].setSelected(true);
        break;
      }
    }
  }

  public void setSelectedPort(String port)
  {
    removeAllSelectedPorts();
    addSelectedPort(port);
  }

  public void removeAllSelectedPorts()
  {
    for(int i = 0; i < boxes.length; i++)
    {
      boxes[i].setSelected(false);
    }
  }
}
