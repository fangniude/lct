package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import java.util.Vector;

/**
 * Created by Li Pengpeng.
 * User: HZ20192
 * Date: 2012-06-13
 */
public class RetrieveWorker extends SwingWorker {
    private ILogger fLogger = LoggerController.createLogger(RetrieveWorker.class);
    private boolean fRunning = false;
    private SnmpTable fTable;
    private SnmpTableModel fTableModel;
    private SnmpMibBean fBean;

    public RetrieveWorker(SnmpTable aTable) {
        this.fTable = aTable;
        this.fTableModel = (SnmpTableModel) fTable.getModel();
        this.fBean = fTableModel.getMibBean();
    }

    @Override
    protected Object doInBackground() throws Exception {
        synchronized (fTableModel) {
            before();

            while (fRunning && fTable.isShowing()) {
                Vector<SnmpMibBean> vector = fBean.retrieveAll();

                fTableModel.addRows(vector);
                if (isEnd(vector)) {
                    break;
                }

                SnmpMibBean lastBean = vector.get(vector.size() - 1);
                for (int i = 0; i < lastBean.getIndexCount(); i++) {
                    fBean.setIndex(i, lastBean.getIndex(i));
                }
            }

            after();
        }

        return null;
    }

    public void stop() {
        fRunning = false;
        this.cancel(true);
    }

    protected void beforeRetrieve() {
    }

    protected void afterRetrieve() {
    }

    private void before() {
        beforeRetrieve();

        fTable.clearSelection();
        fTableModel.getDataVector().clear();
        fTableModel.fireTableChanged(new TableModelEvent(fTableModel, 0, 0));
        fTable.updateUI();

        this.fRunning = true;

        fLogger.debug("Retrieve data row by row start.");
    }

    private void after() {
        fLogger.debug("Retrieve data row by row stop.");

        this.fRunning = false;

        int count = fBean.getIndexCount();
        for (int i = 0; i < count; i++) {
            fBean.setIndex(i, null);
        }

        afterRetrieve();
    }

    private boolean isEnd(Vector<SnmpMibBean> vector) {
        if (vector.size() < fBean.getRowsToFetch()) {
            return true;
        }

        String indexPrefix = fBean.getIndexPrefix();
        if (indexPrefix != null && vector.get(0).getIndexCount() == fBean.getIndexPrefix().split("\\.").length) {
            return true;
        }

        return false;
    }
}
