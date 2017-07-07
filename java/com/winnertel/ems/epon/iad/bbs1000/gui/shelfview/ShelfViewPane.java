package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview;

import java.net.URL;
import java.awt.*;

import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.event.UEvent;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.task.Task;

public class ShelfViewPane extends UPanel
{
  private int shelfIndex = 0;

  private ShelfView shelfView;
//  private ShelfViewData shelfViewData;

  public ShelfViewPane(IApplication app)
  {
    super(app);
    long start = System.currentTimeMillis();
    init();
    long end = System.currentTimeMillis();
    System.out.println("ShelfViewPane construction Total done(ms): " + (end - start));
  }

  public void setShelfIndex(int index)
  {
    shelfIndex = index;
  }

  public int getShelfIndex()
  {
    return shelfIndex;
  }

  URL getUrl(String filename)
  {
    return getClass().getClassLoader().getResource(filename);
  }

  public void initGui()
  {
    setLayout(new BorderLayout());
    long t1 = System.currentTimeMillis();
//    shelfView = new ShelfView(fApplication);
    try
    {
      shelfView = (ShelfView)fApplication.getTaskManager().executeTask( new Task(){

        public Object execute() throws Exception
        {
          ILogResourceFactory.init();
          return new ShelfView(fApplication);
        }
      }
      );
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    long t2 = System.currentTimeMillis();
    System.out.println("ShelfView Total Initialize Done(ms): " + (t2-t1));

    shelfView.getEquipment().getCanvasScrollPane().setPreferredSize(new Dimension(800, 400));
    this.add(shelfView.getEquipment(), BorderLayout.CENTER);
    updateUI();
  }

  protected void initForm()
  {
    //do nothing.
  }

  public void refresh()
  {
    shelfView.refresh();
//    try
//    {
//      fApplication.getTaskManager().executeTask( new Task(){
//
//        public Object execute() throws Exception
//        {
//          long t1 = System.currentTimeMillis();
////          ShelfViewPane.this.shelfView.();
//          System.out.println("initEquipment in refresh(): " + (System.currentTimeMillis() - t1));
//          return null;
//        }
//      }
//      );
//    }
//    catch(Exception e)
//    {
//      e.printStackTrace();
//    }
  }

  public void update(UEvent event)
  {
//    shelfView.
  }
}
