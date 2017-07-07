package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.IPAddressDataLayer;
import com.winnertel.em.standard.util.gui.input.factory.IPTextFieldFactory;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.StringTokenizer;

public class IPAddressField extends IPAddressDataLayer {

    public String getIPString() {
        return cells[0].getText() + "." + cells[1].getText() + "." + cells[2].getText() + "." + cells[3].getText();
    }

    private String clearCNull(String ipAddress) {
        byte[] bytes = ipAddress.getBytes();
        int index = 0;
        for (; index < bytes.length; index++) {
            if (bytes[index] == 0x00) break;
        }
        return new String(bytes, 0, index);
    }

    public void setValue(String aIPAddress) {
        if (aIPAddress == null) return;
        String ipAddress = clearCNull(aIPAddress);
        if (ipAddress == null) {
            setValue(this.getDefaultAddress(addressType));
            return;
        }
        String[] val = new String[4];

        StringTokenizer st = new StringTokenizer(ipAddress, ".");
        int cnt = st.countTokens();
        if (cnt == 4) {
            int i = 0;
            while (st.hasMoreElements()) {
                val[i++] = (String) st.nextElement();
            }
        } else {
            setValue(this.getDefaultAddress(addressType));
            return;
        }
        setValue(val);
    }

    private boolean verifyMask(String[] val) {
        for (int i = 0; i < 4; i++) {
            int v = Integer.parseInt(val[i]);
            if (v > 255 || v < 0) return false;
        }
        boolean getZeroFromLeft = false;
        for (int i = 0; i < 32; i++) {
            byte b = getBit(val, i);
            if (b == 0)
                getZeroFromLeft = true;
            else if (getZeroFromLeft) return false;
        }
        return true;
    }

    private boolean verifyAll(String[] val) {
        for (int i = 0; i < 4; i++) {
            int v = Integer.parseInt(val[i]);
            if (v > 255 || v < 0) return false;
        }
        return true;
    }

    private boolean verifyUnicast(String[] val) {
        for (int i = 0; i < 4; i++) {
            int v = Integer.parseInt(val[i]);
            if ((i == 0) && (v > 223 || v < 1)) return false;
            if ((i != 0) && (v > 255 || v < 0)) return false;
        }

        return true;
    }

    private boolean verifyUnicastAll(String[] val) {
        for (int i = 0; i < 4; i++) {
            int v = Integer.parseInt(val[i]);
            if ((i == 0) && (v > 223 || v < 0)) return false;
            if ((i != 0) && (v > 255 || v < 0)) return false;
        }

        return true;
    }

    private boolean verifyMulticast(String[] val) {
        for (int i = 0; i < 4; i++) {
            int v = Integer.parseInt(val[i]);
            if ((i == 0) && (v > 239 || v < 224)) return false;
            if ((i != 0) && (v > 255 || v < 0)) return false;
        }

        return true;
    }

    private boolean verifyAddress(String[] val) {
        switch (addressType) {
            case IPMASK:
                return verifyMask(val);
            case IPMULTICAST:
                return verifyMulticast(val);
            case IPUNICAST:
                return verifyUnicast(val);
            case IPUNICAST_INCLUDING_UNKNOWN:
                return verifyUnicastAll(val);
            case IPAll:
                return verifyAll(val);
            default:
                return false;
        }

    }

    public void setValue(String[] aval) {
        if (verifyAddress(aval)) {
            cells[0].setText(aval[0]);
            cells[1].setText(aval[1]);
            cells[2].setText(aval[2]);
            cells[3].setText(aval[3]);
        } else {
            setValue(this.getDefaultAddress(addressType));
        }

    }

    public void setValue(byte[] val) {
        if (val == null || val.length != 4) {
            setValue(this.getDefaultAddress(addressType));
            return;
        }
        String[] strVal = new String[4];
        for (int i = 0; i < 4; i++) {
            strVal[i] = Integer.toString(val[i]);
        }

        setValue(strVal);
    }

    public byte[] getValue() {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (Integer.parseInt(cells[0].getText()) & 0XFF);
        bytes[1] = (byte) (Integer.parseInt(cells[1].getText()) & 0XFF);
        bytes[2] = (byte) (Integer.parseInt(cells[2].getText()) & 0XFF);
        bytes[3] = (byte) (Integer.parseInt(cells[3].getText()) & 0XFF);
        return bytes;
    }

    public void addKeyListener(KeyListener l) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].addKeyListener(l);
        }
    }

    public void removeKeyListener(KeyListener l) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].removeKeyListener(l);
        }
    }

    public void setEnabled(boolean b) {
        for (int i = 0; i < cells.length; i++) {
            cells[i].setEnabled(b);
        }
    }

    public IPAddressField() {
        this(IPUNICAST_INCLUDING_UNKNOWN, "");
    }

    public IPAddressField(int type) {

        this(type, "");
    }
    /*
    * @see pls use new SIPAddressTextField(IPMASK).
    */

    public IPAddressField(boolean isMask) {
        this(isMask ? IPMASK : IPUNICAST_INCLUDING_UNKNOWN, "");

    }

    private IPAddressField(int type, String address) {
        super(new int[]{3, 3, 3, 3}, new String[]{".", ".", "."}, IPTextFieldFactory.getInstance(type));
        addressType = type;
        if (address.equals("")) {
            setValue(getDefaultAddress(type));
        } else
            setValue(address);
        this.setMinimumSize(new Dimension(18 * 8, 22));
        this.setPreferredSize(new Dimension(18 * 8, 22));
    }


}

