package com.winnertel.em.framework.util;

import com.winnertel.common.notification.UNotificationFilter;
import com.winnertel.em.framework.log.ILogInfo;
import com.winnertel.nms.topodb.ULManagedObject;

public interface IPlatformProxy {
    public ULManagedObject getManagedObject(String aName);

    public boolean log(ILogInfo aLogInfo);

    public boolean isAuthorized(String userId, String privilegeId);

    public boolean registerNotificationHandler(UNotificationFilter aFilter, INotificationHandler aHandler);

    public boolean deregisterNotificationHandler(UNotificationFilter aFilter, INotificationHandler aHandler);
}
