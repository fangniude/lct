package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Dot3Onu2DbaQueuePanel extends JPanel implements ChangeListener{
  protected IApplication fApplication = null;
  protected DvmStringMap fStringMap = null;

  private String name = null;
  private JCheckBox[] queueCheckBoxList = new JCheckBox[8];
  private IntegerTextField[] thresholdFieldList = new IntegerTextField[8];

  public Dot3Onu2DbaQueuePanel(IApplication app) {
    this(app, "ONU Queue");
  }

  public Dot3Onu2DbaQueuePanel(IApplication app, String title) {
    name = title;
    fApplication = app;
    if (fApplication.getActiveDeviceManager() != null) {
      fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
    }

    init();
    initForm();
  }

  private void init() {
    JPanel bitMapPanel = new JPanel();
    NTLayout layout = new NTLayout(4, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    bitMapPanel.setLayout(layout);
    bitMapPanel.setBorder(BorderFactory.createTitledBorder(name));

    for(int i = 0; i <queueCheckBoxList.length; i++)
    {
      JCheckBox box = new JCheckBox(fStringMap.getString("Queue") + (i));
      box.addChangeListener(this);
      box.setActionCommand("" + i);
      queueCheckBoxList[i] = box;
      bitMapPanel.add(box);

      IntegerTextField thresholdField = new IntegerTextField();
      thresholdFieldList[i] = thresholdField;
      bitMapPanel.add(thresholdField);
    }

    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    setLayout(layout);
    add(bitMapPanel);
  }

  private void initForm()
  {
    for(int i = 0; i < thresholdFieldList.length; i++)
    {
      thresholdFieldList[i].setValueScope(0, 65535);
    }
  }

  public boolean validateFrom() {
    return true;
  }

  public byte[] getQueueBitmap()
  {
    int v = 0;
    for(int i = 0; i < 8; i++)
    {
      if(queueCheckBoxList[i].isSelected())
      {
        int mask = (int)Math.pow(2, i);
        v = v + mask;
      }
    }

    return new byte[]{(byte)v};
  }

  public void setQueueThreshold(byte[] threshold)
  {
    if(threshold == null) return;

    try
    {
      for(int i = 0; i < queueCheckBoxList.length; i++)
      {
        queueCheckBoxList[i].setSelected(true);
      }
      
      for(int i = 0; i < threshold.length/2; i++)
      {
        thresholdFieldList[i].setValue(getInt(threshold[i*2], threshold[i*2+1]));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public byte[] getQueueThreshold()
  {
    byte[] b = new byte[16];
    for(int i = 0; i < thresholdFieldList.length; i++)
    {
      if(thresholdFieldList[i].isEnabled())
      {
        byte[] value = getByteArray(thresholdFieldList[i].getValue());
        System.arraycopy(value, 0, b, i*2, value.length);
      }
    }

    return b;
  }

  public void stateChanged(ChangeEvent e) {
    try
    {
      JCheckBox box = (JCheckBox)e.getSource();
      int index = Integer.parseInt(box.getActionCommand());
      if(queueCheckBoxList[index].isSelected())
      {
        thresholdFieldList[index].setEnabled(true);
      }
      else
      {
        thresholdFieldList[index].setEnabled(false);
      }
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
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
