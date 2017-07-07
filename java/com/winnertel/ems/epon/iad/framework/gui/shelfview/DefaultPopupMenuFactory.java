package com.winnertel.ems.epon.iad.framework.gui.shelfview;

import com.winnertel.em.framework.IApplication;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.action.RefreshChassisAction;
import com.winnertel.tgcl.PopupMenuFactory;
import com.winnertel.tgcl.model.Element;
import com.winnertel.tgcl.state.State;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.List;

public class DefaultPopupMenuFactory implements PopupMenuFactory {
    protected IApplication fApplication;

    public DefaultPopupMenuFactory(IApplication anApplication) {
        fApplication = anApplication;
    }

    public JPopupMenu createPopupMenu(JComponent component, Element element, Point2D d) {
        return createContextualPopup(component, element, d);
    }

    //create popup menus according to the selected object
    JPopupMenu createContextualPopup(JComponent component, Element element, Point2D d) {
        if (element == null) {
            JPopupMenu popMenu = new JPopupMenu();

            JMenuItem item = popMenu.add("Refresh");
            item.setAction(new RefreshChassisAction(fApplication));
            return popMenu;
        }

//        String selectedObjectType = null;
//        if (element instanceof Card) {
//            Card card = (Card) element;
//            selectedObjectType = card.getTypeInfo().getName();
//
//            property.setProperty("type", "card");
//            property.setProperty("slotId", (String) element.getUserObject());
//            // Create an empty popup menu
//            JPopupMenu popMenu = new JPopupMenu();
//
//            if (selectedObjectType.startsWith("GEM") || selectedObjectType.startsWith("EPM") || selectedObjectType.startsWith("GPM") || selectedObjectType.startsWith("XGM")) {
//                if (isMatchedState(card, ILogResourceFactory.LOCKED)) {
//                    JMenuItem item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Unlock"));
////                    item.setAction(new UnlockCardAction(fApplication));
//                } else {
//                    JMenuItem item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Lock"));
////                    item.setAction(new LockCardAction(fApplication));
//                }
//
//                JMenuItem item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Reset"));
////                    item.setAction(new ResetCardAction(fApplication));
//
//                item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
//                item.setAction(new RefreshChassisAction(fApplication));
//
//                return popMenu;
//            } else if (selectedObjectType.startsWith("CSM")) {
//                JMenuItem item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
//                item.setAction(new RefreshChassisAction(fApplication));
//
//                item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Reset"));
////                    item.setAction(new ResetCardAction(fApplication));
//
//                return popMenu;
//            } else// if(selectedObjectType.startsWith("CSM") || selectedObjectType.equalsIgnoreCase("EMPTY"))
//            {
//                JMenuItem item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
//                item.setAction(new RefreshChassisAction(fApplication));
//
//                return popMenu;
//            }
//        } else if (element instanceof Port) {
//            Port port = (Port) element;
//            selectedObjectType = port.getTypeInfo().getName();
//
//            //only the ports on GEM or EPM card are operational.
//            if (selectedObjectType.startsWith("GEM") || selectedObjectType.startsWith("EPM") || selectedObjectType.startsWith("GPM")) {
//                property.setProperty("type", "port");
//                property.setProperty("portId", (String) element.getUserObject());
//                property.setProperty("portType", selectedObjectType);
//
//                // Create an empty popup menu
//                JPopupMenu popMenu = new JPopupMenu();
//
//                if (isMatchedState(port, ILogResourceFactory.LOCKED)) {
//                    JMenuItem item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Unlock"));
////                    item.setAction(new UnlockPortAction(fApplication));
//                } else {
//                    JMenuItem item = popMenu.add(fApplication.getActiveDeviceManager().getGuiComposer().getString("Lock"));
////                    item.setAction(new LockPortAction(fApplication));
//                }
//
//                return popMenu;
//            }
//        }

        return null;
    }

    protected boolean isMatchedState(Element e, State aState) {
        List states = e.getAllStates();
        if (states != null) {
            for (int j = 0; j < states.size(); j++) {
                State s = (State) states.get(j);
                return (s != null && s.equals(aState));
            }
        }

        return false;
    }

}