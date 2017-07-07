package com.winnertel.em.framework.model;

import java.util.Vector;

public interface IMibBean {
    public boolean retrieve() throws MibBeanException;

    public Vector retrieveAll() throws MibBeanException;

    public boolean add() throws MibBeanException;

    public boolean modify() throws MibBeanException;

    public boolean delete() throws MibBeanException;
}
