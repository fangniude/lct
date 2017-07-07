package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.generator;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ILogResourceFactory;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.ChassisConfTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.InterfaceTableMBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r100.OltPonLinkCfgTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Olt2PortTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.Element;
import com.winnertel.tgcl.model.LED;
import com.winnertel.tgcl.model.Shelf;
import com.winnertel.tgcl.model.TypeInfo;

import java.util.List;
import java.util.Vector;

public class ShelfViewGenerator
{

  protected IApplication application = null;
  protected BaseModuleType moduleType = new ModuleType();

  private int shelfId = 1;
  CSMCardGenerator csmGenerator = null;
  GEMCardGenerator gemGenerator = null;
  XGMCardGenerator xgmGenerator = null;
  EPMCardGenerator epmGenerator = null;
  GPMCardGenerator gpmGenerator = null;
  PwrAssembleHelper helper = null;

  public ShelfViewGenerator(IApplication application)
  {
    this.application = application;
    csmGenerator = new CSMCardGenerator(application);
    gemGenerator = new GEMCardGenerator(application);
    xgmGenerator = new XGMCardGenerator(application);
    epmGenerator = new EPMCardGenerator(application);
    gpmGenerator = new GPMCardGenerator(application);
    helper = new PwrAssembleHelper();
  }

  public int getShelfId()
  {
    return shelfId;
  }

  public void setShelfId(int shelfId)
  {
    this.shelfId = shelfId;
  }

  public void assemble(UDataBox dataSource)
  {
    Shelf shelf = generateShelf();
    dataSource.addElement(shelf);

    //
    assembleModule(dataSource, shelf);
  }

  protected Shelf generateShelf()
  {
//    Shelf shelf = new Shelf("SHELF1");
    Shelf shelf = new Shelf();
    shelf.setUserObject("SHELF1");
    shelf.setLabel("");
    shelf.setSize(692, 300);
    shelf.setLocation(43, 115);
    //
//    int[] xSlotWidths = {44, 44, 44, 44, 44, 44, 54, 54, 44, 44, 44, 44, 44, 44, 56};
//    int[] ySlotWidths = {156, 156};
//    shelf.setSlotSizes(xSlotWidths, ySlotWidths);
//    shelf.setPosition(new IlpPoint(43, 108));
    return shelf;
  }

  protected void assembleModule(UDataBox dataSource, Shelf shelf)
  {
    Vector module = getModuleTable();

    if(module == null)
    {
//      MessageDialog.showQueryFailedDialog(application);
      return;
    }

    for(int j = 0; j < module.size(); j++)
    {
      if(j > 13)
      {
        break;
      }

      BBS4000CardMibBean cardBean = (BBS4000CardMibBean)module.get(j);
      if(moduleType.isCSMModule(cardBean.getUtsEponModuleBoardType()))
      {
        csmGenerator.generate(dataSource, cardBean);
      }
      else if(moduleType.isEPMModule(cardBean.getUtsEponModuleBoardType()))
      {
        epmGenerator.generate(dataSource, cardBean);
      }
      else if(moduleType.isGPMModule(cardBean.getUtsEponModuleBoardType()))
      {
        gpmGenerator.generate(dataSource, cardBean);
      }
      else if(moduleType.isGEMModule(cardBean.getUtsEponModuleBoardType()))
      {
        gemGenerator.generate(dataSource, cardBean);
      }
      else if(moduleType.isXGMModule(cardBean.getUtsEponModuleBoardType()))
      {
        xgmGenerator.generate(dataSource, cardBean);
      }
      else
      {
        int phyId = cardBean.getUtsEponModuleBoardPhyId();
        Card card = new Card();

        card.setSize(44, 312);

        dataSource.addElement(card);
        if(phyId < 7)
        {
          card.setLabel(application.getGlobalStringMap().getString("Card") + " " + phyId);
          card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
          dataSource.setParent(shelf, card, 44*(phyId-1), 0);
        }
        else if(phyId == 13)
        {
          card.setLabel(application.getGlobalStringMap().getString("Card") + " A");
          card.setImage(ILogResourceFactory.getCardImage("CSM_EMPTY"));
          dataSource.setParent(shelf, card, 264, 0);
        }
        else if(phyId == 14)
        {
          card.setLabel(application.getGlobalStringMap().getString("Card") + " B");
          card.setImage(ILogResourceFactory.getCardImage("CSM_EMPTY"));
          dataSource.setParent(shelf, card, 318, 0);
        }
        else
        {
          card.setLabel(application.getGlobalStringMap().getString("Card") + " " + phyId);
          card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
          dataSource.setParent(shelf, card, 372+44*(phyId-7), 0);
        }

      }
    }

    ChassisConfTable chassisConfBean = getChassisConfMibBean();
    helper.assembleHighPwr(dataSource, shelf, chassisConfBean);
    helper.assembleLowPwr(dataSource, shelf, chassisConfBean);
  }

