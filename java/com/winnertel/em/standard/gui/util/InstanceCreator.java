package com.winnertel.em.standard.gui.util;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.swing.tree.INodeDecorator;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.gui.SnmpTableFilter;
import com.winnertel.em.standard.snmp.gui.formatter.MibBeanIdFormatter;
import com.winnertel.em.standard.snmp.gui.formatter.SnmpFieldFormatter;

import java.lang.reflect.Constructor;

public class InstanceCreator {
    private static ILogger fgLogger = LoggerController.createLogger(InstanceCreator.class);

    public static BaseAction instantiateBaseAction(IApplication anApp, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        BaseAction result = null;
        try {
            result = (BaseAction) createInstance(aClazzName, IApplication.class, anApp);
        } catch (Exception ex) {
            fgLogger.debug("Error in creating action class instance", ex);
        }

        return result;
    }

    public static BaseAction instantiateBaseAction(IApplication anApp, String aClazzName, String[] aParameterArray) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        BaseAction result = null;
        try {
            result = (BaseAction) createInstance(aClazzName, new Class[]{IApplication.class, String[].class}, new Object[]{anApp, aParameterArray});
        } catch (Exception ex) {
            fgLogger.debug("Error in creating action class instance", ex);
        }

        return result;
    }

    public static BaseChecker instantiateCheker(IApplication anApp, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }
        BaseChecker result = null;
        try {
            result = (BaseChecker) createInstance(aClazzName, IApplication.class, anApp);
        } catch (Exception ex) {
            fgLogger.debug("Error in creating work class instance", ex);
        }

        return result;
    }

    public static SnmpMibBean instantiateSnmpMibBean(ISnmpProxy aSnmpProxy, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        SnmpMibBean result = null;
        try {
            result = (SnmpMibBean) createInstance(aClazzName, ISnmpProxy.class, aSnmpProxy);
        } catch (Exception ex) {
            fgLogger.debug("Error in create mib bean class instance: " + aClazzName, ex);
            return result;
        }
        return result;
    }

    public static SnmpTableFilter instantiateFilter(String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        SnmpTableFilter result = null;
        try {
            result = (SnmpTableFilter) Class.forName(aClazzName).newInstance();
        } catch (Exception ex) {
            fgLogger.debug("Error in create snmp filter class instance: " + aClazzName, ex);
            return result;
        }
        return result;
    }

    public static UPanel instantiatePanel(IApplication anApp, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        UPanel result = null;
        try {
            result = (UPanel) createInstance(aClazzName, IApplication.class, anApp);
        } catch (Exception ex) {
            fgLogger.debug("Error in creating UPanel instance: " + aClazzName, ex);
        }

        return result;
    }

    public static UDialog instantiateDialog(IApplication anApp, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        UDialog result = null;
        try {
            result = (UDialog) createInstance(aClazzName, IApplication.class, anApp);
        } catch (Exception ex) {
            fgLogger.debug("Error in creating UDialog instance: " + aClazzName, ex);
        }

        return result;
    }

    public static SnmpFieldFormatter instantiateFieldFormatter(IApplication anApp, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        SnmpFieldFormatter result = null;
        try {
            result = (SnmpFieldFormatter) createInstance(aClazzName, IApplication.class, anApp);
        } catch (Exception ex) {
            fgLogger.debug("Error in create field formatter class instance: " + aClazzName, ex);
            return result;
        }
        return result;
    }

    public static INodeDecorator instantiateNodeDecorator(IApplication anApp, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        INodeDecorator result = null;
        try {
            result = (INodeDecorator) createInstance(aClazzName, IApplication.class, anApp);
        } catch (Exception ex) {
            fgLogger.debug("Error in creating node decorator instance: " + aClazzName, ex);
        }

        return result;
    }

    public static Task instantiateTask(SnmpMibBean aSnmpMibBean, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        Task result = null;
        try {
            Class clazz = Class.forName(aClazzName);
            Constructor ctor = clazz.getDeclaredConstructor(new Class[]{SnmpMibBean.class});
            result = (Task) ctor.newInstance(new Object[]{aSnmpMibBean});
        } catch (Exception ex) {
            fgLogger.debug("Error in creating task class instance", ex);
        }

        return result;
    }

    public static Task instantiateTask(String aClazzName, IApplication anApp, IDeviceManager aDvm) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        Task result = null;
        try {
            Class clazz = Class.forName(aClazzName);
            Constructor ctor = clazz.getDeclaredConstructor(new Class[]{IApplication.class, IDeviceManager.class});
            result = (Task) ctor.newInstance(new Object[]{anApp, aDvm});
        } catch (Exception ex) {
            fgLogger.debug("Error in creating task class instance", ex);
        }

        return result;
    }

    public static Object instantiateObject(String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        Object result = null;
        try {
            result = Class.forName(aClazzName).newInstance();
        } catch (Exception ex) {
            fgLogger.debug("Error in creating object instance: " + aClazzName, ex);
        }

        return result;
    }

    public static Object instantiateObject(IApplication anApp, String aClazzName) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        Object result = null;
        try {
            result = createInstance(aClazzName, IApplication.class, anApp);
        } catch (Exception ex) {
            fgLogger.debug("Error in creating object instance: " + aClazzName, ex);
        }

        return result;
    }

    public static MibBeanIdFormatter instantiateIdFormatter(IApplication anApp, String aClazzName, String aPattern) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        MibBeanIdFormatter result = null;
        try {
            result = (MibBeanIdFormatter) createInstance(aClazzName, new Class[]{IApplication.class, String.class}, new Object[]{anApp, aPattern});
        } catch (Exception ex) {
            fgLogger.debug("Error in mib bean id formatter class instance", ex);
        }

        return result;
    }

    private static Object createInstance(String aClazzName, Class aClass, Object anObject) throws Exception {
        return createInstance(aClazzName, new Class[]{aClass}, new Object[]{anObject});
    }

    private static Object createInstance(String aClazzName, Class[] aClassArray, Object[] anObjectArray) throws Exception {
        Object result = null;

        Class clazz = Class.forName(aClazzName);
        Constructor ctor = clazz.getDeclaredConstructor(aClassArray);
        result = ctor.newInstance(anObjectArray);

        return result;
    }

    private static boolean isValidClassName(String aClazzName) {
        if (aClazzName == null || aClazzName.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    // add for supporting other transport layer protocol, such as SFTP
    public static ISnmpProxy instantiateSnmpProxy(String aClazzName, ISnmpParameter snmpParam) {
        if (isValidClassName(aClazzName) == false) {
            return null;
        }

        ISnmpProxy result = null;
        try {
            Class clazz = Class.forName(aClazzName);
            Constructor ctor = clazz.getDeclaredConstructor(new Class[]{ISnmpParameter.class});
            result = (ISnmpProxy) ctor.newInstance(new Object[]{snmpParam});
        } catch (Exception ex) {
            fgLogger.debug("Error in creating snmp proxy class instance", ex);
        }

        return result;
    }
}
