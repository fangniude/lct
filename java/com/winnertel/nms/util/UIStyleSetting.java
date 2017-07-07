package com.winnertel.nms.util;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Rex
 * Date: 13-2-27
 * Time: pm4:04
 * To change this template use File | Settings | File Templates.
 */
public class UIStyleSetting {

    private static boolean isUIStyleSet = false;

    public static void setStyle() {
        if (!isUIStyleSet) {
            initLookAndFeel();
            isUIStyleSet = true;
        }

    }

    private static void initLookAndFeel() {

/*
        String theme2 = "ch.randelshofer.quaqua.QuaquaLookAndFeel";

        String lfClass = theme2;
        try {
            System.setProperty("Quaqua.tabLayoutPolicy", "wrap");
            Method method = Class.forName("ch.randelshofer.quaqua.util.Methods").getMethod("invokeStatic", new Class[] {Class.class, String.class, Class.class, Object.class} );
            if( method != null ) {
                method.invoke(null, new Object[]{JFrame.class, "setDefaultLookAndFeelDecorated", Boolean.TYPE,  Boolean.TRUE});
                method.invoke(null, new Object[]{JDialog.class, "setDefaultLookAndFeelDecorated", Boolean.TYPE,  Boolean.TRUE});
            }
        } catch (Exception ex) {

        }
        try {
            UIManager.setLookAndFeel((LookAndFeel) Class.forName(lfClass).newInstance() );
            UIManager.getLookAndFeelDefaults().put("ClassLoader", SwingCommon.class.getClassLoader());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
*/

//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//        } catch ( Exception ex ) {
//            ex.printStackTrace();
//        }


        try {
            UIManager.put("ScrollBar.width", 17);

            UIManager.put("MenuItem.background", Color.WHITE);
            UIManager.put("MenuItem.selectionBackground", Color.BLUE);
            UIManager.put("MenuItem.selectionForeground", Color.WHITE);
            UIManager.put("MenuItem.border", new MetalBorders.MenuItemBorder() {
                public Insets getBorderInsets(Component c) {
                    return new Insets(5, 2, 5, 2);
                }
            });

            initFont();
            initOptionPaneButtonText();
            initFileChooserText();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private static void initFont() {
        Font zhFont = new Font("宋体", Font.PLAIN, 12);
        UIManager.put("Menu.font", zhFont);
        UIManager.put("MenuItem.font", zhFont);
        UIManager.put("Tree.font", zhFont);
        UIManager.put("Button.font", zhFont);
        UIManager.put("TabbedPane.font", zhFont);
        UIManager.put("Label.font", zhFont);
        UIManager.put("TextArea.font", zhFont);
        UIManager.put("TitledBorder.font", zhFont);
    }

    private static void initFileChooserText() {

    }

    private static void initOptionPaneButtonText() {
        if ("zh".equals(Locale.getDefault().getLanguage())) {
            UIManager.getDefaults().put("OptionPane.yesButtonText", "是");
            UIManager.getDefaults().put("OptionPane.noButtonText", "否");
            UIManager.getDefaults().put("OptionPane.cancelButtonText", "取消");
            UIManager.getDefaults().put("OptionPane.okButtonText", "确认");
            UIManager.getDefaults().put("OptionPane.messageDialogTitle", "消息");
            UIManager.getDefaults().put("OptionPane.inputDialogTitle", "输入");
            UIManager.getDefaults().put("OptionPane.titleText", "标题");
        } else {
            UIManager.put("OptionPane.yesButtonText", "Yes");
            UIManager.put("OptionPane.noButtonText", "No");
            UIManager.put("OptionPane.cancelButtonText", "Cancel");
            UIManager.put("OptionPane.okButtonText", "OK");
            UIManager.put("OptionPane.messageDialogTitle", "Message");
        }
    }

}
