package com.winnertel.ems.lct.history;

public interface HistoryAware<E> {
    boolean historyLoad( E history );

}
