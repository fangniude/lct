package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.generator;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ILogResourceFactory;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.PonLedTableBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2PortTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.Element;
import com.winnertel.tgcl.model.LED;
import com.winnertel.tgcl.model.Port;
import com.winnertel.tgcl.model.Shelf;
import com.winnertel.tgcl.model.TypeInfo;

import java.util.List;

public class EPMCardGenerator
{
  ModuleType moduleType = new ModuleType();
  IApplication application = null;

  public EPMCardGenerator(IApplication application)
  {
    this.application = application;
  }

  public void generate(UDataBox dataSource, BBS4000CardMibBean bean)
  {
    Card card = new Card();
    card.setUserObject("" + bean.getUtsEponModuleBoardPhyId());
    card.setLabel(application.getGlobalStringMap().getString("Card") + " " + bean.getUtsEponModuleBoardPhyId() + " - " + moduleType.getModuleDisplayName(bean.getUtsEponModuleBoardType()));
    card.setTypeInfo(new TypeInfo("EPM"));

    dataSource.addElement(card);
    int phyId = bean.getUtsEponModuleBoardPhyId().intValue();
    Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");
    if(phyId < 7)
    {
      dataSource.setParent(shelf, card, 44*(phyId-1), 0);
    }
    else
    {
      dataSource.setParent(shelf, card, 372+44*(phyId-7), 0);
    }

    if(bean.getUtsEponModulePhyPresenceStat().intValue() == 1) //installed
    {
      int type = bean.getUtsEponModuleBoardType().intValue();
      if(type == 3)
      {
        card.setImage(ILogResourceFactory.getCardImage("EPM04A"));
      }
      else if(type == 4)
      {
        card.setImage(ILogResourceFactory.getCardImage("EPM04B"));
      }
      else if(type == 5)
      {
        card.setImage(ILogResourceFactory.getCardImage("EPM04A"));
      }
      else if(type == 11)
      {
          card.setImage(ILogResourceFactory.getCardImage("EPM04D"));
      }
      else
      {
        card.setImage(ILogResourceFactory.getCardImage("EPM04A"));
      }

      if(bean.getUtsEponModuleAdminState().intValue() != 2) //unlocked
      {
        card.setState(ILogResourceFactory.LOCKED);
      }

      assemblePort(dataSource, card);
      assembleLed(dataSource, card);
      updateLed(dataSource, card);
    }
    else
    {
      card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
    }

    if(bean.getUtsEponModuleAdminState() != null && bean.getUtsEponModuleAdminState() == 1)//lock
    {
      card.setState(ILogResourceFactory.LOCKED);
    }
    else
    {
      card.clearState(ILogResourceFactory.LOCKED);
    }
  }

