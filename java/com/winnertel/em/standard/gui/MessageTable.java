package com.winnertel.em.standard.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.ILogable;
import com.winnertel.em.framework.gui.swing.UTable;
import com.winnertel.em.framework.gui.swing.UTableModel;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.log.ILogInfo;

import java.text.SimpleDateFormat;

public final class MessageTable extends UTable implements ILogable {
    private MessageTableModel fModel = null;


    public MessageTable(IApplication anApplication) {
        super(anApplication);
        fModel = new MessageTableModel();
        setModel(fModel);
    }

    public void writeLog(ILogInfo aLogInfo) {
        fModel.getDataVector().add(aLogInfo);
        fModel.fireTableDataChanged();
    }


    private class MessageTableModel extends UTableModel {
        private final int RESULT = 0;
        private final int TIME = 1;
        private final int USER = 2;
        private final int OPERA_OBJECT = 3;
        private final int OPEAR = 4;
        private final int ANNOTATION = 5;
//        private final int HOST_IP = 5;
//        private final int HOST_NAME = 6;

        private String[] fColumnNames = null;
        private String[] fResults = null;

        private SimpleDateFormat fDateFormatter = null;

        public MessageTableModel() {
            fDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            IStringMap stringMap = fApplication.getGlobalStringMap();
            fColumnNames = new String[]{
                    stringMap.getString("Result"),
                    stringMap.getString("Time"),
                    stringMap.getString("User"),
                    stringMap.getString("Operation Object"),
                    stringMap.getString("Operation"),
                    stringMap.getString("Annotation"),
//                stringMap.getString("Host IP Address"),
//                stringMap.getString("Host Name"),
            };

            fResults = new String[]{
                    stringMap.getString("Completed"),
                    stringMap.getString("Failed"),
            };
        }


        public int getColumnCount() {
            return fColumnNames.length;
        }

        public String getColumnName(int column) {
            return fColumnNames[column];
        }

        public Object getValueAt(int row, int column) {
            ILogInfo logInfo = (ILogInfo) dataVector.get(row);
            if (logInfo == null) {
                return null;
            }

            switch (column) {
                case RESULT:
                    switch (logInfo.getStatus()) {
                        case ILogInfo.COMPLETED:
                            return fResults[0];
                        case ILogInfo.FAILED:
                            return fResults[1];
                        default:
                            return "".intern();
                    }
                case TIME:
                    return fDateFormatter.format(logInfo.getTime());
                case USER:
                    return logInfo.getUser();
                case OPERA_OBJECT:
                    return logInfo.getOperationObject();
                case OPEAR:
                    return logInfo.getOperation();
                case ANNOTATION:
                    return logInfo.getAnnotation();
//                case HOST_IP:
//                    return logInfo.getHostIp();
//                case HOST_NAME:
//                    return logInfo.getHostName();
            }

            return null;
        }
    }
}
