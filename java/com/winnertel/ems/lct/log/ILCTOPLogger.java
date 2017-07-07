package com.winnertel.ems.lct.log;

import com.winnertel.em.framework.IApplication;

public interface ILCTOPLogger {
	public void writeOPLog(String object, int level, String opType,
                           String description, boolean result);

	public void writeOPLog(String object, String opType, String description,
                           boolean result);
	
	public void setApplication(IApplication app);

}
