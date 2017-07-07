package com.winnertel.em.framework.gui.event;

public class UEvent {
    public static final int TYPE_REFRESH = 0;
    public static final int TYPE_CREATE = 1;
    public static final int TYPE_UPDATE = 2;
    public static final int TYPE_DELETE = 3;

    int type = 0;
    Object obj = null;

    public UEvent(int type, Object o) {
        this.type = type;
        obj = o;
    }

    public int getType() {
        return type;
    }

    public Object getSource() {
        return obj;
    }
}
