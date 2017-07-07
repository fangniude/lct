package com.winnertel.ems.epon.iad.bbs4000.mib.r400.mock;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.nms.lite.LiteContext;

import java.io.File;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: HZ03842
 * Date: 2010-5-24
 * Time: 10:15:40
 */
public class OnuInfoTable {
    public Integer onuDeviceIndex;
    public String onuName;
    public String onuType;
    public String onuIpAddress;
    public byte[] onuMacAddress;
    public Integer onuOperationStatus;
    public Integer onuLlidId;
    public Integer onuAdminStatus;
    public String onuChipVendor;
    public String aOnuChipVendor;
    public String onuChipType;
    public String onuChipVersion;
    public String onuSoftwareVersion;
    public String onuFirmwareVersion;
   
    public OnuInfoTable() {
    }

    public OnuInfoTable(ISnmpProxy aSnmpProxy) {
    }

    public Integer getOnuDeviceIndex() {
        return onuDeviceIndex;
    }

    public void setOnuDeviceIndex(Integer aOnuDeviceIndex) {
        onuDeviceIndex = aOnuDeviceIndex;
    }

    public String getOnuName() {
        return onuName;
    }

    public void setOnuName(String aOnuName) {
        onuName=aOnuName;
    }

    public String getOnuType() {
        return onuType;
    }

    public void setOnuType(String aOnuType) {
        onuType=aOnuType;
    }

    public String getOnuIpAddress() {
        return onuIpAddress;
    }

    public void setOnuIpAddress(String aOnuIpAddress) {
        onuIpAddress=aOnuIpAddress;
    }


    public void setOnuMacAddress(byte[] aOnuMacAddress) {
        onuMacAddress=aOnuMacAddress;
    }

    public byte[] getOnuMacAddress() {
        return onuMacAddress;
    }

    public Integer getOnuOperationStatus() {
        return onuOperationStatus;
    }

    public void setOnuOperationStatus(Integer aOnuOperationStatus) {
        onuOperationStatus=aOnuOperationStatus;
    }

    public Integer getOnuLlidId() {
        return onuLlidId;
    }

    public void setOnuLlidId(Integer aOnuLlidId) {
        onuLlidId=aOnuLlidId;
    }


    /*
    public String getOnuIpSubnetMask() {
        return (String) getProperty(onuIpSubnetMask).getValue();
    }

    public void setOnuIpSubnetMask(String aOnuIpSubnetMask) {
        getProperty(onuIpSubnetMask).setValue(aOnuIpSubnetMask);
    }

    public String getOnuIpGateway() {
        return (String) getProperty(onuIpGateway).getValue();
    }

    public void setOnuIpGateway(String aOnuIpGateway) {
        getProperty(onuIpGateway).setValue(aOnuIpGateway);
    }
    */


    public Integer getOnuAdminStatus() {
        return onuAdminStatus;
    }

    public void setOnuAdminStatus(Integer aOnuAdminStatus) {
        onuAdminStatus=aOnuAdminStatus;
    }

    public String getOnuChipVendor() {
        return onuChipVendor;
    }

    public void setOnuChipVendor(String aOnuChipVendor) {
        onuChipVendor=aOnuChipVendor;
    }

    public String getOnuChipType() {
        return onuChipType;
    }

    public void setOnuChipType(String aOnuChipType) {
        onuChipType=aOnuChipType;
    }

    public String getOnuChipVersion() {
        return  onuChipVersion;
    }

    public void setOnuChipVersion(String aOnuChipVersion) {
        onuChipVersion=aOnuChipVersion;
    }

    public String getOnuSoftwareVersion() {
        return  onuSoftwareVersion;
    }

    public void setOnuSoftwareVersion(String aOnuSoftwareVersion) {
        onuSoftwareVersion=aOnuSoftwareVersion;
    }

    public String getOnuFirmwareVersion() {
        return  onuFirmwareVersion;
    }

    public void setOnuFirmwareVersion(String aOnuFirmwareVersion) {
        onuFirmwareVersion=aOnuFirmwareVersion;
    }




