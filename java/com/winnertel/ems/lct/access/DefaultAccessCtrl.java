package com.winnertel.ems.lct.access;

import java.util.Hashtable;

import javax.swing.JComponent;

public class DefaultAccessCtrl implements IAccessCtrl {
	
	public Hashtable getAccess() {
		return null;
	}
	
	String fNeType = null;
	
	public DefaultAccessCtrl() {}
	
	public DefaultAccessCtrl( String neType ) {
		fNeType = neType;
	}
	
	public JComponent getDefaultCtrlImpl() {
		return  null;
	}

	public JComponent getCtrlImpl() {
		return null;
	}
	
	public void clear() {}
	
	public int validate( String neType, String ipAddr ) {
		return 0;
	}

	public void setAccess(Hashtable ht) {
	}
	
}
