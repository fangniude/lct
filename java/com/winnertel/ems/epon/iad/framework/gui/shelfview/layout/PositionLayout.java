package com.winnertel.ems.epon.iad.framework.gui.shelfview.layout;

import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.model.Holder;
import org.jdom.Element;

import java.util.HashMap;
import java.util.List;

public class PositionLayout implements ILayout{
    private ILogger fLogger = LoggerController.createLogger(PositionLayout.class);
    private HashMap<String, Location> positions = new HashMap<String, Location>();

    public PositionLayout() {
    }

    public void parse(Element eLayout) {
        positions.clear();
        if(eLayout != null) {
            List<Element> list = (List<Element>)eLayout.getChildren("slot");

            for (Element eSlot : list) {
                try {
                    String index = eSlot.getAttributeValue("index");

                    Location location = new Location();
                    location.x = Integer.parseInt(eSlot.getAttributeValue("x"));
                    location.y = Integer.parseInt(eSlot.getAttributeValue("y"));
                    location.width = Integer.parseInt(eSlot.getAttributeValue("width"));
                    location.height = Integer.parseInt(eSlot.getAttributeValue("height"));

                    positions.put(index, location);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            fLogger.error("The element is null.");
        }
    }
    
   public void locate(UDataBox box, Holder parent, Holder holder) {
        try {
            Location location = positions.get(holder.getUserObject());

            if(location != null) {
                holder.setSize(location.width, location.height);
                box.setParent(parent, holder, location.x, location.y);
            } else {
                fLogger.error("Can't locate the holder: " + holder.getUserObject());
            }
        } catch(NumberFormatException e1) {
            fLogger.error("Invalid index: " + holder.getUserObject());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
