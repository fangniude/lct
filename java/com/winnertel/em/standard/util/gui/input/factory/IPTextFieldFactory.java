package com.winnertel.em.standard.util.gui.input.factory;

import com.winnertel.em.standard.util.gui.input.base.FormattedField;
import com.winnertel.em.standard.util.gui.input.base.IPTextField;

class UnicastAllIPFactory extends TextFieldFactory {
    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;

    private UnicastAllIPFactory() {
    }

    public static TextFieldFactory getInstance() {
        synchronized (initLock) {
            if (factory == null) {
                factory = new UnicastAllIPFactory();
            }
            return factory;
        }
    }

    public FormattedField create(int cellIndex) {
        return new IPTextField(IPUNICAST_INCLUDING_UNKNOWN, cellIndex);
    }
}

class UnicastIPFactory extends TextFieldFactory {
    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;

    private UnicastIPFactory() {
    }

    public static TextFieldFactory getInstance() {
        synchronized (initLock) {
            if (factory == null) {
                factory = new UnicastIPFactory();
            }
            return factory;
        }
    }

    public FormattedField create(int cellIndex) {
        return new IPTextField(IPUNICAST, cellIndex);
    }
}

class MulticastIPFactory extends TextFieldFactory {
    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;

    private MulticastIPFactory() {
    }

    public static TextFieldFactory getInstance() {
        synchronized (initLock) {
            if (factory == null) {
                factory = new MulticastIPFactory();
            }
            return factory;
        }
    }

    public FormattedField create(int cellIndex) {
        return new IPTextField(IPMULTICAST, cellIndex);
    }
}

class MaskIPFactory extends TextFieldFactory {

    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;

    private MaskIPFactory() {
    }

    public static TextFieldFactory getInstance() {
        synchronized (initLock) {
            if (factory == null) {
                factory = new MaskIPFactory();
            }
            return factory;
        }

    }

    public FormattedField create(int cellIndex) {
        return new IPTextField(IPMASK, cellIndex);
    }
}

class AllIPFactory extends TextFieldFactory {

    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;

    private AllIPFactory() {
    }

    public static TextFieldFactory getInstance() {
        synchronized (initLock) {
            if (factory == null) {
                factory = new AllIPFactory();
            }
            return factory;
        }

    }

    public FormattedField create(int cellIndex) {
        return new IPTextField(IPMASK, cellIndex);
    }
}

public class IPTextFieldFactory extends TextFieldFactory {
    private static Object initLock = new Object();
    private static TextFieldFactory factory = null;


    private IPTextFieldFactory() {
    }

    public static TextFieldFactory getInstance(int type) {
        synchronized (initLock) {
            switch (type) {
                case IPUNICAST_INCLUDING_UNKNOWN:
                    return UnicastAllIPFactory.getInstance();
                case IPUNICAST:
                    return UnicastIPFactory.getInstance();
                case IPMULTICAST:
                    return MulticastIPFactory.getInstance();
                case IPMASK:
                    return MaskIPFactory.getInstance();
                case IPAll:
                    return AllIPFactory.getInstance();
            }
            if (factory == null) {
                factory = new IPTextFieldFactory();
            }
            return factory;
        }
    }

    public FormattedField create(int cellIndex) {
        return null;
    }
}
