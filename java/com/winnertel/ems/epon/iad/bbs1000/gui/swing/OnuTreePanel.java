package com.winnertel.ems.epon.iad.bbs1000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs1000.model.BBS1000NE;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.CheckBoxNodeRender;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.CheckTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * To change this template use File | Settings | File Templates.
 */
public class OnuTreePanel extends JPanel implements MouseListener {
  private IApplication fApplication = null;

  JTree jTree = null;
  CheckTreeNode root = null;
  int ratio = 32;
  boolean init = false;
  
  public OnuTreePanel(IApplication app) {
    fApplication = app;
    root = new CheckTreeNode(fApplication.getActiveDeviceManager().getDisplayName());
    ratio = new BBS1000NE(fApplication).getPonSplitRatio();
    createUI();
    loadOnuNode();
  }

  private void createUI() {
	CheckTreeNode rootNode = new CheckTreeNode("root");
    rootNode.add(root);
    jTree = new JTree(rootNode);

    jTree.addMouseListener(this);
    JScrollPane treeView = new JScrollPane(jTree);
    jTree.setCellRenderer(new CheckBoxNodeRender());
    jTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

    NTLayout layout = new NTLayout(1, 1, NTLayout.FILL, NTLayout.FILL, 5, 5);
    this.setLayout(layout);
    this.setPreferredSize(new Dimension(250, 300));
    add(treeView);
  }
  
  public void init() {
	if (!init) {
	  loadOnuNode();
	  init = true;
	}
  }

  public void loadOnuNode() {
    root.removeAllChildren();

    BBS1000NE ne = new BBS1000NE(fApplication);
    Vector v = ne.getEPMCardList();
    for (int i = 0; i < v.size(); i++) {
      root.add(createCardNode(Integer.parseInt((String)v.get(i))));
    }

    jTree.expandRow(0);
    jTree.setRootVisible(false);
  }

  private CheckTreeNode createCardNode(int cardId)
  {
    CheckTreeNode card = new CheckTreeNode("Card " + cardId, true, false);
    for(int i = 1; i <= 4; i++)
    {
      CheckTreeNode port = new CheckTreeNode("Port " + i);
      for(int j = 1; j <= ratio; j++)
      {
        port.add(new CheckTreeNode("ONU " + j));
      }

      card.add(port);
    }
    return card;
  }

//  public String[] getSelectedOnuList()
//  {
//    return null;
//  }

  public byte[] getSelectedOnuBitMap()
  {
    Vector v = getSelectedOnuIndices();
    //size(byte) = 2 EPM * 4 Port * Ratio(32,64) / 8;
    int size = ratio;
    byte[] data = new byte[size];

    if (v == null || v.size() == 0) {
        return data;
    }
    int portByteSize = ratio / 8; //8- 1byte = 8bit
    int cardByteSize = portByteSize * 4;

    for (int i = 0; i < v.size(); i++) {
      String str = (String) v.get(i);

      String[] split = str.split("/");

      int module = Integer.parseInt(split[0]);
      int port = Integer.parseInt(split[1]);
      int onu = Integer.parseInt(split[2]);

      int index = (module - 1) * cardByteSize + (port - 1)* portByteSize + (onu - 1) / 8 ;
      int n = (onu - 1) % 8;
      int value = data[index] + (int) Math.pow(2, n);
      data[index] = (byte) value;
    }

    return data;
  }

  public Vector getSelectedOnuIndices() {
    return getSelectedOnuIndices(jTree, root);
  }

  private Vector getSelectedOnuIndices(JTree jTree, CheckTreeNode node) {
    Vector list = new Vector();
    for (int i = 0; i < node.getChildCount(); i++) {
      CheckTreeNode nodeChild = (CheckTreeNode) node.getChildAt(i);
      if (nodeChild.isSelected()) {
        if (nodeChild.getChildCount() == 0)
        {
          list.add(getOnuIndex(nodeChild));
        }
        else
        {
          list.addAll(getSelectedOnuIndices(jTree, nodeChild));
        }
      } else {
        if (nodeChild.getChildCount() != 0)
        {
          list.addAll(getSelectedOnuIndices(jTree, nodeChild));
        }
      }
    }
    return list;
  }

  /**
   * get the onu index, like "1/1/1"
   * @param node
   * @return
   */
  String getOnuIndex(CheckTreeNode node) {
    String str = node.toString();
    StringBuffer sb = new StringBuffer(str.substring(str.indexOf(" ") + 1));

    for(int i = 0; i < 2; i++)
    {
      node = (CheckTreeNode)node.getParent();
      str = node.toString();
      sb.insert(0, "/").insert(0, str.substring(str.indexOf(" ") + 1));
    }

    return sb.toString();
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
    CheckBoxNodeRender celleditor = (CheckBoxNodeRender) jTree.getCellRenderer();
    boolean isInCheckBoxBound = celleditor.isInCellCheckBoxBound(jTree, e.getX(), e.getY());
    if(e.getClickCount() == 1 && isInCheckBoxBound)
    {
      int x = e.getX();
      int y = e.getY();
      int row = jTree.getRowForLocation(x, y);
      TreePath path = jTree.getPathForRow(row);
      if (path != null) {
        CheckTreeNode node = (CheckTreeNode) path.getLastPathComponent();
        node.setSelected(!node.isSelected());
        ((DefaultTreeModel) jTree.getModel()).nodeChanged(node);
        if (row == 0) {
          jTree.revalidate();
          jTree.repaint();
        }
      }
    }
    jTree.repaint();
  }

  public void mouseReleased(MouseEvent e) {
  }
}