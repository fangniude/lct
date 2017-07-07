package com.winnertel.ems.lct.history;

import com.winnertel.ems.lct.LctNode;

import java.util.List;

public interface HistoryManager<E> {
    List<E> readHistory();

    void addToHistory( LctNode node );

    void eraseHistory(E history);
}
