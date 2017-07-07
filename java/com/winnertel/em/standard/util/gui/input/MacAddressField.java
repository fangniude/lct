package com.winnertel.em.standard.util.gui.input;

import com.winnertel.em.standard.util.gui.input.base.HexIntegerTextField;
import com.winnertel.em.standard.util.gui.input.base.MacAddressDataLayer;
import com.winnertel.em.standard.util.gui.input.factory.HexIntegerTextFieldFactory;
import com.winnertel.em.standard.util.gui.input.factory.MulticastMacFactory;
import com.winnertel.em.standard.util.gui.input.factory.TextFieldFactory;

import java.awt.*;
import java.util.StringTokenizer;

public class MacAddressField extends MacAddressDataLayer {
    // use static ,because abstract factory and static factory can't be combined!
    static private TextFieldFactory factory = HexIntegerTextFieldFactory.getInstance();
    ;
    private int type = UNICAST_TYPE;

    public MacAddressField() {
        this("F8:FF:FF:FF:FF:FF");
    }

    public MacAddressField(String aMacAddress) {
        super(new int[]{2, 2, 2, 2, 2, 2}, new String[]{":", ":", ":", ":", ":"}, factory);
        setValue(aMacAddress);
        this.setMinimumSize(new Dimension(19 * 8, 22));
        this.setPreferredSize(new Dimension(19 * 8, 22));


    }

    public MacAddressField(int type) {
        super(new int[]{2, 2, 2, 2, 2, 2}, new String[]{":", ":", ":", ":", ":"},
                type == MULTICAST_TYPE ? MulticastMacFactory.getInstance() : factory);
        this.setMinimumSize(new Dimension(19 * 8, 22));
        this.setPreferredSize(new Dimension(19 * 8, 22));
        this.type = type;
        if (!(type == UNICAST_TYPE || type == MULTICAST_TYPE))
            throw new RuntimeException("wrong arguments in SMacAddressTextField");

    }

    protected int getMacType() {
        return type;
    }

    private byte getByte(String mac) {
        return (byte) Integer.parseInt(mac.toLowerCase(), 16);
    }

    public byte[] getValue() {
        byte[] mac = new byte[6];
        if (cells[0].getText().equals("")) {
            cells[0].setText("F8");
        }
        mac[0] = getByte(cells[0].getText().toLowerCase());
        mac[1] = getByte(cells[1].getText().toLowerCase());
        mac[2] = getByte(cells[2].getText().toLowerCase());
        mac[3] = getByte(cells[3].getText().toLowerCase());
        mac[4] = getByte(cells[4].getText().toLowerCase());
        mac[5] = getByte(cells[5].getText().toLowerCase());

        return mac;
    }

    public void setValue(String aMacAddress) {
        if (aMacAddress == null) return;
        String[] val = {"F8", "FF", "FF", "FF", "FF", "FF"};
        StringTokenizer st = new StringTokenizer(aMacAddress, ".:");
        int cnt = st.countTokens();
        if (cnt == 6) {
            int i = 0;
            while (st.hasMoreElements()) {
                val[i++] = (String) st.nextElement();
            }
        }
        setValue(val);
    }

    public void setValue(byte[] macVal) {
        if (macVal.length != 6) return;
        String[] strVal = new String[6];
        for (int i = 0; i < 6; i++) {
            byte b = macVal[i];
            StringBuffer sb = new StringBuffer();
            if (b >= 0 && b < 16) {
                sb.append('0');
            }
            int bi = macVal[i] & 0xff;
            sb.append(Integer.toHexString(bi));
            strVal[i] = new String(sb);
        }
        setValue(strVal);
    }

    public String getMacString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 5; i++)
            sb.append(cells[i].getText() + ":");
        sb.append(cells[5].getText());
        return sb.toString();
    }

    public void setValue(String[] val) {
        if (val == null || val.length != 6) return;
        for (int i = 0; i < 6; i++) {
            if (getMacType() == UNICAST_TYPE)
                ((HexIntegerTextField) cells[i]).setValue(val[i]);
            else if (getMacType() == MULTICAST_TYPE)
                ((MulticastMacField) cells[i]).setValue(val[i]);
        }
    }

    public void setEnabled(boolean b) {
        super.setEnabled(b);

        for (int i = 0; i < cells.length; i++) {
            cells[i].setEnabled(b);
        }
    }

}
