package com.winnertel.ems.epon.iad.bbs4000.mgr;

import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.standard.snmp.ISnmpParameter;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.inms.topodb.UTopoAPI;
import com.winnertel.net.tftp.TFTP;
import com.winnertel.net.tftp.TFTPClient;
import com.winnertel.nms.lite.LiteContext;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;
import java.util.Vector;

public class MibProxyMgrImpl extends UnicastRemoteObject implements MibProxyMgr {
    final static String TFTP_ROOT_DIR = LiteContext.getRootDir() +"tftp_root_dir";


    public static boolean isReserveLocalFile = false;

    public MibProxyMgrImpl() throws RemoteException {
        File root = new File(TFTP_ROOT_DIR);

        if (!root.exists()) {
            root.mkdir();
        }
    }

    public Vector retrieveAll(String neName, String table) throws RemoteException {
    	return retrieveAll(neName, table, 1);
    }
    
    public Vector retrieveAll(String neName, String table, int instance) throws RemoteException {
        Properties neProperty = null;
        try {
            neProperty = UTopoAPI.getAPI().getByName( neName ).getProperties();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
//        Properties neProperty = ServerUtility.getNePropertiesByNeName(neName);
        if (neProperty == null) {
            return null;
        }

        String neVersion = neProperty.getProperty("swVersion");
        String ipAddress = neProperty.getProperty("ipAddress");
        int port = Integer.parseInt(neProperty.getProperty("snmpPort", "161"));
       String neType = neProperty.getProperty("type");
       String getCommunity = neProperty.getProperty("readCommunity");
       String neTotalVersion = neVersion;
       try{
           neTotalVersion = SnmpUtility.getNeTotalVersion(neType, ipAddress, port, getCommunity);
       }catch(Exception e){
           e.printStackTrace();
       }

        return retrieveAll(neVersion,neTotalVersion,ipAddress,port,table, instance);
    }
    
    public static Vector retrieveAll(String neVersion, String neTotalVersion, String ipAddress, int port, String table) throws RemoteException {
        return retrieveAll(neVersion, neTotalVersion, ipAddress, port, table, 1);
    }
    
    public static Vector retrieveAll(String neVersion, String neTotalVersion, String ipAddress, int port, String table, int instance) throws RemoteException {
        if (table == null) throw new RemoteException("The table name is null.");

        int tableId = 0;
        if (table.equalsIgnoreCase("utsEponArpTable")) {
            tableId = 1;
        } else if (table.equalsIgnoreCase("utsLagExtLinkAggMacTable")) {
            tableId = 2;
        } else if (table.equalsIgnoreCase("utsLagExtDot1qVlanTable")) {
            tableId = 3;
        } else if (table.equalsIgnoreCase("utsIgmpSnoopingTable")) {
            tableId = 4;
        } else if (table.equalsIgnoreCase("utsIgmpCacheTable")) {
            tableId = 5;
        } else if (table.equalsIgnoreCase("utsDot3Onu2FDBTable")) {
            tableId = 6;
        } else if (table.equalsIgnoreCase("utsDot3Onu2CtcMulticastCtrlTable")) {
            tableId = 7;
        } else if (table.equalsIgnoreCase("onuInfoSyncTable")) {
            tableId = 8;
        } else if (table.equalsIgnoreCase("onuBindingTable")) {
            tableId = 9;
        } else {
            throw new RemoteException("The invalid table name: " + table);
        }


        long beginTime = System.currentTimeMillis();
        String neFile = getTftpFile(neTotalVersion,ipAddress, port, tableId, instance);
        long endGetFileNameTime = System.currentTimeMillis();
        long timeUsed = endGetFileNameTime - beginTime;

        if (neFile != null) {
            String localFile = downloadTftpFile(ipAddress, neFile);

            long endDownFileTime = System.currentTimeMillis();
            timeUsed = endDownFileTime - endGetFileNameTime;

            if (localFile != null) {
                MibTable mibSchema = MibSchemaFactory.getSchema(table, neVersion);
                long endGetSchemaTime = System.currentTimeMillis();
                timeUsed = endGetSchemaTime - endDownFileTime;

                if (mibSchema == null) {
                    throw new RemoteException("Can't get the MIB schema for table: " + table);
                }

                long endParseTime = System.currentTimeMillis();
                File file = null;
                try {
                    file = new File(localFile);

                    TftpFileParser parser = new TftpFileParser(file, mibSchema);

                    Vector retVec = parser.parse();
                    endParseTime = System.currentTimeMillis();
                    timeUsed = endParseTime - endGetSchemaTime;

                    deleteLocalFile(file);
                    
                    return retVec;
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RemoteException("Can't parse the TFTP File: " + e.getMessage());
                } finally {
                    deleteTftpFile(ipAddress, port, tableId, instance);
                    long endDeleteTime = System.currentTimeMillis();
                    timeUsed = endDeleteTime - endParseTime;
                }
            }
        } else {
            throw new RemoteException("Can't get the TFTP File name from NE: " + ipAddress);
        }

        return null;
    }

    public static String getTftpFile(String neTotalVersion, String ipAddress, int port, int tableId) {
        return getTftpFile(neTotalVersion, ipAddress, port, tableId, 1);
    }
    
    public static String getTftpFile(String neTotalVersion, String ipAddress, int port, int tableId, int instance) {
        String fileName = null;

        ISnmpParameter param = new SnmpParameter(ipAddress, port);
        ISnmpProxy proxy = new SnmpProxy(param);

        TftpGetbulkTable getbulkTable = new TftpGetbulkTable(proxy);

        getbulkTable.setUtsTftpGetbulkId(tableId);
        getbulkTable.setUtsTftpGetbulkInstanceId(instance);

        try {
            getbulkTable.retrieve();

            if (getbulkTable.getUtsTftpGetbulkTransactionId() != null) {
                getbulkTable.delete();
            }

            getbulkTable.add();
            getbulkTable.retrieve();

            if (getbulkTable.getUtsTftpGetbulkTransactionId() == null) {
                return null;
            }

            int seq = 0;
            while (seq <300){
                if (getbulkTable.getUtsTftpGetbulkTransactionStatus() == 1 || getbulkTable.getUtsTftpGetbulkTransactionStatus() == 4) {//inProgress
                    Thread.sleep(1000);
                    getbulkTable.retrieve();
                    seq++;
                }else{
                    break;
                }
            }

            if (getbulkTable.getUtsTftpGetbulkTransactionStatus() == 2) {//successfully
                String neFile = "" + getbulkTable.getUtsTftpGetbulkTransactionId();

                if ( true ) {
                    fileName = "table_bulkid_" + getbulkTable.getUtsTftpGetbulkTransactionId() + ".gz";
                }else{
                    fileName = "table_bulkid_" + getbulkTable.getUtsTftpGetbulkTransactionId();
                }

            } else {

                //delete the record.
                getbulkTable.delete();

                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
    }

    public static void deleteTftpFile(String ipAddress, int port, int tableId) {
    	deleteTftpFile(ipAddress, port, tableId, 1);
    }
    
    public static void deleteTftpFile(String ipAddress, int port, int tableId, int instance) {
        ISnmpParameter param = new SnmpParameter(ipAddress, port);
        ISnmpProxy proxy = new SnmpProxy(param);

        TftpGetbulkTable getbulkTable = new TftpGetbulkTable(proxy);

        getbulkTable.setUtsTftpGetbulkId(tableId);
        getbulkTable.setUtsTftpGetbulkInstanceId(instance);

        try {
            getbulkTable.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteLocalFile(File file) {
    	try {
    		if(file!=null && !isReserveLocalFile) {
    			file.delete();
    		}
    	}
    	catch(Exception e) {
            e.printStackTrace();
    	}
    }

    public static String downloadTftpFile(String ipAddress, String neFile) {
        //download the file;
        String localFile = TFTP_ROOT_DIR + File.separator + ipAddress + "_" + neFile;

        TFTPClient tftpClient = new TFTPClient();
        //receive the file from NE.
        tftpClient.setSocketTimeout(5000);
        tftpClient.setMaxTimeoutCount(3);
        try {
            tftpClient.getFile(ipAddress, TFTP.BINARY_MODE, "snmpfile/" + neFile, localFile);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return localFile;
    }

    /** Use 8-8-8 format to represent shelf-slot-port, 1-based. For node level, it is fixed to 1. */
    public Vector retrieveAll(String neId, String table, int[] index) throws RemoteException {
//        throw new RemoteException("This mothed is not implemented.");
    	if(index == null || index.length == 0) {
    		return retrieveAll(neId, table);
    	}
    	
    	Integer instance = (index[0]<<16) + (index[1]<<8) + (index[2]<<0);
    	
    	return retrieveAll(neId, table, instance);

    }

	public static boolean isReserveLocalFile() {
		return isReserveLocalFile;
	}

	public static void setReserveLocalFile(boolean isReserveLocalFile) {
		MibProxyMgrImpl.isReserveLocalFile = isReserveLocalFile;
	}
    
}
