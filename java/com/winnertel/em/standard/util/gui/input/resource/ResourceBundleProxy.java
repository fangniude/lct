package com.winnertel.em.standard.util.gui.input.resource;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class ResourceBundleProxy {
    private static ResourceBundleProxy ourInstance;
    private static Locale fLocale = null;
    private static ResourceBundle bundle;

    private ResourceBundleProxy() {
    }

    public synchronized static ResourceBundleProxy getInstance() {
        if (ourInstance == null) {
            ourInstance = new ResourceBundleProxy();
        }
        return ourInstance;
    }

    public Locale getLocale() {
        return fLocale;
    }

    public void setLocale(Locale aLocale) {
        fLocale = aLocale;
    }

    public String getString(String key) {
        if (fLocale == null)
            fLocale = new Locale("en", "US");
        bundle = ResourceBundle.getBundle("com.winnertel.em.standard.util.gui.input.resource.Resources", fLocale);

        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
//        e.printStackTrace();
            return key;
        }
    }
}

