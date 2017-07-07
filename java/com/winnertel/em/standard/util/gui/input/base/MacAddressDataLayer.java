package com.winnertel.em.standard.util.gui.input.base;

import com.winnertel.em.standard.util.gui.input.factory.TextFieldFactory;

public class MacAddressDataLayer extends AbstractTextPanel {
    public final static int UNICAST_TYPE = 1;
    public final static int MULTICAST_TYPE = 2;
    public final static int BROADCAST_TYPE = 3;


    public MacAddressDataLayer(int[] cellWidths, String[] holders, TextFieldFactory aFactory) {
        super(cellWidths, holders, aFactory);
    }

    protected boolean verifyField(int cellIndex) {
        String content = cells[cellIndex].getText();
        if (content.equals("")) {
            cells[cellIndex].setText("F8");
            super.popupMessage(getString("valid_mac_item_required"));
            return false;
        } else if (content.length() == 1) {
            int i = Integer.parseInt(content, 16);

            if (cellIndex == 0 && i % 2 != 0) {
                if (getMacType() != UNICAST_TYPE) return true;
//                cells[cellIndex].setText("F8");
                super.popupMessage(getString("valid_mask_required"));
                return false;
            } else
                cells[cellIndex].setText("0" + content);
        }

        return true;
    }

    protected int getMacType() {
        return UNICAST_TYPE;
    }
}
