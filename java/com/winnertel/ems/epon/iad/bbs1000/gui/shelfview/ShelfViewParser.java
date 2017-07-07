package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview;

import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import java.net.URL;

import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

public class ShelfViewParser
{
  String filename = null;

  public class DeviceCategory
  {
    private String type;
    private String version;
    private Vector trapVec = new Vector();
    private Vector deviceModuleVec = new Vector();
    private Vector resourceFileVec = new Vector();

    public DeviceCategory()
    {
    }

    public String getType()
    {
      return type;
    }

    public String getVersion()
    {
      return version;
    }

    public Vector getTrapVec()
    {
      return trapVec;
    }

    public Vector getDeviceModuleVec()
    {
      return deviceModuleVec;
    }

    public Vector getResourceFileVec()
    {
      return resourceFileVec;
    }

    public void setType(String _inpara)
    {
      type = _inpara;
    }

    public void setVersion(String _inpara)
    {
      version = _inpara;
    }

    public void setTrapVec(Vector _inpara)
    {
      trapVec = _inpara;
    }

    public void setDeviceModuleVec(Vector _inpara)
    {
      deviceModuleVec = _inpara;
    }

    public void setResourceFileVec(Vector _inpara)
    {
      resourceFileVec = _inpara;
    }
  }

  public class DeviceModule
  {
    private String name;
    private String optional;
    private Vector deviceObjectVec = new Vector();

    public DeviceModule()
    {
    }

    public String getName()
    {
      return name;
    };
    public String getOptional()
    {
      return optional;
    };
    public Vector getDeviceObjectVec()
    {
      return deviceObjectVec;
    };
    public void setName(String _inpara)
    {
      name = _inpara;
    };
    public void setOptional(String _inpara)
    {
      optional = _inpara;
    };
    public void setDeviceObjectVec(Vector _inpara)
    {
      deviceObjectVec = _inpara;
    };
  }


  public class DeviceObject
  {
    private String id;
    private String category;
    private String onLook;
    private String offLook;

    public DeviceObject()
    {
    }

    public String getId()
    {
      return id;
    }

    public String getCategory()
    {
      return category;
    }

    public String getOnLook()
    {
      return onLook;
    }

    public String getOffLook()
    {
      return offLook;
    }

    public void setId(String _inpara)
    {
      id = _inpara;
    }

    public void setCategory(String _inpara)
    {
      category = _inpara;
    }

    public void setOnLook(String _inpara)
    {
      onLook = _inpara;
    }

    public void setOffLook(String _inpara)
    {
      offLook = _inpara;
    }
  }

  public class ResourceFile
  {
    private String filetype;
    private String spmodule;
    private String filename;

    public ResourceFile()
    {
    }

    public String getFileType()
    {
      return filetype;
    }

    public String getSpModule()
    {
      return spmodule;
    }

    public String getFileName()
    {
      return filename;
    }

    public void setFileType(String _inpara)
    {
      filetype = _inpara;
    }

    public void setSpModule(String _inpara)
    {
      spmodule = _inpara;
    }

    public void setFileName(String _inpara)
    {
      filename = _inpara;
    }
  }

  private Vector deviceCategoryVec = new Vector();

  public Vector getDeviceCategoryVec()
  {
    return deviceCategoryVec;
  }

  private DeviceCategory curDeviceCategory;
  private DeviceModule curDeviceModule;
  private DeviceObject curDeviceObject;
  private ResourceFile curResourceFile;
  private Vector curDeviceModuleVec;
  private Vector curDeviceObjectVec;
//  private Vector curResorceFileVec;

  public ShelfViewParser()
  {
  }

  public ShelfViewParser(String sXmlFile)
  {
    filename = sXmlFile;
  }

  URL getUrl(String filename)
  {
    URL url = getClass().getClassLoader().getResource(filename);
    return url;
  }

  public void loadDocument()
  {
    SAXBuilder builder = new SAXBuilder();
    Element rootnode = null;
    try
    {
      URL url = getUrl(filename);
      if(url == null)
      {
        return;
      }
      Document doc = builder.build(url);
      rootnode = doc.getRootElement();
    }
    catch(JDOMException e)
    {
      e.printStackTrace();  //To change body of catch statement use Options | File Templates.
    }

    List lDevice = rootnode.getChildren("Device");
    Iterator it = lDevice.iterator();
    while(it.hasNext())
    {
      Element eDevice = (Element)it.next();
      curDeviceCategory = new DeviceCategory();
      curDeviceCategory.setType((String)eDevice.getAttributeValue("type"));
      curDeviceCategory.setVersion((String)eDevice.getAttributeValue("version"));

      deviceCategoryVec.add(curDeviceCategory);
      curDeviceModuleVec = new Vector();
      curDeviceCategory.setDeviceModuleVec(curDeviceModuleVec);

      List lModule = eDevice.getChildren("Module");
      Iterator itmd = lModule.iterator();
      while(itmd.hasNext())
      {
        Element eModule = (Element)itmd.next();

        curDeviceModule = new DeviceModule();
        curDeviceModule.setName((String)eModule.getAttributeValue("name"));
        curDeviceModule.setOptional((String)eModule.getAttributeValue("optional"));
        curDeviceModuleVec.add(curDeviceModule);

        curDeviceObjectVec = new Vector();
        curDeviceModule.setDeviceObjectVec(curDeviceObjectVec);

        List lObject = eModule.getChildren("Object");
        Iterator itobj = lObject.iterator();
        while(itobj.hasNext())
        {
          Element eObject = (Element)itobj.next();

          curDeviceObject = new DeviceObject();
          curDeviceObject.setId((String)eObject.getAttributeValue("id"));
          curDeviceObject.setCategory((String)eObject.getAttributeValue("category"));
          curDeviceObject.setOnLook((String)eObject.getAttributeValue("onType"));
          curDeviceObject.setOffLook((String)eObject.getAttributeValue("offType"));
          curDeviceObjectVec.add(curDeviceObject);
        }
      }

      //parse all trap oids
      List lTrap = eDevice.getChildren("Trap");
      Iterator itTrap = lTrap.iterator();
      while(itTrap.hasNext())
      {
        Element eTrap = (Element)itTrap.next();
        curDeviceCategory.getTrapVec().add((String)eTrap.getAttributeValue("mibid"));
      }
      //parse all kinds of resource file for shlefview
      List lFile = eDevice.getChildren("File");
      Iterator itFile = lFile.iterator();
      while(itFile.hasNext())
      {
        Element eFile = (Element)itFile.next();
        curResourceFile = new ResourceFile();
        curResourceFile.setFileType((String)eFile.getAttributeValue("type"));
        curResourceFile.setSpModule((String)eFile.getAttributeValue("spmodule"));
        curResourceFile.setFileName((String)eFile.getAttributeValue("name"));
        curDeviceCategory.getResourceFileVec().add(curResourceFile);
      }
    }
  }
}
