package com.winnertel.ems.epon.iad.bbs4000.gui.r310.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r310.Dot3Onu2OPTDTable;
import com.winnertel.em.framework.task.Task;

public class DiagnosisPmSwitchTask extends Task {

	Dot3Onu2OPTDTable fBean = null;

	public DiagnosisPmSwitchTask( Dot3Onu2OPTDTable bean) {
		fBean = bean;
	}

	public Object execute() throws Exception {
		return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
	}

}