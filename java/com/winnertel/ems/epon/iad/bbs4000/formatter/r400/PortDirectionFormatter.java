/**
 * Created by Zhou Chao, 2010/4/16
 */

package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

public class PortDirectionFormatter extends SnmpFieldFormatter {

    public PortDirectionFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        try {
            byte[] direction = (byte[]) MibBeanUtil.getSimpleProperty(aMibBean, aProperty);
            if (direction != null && direction.length > 0) {
                boolean isEgress = ((direction[0] & 0x40) != 0);
                boolean isIngress = ((direction[0] & 0x80) != 0);

                IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
                String value = "";
                if (isEgress) {
                    if (value.length() > 0)
                        value += "/";
                    value += composer.getString("egress");
                }
                if (isIngress) {
                    if (value.length() > 0)
                        value += "/";
                    value += composer.getString("ingress");
                }

                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

}