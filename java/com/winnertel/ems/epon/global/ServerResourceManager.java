package com.winnertel.ems.epon.global;

import com.winnertel.em.standard.resource.DocumentLoader;
import com.winnertel.inms.global.Global;
import org.jdom.Element;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ServerResourceManager {
  private static Map cache = composeCache();

  public static String getString(String key) {
    String str = null;

    if(cache != null)
    {
      str = (String) cache.get(key);
    }

    return str != null ? str : key;
  }

  public static String[] getString(String[] key)
  {
    if(key == null) return null;

    String[] result = new String[key.length];

    for(int i = 0; i < key.length; i++)
    {
      result[i] = getString(key[i]);
    }

    return result;
  }

  private static Map composeCache() {
    String language = "en";
    String country = "US";
    try {
      language = Global.getInstance().getLanguageAbbr();
      country = Global.getInstance().getCountryAbbr();
    } catch (Exception e) {
      e.printStackTrace();
    }

    String fileName = "/resources/epon/common/ServerStringMap_" + language + "_" + country + ".xml";
    System.out.println("The Resource File: " + fileName);
    URL url = ServerResourceManager.class.getResource(fileName);
    System.out.println("The Resource URL: " + url);

    Element root = null;
    if (url != null) {
      root = DocumentLoader.buildDocument(url);
    }

    return loadStringMapHelper(root);
  }

  private static Map loadStringMapHelper(Element aRoot) {
    if(aRoot == null) return null;

    Map result = new TreeMap();
    try {
      List eEntryList = aRoot.getChildren("String");
      if (eEntryList == null || eEntryList.size() == 0) {
        return result;
      }

      Iterator it = eEntryList.iterator();
      while (it.hasNext()) {
        Element eEntry = (Element) it.next();
        String name = eEntry.getAttributeValue("key");
        String value = eEntry.getAttributeValue("value");
        if (name != null && value != null) {
          if (result.containsKey(name)) {
//                      System.out.println( "Duplicate entry for " + name + " found in DvmStringMap. Use the last entry." );
          }
          result.put(name, value);
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return result;
  }
}
