package com.winnertel.em.standard.snmp.command;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.util.BaseException;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportCommand extends SnmpTableCommand {

    static class CSVFileFilter extends FileFilter {

        public boolean accept(File f) {
            if (f != null) {
                if (f.isDirectory()) {
                    return true;
                }
                if (getExtension().equalsIgnoreCase(ExportCommand.getExtension(f))) {
                    return true;
                }
            }
            return false;
        }

        public String getDescription() {
            return "csv format";
        }

        public String getExtension() {
            return "csv";
        }
    }

    static class CSVFileWriter {
        public static boolean writeTableModel(SnmpTable fTable, File file) {

            if (fTable == null) {
                return false;
            }

            TableModel tableModel = fTable.getModel();
            StringBuffer fileBuf = new StringBuffer("");
            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    fileBuf.append(tableModel.getValueAt(row, col).toString());
                    if (col != columnCount - 1) {
                        fileBuf.append(",");
                    }
                }
                fileBuf.append("\n");
            }
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(fileBuf.toString());
                writer.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace(System.err);
                return false;
            }
        }
    }

    static class XMLFileFilter extends FileFilter {

        public boolean accept(File f) {
            if (f != null) {
                if (f.isDirectory()) {
                    return true;
                }
                if (getExtension().equalsIgnoreCase(ExportCommand.getExtension(f))) {
                    return true;
                }
            }
            return false;
        }

        public String getDescription() {
            return "xls format";
        }

        public String getExtension() {
            return "xls";
        }
    }

    static class XMLFileWriter {
        public static boolean writeTableModel(SnmpTable fTable, File file) {
            if (fTable == null) {
                return false;
            }

            TableModel tableModel = fTable.getModel();

            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();

            WorkbookSettings ws = new WorkbookSettings();
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(file, ws);
                String name = fTable.getName() != null ? fTable.getName() : "sheet1";
                WritableSheet sheet = workbook.createSheet(name, 0);

                //header format.
                WritableFont arial10ptBold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
                WritableCellFormat headerFormat = new WritableCellFormat(arial10ptBold);
                //
                WritableCellFormat wrappedformat = new WritableCellFormat(WritableWorkbook.ARIAL_10_PT);
                wrappedformat.setWrap(true);

                //write the table header
                for (int col = 0; col < columnCount; col++) {
                    sheet.addCell(new Label(col, 0, tableModel.getColumnName(col), headerFormat));
                }

                //write the data.
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        sheet.addCell(new Label(col, row + 1, tableModel.getValueAt(row, col).toString(), wrappedformat));
                    }
                }

                workbook.write();
                workbook.close();
            } catch (Exception ioe) {
                ioe.printStackTrace();
                return false;
            }

            return true;
        }
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public ExportCommand(IApplication aApplication, SnmpTable aTable) {
        super(aApplication, aTable);
    }

    public boolean execute() throws BaseException {
        if (fTable == null) {
            return false;
        }
        File file = showSaveDialog();
        if (file != null) {
            if (file.exists()) {
                if (JOptionPane.showConfirmDialog(fTable, fApplication.getGlobalStringMap().getString("The file already exists, do you want to replace it?")) != JOptionPane.YES_OPTION) {
                    return false;
                }
            }

            if (getExtension(file).equalsIgnoreCase("csv")) {
                return CSVFileWriter.writeTableModel(fTable, file);
            } else {
                return XMLFileWriter.writeTableModel(fTable, file);
            }
        }
        return false;
    }

    private File showSaveDialog() {
        JFileChooser chooser = new JFileChooser();
        chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter());
        chooser.addChoosableFileFilter(new CSVFileFilter());
        chooser.addChoosableFileFilter(new XMLFileFilter());
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int ret = chooser.showSaveDialog(fApplication.getTopMostFrame());
        if (ret == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            FileFilter filter = chooser.getFileFilter();

            if (filter instanceof CSVFileFilter) {
                String extension = getExtension(f);
                if (extension == null || !extension.equalsIgnoreCase(((CSVFileFilter) filter).getExtension())) {
                    return new File(f.getAbsolutePath() + "." + ((CSVFileFilter) filter).getExtension());
                }
            } else {
                String extension = getExtension(f);
                if (extension == null || !extension.equalsIgnoreCase(((XMLFileFilter) filter).getExtension())) {
                    return new File(f.getAbsolutePath() + "." + ((XMLFileFilter) filter).getExtension());
                }
            }

            return f;
        }

        return null;
    }
}
