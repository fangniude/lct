package com.winnertel.ems.epon.iad.bbs4000.gui.r300;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.base.FormattedField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class Dot3OnuEtherPortVlanPanel extends JPanel{
  protected IApplication fApplication = null;
  protected DvmStringMap fStringMap = null;

  private FormattedField[] vlanFieldList = new FormattedField[32];
  private byte[] vlanTranslation = null;
  private byte[] vlanNTo1Translation = null;

  public Dot3OnuEtherPortVlanPanel(IApplication app) {
    fApplication = app;
    if (fApplication.getActiveDeviceManager() != null) {
      fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
    }

    init();
    initForm();
  }

  private void init() {
    JPanel vlanTranslationPanel = new JPanel();
    NTLayout layout = new NTLayout(8, 1, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    layout.setMargins(6, 10, 6, 10);
    vlanTranslationPanel.setLayout(layout);
//    vlanTranslationPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("VLAN_Translation_Panel")));

    for(int i = 1; i <= 8; i++)
    {
      JPanel rowPanel = new JPanel();
      NTLayout layout2 = new NTLayout(2, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
      layout2.setMargins(6, 10, 6, 10);
      rowPanel.setLayout(layout2);

      HexTextField strVlanField = new HexTextField();
      strVlanField.setColumns(5);
      vlanFieldList[(i-1)*4] = strVlanField;
      rowPanel.add(new JLabel(fStringMap.getString("in-tpid") + i + fStringMap.getString("postfix_hex")));
      rowPanel.add(strVlanField);

      IntegerTextField intVlanField = new IntegerTextField();
      intVlanField.setColumns(5);
      vlanFieldList[(i-1)*4+1] = intVlanField;
      rowPanel.add(new JLabel(fStringMap.getString("in-tag") + i + fStringMap.getString("postfix_decimal")));
      rowPanel.add(intVlanField);

      strVlanField = new HexTextField();
      strVlanField.setColumns(5);
      rowPanel.add(new JLabel(fStringMap.getString("out-tpid") + i + fStringMap.getString("postfix_hex")));
      vlanFieldList[(i-1)*4+2] = strVlanField;
      rowPanel.add(strVlanField);

      intVlanField = new IntegerTextField();
      intVlanField.setColumns(5);
      rowPanel.add(new JLabel(fStringMap.getString("out-tag") + i + fStringMap.getString("postfix_decimal")));
      vlanFieldList[(i-1)*4+3] = intVlanField;
      rowPanel.add(intVlanField);

      vlanTranslationPanel.add(rowPanel);
    }

    setLayout(new BorderLayout());
    add( new JScrollPane(vlanTranslationPanel));

    setPreferredSize(new Dimension(450, 550));
  }

  private void initForm()
  {
    for(int i = 0; i < vlanFieldList.length; i++)
    {
        if (i%2==1){
            ((IntegerTextField)vlanFieldList[i]).setValueScope(0, 65535);
        }
        if(i%2 == 0){
            ((HexTextField)vlanFieldList[i]).setDefaultString("0");
            ((HexTextField)vlanFieldList[i]).setLenScope(1, 4);
        }
    }
  }

 public boolean validateFrom() {
     for (int i = 0; i < vlanFieldList.length; i++) {
         if (i%2==0){
             int seq = i/4 +1;
             String label =fStringMap.getString("in-tpid") + seq + ": ";
             if (i%4 !=0) label = fStringMap.getString("out-tpid") +seq + ": ";
             try {
                 Integer theValue = Integer.valueOf(((HexTextField)vlanFieldList[i]).getValue(), 16);
                 if (theValue.intValue() < 0 || theValue.intValue() > 65535) {
                     MessageDialog.showInfoMessageDialog(fApplication, label + fStringMap.getString("Err_hex"));
                     return false;
                 }
             } catch (Exception e) {
                 MessageDialog.showInfoMessageDialog(fApplication, label + fStringMap.getString("Err_hex"));
                 return false;
             }
         }else{

         }
     }
     return true;
  }

  public boolean isNull() {
    for(int i = 0; i < vlanFieldList.length; i++)
    {
      if((!vlanFieldList[i].getText().equals("")) && (!vlanFieldList[i].getText().equals("0"))) {
        return false;
      }
    }

    return true;
  }

  //clear the fieled.
  public void clear() {
    for(int i = 0; i < vlanFieldList.length; i++)
    {
      vlanFieldList[i].setText("0");
    }
  }

  public void setVlanTranslation(byte[] value) {
    try
    {
      int cursor = 0;
      for(int i = 0; i < value.length/8; i++)
      {
        int int0 = Integer.parseInt(((HexTextField)vlanFieldList[i*4]).getValue(), 16);
        int int1 = ((IntegerTextField)vlanFieldList[i*4+1]).getValue();
        int int2 = Integer.parseInt(((HexTextField)vlanFieldList[i*4+2]).getValue(), 16);
        int int3 = ((IntegerTextField)vlanFieldList[i*4+3]).getValue();

        if(int0 + int1 + int2 + int3 == 0){
          ((HexTextField)vlanFieldList[i*4]).setValue(Integer.toHexString(getInt(value[cursor*8], value[cursor*8+1])));
          ((IntegerTextField)vlanFieldList[i*4+1]).setValue(getInt(value[cursor*8+2], value[cursor*8 + 3]));
          ((HexTextField)vlanFieldList[i*4+2]).setValue(Integer.toHexString(getInt(value[cursor*8+4], value[cursor*8 + 5])));
          ((IntegerTextField)vlanFieldList[i*4+3]).setValue(getInt(value[cursor*8+6], value[cursor*8 + 7]));

          cursor++;
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public void calculate() {
    vlanTranslation = new byte[64];
    vlanNTo1Translation = new byte[64];

    boolean same = false;
    int cursor = 0, count = 1, current = 0;

    for(int i = 0; i < vlanFieldList.length/4; i++)
    {
      int outVlan = ((IntegerTextField)vlanFieldList[i*4 + 3]).getValue();

      if(outVlan != current)
      {
        if(current == 0) {
          current = outVlan;
        }
        else
        {
          copyToArray(cursor, count);
          current = outVlan;
          cursor = i;
          count = 1;

          if(i == vlanFieldList.length/4 - 1) {//last row.
            copyToArray(cursor, count);
          }
        }
      }
      else
      {
        count++;

        if(i == vlanFieldList.length/4 - 1) {//last row.
          copyToArray(cursor, count);
        }
      }
    }
  }

  public void copyToArray(int cursor, int count) {
    if(count == 1) {//vlanTranslation
      translate(vlanTranslation, cursor, count);
    } else if(count > 1) { //vlanNTo1Translation
      translate(vlanNTo1Translation, cursor, count);
    }
  }

  public void translate(byte[] b, int cursor, int count) {
    byte[] value;

    for(int i = 0; i < count; i++) {
      int index = (cursor + i) * 4;

      value = getByteArray( Integer.valueOf(((HexTextField)vlanFieldList[index]).getValue(),16).intValue());
      System.arraycopy(value, 0, b, index*2, value.length);

      value = getByteArray(((IntegerTextField)vlanFieldList[index + 1]).getValue());
      System.arraycopy(value, 0, b, (index + 1)*2, value.length);

      value = getByteArray( Integer.valueOf(((HexTextField)vlanFieldList[index + 2]).getValue(),16).intValue());
      System.arraycopy(value, 0, b, (index + 2)*2, value.length);

      value = getByteArray(((IntegerTextField)vlanFieldList[index + 3]).getValue());
      System.arraycopy(value, 0, b, (index + 3)*2, value.length);
    }
  }

  public byte[] getVlanTranslation() {
    return vlanTranslation;
  }

  public byte[] getVlanNTo1Translation() {
    return vlanNTo1Translation;
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

  public void setEnabled(boolean b) {
    super.setEnabled(b);

    for(int i = 0; i < vlanFieldList.length; i++) {
      vlanFieldList[i].setEnabled(b);
    }
  }
}
