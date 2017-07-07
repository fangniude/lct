/**
 * Created by Zhou Chao, 2009/2/24
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r100;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class OnuFastLeaveCapabilityFormatter extends SnmpFieldFormatter {

    public OnuFastLeaveCapabilityFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            int value = ((Long) MibBeanUtil.getSimpleProperty(aMibBean, aProperty)).intValue();
            if (value > 0) {
                String text = "";
                int bit = value;
                for (int i = 0; i < 4; i++) {
                    bit = (bit & 0x01); //0: not support, 1: support
                    if (bit == 1) {
                        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
                        if (i == 0) {
                            text = composer.getString("Fast leave in CTC distributed mode");
                        } else if (i == 1) {
                            if (text.length() > 0)
                                text += " | ";
                            text += composer.getString("Non fast leave in CTC distributed mode");
                        } else if (i == 2) {
                            if (text.length() > 0)
                                text += " | ";
                            text += composer.getString("Fast leave in CTC controllable mode");
                        } else if (i == 3) {
                            if (text.length() > 0)
                                text += " | ";
                            text += composer.getString("Non fast leave in CTC controllable mode");
                        }
                    }
                    bit = value >> (i + 1);
                }
                return text;
            }

            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}