package com.winnertel.ems.epon.iad.eoc.formatter;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

/**
 * Created by IntelliJ IDEA.
 * User: YYF
 * Date: 2010-8-6
 * Time: 15:28:04
 * To change this template use File | Settings | File Templates.
 */
public class AlarmParameterOIDFormatter extends AlarmLogInformationFormatter {

    public AlarmParameterOIDFormatter(IApplication anApplication) {
        super(anApplication);
    }

    /*
    //Discrete
    public final static String modEoCCBATAdminTamperStatus_OID="1.3.6.1.4.1.17409.2.4.1.3.4";
    public final static String modEoCCBATCardOnlineStatus_OID="1.3.6.1.4.1.17409.2.4.3.2.1.3";
    public final static String modEoCCNUOnlineStatus_OID="1.3.6.1.4.1.17409.2.4.5.2.4.1.4";

    //Analog
    public final static String modEoCCNURFAttenuation_OID="1.3.6.1.4.1.17409.2.4.5.2.4.1.10";
    public final static String modEoCCNURFDownstreamQuality_OID="1.3.6.1.4.1.17409.2.4.5.2.4.1.11";
    public final static String modEoCCNURFUpstreamQuality_OID="1.3.6.1.4.1.17409.2.4.5.2.4.1.12";
    public final static String modEoCCNUPhyDownstreamRate_OID="1.3.6.1.4.1.17409.2.4.5.2.4.1.13";
    public final static String modEoCCNUPhyUpstreamRate_OID="1.3.6.1.4.1.17409.2.4.5.2.4.1.14";

    public final static  String[][] allOID=new String[][]{
            //OID,DisplayString,DisplayFormat
            {modEoCCNURFAttenuation_OID,"modEoCCNURFAttenuation","%0%-%1%"},
            {modEoCCNURFDownstreamQuality_OID,"modEoCCNURFDownstreamQuality","%0%-%1%"},
            {modEoCCNURFUpstreamQuality_OID,"modEoCCNURFUpstreamQuality","%0%-%1%"},
            {modEoCCNUPhyDownstreamRate_OID,"modEoCCNUPhyDownstreamRate","%0%-%1%"},
            {modEoCCNUPhyUpstreamRate_OID,"modEoCCNUPhyUpstreamRate","%0%-%1%"},

            {modEoCCBATAdminTamperStatus_OID,"modEoCCBATAdminTamperStatus",""},
            {modEoCCBATCardOnlineStatus_OID,"modEoCCBATCardOnlineStatus","%0%"},
            {modEoCCNUOnlineStatus_OID,"modEoCCNUOnlineStatus","%0%-%1%"}
    };
    */
    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {
        Object obj = MibBeanUtil.getSimpleProperty(aMibBean, aProperty);

        if (obj == null) return null;

        String tmpObj = (String) obj;

        return super.formatAsStr(tmpObj);

    }
    /*
    protected Object formatAsStr(String tmpObj) throws Exception{

        String[] allNum=tmpObj.split("[.]");

        int oidLen=-1;
        if  (tmpObj.startsWith("1.3.6")){

        }
        else{
            if(allNum!=null && allNum.length>0){
                try{
                    oidLen=Integer.parseInt(allNum[0]);
                }
                catch(Exception e){
                    e.printStackTrace() ;
                }
            }
        }

        String retStr=tmpObj;
        IGuiComposer composer = fApplication.getActiveDeviceManager().getGuiComposer();

        if(oidLen>0){
            for(int i=0;i<allOID.length;i++){
                int pos1=tmpObj.indexOf(allOID[i][0]);

                if(pos1>=0){

                    retStr= composer.getString(allOID[i][1]);

                    String[] oidNum=allOID[i][0].split("[.]");
                    String[] indexNum=null;
                    if(oidLen>=oidNum.length){
                        indexNum=new String[oidLen-oidNum.length];
                        for(int k=0;k<(oidLen-oidNum.length);k++){
                            indexNum[k]= allNum[oidNum.length+k+1];
                        }
                    }
                    if(indexNum!=null && indexNum.length>0){
                        //String strIdx=tmpObj.substring(pos1+allOID[i][0].length());
                        //retStr= allOID[i][1] + strIdx;
                        String indexStr=new String(allOID[i][2]);
                        for(int k=0;k<indexNum.length;k++){
                            indexStr=indexStr.replaceAll("%"+k+"%",String.valueOf(indexNum[k]));
                        }

                        if(indexStr.length()>0){
                            retStr=retStr+":"+ indexStr;
                        }
                        break;
                    }
                }

            }
        }

        return retStr;
    }*/
}
