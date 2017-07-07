package com.winnertel.ems.epon.iad.bbs1000.gui.action;

import java.awt.event.ActionEvent;

import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.IEditorDialog;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.Application;
import com.winnertel.ems.epon.iad.bbs4000.constant.CommonConstant;


public class DynamicFunctionTreeNodeAction extends BaseAction
{
  protected FunctionTreeNode fNode = null;

  public DynamicFunctionTreeNodeAction(IApplication anApplication)
  {
    super(anApplication);
  }


  public final void setFunctionTreeNode(FunctionTreeNode aNode)
  {
    fNode = aNode;
  }


  /**
   * If DvM has a shelf view, this method should be overrided.
   * <p/>
   * DvM should update shelf view in this method and tell framework
   * if the shelf view should be shown.
   * <p/>
   * When the GUI style is embeded, if the return value is true,
   * the framework will show shelf view in right area and the tabbed panel
   * won't come up.
   */
  protected boolean showShelfView()
  {
    return false;
  }


  public final void executeAction(ActionEvent e)
  {
    FunctionTreeNodeObject userObject = (FunctionTreeNodeObject)fNode.getUserObject();

    switchDeviceManager(userObject);

    String id = (String)getValue(BaseAction.ID);
    if(id == null)
    {
      return;
    }

    if(userObject.getProperties() != null)
    {
      String slotId = userObject.getProperties().getProperty("slotIndex", "");
      String cardId = userObject.getProperties().getProperty("cardIndex", "");
      String portId = userObject.getProperties().getProperty(CommonConstant.CURRENT_PORT_ID, "");
      String onuId = userObject.getProperties().getProperty(CommonConstant.CURRENT_ONU_ID, "");
      String onuIndex = userObject.getProperties().getProperty(CommonConstant.CURRENT_ONU_IFINDEX, "");

      //set current tree node info
      fApplication.getActiveDeviceManager().getProperties().put(CommonConstant.CURRENT_SLOT_ID, slotId);
      fApplication.getActiveDeviceManager().getProperties().put(CommonConstant.CURRENT_CARD_ID, cardId);
      fApplication.getActiveDeviceManager().getProperties().put(CommonConstant.CURRENT_PORT_ID, portId);
      fApplication.getActiveDeviceManager().getProperties().put(CommonConstant.CURRENT_ONU_ID, onuId);
      fApplication.getActiveDeviceManager().getProperties().put(CommonConstant.CURRENT_ONU_IFINDEX, onuIndex);
    }

    try
    {
      boolean bShelfView = showShelfView();
      if(fApplication.getGUIStyle() == Application.EMBEDDED_STYLE && bShelfView)
      {
        fApplication.getMainApplet().setShelfView(fApplication.getActiveDeviceManager().getShelfViewPane());
      }
      else
      {
        // set new communities for snmp proxy
        // setCommunities( userObject );

        // show editor dialog
        IEditorDialog editorDialog = getEditorDialog();

        beforeComposeTabbedPane();
        editorDialog.compose(id);
        afterComposeTabbedPane();

        beforeShowEditorDialog();
        showEditorDialog(editorDialog);
        afterShowEditorDialog();
      }
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }

  protected IEditorDialog getEditorDialog()
  {
    return fApplication.getMainApplet().getEditorDialog();
  }

  protected void beforeComposeTabbedPane()
  {
  }

  protected void afterComposeTabbedPane()
  {
  }


  protected void beforeShowEditorDialog()
  {
  }

  protected void afterShowEditorDialog()
  {
  }


  private void switchDeviceManager(FunctionTreeNodeObject aUserObject)
  {
    if(aUserObject.getDeviceManager() != fApplication.getActiveDeviceManager())
    {
      fApplication.getMainApplet().setActiveDeviceManager(aUserObject.getDeviceManager());
    }
  }

//  private void setCommunities( FunctionTreeNodeObject aUserObject ) {
//      String readCommunity = aUserObject.getReadCommunity();
//      if (readCommunity != null) {
//          fApplication.getSnmpProxy().setReadCommunity(readCommunity);
//      }
//      String writeCommunity = aUserObject.getWriteCommunity();
//      if (writeCommunity != null) {
//          fApplication.getSnmpProxy().setWriteCommunity(writeCommunity);
//      }
//  }

  private void showEditorDialog(IEditorDialog aEditorDialog)
  {
    aEditorDialog.setTitle(fNode.getUserObject().toString());
    aEditorDialog.show();
  }
}
