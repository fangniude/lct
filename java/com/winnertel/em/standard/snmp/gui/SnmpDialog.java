package com.winnertel.em.standard.snmp.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SnmpDialog extends UDialog implements PropertyChangeListener {
    //private SnmpApplyButton fApplyButton = null;
    private String fApplyId = null;
    private SnmpTable fTable = null;

    private String fCommand = null;

    private UPanel fPanel = null;
    private Object[] fStyle = null;
    private java.util.List fButtonList = null;

    public final static String STYLE_OK = "O";
    public final static String STYLE_REFRESH = "R";
    public final static String STYLE_CANCEL = "C";
    public final static String STYLE_CLOSE = "Q";
    public final static String STYLE_APPLY = "A";
    private final static String STYLE_DELIM = "|";

    public SnmpDialog(IApplication app, String title, String command, String style) {
        super(app, title);
        fCommand = command;
        fStyle = createStyles(style);
        init();
    }

    public SnmpDialog(Window win, IApplication app, String title, String command, String style) {
        super(win, app, title, Dialog.ModalityType.DOCUMENT_MODAL);
        fCommand = command;
        fStyle = createStyles(style);
        init();
    }

    private Object[] createStyles(String aStyle) {
        if (aStyle == null) {
            return getDefaultStyle();
        }
        java.util.List tokens = new ArrayList();
        StringTokenizer tokenizer = new StringTokenizer(aStyle, STYLE_DELIM);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isLegalToken(token)) {
                tokens.add(token);
            }
        }
        return tokens.toArray();
    }

    private boolean isLegalToken(String token) {
        return token.equals(STYLE_APPLY) || token.equals(STYLE_CANCEL) || token.equals(STYLE_CLOSE) ||
                token.equals(STYLE_OK) || token.equals(STYLE_REFRESH);
    }

    private String[] getDefaultStyle() {
        return new String[]{STYLE_APPLY, STYLE_CLOSE};
    }

    protected void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        setResizable(false);
    }

    public void setMask(String mask, boolean visible) {
        if (mask == null) {
            return;
        }
        Object[] masks = createStyles(mask);
        for (int x = 0; x < fStyle.length; x++) {
            for (int y = 0; y < masks.length; y++) {
                if (masks[y].equals(fStyle[x])) {
                    ((JButton) fButtonList.get(x)).setVisible(visible);
                }
            }
        }
    }

    public void setApplyId(String applyId) {
        fApplyId = applyId;
    }
    /*
    public void setApplyButton( SnmpApplyButton aApplyButton ) {
        fApplyButton = aApplyButton;
    }
    */

    private java.util.List parseStyleButton(UPanel aPanel) {
        fButtonList = new ArrayList();
        for (int x = 0; x < fStyle.length; x++) {
            String token = fStyle[x].toString();
            JButton button = null;
            if (STYLE_APPLY.equals(token)) {
                button = new SnmpApplyButton(fApplication, aPanel);
                SnmpAction action = (SnmpAction) button.getAction();
                action.putValue(BaseAction.ID, fApplyId);
                action.putValue(SnmpAction.COMMAND, fCommand);
                action.setTable(fTable);
            } else if (STYLE_CLOSE.equals(token)) {
                button = new SnmpCloseButton(fApplication, aPanel);
            } else if (STYLE_CANCEL.equals(token)) {
                button = new SnmpCancelButton(fApplication, aPanel);
            } else if (STYLE_OK.equals(token)) {
                button = new SnmpOKButton(fApplication, aPanel);
                SnmpAction action = (SnmpAction) button.getAction();
                action.putValue(BaseAction.ID, fApplyId);
                action.putValue(SnmpAction.COMMAND, fCommand);
                action.setTable(fTable);
            } else if (STYLE_REFRESH.equals(token)) {
                button = new SnmpRefreshButton(fApplication, aPanel);
            }
            fButtonList.add(button);
        }
        return fButtonList;
    }

    public void setPanel(UPanel aPanel) {
        Container contentPane = getContentPane();
        JPanel controlPane = new JPanel();

        java.util.List styles = parseStyleButton(aPanel);
        for (int x = 0; x < styles.size(); x++) {
            JButton btn = (JButton) styles.get(x);
            controlPane.add(btn);
        }
        /*
        if ( fApplyButton == null ) {
            fApplyButton = new SnmpApplyButton(fApplication, aPanel);
        }
        ApplyAction action = (ApplyAction) fApplyButton.getAction();
        action.putValue(SnmpAction.COMMAND, fCommand);
        action.setTable(fTable);
        controlPane.add(fApplyButton);

        JButton btnClose = new SnmpCloseButton(fApplication, this);
        controlPane.add(btnClose);
        */
        contentPane.add(controlPane, BorderLayout.SOUTH);

        contentPane.add(aPanel, BorderLayout.CENTER);

        fPanel = aPanel;

        fPanel.setPropertyChangeListener( this );
    }


    public UPanel getPanel() {
        return fPanel;
    }


    public void setTable(SnmpTable aTable) {
        fTable = aTable;
    }

    public SnmpTable getTable() {
        return fTable;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String property = evt.getPropertyName();
        Object newValue = evt.getNewValue();
        if( property != null ) {
            if( property.endsWith(".enabled") && newValue != null ) {
                try {
                    changeOperation( Boolean.parseBoolean(newValue.toString()) );
                } catch ( Exception ex ) {
                    ex.printStackTrace();
                }
            }
        }

    }

    private void changeOperation( boolean enabled ) {

        for( int x = 0; x < fButtonList.size(); x++ ) {
            JButton btn = (JButton) fButtonList.get(x);
            if( btn instanceof SnmpApplyButton || btn instanceof  SnmpOKButton ) {
                btn.setEnabled(enabled);
            }
        }
    }
}
