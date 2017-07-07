package com.winnertel.ems.lct;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.task.Task;
import com.winnertel.em.standard.Application;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.lct.access.AccessCtrlFactory;
import com.winnertel.ems.lct.access.IAccessCtrl;
import com.winnertel.ems.lct.history.HistoryAware;
import com.winnertel.ems.lct.history.HistoryPopup;
import com.winnertel.util.SwingCommon;
import com.winnertel.xml.XmlLoader;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Properties;

public class LctLogin {

    private static LoginFrame loginFrame = null;

    public static boolean show() {
        if (loginFrame == null) {
            loginFrame = new LoginFrame();
        }
        SwingCommon.centerWindow(loginFrame);
        loginFrame.setVisible(true);
        return true;
    }

    public static Dimension NORMAL_SIZE = new Dimension(436, 280);

    static class LoginFrame extends JFrame implements HistoryAware<HistoryPopup.AccessHistory> {

        IPAddressField fIpField;
        JComboBox fNeTypes;

        private JButton btnHistory = new JButton(new ImageIcon(getClass().getResource("/com/winnertel/util/swingx/down.png")));

        private IApplication fApplication = new Application(Locale.getDefault());


        LctNode node;

        JPanel _otherPanel = new JPanel();
        IAccessCtrl _ctrl = null;

