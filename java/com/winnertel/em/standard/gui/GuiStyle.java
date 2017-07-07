package com.winnertel.em.standard.gui;

import javax.swing.*;
import java.awt.*;

public class GuiStyle {

    protected LayoutManager fButtonsLayout;

    protected JDialog fWaitDialog;

    public GuiStyle() {
    }

    public static GuiStyle getDefaultGuiStyle() {
        return new HZ_GuiStyle();
    }

    public LayoutManager getButtonsLayout() {
        return fButtonsLayout;
    }

    public JDialog getWaitDialog() {
        return fWaitDialog;
    }

    public static class HZ_GuiStyle extends GuiStyle {

        public HZ_GuiStyle() {
            fButtonsLayout = new FlowLayout(FlowLayout.CENTER);
        }
    }

    public static class NJ_GuiStyle extends GuiStyle {
        public NJ_GuiStyle() {
            fButtonsLayout = new FlowLayout(FlowLayout.RIGHT);
        }
    }
}
