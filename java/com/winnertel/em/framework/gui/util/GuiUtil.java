package com.winnertel.em.framework.gui.util;

import com.klg.jclass.field.JCFieldComponent;
import com.klg.jclass.field.JCFormUtil;
import com.klg.jclass.field.JCTextField;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class GuiUtil {

    public static Frame getParentFrame(Container aContainer) {
        while (!(aContainer instanceof Frame)) {
            aContainer = aContainer.getParent();
        }
        return (Frame) aContainer;
    }


    public static JDialog getParentDialog(Container aContainer) {
        while (!(aContainer instanceof JDialog)) {
            aContainer = aContainer.getParent();
        }
        return (JDialog) aContainer;
    }


    public static boolean validateFrom(UPanel aPanel, IApplication anApp) {
        boolean result = true;
        StringBuffer msg = new StringBuffer();
        IStringMap stringMap = anApp.getGlobalStringMap();
        msg.append("<html>" + stringMap.getString("Following fields are invalid:") + "<br>");
        msg.append("<lo>");
        Set fields = JCFormUtil.getInvalidRequiredFieldComponents(aPanel);
        Iterator it = fields.iterator();
        int count = 0;
        while (it.hasNext()) {
            count++;
            JCFieldComponent field = (JCFieldComponent) it.next();
            if (field instanceof JCTextField) {
                if (!((JCTextField) field).isEditable()) {
                    count--;
                    continue;
                }
            }
            msg.append("<li>");
            msg.append(((Component) field).getName());
            msg.append("<br>");
        }
        msg.append("</lo>");
        msg.append("</html>");

        if (count > 0) {
            result = false;
        }

        if (!result) {
            MessageDialog.showMessageDialog(anApp, msg.toString(),
                    stringMap.getString("Error"),
                    JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }
}