  protected void assemblePort(UDataBox dataSource, Card card)
  {
    String cardName = card.getUserObject().toString();

    Dot3Olt2PortTable portBean = new Dot3Olt2PortTable(application.getSnmpProxy());

    for(int i = 1; i <= 4; i++)
    {
      Port port = new Port();
      port.setUserObject(cardName + "/" + i);
      port.setTypeInfo(new TypeInfo("EPM"));
      port.setImage(ILogResourceFactory.getPortImage("EPM"));

      dataSource.addElement(port);
      dataSource.setParent(card, port, 5, 130 + (i - 1) * 30);

      try
      {
        portBean.setUtsDot3OltModuleId(new Integer(cardName));
        portBean.setUtsDot3OltDeviceId(1);
        portBean.setUtsDot3OltPortId(i);

        portBean.retrieve();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

      if(portBean.getUtsDot3OltAdminStatus() != null && portBean.getUtsDot3OltAdminStatus().intValue() != 1) //down
      {
        port.setState(ILogResourceFactory.LOCKED);
      }

//      card.setItem(port, new IlpPoint(33, 212 - (i - 1) * 9));
    }
  }

  protected void assembleLed(UDataBox dataSource, Card card)
  {
    String cardName = card.getUserObject().toString();
    //POWER
    LED pwrLed = new LED();
    pwrLed.setUserObject(cardName + "_PWR");
    pwrLed.setLabel("PWR LED");
    dataSource.addElement(pwrLed);
    dataSource.setParent(card, pwrLed, 8, 49);
//    card.setItem(pwrLed, new IlpRelativePoint(33, 258));

    LED runLed = new LED();
    runLed.setUserObject(cardName + "_RUN");
    runLed.setLabel("RUN LED");
    dataSource.addElement(runLed);
    dataSource.setParent(card, runLed, 8, 56);
//    card.setItem(runLed, new IlpRelativePoint(33, 250));

    LED swapLed = new LED();
    swapLed.setUserObject(cardName + "_SWAP");
    swapLed.setLabel("SWAP LED");
    dataSource.addElement(swapLed);
    dataSource.setParent(card, swapLed, 8, 62);
//    card.setItem(swapLed, new IlpRelativePoint(33, 242));

    LED almLed = new LED();
    almLed.setUserObject(cardName + "_ALM");
    almLed.setLabel("ALM LED");
    dataSource.addElement(almLed);
    dataSource.setParent(card, almLed, 8, 70);
//    card.setItem(almLed, new IlpRelativePoint(33, 234));

    //OPER and FAULT LED.
    for(int i = 1; i <= 4; i++)
    {
      //Fault LEDs
      LED faultLed = new LED();
      faultLed.setUserObject(cardName + "_FAULT" + i);
      faultLed.setLabel("FAULT LED");
      dataSource.addElement(faultLed);
      dataSource.setParent(card, faultLed, 8, 93 + (i - 1) * 9);

      //Oper LEDs
      LED operLed = new LED();
      operLed.setUserObject(cardName + "_OPER" + i);
      operLed.setLabel("OPER LED");
      dataSource.addElement(operLed);
      dataSource.setParent(card, operLed, 15, 93 + (i - 1) * 9);
    }
  }

  protected void updatePort(Port port, Dot3Olt2PortTable bean)
  {
    if(bean.getUtsDot3OltAdminStatus() != null && bean.getUtsDot3OltAdminStatus().intValue() != 1) //down
    {
      port.setState(ILogResourceFactory.LOCKED);
    }
    else
    {
      port.clearState(ILogResourceFactory.LOCKED);
    }
  }

  protected void updateLed(UDataBox dataSource, Card card)
  {
    try
    {
      int cardId = Integer.parseInt((String)card.getUserObject());
      PonLedTableBean bean = new PonLedTableBean(application.getSnmpProxy());
      bean.setUtsLedPonSlotLedDispSlotId(new Integer(cardId));
      bean.retrieve();

      List children = dataSource.getChildren(card);

      for(int i = 0; i < children.size(); i++)
      {
        Element item = (Element)children.get(i);
        String id = (String)item.getUserObject();

        if(id.indexOf("PWR") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPowLedStat() != null && bean.getUtsLedPonSlotLedDispPowLedStat().intValue() == 1) //1: green-on; 2: green-off
            item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("RUN") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispRunLedStat() != null && bean.getUtsLedPonSlotLedDispRunLedStat().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
            item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("SWAP") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispSwapLedStat() != null && bean.getUtsLedPonSlotLedDispSwapLedStat().intValue() == 1) //1: yellow-on; 2: yellow-off; 3: flashing
            item.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("ALM") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispFaultLedStat() != null && bean.getUtsLedPonSlotLedDispFaultLedStat().intValue() == 1) //1: red-on; 2: red-off
            item.setImage(ILogResourceFactory.getLedImage("LED_RED"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("FAULT1") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort1FaultLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort1FaultLedStat().intValue() == 1) //1: red-on; 2: red-off
            item.setImage(ILogResourceFactory.getLedImage("LED_RED"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("FAULT2") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort2FaultLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort2FaultLedStat().intValue() == 1) //1: red-on; 2: red-off
            item.setImage(ILogResourceFactory.getLedImage("LED_RED"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("FAULT3") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort3FaultLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort3FaultLedStat().intValue() == 1) //1: red-on; 2: red-off
            item.setImage(ILogResourceFactory.getLedImage("LED_RED"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("FAULT4") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort4FaultLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort4FaultLedStat().intValue() == 1) //1: red-on; 2: red-off
            item.setImage(ILogResourceFactory.getLedImage("LED_RED"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("OPER1") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort1OprLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort1OprLedStat().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
            item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("OPER2") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort2OprLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort2OprLedStat().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
            item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("OPER3") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort3OprLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort3OprLedStat().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
            item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }

        if(id.indexOf("OPER4") != -1)
        {
          if(bean.getUtsLedPonSlotLedDispPonPort4OprLedStat() != null && bean.getUtsLedPonSlotLedDispPonPort4OprLedStat().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
            item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
          else
            item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
        }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

  }

//  protected PonLedTableBean getPonLedBean()
//  {
//    PonLedTableBean bean = new PonLedTableBean(application.getSnmpProxy());
//
//  }
  /**
   * update the EPM card in datasource.
   *
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, BBS4000CardMibBean bean)
  {
    Card card = (Card)dataSource.getElementByUserObject("" + bean.getUtsEponModuleBoardPhyId());

    if(card.getTypeInfo().getName().startsWith("EPM"))
    {
      if(bean.getUtsEponModulePhyPresenceStat().intValue() == 1) // installed
      {
        int type = bean.getUtsEponModuleBoardType().intValue();
        if(type == 3)
        {
          card.setImage(ILogResourceFactory.getCardImage("EPM04A"));
        }
        else if(type == 4)
        {
          card.setImage(ILogResourceFactory.getCardImage("EPM04A"));
        }
        else if(type == 5)
        {
          card.setImage(ILogResourceFactory.getCardImage("EPM04A"));
        }
        else
        {
          card.setImage(ILogResourceFactory.getCardImage("EPM04A"));
        }

        //update the state
        if(bean.getUtsEponModuleAdminState().intValue() != 2) //locked
        {
          card.setState(ILogResourceFactory.LOCKED);
        }
        else
        {
          card.clearState(ILogResourceFactory.LOCKED);
        }

        //update the port on card.
        Dot3Olt2PortTable portBean = new Dot3Olt2PortTable(application.getSnmpProxy());
        for(int i = 1; i <= 4; i++)
        {
          try
          {
            String portName = bean.getUtsEponModuleBoardPhyId() + "/" + i;
            portBean.setUtsDot3OltModuleId(bean.getUtsEponModuleBoardPhyId());
            portBean.setUtsDot3OltDeviceId(1);
            portBean.setUtsDot3OltPortId(i);

            portBean.retrieve();

            Port port = (Port)dataSource.getElementByUserObject(portName);
            updatePort(port, portBean);
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }
        }

        //update the led state.
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
        int type = bean.getUtsEponModuleBoardType().intValue();
        if(type == 6)
        {
          card.setImage(ILogResourceFactory.getCardImage("GEM04A"));
        }
        else
        {
          card.setImage(ILogResourceFactory.getCardImage("GEM04A"));
        }

        //add the port to card.
        assemblePort(dataSource, card);
      }
    }

    if(bean.getUtsEponModuleAdminState() != null && bean.getUtsEponModuleAdminState() == 1)//lock
    {
      card.setState(ILogResourceFactory.LOCKED);
    }
    else
    {
      card.clearState(ILogResourceFactory.LOCKED);
    }
  }

  /**
   * update the OLT port on EPM card in datasource.
   *
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, Dot3Olt2PortTable bean)
  {
    String portName = ConfigUtility.formatIfIndex("" + bean.getIfIndex());
    Port port = (Port)dataSource.getElementByUserObject(portName);

    updatePort(port, bean);

    Card card = (Card)dataSource.getElementByUserObject(portName.substring(0, portName.indexOf("/")));
    updateLed(dataSource, card);
  }
}
