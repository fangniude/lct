/*
 * Copyright (c) 2002-2005 UTStarcom, Inc.
 * All rights reserved.
 */
package com.winnertel.ems.epon.iad.bbs4000.mib.r200;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpConstant;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.model.snmp.SnmpMibBeanProperty;

import java.math.BigInteger;
import java.util.Vector;

/**
 * The OltIf2ExtStatTable class.
 * Created by QuickDVM
 */
public class OltIf2ExtStatTable extends SnmpMibBean {
  public static final String utsPonIf2ExtStatModule = "utsPonIf2ExtStatModule";
  public static final String utsPonIf2ExtStatDevice = "utsPonIf2ExtStatDevice";
  public static final String utsPonIf2ExtStatPort = "utsPonIf2ExtStatPort";
  public static final String utsPonIf2ExtStatLogicalLinkId = "utsPonIf2ExtStatLogicalLinkId";
  public static final String utsPonIfExtSysFrameTxOk = "utsPonIfExtSysFrameTxOk";
  public static final String utsPonIfExtSysFrameRxOk = "utsPonIfExtSysFrameRxOk";
  public static final String utsPonIfExtSysFrameTxErr = "utsPonIfExtSysFrameTxErr";
  public static final String utsPonIfExtSysFrameRxErr = "utsPonIfExtSysFrameRxErr";
  public static final String utsPonIfExtSysFrameTxUnicast = "utsPonIfExtSysFrameTxUnicast";
  public static final String utsPonIfExtSysFrameRxUnicast = "utsPonIfExtSysFrameRxUnicast";
  public static final String utsPonIfExtSysFrameTxMulticast = "utsPonIfExtSysFrameTxMulticast";
  public static final String utsPonIfExtSysFrameRxMulticast = "utsPonIfExtSysFrameRxMulticast";
  public static final String utsPonIfExtSysFrameTxBroadcast = "utsPonIfExtSysFrameTxBroadcast";
  public static final String utsPonIfExtSysFrameRxBroadcast = "utsPonIfExtSysFrameRxBroadcast";
  public static final String utsPonIfExtSysOctetTxOk = "utsPonIfExtSysOctetTxOk";
  public static final String utsPonIfExtSysOctetRxOk = "utsPonIfExtSysOctetRxOk";
  public static final String utsPonIfExtPonFrameTxOk = "utsPonIfExtPonFrameTxOk";
  public static final String utsPonIfExtPonFrameRxOk = "utsPonIfExtPonFrameRxOk";
  public static final String utsPonIfExtPonOctetTxOk = "utsPonIfExtPonOctetTxOk";
  public static final String utsPonIfExtPonOctetRxOk = "utsPonIfExtPonOctetRxOk";
  public static final String utsPonIfExtEponFrameRxReport = "utsPonIfExtEponFrameRxReport";
  public static final String utsPonIfExtEponFrameTxReport = "utsPonIfExtEponFrameTxReport";
  public static final String utsPonIfExtEponFrameRxGate = "utsPonIfExtEponFrameRxGate";
  public static final String utsPonIfExtEponFrameTxGate = "utsPonIfExtEponFrameTxGate";
  public static final String utsPonIfExtEponFrameRxRegReq = "utsPonIfExtEponFrameRxRegReq";
  public static final String utsPonIfExtEponFrameTxRegReq = "utsPonIfExtEponFrameTxRegReq";
  public static final String utsPonIfExtEponFrameRxReg = "utsPonIfExtEponFrameRxReg";
  public static final String utsPonIfExtEponFrameTxReg = "utsPonIfExtEponFrameTxReg";
  public static final String utsPonIfExtEponFrameRxRegAck = "utsPonIfExtEponFrameRxRegAck";
  public static final String utsPonIfExtEponFrameTxRegAck = "utsPonIfExtEponFrameTxRegAck";
  public static final String utsPonIfExtEponFrameCrc8Error = "utsPonIfExtEponFrameCrc8Error";
  public static final String utsPonIfExtEponFrameSldError = "utsPonIfExtEponFrameSldError";
  public static final String utsPonIfExtStatPMStatus = "utsPonIfExtStatPMStatus";

