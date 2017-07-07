package com.winnertel.ems.epon.iad.framework.gui.shelfview.model;

import com.winnertel.em.framework.IApplication;

import java.util.List;
import java.util.ArrayList;

public class BBS4000DataModel implements IDataModel{
    private int shelfNum = 1;
    private int soltNum = 15;

    public BBS4000DataModel(IApplication app) {

    }
    
    public List<Object> getShelf() {

        return null;
    }

    public List<Board> getModule(int shelf) {
        return null;
    }

    public List<Object> getPort() {
        return null;
    }

    public List<Object> getChildren() {
        return null;
    }

    public int getSoltNumberPerShelf() {
        return soltNum;
    }

    public List getModuleList() {
        List list = new ArrayList();

        return list;
    }
}