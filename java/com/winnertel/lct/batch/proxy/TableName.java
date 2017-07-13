package com.winnertel.lct.batch.proxy;

/**
 * Created by Lewis
 * 2017-07-11.
 */
public enum TableName {
    OltSystem, OltVlan, OltQinQ, OnuMac, OnuCfg, OnuUni, ProfileOnu, ProfileUni;

    public IndexType[] indexTypes() {
        switch (this) {
            case OltSystem:
                return new IndexType[]{IndexType.INT};
            case OltVlan:
                return new IndexType[]{IndexType.INT};
            case OltQinQ:
                return new IndexType[]{IndexType.INT, IndexType.INT};
            case OnuMac:
                return new IndexType[]{IndexType.STRING};
            case OnuCfg:
                return new IndexType[]{IndexType.STRING};
            case OnuUni:
                return new IndexType[]{IndexType.STRING};
            case ProfileOnu:
                return new IndexType[]{IndexType.STRING};
            case ProfileUni:
                return new IndexType[]{IndexType.STRING};
            default:
                throw new RuntimeException();
        }
    }
}