  public OltIf2ExtStatTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
    initProperty(utsPonIf2ExtStatModule, new SnmpMibBeanProperty(utsPonIf2ExtStatModule, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.1", ISnmpConstant.INTEGER));
    initProperty(utsPonIf2ExtStatDevice, new SnmpMibBeanProperty(utsPonIf2ExtStatDevice, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.2", ISnmpConstant.INTEGER));
    initProperty(utsPonIf2ExtStatPort, new SnmpMibBeanProperty(utsPonIf2ExtStatPort, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.3", ISnmpConstant.INTEGER));
    initProperty(utsPonIf2ExtStatLogicalLinkId, new SnmpMibBeanProperty(utsPonIf2ExtStatLogicalLinkId, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.4", ISnmpConstant.INTEGER));
    initProperty(utsPonIfExtSysFrameTxOk, new SnmpMibBeanProperty(utsPonIfExtSysFrameTxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.5", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameRxOk, new SnmpMibBeanProperty(utsPonIfExtSysFrameRxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.6", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameTxErr, new SnmpMibBeanProperty(utsPonIfExtSysFrameTxErr, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.7", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameRxErr, new SnmpMibBeanProperty(utsPonIfExtSysFrameRxErr, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.8", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameTxUnicast, new SnmpMibBeanProperty(utsPonIfExtSysFrameTxUnicast, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.9", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameRxUnicast, new SnmpMibBeanProperty(utsPonIfExtSysFrameRxUnicast, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.10", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameTxMulticast, new SnmpMibBeanProperty(utsPonIfExtSysFrameTxMulticast, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.11", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameRxMulticast, new SnmpMibBeanProperty(utsPonIfExtSysFrameRxMulticast, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.12", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameTxBroadcast, new SnmpMibBeanProperty(utsPonIfExtSysFrameTxBroadcast, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.13", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysFrameRxBroadcast, new SnmpMibBeanProperty(utsPonIfExtSysFrameRxBroadcast, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.14", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysOctetTxOk, new SnmpMibBeanProperty(utsPonIfExtSysOctetTxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.30", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtSysOctetRxOk, new SnmpMibBeanProperty(utsPonIfExtSysOctetRxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.31", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtPonFrameTxOk, new SnmpMibBeanProperty(utsPonIfExtPonFrameTxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.60", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtPonFrameRxOk, new SnmpMibBeanProperty(utsPonIfExtPonFrameRxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.61", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtPonOctetTxOk, new SnmpMibBeanProperty(utsPonIfExtPonOctetTxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.80", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtPonOctetRxOk, new SnmpMibBeanProperty(utsPonIfExtPonOctetRxOk, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.81", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameRxReport, new SnmpMibBeanProperty(utsPonIfExtEponFrameRxReport, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.100", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameTxReport, new SnmpMibBeanProperty(utsPonIfExtEponFrameTxReport, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.101", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameRxGate, new SnmpMibBeanProperty(utsPonIfExtEponFrameRxGate, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.102", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameTxGate, new SnmpMibBeanProperty(utsPonIfExtEponFrameTxGate, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.103", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameRxRegReq, new SnmpMibBeanProperty(utsPonIfExtEponFrameRxRegReq, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.104", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameTxRegReq, new SnmpMibBeanProperty(utsPonIfExtEponFrameTxRegReq, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.105", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameRxReg, new SnmpMibBeanProperty(utsPonIfExtEponFrameRxReg, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.106", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameTxReg, new SnmpMibBeanProperty(utsPonIfExtEponFrameTxReg, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.107", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameRxRegAck, new SnmpMibBeanProperty(utsPonIfExtEponFrameRxRegAck, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.108", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameTxRegAck, new SnmpMibBeanProperty(utsPonIfExtEponFrameTxRegAck, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.109", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameCrc8Error, new SnmpMibBeanProperty(utsPonIfExtEponFrameCrc8Error, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.110", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtEponFrameSldError, new SnmpMibBeanProperty(utsPonIfExtEponFrameSldError, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.111", ISnmpConstant.COUNTER64));
    initProperty(utsPonIfExtStatPMStatus, new SnmpMibBeanProperty(utsPonIfExtStatPMStatus, ".1.3.6.1.4.1.41355.1800.4.2.1.1.6.1.200", ISnmpConstant.INTEGER));

  }


  public Integer getUtsPonIf2ExtStatModule() {
    return (Integer) getIndex(0);
  }

  public void setUtsPonIf2ExtStatModule(Integer aUtsPonIf2ExtStatModule) {
    setIndex(0, aUtsPonIf2ExtStatModule);
  }


  public Integer getUtsPonIf2ExtStatDevice() {
    return (Integer) getIndex(1);
  }

  public void setUtsPonIf2ExtStatDevice(Integer aUtsPonIf2ExtStatDevice) {
    setIndex(1, aUtsPonIf2ExtStatDevice);
  }


  public Integer getUtsPonIf2ExtStatPort() {
    return (Integer) getIndex(2);
  }

  public void setUtsPonIf2ExtStatPort(Integer aUtsPonIf2ExtStatPort) {
    setIndex(2, aUtsPonIf2ExtStatPort);
  }


  public Integer getUtsPonIf2ExtStatLogicalLinkId() {
    return (Integer) getIndex(3);
  }

  public void setUtsPonIf2ExtStatLogicalLinkId(Integer aUtsPonIf2ExtStatLogicalLinkId) {
    setIndex(3, aUtsPonIf2ExtStatLogicalLinkId);
  }

  public BigInteger getUtsPonIfExtSysFrameTxOk() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameTxOk).getValue();
  }

  public void setUtsPonIfExtSysFrameTxOk(BigInteger aUtsPonIfExtSysFrameTxOk) {
    getProperty(utsPonIfExtSysFrameTxOk).setValue(aUtsPonIfExtSysFrameTxOk);
  }

  public BigInteger getUtsPonIfExtSysFrameRxOk() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameRxOk).getValue();
  }

  public void setUtsPonIfExtSysFrameRxOk(BigInteger aUtsPonIfExtSysFrameRxOk) {
    getProperty(utsPonIfExtSysFrameRxOk).setValue(aUtsPonIfExtSysFrameRxOk);
  }

  public BigInteger getUtsPonIfExtSysFrameTxErr() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameTxErr).getValue();
  }

  public void setUtsPonIfExtSysFrameTxErr(BigInteger aUtsPonIfExtSysFrameTxErr) {
    getProperty(utsPonIfExtSysFrameTxErr).setValue(aUtsPonIfExtSysFrameTxErr);
  }

  public BigInteger getUtsPonIfExtSysFrameRxErr() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameRxErr).getValue();
  }

  public void setUtsPonIfExtSysFrameRxErr(BigInteger aUtsPonIfExtSysFrameRxErr) {
    getProperty(utsPonIfExtSysFrameRxErr).setValue(aUtsPonIfExtSysFrameRxErr);
  }

  public BigInteger getUtsPonIfExtSysFrameTxUnicast() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameTxUnicast).getValue();
  }

  public void setUtsPonIfExtSysFrameTxUnicast(BigInteger aUtsPonIfExtSysFrameTxUnicast) {
    getProperty(utsPonIfExtSysFrameTxUnicast).setValue(aUtsPonIfExtSysFrameTxUnicast);
  }

  public BigInteger getUtsPonIfExtSysFrameRxUnicast() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameRxUnicast).getValue();
  }

  public void setUtsPonIfExtSysFrameRxUnicast(BigInteger aUtsPonIfExtSysFrameRxUnicast) {
    getProperty(utsPonIfExtSysFrameRxUnicast).setValue(aUtsPonIfExtSysFrameRxUnicast);
  }

  public BigInteger getUtsPonIfExtSysFrameTxMulticast() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameTxMulticast).getValue();
  }

  public void setUtsPonIfExtSysFrameTxMulticast(BigInteger aUtsPonIfExtSysFrameTxMulticast) {
    getProperty(utsPonIfExtSysFrameTxMulticast).setValue(aUtsPonIfExtSysFrameTxMulticast);
  }

  public BigInteger getUtsPonIfExtSysFrameRxMulticast() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameRxMulticast).getValue();
  }

  public void setUtsPonIfExtSysFrameRxMulticast(BigInteger aUtsPonIfExtSysFrameRxMulticast) {
    getProperty(utsPonIfExtSysFrameRxMulticast).setValue(aUtsPonIfExtSysFrameRxMulticast);
  }

  public BigInteger getUtsPonIfExtSysFrameTxBroadcast() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameTxBroadcast).getValue();
  }

  public void setUtsPonIfExtSysFrameTxBroadcast(BigInteger aUtsPonIfExtSysFrameTxBroadcast) {
    getProperty(utsPonIfExtSysFrameTxBroadcast).setValue(aUtsPonIfExtSysFrameTxBroadcast);
  }

  public BigInteger getUtsPonIfExtSysFrameRxBroadcast() {
    return (BigInteger) getProperty(utsPonIfExtSysFrameRxBroadcast).getValue();
  }

  public void setUtsPonIfExtSysFrameRxBroadcast(BigInteger aUtsPonIfExtSysFrameRxBroadcast) {
    getProperty(utsPonIfExtSysFrameRxBroadcast).setValue(aUtsPonIfExtSysFrameRxBroadcast);
  }

  public BigInteger getUtsPonIfExtSysOctetTxOk() {
    return (BigInteger) getProperty(utsPonIfExtSysOctetTxOk).getValue();
  }

  public void setUtsPonIfExtSysOctetTxOk(BigInteger aUtsPonIfExtSysOctetTxOk) {
    getProperty(utsPonIfExtSysOctetTxOk).setValue(aUtsPonIfExtSysOctetTxOk);
  }

  public BigInteger getUtsPonIfExtSysOctetRxOk() {
    return (BigInteger) getProperty(utsPonIfExtSysOctetRxOk).getValue();
  }

  public void setUtsPonIfExtSysOctetRxOk(BigInteger aUtsPonIfExtSysOctetRxOk) {
    getProperty(utsPonIfExtSysOctetRxOk).setValue(aUtsPonIfExtSysOctetRxOk);
  }

  public BigInteger getUtsPonIfExtPonFrameTxOk() {
    return (BigInteger) getProperty(utsPonIfExtPonFrameTxOk).getValue();
  }

  public void setUtsPonIfExtPonFrameTxOk(BigInteger aUtsPonIfExtPonFrameTxOk) {
    getProperty(utsPonIfExtPonFrameTxOk).setValue(aUtsPonIfExtPonFrameTxOk);
  }

  public BigInteger getUtsPonIfExtPonFrameRxOk() {
    return (BigInteger) getProperty(utsPonIfExtPonFrameRxOk).getValue();
  }

  public void setUtsPonIfExtPonFrameRxOk(BigInteger aUtsPonIfExtPonFrameRxOk) {
    getProperty(utsPonIfExtPonFrameRxOk).setValue(aUtsPonIfExtPonFrameRxOk);
  }

  public BigInteger getUtsPonIfExtPonOctetTxOk() {
    return (BigInteger) getProperty(utsPonIfExtPonOctetTxOk).getValue();
  }

  public void setUtsPonIfExtPonOctetTxOk(BigInteger aUtsPonIfExtPonOctetTxOk) {
    getProperty(utsPonIfExtPonOctetTxOk).setValue(aUtsPonIfExtPonOctetTxOk);
  }

  public BigInteger getUtsPonIfExtPonOctetRxOk() {
    return (BigInteger) getProperty(utsPonIfExtPonOctetRxOk).getValue();
  }

  public void setUtsPonIfExtPonOctetRxOk(BigInteger aUtsPonIfExtPonOctetRxOk) {
    getProperty(utsPonIfExtPonOctetRxOk).setValue(aUtsPonIfExtPonOctetRxOk);
  }

  public BigInteger getUtsPonIfExtEponFrameRxReport() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameRxReport).getValue();
  }

