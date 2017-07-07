package com.winnertel.em.framework.model.util;

import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import org.apache.commons.beanutils.PropertyUtils;

public class MibBeanUtil {
    private static ILogger fgLogger = LoggerController.createLogger(MibBeanUtil.class);


    public static Object getSimpleProperty(Object aBean, String aPropertyName) {
        try {
            return PropertyUtils.getSimpleProperty(aBean, convertToLegalProperty( aPropertyName ) );
        } catch (Exception ex) {
            fgLogger.debug("Error in get property " + aPropertyName
                    + " of bean " + aBean.getClass().getName(), ex);
            return null;
        }
    }

    public static void setSimpleProperty(Object aBean, String aPropertyName, Object aValue) {
        try {
            PropertyUtils.setSimpleProperty(aBean, convertToLegalProperty( aPropertyName ), aValue);
        } catch (Exception ex) {
            fgLogger.debug("Error in set property " + aPropertyName
                    + " of bean " + aBean.getClass().getName(), ex);
        }
    }

    private static String convertToLegalProperty(String propertyName) {
        if( propertyName == null || propertyName.isEmpty() ) {
            return null;
        }
        char c = propertyName.charAt(0);

        return Character.toLowerCase(c) + propertyName.substring(1);

    }
}
