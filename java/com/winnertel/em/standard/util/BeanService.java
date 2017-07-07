package com.winnertel.em.standard.util;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.task.ITaskManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.snmp.task.RefreshAllTask;
import com.winnertel.em.standard.snmp.task.RefreshTask;

import java.util.Vector;

public class BeanService {

    public static Vector refreshTableBean(IApplication app, SnmpMibBean bean) {
        Task t = new RefreshAllTask(bean);
        ITaskManager tm = app.getTaskManager();
        Vector results = null;
        try {
            results = (Vector) tm.executeTask(t);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            MessageDialog.showOperationFailedDialog(app);
        }
        if (results == null)
            return new Vector();
        return results;
    }

    public static Object refreshBean(IApplication app, SnmpMibBean bean) {
        Task t = new RefreshTask(bean);
        ITaskManager tm = app.getTaskManager();
        //SnmpMibBean result = null;
        try {
            return tm.executeTask(t);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            MessageDialog.showOperationFailedDialog(app);
        }
        return null;
    }

    public static void modifyBean(IApplication app, Task modifyTask) {

        ITaskManager tm = app.getTaskManager();
        try {
            tm.executeTask(modifyTask);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            MessageDialog.showOperationFailedDialog(app);
            modifyTask.setStatus(Task.FAILED);
            return;
            //the thread exception , the task status has been setted as failed
            // , so , here swallow the exception
        }
        if (modifyTask.getStatus() == Task.COMPLETED)
            MessageDialog.showOperationSucceedDialog(app);

    }

    public static void modifyBean(IApplication app, Task modifyTask, boolean background) {

        ITaskManager tm = app.getTaskManager();
        try {
            tm.executeTask(modifyTask);
        } catch (Exception e) {
            e.printStackTrace(System.err);

            if (!background) {
                MessageDialog.showOperationFailedDialog(app);
            }
            modifyTask.setStatus(Task.FAILED);
            return;
        }
        if (modifyTask.getStatus() == Task.COMPLETED)
            if (!background) {
                MessageDialog.showOperationSucceedDialog(app);
            }
    }

    /**
     * have a waiting , use task.getstatus() to get the status , and  change community
     */
    public static void modifyBean(IApplication app, Task modifyTask, String community) {
        String oldCommunity = app.getSnmpProxy().getWriteCommunity();
        app.getSnmpProxy().setWriteCommunity(community);
        ITaskManager tm = app.getTaskManager();
        try {
            tm.executeTask(modifyTask);
        } catch (Exception e) {
            e.printStackTrace(System.err);
            MessageDialog.showOperationFailedDialog(app);
            modifyTask.setStatus(Task.FAILED);
            return;
            //the thread exception , the task status has been setted as failed
            // , so , here swallow the exception
        } finally {
            app.getSnmpProxy().setWriteCommunity(oldCommunity);
        }
        if (modifyTask.getStatus() == Task.COMPLETED)
            MessageDialog.showOperationSucceedDialog(app);

    }

    /**
     * don't use task ,disable the waiting dialog
     *
     * @param app
     * @param modifyTask
     */
    public static boolean modifyBean(IApplication app, SnmpMibBean bean) {

        boolean isOk = true;
        try {
            isOk = bean.modify();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        }
        return isOk;
    }

    /**
     * don't use task ,disable the waiting dialog
     *
     * @param app
     * @param modifyTask
     */
    public static boolean modifyBean(IApplication app, SnmpMibBean bean, String community) {
        String oldCommunity = app.getSnmpProxy().getWriteCommunity();
        app.getSnmpProxy().setWriteCommunity(community);
        boolean isOk = true;
        try {
            isOk = bean.modify();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return false;
        } finally {
            app.getSnmpProxy().setWriteCommunity(oldCommunity);
        }
        return isOk;
    }

    /**
     * don't use task ,disable the waiting dialog
     *
     * @param app
     * @param modifyTask
     */
    public static boolean modifyBean(IApplication app, SnmpMibBean bean, int retries) {

        int oldRetries = app.getSnmpProxy().getRetries();
        app.getSnmpProxy().setRetries(retries);
        boolean result = modifyBean(app, bean);
        app.getSnmpProxy().setRetries(oldRetries);
        return result;
    }

    public static boolean modifyBean(IApplication app, SnmpMibBean bean, String community, int retries) {

        String oldCommunity = app.getSnmpProxy().getWriteCommunity();
        app.getSnmpProxy().setWriteCommunity(community);
        boolean result = modifyBean(app, bean, retries);
        app.getSnmpProxy().setWriteCommunity(oldCommunity);
        return result;
    }

    /**
     * refresh that can't be canceled , you can set the retries
     */
    public static boolean refreshBean(IApplication app, SnmpMibBean bean, int retries) {
        int oldRetries = app.getSnmpProxy().getRetries();
        app.getSnmpProxy().setRetries(retries);
        boolean isOk = true;

        try {
            isOk = bean.retrieve();
            /*
                * } catch (Exception e) { //the thread exception , the task status
                * has been setted as failed // , so , here swallow the exception }
                * finally { app.getSnmpProxy().setRetries(oldRetries); }
                */
        } catch (MibBeanException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            app.getSnmpProxy().setRetries(oldRetries);
        }
        return isOk;
    }
}
