package com.winnertel.ems.epon.iad.framework.gui.shelfview.factory;

import com.winnertel.tgcl.model.Shelf;
import com.winnertel.tgcl.model.Holder;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.gui.util.InstanceCreator;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.layout.ILayout;
import org.jdom.Element;

public class DefaultShelfFactory implements IHolderFactory {
    private ILogger fLogger = LoggerController.createLogger(DefaultShelfFactory.class);

    protected String background;
    protected ILayout layout;
    protected int width;
    protected int height;
    protected int x;
    protected int y;

    public DefaultShelfFactory(IApplication anApplication) {

    }

    public void parse(Element element) {
        try {
            String sWidth = element.getAttributeValue("width");
            if (sWidth != null) {
                width = Integer.parseInt(sWidth);
            }

            String sHight = element.getAttributeValue("height");
            if (sHight != null) {
                height = Integer.parseInt(sHight);
            }

            String location = element.getAttributeValue("location");
            if (location != null) {
                int index = location.indexOf(",");
                if (index != -1) {
                    x = Integer.parseInt(location.substring(0, index).trim());
                    y = Integer.parseInt(location.substring(index + 1).trim());
                } else {
                    fLogger.error("Invalid location in shelf: " + location);
                }
            }

            Element eLayoutManager = element.getChild("layout-manager");
            if (eLayoutManager != null) {
                Element eLayout = eLayoutManager.getChild("layout");

                String layoutClass = eLayout.getAttributeValue("class");
                if (layoutClass != null) {
                    layout = (ILayout) InstanceCreator.instantiateObject(layoutClass);

                    layout.parse(eLayout);
                } else {
                    fLogger.error("The layout in shelf is not found: ");
                }
            }

        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    public Shelf create(String id) {
        Shelf shelf = new Shelf();
        shelf.setUserObject("SHELF" + id);
        shelf.setLabel("");
        shelf.setSize(width, height);
        shelf.setLocation(x, y);

        return shelf;
    }

    public void addChild(UDataBox box, Holder parent, Holder child) {

        box.addElement(child);

        if(layout != null) {
            layout.locate(box, parent, child);
        } else {
            box.setParent(parent, child);
        }
    }
}
