package com.winnertel.ems.epon.iad.bbs1000.gui.shelfview;

import com.winnertel.ems.epon.iad.bbs1000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs1000.MainApplet;
import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs1000.mib.ChassisConfGroup;
import com.winnertel.ems.epon.iad.bbs1000.mib.Dot3Olt2PortTable;
import com.winnertel.ems.epon.iad.bbs1000.mib.InterfaceTableMBean;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.ISession;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.security.ISecurityManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.OperationCanceledException;
import com.winnertel.em.framework.util.OperationFailedException;
import com.winnertel.em.framework.util.OperationFinishedWithoutLogException;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.task.ModifyTask;
import com.winnertel.em.standard.snmp.task.RefreshTask;
import com.winnertel.snmp.beans.SnmpTrapEvent;
import com.winnertel.snmp.beans.SnmpTrapListener;
import com.winnertel.snmp.snmp2.SnmpPDU;
import com.winnertel.tgcl.DefaultInteractor;
import com.winnertel.tgcl.PopupMenuFactory;
import com.winnertel.tgcl.background.PictureBackground;
import com.winnertel.tgcl.equipment.UEquipment;
import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.Element;
import com.winnertel.tgcl.model.Port;
import com.winnertel.tgcl.state.State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class ShelfView implements ActionListener
{
  private ILogger fLogger = LoggerController.createLogger(ShelfView.class);

  IApplication theApplication;

  private String deviceType;
  private String deviceVersion;

  //the vector containing the resource file names.
  private Vector resourceFileVec;
//  private Vector trapVec = null;
//  private Vector deviceModuleVec = null;

  //equipment data source xml file
  public String dataSourceFile;
  //data source addtional xml file
  public String configurationFile;

  //shelfview equipment
  private UEquipment equipmentComponent;

  private ShelfViewData shelfViewData;

  //selected object.
  private Properties property = null;

  public ShelfView(IApplication app)
  {
    theApplication = app;

    IDeviceManager deviceManager = theApplication.getActiveDeviceManager();
    deviceType = deviceManager.getType();
    deviceVersion = deviceManager.getVersion();
    shelfViewData = new ShelfViewData(theApplication);
    property = new Properties();

    String xmlFile = "com/winnertel/ems/epon/iad/bbs1000/gui/shelfview/shelfviewpane.xml";
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
      initConstruct();
      long t2 = System.currentTimeMillis();
      System.out.println("ShelfView initConstruct Done(ms): " + (t2 - t1));
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }

  //get the equipment
  public UEquipment getEquipment()
  {
    return equipmentComponent;
  }

  private void initResourceFile()
  {
    if(null == resourceFileVec)
    {
      return;
    }

    for(int i = 0; i < resourceFileVec.size(); i++)
    {
      ShelfViewParser.ResourceFile anResourceFile = (ShelfViewParser.ResourceFile)resourceFileVec.elementAt(i);
      if(anResourceFile.getFileType().equals("dataSourceFile") && anResourceFile.getSpModule().equals("default"))
      {
        this.dataSourceFile = anResourceFile.getFileName();
      }
      if(anResourceFile.getFileType().equals("configurationFile") && anResourceFile.getSpModule().equals("default"))
      {
        this.configurationFile = anResourceFile.getFileName();
      }
//      if(anResourceFile.getFileType().equals("cardItemTypeFile") && anResourceFile.getSpModule().equals("default"))
//      {
//        this.cardItemTypeFile = anResourceFile.getFileName();
//      }
//      if(anResourceFile.getFileType().equals("cardItemActionFile") && anResourceFile.getSpModule().equals("default"))
//      {
//        this.cardItemActionFile = anResourceFile.getFileName();
//      }
//      if(anResourceFile.getFileType().equals("shelfBackgroundFile") && anResourceFile.getSpModule().equals("default"))
//      {
//        this.shelfBackgroundFile = "com/winnertel/ems/epon/iad/bbs4000/gui/shelfview/resource/background.jpg";
//      }
    }
  }

  //construct the equipment
  private boolean initConstruct()
  {
    try
    {
      long t1 = System.currentTimeMillis();
      URL url = ShelfView.class.getResource("/com/winnertel/ems/epon/iad/bbs1000/gui/shelfview/resource/background.gif");
      PictureBackground background = new PictureBackground(url);
      equipmentComponent = new UEquipment(shelfViewData.getDataSource(), background);
      equipmentComponent.setAllowDragMove(false);

      System.out.println("new IlpEquipment: " + (System.currentTimeMillis() - t1));

      DefaultInteractor interactor = new DefaultInteractor(equipmentComponent);
      interactor.setPopupMenuFactory(new DefaultPopupMenuFactory(this));
      equipmentComponent.setInteractor(interactor);

      //add popup menu

      //set the toolbar invisible of the equipment view
      equipmentComponent.setToolbarVisible(false);

      equipmentComponent.getCanvasScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      equipmentComponent.getCanvasScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

      theApplication.getSnmpProxy().addTrapListener(new SnmpTrapListener()
      {
        public void receivedTrap(SnmpTrapEvent trapevent)
        {
          //refresh the shelfview according to the trap
          SnmpPDU pdu = trapevent.getTrapPDU();
          System.out.println("Received a Trap: " + pdu);
          update(pdu);

        }
      });

      return true;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }

  //create popup menus according to the selected object
  JPopupMenu createContextualPopup(JComponent component, Element element, Point2D d)
  {
    String selectedObjectType = null;
    if(element == null)
    {
      property.setProperty("type", "shelf");
      JPopupMenu popMenu = new JPopupMenu();

      JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
      item.setActionCommand("Refresh");
      item.addActionListener(this);

      return popMenu;
    }

    if(element instanceof Card)
    {
      Card card = (Card)element;
      selectedObjectType = card.getTypeInfo().getName();

      property.setProperty("type", "card");
      property.setProperty("slotId", (String)card.getUserObject());
      // Create an empty popup menu
      JPopupMenu popMenu = new JPopupMenu();

      if(selectedObjectType.startsWith("LTM"))
      {
//        IltOSIObjectState state = (IltOSIObjectState)card.getObjectState();
//        if(state.getState().getAdministrativeState() == IltOSI.State.Administrative.Unlocked)
//        {
//          JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Lock"));
//          item.setActionCommand("Lock_Card");
//          item.addActionListener(this);
//        }
//        else
//        {
//          JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Unlock"));
//          item.setActionCommand("Unlock_Card");
//          item.addActionListener(this);
//        }

        JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Reset"));
        item.setActionCommand("Reset_Card");
        item.addActionListener(this);

        item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
        item.setActionCommand("Refresh");
        item.addActionListener(this);

        return popMenu;
      }
      else if (selectedObjectType.startsWith("CSM") ){
          JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
          item.setActionCommand("Refresh");
          item.addActionListener(this);

          item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Reset"));
          item.setActionCommand("Reset_Card");
          item.addActionListener(this);

          return popMenu;
      }
      else// if(selectedObjectType.startsWith("CSM") || selectedObjectType.equalsIgnoreCase("EMPTY"))
      {
        JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Refresh"));
        item.setActionCommand("Refresh");
        item.addActionListener(this);

        return popMenu;
      }
    }
    else if(element instanceof Port)
    {
      Port port = (Port)element;
      selectedObjectType = port.getTypeInfo().getName();

      //only the ports on GEM or EPM card are operational.
      if(selectedObjectType.startsWith("GSM") || selectedObjectType.startsWith("LTM"))
      {
        property.setProperty("type", "port");
        property.setProperty("portId", (String)element.getUserObject());
        property.setProperty("portType", selectedObjectType);

        // Create an empty popup menu
        JPopupMenu popMenu = new JPopupMenu();

        if(isMatchedState(port, ILogResourceFactory.LOCKED))
        {
          JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Unlock"));
          item.setActionCommand("Unlock_Port");
          item.addActionListener(this);
        }
        else
        {
          JMenuItem item = popMenu.add(theApplication.getActiveDeviceManager().getGuiComposer().getString("Lock"));
          item.setActionCommand("Lock_Port");
          item.addActionListener(this);
        }

        return popMenu;
      }
    }

    return null;
  }
  private boolean isMatchedState(Element e, State aState){
      List states = e.getAllStates();
      for(int j=0;states != null && j<states.size();j++){
          State s = (State)states.get(j);
          return (s != null && s.equals(aState));
      }
      return false;
  }

  private boolean readConfigParams(String filename)
  {
    boolean isFind = false;
    ShelfViewParser panelparser = new ShelfViewParser(filename);
    panelparser.loadDocument();

    Vector categoryVec = panelparser.getDeviceCategoryVec();
    for(int i = 0; i < categoryVec.size(); i++)
    {
      ShelfViewParser.DeviceCategory anDeviceCategory = (ShelfViewParser.DeviceCategory)categoryVec.elementAt(i);
      String typeStr = anDeviceCategory.getType();

      if(typeStr.equals(deviceType))
      {
        resourceFileVec = anDeviceCategory.getResourceFileVec();
//            deviceModuleVec = anDeviceCategory.getDeviceModuleVec();
        isFind = true;
        break;
      }
    }
    return isFind;
  }

  private boolean checkPermission(String anActionId)
  {
    if(theApplication.isDebug() || anActionId == null || anActionId.length() == 0)
    {
      return true;
    }

    final ISecurityManager securityManager = theApplication.getSecurityManager();
    final ISession session = theApplication.getSession();
    if(!securityManager.isAuthorized(session, anActionId))
    {
      MessageDialog.showPermissionDeniedDialog(theApplication);
      return false;
    }
    else
    {
      return true;
    }
  }

  private void writeOperationLog(String action, boolean isCompleted)
  {
    try
    {
      ILogInfo logInfo = theApplication.getLogManager().getLogInfo(action);
      if(logInfo != null)
      {
        if(isCompleted)
        {
          logInfo.setStatus(ILogInfo.COMPLETED);
        }
        else
        {
          logInfo.setStatus(ILogInfo.FAILED);
        }
        theApplication.getLogManager().writeLog(logInfo);
      }
    }
    catch(Exception ex)
    {
//      ex.printStackTrace();
      fLogger.error("Failed to write operation log", ex);
    }
  }

  public void actionPerformed(ActionEvent actionEvent)
  {
    String actionId = actionEvent.getActionCommand();
    if(checkPermission(actionId))
    {
      boolean completed = false;
      try
      {
        executeAction(actionId);
        completed = true;
      }
      catch(OperationCanceledException ex)
      {
        return;
      }
      catch(OperationFinishedWithoutLogException ex)
      {
        return;
      }
      catch(OperationFailedException ex)
      {
        fLogger.error("Operation failed: action id=" + actionId, ex);
      }
      catch(Exception ex)
      {
        fLogger.error("Error in executing action: action id=" + actionId, ex);
      }
      writeOperationLog(actionId, completed);
    }
  }

  private void executeAction(String action) throws Exception
  {
    String type = property.getProperty("type", "");
    if(type.equals("shelf"))
    {
      try
      {
        Task task = new Task(){
          public Object execute() throws Exception {
              refresh();
              return null;
          }
        };

        theApplication.getTaskManager().executeTask(task);

        //refresh the left function tree.
        MainApplet applet = (MainApplet)theApplication.getMainApplet();
        applet.refreshGuiComponent(theApplication.getActiveDeviceManager());
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    else if(type.equals("card"))
    {
      String slotId = property.getProperty("slotId");
      SnmpMibBean bean = null;
      if(slotId.indexOf("PWR") != -1)
      {
        if(action.equals("Refresh"))
        {
          try
          {
            bean = new ChassisConfGroup(theApplication.getSnmpProxy());
            RefreshTask task = new RefreshTask(bean);
            theApplication.getTaskManager().executeTask(task);
            shelfViewData.update(bean);
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }

          //return without log.
          throw new OperationFinishedWithoutLogException();  //don't write the operation log.
        }
        else
        {
          throw new OperationCanceledException("Not Supported Command: " + action);
        }
      }
      else
      {
        bean = new BBS1000CardMibBean(theApplication.getSnmpProxy());
        ((BBS1000CardMibBean)bean).setUtsEponModuleBoardPhyId(new Integer(property.getProperty("slotId")));
        if(action.equals("Reset_Card"))
        {
          ((BBS1000CardMibBean)bean).setUtsEponModuleBoardAction(new Integer(1));  //1-reset

        }
        else if(action.equals("Refresh"))
        {
          try
          {
            RefreshTask task = new RefreshTask(bean);
            theApplication.getTaskManager().executeTask(task);
            shelfViewData.update(bean);
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }

          //return without log.
          throw new OperationFinishedWithoutLogException();  //don't write the operation log.
        }
        else
        {
          throw new OperationCanceledException("Not Supported Command: " + action);
        }
      }

      // prompt user for confirmation
      if(!MessageDialog.showConfirmOperationDialog(theApplication))
      {
        throw new OperationCanceledException("Operation is canceled by user.");
      }

      ModifyTask task = new ModifyTask(bean);
      Boolean b = (Boolean)theApplication.getTaskManager().executeTask(task);
      if(b.equals(Boolean.TRUE))
      {
        //retrieve the card data from NE and update the shelfview.
        bean.retrieve();
        shelfViewData.update(bean);
      }
    }
    else if(type.equals("port"))
    {
      String portId = property.getProperty("portId");

      SnmpMibBean bean = null;
      String portType = property.getProperty("portType");
      if(portType.equals("GSM"))
      {
        bean = new InterfaceTableMBean(theApplication.getSnmpProxy());
        ((InterfaceTableMBean)bean).setIfIndex(new Integer(ConfigUtility.generateIfIndex(portId)));
        if(action.equals("Lock_Port"))
        {
          ((InterfaceTableMBean)bean).setIfAdminStatus(new Integer(2));  //2-down
        }
        else if(action.equals("Unlock_Port"))
        {
          ((InterfaceTableMBean)bean).setIfAdminStatus(new Integer(1));  //1-up
        }
        else
        {
          throw new OperationCanceledException("Not Supported Command: " + action);
        }
      }
      else
      {
        bean = new Dot3Olt2PortTable(theApplication.getSnmpProxy());
        String[] split = portId.split("/");
        ((Dot3Olt2PortTable)bean).setUtsDot3OltModuleId(new Integer(split[0]));
        ((Dot3Olt2PortTable)bean).setUtsDot3OltDeviceId(new Integer(1));
        ((Dot3Olt2PortTable)bean).setUtsDot3OltPortId(new Integer(split[1]));
        if(action.equals("Lock_Port"))
        {
          ((Dot3Olt2PortTable)bean).setUtsDot3OltAdminStatus(new Integer(2));  //2-down
        }
        else if(action.equals("Unlock_Port"))
        {
          ((Dot3Olt2PortTable)bean).setUtsDot3OltAdminStatus(new Integer(1));  //1-up
        }
        else
        {
          throw new OperationCanceledException("Not Supported Command: " + action);
        }
      }

      // prompt user for confirmation
      if(!MessageDialog.showConfirmOperationDialog(theApplication))
      {
        throw new OperationCanceledException("Apply action canceled");
      }

      ModifyTask task = new ModifyTask(bean);
      Boolean b = (Boolean)theApplication.getTaskManager().executeTask(task);
      if(b.equals(Boolean.TRUE))
      {
        shelfViewData.update(bean);
      }
    }
    else
    {
      throw new OperationCanceledException("Not Supported Type: " + type);
    }
  }

  private void update(SnmpPDU pdu)
  {
/*
    <!-- linkdown -->
    <Trap mibid=".1.3.6.1.6.3.1.1.5.3"></Trap>
    <!-- linkup -->
    <Trap mibid=".1.3.6.1.6.3.1.1.5.4"></Trap>

    <!-- utsFanNormal -->
    <Trap mibid=".1.3.6.1.4.1.41355.1.3.10.200.6.3.1.0.36"></Trap>
    <!-- utsFanAbnormal -->
    <Trap mibid=".1.3.6.1.4.1.41355.1.3.10.200.6.3.1.0.38"></Trap>

    <!-- utsBBS4000CardInsertAlarm -->
    <Trap mibid=".1.3.6.1.4.1.41355.1.3.10.200.6.3.1.0.36"></Trap>
    <!-- utsBBS4000CardRemoveAlarm -->
    <Trap mibid=".1.3.6.1.4.1.41355.1.3.10.200.6.3.1.0.38"></Trap>
*/
    String type = pdu.getVariable(1).getVarObject().toString();
    if(type.equals(".1.3.6.1.6.3.1.1.5.3") || type.equals(".1.3.6.1.6.3.1.1.5.4")) //linkdown/linkup
    {
      InterfaceTableMBean bean = new InterfaceTableMBean(theApplication.getSnmpProxy());
      bean.setIfIndex(new Integer(pdu.getVariableBinding(2).getVariable().toString()));
      bean.setIfAdminStatus(new Integer(pdu.getVariableBinding(3).getVariable().toString()));
    }
    else if(type.equals(".1.3.6.1.4.1.41355.1.3.10.200.6.3.1.0.36")) //utsBBS4000CardInsertAlarm
    {
      BBS1000CardMibBean bean = new BBS1000CardMibBean(theApplication.getSnmpProxy());
      bean.setUtsEponModuleBoardPhyId(new Integer(pdu.getVariableBinding(9).getVariable().getVarObject().toString()));
      bean.setUtsEponModuleBoardType(new Integer(pdu.getVariableBinding(10).getVariable().getVarObject().toString()));
      bean.setUtsEponModuleBoardState(new Integer(3)); //installed
    }
    else if(type.equals(".1.3.6.1.4.1.41355.1.3.10.200.6.3.1.0.38")) //utsBBS4000CardRemoveAlarm
    {
      BBS1000CardMibBean bean = new BBS1000CardMibBean(theApplication.getSnmpProxy());
      bean.setUtsEponModuleBoardPhyId(new Integer(pdu.getVariableBinding(9).getVariable().getVarObject().toString()));
      bean.setUtsEponModuleBoardType(new Integer(pdu.getVariableBinding(10).getVariable().getVarObject().toString()));
      bean.setUtsEponModuleBoardState(new Integer(4)); //uninstalled
    }
    else
    {
    }

  }

  public void refresh()
  {
    shelfViewData.update();
    ShelfView.this.equipmentComponent.setDataBox(shelfViewData.getDataSource(), true);

//    try
//    {
//      Task task = new Task(){
//        public Object execute() throws Exception {
//            shelfViewData.update();
//            return null;
//        }
//      };
//
//      theApplication.getTaskManager().executeTask(task);
//    }
//    catch(Exception e)
//    {
//      e.printStackTrace();
//    }
  }
}

class DefaultPopupMenuFactory implements PopupMenuFactory
{
  protected ShelfView shelfView = null;

  public DefaultPopupMenuFactory(ShelfView shelfView)
  {
    this.shelfView = shelfView;
  }

  public JPopupMenu createPopupMenu(JComponent component, Element element, Point2D d) {
    return shelfView.createContextualPopup(component, element, d);
  }
}