  protected Vector getModuleTable()
  {
    BBS4000CardMibBean bean = new BBS4000CardMibBean(application.getSnmpProxy());
    Vector module = null;

    try
    {
      module = bean.retrieveAll();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();  //To change body of catch statement use Options | File Templates.
    }

    return module;
  }

  protected ChassisConfTable getChassisConfMibBean()
  {
    ChassisConfTable bean = new ChassisConfTable(application.getSnmpProxy());
    Vector module = null;
    try
    {
      module = bean.retrieveAll();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      MessageDialog.showQueryFailedDialog(application);
    }

    return module != null ? (ChassisConfTable)module.get(0) : null;
  }

  public void update(UDataBox dataSource, SnmpMibBean bean)
  {
    if(bean instanceof BBS4000CardMibBean) //update the module card.
    {
      int type = ((BBS4000CardMibBean)bean).getUtsEponModuleBoardType();
      if(moduleType.isCSMModule(type))
      {
        csmGenerator.update(dataSource, (BBS4000CardMibBean)bean);
      }
      else if(moduleType.isEPMModule(type))
      {
        epmGenerator.update(dataSource, (BBS4000CardMibBean)bean);
      }
      else if(moduleType.isGPMModule(type))
      {
        gpmGenerator.update(dataSource, (BBS4000CardMibBean)bean);
      }
      else if(moduleType.isGEMModule(type))
      {
        gemGenerator.update(dataSource, (BBS4000CardMibBean)bean);
      }
      else if(moduleType.isXGMModule(type))
      {
        xgmGenerator.update(dataSource, (BBS4000CardMibBean)bean);
      }
      else
      {
        Card card = (Card)dataSource.getElementByUserObject("" + ((BBS4000CardMibBean)bean).getUtsEponModuleBoardPhyId());
        if(card != null)
        {
          List children = dataSource.getChildren(card);
          for(int i = 0; i < children.size(); i++)
          {
            dataSource.removeElement((Element)children.get(i), true);
          }

          card.setTypeInfo(new TypeInfo("EMPTY"));
          card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
        }
      }
    }
    else if(bean instanceof InterfaceTableMBean)  //update the GSM port.
    {
      gemGenerator.update(dataSource, (InterfaceTableMBean)bean);
    }
    else if(bean instanceof Dot3Olt2PortTable)  //update the EPM port.
    {
      epmGenerator.update(dataSource, (Dot3Olt2PortTable)bean);
    }
    else if(bean instanceof ChassisConfTable) //update the FAN and Power.
    {
      helper.update(dataSource, (ChassisConfTable)bean);
      csmGenerator.update(dataSource, (ChassisConfTable)bean);
    }
    else if(bean instanceof OltPonLinkCfgTable) {
      gpmGenerator.update(dataSource, (OltPonLinkCfgTable)bean);
    }
  }
}

class PwrAssembleHelper
{
/*
      power module Status:
      	1: empty(1)
        2: installed-not-work(2)
        3: installed-and-work(3)
*/

