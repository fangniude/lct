package com.winnertel.em.standard.util.gui.input.base;

import com.winnertel.em.standard.util.gui.input.factory.TextFieldFactory;


public abstract class IPAddressDataLayer extends AbstractTextPanel {
    public static final int IPUNICAST_INCLUDING_UNKNOWN = 0; // 0.0.0.0 means a unknown ipaddress
    public static final int IPUNICAST = 1;  // 1.0.0.0 - 223.255.255.255
    public static final int IPMULTICAST = 2; // 224.0.0.0 - 239.255.255.255
    public static final int IPMASK = 3;
    public static final int IPAll = 4;
    public int addressType;

    public IPAddressDataLayer(int[] cellWidths, String[] holders, TextFieldFactory aFactory) {
        super(cellWidths, holders, aFactory);
    }

    protected byte getBit(String[] val, int index) {
        int i = index / 8;
        int x = 7 - index % 8;
        byte b = (byte) Integer.parseInt(val[i]);
        return (byte) (b >>> x & 0x01);
    }

    protected String getDefaultAddress(int type) {
        switch (type) {
            case IPMASK:
                return "255.255.255.0";
            case IPMULTICAST:
                return "224.0.0.0";
            case IPUNICAST:
                return "1.0.0.0";
            case IPUNICAST_INCLUDING_UNKNOWN:
                return "0.0.0.0";
            case IPAll:
                return "0.0.0.0";
            default:
                return "";
        }
    }

    protected boolean verifyUnicastAllIP(int cellIndex) {
        String content = cells[cellIndex].getText();
        if (cellIndex == 0) {
            {
                if (content.equals("")) {
                    cells[cellIndex].setText("223");
                    popupMessage(0, 223);
                    cells[cellIndex].requestFocus();
                    return false;
                }
                int i = Integer.parseInt(content);
                if (i > 223 || i < 0) {
                    cells[cellIndex].setText("223");
                    popupMessage(0, 223);
                    cells[cellIndex].requestFocus();
                    return false;
                }

            }
        } else {
            if (content.equals("")) {
                cells[cellIndex].setText("0");
                popupMessage(0, 255);
                cells[cellIndex].requestFocus();
                return false;
            }
            int i = Integer.parseInt(content);
            if (i > 255 || i < 0) {
                cells[cellIndex].setText("0");
                popupMessage(0, 255);
                cells[cellIndex].requestFocus();
                return false;
            }
        }

        return true;
    }

    protected boolean verifyUnicastIP(int cellIndex) {
        String content = cells[cellIndex].getText();
        if (cellIndex == 0) {
            {
                if (content.equals("")) {
                    cells[cellIndex].setText("223");
                    popupMessage(1, 223);
                    cells[cellIndex].requestFocus();
                    return false;
                }
                int i = Integer.parseInt(content);
                if (i > 223 || i < 1) {
                    cells[cellIndex].setText("223");
                    popupMessage(1, 223);
                    cells[cellIndex].requestFocus();
                    return false;
                }

            }
        } else {
            if (content.equals("")) {
                cells[cellIndex].setText("0");
                popupMessage(0, 255);
                cells[cellIndex].requestFocus();
                return false;
            }
            int i = Integer.parseInt(content);
            if (i > 255 || i < 0) {
                cells[cellIndex].setText("0");
                popupMessage(0, 255);
                cells[cellIndex].requestFocus();
                return false;
            }
        }

        return true;
    }

    protected boolean verifyMulticastIP(int cellIndex) {
        String content = cells[cellIndex].getText();
        if (cellIndex == 0) {
            {
                if (content.equals("")) {
                    cells[cellIndex].setText("224");
                    popupMessage(224, 239);
                    cells[cellIndex].requestFocus();
                    return false;
                }
                int i = Integer.parseInt(content);
                if (i > 239 || i < 224) {
                    cells[cellIndex].setText("224");
                    popupMessage(224, 239);
                    cells[cellIndex].requestFocus();
                    return false;
                }

            }
        } else {
            if (content.equals("")) {
                cells[cellIndex].setText("0");
                popupMessage(0, 255);
                cells[cellIndex].requestFocus();
                return false;
            }
            int i = Integer.parseInt(content);
            if (i > 255 || i < 0) {
                cells[cellIndex].setText("0");
                popupMessage(0, 255);
                cells[cellIndex].requestFocus();
                return false;
            }
        }

        return true;
    }

    protected boolean verifyMask(int cellIndex) {
        String[] val = new String[]{cells[0].getText(), cells[1].getText(), cells[2].getText(), cells[3].getText()};

        if (!maskIPVerify(val)) {
            super.popupMessage(getString("valid_mask_required"));
            return false;
        }


        int index = getInvalidFieldIndex(val);

        if (index > -1) {
            for (int j = index + 1; j < cells.length; j++) {
                cells[j].setText("0");
            }

            if (index == cellIndex) {
                super.popupMessage(getString("valid_mask_required"));
                return false;
            }
        }

        return true;
    }

    protected boolean verifyAll(int cellIndex) {
        String[] val = new String[]{cells[0].getText(), cells[1].getText(), cells[2].getText(), cells[3].getText()};

        if (!maskIPVerify(val)) {
            super.popupMessage(getString("valid_mask_required"));
            return false;
        }
        return true;
    }

    private boolean maskIPVerify(String[] val) {
        for (int i = 0; i < 4; i++) {
            if (val[i].equals("")) return false;
            int v = Integer.parseInt(val[i]);
            if (v > 255 || v < 0) return false;
        }
        return true;
    }

    private int getInvalidFieldIndex(String[] val) {
        boolean getZeroFromLeft = false;
        for (int i = 0; i < 32; i++) {
            byte b = getBit(val, i);
            if (b == 0)
                getZeroFromLeft = true;
            else if (getZeroFromLeft) {
                //the mask is invalid.
                return i / 8;
            }
        }

        return -1;
    }

    public boolean verifyField(int cellIndex) {

        if (!isEditable()) return true;

        switch (addressType) {
            case IPUNICAST_INCLUDING_UNKNOWN: {
                return verifyUnicastAllIP(cellIndex);
            }
            case IPUNICAST: {
                return verifyUnicastIP(cellIndex);
            }
            case IPMULTICAST: {
                return verifyMulticastIP(cellIndex);
            }
            case IPMASK: {
                return verifyMask(cellIndex);
            }
            case IPAll: {
                return verifyAll(cellIndex);
            }
        }

        return true;
    }
}

