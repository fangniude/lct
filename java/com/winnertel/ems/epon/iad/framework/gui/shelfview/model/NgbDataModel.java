package com.winnertel.ems.epon.iad.framework.gui.shelfview.model;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.BoardTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NgbDataModel implements IDataModel{
    private IApplication fApplication;
    private int shelfNum = 1;
    private int soltNum = 15;

    public NgbDataModel(IApplication anApplication) {
        fApplication = anApplication;
    }

    public List<Object> getShelf() {
        return null;
    }

    public List<Board> getModule(int shelf) {
        List<Board> list = new ArrayList<Board>();
        
        BoardTable mbean = new BoardTable(fApplication.getSnmpProxy());

        try {
            Vector v = mbean.retrieveAll();

            for(Object obj : v) {
                BoardTable bean = (BoardTable)obj;
                Board board = new Board();

                board.setId(bean.getCardIndex());
                board.setType(convert(bean.getType()));

                list.add(board);
            }
        } catch (MibBeanException e) {
            e.printStackTrace();
        }

        return list;
    }

    protected String convert(int i) {
        switch(i) {
            case 1:
                return "control";
            case 2:
                return "gepon";
            case 3:
                return "uplink";
            case 4:
                return "switch";
        }
        
        return "other";
    }
    public List<Object> getPort() {
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
