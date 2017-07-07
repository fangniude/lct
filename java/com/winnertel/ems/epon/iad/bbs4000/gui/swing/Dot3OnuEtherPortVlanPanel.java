package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.util.gui.input.HexTextField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.base.FormattedField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;

public class Dot3OnuEtherPortVlanPanel extends JPanel{
  protected IApplication fApplication = null;
  protected DvmStringMap fStringMap = null;

  private FormattedField[] vlanFieldList = new FormattedField[32];

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
      NTLayout layout2 = new NTLayout(2, 5, NTLayout.FILL, NTLayout.CENTER, 5, 5);
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
      rowPanel.add(new HSpacer());

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
      rowPanel.add(new HSpacer());

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
            ((IntegerTextField)vlanFieldList[i]).setValueScope(0, 4094);
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

  public void setVlanTranslation(byte[] value) {
    try
    {
      for(int i = 0; i < value.length/8; i++)
      {
        ((HexTextField)vlanFieldList[i*4]).setValue(Integer.toHexString(getInt(value[i*8], value[i*8+1])));
        ((IntegerTextField)vlanFieldList[i*4+1]).setValue(getInt(value[i*8+2], value[i*8 + 3]));
        ((HexTextField)vlanFieldList[i*4+2]).setValue(Integer.toHexString(getInt(value[i*8+4], value[i*8 + 5])));
        ((IntegerTextField)vlanFieldList[i*4+3]).setValue(getInt(value[i*8+6], value[i*8 + 7]));
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  public byte[] getVlanTranslation() {
    byte[] b = new byte[64];
    for(int i = 0; i < vlanFieldList.length; i++)
    {
        byte[] value;
        if(i%2==0){
            value = getByteArray( Integer.valueOf(((HexTextField)vlanFieldList[i]).getValue(),16).intValue());
        }else{
            value = getByteArray(((IntegerTextField)vlanFieldList[i]).getValue());
        }
      System.arraycopy(value, 0, b, i*2, value.length);
    }

    return b;
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