  public void setUtsPonIfExtEponFrameRxReport(BigInteger aUtsPonIfExtEponFrameRxReport) {
    getProperty(utsPonIfExtEponFrameRxReport).setValue(aUtsPonIfExtEponFrameRxReport);
  }

  public BigInteger getUtsPonIfExtEponFrameTxReport() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameTxReport).getValue();
  }

  public void setUtsPonIfExtEponFrameTxReport(BigInteger aUtsPonIfExtEponFrameTxReport) {
    getProperty(utsPonIfExtEponFrameTxReport).setValue(aUtsPonIfExtEponFrameTxReport);
  }

  public BigInteger getUtsPonIfExtEponFrameRxGate() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameRxGate).getValue();
  }

  public void setUtsPonIfExtEponFrameRxGate(BigInteger aUtsPonIfExtEponFrameRxGate) {
    getProperty(utsPonIfExtEponFrameRxGate).setValue(aUtsPonIfExtEponFrameRxGate);
  }

  public BigInteger getUtsPonIfExtEponFrameTxGate() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameTxGate).getValue();
  }

  public void setUtsPonIfExtEponFrameTxGate(BigInteger aUtsPonIfExtEponFrameTxGate) {
    getProperty(utsPonIfExtEponFrameTxGate).setValue(aUtsPonIfExtEponFrameTxGate);
  }

  public BigInteger getUtsPonIfExtEponFrameRxRegReq() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameRxRegReq).getValue();
  }

  public void setUtsPonIfExtEponFrameRxRegReq(BigInteger aUtsPonIfExtEponFrameRxRegReq) {
    getProperty(utsPonIfExtEponFrameRxRegReq).setValue(aUtsPonIfExtEponFrameRxRegReq);
  }

  public BigInteger getUtsPonIfExtEponFrameTxRegReq() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameTxRegReq).getValue();
  }

  public void setUtsPonIfExtEponFrameTxRegReq(BigInteger aUtsPonIfExtEponFrameTxRegReq) {
    getProperty(utsPonIfExtEponFrameTxRegReq).setValue(aUtsPonIfExtEponFrameTxRegReq);
  }

  public BigInteger getUtsPonIfExtEponFrameRxReg() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameRxReg).getValue();
  }

  public void setUtsPonIfExtEponFrameRxReg(BigInteger aUtsPonIfExtEponFrameRxReg) {
    getProperty(utsPonIfExtEponFrameRxReg).setValue(aUtsPonIfExtEponFrameRxReg);
  }

  public BigInteger getUtsPonIfExtEponFrameTxReg() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameTxReg).getValue();
  }

  public void setUtsPonIfExtEponFrameTxReg(BigInteger aUtsPonIfExtEponFrameTxReg) {
    getProperty(utsPonIfExtEponFrameTxReg).setValue(aUtsPonIfExtEponFrameTxReg);
  }

  public BigInteger getUtsPonIfExtEponFrameRxRegAck() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameRxRegAck).getValue();
  }

  public void setUtsPonIfExtEponFrameRxRegAck(BigInteger aUtsPonIfExtEponFrameRxRegAck) {
    getProperty(utsPonIfExtEponFrameRxRegAck).setValue(aUtsPonIfExtEponFrameRxRegAck);
  }

  public BigInteger getUtsPonIfExtEponFrameTxRegAck() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameTxRegAck).getValue();
  }

  public void setUtsPonIfExtEponFrameTxRegAck(BigInteger aUtsPonIfExtEponFrameTxRegAck) {
    getProperty(utsPonIfExtEponFrameTxRegAck).setValue(aUtsPonIfExtEponFrameTxRegAck);
  }

  public BigInteger getUtsPonIfExtEponFrameCrc8Error() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameCrc8Error).getValue();
  }

  public void setUtsPonIfExtEponFrameCrc8Error(BigInteger aUtsPonIfExtEponFrameCrc8Error) {
    getProperty(utsPonIfExtEponFrameCrc8Error).setValue(aUtsPonIfExtEponFrameCrc8Error);
  }

  public BigInteger getUtsPonIfExtEponFrameSldError() {
    return (BigInteger) getProperty(utsPonIfExtEponFrameSldError).getValue();
  }

  public void setUtsPonIfExtEponFrameSldError(BigInteger aUtsPonIfExtEponFrameSldError) {
    getProperty(utsPonIfExtEponFrameSldError).setValue(aUtsPonIfExtEponFrameSldError);
  }

  public Integer getUtsPonIfExtStatPMStatus() {
    return (Integer) getProperty(utsPonIfExtStatPMStatus).getValue();
  }

  public void setUtsPonIfExtStatPMStatus(Integer aUtsPonIfExtStatPMStatus) {
    getProperty(utsPonIfExtStatPMStatus).setValue(aUtsPonIfExtStatPMStatus);
  }


  public boolean retrieve() throws MibBeanException {
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxOk));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxOk));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxErr));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxErr));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxUnicast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxUnicast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxMulticast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxMulticast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxBroadcast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxBroadcast));
    prepareRead(super.getProperty(utsPonIfExtSysOctetTxOk));
    prepareRead(super.getProperty(utsPonIfExtSysOctetRxOk));
    prepareRead(super.getProperty(utsPonIfExtPonFrameTxOk));
    prepareRead(super.getProperty(utsPonIfExtPonFrameRxOk));
    prepareRead(super.getProperty(utsPonIfExtPonOctetTxOk));
    prepareRead(super.getProperty(utsPonIfExtPonOctetRxOk));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxReport));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxReport));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxGate));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxGate));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxRegReq));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxRegReq));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxReg));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxReg));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxRegAck));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxRegAck));
    prepareRead(super.getProperty(utsPonIfExtEponFrameCrc8Error));
    prepareRead(super.getProperty(utsPonIfExtEponFrameSldError));
    prepareRead(super.getProperty(utsPonIfExtStatPMStatus));
    return load();
  }

  public Vector retrieveAll() throws MibBeanException {
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxOk));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxOk));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxErr));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxErr));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxUnicast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxUnicast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxMulticast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxMulticast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameTxBroadcast));
    prepareRead(super.getProperty(utsPonIfExtSysFrameRxBroadcast));
    prepareRead(super.getProperty(utsPonIfExtSysOctetTxOk));
    prepareRead(super.getProperty(utsPonIfExtSysOctetRxOk));
    prepareRead(super.getProperty(utsPonIfExtPonFrameTxOk));
    prepareRead(super.getProperty(utsPonIfExtPonFrameRxOk));
    prepareRead(super.getProperty(utsPonIfExtPonOctetTxOk));
    prepareRead(super.getProperty(utsPonIfExtPonOctetRxOk));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxReport));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxReport));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxGate));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxGate));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxRegReq));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxRegReq));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxReg));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxReg));
    prepareRead(super.getProperty(utsPonIfExtEponFrameRxRegAck));
    prepareRead(super.getProperty(utsPonIfExtEponFrameTxRegAck));
    prepareRead(super.getProperty(utsPonIfExtEponFrameCrc8Error));
    prepareRead(super.getProperty(utsPonIfExtEponFrameSldError));
    prepareRead(super.getProperty(utsPonIfExtStatPMStatus));

    Vector v = loadAll(new int[]{1, 1, 1, 1});

    int i = 0;
    while(i < v.size()) {
      OltIf2ExtStatTable bean = (OltIf2ExtStatTable)v.get(i);
      if(bean.getUtsPonIf2ExtStatLogicalLinkId().intValue() != 0) {
        v.remove(i);
      } else {
        i++;
      }
    }
    return v;
  }

  public boolean modify() throws MibBeanException {
    prepareSave(getProperty(utsPonIfExtStatPMStatus));

    return save();
  }

  public boolean delete()throws MibBeanException{
    Integer onu = getUtsPonIf2ExtStatLogicalLinkId();
    PerfStaOperGroup mbean = new PerfStaOperGroup(fSnmpProxy);
    //check if it is OLT Port
    if(onu != null && onu.intValue() == 0)
    {
      mbean.setUtsPerfStaClearAll(new Integer(4));
    }
    else//ONU Port
    {
      mbean.setUtsPerfStaClearAll(new Integer(5));
    }
    
    mbean.modify();
    return true;
  }

}
