package com.winnertel.ems.epon.iad.inventory.gui;

import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.IADManager;
import com.winnertel.ems.epon.iad.inventory.model.InventoryDataResource;
import com.winnertel.ems.epon.iad.inventory.model.InventoryTreeModel;
import com.winnertel.ems.epon.iad.inventory.model.NENode;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InventoryPanel extends JDialog {
	private JButton jBtOk;
	private JTree ftrFilterTree = new JTree();
  private IADManager manager ;
  private IStringMap fStringMap;

  public InventoryPanel(IADManager manager,IStringMap aStringMap, boolean modal) {
    super((JFrame)manager.getOmcdParmMap().get("parentFrame"),aStringMap.getString("IAD Management"), modal);
    fStringMap = aStringMap;
    this.manager = manager ;
    layoutComponents();
  }

  public void setInventoryDataSource(InventoryDataResource dataSource)
  {
		ftrFilterTree.setModel(new InventoryTreeModel(dataSource.getRootNode()));
	}

	private void layoutComponents() {
		getContentPane().setLayout(new BorderLayout());
		try {
			getContentPane().add(getFilterTreePanel(), BorderLayout.CENTER);
			getContentPane().add(getButtonPanel(), BorderLayout.SOUTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel getFilterTreePanel() {
    NENode node = new NENode(manager.getNodeName(), manager.getNodeLabel());
    ftrFilterTree.setModel(new InventoryTreeModel(node));

    //ftrFilterTree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    ftrFilterTree.putClientProperty("JTree.lineStyle", "Angled");
    //InventoryNodeRenderer renderer = new InventoryNodeRenderer();
    //ftrFilterTree.setCellRenderer(renderer);
    ftrFilterTree.addMouseListener(new InventoryTreeMouseAdapter(manager,
        ftrFilterTree));

		JPanel filterTree = new JPanel(new NTLayout(1, 1));
		//filterTree.add(jlbCurrentLevel);
		TitledBorder aTitleBorder = new TitledBorder(new EtchedBorder(
				EtchedBorder.RAISED, Color.white, new Color(148, 145, 140)),
				fStringMap.getString("Inventory"));
		filterTree.setBorder(aTitleBorder);
		JScrollPane spane = new JScrollPane(ftrFilterTree);
		spane.setPreferredSize(new Dimension(400, 600));
		filterTree.add(spane);
		return filterTree;
	}

	private JPanel getButtonPanel() throws Exception {
		JPanel aPanel = new JPanel();
		aPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.jBtOk = new JButton(new OkAction());
		aPanel.add(this.jBtOk);

		return aPanel;
	}

  public void dispose()
  {
    NENode node = new NENode(manager.getNodeName(), manager.getNodeLabel());
    ftrFilterTree.setModel(new InventoryTreeModel(node));
    
    super.dispose();
  }
	class OkAction extends AbstractAction {
		public OkAction() {
			super(fStringMap.getString("Close"));
		}

		public void actionPerformed(ActionEvent e) {
			doOk();
		}
	}

	private void doOk() {
		this.setVisible(false);
		this.dispose();

	}

	public static void main(String[] args) {
		/*try {
			JFrame aFrame = new JFrame();
			InventoryPanel aPanel = new InventoryPanel(aFrame, "Title", true,
					new InventoryDataResource("10.240.100.200",new Vector()));
			aPanel.setLocation(250, 250);
			aPanel.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
