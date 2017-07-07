package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.generator;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ILogResourceFactory;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.ChassisConfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.CsmLedGroupBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.Element;
import com.winnertel.tgcl.model.LED;
import com.winnertel.tgcl.model.Port;
import com.winnertel.tgcl.model.Shelf;
import com.winnertel.tgcl.model.TypeInfo;

import java.util.List;

public class CSMCardGenerator
{
  IApplication application = null;
  FanAssembleHelper helper = null;

  public CSMCardGenerator(IApplication application)
  {
    this.application = application;
    helper = new FanAssembleHelper();
  }

  public void generate(UDataBox dataSource, BBS4000CardMibBean bean)
  {
    String name = "" + bean.getUtsEponModuleBoardPhyId().intValue();
    //2 - CSM Card.
//    if(bean.getUtsEponModuleBoardType().intValue() != 2)
//      throw new IllegalArgumentException("Unsupport Card Type: " + bean.getUtsEponModuleBoardType());

    Card card = new Card();
    card.setUserObject(name);
    card.setTypeInfo(new TypeInfo("CSM"));

    dataSource.addElement(card);
    int phyId = bean.getUtsEponModuleBoardPhyId().intValue();
    Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");

    if(phyId == 13)
    {
      card.setLabel(application.getGlobalStringMap().getString("Card") + " A - CSM");
      dataSource.setParent(shelf, card, 264, 0);
    }
    else if(phyId == 14)
    {
      card.setLabel(application.getGlobalStringMap().getString("Card") + " B - CSM");
      dataSource.setParent(shelf, card, 318, 0);
    }

    if(bean.getUtsEponModulePhyPresenceStat().intValue() == 1) //installed
    {
      card.setTypeInfo(new TypeInfo("CSM"));
      card.setImage(ILogResourceFactory.getCardImage("CSM"));
      
      if(bean.getUtsEponModuleAdminState().intValue() != 2) //unlocked
      {
        card.setState(ILogResourceFactory.LOCKED);
      }

      assemblePort(dataSource, card, bean);
      assembleLed(dataSource, card, bean);
      updateLed(dataSource, card);
    }
    else
    {
      card.setTypeInfo(new TypeInfo("EMPTY"));
      card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
    }

    //PhyId 13 is CSM card, add all the fans to this card.
    if(bean.getUtsEponModuleBoardPhyId().intValue() == 13)
    {
      ChassisConfTable chassisConfBean = new ChassisConfTable(application.getSnmpProxy());
      try
      {
        chassisConfBean.retrieve();
        helper.assembleLeftFan(dataSource, card, chassisConfBean);
        helper.assembleMiddleFan(dataSource, card, chassisConfBean);
        helper.assembleRightFan(dataSource, card, chassisConfBean);
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
      }
    }
  }

  protected void assemblePort(UDataBox dataSource, Card card, BBS4000CardMibBean bean)
  {
    for(int i = 1; i <= 3; i++)
    {
      Port port = new Port();
      port.setUserObject(card.getUserObject() + "/" + i);
      port.setTypeInfo(new TypeInfo("CSM"));
      port.setImage(ILogResourceFactory.getPortImage("CSM"));

      dataSource.addElement(port);
      dataSource.setParent(card, port, 8, 160 + (i - 1) * 30);
    }
  }

