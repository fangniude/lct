package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.ems.epon.iad.bbs4000.formatter.r200.Dot3Onu2CtcSerialNumberFormatter;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.CheckBoxNodeRender;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.CheckTreeNode;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import org.apache.commons.collections.map.HashedMap;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class OnlineOnuTreePanel extends JPanel implements MouseListener {
    private IApplication fApplication = null;

    JTree jTree = null;
    CheckTreeNode root = null;
    int ratio = 32;
    boolean init = false;
    Dot3Onu2CtcSerialNumberFormatter formatter = new Dot3Onu2CtcSerialNumberFormatter(fApplication);

    // module ID , port ID , ONU , ONU name
    private Map<Integer, Map<Integer, Map<Integer, String>>> moduleMap;

    public OnlineOnuTreePanel(IApplication app) {
	fApplication = app;
	root = new CheckTreeNode(fApplication.getActiveDeviceManager().getDisplayName());
	ratio = new BBS4000NE(fApplication).getPonSplitRatio();
	createUI();
    }

    private void createUI() {
	jTree = new JTree(root);

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
	    loadOnlineOnu();
	    loadOnuNode();
	    init = true;
	}
    }

    private void loadOnlineOnu() {
	// clear the exist moduleMap
	moduleMap = null;

	final Dot3Onu2CtcTable meanBean = new Dot3Onu2CtcTable(fApplication.getSnmpProxy());
	Task t = new Task(){
	    @Override
	    public Object execute() throws Exception {
	        return meanBean.retrieveOnlineInfo();
	    }
	};
//	t.setWaitPrompt(fApplication.getGlobalStringMap().getString("Please wait while configuring NE"));

	Vector<Dot3Onu2CtcTable> mibBeanVector = null;
	try {
	    mibBeanVector = (Vector<Dot3Onu2CtcTable>) fApplication.getTaskManager().executeTask(t);
	} catch (Exception ex) {
	    MessageDialog.showOperationFailedDialog(fApplication);
	}

	if (mibBeanVector == null) {
	    return;
	}

	for (Dot3Onu2CtcTable dot3Onu2CtcTable : mibBeanVector) {
	    // only add on line ONU
	    if (dot3Onu2CtcTable.getUtsDot3Onu2CtcRegisterStatus() == 1) {
		buildOnlineOnu(dot3Onu2CtcTable);
	    }
	}

    }

    private void buildOnlineOnu(Dot3Onu2CtcTable dot3Onu2CtcTable) {
	int module = dot3Onu2CtcTable.getUtsDot3Onu2CtcModuleId();
	int port = dot3Onu2CtcTable.getUtsDot3Onu2CtcPortId();
	int onu = dot3Onu2CtcTable.getUtsDot3Onu2CtcLogicalPortId();
	String onuName = null;
	try {
	    onuName = (String) formatter.format(dot3Onu2CtcTable, "utsDot3Onu2CtcOnuModel");
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	// moduleMap has not exist
	if (moduleMap == null) {
	    moduleMap = new HashedMap();
	}

	// has not exist in moduleMap
	if (moduleMap != null && !moduleMap.containsKey(module)) {
	    moduleMap.put(module, new HashMap<Integer, Map<Integer, String>>());
	}

	Map<Integer, Map<Integer, String>> portMap = moduleMap.get(module);

	// has not exist in portMap
	if (portMap != null && !portMap.containsKey(port)) {
	    portMap.put(port, new HashedMap());
	}

	Map<Integer, String> onuMap = portMap.get(port);

	// has not exist in onuMap
	if (onuMap != null && !onuMap.containsKey(onu)) {
	    if (onuName != null) {
		onuMap.put(onu, onuName);
	    } else {
		onuMap.put(onu, "");
	    }
	}

    }

    public void loadOnuNode() {
	root.removeAllChildren();
	BBS4000CardMibBean bean = new BBS4000CardMibBean(fApplication.getSnmpProxy());
	Vector v = BeanService.refreshTableBean(fApplication, bean);
	ModuleType moduleType = new ModuleType();
	for (int i = 0; i < v.size(); i++) {
	    BBS4000CardMibBean one = (BBS4000CardMibBean) v.get(i);
	    int moduleBoardType = one.getUtsEponModuleBoardType().intValue();
	    int modulePhyPreStat = one.getUtsEponModulePhyPresenceStat().intValue();
	    int moduleAdminState = one.getUtsEponModuleAdminState().intValue();
	    if (moduleType.isEPMModule(moduleBoardType) && modulePhyPreStat == 1 && moduleAdminState == 2) {
		CheckTreeNode treeNode = createCardNode(one.getUtsEponModuleBoardPhyId().intValue());
		if (treeNode != null) {
		    root.add(treeNode);
		}
	    }
	}

	jTree.expandRow(0);
    }

    private CheckTreeNode createCardNode(int cardId) {
	CheckTreeNode card = null;
	if (moduleMap != null && moduleMap.containsKey(cardId)) {
	    card = new CheckTreeNode("Card " + cardId, true, false);
	    Map<Integer, Map<Integer, String>> portMap = moduleMap.get(cardId);
	    for (int i = 1; i <= 4; i++) {
		if (portMap.containsKey(i)) {
		    CheckTreeNode port = new CheckTreeNode("Port " + i);
		    Map<Integer, String> onuMap = portMap.get(i);
		    for (int j = 1; j <= ratio; j++) {
			if (onuMap.containsKey(j)) {
			    String onuName = onuMap.get(j);

			    StringBuilder stringBuilder = new StringBuilder();
			    stringBuilder.append("ONU ");
			    stringBuilder.append(j);
			    stringBuilder.append("(");
			    stringBuilder.append(onuName);
			    stringBuilder.append(")");
			    port.add(new CheckTreeNode(stringBuilder.toString()));
			}
		    }

		    card.add(port);
		}
	    }
	}
	return card;
    }

    // public String[] getSelectedOnuList()
    // {
    // return null;
    // }

    public byte[] getSelectedOnuBitMap() {
	Vector v = getSelectedOnuIndices();
	// size(byte) = 12 EPM * 8 Port * Ratio(32,64) / 8;
	int size = 6 * ratio;
	byte[] data = new byte[size];

	if (v == null || v.size() == 0) {
	    return data;
	}
	int portByteSize = ratio / 8; // 8- 1byte = 8bit
	int cardByteSize = portByteSize * 4;

	for (int i = 0; i < v.size(); i++) {
	    String str = (String) v.get(i);

	    String[] split = str.split("/");

	    int module = Integer.parseInt(split[0]);
	    int port = Integer.parseInt(split[1]);
	    int onu = Integer.parseInt(split[2]);

	    int index = (module - 1) * cardByteSize + (port - 1) * portByteSize + (onu - 1) / 8;
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
		if (nodeChild.getChildCount() == 0) {
		    list.add(getOnuIndex(nodeChild));
		} else {
		    list.addAll(getSelectedOnuIndices(jTree, nodeChild));
		}
	    } else {
		if (nodeChild.getChildCount() != 0) {
		    list.addAll(getSelectedOnuIndices(jTree, nodeChild));
		}
	    }
	}
	return list;
    }

    /**
     * get the onu index, like "1/1/1"
     * 
     * @param node
     * @return
     */
    String getOnuIndex(CheckTreeNode node) {
	String str = node.toString();
	StringBuffer sb = new StringBuffer(str.substring(str.indexOf(" ") + 1, str.indexOf("(")));

	for (int i = 0; i < 2; i++) {
	    node = (CheckTreeNode) node.getParent();
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
	if (e.getClickCount() == 1 && isInCheckBoxBound) {
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
	// jTree.updateUI();
	jTree.repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }
}