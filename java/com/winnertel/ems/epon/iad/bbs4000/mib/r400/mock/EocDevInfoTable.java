package com.winnertel.ems.epon.iad.bbs4000.mib.r400.mock;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.SnmpProxy;
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
 * Time: 9:57:45
 */
public class EocDevInfoTable {

    private  Integer eocDeviceIndex;
    private  Integer eocCardIndex;
    private  Integer eocPortIndex;
    private  String eocDeviceIpAddress;
    private  byte[] eocDeviceMacAddress;

    public EocDevInfoTable(){
    }

    public EocDevInfoTable(SnmpProxy proxy){
    }


    public Integer getEocDeviceIndex() {
        return eocDeviceIndex;
    }

    public void setEocDeviceIndex(Integer aEDeviceIndex) {
        eocDeviceIndex = aEDeviceIndex; 
    }

    public Integer getEocCardIndex() {
        return eocCardIndex;
    }

    public void setEocCardIndex(Integer aECardIndex) {
        eocCardIndex = aECardIndex;
    }

    public Integer getEocPortIndex() {
        return eocPortIndex;
    }

    public void setEocPortIndex(Integer aEPortIndex) {
        eocPortIndex = aEPortIndex;
    }

    public String getEocDeviceIpAddress() {
        return eocDeviceIpAddress;
    }

    public void setEocDeviceIpAddress(String aEocDeviceIpAddress) {
        eocDeviceIpAddress=aEocDeviceIpAddress;
    }

    public byte[] getEocDeviceMacAddress() {
        return eocDeviceMacAddress;
    }

    public void setEocDeviceMacAddress(byte[] aEocDeviceMacAddress) {
        eocDeviceMacAddress=aEocDeviceMacAddress;
    }


    public boolean retrieve() throws MibBeanException {
//        if (cbatInfoMap == null){
           loadAll();
//        }
        EocDevInfoTable infoTable =  (EocDevInfoTable)cbatInfoMap.get(getkey(this.getEocDeviceIndex(),this.getEocCardIndex(),this.getEocPortIndex()));
        this.setEocDeviceIpAddress(infoTable.getEocDeviceIpAddress());
        this.setEocDeviceMacAddress(infoTable.getEocDeviceMacAddress());
        return true;
     }

    public Vector retrieveAll() throws MibBeanException {
        return loadAll();
    }
    

    public Vector retrieveByONU(int onuDeviceId){
        Vector retVec = new Vector();
//        if (cbatInfoMap == null){
            loadAll();
//         }
        Iterator it =cbatInfoMap.values().iterator();
        while (it.hasNext()){
            EocDevInfoTable infoTable =  (EocDevInfoTable)it.next();
            if (infoTable.getEocDeviceIndex() == onuDeviceId){
                retVec.add(infoTable);
            }
        }
        return retVec;
    }

    private Vector loadAll(){
        cbatInfoMap = new Hashtable();
        try{
            org.jdom.input.SAXBuilder saxBuilder = new org.jdom.input.SAXBuilder(false);
            org.jdom.Document doc = null;
            File confFile = new File(LiteContext.getRootDir() + cbatinfofile);
            InputStream in = confFile.toURL().openStream();
            doc = saxBuilder.build(in);
            org.jdom.Element root = doc.getRootElement();
            List onuList = root.getChildren("cbat");
            for (int j = 0; j < onuList.size(); j++) {
                org.jdom.Element oneOnu = (org.jdom.Element) onuList.get(j);
                int[] id_bit = new int[4];
                String id = oneOnu.getAttributeValue("onuid");
                String card = oneOnu.getAttributeValue("card");
                String port = oneOnu.getAttributeValue("port");
                String ip = oneOnu.getAttributeValue("ip");
                String mac = oneOnu.getAttributeValue("mac");

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
                

                EocDevInfoTable info= new EocDevInfoTable();
                Integer iId = (id_bit[0]<<24) + (id_bit[1]<<16) + (id_bit[2]<<8)+id_bit[3];
                info.setEocDeviceIndex(iId);
                info.setEocCardIndex(new Integer(card));
                info.setEocPortIndex(new Integer(port));
                info.setEocDeviceIpAddress(ip);
                info.setEocDeviceMacAddress(mac_byte);



                cbatInfoMap.put(getkey(iId,info.getEocCardIndex(),info.getEocPortIndex()), info);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Vector(cbatInfoMap.values());
    }

    private String getkey(int onuid, int card, int port){
        return onuid + "-" + card + "-" + port;
    }

    public EocDevInfoTable retrieveByIP(String ip) throws MibBeanException {
        Vector allEocVec = retrieveAll();
        for (int i=0;i<allEocVec.size();i++){
            EocDevInfoTable oneEoc = (EocDevInfoTable)allEocVec.get(i);
            if (ip.equalsIgnoreCase(oneEoc.getEocDeviceIpAddress())){
                return oneEoc;
            }
        }
        return null;
    }


    public static void main (String[] args){
        EocDevInfoTable table = new EocDevInfoTable();
        table.loadAll();

    }
    private static String cbatinfofile = "conf/Gepon/cbattest.xml";
    private static Hashtable cbatInfoMap = null;
}