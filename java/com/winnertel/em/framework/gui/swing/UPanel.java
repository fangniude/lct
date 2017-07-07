package com.winnertel.em.framework.gui.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.event.UEvent;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.framework.model.IMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTable;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class UPanel extends JPanel {
    protected IApplication fApplication = null;

    protected DvmStringMap fStringMap = null;

    protected SnmpTable fTable = null;

    protected IMibBean fModel = null;

    protected String fCommand = null;


    public UPanel(IApplication app) {
        super();
        initialize(app);
    }


    private void initialize(IApplication app) {
        fApplication = app;
        if (fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }
    }


    protected void init() {
        initGui();
        initForm();
    }

    protected abstract void initGui();

    protected void initForm() {
    }


    public abstract void refresh();


    public IMibBean getModel() {
        return fModel;
    }

    public void setModel(IMibBean aModel) {
        fModel = aModel;
    }

    public SnmpTable getTable() {
        return fTable;
    }

    //reference to the snmp table.
    public void setTable(SnmpTable aTable) {
        fTable = aTable;
    }

    public void setCommand(String aCommand) {
        fCommand = aCommand;
    }


    /**
     * Most time subclass should override this method to update the model
     * from gui based on the user input.
     */
    public void updateModel() {
    }

    /**
     * This method executes before update model
     */
    public void beforeUpdateModel() {
    }

    /**
     * This method executes after update model
     */
    public void afterUpdateModel() {
    }


    public boolean validateFrom() {
        return true;
    }


    /**
     * This helper method create a panel instance.
     *
     * @return a panel instance
     */
    public static UPanel createInstance(IApplication anApplication) {
        return new UPanel(anApplication) {
            protected void initGui() {
            }

            public void refresh() {
            }
        };
    }

    /**
     * invoked by NS listener to update the data.
     *
     * @param e The event received from Server.
     */
    public void update(UEvent e) {

    }


    protected void firePropertyChange( PropertyChangeEvent event ) {
        if( fPropertyChangeListener != null ) {
            fPropertyChangeListener.propertyChange(event);
        }
    }

    public void setPropertyChangeListener(PropertyChangeListener listener) {
        fPropertyChangeListener = listener;
    }

    private PropertyChangeListener fPropertyChangeListener = null;
}
