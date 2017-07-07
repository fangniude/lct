package com.winnertel.ems.epon.iad.bbs4000.mgr;

import com.winnertel.em.standard.resource.DocumentLoader;
import org.jdom.Document;
import org.jdom.Element;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class MibSchemaFactory {
    public static final String SCHEMA_FILE = "com/winnertel/ems/epon/iad/bbs4000/mgr/mib_table.xml";
//    private static final HashMap<String, SnmpSchema> bean_schema_cache = new HashMap<String, SnmpSchema>();
    private static final HashMap<String, MibTable> name_schema_cache = new HashMap<String, MibTable>();

    static {
        initCache();
    }

    public static MibTable getSchema(String table, String version) {
        if(table == null) return null;

        MibTable mibTable = name_schema_cache.get(table + "." + version);

        if(mibTable == null) {
            mibTable = name_schema_cache.get(table);
        }
        
        return mibTable;
    }

    protected static void initCache() {
        URL url = MibSchemaFactory.class.getClassLoader().getResource(SCHEMA_FILE);

        try {
//            SAXBuilder builder = new SAXBuilder();
//            Document doc = builder.build(url);

            Document doc = DocumentLoader.loadDocument(url);

            Element eRoot = doc.getRootElement();
            if(eRoot == null || !eRoot.getName().equals("tablelist")) {
                return;
            }

            Iterator iterator = eRoot.getChildren("table").iterator();

            while(iterator.hasNext()) {
                Element eTable = (Element)iterator.next();

                MibTable table = new MibTable();
                table.setMibTableName(eTable.getAttributeValue("name"));

                //
                table.setOid(eTable.getAttributeValue("entry"));

                List<MibItem> itemList = new ArrayList();
                Iterator it3 = eTable.getChildren().iterator();
                while(it3.hasNext()) {
                    Element eItem = (Element)it3.next();

                    MibItem item = new MibItem();
                    item.setSpecId(eItem.getAttributeValue("name"));
                    item.setOid(eItem.getAttributeValue("oid"));
                    item.setReadOnly(Boolean.valueOf(eItem.getAttributeValue("readonly")));

                    String type = eItem.getAttributeValue("type");
                    if(type != null) {
                        type = type.toLowerCase();

                        if(type.equals("ipaddress")) {
                            item.setType(MibItem.IP_ADDRESS);
                        } else if(type.equals("macaddress")) {
                            item.setType(MibItem.MAC_ADDRESS);
                        } else if(type.equals("timeticks")) {
                            item.setType(MibItem.TIME_TICKS);
                        } else if(type.equals("integer")) {
                            item.setType(MibItem.INTEGER);
                        } else if(type.equals("counter") || type.equals("counter64")){
                            item.setType(MibItem.INTEGER);
                        } else if(type.equals("gauge")){
                            item.setType(MibItem.GAUGE);
                        } else if(type.equals("octets")){
                            item.setType(MibItem.OCTETS);

                            try {
                                item.setMaxLen(Integer.parseInt(eItem.getAttributeValue("length")));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                throw new NullPointerException("Invalid Length definition of MIB Item[" + item.getSpecId() + "]: " + eItem.getAttributeValue("length"));
                            }
                        } else if(type.equals("string")) {
                            item.setType(MibItem.STRING);

                            try {
                                item.setMaxLen(Integer.parseInt(eItem.getAttributeValue("length")));
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                throw new NullPointerException("Invalid Length definition of MIB Item[" + item.getSpecId() + "]: " + eItem.getAttributeValue("length"));
                            }
                        } else if(type.equals("rowstatus")){
                            item.setType(MibItem.INTEGER);
                            item.setRowStatus(true);
                            item.setVisable(false);
                        } else {
                            throw new NullPointerException("Invalid Type of MIB Item[" + item.getSpecId() + "]: " + type);
                        }
                    } else {
                        throw new NullPointerException("The Type of MIB Item[" + item.getSpecId() + "] is not defined.");
                    }

                    itemList.add(item);
                }

                table.setItems(itemList);
                //put the table to the cache which contains the name-table mapping.
                if(name_schema_cache.containsKey(table.getMibTableName())) {
//                    fLogger.error("There are the duplicated table definition: " + table.getMibTableName() + ". Use the last one.");
                }

                String version = eTable.getAttributeValue("version");
                String key = table.getMibTableName();
                if(version != null) {
                    key = key + "." + version;
                }

                name_schema_cache.put(key, table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
