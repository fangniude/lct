package com.winnertel.ems.lct.access;

import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.lct.NodeMeta;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

public class CommunityChgCtrl extends DefaultAccessCtrl {

    public CommunityChgCtrl(String aNeType) {
        super(aNeType);
    }

    public CommunityChgCtrl() {
        super();
    }

    public void clear() {
    }

    public Hashtable getAccess() {
        Hashtable ht = new Hashtable();
        ht.put(NodeMeta.KEY_READ_COMMUNITY, _control.getReadCommunity());
        ht.put(NodeMeta.KEY_WRITE_COMMUNITY, _control.getWriteCommunity());
        return ht;
    }

    public JComponent getCtrlImpl() {
        return _control;
    }

    public JComponent getDefaultCtrlImpl() {
        if (_control != null) {
            if ("GOT6000".equals(this.fNeType)) {
                _control.setReadCommunity("!|public");
                _control.setWriteCommunity("!|xpress");
            }
        }

        return _control;
    }

    public void setAccess(Hashtable ht) {
        if (ht == null) {
            return;
        }

        try {
            _control.setReadCommunity(ht.get(NodeMeta.KEY_READ_COMMUNITY).toString());
            _control.setWriteCommunity(ht.get(NodeMeta.KEY_WRITE_COMMUNITY).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int validate(String neType, String ipAddr) {
        if (_control.getReadCommunity() == null || _control.getWriteCommunity() == null) {
            return AccessCtrlFactory.CtrlErrorCode.ERR_EMPTY_COMMUNITY;
        }

        return 0;
    }

    AccessControl _control = new AccessControl();

    class AccessControl extends JPanel {

        private ResourceBundle res = ResourceBundle.getBundle("com.winnertel.ems.lct.Res", Locale.getDefault());

        JTextField txReadCommunity = new JTextField(10);
        JTextField txWriteCommunity = new JTextField(10);

        private String getString(String key) {
            try {
                return res.getString(key);
            } catch (Exception ex) {
                return key;
            }
        }

        AccessControl() {
            setBorder(BorderFactory.createTitledBorder(getString("OtherInfo")));
            NTLayout otherLayout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
            setLayout(otherLayout);
            //row 1
            add(new JLabel(getString("ReadCommunity")));
            add(txReadCommunity);
            add(Box.createGlue());
            //row 2
            add(new JLabel(getString("WriteCommunity")));
            add(txWriteCommunity);
            add(Box.createGlue());
            //row 3
            add(Box.createGlue());
        }

        String getReadCommunity() {
            if (txReadCommunity.getText() == null || txReadCommunity.getText().trim().length() == 0) {
                return null;
            }

            return txReadCommunity.getText();
        }

        String getWriteCommunity() {
            if (txWriteCommunity.getText() == null || txWriteCommunity.getText().trim().length() == 0) {
                return null;
            }

            return txWriteCommunity.getText();
        }

        void setReadCommunity(String read) {
            txReadCommunity.setText(read);
        }

        void setWriteCommunity(String write) {
            txWriteCommunity.setText(write);
        }

    }

}