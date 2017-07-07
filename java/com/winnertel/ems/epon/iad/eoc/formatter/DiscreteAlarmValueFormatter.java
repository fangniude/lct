package com.winnertel.ems.epon.iad.eoc.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 2010-8-6
 * Time: 14:34:47
 * To change this template use File | Settings | File Templates.
 */
public class DiscreteAlarmValueFormatter extends SnmpFieldFormatter {

    public DiscreteAlarmValueFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (obj == null) return null;

        String tmpValue = null;

        String refObj = null;
        if (aProperty.compareTo("discreteAlarmParameterOID") == 0) {
            String tmpObj = (String) obj;
            tmpValue = getLastOIDItem(tmpObj);
            refObj = tmpObj;
        } else if (aProperty.compareTo("currentAlarmValue") == 0) { //currentAlarmValue
            Integer tmpObj = (Integer) obj;
            tmpValue = String.valueOf(tmpObj);
            refObj = (String) MibBeanUtil.getSimpleProperty(aMibBean, "currentAlarmOID");
        }

        if (refObj == null) {
            return "Error ref mib:" + aProperty + ",error value:" + tmpValue;
        }

        if (tmpValue == null) {
            return "Error value:" + tmpValue;
        }
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();
        return getValueAs(composer, refObj, tmpValue);

    }

    protected static String getValueAs(IGuiComposer composer, String refObj, String tmpValue) {
        //IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();

        if (refObj.indexOf(AlarmLogInformationFormatter.modEoCCBATAdminTamperStatus_OID) >= 0) {
            if (tmpValue.compareTo("1") == 0) {
                return composer.getString("intact");
            } else if (tmpValue.compareTo("2") == 0) {
                return composer.getString("compromised");
            } else if (tmpValue.compareTo("0") == 0) {
                return composer.getString("unknown");
            } else {
                return tmpValue;
            }
        } else if (refObj.indexOf(AlarmLogInformationFormatter.modEoCCBATCardOnlineStatus_OID) >= 0) {
            if (tmpValue.compareTo("0") == 0) {
                return composer.getString("offline");
            } else if (tmpValue.compareTo("1") == 0) {
                return composer.getString("online");
            } else {
                return tmpValue;
            }
        } else if (refObj.indexOf(AlarmLogInformationFormatter.modEoCCNUOnlineStatus_OID) >= 0) {
            if (tmpValue.compareTo("0") == 0) {
                return composer.getString("offline");
            } else if (tmpValue.compareTo("1") == 0) {
                return composer.getString("online");
            } else {
                return tmpValue;
            }
        }

        return tmpValue;

    }

    public static String getLastOIDItem(String tmpObj) {

        String[] allNum = tmpObj.split("[.]");

        String retStr = "";
        if (allNum != null && allNum.length > 0) {
            retStr = allNum[allNum.length - 1];
        }

        return retStr;
    }
}
