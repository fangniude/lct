package com.winnertel.em.standard.util.gui.layout;

import javax.swing.*;
import java.awt.*;

public class HSpacer extends JComponent {
    private boolean isspring = true;

    public HSpacer() {
        isspring = true;
    }

    public HSpacer(int width) {
        setWidth(width);

    }

    public void setWidth(int width) {
        isspring = false;
        setPreferredSize(new Dimension(width, this.getPreferredSize().height));
        setMaximumSize(new Dimension(width, this.getPreferredSize().height));
        setMinimumSize(new Dimension(width, this.getPreferredSize().height));
    }

    public boolean isSpring() {
        return isspring;
    }

}
