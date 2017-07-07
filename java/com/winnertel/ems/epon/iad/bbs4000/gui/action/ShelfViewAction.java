package com.winnertel.ems.epon.iad.bbs4000.gui.action;

import com.winnertel.em.framework.IApplication;

public class ShelfViewAction extends DynamicFunctionTreeNodeAction {

  public ShelfViewAction(IApplication anApplication) {
      super(anApplication);
  }

  protected boolean showShelfView() {
      return true;
  }
}
