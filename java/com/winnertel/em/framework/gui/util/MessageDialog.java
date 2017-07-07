package com.winnertel.em.framework.gui.util;

import com.winnertel.em.framework.IApplication;

import javax.swing.*;

public class MessageDialog {
    private MessageDialog() {
    }


    public static boolean showConfirmOperationDialog(IApplication anApplication) {
        String message = "Are you sure to do this configuration?";
        return JOptionPane.OK_OPTION == showConfirmDialog(anApplication, getString(anApplication, message));
    }


    public static boolean showConfirmDeleteDialog(IApplication anApplication) {
        String message = "Are you sure to delete this row?";
        return JOptionPane.OK_OPTION == showConfirmDialog(anApplication, getString(anApplication, message));
    }


    public static int showConfirmDialog(IApplication anApplication, String aMessage) {
        return JOptionPane.showConfirmDialog(anApplication.getTopMostFrame(),
                aMessage,
                getString(anApplication, "Please Confirm"),
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE);
    }


    public static void showQueryFailedDialog(IApplication anApplication) {
        String message = "Failed to query data from device!";
        showErrorMessageDialog(anApplication, message);
    }

    public static void showOperationSucceedDialog(IApplication anApplication) {
        String message = "Configuration completed successful!";
        showInfoMessageDialog(anApplication, message);
    }

    public static void showOperationFailedDialog(IApplication anApplication) {
        String message = "Configuration failed!";
        showErrorMessageDialog(anApplication, message);
    }

    public static void showSelectRowDialog(IApplication anApplication) {
        String message = "Please select a row in the table for the operation.";
        showInfoMessageDialog(anApplication, message);
    }

    public static void showPermissionDeniedDialog(IApplication anApplication) {
        String message = "You have no permission for this operation.";
        showErrorMessageDialog(anApplication, message);
    }


    public static void showMessageDialog(IApplication anApplication,
                                         String aMessage, String aTitle,
                                         int aMessageType) {
        JOptionPane.showMessageDialog(anApplication.getTopMostFrame(),
                aMessage, aTitle, aMessageType);
    }


    public static void showErrorMessageDialog(IApplication anApplication, String aMessage) {
        showMessageDialog(anApplication, getString(anApplication, aMessage),
                getString(anApplication, "Error"),
                JOptionPane.ERROR_MESSAGE);
    }


    public static void showInfoMessageDialog(IApplication anApplication, String aMessage) {
        showMessageDialog(anApplication, getString(anApplication, aMessage),
                getString(anApplication, "Information"),
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * replace the "\r\n" string to enter key.
     *
     * @param anApplication
     * @param aKey
     * @return String
     */
    private static String getString(IApplication anApplication, String aKey) {
        String s = anApplication.getGlobalStringMap().getString(aKey);
        if (s == null) s = "";

        s = s.replaceAll("\\\\r\\\\n", "\r\n");
        s = s.replaceAll("\\\\r", "\r\n");
        s = s.replaceAll("\\\\n", "\r\n");

        return s;
    }
}
