package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.generator;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ILogResourceFactory;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.ChassisConfGroup;
import com.winnertel.ems.epon.iad.bbs1000.mib.InterfaceTableMBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Olt2PortTable;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.model.Shelf;
import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.TypeInfo;
import com.winnertel.tgcl.model.Element;

import java.util.Vector;
import java.util.List;

public class ShelfViewGenerator
{
  protected IApplication application = null;
  protected ModuleType moduleType = new ModuleType();

  private int shelfId = 1;
  GSMCardGenerator gsmGenerator = null;
  LTMCardGenerator ltmGenerator = null;
  PwrAssembleHelper helper = null;

  public ShelfViewGenerator(IApplication application)
  {
    this.application = application;
    gsmGenerator = new GSMCardGenerator(application);
    ltmGenerator = new LTMCardGenerator(application);
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
    assembleModule(dataSource, shelf);
  }

  protected Shelf generateShelf()
  {
    Shelf shelf = new Shelf();
    shelf.setUserObject("SHELF1");
    shelf.setLabel("");
    
    shelf.setSize(648, 64);
//    shelf.setLocation(40, 85);
    shelf.setLocation(42, 6);
    //
//    int[] xSlotWidths = {192, 228, 228};
//    int[] ySlotWidths = {32, 32};
//    shelf.setSlotSizes(xSlotWidths, ySlotWidths);
//    shelf.setPosition(new IlpPoint(45, 82));
    return shelf;
  }

  protected void assembleModule(UDataBox dataSource, Shelf shelf)
  {
    Vector module = getModuleTable();

    if(module == null)
    {
//      MessageDialog.showQueryFailedDialog(fApplication);
      return;
    }

    for(int j = 0; j < module.size(); j++)
    {
      BBS1000CardMibBean cardBean = (BBS1000CardMibBean)module.get(j);
      if(moduleType.isLTMModule(cardBean.getUtsEponModuleBoardType().intValue()))
      {
        ltmGenerator.generate(dataSource, cardBean);
      }
      else if(moduleType.isGSMModule(cardBean.getUtsEponModuleBoardType().intValue()))
      {
        gsmGenerator.generate(dataSource, cardBean);
      }
      else
      {
        int index = cardBean.getUtsEponModuleBoardPhyId().intValue();
        Card card = new Card();
        card.setUserObject("" + index);
        card.setLabel(application.getGlobalStringMap().getString("Card") + " " + index);
        card.setTypeInfo(new TypeInfo("Unknown"));
        card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
        dataSource.addElement(card);
        int phyId = cardBean.getUtsEponModuleBoardPhyId().intValue();
        if(phyId ==1)
        {
          dataSource.setParent(shelf, card, 420, 32);
        }
        else if(phyId == 2)
        {
          dataSource.setParent(shelf, card, 192, 32);
        }
        else if(phyId == 3)
        {
          dataSource.setParent(shelf, card, 192, 0);
        }
      }
    }

    ChassisConfGroup chassisConfBean = getChassisConfMibBean();
    helper.assembleHighPwr(dataSource, shelf, chassisConfBean);
    helper.assembleLowPwr(dataSource, shelf, chassisConfBean);
  }

