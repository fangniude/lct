/*
 * @(#)OpenHelpAction.java
 * Created on 2006-12-20, ????02:02:17
 *
 * Copyright 2006 (c) UTStarcom, Inc. All rights reserved.
 * UTStarcom PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.nms.helpsys.HelpUtilityHolder;

import java.awt.event.ActionEvent;

public class OpenHelpAction extends BaseAction {

    public OpenHelpAction(IApplication anApplication) {
        super(anApplication);
    }

  public void executeAction(ActionEvent e) throws Exception {
    //Check the privilege.
    if (!fApplication.isDebug()) {
        HelpUtilityHolder.showHelp();
    }
  }
}
