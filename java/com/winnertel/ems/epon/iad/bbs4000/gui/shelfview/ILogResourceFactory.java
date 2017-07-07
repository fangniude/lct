package com.winnertel.ems.epon.iad.bbs4000.gui.shelfview;

import com.winnertel.tgcl.state.DefaultIconState;
import com.winnertel.tgcl.state.State;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class ILogResourceFactory
{
  public static final State LOCKED = new DefaultIconState("/com/winnertel/ems/epon/iad/bbs4000/gui/shelfview/resource/lock.gif");

  //equipment data source xml file
  static String dataSourceFile;
  //data source addtional xml file
  static String configurationFile;
  //card item types and images xml file
  static String cardItemTypeFile;
  //card item types and actions xml file
  static String cardItemActionFile;
  //equipment background image file
  static String shelfBackgroundFile;

  //port,card,led's names and types
  static Hashtable portImages = new Hashtable(10);
  static Hashtable cardImages = new Hashtable(10);
  static Hashtable ledImages = new Hashtable(10);

  //shelfview special conditional datasource files
  static Vector dataSourceFileVec;

  static Vector trapVec;

  static boolean isInitialized = false;

  public ILogResourceFactory()
  {
  }

  public static synchronized void init()
  {
    if(!isInitialized)
    {
      String xmlFile = "com/winnertel/ems/epon/iad/bbs4000/gui/shelfview/shelfviewpane.xml";
      if(!readConfigParams(xmlFile))
      {
        System.out.println("###Shelfview can't support the current device.....!");
        return;
      }

      //set xml file names
      initResourceFile();

      try
      {
        long t1 = System.currentTimeMillis();
        initCardItemTypes();
        long t2 = System.currentTimeMillis();
        System.out.println("ShelfView initCardItemTypes Done(ms): " + (t2-t1));
        t1 = System.currentTimeMillis();
//      initCartItemActions();
        t2 = System.currentTimeMillis();
        System.out.println("ShelfView initCardItemActions Done(ms): " + (t2-t1));
        t1 = System.currentTimeMillis();
//      initConstruct();
        t2 = System.currentTimeMillis();
        System.out.println("ShelfView initConstruct Done(ms): " + (t2-t1));
        t1 = System.currentTimeMillis();
//      initEquipmentByFile();
        t2 = System.currentTimeMillis();
        System.out.println("ShelfView initEquipmentByFile Done(ms): " + (t2-t1));
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
      }
      isInitialized = true;
    }
  }

  public static URL getUrl(String aPathFileName)
  {
    URL url = null;
    try
    {
      url = ILogResourceFactory.class.getClassLoader().getResource(aPathFileName);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return url;
  }


  private static boolean readConfigParams(String filename)
  {
    boolean isFind = false;
    ShelfViewParser panelparser = new ShelfViewParser(filename);
    panelparser.loadDocument();

    Vector categoryVec = panelparser.getDeviceCategoryVec();
    if(categoryVec != null && categoryVec.size() > 0)
    {
      ShelfViewParser.DeviceCategory anDeviceCategory = (ShelfViewParser.DeviceCategory)categoryVec.elementAt(0);
      String typeStr = anDeviceCategory.getType();

      trapVec = anDeviceCategory.getTrapVec();
      dataSourceFileVec = anDeviceCategory.getResourceFileVec();

      return true;
    }
//    for(int i = 0; i < categoryVec.size(); i++)
//    {
//      ShelfViewParser.DeviceCategory anDeviceCategory = (ShelfViewParser.DeviceCategory)categoryVec.elementAt(i);
//      String typeStr = anDeviceCategory.getType();
//
//      if(typeStr.equals("FBW3000"))
//      {
//        String tmpVersion = anDeviceCategory.getVersion();
//        StringTokenizer st = new StringTokenizer(tmpVersion, ",");
//
//        while(st.hasMoreTokens())
//        {
//          String strVersion = st.nextToken();
//
//          if("3.1.0".startsWith(strVersion))
//          {
//            trapVec = anDeviceCategory.getTrapVec();
//            dataSourceFileVec = anDeviceCategory.getResourceFileVec();
//            isFind = true;
//            break;
//          }
//        }
//      }
//      if(isFind)
//      {
//        break;
//      }
//    }
    return false;
  }

  protected static void initResourceFile()
  {
    if(null == dataSourceFileVec)
    {
      return;
    }

    for(int i = 0; i < dataSourceFileVec.size(); i++)
    {
      ShelfViewParser.ResourceFile anResourceFile = (ShelfViewParser.ResourceFile)dataSourceFileVec.elementAt(i);
      if(anResourceFile.getFileType().equals("dataSourceFile") && anResourceFile.getSpModule().equals("default"))
      {
        dataSourceFile = anResourceFile.getFileName();
      }
      if(anResourceFile.getFileType().equals("configurationFile") && anResourceFile.getSpModule().equals("default"))
      {
        configurationFile = anResourceFile.getFileName();
      }
      if(anResourceFile.getFileType().equals("cardItemTypeFile") && anResourceFile.getSpModule().equals("default"))
      {
        cardItemTypeFile = anResourceFile.getFileName();
      }
      if(anResourceFile.getFileType().equals("cardItemActionFile") && anResourceFile.getSpModule().equals("default"))
      {
        cardItemActionFile = anResourceFile.getFileName();
      }
    }
  }

////create new card, port, led types
  protected static boolean initCardItemTypes()
  {
    SAXBuilder builder = new SAXBuilder();
    Document doc = null;
    try
    {
      doc = builder.build(getUrl(cardItemTypeFile));
    }
    catch(JDOMException e)
    {
      e.printStackTrace();
    }

    Element rootNode = doc.getRootElement();
    //set card vector
    String[] types = {"Card", "Port", "Led"};

    for(int i = 0; i < types.length; i++)
    {
      Element eNode = rootNode.getChild(types[i]);
      List lNode = eNode.getChildren("Type");
      Iterator it = lNode.iterator();
      while(it.hasNext())
      {
        Element eType = (Element)it.next();
        String name = eType.getAttributeValue("name");
        String imgfile = eType.getAttributeValue("imgfile");

        switch(i)
        {
          case 0:
            cardImages.put(name, createImage(name, imgfile));
            break;
          case 1:
            portImages.put(name, createImage(name, imgfile));
            break;
          case 2:
            ledImages.put(name, createImage(name, imgfile));
            break;
        }
      }
    }
    return true;
  }

  public static ImageIcon getCardImage(String cardType)
  {
    return (ImageIcon)cardImages.get(cardType);
  }

  public static ImageIcon getPortImage(String portType)
  {
    return (ImageIcon)portImages.get(portType);
  }

  public static ImageIcon getLedImage(String ledType)
  {
    return (ImageIcon)ledImages.get(ledType);
  }

  //create image for type
  protected static ImageIcon createImage(String name, String imgfile)
  {
    System.out.println("Create Type " + name + ": " + imgfile);
    URL url = ILogResourceFactory.class.getClassLoader().getResource(imgfile);
    return new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
  }
}