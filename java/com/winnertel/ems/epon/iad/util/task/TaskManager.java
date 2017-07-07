/*
 * Copyright (c) 2002-2003 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.util.task;

import com.winnertel.ems.epon.iad.util.GuiUtils;
import com.winnertel.em.framework.task.ITaskManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.util.gui.input.resource.ResourceBundleProxy;
import com.winnertel.util.SwingWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;


/**
 * The TaskManager class.
 *
 * @author Jason Hao
 */
public class TaskManager implements ITaskManager {
    private ILogger fLogger = LoggerController.createLogger(TaskManager.class);

    public TaskManager() {
    }


    public synchronized Object executeTask(Task aTask) throws Exception {
        checkTask( aTask );

        WaitDialog dialog = getWaitDialog( aTask );
        TaskThread thread = new TaskThread(aTask, dialog);
        return executeThread(thread, dialog);
    }

    public synchronized Object executeTask(Task aTask, Dialog parent) throws Exception{
      checkTask( aTask );

      WaitDialog dialog = getWaitDialog(aTask, parent);
      TaskThread thread = new TaskThread(aTask, dialog);
      return executeThread(thread, dialog);
    }

    public synchronized Object executeTask(Task aTask, Frame parent) throws Exception{
      checkTask( aTask );

      WaitDialog dialog = getWaitDialog(aTask, parent);
      TaskThread thread = new TaskThread(aTask, dialog);
      return executeThread(thread, dialog);
    }

    private void checkTask( Task aTask ) {
        if ( aTask == null ) {
            throw new IllegalArgumentException( "Task can't be null" );
        }
    }

    public Object executeTaskInBackground(Task aTask) throws Exception {
        checkTask( aTask );

        TaskThread thread = new TaskThread(aTask, null);
        return executeThread(thread, null);
    }

    private Object executeThread(TaskThread aThread, WaitDialog aDialog) throws Exception {
        Task tTask = aThread.getTask();
        aThread.start();
        tTask.setStatus(Task.RUNNING);

        if ( aDialog != null ) {
            aDialog.setTaskThread(aThread);
            aDialog.show();
        }

        if (aThread.getException() != null) {
            tTask.setStatus(Task.FAILED);
            throw aThread.getException();
        } else {
            if ( aThread.isCanceled() ) {
                tTask.setStatus(Task.CANCELED);
            } else {
                tTask.setStatus(Task.COMPLETED);
            }
        }

        return aThread.get();
    }


    private WaitDialog getWaitDialog(Task aTask) {
        return new WaitDialog(aTask);
    }

    private WaitDialog getWaitDialog(Task aTask, Dialog parent) {
        return new WaitDialog(aTask, parent);
    }

    private WaitDialog getWaitDialog(Task aTask, Frame parent) {
        return new WaitDialog(aTask, parent);
    }


    private class WaitDialog extends JDialog {
        private TaskThread fTaskThread = null;
        //added for new feature implementation by Rex.zhu at 2004-01-13
        private Task fTask = null;
        private boolean fDisposed;

        public WaitDialog(Task aTask) {
            fTask = aTask;
            init();
        }

        public WaitDialog(Task aTask, Dialog parent) {
            super(parent, true);
            fTask = aTask;
            init();
        }

        public WaitDialog(Task aTask, Frame parent) {
            super(parent, true);
            fTask = aTask;
            init();
        }

        public boolean isDisposed() {
            return fDisposed;
        }


        protected void processWindowEvent( WindowEvent e ) {
            if( e != null && e.getID() == WindowEvent.WINDOW_CLOSING ) {
                if( fTask.isCancelable() ) {
                    onCancel();
                } else {
                    return;
                }
            }
            super.processWindowEvent( e );
        }//added for new feature implementation by Rex.zhu at 2004-01-13

        protected void init() {
            setResizable(false);
            String sTitle = ResourceBundleProxy.getInstance().getString("Operation progress");
            setTitle(sTitle);

            JPanel mainPane = new JPanel( new FlowLayout( FlowLayout.CENTER, 6, 6 ) );
            //changed for new feature implementation by Rex.zhu at 2004-01-13
            String prompt = ResourceBundleProxy.getInstance().getString("Wait_Message");

            if( fTask != null && fTask.getWaitPrompt() != null ) {
                prompt = fTask.getWaitPrompt();
            }
            JLabel label = new JLabel(prompt, JLabel.CENTER);

            URL imgUrl = getClass().getResource( "Clock.gif" );
            if ( imgUrl != null ) {
                Icon tIcon = new ImageIcon( imgUrl );
                JLabel image = new JLabel( tIcon, JLabel.CENTER );
                mainPane.add( image );
            }
            mainPane.add( label );
            getContentPane().add(mainPane, BorderLayout.CENTER);
            getContentPane().add( Box.createHorizontalStrut( 10 ), BorderLayout.EAST );
            getContentPane().add( Box.createHorizontalStrut( 10 ), BorderLayout.WEST );

            //changed for new feature implementation by Rex.zhu at 2004-01-13
            if( fTask.isCancelable() ) {
                JButton btnCancel = new JButton(ResourceBundleProxy.getInstance().getString("Cancel"));
                btnCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onCancel();
                    }
                });
                JPanel controlPane = new JPanel();
                controlPane.add(btnCancel);
                getContentPane().add(controlPane, BorderLayout.SOUTH);
            }
        }

        private void onCancel() {
            fTaskThread.interrupt();
            fTaskThread.setCanceled(true);
            dispose();
            fDisposed = true;
        }


        public void setTaskThread(TaskThread aThead) {
            fTaskThread = aThead;
        }


        public void show() {
            pack();
            GuiUtils.center(this);
            super.show();
        }
    }


    private class TaskThread extends SwingWorker {
        private Task fTask = null;
        private WaitDialog fWaitDialog = null;
        private Exception fException = null;
        private boolean fCanceled = false;


        public TaskThread(Task aTask, WaitDialog aDialog) {
            fTask = aTask;
            fWaitDialog = aDialog;
        }


        public Object construct() {
            try {
                return fTask.execute();
            } catch (Exception ex) {
                fLogger.debug("Error in execute task", ex);
                fException = ex;
                return null;
            }
        }


        public void finished() {
            if ( fWaitDialog == null || fWaitDialog.isDisposed() ) {
                return;
            }

            if ( fWaitDialog.isShowing() ) {
                // if waiting dialog is shown before the thread is finished
                fWaitDialog.dispose();
            } else {
                // if waiting dialog is not shown after the thread is finished
                while( !fWaitDialog.isShowing() ) {
                    try {
                        Thread.sleep( 100 );
                    } catch ( InterruptedException ex ) {
                    }
                }
                fWaitDialog.dispose();
            }
        }


        public Exception getException() {
            return fException;
        }


        public boolean isCanceled() {
            return fCanceled;
        }

        public void setCanceled(boolean aCanceled) {
            fCanceled = aCanceled;
        }


        public Task getTask() {
            return fTask;
        }
    }
}
