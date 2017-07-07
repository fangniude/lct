package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Vector;

/**
 * Component used to display a JCombox based group of JCheckBox. the value of
 * the Combox will display all the selected values.
 *
 * @author HZ03048
 */
public class MultiItemSelector extends JPanel {

  // Local variants
  public static final String PROPERTY_SELECTED = "vSelectedChoices";

  private Vector<Object> vChoices = null;
  private Vector<Object> vSelectedChoices = null;

  private MultiChooserMenu menu = null;
  private JTextField selectorField = null;
  private JButton selectorBtn = null;

  private ImageIcon selectorBtnIcon = getImageIcon("/com/winnertel/ems/epon/iad/bbs4000/gui/swing/images/down_small.gif");

  /**
   * Constracture, and it will init the selection set and selected set of this
   * component.
   */
  public MultiItemSelector() {
    this(new Vector<Object>());
  }

  /**
   * Constracture, and it will init the selection set with the specific Vector
   * and selected set of this
   *
   * @param choices A Vector include all possible values and it will be the
   *                selection set of this component
   */
  public MultiItemSelector(Vector<Object> choices) {
    vChoices = choices;
    vSelectedChoices = new Vector<Object>();
    init();
  }

  /**
   * Init all the check box in this component according the provides v
   *
   * @param v A Vector indicate the selection set of the component.
   * @see #getSelectionChoices()
   */
  public void setSelectionChoices(Vector<?> v) {
    vChoices.clear();
    for (int i = 0; i < v.size(); i++)
      vChoices.addElement(v.elementAt(i));

    fireSelectionChanged();
  }

  void fireSelectionChanged() {
    menu.handleSelectionChanged();
  }

  /**
   * Get the selection set of this component.
   *
   * @return A Vector include all possible values can be selected from this
   *         component.
   * @see #setSelectedChoices(Vector)
   */
  public Vector<?> getSelectionChoices() {
    return (Vector)vChoices.clone();
  }


  public void setEnabled(boolean enabled) {
//		super.setEnabled(enabled);
    selectorField.setEnabled(enabled);
    selectorField.setEditable(false);
    selectorBtn.setEnabled(enabled);
    for (int i = 0; i < menu.boxs.length; i++) {
      menu.boxs[i].setEnabled(enabled);
    }
  }

  /**
   * Set the values should be selected in this component
   *
   * @param v A Vector include all values will be set selected in this
   *          component
   * @see #getSelectedChoices()
   */
  public void setSelectedChoices(Vector<?> v) {
    if (menu == null)
      return;

    vSelectedChoices.clear();

    for(int i = 0; i < v.size(); i++) {
      if(vChoices.contains(v.get(i))) {
        vSelectedChoices.add(v.get(i));
      }
    }

    menu.handleSelectedChanged();
  }

  /**
   * Get the selected value in this component
   *
   * @return A Vector to include all has been selected values
   * @see #setSelectedChoices(Vector)
   */
  public Vector<Object> getSelectedChoices() {
    return (Vector)vSelectedChoices.clone();
  }

  /**
   * Used to set one items in this check box menu enable status
   *
   * @param i The index of the check menu item in this component
   * @param b It indicate the enable status of the specific item in check
   *          box menu
   */
  public void setItemEnable(int i, boolean b) {
    if (menu == null)
      return;
    if (i >= 0 && i < menu.boxs.length) {
      menu.boxs[i].setEnabled(b);
    }
  }

  /**
   * Get the selected value changed property name of this component
   *
   * @return A String indicate the property name
   */
  public String getValueProperty() {
    return PROPERTY_SELECTED;
  }

  // Init the component
  private void init() {
    // Create a text field to show the selected result, if multi-item
    // selected, it only display the first item and also some ...
    selectorField = new JTextField();
    selectorField.setEditable(false);
    selectorField.setBorder(BorderFactory.createEtchedBorder());
    selectorField.setPreferredSize(new Dimension(21, 21));
    selectorField.setFocusable(false);

    selectorBtn = new JButton();
    selectorBtn.setBorder(BorderFactory.createEtchedBorder());
    selectorBtn.setPreferredSize(new Dimension(21, 21));
    selectorBtn.setFocusable(false);
    selectorBtn.setIcon(selectorBtnIcon);
    selectorBtn.setOpaque(false);

    // Create the check box menu
    menu = new MultiChooserMenu(selectorField);

    MouseAdapter mouse = new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
      }

