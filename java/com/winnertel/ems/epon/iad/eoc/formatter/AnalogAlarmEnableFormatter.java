package com.winnertel.ems.epon.iad.eoc.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-8-3
 * Time: 11:14:14
 * To change this template use File | Settings | File Templates.
 */
public class AnalogAlarmEnableFormatter extends SnmpFieldFormatter {

    public AnalogAlarmEnableFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (obj == null) return null;

        byte[] tmpObj = (byte[]) obj;

        StringBuffer sb = new StringBuffer();

        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();

        if (tmpObj != null && tmpObj.length > 0) {

            if ((tmpObj[0] & (0x01)) == (0x01)) {
                sb.append(" ").append(composer.getString("analogAlarmEnable_LOLO"));
            } else if ((tmpObj[0] & (0x02)) == (0x02)) {
                sb.append(" ").append(composer.getString("analogAlarmEnable_LO"));
            } else if ((tmpObj[0] & (0x04)) == (0x04)) {
                sb.append(" ").append(composer.getString("analogAlarmEnable_HI"));
            } else if ((tmpObj[0] & (0x08)) == (0x08)) {
                sb.append(" ").append(composer.getString("analogAlarmEnable_HIHI"));
            } else {
                sb.append(" ").append(composer.getString("analogAlarmEnable_ALLCLOSE"));
            }

//            sb.append(" 0x").append(Integer.toHexString(tmpObj[0]));
        }

        return sb.toString();
    }
}
