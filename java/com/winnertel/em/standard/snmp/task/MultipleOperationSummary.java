package com.winnertel.em.standard.snmp.task;

import java.util.Vector;

public class MultipleOperationSummary {
    private Vector fSummaryList;


    public MultipleOperationSummary() {
        fSummaryList = new Vector();
    }


    public void add(String anObjectName, Integer aResult) {
        Vector summary = new Vector(2);
        summary.add(anObjectName);
        summary.add(aResult);
        fSummaryList.add(summary);
    }


    public Vector getSummaryList() {
        return fSummaryList;
    }
}
