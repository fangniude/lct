/**
 * Created by Zhou Chao, 2011/4/28
 */

package com.winnertel.ems.epon.iad.bbs4000.cellrenderer.r220;

import com.winnertel.ems.epon.iad.bbs4000.CellRendererIntf;
import com.winnertel.ems.epon.iad.bbs4000.mib.r220.Dot3Onu2CtcTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.ems.epon.iad.util.GuiUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Dot3Onu2CtcTableCellRenderer extends DefaultTableCellRenderer implements CellRendererIntf {

    private IApplication fApplication = null;
    private String neName = null;
    private IGuiComposer composer = null;

    public void setApplication(IApplication anApplication) {
        fApplication = anApplication;
        composer = fApplication.getActiveDeviceManager().getGuiComposer();
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lab = null;
        try {
            lab = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            lab.setForeground(new Color(0, 0, 0));
            Font font = new Font(lab.getFont().getName(), Font.PLAIN, 12);
            lab.setFont(font);

            //if (composer.getString("utsDot3Onu2CtcRegisterStatus").equalsIgnoreCase(table.getColumnName(column))) {
                SnmpTableModel model = (SnmpTableModel) table.getModel();
                if (model == null)
                    return null;

                Dot3Onu2CtcTable rowValue = (Dot3Onu2CtcTable) model.getRow(row);
                if (rowValue == null)
                    return null;

                GuiUtils.markColor4OnuLabel(lab,rowValue.getUtsDot3Onu2CtcStatus(), rowValue.getRegisteredever(),rowValue.isDyingGasp());
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lab;
    }

}