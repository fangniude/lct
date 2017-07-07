package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview;

import com.winnertel.ems.epon.iad.bbs4000.constant.CommonConstant;

import java.util.Properties;

public class ShelfInformation
{
  private synchronized static Properties createShelfInformation(Properties source) {
      Properties shelfInformation = (Properties) source.get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION);
      if (shelfInformation == null) {
          shelfInformation = new Properties();
          source.put(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION, shelfInformation);
      }
      return source;
  }

  public synchronized static Object getShelfProperties(Properties source, String key) {
      return ((Properties) createShelfInformation(source).get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION)).get(key);
  }

  public synchronized static void putShelfProperties(Properties source, String key, Object val) {
      Properties prop = (Properties) createShelfInformation(source).get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION);
      if (prop == null) {
          prop = new Properties();
          source.put(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION, prop);
      }

      if (prop.getProperty(key) != null) {
          prop.remove(key);
      }
      ((Properties) source.get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION)).put(key, val);
  }

  public synchronized static Object getModuleProperties(Properties source, int shelfIndex, String key) {
      return ((Properties) createShelfInformation(source).get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION)).get("Shelf" + shelfIndex + key);
  }

  public synchronized static void putModuleProperties(Properties source, int shelfIndex, String key, Object val) {
      Properties prop = (Properties) createShelfInformation(source).get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION);

      if (prop.getProperty("Shelf" + shelfIndex + key) != null) {
          prop.remove("Shelf" + shelfIndex + key);
      }
      ((Properties) source.get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION)).put("Shelf" + shelfIndex + key, val);
  }

  public synchronized static void removeShelfProperties(Properties source, String key) {
      ((Properties) createShelfInformation(source).get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION)).remove(key);
  }

  public synchronized static void removeAllShelfProperites(Properties source) {
      ((Properties) createShelfInformation(source).get(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION)).clear();
      source.remove(CommonConstant.BBS4000_SHUTDOWN_SHELF_INFORMATION);
  }
}