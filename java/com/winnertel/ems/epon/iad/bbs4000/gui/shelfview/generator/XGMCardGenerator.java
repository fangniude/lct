package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.generator;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ILogResourceFactory;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.GeLedTableBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.InterfaceTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.Element;
import com.winnertel.tgcl.model.LED;
import com.winnertel.tgcl.model.Port;
import com.winnertel.tgcl.model.Shelf;
import com.winnertel.tgcl.model.TypeInfo;

import java.util.List;

public class XGMCardGenerator {
  IApplication application = null;
  ModuleType moduleType = new ModuleType();
  static final int PORT_COUNT = 1;
  
  public XGMCardGenerator(IApplication application)
  {
    this.application = application;
  }

  public void generate(UDataBox dataSource, BBS4000CardMibBean bean)
  {
    //4 - GEM Card.
//    if(bean.getUtsEponModuleBoardType().intValue() != 4)
//      throw new IllegalArgumentException("Unsupport Card Type: " + bean.getUtsEponModuleBoardType());

    Card card = new Card();
    card.setUserObject("" + bean.getUtsEponModuleBoardPhyId());
    card.setLabel(application.getGlobalStringMap().getString("Card") + " " + bean.getUtsEponModuleBoardPhyId() + " - " + moduleType.getModuleDisplayName(bean.getUtsEponModuleBoardType()));
    card.setTypeInfo(new TypeInfo("XGM"));
    card.setSize(144, 312);

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
      if(type == 8)
      {
        card.setImage(ILogResourceFactory.getCardImage("XGM01A"));
      }
      else
      {
        card.setImage(ILogResourceFactory.getCardImage("XGM01A"));
      }

      if(bean.getUtsEponModuleAdminState().intValue() != 2) //locked
      {
        card.setState(ILogResourceFactory.LOCKED);
      }
      else
      {
        card.clearState(ILogResourceFactory.LOCKED);
      }

      assemblePort(dataSource, card, bean);
      assembleLed(dataSource, card, bean);
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

  protected void assemblePort(UDataBox dataSource, Card card, BBS4000CardMibBean bean)
  {
    String cardName = card.getUserObject().toString();

    InterfaceTableMBean portBean = new InterfaceTableMBean(application.getSnmpProxy());

    for(int i = 1; i <= PORT_COUNT; i++)
    {
      Port port = new Port();
      port.setUserObject(cardName + "/" + i);
      port.setTypeInfo(new TypeInfo("GEM"));
      port.setImage(ILogResourceFactory.getPortImage("GEM"));
      dataSource.addElement(port);
      dataSource.setParent(card, port, 2, 130+(i-1)*30);

      try
      {
        portBean.setIfIndex(new Integer(ConfigUtility.generateIfIndex(card.getUserObject() + "/" + i)));
        portBean.retrieve();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

      if(portBean.getIfAdminStatus() != null && portBean.getIfAdminStatus().intValue() != 1) //up
      {
        port.setState(ILogResourceFactory.LOCKED);
      }
      else
      {
        port.clearState(ILogResourceFactory.LOCKED);
      }

//      card.setItem(port, new IlpPoint(33, 212-(i-1)*9));
    }
  }

  protected void assembleLed(UDataBox dataSource, Card card, BBS4000CardMibBean bean)
  {
    String cardName = card.getUserObject().toString();
    //POWER
    LED pwrLed = new LED();
    pwrLed.setUserObject(cardName + "_PWR");
    pwrLed.setLabel("PWR LED");
    dataSource.addElement(pwrLed);
    dataSource.setParent(card, pwrLed, 8, 49);
//    card.setItem(pwrLed, new IlpPoint(33, 258));

    LED runLed = new LED();
    runLed.setUserObject(cardName + "_RUN");
    runLed.setLabel("RUN LED");
    dataSource.addElement(runLed);
    dataSource.setParent(card, runLed, 8, 56);
//    card.setItem(runLed, new IlvPoint(33, 250));

    LED swapLed = new LED();
    swapLed.setUserObject(cardName + "_SWAP");
    swapLed.setLabel("SWAP LED");
    dataSource.addElement(swapLed);
    dataSource.setParent(card, swapLed, 8, 62);
//    card.setItem(swapLed, new IlvPoint(33, 242));

    LED almLed = new LED();
    almLed.setUserObject(cardName + "_ALM");
    almLed.setLabel("ALM LED");
    dataSource.addElement(almLed);
    dataSource.setParent(card, almLed, 8, 70);
//    card.setItem(almLed, new IlvPoint(33, 234));

    for(int i = 1; i <= PORT_COUNT; i++)
    {
      LED lnkLed = new LED();
      lnkLed.setUserObject(cardName + "_LNK" + i);
      lnkLed.setLabel("LNK LED");
      dataSource.addElement(lnkLed);
      dataSource.setParent(card, lnkLed, 8, 93+(i-1)*9);

//      card.setItem(lnkLed, new IlvPoint(33, 212-(i-1)*9));
    }
  }

  protected void updatePort(Port port, InterfaceTableMBean bean)
  {
    if(bean.getIfAdminStatus() != null && bean.getIfAdminStatus().intValue() != 1) //up
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
      GeLedTableBean bean = new GeLedTableBean(application.getSnmpProxy());
      bean.setUtsLedGEPortSlotLedDispSlotId(new Integer(cardId));
      bean.retrieve();

      updateLed(dataSource, card, bean);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  protected void updateLed(UDataBox dataSource, Card card, GeLedTableBean bean)
  {
    List children = dataSource.getChildren(card);
    for(int i = 0; i < children.size(); i++)
    {
      Element item = (Element)children.get(i);
      String id = (String)item.getUserObject();

      if(id.indexOf("PWR") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispPowLedStat() != null && bean.getUtsLedGEPortSlotLedDispPowLedStat().intValue() == 1) //1: green-on; 2: green-off
          item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }

      if(id.indexOf("RUN") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispRunLedStat() != null && bean.getUtsLedGEPortSlotLedDispRunLedStat().intValue() == 1) //1: green-on; 2: green-off; 3: flashing
          item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }

      if(id.indexOf("SWAP") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispSwapLedStat() != null && bean.getUtsLedGEPortSlotLedDispSwapLedStat().intValue() == 1) //1: yellow-on; 2: yellow-off; 3: flashing
          item.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }

      if(id.indexOf("ALM") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispFaultLedStat() != null && bean.getUtsLedGEPortSlotLedDispFaultLedStat().intValue() == 1) //1: red-on; 2: red-off
          item.setImage(ILogResourceFactory.getLedImage("LED_RED"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }

      if(id.indexOf("LNK1") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispPort1LinkLedStat() != null && bean.getUtsLedGEPortSlotLedDispPort1LinkLedStat().intValue() == 1) //1: green-on; 2: green-off
          item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }

      if(id.indexOf("LNK2") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispPort2LinkLedStat() != null && bean.getUtsLedGEPortSlotLedDispPort2LinkLedStat().intValue() == 1) //1: green-on; 2: green-off
          item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }

      if(id.indexOf("LNK3") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispPort3LinkLedStat() != null && bean.getUtsLedGEPortSlotLedDispPort3LinkLedStat().intValue() == 1) //1: green-on; 2: green-off
          item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }

