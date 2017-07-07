package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.generator;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ILogResourceFactory;
import com.winnertel.ems.epon.iad.bbs1000.mib.InterfaceTableMBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.ChassisConfGroup;
import com.winnertel.ems.epon.iad.bbs1000.mib.GlobalLedMibBean;
import com.winnertel.tgcl.model.*;
import com.winnertel.tgcl.UDataBox;

import java.util.List;

public class GSMCardGenerator
{
  IApplication fApplication = null;

  public GSMCardGenerator(IApplication application)
  {
    this.fApplication = application;
  }

  public Card generate(UDataBox dataSource, BBS1000CardMibBean bean)
  {
    Card card = new Card();
    card.setUserObject("" + bean.getUtsEponModuleBoardPhyId());
    card.setLabel(fApplication.getGlobalStringMap().getString("Card") + " " + bean.getUtsEponModuleBoardPhyId());
    card.setTypeInfo(new TypeInfo("GSM"));

    dataSource.addElement(card);
    Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");
    dataSource.setParent(shelf, card, 192, 0);
    if(bean.getUtsEponModuleBoardState().intValue() == 3) //active
    {
      card.setImage(ILogResourceFactory.getCardImage("GSM"));

      GlobalLedMibBean ledBean = new GlobalLedMibBean(fApplication.getSnmpProxy());
      try
      {
        ledBean.retrieve();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

      assemblePort(dataSource, card, ledBean);
      assembleLed(dataSource, card, ledBean);
    }
    else
    {
      card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
    }

    return card;
  }

  protected void assemblePort(UDataBox dataSource, Card card, GlobalLedMibBean bean)
  {
    String cardName = card.getUserObject().toString();
    InterfaceTableMBean portBean = new InterfaceTableMBean(fApplication.getSnmpProxy());

    for(int i = 1; i <= 4; i++)
    {
      Port port = new Port();
      port.setUserObject(cardName + "/" + i);
      port.setTypeInfo(new TypeInfo("GSM"));
      port.setImage(ILogResourceFactory.getPortImage("GSM"));
      dataSource.addElement(port);
      dataSource.setParent(card, port, 215 + i * 21, 7);

      LED lnkLed = new LED();
      lnkLed.setUserObject(cardName + "_LNK" + i);
      lnkLed.setTypeInfo(new TypeInfo("LED"));
      dataSource.addElement(lnkLed);
      dataSource.setParent(card, lnkLed, 345, 3+(i-1)*5);

      try
      {
        portBean.setIfIndex(new Integer(ConfigUtility.generateIfIndex(card.getUserObject() + "/" + i)));
        portBean.retrieve();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

      if(portBean.getIfAdminStatus() != null && portBean.getIfAdminStatus().intValue() == 1) //up
      {
        port.clearState(ILogResourceFactory.LOCKED);
      }
      else
      {
        port.setState(ILogResourceFactory.LOCKED);
      }

      Integer state = (Integer)MibBeanUtil.getSimpleProperty(bean, "utsBBSLEDGsmUplinkSFP" + i +"State");
      if(state != null && state == 1)//green-on
      {
        lnkLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
      }
      else
      {
        lnkLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }
    }
  }

  protected void assembleLed(UDataBox dataSource, Card card, GlobalLedMibBean bean)
  {
    String cardName = card.getUserObject().toString();
    //POWER
    LED pwrLed = new LED();
    pwrLed.setUserObject(cardName + "_PWR");
    pwrLed.setTypeInfo(new TypeInfo("LED"));
    pwrLed.setLabel("PWR");
    pwrLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
    dataSource.addElement(pwrLed);
    dataSource.setParent(card, pwrLed, 82, 10);

    LED fanLed = new LED();
    fanLed.setUserObject(cardName + "_FAN");
    fanLed.setTypeInfo(new TypeInfo("LED"));
    fanLed.setLabel("FAN");
    if(bean.getUtsBBSLEDFanLedState() != null && bean.getUtsBBSLEDFanLedState().intValue() == 1)//1: green-on
    {
      fanLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
    }
    else//2: red-on
    {
      fanLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
    }
    dataSource.addElement(fanLed);
    dataSource.setParent(card, fanLed, 101, 17);

    LED criLed = new LED();
    criLed.setUserObject(cardName + "_CRI");
    criLed.setTypeInfo(new TypeInfo("LED"));
    criLed.setLabel("CRI");
    if(bean.getUtsBBSLEDAlarmCriticalLedState() != null && bean.getUtsBBSLEDAlarmCriticalLedState().intValue() == 1)//1: red-on
    {
      criLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
    }
    else
    {
      criLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
    }
    dataSource.addElement(criLed);
    dataSource.setParent(card, criLed, 62, 10);

    LED majLed = new LED();
    majLed.setUserObject(cardName + "_MAJ");
    majLed.setTypeInfo(new TypeInfo("LED"));
    majLed.setLabel("MAJ");
    if(bean.getUtsBBSLEDAlarmMajorLedState() != null && bean.getUtsBBSLEDAlarmMajorLedState().intValue() == 1)//1: red-on
    {
      majLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
    }
    else
    {
      majLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
    }
    dataSource.addElement(majLed);
    dataSource.setParent(card, majLed, 62, 17);

    LED minLed = new LED();
    minLed.setUserObject(cardName + "_MIN");
    minLed.setTypeInfo(new TypeInfo("LED"));
    minLed.setLabel("MIN");
    if(bean.getUtsBBSLEDAlarmMinorLedState() != null && bean.getUtsBBSLEDAlarmMinorLedState().intValue() == 1)//1: yellow-on
    {
      minLed.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
    }
    else
    {
      minLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
    }
    dataSource.addElement(minLed);
    dataSource.setParent(card, minLed, 82, 17);

    LED sysLed = new LED();
    sysLed.setUserObject(cardName + "_SYS");
    sysLed.setTypeInfo(new TypeInfo("LED"));
    sysLed.setLabel("SYS");
    if(bean.getUtsBBSLEDSystemLedState() != null && bean.getUtsBBSLEDSystemLedState().intValue() == 1)//1: green-on
    {
      sysLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
    }
    else//2: red-on
    {
      sysLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
    }
    dataSource.addElement(sysLed);
    dataSource.setParent(card, sysLed, -77, 180);

  }

  protected void updatePort(Port port, InterfaceTableMBean bean)
  {
    if(bean.getIfAdminStatus() != null && bean.getIfAdminStatus().intValue() != 1) //down
    {
      port.setState(ILogResourceFactory.LOCKED);
    }
    else
    {
      port.clearState(ILogResourceFactory.LOCKED);
    }
  }

  protected void updateLed(LED led, InterfaceTableMBean bean)
  {
    String portName = ConfigUtility.formatIfIndex("" + bean.getIfIndex());
    //update the led state.
    String portId = portName.substring(portName.indexOf("/") + 1);

    GlobalLedMibBean ledBean = new GlobalLedMibBean(fApplication.getSnmpProxy());
    try
    {
      ledBean.retrieve();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    Integer state = (Integer)MibBeanUtil.getSimpleProperty(ledBean, "utsBBSLEDGsmUplinkSFP" + portId +"State");
    if(state != null && state == 1)//green-on
    {
      led.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
    }
    else
    {
      led.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
    }
  }

  protected void updateLed(LED led, ChassisConfGroup bean)
  {
    GlobalLedMibBean ledBean = new GlobalLedMibBean(fApplication.getSnmpProxy());
    try
    {
      ledBean.retrieve();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    if(ledBean.getUtsBBSLEDFanLedState() != null && ledBean.getUtsBBSLEDFanLedState().intValue() == 1)//1: green-on
    {
      led.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
    }
    else//2: red-on
    {
      led.setImage(ILogResourceFactory.getLedImage("LED_RED"));
    }
  }

  /**
   * update the GEM card in datasource.
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, BBS1000CardMibBean bean)
  {
    Card card = (Card)dataSource.getElementByUserObject("" + bean.getUtsEponModuleBoardPhyId());

    if(card.getTypeInfo().getName().startsWith("GSM"))
    {
      if(bean.getUtsEponModuleBoardState().intValue() == 3) // active
      {
        card.setImage(ILogResourceFactory.getCardImage("GSM"));

        //update the state
//        IltOSIObjectState state = (IltOSIObjectState)card.getObjectState();
//        state.setState(new IltOSI.State(IltOSI.State.Operational.Enabled, IltOSI.State.Usage.Active, IltOSI.State.Administrative.Unlocked));

        //update the port on card.
        InterfaceTableMBean portBean = new InterfaceTableMBean(fApplication.getSnmpProxy());
        for(int i = 1; i <= 4; i++)
        {
          try
          {
            String portName = bean.getUtsEponModuleBoardPhyId() + "/" + i;
            portBean.setIfIndex(new Integer(ConfigUtility.generateIfIndex(portName)));
            portBean.retrieve();

            Port port = (Port)dataSource.getElementByUserObject(portName);
            updatePort(port, portBean);

            //update the led state.
            String ledName = bean.getUtsEponModuleBoardPhyId() + "_LNK" + i;
            LED led = (LED)dataSource.getElementByUserObject(ledName);
            updateLed(led, portBean);
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }
        }
      }
      else
      {
        card.setImage(ILogResourceFactory.getCardImage("EMPTY"));

        List children = dataSource.getChildren(card);
        for(int i = 0; i < children.size(); i++)
        {
          dataSource.removeElement((Element)children.get(i), true);
        }
      }
    }
    else
    {
      if(bean.getUtsEponModuleBoardState().intValue() == 3) //active
      {
        card.setImage(ILogResourceFactory.getCardImage("GSM"));

        GlobalLedMibBean ledBean = new GlobalLedMibBean(fApplication.getSnmpProxy());
        try
        {
          ledBean.retrieve();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        //add the port to card.
        assemblePort(dataSource, card, ledBean);

        //add the LEDs to card.
        assembleLed(dataSource, card, ledBean);
      }
    }
  }

  /**
   * update the GE port on GEM card in datasource.
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, InterfaceTableMBean bean)
  {
    String portName = ConfigUtility.formatIfIndex("" + bean.getIfIndex());
    Port port = (Port)dataSource.getElementByUserObject(portName);

    updatePort(port, bean);

    //update the led state.
    String cardId = portName.substring(0, portName.indexOf("/"));
    String portId = portName.substring(portName.indexOf("/") + 1);
    String ledName = cardId + "_LNK" + portId;
    LED led = (LED)dataSource.getElementByUserObject(ledName);
    updateLed(led, bean);
  }

  public void update(UDataBox dataSource, ChassisConfGroup bean)
  {
    LED led = (LED)dataSource.getElementByUserObject("3_FAN");
    updateLed(led, bean);
  }
}
