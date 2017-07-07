package com.winnertel.ems.epon.inventory;

import java.io.Serializable;

public class UnboundOnuMOD implements Serializable {
  private String llId = "";
  private String cardId = "";
  private String portId = "";
  private String macAddress = "";
  private String neName = "";
  private String neLabel = "";
  


  public UnboundOnuMOD() {
  }

  public UnboundOnuMOD(String id) {
    setLlId(id);
  }

  public String getNeLabel() {
		return neLabel;
  }

  public void setNeLabel(String neLabel) {
	  this.neLabel = neLabel;
  }
  public String getLlId() {
    return llId;
  }

  public String getMacAddress() {
    return macAddress;
  }

  public String getCardId() {
    return cardId;
  }

  public String getPortId() {
    return portId;
  }

  public void setLlId(String id) {
    this.llId = id;
  }

  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public void setPortId(String portId) {
    this.portId = portId;
  }

  public String getNeName() {
    return neName;
  }

  public void setNeName(String neName) {
    this.neName = neName;
  }
}