package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.util.Vector;

/**
 * The AclExtProfileTable class.
 * Created by QuickDVM
 */
public class OnuAclExtProfileTable extends SnmpMibBean {
    public static final String utsOnuAclExtProfileSlotNo = "utsOnuAclExtProfileSlotNo" ;
    public static final String utsOnuAclExtProfilePortNo = "utsOnuAclExtProfilePortNo" ;
    public static final String utsOnuAclExtProfileLogicalPortNo = "utsOnuAclExtProfileLogicalPortNo" ;
    public static final String utsOnuAclExtProfileOnuUniPortNo = "utsOnuAclExtProfileOnuUniPortNo" ;
    public static final String utsOnuAclExtProfileId = "utsOnuAclExtProfileId" ;
    public static final String utsOnuAclExtProfileFieldId = "utsOnuAclExtProfileFieldId" ;
    public static final String utsOnuAclExtProfileRuleId = "utsOnuAclExtProfileRuleId" ;
    public static final String utsOnuAclExtProfileName = "utsOnuAclExtProfileName" ;
    public static final String utsOnuAclExtProfileFieldName = "utsOnuAclExtProfileFieldName" ;
    public static final String utsOnuAclExtProfileRuleName = "utsOnuAclExtProfileRuleName" ;
    public static final String utsOnuAclExtProfileFieldBitmap = "utsOnuAclExtProfileFieldBitmap" ;
    public static final String utsOnuAclExtProfileFieldMaskDstMac = "utsOnuAclExtProfileFieldMaskDstMac" ;
    public static final String utsOnuAclExtProfileFieldMaskSrcMac = "utsOnuAclExtProfileFieldMaskSrcMac" ;
    public static final String utsOnuAclExtProfileFieldMaskArpTargetMac = "utsOnuAclExtProfileFieldMaskArpTargetMac" ;
    public static final String utsOnuAclExtProfileFieldMaskArpSendMac = "utsOnuAclExtProfileFieldMaskArpSendMac" ;
    public static final String utsOnuAclExtProfileFieldMaskSrcIp = "utsOnuAclExtProfileFieldMaskSrcIp" ;
    public static final String utsOnuAclExtProfileFieldMaskDstIp = "utsOnuAclExtProfileFieldMaskDstIp" ;
    public static final String utsOnuAclExtProfileFieldMaskVlan = "utsOnuAclExtProfileFieldMaskVlan" ;
    public static final String utsOnuAclExtProfileFieldMaskEtherType = "utsOnuAclExtProfileFieldMaskEtherType" ;
    public static final String utsOnuAclExtProfileFieldMaskTcpSrcPort = "utsOnuAclExtProfileFieldMaskTcpSrcPort" ;
    public static final String utsOnuAclExtProfileFieldMaskTcpDstPort = "utsOnuAclExtProfileFieldMaskTcpDstPort" ;
    public static final String utsOnuAclExtProfileFieldMaskSrcPortMin = "utsOnuAclExtProfileFieldMaskSrcPortMin" ;
    public static final String utsOnuAclExtProfileFieldMaskSrcPortMax = "utsOnuAclExtProfileFieldMaskSrcPortMax" ;
    public static final String utsOnuAclExtProfileFieldMaskDstPortMin = "utsOnuAclExtProfileFieldMaskDstPortMin" ;
    public static final String utsOnuAclExtProfileFieldMaskDstPortMax = "utsOnuAclExtProfileFieldMaskDstPortMax" ;
    public static final String utsOnuAclExtProfileFieldMaskTagPri = "utsOnuAclExtProfileFieldMaskTagPri" ;
    public static final String utsOnuAclExtProfileFieldMaskDscp = "utsOnuAclExtProfileFieldMaskDscp" ;
    public static final String utsOnuAclExtProfileFieldMaskProtocol = "utsOnuAclExtProfileFieldMaskProtocol" ;
    public static final String utsOnuAclExtProfileFieldMaskIHL = "utsOnuAclExtProfileFieldMaskIHL" ;
    public static final String utsOnuAclExtProfileFieldMaskFragmentOffset = "utsOnuAclExtProfileFieldMaskFragmentOffset" ;
    public static final String utsOnuAclExtProfileRuleValDstMac = "utsOnuAclExtProfileRuleValDstMac" ;
    public static final String utsOnuAclExtProfileRuleValSrcMac = "utsOnuAclExtProfileRuleValSrcMac" ;
    public static final String utsOnuAclExtProfileRuleValArpTargetMac = "utsOnuAclExtProfileRuleValArpTargetMac" ;
    public static final String utsOnuAclExtProfileRuleValArpSendMac = "utsOnuAclExtProfileRuleValArpSendMac" ;
    public static final String utsOnuAclExtProfileRuleValSrcIp = "utsOnuAclExtProfileRuleValSrcIp" ;
    public static final String utsOnuAclExtProfileRuleValDstIp = "utsOnuAclExtProfileRuleValDstIp" ;
    public static final String utsOnuAclExtProfileRuleValVlan = "utsOnuAclExtProfileRuleValVlan" ;
    public static final String utsOnuAclExtProfileRuleValEtherType = "utsOnuAclExtProfileRuleValEtherType" ;
    public static final String utsOnuAclExtProfileRuleValTcpSrcPort = "utsOnuAclExtProfileRuleValTcpSrcPort" ;
    public static final String utsOnuAclExtProfileRuleValTcpDstPort = "utsOnuAclExtProfileRuleValTcpDstPort" ;
    public static final String utsOnuAclExtProfileRuleValSrcPortMin = "utsOnuAclExtProfileRuleValSrcPortMin" ;
    public static final String utsOnuAclExtProfileRuleValSrcPortMax = "utsOnuAclExtProfileRuleValSrcPortMax" ;
    public static final String utsOnuAclExtProfileRuleValDstPortMin = "utsOnuAclExtProfileRuleValDstPortMin" ;
    public static final String utsOnuAclExtProfileRuleValDstPortMax = "utsOnuAclExtProfileRuleValDstPortMax" ;
    public static final String utsOnuAclExtProfileRuleValTagPri = "utsOnuAclExtProfileRuleValTagPri" ;
    public static final String utsOnuAclExtProfileRuleValDscp = "utsOnuAclExtProfileRuleValDscp" ;
    public static final String utsOnuAclExtProfileRuleValProtocol = "utsOnuAclExtProfileRuleValProtocol" ;
    public static final String utsOnuAclExtProfileRuleValNewDscp = "utsOnuAclExtProfileRuleValNewDscp" ;
    public static final String utsOnuAclExtProfileRuleValNewTagPri = "utsOnuAclExtProfileRuleValNewTagPri" ;
    public static final String utsOnuAclExtProfileRuleValNewBandwidth = "utsOnuAclExtProfileRuleValNewBandwidth" ;
    public static final String utsOnuAclExtProfileRuleValNewBurstSize = "utsOnuAclExtProfileRuleValNewBurstSize" ;
    public static final String utsOnuAclExtProfileRuleValNewOutPort = "utsOnuAclExtProfileRuleValNewOutPort" ;
    public static final String utsOnuAclExtProfileRuleValNewOutTag = "utsOnuAclExtProfileRuleValNewOutTag" ;
    public static final String utsOnuAclExtProfileRuleValNewVlanId = "utsOnuAclExtProfileRuleValNewVlanId" ;
    public static final String utsOnuAclExtProfileRuleValIHL = "utsOnuAclExtProfileRuleValIHL" ;
    public static final String utsOnuAclExtProfileRuleValFragmentOffset = "utsOnuAclExtProfileRuleValFragmentOffset" ;
    public static final String utsOnuAclExtProfileRuleValAction = "utsOnuAclExtProfileRuleValAction" ;