  protected void assembleLed(UDataBox dataSource, Card card, BBS4000CardMibBean bean)
  {
    //POWER
    LED pwrLed = new LED();
    pwrLed.setUserObject(card.getUserObject() + "_PWR");
    pwrLed.setLabel("PWR LED");
    pwrLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(pwrLed);
    dataSource.setParent(card, pwrLed, 10, 50);

    //RUN LED
    LED runLed = new LED();
    runLed.setUserObject(card.getUserObject() + "_RUN");
    runLed.setLabel("RUN LED");
    runLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(runLed);
    dataSource.setParent(card, runLed, 10, 58);
//    card.setItem(runLed, new IlpRelativePoint(41, 250));

    //SWAP LED
    LED swapLed = new LED();
    swapLed.setUserObject(card.getUserObject() + "_SWAP");
    swapLed.setLabel("SWAP LED");
    swapLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(swapLed);
    dataSource.setParent(card, swapLed, 10, 64);
//    card.setItem(swapLed, new IlpRelativePoint(41, 242));

    //ACT LED
    LED actLed = new LED();
    actLed.setUserObject(card.getUserObject() + "_ACT");
    actLed.setLabel("ACT LED");
    actLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(actLed);
    dataSource.setParent(card, actLed, 10, 72);
//    card.setItem(actLed, new IlpRelativePoint(41, 234));

    //CRITICAL ALARM LED
    LED criLed = new LED();
    criLed.setUserObject(card.getUserObject() + "_CRI");
    criLed.setLabel("CRI LED");
    criLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(criLed);
    dataSource.setParent(card, criLed, 11, 94);
//    card.setItem(criLed, new IlpRelativePoint(41, 212));

    //MAJOR ALARM LED
    LED majLed = new LED();
    majLed.setUserObject(card.getUserObject() + "_MAJ");
    majLed.setLabel("MAJ LED");
    majLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(majLed);
    dataSource.setParent(card, majLed, 11, 103);
//    card.setItem(majLed, new IlpRelativePoint(41, 203));

    //MINOR ALARM LED
    LED minLed = new LED();
    minLed.setUserObject(card.getUserObject() + "_MIN");
    minLed.setLabel("MIN LED");
    minLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(minLed);
    dataSource.setParent(card, minLed, 11, 112);
//    card.setItem(minLed, new IlpRelativePoint(41, 194));

    //LINK LED
    LED lnkLed = new LED();
    lnkLed.setUserObject(card.getUserObject() + "_LNK");
    lnkLed.setLabel("LNK LED");
    lnkLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(lnkLed);
    dataSource.setParent(card, lnkLed, 14, 152);
//    card.setItem(lnkLed, new IlpRelativePoint(30, 150));

    //SPEED LED
    LED spdLed = new LED();
    spdLed.setUserObject(card.getUserObject() + "_SPD");
    spdLed.setLabel("SPD LED");
    spdLed.setTypeInfo(new TypeInfo("LED"));
    dataSource.addElement(spdLed);
    dataSource.setParent(card, spdLed, 22, 152);
//    card.setItem(spdLed, new IlpRelativePoint(38, 150));
  }

