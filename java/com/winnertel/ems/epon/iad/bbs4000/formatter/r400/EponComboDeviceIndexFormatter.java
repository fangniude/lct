package com.winnertel.ems.epon.iad.bbs4000.formatter.r400;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.util.MibBeanUtil;

/**
 * Created by IntelliJ IDEA.
 * User: hz03446
 * Date: 2010-6-28
 * Time: 18:57:41
 * To change this template use File | Settings | File Templates.
 */
public class EponComboDeviceIndexFormatter extends EponDeviceIndexFormatter{
    public EponComboDeviceIndexFormatter(IApplication anApplication) {
        super(anApplication);
    }

    public Object format(SnmpMibBean aMibBean, String aProperty) throws Exception {

        String superRet=(String)super.format(aMibBean,aProperty);
        String retStr= superRet;
        if (aProperty.compareTo("pvtDeviceIndex")==0){
            Object cardIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pvtCardIndex");
            Object portIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pvtPortIndex");
            if (cardIndex.toString().compareTo("0")==0 && portIndex.toString().compareTo("0")==0){

            }
            else{
                retStr=superRet+"-"+cardIndex+"/"+ portIndex;
            }
        }else if (aProperty.compareTo("pvlanDeviceIndex")==0){
            Object cardIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pvlanCardIndex");
            Object portIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pvlanPortIndex");
            if (cardIndex.toString().compareTo("0")==0 && portIndex.toString().compareTo("0")==0){

            }
            else{
                retStr=superRet+"-"+cardIndex+"/"+ portIndex;
            }
        }else if (aProperty.compareTo("pqDeviceIndex")==0){
            Object cardIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pqCardIndex");
            Object portIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pqPortIndex");
            if (cardIndex.toString().compareTo("0")==0 && portIndex.toString().compareTo("0")==0){

            }
            else{
                retStr=superRet+"-"+cardIndex+"/"+ portIndex;
            }
        }else if (aProperty.compareTo("trunkDeviceIndex")==0){
            Object cardIndex = MibBeanUtil.getSimpleProperty(aMibBean, "trunkCardIndex");
            Object portIndex = MibBeanUtil.getSimpleProperty(aMibBean, "trunkPortIndex");
            if (cardIndex.toString().compareTo("0")==0 && portIndex.toString().compareTo("0")==0){

            }
            else{
                retStr=superRet+"-"+cardIndex+"/"+ portIndex;
            }
        }else if (aProperty.compareTo("pvaDeviceIndex")==0){
            Object cardIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pvaCardIndex");
            Object portIndex = MibBeanUtil.getSimpleProperty(aMibBean, "pvaPortIndex");
            if (cardIndex.toString().compareTo("0")==0 && portIndex.toString().compareTo("0")==0){

            }
            else{
                retStr=superRet+"-"+cardIndex+"/"+ portIndex;
            }
        }

        return retStr;

    }
}
