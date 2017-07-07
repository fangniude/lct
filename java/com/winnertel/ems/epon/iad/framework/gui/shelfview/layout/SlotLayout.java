package com.winnertel.ems.epon.iad.framework.gui.shelfview.layout;

import org.jdom.Element;
import com.winnertel.tgcl.model.Holder;
import com.winnertel.tgcl.UDataBox;


public class SlotLayout implements ILayout{

    public void parse(Element eLayout) {
//        positions.clear();
//        if(eLayout != null) {
//            List<Element> list = eLayout.getChildren("slot");
//
//            for(int i = 0; i < list.size(); i++) {
//                Element eSlot = list.get(i);
//
//                try {
//                    int index = Integer.parseInt(eSlot.getAttributeValue("index"));
//
//                    Point point = new Point();
//                    point.x = Integer.parseInt(eSlot.getAttributeValue("x"));
//                    point.y = Integer.parseInt(eSlot.getAttributeValue("y"));
//
//                    positions.add(index, point);
//                } catch(Exception e) {
//
//                }
//            }
//        } else {
//            fLogger.error("The element is null.");
//        }
    }

    public void locate(UDataBox box, Holder parent, Holder holder) {
    }

    public int getLocation() {
        return 0;
    }
}
