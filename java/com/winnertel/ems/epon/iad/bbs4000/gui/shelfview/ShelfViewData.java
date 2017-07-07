package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview;

import com.winnertel.ems.epon.iad.bbs4000.MainApplet;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.generator.ShelfViewGenerator;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.tgcl.UDataBox;

public class ShelfViewData
{
  private IApplication application;
  private ShelfViewGenerator generator;
  private UDataBox dataSource;

  public ShelfViewData(IApplication _application)
  {
    application = _application;

    // Create a new datasource
    dataSource = new UDataBox(application.getActiveDeviceManager().getName());
    generator = new ShelfViewGenerator(application);
  }

  public UDataBox getDataSource()
  {
    return dataSource;
  }

  public void assemble()
  {
    generator.assemble(dataSource);
  }

  public void update()
  {
    dataSource = new UDataBox(application.getActiveDeviceManager().getName());
    assemble();
  }
  
  public void update(SnmpMibBean bean)
  {
    generator.update(dataSource, bean);

    //refresh the left function tree.
    if(bean instanceof BBS4000CardMibBean) //update the module card.
    {
      MainApplet applet = (MainApplet)application.getMainApplet();
      applet.refreshGuiComponent(application.getActiveDeviceManager());
    }
  }
}
