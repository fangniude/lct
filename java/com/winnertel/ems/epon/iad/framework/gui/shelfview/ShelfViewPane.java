package com.winnertel.ems.epon.iad.framework.gui.shelfview;

import java.awt.*;

import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.task.Task;

public class ShelfViewPane extends UPanel {
    private ShelfView shelfView;

    public ShelfViewPane(IApplication app) {
        super(app);
        long start = System.currentTimeMillis();
        init();
        long end = System.currentTimeMillis();
        System.out.println("ShelfViewPane construction Total done(ms): " + (end - start));
    }

    public void initGui() {
        fApplication.getActiveDeviceManager().setShelfViewPane(this);

        setLayout(new BorderLayout());

        long t1 = System.currentTimeMillis();
        try {
            //it takes about 5 seconds to init the data and resouce in shelfview.
            fApplication.getTaskManager().executeTask(new Task() {

                public Object execute() throws Exception {
                    long t1 = System.currentTimeMillis();

                    shelfView = new ShelfView(fApplication);
                    fApplication.getActiveDeviceManager().getProperties().put("ShelfView", shelfView);
                    shelfView.init();
                    shelfView.assemble();

                    long t2 = System.currentTimeMillis();
                    System.out.println("ShelfView Total Initialize Done(ms): " + (t2 - t1));
                    return Boolean.TRUE;
                }
            }
            );
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        shelfView.getEquipment().getCanvasScrollPane().setPreferredSize(new Dimension(800, 650));
        this.add(shelfView.getEquipment(), BorderLayout.CENTER);
        updateUI();
    }

    protected void initForm() {
        //do nothing.
    }

    public void refresh() {
    }

    //
}
    