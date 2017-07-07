package com.winnertel.em.standard.task;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.util.IStringMap;
import com.winnertel.em.framework.task.ITaskManager;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.util.SwingWorker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;


public class TaskManager implements ITaskManager {
    private ILogger fLogger = LoggerController.createLogger(TaskManager.class);

    private IApplication fApplication = null;


    public TaskManager(IApplication anApplication) {
        fApplication = anApplication;
    }


    public synchronized Object executeTask(Task aTask) throws Exception {
        checkTask(aTask);

        WaitDialog dialog = getWaitDialog(aTask);
        TaskThread thread = new TaskThread(aTask, dialog);
        return executeThread(thread, dialog);
    }

    private void checkTask(Task aTask) {
        if (aTask == null) {
            throw new IllegalArgumentException("Task can't be null");
        }
    }


    public Object executeTaskInBackground(Task aTask) throws Exception {
        checkTask(aTask);

        TaskThread thread = new TaskThread(aTask, null);
        return executeThread(thread, null);
    }

    private Object executeThread(TaskThread aThread, WaitDialog aDialog) throws Exception {
        Task tTask = aThread.getTask();
        aThread.start();
        tTask.setStatus(Task.RUNNING);

        if (aDialog != null) {
            aDialog.setTaskThread(aThread);
            aDialog.show();
        }

        if (aThread.getException() != null) {
            tTask.setStatus(Task.FAILED);
            throw aThread.getException();
        } else {
            if (aThread.isCanceled()) {
                tTask.setStatus(Task.CANCELED);
            } else {
                tTask.setStatus(Task.COMPLETED);
            }
        }

        return aThread.get();
    }


    private WaitDialog getWaitDialog(Task aTask) {
        return new WaitDialog(fApplication, aTask);
    }


    private class WaitDialog extends UDialog {
        private TaskThread fTaskThread = null;
        //added for new feature implementation by Rex.zhu at 2004-01-13
        private Task fTask = null;
        private boolean fDisposed;


        public WaitDialog(IApplication app, Task aTask) {
            super(app);
            fTask = aTask;
            init();
        }


        public boolean isDisposed() {
            return fDisposed;
        }


        protected void processWindowEvent(WindowEvent e) {
            if (e != null && e.getID() == WindowEvent.WINDOW_CLOSING) {
                if (fTask.isCancelable()) {
                    onCancel();
                } else {
                    return;
                }
            }
            super.processWindowEvent(e);
        }//added for new feature implementation by Rex.zhu at 2004-01-13

        protected void init() {
            setResizable(false);
            IStringMap stringMap = this.fApplication.getGlobalStringMap();
            setTitle(stringMap.getString("Operation progress"));

            JPanel mainPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 6, 6));
            //changed for new feature implementation by Rex.zhu at 2004-01-13
            String prompt = stringMap.getString("Operation in process, please wait...");
            if (fTask != null && fTask.getWaitPrompt() != null) {
                prompt = fTask.getWaitPrompt();
            }
            JLabel label = new JLabel(prompt, JLabel.CENTER);

            URL imgUrl = getClass().getResource("/com/winnertel/em/standard/task/clock.gif");
            if (imgUrl != null) {
                Icon tIcon = new ImageIcon(imgUrl);
                JLabel image = new JLabel(tIcon, JLabel.CENTER);
                mainPane.add(image);
            }
            mainPane.add(label);
            getContentPane().add(mainPane, BorderLayout.CENTER);
            getContentPane().add(Box.createHorizontalStrut(10), BorderLayout.EAST);
            getContentPane().add(Box.createHorizontalStrut(10), BorderLayout.WEST);

            //changed for new feature implementation by Rex.zhu at 2004-01-13
            if (fTask.isCancelable()) {
                JButton btnCancel = new JButton(stringMap.getString("Cancel"));
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
            fTaskThread.stop();
            fTaskThread.setCanceled(true);
            dispose();
            fDisposed = true;
        }


        public void setTaskThread(TaskThread aThead) {
            fTaskThread = aThead;
        }


        public void show() {
            pack();
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
                fLogger.error("Error in execute task", ex);
                fException = ex;
                return null;
            }
        }


        public void finished() {
            this.stop();
            if (fWaitDialog == null || fWaitDialog.isDisposed()) {
                return;
            }

            if (fWaitDialog.isShowing()) {
                // if waiting dialog is shown before the thread is finished
                fWaitDialog.dispose();
            } else {
                // if waiting dialog is not shown after the thread is finished
                while (!fWaitDialog.isShowing()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
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
