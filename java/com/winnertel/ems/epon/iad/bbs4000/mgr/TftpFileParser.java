package com.winnertel.ems.epon.iad.bbs4000.mgr;

import com.winnertel.ems.epon.util.ConfigUtility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;
import java.util.zip.GZIPInputStream;

public class TftpFileParser {

    private File tftpFile;
    private MibTable mibTable;
    private static int HEADER_SIZE = 64;

    public TftpFileParser(File tftpFile, MibTable mibTable) {
        this.tftpFile = tftpFile;
        this.mibTable = mibTable;
    }

    public Vector parse() throws IOException {
        return parseRows(tftpFile, mibTable);
    }

    private Vector parseRows(File tftpFile, MibTable mibTable) throws IOException {
        InputStream ins;
        String ungzFileName = null;
        try {
        	if (tftpFile.getName().endsWith(".gz")){
        		String gzFileName = tftpFile.getName();
        		ungzFileName = MibProxyMgrImpl.TFTP_ROOT_DIR + File.separator+gzFileName.substring(0,gzFileName.length()-3);
        		//The record read from GZIPInputStream directly is not correct when the record count is large, but read from unGzipped the file correct. So unGzip the .gz file first. 
        		unGzipTftpFile(tftpFile, ungzFileName);
        		ins = new BufferedInputStream(new FileInputStream(ungzFileName));
        	}else{
        		ins = new BufferedInputStream(new FileInputStream(tftpFile));
        	}
        	return parseRows(ins,mibTable);
        }finally {
        	deleteUngzFile(ungzFileName);
        }
    }

    private void unGzipTftpFile(File tftpFile, String ungzFileName) throws IOException {
        GZIPInputStream gzIns = new GZIPInputStream(new FileInputStream(tftpFile),1024);
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(ungzFileName);
            byte[] buf = new byte[1024];
            int num;

            while ((num = gzIns.read(buf, 0, buf.length)) != -1) {
                fout.write(buf, 0, num);
            }
            gzIns.close();
            fout.close();
        } catch (IOException e) {
            System.out.println(e);
        }finally {
        	try {
        		fout.close();
        	}
        	catch(Exception ex){}
        }
    }

    private Vector parseRows(InputStream ins, MibTable mibTable) throws IOException {
        Vector<Vector> rows = new Vector();
        try {

            byte[] head = new byte[HEADER_SIZE];

            int read = ins.read(head, 0, HEADER_SIZE);

            if(read < HEADER_SIZE) {
                return rows;
            }
            TftpFileHeader header = parseHeader(head);

            List mibItems = mibTable.getItems();

            byte[] bytes = new byte[64];
            for (int i = 0; i < header.getRowCount(); i++) {
//                if(read < 1) {
//                    fLogger.error("The file is runinate: " + tftpFile.getName());
//                }

                Vector row = new Vector(mibTable.getItems().size());
                for (int j = 0; j < mibItems.size(); j++) {
                    Object value = null;
                    MibItem item = (MibItem) mibItems.get(j);
                    switch (item.getType()) {
                        case MibItem.IP_ADDRESS:
                            ins.read(bytes, 0, 4);
                            value = formatIpAddress(bytes);
                            break;
                        case MibItem.MAC_ADDRESS:
                            byte[] mac = new byte[6];
                            ins.read(mac, 0, mac.length);
                            value = mac;
                            break;
                        case MibItem.TIME_TICKS:
                            ins.read(bytes, 0, 8);
                            long tempLong = formatLong(bytes);
                            value = ConfigUtility.formatSysUpTime(tempLong);
                            break;
                        case MibItem.INTEGER:
                            ins.read(bytes, 0, 4);
                            value = formatInt(bytes);
                            break;
                        case MibItem.COUNTER:
                        case MibItem.COUNTER64:
                        case MibItem.GAUGE:
                            ins.read(bytes, 0, 8);
                            value = formatLong(bytes);
                            break;
                        case MibItem.STRING:
                            int size = (int)item.getMaxLen();
                            byte[] str = new byte[size];
                            ins.read(str, 0, size);
                            value = new String(str, 0, size).trim();
                            break;
                        case MibItem.OCTETS:
                            int len = (int)item.getMaxLen();
                            byte[] b = new byte[len];
                            ins.read(b, 0, b.length);
                            value = b;
                            break;
                        default:

                    }
                    row.add(value);
                }
                rows.add(row);
            }
        } finally {
            ins.close();
        }

        return rows;
    }

    String formatIpAddress(byte[] bytes) {
        StringBuffer sb = new StringBuffer(Integer.toString(bytes[0] & 0xFF));

        for(int i = 1; i < 4; i++) {
            sb.append(".").append(bytes[i] & 0xFF);
        }

        return sb.toString();
    }

    String formatMacAddress(byte[] bytes) {
        StringBuffer sb = new StringBuffer(Integer.toHexString(bytes[0] & 0xFF));

        for(int i = 1; i < 6; i++) {
            sb.append(":").append(Integer.toHexString(bytes[0] & 0xFF));
        }

        return sb.toString();
    }

    int formatInt(byte[] bytes) {
        int value = 0;

        for(int i = 0; i < 4; i++) {
            value |= ((bytes[i]&0xFF) << ((4 - i -1) * 8));
        }

        return value;
    }

    long formatLong(byte[] bytes) {
        long value = 0;

        for(int i = 0; i < 8; i++) {
            value |= ((bytes[i]&0xFF) << ((8 - i - 1) * 8));
        }

        return value;
    }

    private static int getRowSize(MibTable table) {
        return 1024;
    }

    private static TftpFileHeader parseHeader(byte[] bytes) {
        TftpFileHeader header = new TftpFileHeader();

        header.setVersion(bytes[0]);
        header.setRowNumber((((bytes[1] & 0xff) << 24) + ((bytes[2] & 0xff) << 16)
                + ((bytes[3] & 0xff) << 8) + (bytes[4] & 0xff)));


        return header;
    }
    
    public void deleteUngzFile(String fileName) {
    	try {
    		if(fileName!=null && !MibProxyMgrImpl.isReserveLocalFile) {
    			File file = new File(fileName);
    			file.delete();
    		}
    	}
    	catch(Exception e) {

            e.printStackTrace();
    	}
    }



}

class TftpFileHeader {

    private int version;

    private int rowNumber;

    private long timeStamp;

    private int transactionId;

    private int tableCode;

    private int reserved;

    public int getRowCount() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTableCode() {
        return tableCode;
    }

    public void setTableCode(int tableCode) {
        this.tableCode = tableCode;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }
}