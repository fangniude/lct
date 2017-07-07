package com.winnertel.ems.lct.history;

import com.winnertel.ems.lct.LctMain;
import com.winnertel.ems.lct.LctNode;
import com.winnertel.util.XMLBasicParser;
import com.winnertel.util.XMLBasicWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

/**
 * Configuration file is /conf/access_history.xml
 * The format inside is listed below for reference
 * <Nodes>
 *      <Node address="" type="" read="" write="" time=""/>
 * </Nodes>
 *
 */
public class HistoryPopup extends JPopupMenu implements HistoryManager<HistoryPopup.AccessHistory> {
    private HistoryPopup() {
        loadHistoryFromDisk();
        buildItems();
    }

    public static HistoryPopup getPopup( HistoryAware component ) {
        popup.setHistoryAware( component );
        return popup;
    }

    private static final String _HISTORY_CONF_ = "./conf/access_history.xml";
    private int loadHistoryFromDisk() {
        File history = new File( _HISTORY_CONF_ );

        if( !history.exists() ) {
            return 0;
        }

        records.clear();
        try {
            new XMLBasicParser( new FileInputStream(history) ) {
                @Override
                protected boolean handleData(String sNodeName, String sNodeVal, Hashtable htAttr, boolean isLeaf) {
                    if( "Node".equalsIgnoreCase(sNodeName) && isLeaf ) {
                        AccessHistory access = new AccessHistory();
                        access.address = (String) htAttr.get("address");
                        access.type = (String) htAttr.get("type");
                        access.read_community = (String)htAttr.get("read");
                        access.write_community = (String)htAttr.get("write");
                        access.time = (String)htAttr.get("time");

                        records.add( access );
                    }
                    return true;
                }
            }.doLoad();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        Collections.sort( records, new Comparator<AccessHistory>() {
            @Override
            public int compare(AccessHistory o1, AccessHistory o2) {
                if( o1 != null && o2 != null ) {
                    return o2.time.compareTo(o1.time);
                }

                return 0;
            }
        });

        return records.size();
    }

    @Override
    public void show(Component c, int x, int y) {
        if( records.isEmpty() ) {
            return;
        }
        buildItems();
        super.show(c, x,y);
    }

    private void setHistoryAware(HistoryAware component) {
        fHistoryWare = component;
    }

    private void buildItems() {
        if( records.isEmpty() ) {
            return;
        }

        removeAll();


        setLayout(new BorderLayout());
        DefaultListModel lm = new DefaultListModel();
        final JList list = new JList( lm );
        for( AccessHistory access : records ) {
            lm.addElement( access );
        }
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if( e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    HistoryPopup.this.setVisible(false);
                    fHistoryWare.historyLoad( list.getSelectedValue() );
                }
            }
        });
        add(new JScrollPane(list), BorderLayout.CENTER);

        JButton clearAll = new JButton(LctMain.getString("RemoveAll"));
        clearAll.setBorder( BorderFactory.createLoweredBevelBorder());
        clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    records.clear();
                    flushHistoryToXML();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                HistoryPopup.this.setVisible(false);
            }
        });
        add( clearAll, BorderLayout.NORTH );

        setPreferredSize(new Dimension(180, 200));

    }


    private static HistoryPopup popup = new HistoryPopup();

    private HistoryAware fHistoryWare;

    private ArrayList<AccessHistory> records = new ArrayList<AccessHistory>();

    @Override
    public List<HistoryPopup.AccessHistory> readHistory() {
        return records;
    }

    @Override
    public void addToHistory(LctNode node) {
        if( node != null ) {
            String nodeAddress = node.getNodeAddress();
            AccessHistory found  = null;
            for( AccessHistory h : records ) {
                if(h.address.equalsIgnoreCase(nodeAddress)) {
                    found = h;
                    break;
                }
            }
            if( found != null ) {
                records.remove(found);
            } else {
                found = new AccessHistory();
                found.address = node.getNodeAddress();
                found.read_community = node.getReadCommunity();
                found.write_community = node.getWriteCommunity();
                found.type = node.getNodeType();
            }
            found.time = String.valueOf(System.currentTimeMillis());
            records.add( found );

            try {
                if( !records.isEmpty() ) {
                    flushHistoryToXML();
                }

            } catch (Exception ex) {
                ex.printStackTrace();;
            }

        }
    }

    private void flushHistoryToXML() throws Exception {
        Document document = XMLBasicWriter.createDocument();
        Element root = document.createElement("Nodes");
        document.appendChild(root);
        for( AccessHistory history : records ) {
            Element element = document.createElement("Node");
            element.setAttribute("address", history.address);
            element.setAttribute("type", history.type);
            element.setAttribute("read", history.read_community);
            element.setAttribute("write", history.write_community);
            element.setAttribute("time", history.time);
            root.appendChild(element);
        }

        XMLBasicWriter.writeXML(document, new File( _HISTORY_CONF_) );

    }

    @Override
    public void eraseHistory(HistoryPopup.AccessHistory history) {
        records.remove(history);
    }

    public static class AccessHistory {
        public String address;
        public String type;
        public String read_community;
        public String write_community;
        public String time;

        @Override
        public String toString() {
            return "[" + type + "] " + address;
        }

        @Override
        public boolean equals(Object o) {
            if( o != null && o instanceof AccessHistory ) {
                return ((AccessHistory)o).address.equalsIgnoreCase(address);
            }
            return false;
        }
    }


}
