/**
 * Created by Zhou Chao, 2010/5/11
 */

package com.winnertel.ems.epon.iad.bbs4000.mib.r400;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

public class CurStatsTable extends SnmpMibBean {

    public static final String curStatsDeviceIndex = "curStatsDeviceIndex";
    public static final String curStatsCardIndex = "curStatsCardIndex";
    public static final String curStatsPortIndex = "curStatsPortIndex";
    public static final String curStatsInOctets = "curStatsInOctets";
    public static final String curStatsInPkts = "curStatsInPkts";
    public static final String curStatsInBroadcastPkts = "curStatsInBroadcastPkts";
    public static final String curStatsInMulticastPkts = "curStatsInMulticastPkts";
    public static final String curStatsInPkts64Octets = "curStatsInPkts64Octets";
    public static final String curStatsInPkts65to127Octets = "curStatsInPkts65to127Octets";
    public static final String curStatsInPkts128to255Octets = "curStatsInPkts128to255Octets";
    public static final String curStatsInPkts256to511Octets = "curStatsInPkts256to511Octets";
    public static final String curStatsInPkts512to1023Octets = "curStatsInPkts512to1023Octets";
    public static final String curStatsInPkts1024to1518Octets = "curStatsInPkts1024to1518Octets";
    public static final String curStatsInPkts1519to1522Octets = "curStatsInPkts1519to1522Octets";
    public static final String curStatsInUndersizePkts = "curStatsInUndersizePkts";
    public static final String curStatsInOversizePkts = "curStatsInOversizePkts";
    public static final String curStatsInFragments = "curStatsInFragments";
    public static final String curStatsInMpcpFrames = "curStatsInMpcpFrames";
    public static final String curStatsInMpcpOctets = "curStatsInMpcpOctets";
    public static final String curStatsInOAMFrames = "curStatsInOAMFrames";
    public static final String curStatsInOAMOctets = "curStatsInOAMOctets";
    public static final String curStatsInCRCErrorPkts = "curStatsInCRCErrorPkts";
    public static final String curStatsInDropEvents = "curStatsInDropEvents";
    public static final String curStatsInJabbers = "curStatsInJabbers";
    public static final String curStatsInCollision = "curStatsInCollision";
    public static final String curStatsOutOctets = "curStatsOutOctets";
    public static final String curStatsOutPkts = "curStatsOutPkts";
    public static final String curStatsOutBroadcastPkts = "curStatsOutBroadcastPkts";
    public static final String curStatsOutMulticastPkts = "curStatsOutMulticastPkts";
    public static final String curStatsOutPkts64Octets = "curStatsOutPkts64Octets";
    public static final String curStatsOutPkts65to127Octets = "curStatsOutPkts65to127Octets";
    public static final String curStatsOutPkts128to255Octets = "curStatsOutPkts128to255Octets";
    public static final String curStatsOutPkts256to511Octets = "curStatsOutPkts256to511Octets";
    public static final String curStatsOutPkts512to1023Octets = "curStatsOutPkts512to1023Octets";
    public static final String curStatsOutPkts1024to1518Octets = "curStatsOutPkts1024to1518Octets";
    public static final String curStatsOutPkts1519o1522Octets = "curStatsOutPkts1519o1522Octets";
    public static final String curStatsOutUndersizePkts = "curStatsOutUndersizePkts";
    public static final String curStatsOutOversizePkts = "curStatsOutOversizePkts";
    public static final String curStatsOutFragments = "curStatsOutFragments";
    public static final String curStatsOutMpcpFrames = "curStatsOutMpcpFrames";
    public static final String curStatsOutMpcpOctets = "curStatsOutMpcpOctets";
    public static final String curStatsOutOAMFrames = "curStatsOutOAMFrames";
    public static final String curStatsOutOAMOctets = "curStatsOutOAMOctets";
    public static final String curStatsOutCRCErrorPkts = "curStatsOutCRCErrorPkts";
    public static final String curStatsOutDropEvents = "curStatsOutDropEvents";
    public static final String curStatsOutJabbers = "curStatsOutJabbers";
    public static final String curStatsOutCollision = "curStatsOutCollision";
    public static final String curStatsStatusAndAction = "curStatsStatusAndAction";

    public CurStatsTable(ISnmpProxy aSnmpProxy) {
        super(aSnmpProxy);
        init();
    }

