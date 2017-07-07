package com.winnertel.ems.lct.access;

public class AccessCtrlFactory {

    private static AccessCtrlFactory _instance = new AccessCtrlFactory();

    private AccessCtrlFactory() {
    }

    public static AccessCtrlFactory instance() {
        return _instance;
    }

    public IAccessCtrl getAccessCtrl(String neType) {
        return new CommunityChgCtrl(neType);

    }

    public static class CtrlErrorCode {
        public static final int ERR_ILLEGAL_UNCP = 1;
        public static final int ERR_INCONSISTENT_UNCP = 2;
        public static final int ERR_EMPTY_COMMUNITY = 3;
    }

}