package com.winnertel.em.standard.util.gui.input.factory;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;


/**
 * The TextFieldFactory interface.
 */
public abstract class TextFieldFactory {
    public static final int IPUNICAST_INCLUDING_UNKNOWN = 0; // 0.0.0.0 means a unknown ipaddress
    public static final int IPUNICAST = 1;  // 1.0.0.0 - 223.255.255.255
    public static final int IPMULTICAST = 2; // 224.0.0.0 - 239.255.255.255
    public static final int IPMASK = 3;
    public static final int IPAll = 4;

    public abstract FormattedField create(int index);

}

;