    protected void init() {
        initProperty(curStatsDeviceIndex, new SnmpMibBeanProperty(curStatsDeviceIndex, ".1.3.6.1.4.1.17409.2.3.10.1.1.1", ISnmpConstant.INTEGER));
        initProperty(curStatsCardIndex, new SnmpMibBeanProperty(curStatsCardIndex, ".1.3.6.1.4.1.17409.2.3.10.1.1.2", ISnmpConstant.INTEGER));
        initProperty(curStatsPortIndex, new SnmpMibBeanProperty(curStatsPortIndex, ".1.3.6.1.4.1.17409.2.3.10.1.1.3", ISnmpConstant.INTEGER));
        initProperty(curStatsInOctets, new SnmpMibBeanProperty(curStatsInOctets, ".1.3.6.1.4.1.17409.2.3.10.1.1.4", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts, new SnmpMibBeanProperty(curStatsInPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.5", ISnmpConstant.COUNTER64));
        initProperty(curStatsInBroadcastPkts, new SnmpMibBeanProperty(curStatsInBroadcastPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.6", ISnmpConstant.COUNTER64));
        initProperty(curStatsInMulticastPkts, new SnmpMibBeanProperty(curStatsInMulticastPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.7", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts64Octets, new SnmpMibBeanProperty(curStatsInPkts64Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.8", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts65to127Octets, new SnmpMibBeanProperty(curStatsInPkts65to127Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.9", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts128to255Octets, new SnmpMibBeanProperty(curStatsInPkts128to255Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.10", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts256to511Octets, new SnmpMibBeanProperty(curStatsInPkts256to511Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.11", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts512to1023Octets, new SnmpMibBeanProperty(curStatsInPkts512to1023Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.12", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts1024to1518Octets, new SnmpMibBeanProperty(curStatsInPkts1024to1518Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.13", ISnmpConstant.COUNTER64));
        initProperty(curStatsInPkts1519to1522Octets, new SnmpMibBeanProperty(curStatsInPkts1519to1522Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.14", ISnmpConstant.COUNTER64));
        initProperty(curStatsInUndersizePkts, new SnmpMibBeanProperty(curStatsInUndersizePkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.15", ISnmpConstant.COUNTER64));
        initProperty(curStatsInOversizePkts, new SnmpMibBeanProperty(curStatsInOversizePkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.16", ISnmpConstant.COUNTER64));
        initProperty(curStatsInFragments, new SnmpMibBeanProperty(curStatsInFragments, ".1.3.6.1.4.1.17409.2.3.10.1.1.17", ISnmpConstant.COUNTER64));
        initProperty(curStatsInMpcpFrames, new SnmpMibBeanProperty(curStatsInMpcpFrames, ".1.3.6.1.4.1.17409.2.3.10.1.1.18", ISnmpConstant.COUNTER64));
        initProperty(curStatsInMpcpOctets, new SnmpMibBeanProperty(curStatsInMpcpOctets, ".1.3.6.1.4.1.17409.2.3.10.1.1.19", ISnmpConstant.COUNTER64));
        initProperty(curStatsInOAMFrames, new SnmpMibBeanProperty(curStatsInOAMFrames, ".1.3.6.1.4.1.17409.2.3.10.1.1.20", ISnmpConstant.COUNTER64));
        initProperty(curStatsInOAMOctets, new SnmpMibBeanProperty(curStatsInOAMOctets, ".1.3.6.1.4.1.17409.2.3.10.1.1.21", ISnmpConstant.COUNTER64));
        initProperty(curStatsInCRCErrorPkts, new SnmpMibBeanProperty(curStatsInCRCErrorPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.22", ISnmpConstant.COUNTER64));
        initProperty(curStatsInDropEvents, new SnmpMibBeanProperty(curStatsInDropEvents, ".1.3.6.1.4.1.17409.2.3.10.1.1.23", ISnmpConstant.COUNTER64));
        initProperty(curStatsInJabbers, new SnmpMibBeanProperty(curStatsInJabbers, ".1.3.6.1.4.1.17409.2.3.10.1.1.24", ISnmpConstant.COUNTER64));
        initProperty(curStatsInCollision, new SnmpMibBeanProperty(curStatsInCollision, ".1.3.6.1.4.1.17409.2.3.10.1.1.25", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutOctets, new SnmpMibBeanProperty(curStatsOutOctets, ".1.3.6.1.4.1.17409.2.3.10.1.1.26", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts, new SnmpMibBeanProperty(curStatsOutPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.27", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutBroadcastPkts, new SnmpMibBeanProperty(curStatsOutBroadcastPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.28", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutMulticastPkts, new SnmpMibBeanProperty(curStatsOutMulticastPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.29", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts64Octets, new SnmpMibBeanProperty(curStatsOutPkts64Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.30", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts65to127Octets, new SnmpMibBeanProperty(curStatsOutPkts65to127Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.31", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts128to255Octets, new SnmpMibBeanProperty(curStatsOutPkts128to255Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.32", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts256to511Octets, new SnmpMibBeanProperty(curStatsOutPkts256to511Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.33", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts512to1023Octets, new SnmpMibBeanProperty(curStatsOutPkts512to1023Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.34", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts1024to1518Octets, new SnmpMibBeanProperty(curStatsOutPkts1024to1518Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.35", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutPkts1519o1522Octets, new SnmpMibBeanProperty(curStatsOutPkts1519o1522Octets, ".1.3.6.1.4.1.17409.2.3.10.1.1.36", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutUndersizePkts, new SnmpMibBeanProperty(curStatsOutUndersizePkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.37", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutOversizePkts, new SnmpMibBeanProperty(curStatsOutOversizePkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.38", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutFragments, new SnmpMibBeanProperty(curStatsOutFragments, ".1.3.6.1.4.1.17409.2.3.10.1.1.39", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutMpcpFrames, new SnmpMibBeanProperty(curStatsOutMpcpFrames, ".1.3.6.1.4.1.17409.2.3.10.1.1.40", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutMpcpOctets, new SnmpMibBeanProperty(curStatsOutMpcpOctets, ".1.3.6.1.4.1.17409.2.3.10.1.1.41", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutOAMFrames, new SnmpMibBeanProperty(curStatsOutOAMFrames, ".1.3.6.1.4.1.17409.2.3.10.1.1.42", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutOAMOctets, new SnmpMibBeanProperty(curStatsOutOAMOctets, ".1.3.6.1.4.1.17409.2.3.10.1.1.43", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutCRCErrorPkts, new SnmpMibBeanProperty(curStatsOutCRCErrorPkts, ".1.3.6.1.4.1.17409.2.3.10.1.1.44", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutDropEvents, new SnmpMibBeanProperty(curStatsOutDropEvents, ".1.3.6.1.4.1.17409.2.3.10.1.1.45", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutJabbers, new SnmpMibBeanProperty(curStatsOutJabbers, ".1.3.6.1.4.1.17409.2.3.10.1.1.46", ISnmpConstant.COUNTER64));
        initProperty(curStatsOutCollision, new SnmpMibBeanProperty(curStatsOutCollision, ".1.3.6.1.4.1.17409.2.3.10.1.1.47", ISnmpConstant.COUNTER64));

        initProperty(curStatsStatusAndAction, new SnmpMibBeanProperty(curStatsStatusAndAction, ".1.3.6.1.4.1.17409.2.3.10.1.1.48", ISnmpConstant.INTEGER));
    }

    public Integer getCurStatsDeviceIndex() {
        return (Integer) getIndex(0);
    }

    public void setCurStatsDeviceIndex(Integer aCurStatsDeviceIndex) {
        setIndex(0, aCurStatsDeviceIndex);
    }

    public Integer getCurStatsCardIndex() {
        return (Integer) getIndex(1);
    }

    public void setCurStatsCardIndex(Integer aCurStatsCardIndex) {
        setIndex(1, aCurStatsCardIndex);
    }

    public Integer getCurStatsPortIndex() {
        return (Integer) getIndex(2);
    }

    public void setCurStatsPortIndex(Integer aCurStatsPortIndex) {
        setIndex(2, aCurStatsPortIndex);
    }

    public BigInteger getCurStatsInOctets() {
        return (BigInteger) getProperty(curStatsInOctets).getValue();
    }

    public void setCurStatsInOctets(BigInteger aCurStatsInOctets) {
        getProperty(curStatsInOctets).setValue(aCurStatsInOctets);
    }

    public BigInteger getCurStatsInPkts() {
        return (BigInteger) getProperty(curStatsInPkts).getValue();
    }

    public void setCurStatsInPkts(BigInteger aCurStatsInPkts) {
        getProperty(curStatsInPkts).setValue(aCurStatsInPkts);
    }

    public BigInteger getCurStatsInBroadcastPkts() {
        return (BigInteger) getProperty(curStatsInBroadcastPkts).getValue();
    }

    public void setCurStatsInBroadcastPkts(BigInteger aCurStatsInBroadcastPkts) {
        getProperty(curStatsInBroadcastPkts).setValue(aCurStatsInBroadcastPkts);
    }

    public BigInteger getCurStatsInMulticastPkts() {
        return (BigInteger) getProperty(curStatsInMulticastPkts).getValue();
    }

    public void setCurStatsInMulticastPkts(BigInteger aCurStatsInMulticastPkts) {
        getProperty(curStatsInMulticastPkts).setValue(aCurStatsInMulticastPkts);
    }

    public BigInteger getCurStatsInPkts64Octets() {
        return (BigInteger) getProperty(curStatsInPkts64Octets).getValue();
    }

    public void setCurStatsInPkts64Octets(BigInteger aCurStatsInPkts64Octets) {
        getProperty(curStatsInPkts64Octets).setValue(aCurStatsInPkts64Octets);
    }

    public BigInteger getCurStatsInPkts65to127Octets() {
        return (BigInteger) getProperty(curStatsInPkts65to127Octets).getValue();
    }

    public void setCurStatsInPkts65to127Octets(BigInteger aCurStatsInPkts65to127Octets) {
        getProperty(curStatsInPkts65to127Octets).setValue(aCurStatsInPkts65to127Octets);
    }

    public BigInteger getCurStatsInPkts128to255Octets() {
        return (BigInteger) getProperty(curStatsInPkts128to255Octets).getValue();
    }

    public void setCurStatsInPkts128to255Octets(BigInteger aCurStatsInPkts128to255Octets) {
        getProperty(curStatsInPkts128to255Octets).setValue(aCurStatsInPkts128to255Octets);
    }

    public BigInteger getCurStatsInPkts256to511Octets() {
        return (BigInteger) getProperty(curStatsInPkts256to511Octets).getValue();
    }

    public void setCurStatsInPkts256to511Octets(BigInteger aCurStatsInPkts256to511Octets) {
        getProperty(curStatsInPkts256to511Octets).setValue(aCurStatsInPkts256to511Octets);
    }

    public BigInteger getCurStatsInPkts512to1023Octets() {
        return (BigInteger) getProperty(curStatsInPkts512to1023Octets).getValue();
    }

    public void setCurStatsInPkts512to1023Octets(BigInteger aCurStatsInPkts512to1023Octets) {
        getProperty(curStatsInPkts512to1023Octets).setValue(aCurStatsInPkts512to1023Octets);
    }

    public BigInteger getCurStatsInPkts1024to1518Octets() {
        return (BigInteger) getProperty(curStatsInPkts1024to1518Octets).getValue();
    }

    public void setCurStatsInPkts1024to1518Octets(BigInteger aCurStatsInPkts1024to1518Octets) {
        getProperty(curStatsInPkts1024to1518Octets).setValue(aCurStatsInPkts1024to1518Octets);
    }

    public BigInteger getCurStatsInPkts1519to1522Octets() {
        return (BigInteger) getProperty(curStatsInPkts1519to1522Octets).getValue();
    }

    public void setCurStatsInPkts1519to1522Octets(BigInteger aCurStatsInPkts1519to1522Octets) {
        getProperty(curStatsInPkts1519to1522Octets).setValue(aCurStatsInPkts1519to1522Octets);
    }

    public BigInteger getCurStatsInUndersizePkts() {
        return (BigInteger) getProperty(curStatsInUndersizePkts).getValue();
    }

    public void setCurStatsInUndersizePkts(BigInteger aCurStatsInUndersizePkts) {
        getProperty(curStatsInUndersizePkts).setValue(aCurStatsInUndersizePkts);
    }

    public BigInteger getCurStatsInOversizePkts() {
        return (BigInteger) getProperty(curStatsInOversizePkts).getValue();
    }

    public void setCurStatsInOversizePkts(BigInteger aCurStatsInOversizePkts) {
        getProperty(curStatsInOversizePkts).setValue(aCurStatsInOversizePkts);
    }

    public BigInteger getCurStatsInFragments() {
        return (BigInteger) getProperty(curStatsInFragments).getValue();
    }

    public void setCurStatsInFragments(BigInteger aCurStatsInFragments) {
        getProperty(curStatsInFragments).setValue(aCurStatsInFragments);
    }

    public BigInteger getCurStatsInMpcpFrames() {
        return (BigInteger) getProperty(curStatsInMpcpFrames).getValue();
    }

    public void setCurStatsInMpcpFrames(BigInteger aCurStatsInMpcpFrames) {
        getProperty(curStatsInMpcpFrames).setValue(aCurStatsInMpcpFrames);
    }

    public BigInteger getCurStatsInMpcpOctets() {
        return (BigInteger) getProperty(curStatsInMpcpOctets).getValue();
    }

    public void setCurStatsInMpcpOctets(BigInteger aCurStatsInMpcpOctets) {
        getProperty(curStatsInMpcpOctets).setValue(aCurStatsInMpcpOctets);
    }

    public BigInteger getCurStatsInOAMFrames() {
        return (BigInteger) getProperty(curStatsInOAMFrames).getValue();
    }

    public void setCurStatsInOAMFrames(BigInteger aCurStatsInOAMFrames) {
        getProperty(curStatsInOAMFrames).setValue(aCurStatsInOAMFrames);
    }

    public BigInteger getCurStatsInOAMOctets() {
        return (BigInteger) getProperty(curStatsInOAMOctets).getValue();
    }

    public void setCurStatsInOAMOctets(BigInteger aCurStatsInOAMOctets) {
        getProperty(curStatsInOAMOctets).setValue(aCurStatsInOAMOctets);
    }

    public BigInteger getCurStatsInCRCErrorPkts() {
        return (BigInteger) getProperty(curStatsInCRCErrorPkts).getValue();
    }

    public void setCurStatsInCRCErrorPkts(BigInteger aCurStatsInCRCErrorPkts) {
        getProperty(curStatsInCRCErrorPkts).setValue(aCurStatsInCRCErrorPkts);
    }

    public BigInteger getCurStatsInDropEvents() {
        return (BigInteger) getProperty(curStatsInDropEvents).getValue();
    }

    public void setCurStatsInDropEvents(BigInteger aCurStatsInDropEvents) {
        getProperty(curStatsInDropEvents).setValue(aCurStatsInDropEvents);
    }

    public BigInteger getCurStatsInJabbers() {
        return (BigInteger) getProperty(curStatsInJabbers).getValue();
    }

    public void setCurStatsInJabbers(BigInteger aCurStatsInJabbers) {
        getProperty(curStatsInJabbers).setValue(aCurStatsInJabbers);
    }

    public BigInteger getCurStatsInCollision() {
        return (BigInteger) getProperty(curStatsInCollision).getValue();
    }

    public void setCurStatsInCollision(BigInteger aCurStatsInCollision) {
        getProperty(curStatsInCollision).setValue(aCurStatsInCollision);
    }

    public BigInteger getCurStatsOutOctets() {
        return (BigInteger) getProperty(curStatsOutOctets).getValue();
    }

    public void setCurStatsOutOctets(BigInteger aCurStatsOutOctets) {
        getProperty(curStatsOutOctets).setValue(aCurStatsOutOctets);
    }

    public BigInteger getCurStatsOutPkts() {
        return (BigInteger) getProperty(curStatsOutPkts).getValue();
    }

    public void setCurStatsOutPkts(BigInteger aCurStatsOutPkts) {
        getProperty(curStatsOutPkts).setValue(aCurStatsOutPkts);
    }

    public BigInteger getCurStatsOutBroadcastPkts() {
        return (BigInteger) getProperty(curStatsOutBroadcastPkts).getValue();
    }

    public void setCurStatsOutBroadcastPkts(BigInteger aCurStatsOutBroadcastPkts) {
        getProperty(curStatsOutBroadcastPkts).setValue(aCurStatsOutBroadcastPkts);
    }

    public BigInteger getCurStatsOutMulticastPkts() {
        return (BigInteger) getProperty(curStatsOutMulticastPkts).getValue();
    }

    public void setCurStatsOutMulticastPkts(BigInteger aCurStatsOutMulticastPkts) {
        getProperty(curStatsOutMulticastPkts).setValue(aCurStatsOutMulticastPkts);
    }

    public BigInteger getCurStatsOutPkts64Octets() {
        return (BigInteger) getProperty(curStatsOutPkts64Octets).getValue();
    }

    public void setCurStatsOutPkts64Octets(BigInteger aCurStatsOutPkts64Octets) {
        getProperty(curStatsOutPkts64Octets).setValue(aCurStatsOutPkts64Octets);
    }

    public BigInteger getCurStatsOutPkts65to127Octets() {
        return (BigInteger) getProperty(curStatsOutPkts65to127Octets).getValue();
    }

    public void setCurStatsOutPkts65to127Octets(BigInteger aCurStatsOutPkts65to127Octets) {
        getProperty(curStatsOutPkts65to127Octets).setValue(aCurStatsOutPkts65to127Octets);
    }

    public BigInteger getCurStatsOutPkts128to255Octets() {
        return (BigInteger) getProperty(curStatsOutPkts128to255Octets).getValue();
    }

    public void setCurStatsOutPkts128to255Octets(BigInteger aCurStatsOutPkts128to255Octets) {
        getProperty(curStatsOutPkts128to255Octets).setValue(aCurStatsOutPkts128to255Octets);
    }

    public BigInteger getCurStatsOutPkts256to511Octets() {
        return (BigInteger) getProperty(curStatsOutPkts256to511Octets).getValue();
    }

    public void setCurStatsOutPkts256to511Octets(BigInteger aCurStatsOutPkts256to511Octets) {
        getProperty(curStatsOutPkts256to511Octets).setValue(aCurStatsOutPkts256to511Octets);
    }

    public BigInteger getCurStatsOutPkts512to1023Octets() {
        return (BigInteger) getProperty(curStatsOutPkts512to1023Octets).getValue();
    }

    public void setCurStatsOutPkts512to1023Octets(BigInteger aCurStatsOutPkts512to1023Octets) {
        getProperty(curStatsOutPkts512to1023Octets).setValue(aCurStatsOutPkts512to1023Octets);
    }

    public BigInteger getCurStatsOutPkts1024to1518Octets() {
        return (BigInteger) getProperty(curStatsOutPkts1024to1518Octets).getValue();
    }

    public void setCurStatsOutPkts1024to1518Octets(BigInteger aCurStatsOutPkts1024to1518Octets) {
        getProperty(curStatsOutPkts1024to1518Octets).setValue(aCurStatsOutPkts1024to1518Octets);
    }

    public BigInteger getCurStatsOutPkts1519o1522Octets() {
        return (BigInteger) getProperty(curStatsOutPkts1519o1522Octets).getValue();
    }

    public void setCurStatsOutPkts1519o1522Octets(BigInteger aCurStatsOutPkts1519o1522Octets) {
        getProperty(curStatsOutPkts1519o1522Octets).setValue(aCurStatsOutPkts1519o1522Octets);
    }

    public BigInteger getCurStatsOutUndersizePkts() {
        return (BigInteger) getProperty(curStatsOutUndersizePkts).getValue();
    }

    public void setCurStatsOutUndersizePkts(BigInteger aCurStatsOutUndersizePkts) {
        getProperty(curStatsOutUndersizePkts).setValue(aCurStatsOutUndersizePkts);
    }

    public BigInteger getCurStatsOutOversizePkts() {
        return (BigInteger) getProperty(curStatsOutOversizePkts).getValue();
    }

    public void setCurStatsOutOversizePkts(BigInteger aCurStatsOutOversizePkts) {
        getProperty(curStatsOutOversizePkts).setValue(aCurStatsOutOversizePkts);
    }

    public BigInteger getCurStatsOutFragments() {
        return (BigInteger) getProperty(curStatsOutFragments).getValue();
    }

    public void setCurStatsOutFragments(BigInteger aCurStatsOutFragments) {
        getProperty(curStatsOutFragments).setValue(aCurStatsOutFragments);
    }

    public BigInteger getCurStatsOutMpcpFrames() {
        return (BigInteger) getProperty(curStatsOutMpcpFrames).getValue();
    }

    public void setCurStatsOutMpcpFrames(BigInteger aCurStatsOutMpcpFrames) {
        getProperty(curStatsOutMpcpFrames).setValue(aCurStatsOutMpcpFrames);
    }

    public BigInteger getCurStatsOutMpcpOctets() {
        return (BigInteger) getProperty(curStatsOutMpcpOctets).getValue();
    }

    public void setCurStatsOutMpcpOctets(BigInteger aCurStatsOutMpcpOctets) {
        getProperty(curStatsOutMpcpOctets).setValue(aCurStatsOutMpcpOctets);
    }

    public BigInteger getCurStatsOutOAMFrames() {
        return (BigInteger) getProperty(curStatsOutOAMFrames).getValue();
    }

    public void setCurStatsOutOAMFrames(BigInteger aCurStatsOutOAMFrames) {
        getProperty(curStatsOutOAMFrames).setValue(aCurStatsOutOAMFrames);
    }

    public BigInteger getCurStatsOutOAMOctets() {
        return (BigInteger) getProperty(curStatsOutOAMOctets).getValue();
    }

    public void setCurStatsOutOAMOctets(BigInteger aCurStatsOutOAMOctets) {
        getProperty(curStatsOutOAMOctets).setValue(aCurStatsOutOAMOctets);
    }

    public BigInteger getCurStatsOutCRCErrorPkts() {
        return (BigInteger) getProperty(curStatsOutCRCErrorPkts).getValue();
    }

    public void setCurStatsOutCRCErrorPkts(BigInteger aCurStatsOutCRCErrorPkts) {
        getProperty(curStatsOutCRCErrorPkts).setValue(aCurStatsOutCRCErrorPkts);
    }

    public BigInteger getCurStatsOutDropEvents() {
        return (BigInteger) getProperty(curStatsOutDropEvents).getValue();
    }

    public void setCurStatsOutDropEvents(BigInteger aCurStatsOutDropEvents) {
        getProperty(curStatsOutDropEvents).setValue(aCurStatsOutDropEvents);
    }

    public BigInteger getCurStatsOutJabbers() {
        return (BigInteger) getProperty(curStatsOutJabbers).getValue();
    }

    public void setCurStatsOutJabbers(BigInteger aCurStatsOutJabbers) {
        getProperty(curStatsOutJabbers).setValue(aCurStatsOutJabbers);
    }

    public BigInteger getCurStatsOutCollision() {
        return (BigInteger) getProperty(curStatsOutCollision).getValue();
    }

    public void setCurStatsOutCollision(BigInteger aCurStatsOutCollision) {
        getProperty(curStatsOutCollision).setValue(aCurStatsOutCollision);
    }

    public Integer getCurStatsStatusAndAction() {
        return (Integer) getProperty(curStatsStatusAndAction).getValue();
    }

    public void setCurStatsStatusAndAction(Integer aCurStatsStatusAndAction) {
        getProperty(curStatsStatusAndAction).setValue(aCurStatsStatusAndAction);
    }

    public boolean cleanCurStats() throws MibBeanException {
        setCurStatsStatusAndAction(2);
        prepareSave(getProperty(curStatsStatusAndAction));

        return save();
    }

    public boolean retrieve() throws MibBeanException {
        prepareRead(getProperty(curStatsInOctets));
        prepareRead(getProperty(curStatsInPkts));
        prepareRead(getProperty(curStatsInBroadcastPkts));
        prepareRead(getProperty(curStatsInMulticastPkts));
        prepareRead(getProperty(curStatsInPkts64Octets));
        prepareRead(getProperty(curStatsInPkts65to127Octets));
        prepareRead(getProperty(curStatsInPkts128to255Octets));
        prepareRead(getProperty(curStatsInPkts256to511Octets));
        prepareRead(getProperty(curStatsInPkts512to1023Octets));
        prepareRead(getProperty(curStatsInPkts1024to1518Octets));
        prepareRead(getProperty(curStatsInPkts1519to1522Octets));
        prepareRead(getProperty(curStatsInUndersizePkts));
        prepareRead(getProperty(curStatsInOversizePkts));
        prepareRead(getProperty(curStatsInFragments));
        prepareRead(getProperty(curStatsInMpcpFrames));
        prepareRead(getProperty(curStatsInMpcpOctets));
        prepareRead(getProperty(curStatsInOAMFrames));
        prepareRead(getProperty(curStatsInOAMOctets));
        prepareRead(getProperty(curStatsInCRCErrorPkts));
        prepareRead(getProperty(curStatsInDropEvents));
        prepareRead(getProperty(curStatsInJabbers));
        prepareRead(getProperty(curStatsInCollision));
        prepareRead(getProperty(curStatsOutOctets));
        prepareRead(getProperty(curStatsOutPkts));
        prepareRead(getProperty(curStatsOutBroadcastPkts));
        prepareRead(getProperty(curStatsOutMulticastPkts));
        prepareRead(getProperty(curStatsOutPkts64Octets));
        prepareRead(getProperty(curStatsOutPkts65to127Octets));
        prepareRead(getProperty(curStatsOutPkts128to255Octets));
        prepareRead(getProperty(curStatsOutPkts256to511Octets));
        prepareRead(getProperty(curStatsOutPkts512to1023Octets));
        prepareRead(getProperty(curStatsOutPkts1024to1518Octets));
        prepareRead(getProperty(curStatsOutPkts1519o1522Octets));
        prepareRead(getProperty(curStatsOutUndersizePkts));
        prepareRead(getProperty(curStatsOutOversizePkts));
        prepareRead(getProperty(curStatsOutFragments));
        prepareRead(getProperty(curStatsOutMpcpFrames));
        prepareRead(getProperty(curStatsOutMpcpOctets));
        prepareRead(getProperty(curStatsOutOAMFrames));
        prepareRead(getProperty(curStatsOutOAMOctets));
        prepareRead(getProperty(curStatsOutCRCErrorPkts));
        prepareRead(getProperty(curStatsOutDropEvents));
        prepareRead(getProperty(curStatsOutJabbers));
        prepareRead(getProperty(curStatsOutCollision));
        //prepareRead(getProperty(curStatsStatusAndAction));

        return load();
    }

    public Vector retrieveAll() throws MibBeanException {
        prepareRead(getProperty(curStatsInOctets));
        prepareRead(getProperty(curStatsInPkts));
        prepareRead(getProperty(curStatsInBroadcastPkts));
        prepareRead(getProperty(curStatsInMulticastPkts));
        prepareRead(getProperty(curStatsInPkts64Octets));
        prepareRead(getProperty(curStatsInPkts65to127Octets));
        prepareRead(getProperty(curStatsInPkts128to255Octets));
        prepareRead(getProperty(curStatsInPkts256to511Octets));
        prepareRead(getProperty(curStatsInPkts512to1023Octets));
        prepareRead(getProperty(curStatsInPkts1024to1518Octets));
        prepareRead(getProperty(curStatsInPkts1519to1522Octets));
        prepareRead(getProperty(curStatsInUndersizePkts));
        prepareRead(getProperty(curStatsInOversizePkts));
        prepareRead(getProperty(curStatsInFragments));
        prepareRead(getProperty(curStatsInMpcpFrames));
        prepareRead(getProperty(curStatsInMpcpOctets));
        prepareRead(getProperty(curStatsInOAMFrames));
        prepareRead(getProperty(curStatsInOAMOctets));
        prepareRead(getProperty(curStatsInCRCErrorPkts));
        prepareRead(getProperty(curStatsInDropEvents));
        prepareRead(getProperty(curStatsInJabbers));
        prepareRead(getProperty(curStatsInCollision));
        prepareRead(getProperty(curStatsOutOctets));
        prepareRead(getProperty(curStatsOutPkts));
        prepareRead(getProperty(curStatsOutBroadcastPkts));
        prepareRead(getProperty(curStatsOutMulticastPkts));
        prepareRead(getProperty(curStatsOutPkts64Octets));
        prepareRead(getProperty(curStatsOutPkts65to127Octets));
        prepareRead(getProperty(curStatsOutPkts128to255Octets));
        prepareRead(getProperty(curStatsOutPkts256to511Octets));
        prepareRead(getProperty(curStatsOutPkts512to1023Octets));
        prepareRead(getProperty(curStatsOutPkts1024to1518Octets));
        prepareRead(getProperty(curStatsOutPkts1519o1522Octets));
        prepareRead(getProperty(curStatsOutUndersizePkts));
        prepareRead(getProperty(curStatsOutOversizePkts));
        prepareRead(getProperty(curStatsOutFragments));
        prepareRead(getProperty(curStatsOutMpcpFrames));
        prepareRead(getProperty(curStatsOutMpcpOctets));
        prepareRead(getProperty(curStatsOutOAMFrames));
        prepareRead(getProperty(curStatsOutOAMOctets));
        prepareRead(getProperty(curStatsOutCRCErrorPkts));
        prepareRead(getProperty(curStatsOutDropEvents));
        prepareRead(getProperty(curStatsOutJabbers));
        prepareRead(getProperty(curStatsOutCollision));
        //prepareRead(getProperty(curStatsStatusAndAction));

        return loadAll(new int[]{1, 1, 1});
    }

    public boolean modify() throws MibBeanException {
        prepareSave(getProperty(curStatsStatusAndAction));

        return save();
    }

}