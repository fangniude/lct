package com.winnertel.em.standard.util.gui.layout;

import javax.swing.*;
import java.awt.*;

public class VSpacer extends JComponent {
    private boolean isspring = true;

    public VSpacer() {
        isspring = true;
    }

    public VSpacer(int height) {
        setHeight(height);
    }

    public void setHeight(int height) {
        isspring = false;
        setPreferredSize(new Dimension(this.getPreferredSize().width, height));
        setMaximumSize(new Dimension(this.getPreferredSize().width, height));
        setMinimumSize(new Dimension(this.getPreferredSize().width, height));
    }

    public boolean isSpring() {
        return isspring;
    }

}
