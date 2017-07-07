package com.winnertel.em.standard.util.gui.input.base;

import com.winnertel.em.standard.util.gui.input.factory.TextFieldFactory;
import com.winnertel.em.standard.util.gui.input.resource.ResourceBundleProxy;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.MessageFormat;

public abstract class AbstractTextPanel extends JPanel {
    protected FormattedField[] cells;
    protected JTextField[] placeHolders;
    private NTLayout layout;
    private int counter = 0;
    private ResourceBundleProxy bundleProxy;
    private boolean ipEditable = true;

    public String getString(String string) {
        if (bundleProxy == null) {
            bundleProxy = ResourceBundleProxy.getInstance();
            bundleProxy.setLocale(getLocale());
        }
        return bundleProxy.getString(string);
    }

    public void popupMessage(String aMessage) {

        JOptionPane.showMessageDialog(this, aMessage);

    }

    public void popupMessage(int min, int max) {
        //888 is not a valid entry. Please specify a integer between min and max
        popupMessage(MessageFormat.format(getString("value_between"), min, max));
//        popupMessage(getString("Please enter a value between ")
//                + min + getString(" and ") + max + getString("@IntegerTail"));
    }

    public AbstractTextPanel(int[] cellWidths, String[] holders, TextFieldFactory aFactory) {
        int countOfCells = cellWidths.length;

        if (!(holders.length == countOfCells - 1 || holders.length == countOfCells + 1))
            throw new IllegalArgumentException("[pht]error in placeholders length!");
        cells = new FormattedField[countOfCells];
        for (int i = countOfCells - 1; i >= 0; i--) {

            cells[i] = aFactory.create(i);
            cells[i].setColumns(cellWidths[i]);
            cells[i].setBorder(null);
            cells[i].setHorizontalAlignment(SwingConstants.CENTER);
            if (i < countOfCells - 1)
                cells[i].setNextFocusableComponent(cells[i + 1]);
        }

        placeHolders = new JTextField[holders.length];
        for (int i = 0; i < holders.length; i++) {
            placeHolders[i] = new JTextField(holders[i], holders[i].length());
            placeHolders[i].setBorder(null);
            placeHolders[i].setBackground(Color.white);
            placeHolders[i].setEditable(false);
        }
        layout = new NTLayout(1, countOfCells + holders.length, NTLayout.CENTER, NTLayout.CENTER, 0, 0);
        layout.setMargins(1, 1, 1, 1);

        int totalWidth = 0;
        for (int i = 0; i < countOfCells; i++) {
            totalWidth += cellWidths[i];
        }
        for (int i = 0; i < holders.length; i++) {
            totalWidth += holders[i].length();
        }

//        if ( holders.length == countOfCells - 1 )//x.y.z.c type
//        {
//            for ( int i = 0; i < countOfCells + holders.length; i++ ) {
//                if ( i % 2 == 0 )
//                    layout.setColumnScale( i, ( double ) cellWidths[i / 2] / totalWidth );
//                else
//                    layout.setColumnScale( i, ( double ) holders[( i - 1 ) / 2].length() / totalWidth );
//            }
//        }
//        if ( holders.length == countOfCells + 1 )//.x.y.z.c. type
//        {
//            for ( int i = 0; i < countOfCells + holders.length; i++ ) {
//                if ( i % 2 == 0 )
//                    layout.setColumnScale( i, ( double ) holders[i / 2].length() / totalWidth );
//                else
//                    layout.setColumnScale( i, ( double ) cellWidths[( i - 1 ) / 2] / totalWidth );
//            }
//        }
        if (holders.length == countOfCells - 1)//x.y.z.c type
        {
            for (int i = 0; i < countOfCells + holders.length; i++) {
                if (i % 2 == 0) add(cells[i / 2]);
                else add(placeHolders[(i - 1) / 2]);
            }
        }
        if (holders.length == countOfCells + 1)//.x.y.z.c. type
        {
            for (int i = 0; i < countOfCells + holders.length; i++) {
                if (i % 2 == 0) add(placeHolders[i / 2]);
                else add(cells[(i - 1) / 2]);
            }
        }
        setLayout(layout);
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(new Color(120, 120, 120)));
        setPreferredSize(new Dimension(totalWidth + 4, 22));
        setListeners(cellWidths);
    }

    protected boolean isEditable() {
        return ipEditable;
    }

    public void setEditable(boolean b) {
        ipEditable = b;
        for (int i = 0; i < cells.length; i++) {
            cells[i].setEditable(b);
        }
        if (!b) {
            for (int i = 0; i < placeHolders.length; i++) {
                placeHolders[i].setBackground(new Color(204, 204, 204));
            }
            this.setBackground(new Color(204, 204, 204));
        } else {
            for (int i = 0; i < placeHolders.length; i++) {
                placeHolders[i].setBackground(Color.white);
            }
            this.setBackground(Color.white);
        }
    }

    private int getIndex(ComponentEvent event) {
        int i = 0;
        for (; i < cells.length; i++) {
            if (cells[i] == event.getSource())
                break;
        }
        if (i >= cells.length)
            return -1;
        return i;
    }

    private int getIndex(JComponent component) {
        int i = 0;
        for (; i < cells.length; i++) {
            if (cells[i] == component)
                break;
        }
        if (i >= cells.length)
            return -1;
        return i;
    }

    /**
     * invoked when the field loses keyboard focus.
     *
     * @param cellIndex
     */
    protected abstract boolean verifyField(int cellIndex);

//    protected boolean verifyField( int cellIndex ){return true;}

    private void setListeners(final int[] cellWidths) {
        for (counter = 0; counter < cellWidths.length; counter++) {
            cells[counter].addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    int i = getIndex(e);
                    cells[i].getCaret().setDot(0);
                    cells[i].selectAll();
                }

                public void focusLost(FocusEvent e) {
                    //do nothing.
                }
            });

            //check if the input in field is valid when user try to transfer the foucus to other component..
            cells[counter].setInputVerifier(new InputVerifier() {
                public boolean verify(JComponent e) {
                    int i = getIndex(e);
                    return verifyField(i);
                }
            });
            cells[counter].addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    int i = getIndex(e);
                    int key = e.getKeyCode();
                    int len = cells[i].getText().length();
                    int pos = cells[i].getCaretPosition();
                    if ((key == KeyEvent.VK_LEFT) && (pos == 0) && (i > 0)) {
                        cells[i - 1].requestFocus();
                    } else if ((key == KeyEvent.VK_RIGHT || key == 110 || key == 46) && (pos == len) && (i < cells.length - 1)) {
                        cells[i + 1].requestFocus();
                    } else if (key == KeyEvent.VK_BACK_SPACE && pos == 0 && (i > 0)) {
                        cells[i - 1].requestFocus();
                    } else if ((pos == len) && (pos == cells[i].getColumns()) && key != KeyEvent.VK_BACK_SPACE) {
                        cells[i + 1].requestFocus();
                    }
                }
            });
        }
    }
}