      if(id.indexOf("LNK4") != -1)
      {
        if(bean.getUtsLedGEPortSlotLedDispPort4LinkLedStat() != null && bean.getUtsLedGEPortSlotLedDispPort4LinkLedStat().intValue() == 1) //1: green-on; 2: green-off
          item.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
        else
          item.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }
    }
  }
  /**
   * update the GEM card in datasource.
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, BBS4000CardMibBean bean)
  {
    Card card = (Card)dataSource.getElementByUserObject("" + bean.getUtsEponModuleBoardPhyId());

    if(card.getTypeInfo().getName().startsWith("XGM"))
    {
      if(bean.getUtsEponModulePhyPresenceStat().intValue() == 1) // installed
      {
        int type = bean.getUtsEponModuleBoardType().intValue();
        if(type == 6)
        {
          card.setImage(ILogResourceFactory.getCardImage("XGM01A"));
        }
        else
        {
          card.setImage(ILogResourceFactory.getCardImage("XGM01A"));
        }

        //update the state
        if(bean.getUtsEponModuleAdminState().intValue() != 2) //unlocked
        {
          card.setState(ILogResourceFactory.LOCKED);
        }
        else
        {
          card.clearState(ILogResourceFactory.LOCKED);
        }

        //update the port on card.
        InterfaceTableMBean portBean = new InterfaceTableMBean(application.getSnmpProxy());
        for(int i = 1; i <= PORT_COUNT; i++)
        {
          try
          {
            String portName = bean.getUtsEponModuleBoardPhyId() + "/" + i;
            portBean.setIfIndex(new Integer(ConfigUtility.generateIfIndex(portName)));
            portBean.retrieve();

            Port port = (Port)dataSource.getElementByUserObject(portName);
            updatePort(port, portBean);
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }
        }

        //update led state
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
          card.setImage(ILogResourceFactory.getCardImage("XGM01A"));
        }
        else
        {
          card.setImage(ILogResourceFactory.getCardImage("XGM01A"));
        }

        //add the port to card.
        assemblePort(dataSource, card, bean);
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
   * update the GE port on GEM card in datasource.
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, InterfaceTableMBean bean)
  {
    String portName = ConfigUtility.formatIfIndex("" + bean.getIfIndex());
    Port port = (Port)dataSource.getElementByUserObject(portName);

    updatePort(port, bean);

    Card card = (Card)dataSource.getElementByUserObject(portName.substring(0, portName.indexOf("/")));
    updateLed(dataSource, card);
  }
}