        LoginFrame() {
            fApplication.setDebug(true);
            fApplication.startUp();
            initGui();
            setJMenuBar(createMenuBar());
            setTitle(LctMain.getString("Title") + "-" + getSystemVersion().getProperty("version", "unknown"));
            ImageIcon titleIcon = new ImageIcon(this.getClass().getResource("titlebar.gif"));
            setIconImage(titleIcon.getImage());
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                    System.exit(1);
                }
            });

        }

        private final Properties getSystemVersion() {
            final Properties property = new Properties();
            try {
                new XmlLoader(new FileInputStream("./conf/LiteReleaseInfo_version.xml")) {
                    @Override
                    protected boolean handleData(String sNodeName, String sNodeVal, Properties attributes, boolean isLeaf) {
                        if ("productVersion".equalsIgnoreCase(sNodeName)) {
                            property.setProperty("version", sNodeVal);
                        }
                        return super.handleData(sNodeName, sNodeVal, attributes, isLeaf);
                    }

                }.load();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return property;
        }


        private JMenuBar createMenuBar() {
            JMenuBar mb = new JMenuBar();

            JMenu fileMenu = new JMenu(LctMain.getString("File"));
            fileMenu.setMnemonic('F');

            JMenuItem exitItem = new JMenuItem(new ExitAction());
            exitItem.setMnemonic('x');

            fileMenu.add(exitItem);

            mb.add(fileMenu);

            return mb;
        }


        void initGui() {
            NTLayout nodeSelectLayout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 2);
            JPanel nodeSelectPanel = new JPanel(nodeSelectLayout);

            nodeSelectPanel.setBorder(BorderFactory.createEtchedBorder());

            nodeSelectPanel.add(new JLabel(LctMain.getString("IP_Address")));
            JPanel address_panel = new JPanel(new BorderLayout());
            address_panel.add(fIpField = new IPAddressField(), BorderLayout.CENTER);
            address_panel.add(btnHistory, BorderLayout.EAST);
            nodeSelectPanel.add(address_panel);
            nodeSelectPanel.add(Box.createGlue());

            nodeSelectPanel.add(new JLabel(LctMain.getString("NE_Type")));
            nodeSelectPanel.add(fNeTypes = new JComboBox(LctMain.getSupportedTypes()));

            fNeTypes.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        neTypeChanged();
                    }
                }
            });

            fNeTypes.setRenderer(new DefaultListCellRenderer() {
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    JLabel ret = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    return ret;
                }
            });

            btnHistory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    popupHistory();
                }
            });

            nodeSelectPanel.add(Box.createGlue());

            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton btn = new JButton(LctMain.getString("Enter"));
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent aE) {
                    apply();
                }
            });
            btnPanel.add(btn);

            //other information
            _otherPanel.setLayout(new BorderLayout());
            //end other information

            JPanel content = new JPanel(new BorderLayout());
            content.add(nodeSelectPanel, BorderLayout.CENTER);
            content.add(_otherPanel, BorderLayout.SOUTH);

            JPanel gui = new JPanel(new BorderLayout());
            gui.add(content, BorderLayout.CENTER);
            gui.add(btnPanel, BorderLayout.SOUTH);

            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(gui, BorderLayout.CENTER);

            //JLabel label = new JLabel(LctMain.getString(("Node_Sel")));
            //getContentPane().add( label, BorderLayout.NORTH );

            String flashimage = "loginimage.gif";
            if (!Locale.getDefault().equals(Locale.CHINA)) {
                flashimage = "loginimage_en.gif";
            }

            ImageIcon imgIcon = new ImageIcon(LctLogin.class.getResource("/com/winnertel/client/login/" + flashimage));
            Image img = imgIcon.getImage().getScaledInstance(436, 82, Image.SCALE_FAST);
            JLabel imageLabel = new JLabel(new ImageIcon(img));
            imageLabel.setBorder(new EtchedBorder());
            getContentPane().add(imageLabel, BorderLayout.NORTH);

            gui.getRootPane().setDefaultButton(btn);
            this.setResizable(false);

            neTypeChanged();
            //init the components.
        }

        private void popupHistory() {
            HistoryPopup.getPopup(LoginFrame.this).show(btnHistory, 0, btnHistory.getHeight());
        }

        private void neTypeChanged() {
            String neType = fNeTypes.getSelectedItem().toString();

            if (_ctrl != null) {
                _ctrl.clear();
                _otherPanel.removeAll();
            }
            _ctrl = AccessCtrlFactory.instance().getAccessCtrl(neType);
            JComponent ctrlImpl = _ctrl.getDefaultCtrlImpl();
            if (ctrlImpl != null) {
                _otherPanel.add(ctrlImpl, BorderLayout.CENTER);
                setSize(NORMAL_SIZE.width, NORMAL_SIZE.height + ctrlImpl.getPreferredSize().height);
            } else {
                setSize(NORMAL_SIZE);
            }
            //fIpField.setText("0.0.0.0");
            invalidate();
            validate();
            repaint();
        }

        private String getString(String key) {
            return LctMain.getString(key);
        }

        private void apply() {
            if (SwingCommon.getValidIPAddress(fIpField.getIPString()) == null) {
                JOptionPane.showMessageDialog(LoginFrame.this, getString("Invalid_IP"));
                return;
            }
            String neType = fNeTypes.getSelectedItem().toString();
            String ipAddr = fIpField.getIPString();
            if (_ctrl != null) {
                int i = _ctrl.validate(neType, ipAddr);
                if (i != 0) {
                    JOptionPane.showMessageDialog(LoginFrame.this, getString(_ctrl.getClass().getName() + "_" + i));
                    return;
                }
            }
            Hashtable ht = _ctrl != null ? _ctrl.getAccess() : null;
            try {
                node = (LctNode) fApplication.getTaskManager().executeTask(new Task() {
                    @Override
                    public Object execute() throws Exception {
                        return LctNode.createNode(fNeTypes.getSelectedItem().toString(), fIpField.getIPString(), _ctrl.getAccess());
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (node == null || node.getNodeVersion() == null) {
                JOptionPane.showMessageDialog(this, getString("msg_fail_connect"), getString("warn"), JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (LctMain.isSupportedNode(node)) {
                LctMain.registerNode(node);


                if (node != null) {
//                    HistoryPopup.getPopup(LoginFrame.this).addToHistory(node);
                    JFrame lctFrame = LctMain.openDvm(node, loginFrame);
                    if (lctFrame != null) {
                        dispose();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, getString("Support_Fail"));
            }
        }

        @Override
        public boolean historyLoad(HistoryPopup.AccessHistory history) {
            if (history != null) {
                fIpField.setValue(history.address);
                fNeTypes.setSelectedItem(history.type);
                Hashtable ht = new Hashtable();
                ht.put(NodeMeta.KEY_READ_COMMUNITY, history.read_community);
                ht.put(NodeMeta.KEY_WRITE_COMMUNITY, history.write_community);
                _ctrl.setAccess(ht);
                return true;
            }
            return false;
        }


        class ExitAction extends AbstractAction {

            public ExitAction() {
                super(LctMain.getString("Exit"));
            }

            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(1);
            }

        }


    }

}