      public void mouseClicked(MouseEvent e) {
        // If this component is enable, then show the menu
        if (MultiItemSelector.this.isEnabled())
          menu.initSelectionLayout();
          menu.show(MultiItemSelector.this, 0, MultiItemSelector.this.getHeight());

      }
    };

    selectorField.addMouseListener(mouse);
    selectorBtn.addMouseListener(mouse);

    this.setLayout(new BorderLayout());
    this.add(selectorField, BorderLayout.CENTER);
    this.add(selectorBtn, BorderLayout.EAST);
  }
  
  public void addSelectListener(ItemListener listener) {
	  menu.addSelectionListener(listener);
  }

  // Get the display result in the text field from the selected values
  protected String getContent(Vector<Object> vSelected) {
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < vSelected.size(); i++) {
      String text = vSelected.elementAt(i).toString();

      if (sb.length() == 0)
        sb.append(text);
      else
        sb.append(", ").append(text);
    }

    return sb.toString();
  }

  protected static ImageIcon getImageIcon(String path) {
    URL imgURL = MultiItemSelector.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }

  // The check box menu implementation
  private class MultiChooserMenu extends JPopupMenu implements ItemListener{
    // Check box array
    private JCheckBox[] boxs = null;

    // Check box text
    private JTextField component = null;

    private JPanel panel = null;
    
    private Vector selectionListener = new Vector();

    public MultiChooserMenu(JTextField _commponent) {
      component = _commponent;
      bInit();
    }

    // get the selected values and if it changed then fire an
    // property change event
    public Vector<Object> getSelections() {
      return (Vector) vSelectedChoices.clone();
    }

    private void bInit() {
      JScrollPane scrollpane = new JScrollPane();
      panel = new JPanel(new BorderLayout());

      this.setLayout(new BorderLayout());
      this.add(scrollpane, BorderLayout.CENTER);
      this.setBorder(BorderFactory.createEmptyBorder());

      scrollpane.getViewport().add(panel);
    }

    private void initSelectionLayout() {
      panel.removeAll();

      //count the rows and columns.
      int maxSelectionLength = 0;
      for (int i = 0; i < vChoices.size(); i++) {
        int length = this.getFontMetrics(this.getFont()).stringWidth(
            boxs[i].getText()) + 30;
        if (maxSelectionLength < length)
          maxSelectionLength = length;
      }

      int nColumn = MultiItemSelector.this.getWidth()
          / (maxSelectionLength + 10);

      if (nColumn <= 0) {
        nColumn = 1;
      }

      int nLine = (vChoices.size() % nColumn) == 0 ? vChoices.size()
          / nColumn
          : vChoices.size() / nColumn + 1;

      JPanel pane = new JPanel(new GridLayout(nLine, nColumn, 20, 5));
      for (int i = 0; i < vChoices.size(); i++) {
        pane.add(boxs[i]);
      }
      pane.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 0));

      panel.add(pane, BorderLayout.CENTER);

      // Try to get the max legnth of the selection items
      String maxlengthStr = "";
      for (int i = 0; i < vChoices.size(); i++) {
        if (vChoices.elementAt(i).toString().length() > maxlengthStr.length())
          maxlengthStr = vChoices.elementAt(i).toString();
      }

      // The max height of the popup menu is no more than 300
      int width = Math.max(MultiItemSelector.this.getWidth(),
          this.getFontMetrics(this.getFont()).stringWidth(maxlengthStr) + 45);
      int height = Math.min(nLine * 30, 300);

      this.setPreferredSize(new Dimension(width, height));
    }

    void handleSelectionChanged() {
      // Layout check box
      boxs = new JCheckBox[vChoices.size()];
      for (int i = 0; i < vChoices.size(); i++) {
        boxs[i] = new JCheckBox();
        boxs[i].setPreferredSize(new Dimension(30, 21));

        String text = vChoices.elementAt(i).toString();
        boxs[i].setText(text);
        if (vSelectedChoices.contains(vChoices.elementAt(i))) {
          boxs[i].setSelected(true);
        } else {
          boxs[i].setSelected(false);
        }

        // Add item listener
        boxs[i].addItemListener(this);
      }

      //
      itemStateChanged(null);
    }

    public void itemStateChanged(ItemEvent e) {
      vSelectedChoices.clear();
      for (int i = 0; i < boxs.length; i++) {
        if (boxs[i].isSelected()) {
          vSelectedChoices.addElement(vChoices.elementAt(i));
        }
      }

      String text = getContent(vSelectedChoices);
      component.setText(text);
      if (text != null && !text.equals("")) {
        component.setCaretPosition(0);
        component.moveCaretPosition(0);
      }
      
      for(int i = 0; i < selectionListener.size(); i++) {
    	  ItemListener listener = (ItemListener)selectionListener.get(i);
    	  listener.itemStateChanged(e);
      }
    }

    void handleSelectedChanged() {
      for(int i = 0; i < boxs.length; i++) {
        boxs[i].removeItemListener(this);
      }

      for (int i = 0; i < menu.boxs.length; i++) {
        if (vSelectedChoices.contains(vChoices.get(i))) {
          menu.boxs[i].setSelected(true);
        }
        else
          menu.boxs[i].setSelected(false);
      }

      for(int i = 0; i < boxs.length; i++) {
        boxs[i].addItemListener(this);
      }

      //
      itemStateChanged(null);
    }
    
    public void addSelectionListener(ItemListener listener) {
    	selectionListener.add(listener);
    }
  }

  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setPreferredSize(new Dimension(800, 600));

    Vector<Object> strFirst = new Vector<Object>();
    for (int i = 0; i < 10; i++)
      strFirst.addElement("This is Test " + i);

    Vector<Object> str = new Vector<Object>();
    for (int i = 0; i < 100; i++)
      str.addElement("This is Test " + i);

    Vector<Object> selected = new Vector<Object>();
    selected.addElement(str.elementAt(1));
    selected.addElement(str.elementAt(4));

    MultiItemSelector selector = new MultiItemSelector(strFirst);
    selector.setSelectionChoices(str);
    selector.setPreferredSize(new Dimension(150, 21));
    selector.setEnabled(true);
    selector.setSelectedChoices(selected);
    selector.setItemEnable(1, true);
    selector.setItemEnable(3, false);
    selector.setItemEnable(4, false);

    JPanel pan = new JPanel(new BorderLayout());
    pan.add(selector, BorderLayout.NORTH);

    f.setLayout(new BorderLayout());
    f.add(pan, BorderLayout.NORTH);
    f.pack();
    f.setVisible(true);

    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
			}
		});
	}
}