  protected Vector getModuleTable()
  {
    BBS1000CardMibBean bean = new BBS1000CardMibBean(application.getSnmpProxy());
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

  protected ChassisConfGroup getChassisConfMibBean()
  {
    ChassisConfGroup bean = new ChassisConfGroup(application.getSnmpProxy());
    try
    {
      bean.retrieve();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
      MessageDialog.showQueryFailedDialog(application);
    }

    return bean;
  }

  public void update(UDataBox dataSource, SnmpMibBean bean)
  {
    if(bean instanceof BBS1000CardMibBean) //update the module card.
    {
      int type = ((BBS1000CardMibBean)bean).getUtsEponModuleBoardType().intValue();
      if(moduleType.isLTMModule(type))
      {
        ltmGenerator.update(dataSource, (BBS1000CardMibBean)bean);
      }
      else if(moduleType.isGSMModule(type))
      {
        gsmGenerator.update(dataSource, (BBS1000CardMibBean)bean);
      }
      else
      {
        Card card = (Card)dataSource.getElementByUserObject("" + ((BBS1000CardMibBean)bean).getUtsEponModuleBoardPhyId());
        if(card != null)
        {
          card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
          List children = dataSource.getChildren(card);
          for(int i = 0; i < children.size(); i++)
          {
            dataSource.removeElement((Element)children.get(i), true);
          }
        }
      }
    }
    else if(bean instanceof InterfaceTableMBean)  //update the GSM port.
    {
      gsmGenerator.update(dataSource, (InterfaceTableMBean)bean);
    }
    else if(bean instanceof Dot3Olt2PortTable)  //update the EPM port.
    {
      ltmGenerator.update(dataSource, (Dot3Olt2PortTable)bean);
    }
    else if(bean instanceof ChassisConfGroup) //update the Power.
    {
      helper.update(dataSource, (ChassisConfGroup)bean);
      gsmGenerator.update(dataSource, (ChassisConfGroup)bean);
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

  public void assembleHighPwr(UDataBox dataSource, Shelf shelf, ChassisConfGroup bean)
  {
    if(bean.getUtsBBSChassisPwrType() == 2) //DC
    {
      Card highPower = new Card();
      highPower.setUserObject("HIGH_PWR");
      highPower.setTypeInfo(new TypeInfo("PWR"));

      if(bean.getUtsBBSChassisPwrHighSlot().intValue() == 1) //empty
      {
        highPower.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));
      }
      else
      {
        highPower.setImage(ILogResourceFactory.getCardImage("PWR"));
      }

      dataSource.addElement(highPower);
      dataSource.setParent(shelf, highPower, 0, 0);
    }
  }

/*
      power module Status:
      	1: empty(1)
        2: installed-not-work(2)
        3: installed-and-work(3)
*/
  public void assembleLowPwr(UDataBox dataSource, Shelf shelf, ChassisConfGroup bean)
  {
    Card lowPower = new Card();
    lowPower.setUserObject("LOW_PWR");

    if(bean.getUtsBBSChassisPwrType() == 2) //DC
    {
      lowPower.setTypeInfo(new TypeInfo("PWR"));

      if(bean.getUtsBBSChassisPwrLowSlot().intValue() == 1) //empty
      {
        lowPower.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));
      }
      else
      {
        lowPower.setImage(ILogResourceFactory.getCardImage("PWR"));
      }

      dataSource.addElement(lowPower);
      dataSource.setParent(shelf, lowPower, 0, 32);
    }
    else //AC
    {
      lowPower.setImage(ILogResourceFactory.getCardImage("PWR_AC"));

      dataSource.addElement(lowPower);
      dataSource.setParent(shelf, lowPower, 0, 0);
    }
  }

  public void update(UDataBox dataSource, ChassisConfGroup bean)
  {
    //
    Card highPwr = (Card)dataSource.getElementByUserObject("HIGH_PWR");
    if(highPwr == null)
    {
      assembleHighPwr(dataSource, (Shelf)dataSource.getElementByUserObject("SHELF1"), bean);
    }
    else
    {
      if(bean.getUtsBBSChassisPwrType() == 2) //DC
      {
        if(highPwr.getTypeInfo().getName().equals("PWR"))
        {
          //the card is removed.
          if(bean.getUtsBBSChassisPwrHighSlot().intValue() == 1) //empty
          {
            highPwr.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));
          }
        }
        else
        {
          if(bean.getUtsBBSChassisPwrHighSlot().intValue() != 1)
          {
            highPwr.setImage(ILogResourceFactory.getCardImage("PWR"));
          }
        }
      }
      else //High pwr card doesn't exist in AC mode.
      {
        dataSource.removeElement(highPwr, true);
      }
    }

    Card lowPwr = (Card)dataSource.getElementByUserObject("LOW_PWR");
    if(lowPwr == null)
    {
      assembleLowPwr(dataSource, (Shelf)dataSource.getElementByUserObject("SHELF1"), bean);
    }
    else
    {
      if(lowPwr.getTypeInfo().getName().equals("PWR"))
      {
        if(bean.getUtsBBSChassisPwrType() == 1) //AC
        {
          lowPwr.setImage(ILogResourceFactory.getCardImage("PWR_AC"));
        }
        else if(bean.getUtsBBSChassisPwrType() == 2 && bean.getUtsBBSChassisPwrLowSlot() == 1) //DC && empty, it means that only remove the pwr card in DC mode.
        {
          lowPwr.setImage(ILogResourceFactory.getCardImage("PWR_EMPTY"));
        }
      }
      else
      {
        if(bean.getUtsBBSChassisPwrType() == 1) //AC
        {
          lowPwr.setImage(ILogResourceFactory.getCardImage("PWR_AC"));
        }
        else if(bean.getUtsBBSChassisPwrType() == 2 && bean.getUtsBBSChassisPwrLowSlot().intValue() != 1)
        {
          lowPwr.setImage(ILogResourceFactory.getCardImage("PWR"));
        }
      }
    }
  }
}