    public  OnuAclExtProfileTable( ISnmpProxy aSnmpProxy )
    {
        super( aSnmpProxy );
        init();
    }

    protected void init()
    {
     initProperty( utsOnuAclExtProfileSlotNo, new SnmpMibBeanProperty( utsOnuAclExtProfileSlotNo, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.1", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfilePortNo, new SnmpMibBeanProperty( utsOnuAclExtProfilePortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.2", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileLogicalPortNo, new SnmpMibBeanProperty( utsOnuAclExtProfileLogicalPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.3", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileOnuUniPortNo, new SnmpMibBeanProperty( utsOnuAclExtProfileOnuUniPortNo, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.4", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileId, new SnmpMibBeanProperty( utsOnuAclExtProfileId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.5", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldId, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.6", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleId, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.7", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileName, new SnmpMibBeanProperty( utsOnuAclExtProfileName, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.11", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldName, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldName, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.12", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileRuleName, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleName, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.13", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldBitmap, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldBitmap, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.14", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskDstMac, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskDstMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.15", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldMaskSrcMac, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskSrcMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.16", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldMaskArpTargetMac, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskArpTargetMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.17", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldMaskArpSendMac, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskArpSendMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.18", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldMaskSrcIp, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskSrcIp, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.19", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldMaskDstIp, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskDstIp, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.20", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileFieldMaskVlan, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskVlan, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.21", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskEtherType, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskEtherType, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.22", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskTcpSrcPort, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskTcpSrcPort, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.23", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskTcpDstPort, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskTcpDstPort, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.24", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskSrcPortMin, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskSrcPortMin, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.25", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskSrcPortMax, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskSrcPortMax, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.26", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskDstPortMin, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskDstPortMin, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.27", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskDstPortMax, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskDstPortMax, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.28", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskTagPri, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskTagPri, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.29", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskDscp, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskDscp, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.30", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskProtocol, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskProtocol, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.31", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskIHL, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskIHL, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.32", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileFieldMaskFragmentOffset, new SnmpMibBeanProperty( utsOnuAclExtProfileFieldMaskFragmentOffset, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.33", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValDstMac, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValDstMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.100", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileRuleValSrcMac, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValSrcMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.101", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileRuleValArpTargetMac, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValArpTargetMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.102", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileRuleValArpSendMac, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValArpSendMac, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.103", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileRuleValSrcIp, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValSrcIp, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.104", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileRuleValDstIp, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValDstIp, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.105", ISnmpConstant.STRING));
     initProperty( utsOnuAclExtProfileRuleValVlan, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValVlan, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.106", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValEtherType, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValEtherType, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.107", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValTcpSrcPort, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValTcpSrcPort, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.108", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValTcpDstPort, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValTcpDstPort, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.109", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValSrcPortMin, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValSrcPortMin, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.110", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValSrcPortMax, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValSrcPortMax, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.111", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValDstPortMin, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValDstPortMin, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.112", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValDstPortMax, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValDstPortMax, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.113", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValTagPri, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValTagPri, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.114", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValDscp, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValDscp, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.115", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValProtocol, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValProtocol, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.116", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValNewDscp, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValNewDscp, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.117", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValNewTagPri, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValNewTagPri, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.118", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValNewBandwidth, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValNewBandwidth, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.119", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValNewBurstSize, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValNewBurstSize, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.120", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValNewOutPort, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValNewOutPort, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.121", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValNewOutTag, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValNewOutTag, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.122", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValNewVlanId, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValNewVlanId, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.123", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValIHL, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValIHL, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.124", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValFragmentOffset, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValFragmentOffset, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.125", ISnmpConstant.INTEGER));
     initProperty( utsOnuAclExtProfileRuleValAction, new SnmpMibBeanProperty( utsOnuAclExtProfileRuleValAction, ".1.3.6.1.4.1.45121.1.3.10.5.1000.6.1.200", ISnmpConstant.INTEGER));

    }

    
    public Integer getUtsOnuAclExtProfileSlotNo() {
        return ( Integer)  getIndex(0);
    }
    public void setUtsOnuAclExtProfileSlotNo( Integer aUtsOnuAclExtProfileSlotNo ) {
         setIndex(0, aUtsOnuAclExtProfileSlotNo);
    }
    

    public Integer getUtsOnuAclExtProfilePortNo() {
        return ( Integer)  getIndex(1);
    }
    public void setUtsOnuAclExtProfilePortNo( Integer aUtsOnuAclExtProfilePortNo ) {
         setIndex(1, aUtsOnuAclExtProfilePortNo);
    }
    

    public Integer getUtsOnuAclExtProfileLogicalPortNo() {
        return ( Integer)  getIndex(2);
    }
    public void setUtsOnuAclExtProfileLogicalPortNo( Integer aUtsOnuAclExtProfileLogicalPortNo ) {
         setIndex(2, aUtsOnuAclExtProfileLogicalPortNo);
    }
    

    public Integer getUtsOnuAclExtProfileOnuUniPortNo() {
        return ( Integer)  getIndex(3);
    }
    public void setUtsOnuAclExtProfileOnuUniPortNo( Integer aUtsOnuAclExtProfileOnuUniPortNo ) {
         setIndex(3, aUtsOnuAclExtProfileOnuUniPortNo);
    }
    

    public Integer getUtsOnuAclExtProfileId() {
        return ( Integer)  getIndex(4);
    }
    public void setUtsOnuAclExtProfileId( Integer aUtsOnuAclExtProfileId ) {
         setIndex(4, aUtsOnuAclExtProfileId);
    }
    

    public Integer getUtsOnuAclExtProfileFieldId() {
        return ( Integer)  getIndex(5);
    }
    public void setUtsOnuAclExtProfileFieldId( Integer aUtsOnuAclExtProfileFieldId ) {
         setIndex(5, aUtsOnuAclExtProfileFieldId);
    }
    

    public Integer getUtsOnuAclExtProfileRuleId() {
        return ( Integer)  getIndex(6);
    }
    public void setUtsOnuAclExtProfileRuleId( Integer aUtsOnuAclExtProfileRuleId ) {
         setIndex(6, aUtsOnuAclExtProfileRuleId);
    }
    

  public Integer getUtsOnuAclExtProfileFieldBitmap() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldBitmap).getValue();
  }

  public void setUtsOnuAclExtProfileFieldBitmap(Integer aUtsOnuAclExtProfileFieldBitmap) {
    getProperty(utsOnuAclExtProfileFieldBitmap).setValue(aUtsOnuAclExtProfileFieldBitmap);
  }

  public byte[] getUtsOnuAclExtProfileFieldMaskDstMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileFieldMaskDstMac).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskDstMac(byte[] aUtsOnuAclExtProfileFieldMaskDstMac) {
    getProperty(utsOnuAclExtProfileFieldMaskDstMac).setValue(aUtsOnuAclExtProfileFieldMaskDstMac);
  }

  public byte[] getUtsOnuAclExtProfileFieldMaskSrcMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileFieldMaskSrcMac).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskSrcMac(byte[] aUtsOnuAclExtProfileFieldMaskSrcMac) {
    getProperty(utsOnuAclExtProfileFieldMaskSrcMac).setValue(aUtsOnuAclExtProfileFieldMaskSrcMac);
  }

  public byte[] getUtsOnuAclExtProfileFieldMaskArpTargetMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileFieldMaskArpTargetMac).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskArpTargetMac(byte[] aUtsOnuAclExtProfileFieldMaskArpTargetMac) {
    getProperty(utsOnuAclExtProfileFieldMaskArpTargetMac).setValue(aUtsOnuAclExtProfileFieldMaskArpTargetMac);
  }

  public byte[] getUtsOnuAclExtProfileFieldMaskArpSendMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileFieldMaskArpSendMac).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskArpSendMac(byte[] aUtsOnuAclExtProfileFieldMaskArpSendMac) {
    getProperty(utsOnuAclExtProfileFieldMaskArpSendMac).setValue(aUtsOnuAclExtProfileFieldMaskArpSendMac);
  }

  public String getUtsOnuAclExtProfileFieldMaskSrcIp() {
    return (String) getProperty(utsOnuAclExtProfileFieldMaskSrcIp).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskSrcIp(String aUtsOnuAclExtProfileFieldMaskSrcIp) {
    getProperty(utsOnuAclExtProfileFieldMaskSrcIp).setValue(aUtsOnuAclExtProfileFieldMaskSrcIp);
  }

  public String getUtsOnuAclExtProfileFieldMaskDstIp() {
    return (String) getProperty(utsOnuAclExtProfileFieldMaskDstIp).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskDstIp(String aUtsOnuAclExtProfileFieldMaskDstIp) {
    getProperty(utsOnuAclExtProfileFieldMaskDstIp).setValue(aUtsOnuAclExtProfileFieldMaskDstIp);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskVlan() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskVlan).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskVlan(Integer aUtsOnuAclExtProfileFieldMaskVlan) {
    getProperty(utsOnuAclExtProfileFieldMaskVlan).setValue(aUtsOnuAclExtProfileFieldMaskVlan);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskEtherType() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskEtherType).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskEtherType(Integer aUtsOnuAclExtProfileFieldMaskEtherType) {
    getProperty(utsOnuAclExtProfileFieldMaskEtherType).setValue(aUtsOnuAclExtProfileFieldMaskEtherType);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskTcpSrcPort() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskTcpSrcPort).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskTcpSrcPort(Integer aUtsOnuAclExtProfileFieldMaskTcpSrcPort) {
    getProperty(utsOnuAclExtProfileFieldMaskTcpSrcPort).setValue(aUtsOnuAclExtProfileFieldMaskTcpSrcPort);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskTcpDstPort() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskTcpDstPort).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskTcpDstPort(Integer aUtsOnuAclExtProfileFieldMaskTcpDstPort) {
    getProperty(utsOnuAclExtProfileFieldMaskTcpDstPort).setValue(aUtsOnuAclExtProfileFieldMaskTcpDstPort);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskSrcPortMin() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskSrcPortMin).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskSrcPortMin(Integer aUtsOnuAclExtProfileFieldMaskSrcPortMin) {
    getProperty(utsOnuAclExtProfileFieldMaskSrcPortMin).setValue(aUtsOnuAclExtProfileFieldMaskSrcPortMin);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskSrcPortMax() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskSrcPortMax).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskSrcPortMax(Integer aUtsOnuAclExtProfileFieldMaskSrcPortMax) {
    getProperty(utsOnuAclExtProfileFieldMaskSrcPortMax).setValue(aUtsOnuAclExtProfileFieldMaskSrcPortMax);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskDstPortMin() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskDstPortMin).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskDstPortMin(Integer aUtsOnuAclExtProfileFieldMaskDstPortMin) {
    getProperty(utsOnuAclExtProfileFieldMaskDstPortMin).setValue(aUtsOnuAclExtProfileFieldMaskDstPortMin);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskDstPortMax() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskDstPortMax).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskDstPortMax(Integer aUtsOnuAclExtProfileFieldMaskDstPortMax) {
    getProperty(utsOnuAclExtProfileFieldMaskDstPortMax).setValue(aUtsOnuAclExtProfileFieldMaskDstPortMax);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskTagPri() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskTagPri).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskTagPri(Integer aUtsOnuAclExtProfileFieldMaskTagPri) {
    getProperty(utsOnuAclExtProfileFieldMaskTagPri).setValue(aUtsOnuAclExtProfileFieldMaskTagPri);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskDscp() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskDscp).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskDscp(Integer aUtsOnuAclExtProfileFieldMaskDscp) {
    getProperty(utsOnuAclExtProfileFieldMaskDscp).setValue(aUtsOnuAclExtProfileFieldMaskDscp);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskProtocol() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskProtocol).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskProtocol(Integer aUtsOnuAclExtProfileFieldMaskProtocol) {
    getProperty(utsOnuAclExtProfileFieldMaskProtocol).setValue(aUtsOnuAclExtProfileFieldMaskProtocol);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskIHL() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskIHL).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskIHL(Integer aUtsOnuAclExtProfileFieldMaskIHL) {
    getProperty(utsOnuAclExtProfileFieldMaskIHL).setValue(aUtsOnuAclExtProfileFieldMaskIHL);
  }

  public Integer getUtsOnuAclExtProfileFieldMaskFragmentOffset() {
    return (Integer) getProperty(utsOnuAclExtProfileFieldMaskFragmentOffset).getValue();
  }

  public void setUtsOnuAclExtProfileFieldMaskFragmentOffset(Integer aUtsOnuAclExtProfileFieldMaskFragmentOffset) {
    getProperty(utsOnuAclExtProfileFieldMaskFragmentOffset).setValue(aUtsOnuAclExtProfileFieldMaskFragmentOffset);
  }

  public byte[] getUtsOnuAclExtProfileRuleValDstMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileRuleValDstMac).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValDstMac(byte[] aUtsOnuAclExtProfileRuleValDstMac) {
    getProperty(utsOnuAclExtProfileRuleValDstMac).setValue(aUtsOnuAclExtProfileRuleValDstMac);
  }

  public byte[] getUtsOnuAclExtProfileRuleValSrcMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileRuleValSrcMac).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValSrcMac(byte[] aUtsOnuAclExtProfileRuleValSrcMac) {
    getProperty(utsOnuAclExtProfileRuleValSrcMac).setValue(aUtsOnuAclExtProfileRuleValSrcMac);
  }

  public byte[] getUtsOnuAclExtProfileRuleValArpTargetMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileRuleValArpTargetMac).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValArpTargetMac(byte[] aUtsOnuAclExtProfileRuleValArpTargetMac) {
    getProperty(utsOnuAclExtProfileRuleValArpTargetMac).setValue(aUtsOnuAclExtProfileRuleValArpTargetMac);
  }

  public byte[] getUtsOnuAclExtProfileRuleValArpSendMac() {
    return (byte[]) getProperty(utsOnuAclExtProfileRuleValArpSendMac).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValArpSendMac(byte[] aUtsOnuAclExtProfileRuleValArpSendMac) {
    getProperty(utsOnuAclExtProfileRuleValArpSendMac).setValue(aUtsOnuAclExtProfileRuleValArpSendMac);
  }

  public String getUtsOnuAclExtProfileRuleValSrcIp() {
    return (String) getProperty(utsOnuAclExtProfileRuleValSrcIp).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValSrcIp(String aUtsOnuAclExtProfileRuleValSrcIp) {
    getProperty(utsOnuAclExtProfileRuleValSrcIp).setValue(aUtsOnuAclExtProfileRuleValSrcIp);
  }

  public String getUtsOnuAclExtProfileRuleValDstIp() {
    return (String) getProperty(utsOnuAclExtProfileRuleValDstIp).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValDstIp(String aUtsOnuAclExtProfileRuleValDstIp) {
    getProperty(utsOnuAclExtProfileRuleValDstIp).setValue(aUtsOnuAclExtProfileRuleValDstIp);
  }

  public Integer getUtsOnuAclExtProfileRuleValVlan() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValVlan).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValVlan(Integer aUtsOnuAclExtProfileRuleValVlan) {
    getProperty(utsOnuAclExtProfileRuleValVlan).setValue(aUtsOnuAclExtProfileRuleValVlan);
  }

  public Integer getUtsOnuAclExtProfileRuleValEtherType() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValEtherType).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValEtherType(Integer aUtsOnuAclExtProfileRuleValEtherType) {
    getProperty(utsOnuAclExtProfileRuleValEtherType).setValue(aUtsOnuAclExtProfileRuleValEtherType);
  }

  public Integer getUtsOnuAclExtProfileRuleValTcpSrcPort() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValTcpSrcPort).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValTcpSrcPort(Integer aUtsOnuAclExtProfileRuleValTcpSrcPort) {
    getProperty(utsOnuAclExtProfileRuleValTcpSrcPort).setValue(aUtsOnuAclExtProfileRuleValTcpSrcPort);
  }

  public Integer getUtsOnuAclExtProfileRuleValTcpDstPort() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValTcpDstPort).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValTcpDstPort(Integer aUtsOnuAclExtProfileRuleValTcpDstPort) {
    getProperty(utsOnuAclExtProfileRuleValTcpDstPort).setValue(aUtsOnuAclExtProfileRuleValTcpDstPort);
  }

  public Integer getUtsOnuAclExtProfileRuleValSrcPortMin() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValSrcPortMin).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValSrcPortMin(Integer aUtsOnuAclExtProfileRuleValSrcPortMin) {
    getProperty(utsOnuAclExtProfileRuleValSrcPortMin).setValue(aUtsOnuAclExtProfileRuleValSrcPortMin);
  }

  public Integer getUtsOnuAclExtProfileRuleValSrcPortMax() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValSrcPortMax).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValSrcPortMax(Integer aUtsOnuAclExtProfileRuleValSrcPortMax) {
    getProperty(utsOnuAclExtProfileRuleValSrcPortMax).setValue(aUtsOnuAclExtProfileRuleValSrcPortMax);
  }

  public Integer getUtsOnuAclExtProfileRuleValDstPortMin() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValDstPortMin).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValDstPortMin(Integer aUtsOnuAclExtProfileRuleValDstPortMin) {
    getProperty(utsOnuAclExtProfileRuleValDstPortMin).setValue(aUtsOnuAclExtProfileRuleValDstPortMin);
  }

  public Integer getUtsOnuAclExtProfileRuleValDstPortMax() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValDstPortMax).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValDstPortMax(Integer aUtsOnuAclExtProfileRuleValDstPortMax) {
    getProperty(utsOnuAclExtProfileRuleValDstPortMax).setValue(aUtsOnuAclExtProfileRuleValDstPortMax);
  }

  public Integer getUtsOnuAclExtProfileRuleValTagPri() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValTagPri).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValTagPri(Integer aUtsOnuAclExtProfileRuleValTagPri) {
    getProperty(utsOnuAclExtProfileRuleValTagPri).setValue(aUtsOnuAclExtProfileRuleValTagPri);
  }

  public Integer getUtsOnuAclExtProfileRuleValDscp() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValDscp).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValDscp(Integer aUtsOnuAclExtProfileRuleValDscp) {
    getProperty(utsOnuAclExtProfileRuleValDscp).setValue(aUtsOnuAclExtProfileRuleValDscp);
  }

  public Integer getUtsOnuAclExtProfileRuleValProtocol() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValProtocol).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValProtocol(Integer aUtsOnuAclExtProfileRuleValProtocol) {
    getProperty(utsOnuAclExtProfileRuleValProtocol).setValue(aUtsOnuAclExtProfileRuleValProtocol);
  }

  public Integer getUtsOnuAclExtProfileRuleValNewDscp() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValNewDscp).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValNewDscp(Integer aUtsOnuAclExtProfileRuleValNewDscp) {
    getProperty(utsOnuAclExtProfileRuleValNewDscp).setValue(aUtsOnuAclExtProfileRuleValNewDscp);
  }

  public Integer getUtsOnuAclExtProfileRuleValNewTagPri() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValNewTagPri).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValNewTagPri(Integer aUtsOnuAclExtProfileRuleValNewTagPri) {
    getProperty(utsOnuAclExtProfileRuleValNewTagPri).setValue(aUtsOnuAclExtProfileRuleValNewTagPri);
  }

  public Integer getUtsOnuAclExtProfileRuleValNewBandwidth() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValNewBandwidth).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValNewBandwidth(Integer aUtsOnuAclExtProfileRuleValNewBandwidth) {
    getProperty(utsOnuAclExtProfileRuleValNewBandwidth).setValue(aUtsOnuAclExtProfileRuleValNewBandwidth);
  }

  public Integer getUtsOnuAclExtProfileRuleValNewBurstSize() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValNewBurstSize).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValNewBurstSize(Integer aUtsOnuAclExtProfileRuleValNewBurstSize) {
    getProperty(utsOnuAclExtProfileRuleValNewBurstSize).setValue(aUtsOnuAclExtProfileRuleValNewBurstSize);
  }

  public Integer getUtsOnuAclExtProfileRuleValNewOutPort() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValNewOutPort).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValNewOutPort(Integer aUtsOnuAclExtProfileRuleValNewOutPort) {
    getProperty(utsOnuAclExtProfileRuleValNewOutPort).setValue(aUtsOnuAclExtProfileRuleValNewOutPort);
  }

  public Integer getUtsOnuAclExtProfileRuleValNewOutTag() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValNewOutTag).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValNewOutTag(Integer aUtsOnuAclExtProfileRuleValNewOutTag) {
    getProperty(utsOnuAclExtProfileRuleValNewOutTag).setValue(aUtsOnuAclExtProfileRuleValNewOutTag);
  }

  public Integer getUtsOnuAclExtProfileRuleValNewVlanId() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValNewVlanId).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValNewVlanId(Integer aUtsOnuAclExtProfileRuleValNewVlanId) {
    getProperty(utsOnuAclExtProfileRuleValNewVlanId).setValue(aUtsOnuAclExtProfileRuleValNewVlanId);
  }

  public Integer getUtsOnuAclExtProfileRuleValIHL() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValIHL).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValIHL(Integer aUtsOnuAclExtProfileRuleValIHL) {
    getProperty(utsOnuAclExtProfileRuleValIHL).setValue(aUtsOnuAclExtProfileRuleValIHL);
  }

  public Integer getUtsOnuAclExtProfileRuleValFragmentOffset() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValFragmentOffset).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValFragmentOffset(Integer aUtsOnuAclExtProfileRuleValFragmentOffset) {
    getProperty(utsOnuAclExtProfileRuleValFragmentOffset).setValue(aUtsOnuAclExtProfileRuleValFragmentOffset);
  }

  public Integer getUtsOnuAclExtProfileRuleValAction() {
    return (Integer) getProperty(utsOnuAclExtProfileRuleValAction).getValue();
  }

  public void setUtsOnuAclExtProfileRuleValAction(Integer aUtsOnuAclExtProfileRuleValAction) {
    getProperty(utsOnuAclExtProfileRuleValAction).setValue(aUtsOnuAclExtProfileRuleValAction);
  }

 


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsOnuAclExtProfileName));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldName));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleName));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldBitmap));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstMac));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcMac));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskArpTargetMac));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskArpSendMac));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcIp));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstIp));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskVlan));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskEtherType));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskTcpSrcPort));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskTcpDstPort));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcPortMin));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcPortMax));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstPortMin));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstPortMax));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskTagPri));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDscp));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskProtocol));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskIHL));
    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskFragmentOffset));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstMac));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcMac));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValArpTargetMac));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValArpSendMac));
    //load twice for too many items.
    load();

    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcIp));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstIp));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValVlan));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValEtherType));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValTcpSrcPort));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValTcpDstPort));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcPortMin));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcPortMax));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstPortMin));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstPortMax));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValTagPri));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDscp));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValProtocol));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewDscp));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewTagPri));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewBandwidth));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewBurstSize));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewOutPort));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewOutTag));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewVlanId));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValIHL));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValFragmentOffset));
    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValAction));
    

    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsOnuAclExtProfileName));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldName));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleName));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldBitmap));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskArpTargetMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskArpSendMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcIp));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstIp));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskVlan));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskEtherType));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskTcpSrcPort));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskTcpDstPort));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcPortMin));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskSrcPortMax));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstPortMin));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDstPortMax));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskTagPri));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskDscp));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskProtocol));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskIHL));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskFragmentOffset));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValArpTargetMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValArpSendMac));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcIp));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstIp));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValVlan));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValEtherType));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValTcpSrcPort));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValTcpDstPort));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcPortMin));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValSrcPortMax));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstPortMin));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDstPortMax));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValTagPri));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValDscp));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValProtocol));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewDscp));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewTagPri));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewBandwidth));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewBurstSize));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewOutPort));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewOutTag));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValNewVlanId));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValIHL));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValFragmentOffset));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValAction));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskInVlan));
//    prepareRead(super.getProperty(utsOnuAclExtProfileFieldMaskInTagPri));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValInVlan));
//    prepareRead(super.getProperty(utsOnuAclExtProfileRuleValInTagPri));


    Vector v = loadAll(new int[]{1,1,1,1,1,1,1 });

    if(v != null) {
      for(int i = 0; i < v.size(); i++) {
          OnuAclExtProfileTable one = (OnuAclExtProfileTable)v.get(i);
        one.retrieve();
      }
    }

    return v;
  }


}
    