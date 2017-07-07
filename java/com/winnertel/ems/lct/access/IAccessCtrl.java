package com.winnertel.ems.lct.access;

import java.util.Hashtable;
import javax.swing.JComponent;

public interface IAccessCtrl {
	JComponent getCtrlImpl();
	JComponent getDefaultCtrlImpl();
	Hashtable getAccess();
	void setAccess(Hashtable ht);
	void clear();
	int validate(String neType, String ipAddr);
}
