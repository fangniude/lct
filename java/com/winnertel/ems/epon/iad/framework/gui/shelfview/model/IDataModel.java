package com.winnertel.ems.epon.iad.framework.gui.shelfview.model;

import java.util.List;

public interface IDataModel {
    public List<Object> getShelf();

    public List<Board> getModule(int shelf);

    public List<Object> getPort();
}
