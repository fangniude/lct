package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Enumeration;

public class CheckTreeNode extends DefaultMutableTreeNode {
  public final static int SINGLE_SELECTION = 0;
  public final static int DIG_IN_SELECTION = 4;
  public boolean isSelected;

  public CheckTreeNode(Object userObject) {
    this(userObject, true, false);
  }

  public CheckTreeNode(Object userObject, boolean allowsChildren
                       , boolean isSelected) {
    super(userObject, allowsChildren);
    this.isSelected = isSelected;
  }

  public void setSelected(boolean isSelected) {
    this.isSelected = isSelected;

    if (children != null) {
      Enumeration enums = children.elements();
      while (enums.hasMoreElements()) {
        CheckTreeNode node = (CheckTreeNode) enums.nextElement();
        node.setSelected(isSelected);
      }
    }

    setParenetSelected(this);
  }

  protected void setPureSelected(boolean isSelected)
  {
    this.isSelected = isSelected;
  }

  protected void setParenetSelected(CheckTreeNode node) {
    CheckTreeNode parentNode = (CheckTreeNode) node.getParent();
    if (parentNode == null) {
      return;
    }

    boolean isSelected = true;
    Enumeration elements = parentNode.children();
    if (elements == null) {
      return;
    }
    while (elements.hasMoreElements()) {
      CheckTreeNode brotherNode = (CheckTreeNode) elements.nextElement();
      if (!brotherNode.isSelected()) {
        isSelected = false;
        break;
      }
    }

    parentNode.setPureSelected(isSelected);
    setParenetSelected(parentNode);
  }

  public boolean isSelected() {
    return isSelected;
  }
}