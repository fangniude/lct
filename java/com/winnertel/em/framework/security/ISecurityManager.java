package com.winnertel.em.framework.security;

import com.winnertel.em.framework.ISession;

public interface ISecurityManager {
    /**
     * Check if a session is authorized to perform the action
     *
     * @param aSession a session for the operator
     * @param anAction the action id
     * @return ture if authorized, false otherwise
     */
    public boolean isAuthorized(ISession aSession, String anAction);
}
