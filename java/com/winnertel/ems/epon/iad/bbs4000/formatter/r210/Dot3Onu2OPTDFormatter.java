package com.winnertel.ems.epon.iad.bbs4000.formatter.r210;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.DecimalFormat;

public class Dot3Onu2OPTDFormatter extends SnmpFieldFormatter {

    public Dot3Onu2OPTDFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        Integer value = (Integer) MibBeanUtil.getSimpleProperty(mibBean, property);

        DecimalFormat df2  = new DecimalFormat("0.##");
        if("utsDot3OnuOpticalTransceiverDiagnosisTemperature".equals(property)) {
            double b = value/(double)256;

            return df2.format(b);
        } else if("utsDot3OnuOpticalTransceiverDiagnosisVoltage".equals(property) || "utsDot3OnuOpticalTransceiverDiagnosisTxBiasCurrent".equals(property)) {
            double b = value/(double)1000;
            return df2.format(b);
        } else if("utsDot3OnuOpticalTransceiverDiagnosisTxPower".equals(property) || "utsDot3OnuOpticalTransceiverDiagnosisRxPower".equals(property)) {
            double b = 10 * Math.log10(value/(double)10000);
            return df2.format(b);
        } else {
            return value;
        }
    }

}
