package com.winnertel.em.standard.gui.util;

import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.standard.resource.DocumentLoader;
import com.winnertel.em.standard.resource.ResourceManager;

import java.net.URL;
import java.util.Locale;
import java.util.Map;

public class GlobalStringMap implements IStringMap {
    private Map fStringCache = null;


    public GlobalStringMap(Locale aLocale) {
        String fileName = "com/winnertel/em/standard/resource/GlobalStringMap" + "_"
                + aLocale.getLanguage() + "_" + aLocale.getCountry() + ".xml";
        URL fileUrl = getClass().getClassLoader().getResource(fileName);
        fStringCache = ResourceManager.loadStringMapHelper(DocumentLoader.buildDocument(fileUrl));
    }


    public String getString(String aKey) {
        String s = (String) fStringCache.get(aKey);
        if (s == null) {
            s = aKey;
        }
        return s;
    }
}