    public boolean retrieve() throws MibBeanException {
//        if (onuInfoMap == null){
           loadAll(); 
//        }
        OnuInfoTable infoTable =  (OnuInfoTable)onuInfoMap.get(this.getOnuDeviceIndex());
        this.setOnuIpAddress(infoTable.getOnuIpAddress());
        this.setOnuMacAddress(infoTable.getOnuMacAddress());
        this.setOnuLlidId(infoTable.getOnuLlidId());
        this.setOnuOperationStatus(infoTable.getOnuOperationStatus());
        return true;
    }

    public Vector retrieveAll() throws MibBeanException {
        return loadAll();
    }

    public Vector retrieveByPonOdn(int oltId, int cardId, int portId) throws MibBeanException {
        Vector retVec = new Vector();
        loadAll();
        Integer id = (oltId<<24) + (cardId<<16) + (portId<<8);

        Iterator it =onuInfoMap.values().iterator();
        while (it.hasNext()){
            OnuInfoTable infoTable =  (OnuInfoTable)it.next();
            int tempId = infoTable.getOnuDeviceIndex();
            tempId = tempId&0xFFFFFF00; 
            if (tempId == id){
                retVec.add(infoTable);
            }
        }
        return retVec;
    }

    private Vector loadAll(){
        onuInfoMap = new Hashtable();
        try{
            org.jdom.input.SAXBuilder saxBuilder = new org.jdom.input.SAXBuilder(false);
            org.jdom.Document doc = null;
            File confFile = new File(LiteContext.getRootDir() + onuinfofile);
            InputStream in = confFile.toURL().openStream();
            doc = saxBuilder.build(in);
            org.jdom.Element root = doc.getRootElement();
            List onuList = root.getChildren("Onu");
            for (int j = 0; j < onuList.size(); j++) {
                org.jdom.Element oneOnu = (org.jdom.Element) onuList.get(j);
                int[] id_bit = new int[4];
                String id = oneOnu.getAttributeValue("id");
                String ip = oneOnu.getAttributeValue("ip");
                String mac = oneOnu.getAttributeValue("mac");
                String status = oneOnu.getAttributeValue("status");
                String llid = oneOnu.getAttributeValue("llid");

                StringTokenizer tokenizer = new StringTokenizer(id, "-");
                id_bit[0] = new Integer(tokenizer.nextToken());
                id_bit[1] = new Integer(tokenizer.nextToken());
                id_bit[2] = new Integer(tokenizer.nextToken());
                id_bit[3] = new Integer(tokenizer.nextToken());


                byte[] mac_byte = new byte[6];
                StringTokenizer tokenizer1 = new StringTokenizer(mac, ".");
                mac_byte[0] = new Integer(tokenizer1.nextToken()).byteValue();
                mac_byte[1] = new Integer(tokenizer1.nextToken()).byteValue();
                mac_byte[2] = new Integer(tokenizer1.nextToken()).byteValue();
                mac_byte[3] = new Integer(tokenizer1.nextToken()).byteValue();
                mac_byte[4] = new Integer(tokenizer1.nextToken()).byteValue();
                mac_byte[5] = new Integer(tokenizer1.nextToken()).byteValue();

                OnuInfoTable info= new OnuInfoTable();
                Integer iId = (id_bit[0]<<24) + (id_bit[1]<<16) + (id_bit[2]<<8)+id_bit[3]; 
                info.setOnuDeviceIndex(iId);
                info.setOnuIpAddress(ip);
                info.setOnuMacAddress(mac_byte);
                info.setOnuOperationStatus(new Integer(status));
                info.setOnuLlidId(new Integer(llid));
                
                onuInfoMap.put(iId, info);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Vector(onuInfoMap.values());
    }


    public static void main (String[] args){
        OnuInfoTable table = new OnuInfoTable();
//        table.loadAll();
        try{
            Vector v = table.retrieveByPonOdn(1,1,3);
            System.err.println("v.size():"+v.size());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    private static String onuinfofile = "conf/Gepon/onu_test.xml";
    private static Hashtable onuInfoMap = null;

}