  public void assembleHighPwr(UDataBox dataSource, Shelf shelf, ChassisConfTable bean)
  {
    Card highPower = new Card();
    highPower.setUserObject("HIGH_PWR");
    highPower.setLabel("PWR");
    highPower.setTypeInfo(new TypeInfo("PWR"));
    dataSource.addElement(highPower);
    dataSource.setParent(shelf, highPower, 636, 0);

    if(bean.getUtsBBSChassisPwrHighSlot() == 1) //empty
    {
      highPower.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));
    }
    else
    {
      highPower.setImage(ILogResourceFactory.getCardImage("PWR"));

      LED runLed = new LED();
      runLed.setUserObject("HIGH_PWR_RUN");
      runLed.setLabel("");
      runLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));

      dataSource.addElement(runLed);
      dataSource.setParent(highPower, runLed, 15, 30);

      LED almLed = new LED();
      almLed.setUserObject("HIGH_PWR_ALM");
      almLed.setLabel("");
      
      if(bean.getUtsBBSChassisPwrType() == 2 && bean.getUtsBBSChassisPwrLowSlot() == 2)
    	  almLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
      else 
    	  almLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));

      dataSource.addElement(almLed);
      dataSource.setParent(highPower, almLed, 23, 30);
    }
  }

/*
      power module Status:
      	1: empty(1)
        2: installed-not-work(2)
        3: installed-and-work(3)
*/
  public void assembleLowPwr(UDataBox dataSource, Shelf shelf, ChassisConfTable bean)
  {
    Card lowPower = new Card();
    lowPower.setUserObject("LOW_PWR");
    lowPower.setLabel("PWR");
    lowPower.setTypeInfo(new TypeInfo("PWR"));
    dataSource.addElement(lowPower);
    dataSource.setParent(shelf, lowPower, 636, 150);

    if(bean.getUtsBBSChassisPwrLowSlot() == 1) //empty
    {
      lowPower.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));
    }
    else
    {
      lowPower.setImage(ILogResourceFactory.getCardImage("PWR"));

      LED runLed = new LED();
      runLed.setUserObject("LOW_PWR_RUN");
      runLed.setLabel("");
      runLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));

      dataSource.addElement(runLed);
      dataSource.setParent(lowPower, runLed, 15, 30);

      LED almLed = new LED();
      almLed.setUserObject("LOW_PWR_ALM");
      almLed.setLabel("");
      if(bean.getUtsBBSChassisPwrType() == 2 && bean.getUtsBBSChassisPwrLowSlot() == 2)
    	  almLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
      else 
    	  almLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      
      dataSource.addElement(almLed);
      dataSource.setParent(lowPower, almLed, 23, 30);
    }
  }

  public void update(UDataBox dataSource, ChassisConfTable bean)
  {
    //
    Card highPwr = (Card)dataSource.getElementByUserObject("HIGH_PWR");
    if(highPwr == null)
    {
      Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");
      assembleHighPwr(dataSource, shelf, bean);
    }
    else
    {
      if(highPwr.getTypeInfo().getName().equals("PWR"))
      {
        //the card is removed.
        if(bean.getUtsBBSChassisPwrHighSlot() == 1) //empty
        {
          highPwr.setTypeInfo(new TypeInfo("PWR"));
          highPwr.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));

          //The card becomes empty card, so remove all the child elements from it.
          List children = dataSource.getChildren(highPwr);
          for(int i = 0; i < children.size(); i++)
          {
            dataSource.removeElement((Element)children.get(i), true);
          }
        }
      }
      else
      {
        if(bean.getUtsBBSChassisPwrHighSlot() != 1)
        {
          //remove the card the create it again.
          dataSource.removeElement(highPwr, true);

          Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");
          assembleHighPwr(dataSource, shelf, bean);
        }
      }
    }

    Card lowPwr = (Card)dataSource.getElementByUserObject("LOW_PWR");
    if(lowPwr == null)
    {
      Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");
      assembleLowPwr(dataSource, shelf, bean);
    }
    else
    {
      if(lowPwr.getTypeInfo().getName().equals("PWR"))
      {
        if(bean.getUtsBBSChassisPwrLowSlot() == 1) //empty
        {
          lowPwr.setTypeInfo(new TypeInfo("PWR"));
          lowPwr.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));

          //The card becomes empty card, so remove all the child elements from it.
          List children = dataSource.getChildren(lowPwr);
          for(int i = 0; i < children.size(); i++)
          {
            dataSource.removeElement((Element)children.get(i), true);
          }
        }
      }
      else
      {
        if(bean.getUtsBBSChassisPwrLowSlot() != 1)
        {
          //remove the card the create it again.
          dataSource.removeElement(highPwr, true);

          Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");
          assembleLowPwr(dataSource, shelf, bean);
        }
      }
    }
  }

}