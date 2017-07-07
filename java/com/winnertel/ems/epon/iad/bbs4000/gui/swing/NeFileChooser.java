package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.ems.epon.gui.util.GUIUtilities;
import com.winnertel.ems.epon.iad.util.GuiUtils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class NeFileChooser extends JDialog implements ActionListener
{
//  public static final int FILES_ONLY = 1;
//  public static final int DIRECTORIES_ONLY = 2;
//  public static final int FILES_AND_DIRECTORIES = 3;

  protected IApplication fApplication;
  protected NeFileSystem fileSystem;
  private DefaultMutableTreeNode rootNode;
  NeFileSystem.File selectedFile = null;
//  int selectionMode = FILES_ONLY;

  private JPanel jPanel = null;
  private JScrollPane scrollPane = null;
  private JPanel buttonPanel = null;
  private JTree fileTree = null;
  private JButton okButton = null;
  private JButton cancelButton = null;

  public NeFileChooser(IApplication theApplication)
  {
    fApplication = theApplication;
    fileSystem = new NeFileSystem(fApplication);
    initialize();
    init();
  }

  public NeFileChooser(IApplication theApplication, Dialog dialog)
  {
    super(dialog, true);

    fApplication = theApplication;
    fileSystem = new NeFileSystem(fApplication);
    initialize();
    init();
  }

  public NeFileChooser(IApplication theApplication, Frame frame)
  {
    super(frame, true);

    fApplication = theApplication;
    fileSystem = new NeFileSystem(fApplication);
    initialize();
    init();
  }

  public NeFileChooser(IApplication theApplication, Dialog dialog, String[] tgtDirs)
  {
    super(dialog, true);

    fApplication = theApplication;
    fileSystem = new NeFileSystem(fApplication);
    initialize();
    init( tgtDirs );
  }
  
  public NeFileChooser(IApplication theApplication, Dialog dialog, String[] tgtDirs, NeFileSystem nf )
  {
    super(dialog, true);

    fApplication = theApplication;
    fileSystem = nf;
    initialize();
    init( tgtDirs );
  }

  private void init()
  {
    String[] dirs = new String[]{"flash:", "nvm:"};
    try
    {
      for(int i = 0; i < dirs.length; i++)
      {
        NeFileSystem.File file = new NeFileSystem.File(dirs[i]);
        file.setDirectory(true);

        buildFileTree(rootNode, file);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    fileTree.expandRow(0);
  }

  private void init(String[] tgtDirs)
  {
	String[] dirs = new String[]{"flash:", "nvm:"}; 
	if( tgtDirs != null && tgtDirs.length != 0 ) {
		dirs = tgtDirs;
	}

    try
    {
      for(int i = 0; i < dirs.length; i++)
      {
        NeFileSystem.File file = new NeFileSystem.File(dirs[i]);
        file.setDirectory(true);

        buildFileTree(rootNode, file);
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    fileTree.expandRow(0);
  }

  private void buildFileTree(DefaultMutableTreeNode node, NeFileSystem.File file) throws IOException
  {
    DefaultMutableTreeNode dirNode = new DefaultMutableTreeNode(file);
    node.add(dirNode);

    if(file.isDirectory())
    {
      NeFileSystem.File[] list = fileSystem.list(file);
      for(int i = 0; i < list.length; i++)
      {
        if(list[i].isDirectory())
          buildFileTree(dirNode, list[i]);
        else
          dirNode.add(new DefaultMutableTreeNode(list[i]));
      }
    }
  }

  public void show()
  {
    selectedFile = null;
    super.show();
  }

  public NeFileSystem.File getSelectedFile()
  {
    return selectedFile;
  }

//  public String[] getSelectedFiles()
//  {
//    return null;
//  }

//  public int getFileSelectionMode()
//  {
//    return selectionMode;
//  }
//
//  public void setFileSelectionMode(int mode)
//  {
//    this.selectionMode = mode;
//  }
  /**
   * This method initializes this
   *
   */
  private void initialize() {
    rootNode = new DefaultMutableTreeNode(fApplication.getActiveDeviceManager().getDisplayName());
    this.setTitle(fApplication.getGlobalStringMap().getString("Select_File"));
    this.setSize(new Dimension(400, 400));
    this.setContentPane(getJPanel());
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    if(this.getParent() != null)
      GuiUtils.centerFrameDialog((JDialog)this.getParent(), this);
    else
      GUIUtilities.centerDesktopDialog(this);
  }

  /**
   * This method initializes jPanel
   *
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel()
  {
    if (jPanel == null)
    {
      jPanel = new JPanel();
      jPanel.setLayout(new BorderLayout());
      jPanel.add(getScrollPane(), BorderLayout.CENTER);
      jPanel.add(getJPanel1(), BorderLayout.SOUTH);
    }
    return jPanel;
  }
  /**
   * This method initializes jScrollPane
   *
   * @return javax.swing.JScrollPane
   */
  private JScrollPane getScrollPane()
  {
    if (scrollPane == null)
    {
      scrollPane = new JScrollPane();
      scrollPane.setViewportView(getFileTree());
    }
    return scrollPane;
  }
  /**
   * This method initializes jPanel1
   *
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel1()
  {
    if (buttonPanel == null)
    {
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new GridBagLayout());
      buttonPanel.add(getOkButton(), new GridBagConstraints());
      buttonPanel.add(getCancelButton(), new GridBagConstraints());
    }
    return buttonPanel;
  }
  /**
   * This method initializes jTree
   *
   * @return javax.swing.JTree
   */
  private JTree getFileTree()
  {
    if (fileTree == null)
    {
      fileTree = new JTree(rootNode);
      fileTree.setCellRenderer(new NeFileTreeCellRenderer());
      fileTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
      fileTree.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e) {
              if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
                  doOK();
              }
          }
      });
    }
    return fileTree;
  }
  /**
   * This method initializes jButton
   *
   * @return javax.swing.JButton
   */
  private JButton getOkButton()
  {
    if (okButton == null)
    {
      okButton = new JButton();
      okButton.setPreferredSize(new Dimension(80, 30));
      okButton.setActionCommand("OK");
      okButton.setText(fApplication.getGlobalStringMap().getString("OK"));
      okButton.addActionListener(this);
    }
    return okButton;
  }
  /**
   * This method initializes jButton1
   *
   * @return javax.swing.JButton
   */
  private JButton getCancelButton()
  {
    if (cancelButton == null)
    {
      cancelButton = new JButton();
      cancelButton.setPreferredSize(new Dimension(80, 30));
      cancelButton.setActionCommand("Cancel");
      cancelButton.setText(fApplication.getGlobalStringMap().getString("Cancel"));
      cancelButton.addActionListener(this);
    }
    return cancelButton;
  }

  public static void main(String[] args)
  {
    NeFileChooser fileChooser = new NeFileChooser(null);
    fileChooser.show();
  }

  public void actionPerformed(ActionEvent event)
  {
    String action = event.getActionCommand();
    if(action.equals("OK"))
    {
        doOK();
    }
    else
    {
      this.dispose();
    }
  }

  protected void doOK() {
      TreePath path = fileTree.getSelectionPath();
      if(path != null)
      {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)path.getLastPathComponent();
        if(!selectedNode.isRoot())
        {
          NeFileSystem.File file = (NeFileSystem.File)selectedNode.getUserObject();
          if(file.isFile())
          {
            selectedFile = file;
            this.dispose();
          }
        }
      }
  }
}

class NeFileTreeCellRenderer extends DefaultTreeCellRenderer
{
  Icon closeFolderIcon = null;
  Icon openFolderIcon = null;
  Icon fileIcon = null;

  public NeFileTreeCellRenderer() {
    closeFolderIcon = createImageIcon("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/close_folder.gif");
    openFolderIcon = createImageIcon("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/open_folder.gif");
    fileIcon = createImageIcon("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/file.gif");
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                boolean sel, boolean expanded,
                                                boolean leaf, int row,
                                                boolean hasFocus) {
    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
    if(node.isRoot())
    {
      if(expanded)
        this.setIcon(openFolderIcon);
      else
        this.setIcon(closeFolderIcon);
    }
    else
    {
      NeFileSystem.File file = (NeFileSystem.File)node.getUserObject();

      if(file.isDirectory())
      {
        if(expanded)
          this.setIcon(openFolderIcon);
        else
          this.setIcon(closeFolderIcon);
      }
      else
      {
        this.setIcon(fileIcon);
      }
    }

    return this;
  }

  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = NeFileTreeCellRenderer.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    }
    else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
}