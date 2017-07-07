package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.text.DecimalFormat;

public class OnuOlsFormatter extends SnmpFieldFormatter{

    public OnuOlsFormatter(IApplication app){
        super(app);
    }
    
    public Object format(SnmpMibBean mibBean, String property) throws Exception {
        double temp = 0;
        DecimalFormat format = new DecimalFormat("0.000");
        if(property.equals("onuOlsTemperature")){
            temp = ((Integer)MibBeanUtil.getSimpleProperty(mibBean, property))*0.25;
            
        }
        else if(property.equals("onuOlsVoltage")){
            temp= ((Integer)MibBeanUtil.getSimpleProperty(mibBean, property))*0.0001;
        }
        else if(property.equals("onuOlsBiasCurrent")){
            temp = ((Integer)MibBeanUtil.getSimpleProperty(mibBean, property))*0.002;
        }
        else if(property.equals("onuOlsTxPower")||property.equals("onuOlsRxPower")){
            temp= ((Integer)MibBeanUtil.getSimpleProperty(mibBean, property))*0.1;
        }
        return format.format(temp);
    }
}
    