  protected void updateLed(UDataBox dataSource, Card card)
  {
    CsmLedGroupBean csmLedBean = getCsmLedBean();

    List list = dataSource.getChildren(card);

    if("13".equals(card.getUserObject())) {
        for(int i = 0; i < list.size(); i++)
        {
          Element element = (Element)list.get(i);
          String id = (String)element.getUserObject();

          //POWER LED
          if(id.indexOf("PWR") != -1)
          {
            if(csmLedBean.getUtsBBSLEDCSMAPowerLedState() != null && csmLedBean.getUtsBBSLEDCSMAPowerLedState().intValue() == 1) //1: green-on; 2: green-off
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("RUN") != -1) {         //RUN LED
            if(csmLedBean.getUtsBBSLEDCSMARunLedState() != null && csmLedBean.getUtsBBSLEDCSMARunLedState().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("SWAP") != -1) {         //SWAP LED
            if(csmLedBean.getUtsBBSLEDCSMAHotSwapLedState() != null && csmLedBean.getUtsBBSLEDCSMAHotSwapLedState().intValue() == 1) //1: yeloow-on; 2: yellow-off; 3: flashing
              element.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("ACT") != -1) {          //ACT LED
            if(csmLedBean.getUtsBBSLEDCSMAActiveLedState() != null && csmLedBean.getUtsBBSLEDCSMAActiveLedState().intValue() == 1) //1: green-on; 2: green-off
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("CRI") != -1) {          //CRITICAL ALARM LED
            if(csmLedBean.getUtsBBSLEDCSMACriticalAlarmLedState() != null && csmLedBean.getUtsBBSLEDCSMACriticalAlarmLedState().intValue() == 1) //1: red-on; 2: red-off
              element.setImage(ILogResourceFactory.getLedImage("LED_RED"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("MAJ") != -1) {          //MAJOR ALARM LED
            if(csmLedBean.getUtsBBSLEDCSMAMajorAlarmLedState() != null && csmLedBean.getUtsBBSLEDCSMAMajorAlarmLedState().intValue() == 1) //1: red-on; 2: red-off
              element.setImage(ILogResourceFactory.getLedImage("LED_RED"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("MIN") != -1) {          //MINOR ALARM LED
            if(csmLedBean.getUtsBBSLEDCSMAMinorAlarmLedState() != null && csmLedBean.getUtsBBSLEDCSMAMinorAlarmLedState().intValue() == 1) //1: yellow-on; 2: yellow-off
              element.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("LNK") != -1) {          //LINK LED
            if(csmLedBean.getUtsBBSLEDCSMAEmsPortLinkLedState() != null && csmLedBean.getUtsBBSLEDCSMAEmsPortLinkLedState().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("SPD") != -1) {          //SPEED LED
            if(csmLedBean.getUtsBBSLEDCSMAEmsPortSpeedLedState() != null && csmLedBean.getUtsBBSLEDCSMAEmsPortSpeedLedState().intValue() == 1) //1: green-on; 2: green-off
              element.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          }
        }
    } else {
        for(int i = 0; i < list.size(); i++)
        {
          Element element = (Element)list.get(i);
          String id = (String)element.getUserObject();

          //POWER LED
          if(id.indexOf("PWR") != -1)
          {
            if(csmLedBean.getUtsBBSLEDCSMBPowerLedState() != null && csmLedBean.getUtsBBSLEDCSMBPowerLedState().intValue() == 1) //1: green-on; 2: green-off
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("RUN") != -1) {//RUN LED
            if(csmLedBean.getUtsBBSLEDCSMBRunLedState() != null && csmLedBean.getUtsBBSLEDCSMBRunLedState().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("SWAP") != -1) {//SWAP LED
            if(csmLedBean.getUtsBBSLEDCSMBHotSwapLedState() != null && csmLedBean.getUtsBBSLEDCSMBHotSwapLedState().intValue() == 1) //1: yeloow-on; 2: yellow-off; 3: flashing
              element.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("ACT") != -1) {//ACT LED
            if(csmLedBean.getUtsBBSLEDCSMBActiveLedState() != null && csmLedBean.getUtsBBSLEDCSMBActiveLedState().intValue() == 1) //1: green-on; 2: green-off
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("CRI") != -1) {//CRITICAL ALARM LED
            if(csmLedBean.getUtsBBSLEDCSMBCriticalAlarmLedState() != null && csmLedBean.getUtsBBSLEDCSMBCriticalAlarmLedState().intValue() == 1) //1: red-on; 2: red-off
              element.setImage(ILogResourceFactory.getLedImage("LED_RED"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("MAJ") != -1) {          //MAJOR ALARM LED
            if(csmLedBean.getUtsBBSLEDCSMBMajorAlarmLedState() != null && csmLedBean.getUtsBBSLEDCSMBMajorAlarmLedState().intValue() == 1) //1: red-on; 2: red-off
              element.setImage(ILogResourceFactory.getLedImage("LED_RED"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("MIN") != -1) {          //MINOR ALARM LED
            if(csmLedBean.getUtsBBSLEDCSMBMinorAlarmLedState() != null && csmLedBean.getUtsBBSLEDCSMBMinorAlarmLedState().intValue() == 1) //1: yellow-on; 2: yellow-off
              element.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("LNK") != -1) {          //LINK LED
            if(csmLedBean.getUtsBBSLEDCSMBEmsPortLinkLedState() != null && csmLedBean.getUtsBBSLEDCSMBEmsPortLinkLedState().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
              element.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          } else if(id.indexOf("SPD") != -1) {          //SPEED LED
            if(csmLedBean.getUtsBBSLEDCSMBEmsPortSpeedLedState() != null && csmLedBean.getUtsBBSLEDCSMBEmsPortSpeedLedState().intValue() == 1) //1: green-on; 2: green-off
              element.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
            else
              element.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
          }
        }
    }
  }
  protected CsmLedGroupBean getCsmLedBean()
  {
    CsmLedGroupBean bean = new CsmLedGroupBean(application.getSnmpProxy());
    try
    {
      bean.retrieve();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    return bean;
  }

  /**
   * update the CSM card in datasource.
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, BBS4000CardMibBean bean)
  {
    Card card = (Card)dataSource.getElementByUserObject("" + bean.getUtsEponModuleBoardPhyId());

    if(card.getTypeInfo().getName().equals("CSM"))
    {
      if(bean.getUtsEponModulePhyPresenceStat().intValue() == 1) // installed
      {
        //only refresh the led state.
        updateLed(dataSource, card);
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
      if(bean.getUtsEponModulePhyPresenceStat().intValue() == 1) // installed
      {
        card.setImage(ILogResourceFactory.getCardImage("CSM"));

        //add the port to card.
        assemblePort(dataSource, card, bean);
        assembleLed(dataSource, card, bean);
        updateLed(dataSource, card);
      }
    }
  }

  /**
   * update the fan in datasource.
   * @param dataSource
   * @param bean
   */

  public void update(UDataBox dataSource, ChassisConfTable bean)
  {
    if(bean.getUtsBBSChassisLeftFanTrayStat() != null)
    {
      dataSource.removeElement(dataSource.getElementByUserObject("FAN1_LED1"), true);
      dataSource.removeElement(dataSource.getElementByUserObject("FAN1_LED2"), true);
      helper.assembleLeftFan(dataSource, (Card)dataSource.getElementByUserObject("13"), bean);
    }

    if(bean.getUtsBBSChassisMiddleFanTrayStat() != null)
    {
      dataSource.removeElement(dataSource.getElementByUserObject("FAN2_LED1"), true);
      dataSource.removeElement(dataSource.getElementByUserObject("FAN2_LED2"), true);
      helper.assembleMiddleFan(dataSource, (Card)dataSource.getElementByUserObject("13"), bean);
    }

    if(bean.getUtsBBSChassisRightFanTrayStat() != null)
    {
      dataSource.removeElement(dataSource.getElementByUserObject("FAN3_LED1"), true);
      dataSource.removeElement(dataSource.getElementByUserObject("FAN3_LED2"), true);
      helper.assembleRightFan(dataSource, (Card)dataSource.getElementByUserObject("13"), bean);
    }
  }
}

class FanAssembleHelper
{
/*
      Fan Tray Status:
      	1: empty(1)
        2: installed-not-work(2)
        3: installed-and-work(3)
*/
  public void assembleLeftFan(UDataBox dataSource, Card card, ChassisConfTable bean)
  {
    if(bean.getUtsBBSChassisLeftFanTrayStat().intValue() == 3)
    {
      LED led = new LED();
      led.setUserObject("FAN1_LED1");
      led.setLabel("");
      led.setTypeInfo(new TypeInfo("LED"));
      led.setImage(ILogResourceFactory.getLedImage("FAN_BLUE"));
      dataSource.addElement(led);
      dataSource.setParent(card, led, -170, -75);

      led = new LED();
      led.setUserObject("FAN1_LED2");
      led.setLabel("");
      led.setTypeInfo(new TypeInfo("LED"));
      led.setImage(ILogResourceFactory.getLedImage("FAN_PURPLE"));
      dataSource.addElement(led);
      dataSource.setParent(card, led, -134, -75);
    }
  }

  public void assembleMiddleFan(UDataBox dataSource, Card card, ChassisConfTable bean)
  {
    if(bean.getUtsBBSChassisMiddleFanTrayStat().intValue() == 3)
    {
      LED led = new LED();
      led.setUserObject("FAN2_LED1");
      led.setLabel("");
      led.setTypeInfo(new TypeInfo("LED"));
      led.setImage(ILogResourceFactory.getLedImage("FAN_BLUE"));
      dataSource.addElement(led);
      dataSource.setParent(card, led, 50, -75);

      led = new LED();
      led.setUserObject("FAN2_LED2");
      led.setLabel("");
      led.setTypeInfo(new TypeInfo("LED"));
      led.setImage(ILogResourceFactory.getLedImage("FAN_PURPLE"));
      dataSource.addElement(led);
      dataSource.setParent(card, led, 85, -75);
    }
  }

  public void assembleRightFan(UDataBox dataSource, Card card, ChassisConfTable bean)
  {
    if(bean.getUtsBBSChassisRightFanTrayStat().intValue() == 3)
    {
      LED led = new LED();
      led.setUserObject("FAN3_LED1");
      led.setLabel("");
      led.setTypeInfo(new TypeInfo("LED"));
      led.setImage(ILogResourceFactory.getLedImage("FAN_BLUE"));
      dataSource.addElement(led);
      dataSource.setParent(card, led, 275, -75);

      led = new LED();
      led.setUserObject("FAN3_LED2");
      led.setLabel("");
      led.setTypeInfo(new TypeInfo("LED"));
      led.setImage(ILogResourceFactory.getLedImage("FAN_PURPLE"));
      dataSource.addElement(led);
      dataSource.setParent(card, led, 310, -75);
    }
  }
}