package com.winnertel.ems.epon.iad.bbs4000.gui.r210.action;

import com.winnertel.ems.epon.iad.bbs4000.mib.r210.PortDiagnosisMBean;
import com.winnertel.em.framework.task.Task;

public class DiagnosisTask extends Task {

	PortDiagnosisMBean fBean = null;

	public DiagnosisTask( PortDiagnosisMBean bean) {
		fBean = bean;
	}

	public Object execute() throws Exception {
		return fBean.modify() ? Boolean.TRUE : Boolean.FALSE;
	}

}
