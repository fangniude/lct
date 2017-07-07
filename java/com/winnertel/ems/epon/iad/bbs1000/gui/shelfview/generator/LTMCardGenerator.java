package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.generator;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.ems.epon.iad.bbs1000.gui.shelfview.ILogResourceFactory;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Olt2PortTable;
import com.winnertel.ems.epon.iad.bbs1000.mib.PonLedTable;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.model.*;

import java.util.List;

public class LTMCardGenerator
{
  IApplication fApplication = null;

  public LTMCardGenerator(IApplication application)
  {
    this.fApplication = application;
  }

  public void generate(UDataBox dataSource, BBS1000CardMibBean bean)
  {
    Card card = new Card();
    card.setUserObject("" + bean.getUtsEponModuleBoardPhyId());
    card.setLabel(fApplication.getGlobalStringMap().getString("Card") + " " + bean.getUtsEponModuleBoardPhyId());
    card.setTypeInfo(new TypeInfo("LTM"));
    dataSource.addElement(card);

    Shelf shelf = (Shelf)dataSource.getElementByUserObject("SHELF1");
    int id = bean.getUtsEponModuleBoardPhyId().intValue();
    if(id == 1)
    {
      dataSource.setParent(shelf, card, 420, 33);
    }
    else
    {
      dataSource.setParent(shelf, card, 192, 33);
    }

    if(bean.getUtsEponModuleBoardState().intValue() == 3) //active
    {
      int type = bean.getUtsEponModuleBoardType().intValue();
      if(type == 20)
      {
        card.setImage(ILogResourceFactory.getCardImage("LTM"));
      }
      else if(type == 21)
      {
        card.setImage(ILogResourceFactory.getCardImage("LTM6"));
      }
      else
      {
        card.setImage(ILogResourceFactory.getCardImage("LTM"));
      }

      PonLedTable ponBean = new PonLedTable(fApplication.getSnmpProxy());
      ponBean.setUtsLedPonSlotLedDispSlotId(Integer.valueOf((String)card.getUserObject()));
      try
      {
        ponBean.retrieve();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

      assemblePort(dataSource, card, ponBean);
      assembleLed(dataSource, card, ponBean);
    }
    else
    {
      card.setImage(ILogResourceFactory.getCardImage("EMPTY"));
    }
  }

  protected void assemblePort(UDataBox dataSource, Card card, PonLedTable bean)
  {
    String cardName = card.getUserObject().toString();

    Dot3Olt2PortTable portBean = new Dot3Olt2PortTable(fApplication.getSnmpProxy());

    for(int i = 1; i <= 4; i++)
    {
      Port port = new Port();
      port.setUserObject(cardName + "/" + i);
      port.setTypeInfo(new TypeInfo("LTM"));
      port.setImage(ILogResourceFactory.getPortImage("LTM"));
      dataSource.addElement(port);
      dataSource.setParent(card, port, 73 + i * 21, 5);

      //Oper LEDs
      LED operLed = new LED();
      operLed.setUserObject(cardName + "_OPER" + i);
      operLed.setLabel("OPER");
      operLed.setTypeInfo(new TypeInfo("LED"));
      dataSource.addElement(operLed);
      dataSource.setParent(card, operLed, 193 - (i - 1)/2 * 10, 5 + (i - 1) % 2 * 10);

      try
      {
        portBean.setUtsDot3OltModuleId(new Integer(cardName));
        portBean.setUtsDot3OltDeviceId(new Integer(1));
        portBean.setUtsDot3OltPortId(new Integer(i));

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
      else
      {
        port.clearState(ILogResourceFactory.LOCKED);
      }

      Integer state = (Integer) MibBeanUtil.getSimpleProperty(bean, "utsLedPonSlotLedDispPonPort" + i +"LedStat");
      if(state != null && state == 1)//green-on
      {
        operLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
      }
      else if(state != null && state == 2)//red-on
      {
        operLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
      }
      else
      {
        operLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
      }
    }
  }

  protected void assembleLed(UDataBox dataSource, Card card, PonLedTable bean)
  {
    String cardName = card.getUserObject().toString();
    //POWER
    LED pwrLed = new LED();
    pwrLed.setUserObject(cardName + "_PWR");
    pwrLed.setLabel("PWR");
    pwrLed.setTypeInfo(new TypeInfo("LED"));
    pwrLed.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
    dataSource.addElement(pwrLed);
    dataSource.setParent(card, pwrLed, 37, 14);

    LED runLed = new LED();
    runLed.setUserObject(cardName + "_FAULT");
    runLed.setLabel("FAULT");
    runLed.setTypeInfo(new TypeInfo("LED"));
    if(bean.getUtsLedPonSlotLedDispFaultLedStat()!= null && bean.getUtsLedPonSlotLedDispFaultLedStat().intValue() == 1)//1 - red on
    {
      runLed.setImage(ILogResourceFactory.getLedImage("LED_RED"));
    }
    else
    {
      runLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
    }
    dataSource.addElement(runLed);
    dataSource.setParent(card, runLed, 51, 14);

    LED swapLed = new LED();
    swapLed.setUserObject(cardName + "_SWAP");
    swapLed.setLabel("SWAP");
    swapLed.setTypeInfo(new TypeInfo("LED"));
    if(bean.getUtsLedPonSlotLedDispSwapLedStat() == null || bean.getUtsLedPonSlotLedDispSwapLedStat() == 2) //2 - yellow off
    {
      swapLed.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
    }
    else
    {
      swapLed.setImage(ILogResourceFactory.getLedImage("LED_YELLOW"));
    }

    dataSource.addElement(swapLed);
    dataSource.setParent(card, swapLed, 65, 14);
  }

  protected void updatePort(Port port, Dot3Olt2PortTable bean)
  {
    if(bean.getUtsDot3OltAdminStatus() != null && bean.getUtsDot3OltAdminStatus().intValue() != 1) //down
      port.setState(ILogResourceFactory.LOCKED);
    else
      port.clearState(ILogResourceFactory.LOCKED);
  }

  protected void updateLed(LED led, Dot3Olt2PortTable bean)
  {
    //update the LED by PonLedTable not the port admin status.
    PonLedTable ponBean = new PonLedTable(fApplication.getSnmpProxy());
    ponBean.setUtsLedPonSlotLedDispSlotId(bean.getUtsDot3OltModuleId());
    try
    {
      ponBean.retrieve();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    Integer state = (Integer) MibBeanUtil.getSimpleProperty(ponBean, "utsLedPonSlotLedDispPonPort" + bean.getUtsDot3OltPortId() +"LedStat");
    if(state != null && state == 1)//green-on
    {
      led.setImage(ILogResourceFactory.getLedImage("LED_GREEN"));
    }
    else if(state != null && state == 2)//red-on
    {
      led.setImage(ILogResourceFactory.getLedImage("LED_RED"));
    }
    else
    {
      led.setImage(ILogResourceFactory.getLedImage("LED_OFF"));
    }
  }

//  protected PonLedTableBean getPonLedBean()
//  {
//    PonLedTableBean bean = new PonLedTableBean(fApplication.getSnmpProxy());
//
//  }
  /**
   * update the EPM card in datasource.
   *
   * @param dataSource
   * @param bean
   */
  public void update(UDataBox dataSource, BBS1000CardMibBean bean)
  {
    Card card = (Card)dataSource.getElementByUserObject("" + bean.getUtsEponModuleBoardPhyId());

    if(card.getTypeInfo().getName().startsWith("LTM"))
    {
      if(bean.getUtsEponModuleBoardState().intValue() == 3) // active
      {
        int type = bean.getUtsEponModuleBoardType().intValue();
        if(type == 20)
        {
          card.setImage(ILogResourceFactory.getCardImage("LTM"));
        }
        else if(type == 21)
        {
          card.setImage(ILogResourceFactory.getCardImage("LTM6"));
        }
        else
        {
          card.setImage(ILogResourceFactory.getCardImage("LTM"));
        }

        //update the state
//        IltOSIObjectState state = (IltOSIObjectState)card.getObjectState();
//        state.setState(new IltOSI.State(IltOSI.State.Operational.Enabled, IltOSI.State.Usage.Active, IltOSI.State.Administrative.Unlocked));

        //update the port on card.
        Dot3Olt2PortTable portBean = new Dot3Olt2PortTable(fApplication.getSnmpProxy());
        for(int i = 1; i <= 4; i++)
        {
          try
          {
            String portName = bean.getUtsEponModuleBoardPhyId() + "/" + i;
            portBean.setUtsDot3OltModuleId(bean.getUtsEponModuleBoardPhyId());
            portBean.setUtsDot3OltDeviceId(new Integer(1));
            portBean.setUtsDot3OltPortId(new Integer(i));
            portBean.retrieve();

            Port port = (Port)dataSource.getElementByUserObject(portName);
            updatePort(port, portBean);

            //update the led state.
            String ledName = bean.getUtsEponModuleBoardPhyId() + "_OPER" + i;
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

        //
        List children = dataSource.getChildren(card);
        for(int i = 0; i < children.size(); i++)
        {
          dataSource.removeElement((Element)children.get(i), true);
        }
      }
    }
    else
    {
      if(bean.getUtsEponModuleBoardState().intValue() == 3) // active
      {
        int type = bean.getUtsEponModuleBoardType().intValue();
        if(type == 20)
        {
          card.setImage(ILogResourceFactory.getCardImage("LTM"));
        }
        else if(type == 21)
        {
          card.setImage(ILogResourceFactory.getCardImage("LTM6"));
        }
        else
        {
          card.setImage(ILogResourceFactory.getCardImage("LTM"));
        }

        PonLedTable ponBean = new PonLedTable(fApplication.getSnmpProxy());
        ponBean.setUtsLedPonSlotLedDispSlotId(Integer.valueOf((String)card.getUserObject()));
        try
        {
          ponBean.retrieve();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }

        //add the ports to card.
        assemblePort(dataSource, card, ponBean);

        //add the LEDs to card.
        assembleLed(dataSource, card, ponBean);
      }
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
    String portName = bean.getUtsDot3OltModuleId() + "/" + bean.getUtsDot3OltPortId();
    Port port = (Port)dataSource.getElementByUserObject(portName);
    updatePort(port, bean);

    //update the led state.
    String ledName = bean.getUtsDot3OltModuleId() + "_OPER" + bean.getUtsDot3OltPortId();
    LED led = (LED)dataSource.getElementByUserObject(ledName);
    updateLed(led, bean);
  }
}
