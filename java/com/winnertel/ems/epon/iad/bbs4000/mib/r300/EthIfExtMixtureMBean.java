package com.winnertel.ems.epon.iad.bbs4000.mib.r300;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SecondIPAddressTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

import java.util.Vector;

public class EthIfExtMixtureMBean extends SnmpMibBean {

	EthIfExtTable ethIfExtTable;
	SecondIPAddressTable secondIPAddressTable;
	SuperSVITable superSVITable;

	boolean hasSVI = false;
	boolean hasSencondIP = false;

	ISnmpProxy snmpProxy;

	public EthIfExtMixtureMBean(ISnmpProxy _snmpProxy) {
		super(_snmpProxy);
		snmpProxy = _snmpProxy;
		ethIfExtTable = new EthIfExtTable(snmpProxy);
		secondIPAddressTable = new SecondIPAddressTable(snmpProxy);
		superSVITable = new SuperSVITable(snmpProxy);
	}

	@Override
	protected void init() {
	}

	// EthIfExtTable
	public Integer getIfIndex() {
		return ethIfExtTable.getIfIndex();
	}

	public void setIfIndex(Integer aIfIndex) {
		ethIfExtTable.setIndex(0, aIfIndex);
	}

	public Integer getUtsEthIfExtModuleId() {
		return ethIfExtTable.getUtsEthIfExtModuleId();
		// return (Integer) getProperty(utsEthIfExtModuleId).getValue();
	}

	public void setUtsEthIfExtModuleId(Integer aUtsEthIfExtModuleId) {
		// getProperty(utsEthIfExtModuleId).setValue(aUtsEthIfExtModuleId);
		ethIfExtTable.setUtsEthIfExtModuleId(aUtsEthIfExtModuleId);
	}

	public Integer getUtsEthIfExtPortId() {
		// return (Integer) getProperty(utsEthIfExtPortId).getValue();
		return ethIfExtTable.getUtsEthIfExtPortId();
	}

	public void setUtsEthIfExtPortId(Integer aUtsEthIfExtPortId) {
		// getProperty(utsEthIfExtPortId).setValue(aUtsEthIfExtPortId);
		ethIfExtTable.setUtsEthIfExtPortId(aUtsEthIfExtPortId);
	}

	public Integer getUtsEthIfExtLinkAggGroupId() {
		// return (Integer) getProperty(utsEthIfExtLinkAggGroupId).getValue();
		return ethIfExtTable.getUtsEthIfExtLinkAggGroupId();
	}

	public void setUtsEthIfExtLinkAggGroupId(Integer aUtsEthIfExtLinkAggGroupId) {
		// getProperty(utsEthIfExtLinkAggGroupId).setValue(
		// aUtsEthIfExtLinkAggGroupId);
		ethIfExtTable.setUtsEthIfExtLinkAggGroupId(aUtsEthIfExtLinkAggGroupId);
	}

	public Integer getUtsEthIfExtLoopbackPortId() {
		// return (Integer) getProperty(utsEthIfExtLoopbackPortId).getValue();
		return ethIfExtTable.getUtsEthIfExtPortId();
	}

	public void setUtsEthIfExtLoopbackPortId(Integer aUtsEthIfExtLoopbackPortId) {
		// getProperty(utsEthIfExtLoopbackPortId).setValue(
		// aUtsEthIfExtLoopbackPortId);
		ethIfExtTable.setUtsEthIfExtLoopbackPortId(aUtsEthIfExtLoopbackPortId);
	}

	public Integer getUtsEthIfExtVlanId() {
		// return (Integer) getProperty(utsEthIfExtVlanId).getValue();
		return ethIfExtTable.getUtsEthIfExtVlanId();
	}

	public void setUtsEthIfExtVlanId(Integer aUtsEthIfExtVlanId) {
		// getProperty(utsEthIfExtVlanId).setValue(aUtsEthIfExtVlanId);
		ethIfExtTable.setUtsEthIfExtVlanId(aUtsEthIfExtVlanId);
	}

	public Integer getUtsEthIfExtPortType() {
		// return (Integer) getProperty(utsEthIfExtPortType).getValue();
		return ethIfExtTable.getUtsEthIfExtPortType();
	}

	public void setUtsEthIfExtPortType(Integer aUtsEthIfExtPortType) {
		// getProperty(utsEthIfExtPortType).setValue(aUtsEthIfExtPortType);
		ethIfExtTable.setUtsEthIfExtPortType(aUtsEthIfExtPortType);
	}

	public String getUtsEthIfExtIpAddress() {
		// return (String) getProperty(utsEthIfExtIpAddress).getValue();
		return ethIfExtTable.getUtsEthIfExtIpAddress();
	}

	public void setUtsEthIfExtIpAddress(String aUtsEthIfExtIpAddress) {
		// getProperty(utsEthIfExtIpAddress).setValue(aUtsEthIfExtIpAddress);
		ethIfExtTable.setUtsEthIfExtIpAddress(aUtsEthIfExtIpAddress);
	}

	public String getUtsEthIfExtIpNetmask() {
		// return (String) getProperty(utsEthIfExtIpNetmask).getValue();
		return ethIfExtTable.getUtsEthIfExtIpNetmask();
	}

	public void setUtsEthIfExtIpNetmask(String aUtsEthIfExtIpNetmask) {
		// getProperty(utsEthIfExtIpNetmask).setValue(aUtsEthIfExtIpNetmask);
		ethIfExtTable.setUtsEthIfExtIpNetmask(aUtsEthIfExtIpNetmask);
	}

	public Integer getUtsEthIfExtSwitchMode() {
		// return (Integer) getProperty(utsEthIfExtSwitchMode).getValue();
		return ethIfExtTable.getUtsEthIfExtSwitchMode();
	}

	public void setUtsEthIfExtSwitchMode(Integer aUtsEthIfExtSwitchMode) {
		// getProperty(utsEthIfExtSwitchMode).setValue(aUtsEthIfExtSwitchMode);
		ethIfExtTable.setUtsEthIfExtSwitchMode(aUtsEthIfExtSwitchMode);
	}

	public Integer getUtsEthIfExtAdminStatus() {
		// return (Integer) getProperty(utsEthIfExtAdminStatus).getValue();
		return ethIfExtTable.getUtsEthIfExtAdminStatus();
	}

	public void setUtsEthIfExtAdminStatus(Integer aUtsEthIfExtAdminStatus) {
		// getProperty(utsEthIfExtAdminStatus).setValue(aUtsEthIfExtAdminStatus);
		ethIfExtTable.setUtsEthIfExtAdminStatus(aUtsEthIfExtAdminStatus);
	}

	public Integer getUtsEthIfExtIfIndex() {
		// return (Integer) getProperty(utsEthIfExtIfIndex).getValue();
		return ethIfExtTable.getUtsEthIfExtIfIndex();
	}

	public void setUtsEthIfExtIfIndex(Integer aUtsEthIfExtIfIndex) {
		// getProperty(utsEthIfExtIfIndex).setValue(aUtsEthIfExtIfIndex);
		ethIfExtTable.setUtsEthIfExtIfIndex(aUtsEthIfExtIfIndex);
	}

	// SecondIPAddressTable
	public Integer getUtsIfSecondIpIfIndex() {
		return (Integer) secondIPAddressTable.getIndex(0);
	}

	public void setUtsIfSecondIpIfIndex(Integer aUtsIfSecondIpIfIndex) {
		secondIPAddressTable.setIndex(0, aUtsIfSecondIpIfIndex);
	}

	public String getUtsIfSecondIpAddress() {
		return (String) secondIPAddressTable.getIndex(1);
	}

	public void setUtsIfSecondIpAddress(String aUtsIfSecondIpAddress) {
		secondIPAddressTable.setIndex(1, aUtsIfSecondIpAddress);
	}

	public String getUtsIfSecondIpNetmask() {
		return (String) secondIPAddressTable.getIndex(2);
	}

	public void setUtsIfSecondIpNetmask(String aUtsIfSecondIpNetmask) {
		secondIPAddressTable.setIndex(2, aUtsIfSecondIpNetmask);
	}

	// SuperSVITable

	public Integer getHasSuperSVI() {
		return isHasSVI() ? new Integer(1) : new Integer(2);
	}

	public void setHasSuperSVI(Integer hasSVI) {
	}

	public Integer getUtsIntfSuperSVIVlanId() {
		return (Integer) superSVITable.getIndex(0);
	}

	public void setUtsIntfSuperSVIVlanId(Integer aUtsIntfSuperSVIVlanId) {
		superSVITable.setIndex(0, aUtsIntfSuperSVIVlanId);
	}

	public byte[] getUtsIntfSuperSVIVlanMemberBitmap() {
		return superSVITable.getUtsIntfSuperSVIVlanMemberBitmap();
		// return (byte[])
		// getProperty(utsIntfSuperSVIVlanMemberBitmap).getValue();
	}

	public void setUtsIntfSuperSVIVlanMemberBitmap(
			byte[] aUtsIntfSuperSVIVlanMemberBitmap) {
		superSVITable
				.setUtsIntfSuperSVIVlanMemberBitmap(aUtsIntfSuperSVIVlanMemberBitmap);
		// getProperty(utsIntfSuperSVIVlanMemberBitmap).setValue(
		// aUtsIntfSuperSVIVlanMemberBitmap);
	}

	public boolean retrieve() throws MibBeanException {
		boolean bEthifExt = ethIfExtTable.retrieve();
		boolean bSencondIPAddress = secondIPAddressTable.retrieve();
		boolean bSuperSVI = superSVITable.retrieve();

		return bEthifExt && bSencondIPAddress && bSuperSVI;
	}

	@SuppressWarnings("unchecked")
	public Vector retrieveAll() throws MibBeanException {
		Vector<EthIfExtTable> vEthIfExt = ethIfExtTable.retrieveAll();
		Vector<SecondIPAddressTable> vSendcondIPAddress = secondIPAddressTable
				.retrieveAll();
		Vector<SuperSVITable> vSuperSVI = superSVITable.retrieveAll();

		Vector<EthIfExtMixtureMBean> vMixtureMbean = new Vector<EthIfExtMixtureMBean>();

		for (int i = 0; i < vEthIfExt.size(); i++) {
			EthIfExtMixtureMBean mixtureMBean = new EthIfExtMixtureMBean(
					snmpProxy);

			EthIfExtTable ethIfExt = vEthIfExt.get(i);
			mixtureMBean.ethIfExtTable = ethIfExt;

			Integer ifIndex = ethIfExt.getIfIndex();

			for (int j = 0; j < vSendcondIPAddress.size(); j++) {
				SecondIPAddressTable secondIP = vSendcondIPAddress.get(j);
				if (ifIndex.equals(secondIP.getUtsIfSecondIpIfIndex())) {
					mixtureMBean.setHasSencondIP(true);
					mixtureMBean.secondIPAddressTable = secondIP;
					break;
				}
			}

			for (int k = 0; k < vSuperSVI.size(); k++) {
				SuperSVITable superSVI = vSuperSVI.get(k);
				String s = ConfigUtility.formatIfIndex(ifIndex);
				if (s.equals("vlan" + superSVI.getUtsIntfSuperSVIVlanId())) {
					mixtureMBean.setHasSVI(true);
					mixtureMBean.superSVITable = superSVI;
					break;
				}
			}

			vMixtureMbean.add(mixtureMBean);
		}

		return vMixtureMbean;
	}

	public boolean modify() throws MibBeanException {
		boolean b1 = true;
		boolean b2 = true;
		boolean b3 = true;

		b1 = ethIfExtTable.modify();

//		if ( isHasSencondIP()) {
//			b2 = secondIPAddressTable.add();
//		} 
		
//		try {
//			b3 = superSVITable.delete();
//		} catch ( Exception ex ) {
//		}
//		
//		if (b3 && isHasSVI()) {
//			b3 = superSVITable.add();
//		} 

		return b1 && b2 && b3;
	}
	
	public boolean deleteOldSecondIP( ) throws MibBeanException {
		return secondIPAddressTable.delete();
	}
	
	public boolean addNewSecondIP( ) throws MibBeanException {
		return secondIPAddressTable.add();
	}

	public boolean deleteOldSVI( ) throws MibBeanException {
		return superSVITable.delete();
	}
	
	public boolean addNewSVI( ) throws MibBeanException {
		return superSVITable.add();
	}
	
	public boolean delete() throws MibBeanException {
		boolean b1 = true;
		boolean b2 = true;
		boolean b3 = true;

		if (isHasSencondIP()) {
			b2 = secondIPAddressTable.delete();
		}

		if (isHasSVI()) {
			b3 = superSVITable.delete();
		}

		b1 = ethIfExtTable.delete();

		return b1 && b2 && b3;
	}

	public boolean add() throws MibBeanException {
		boolean b1 = true;
		boolean b2 = true;
		boolean b3 = true;

		b1 = ethIfExtTable.add();

		if (isHasSencondIP()) {
			b2 = secondIPAddressTable.add();
		}

		if (isHasSVI()) {
			b3 = superSVITable.add();
		}

		return b1 && b2 && b3;
	}

	public boolean isHasSVI() {
		return hasSVI;
	}

	public void setHasSVI(boolean hasSVI) {
		this.hasSVI = hasSVI;
	}

	public boolean isHasSencondIP() {
		return hasSencondIP;
	}

	public void setHasSencondIP(boolean hasSencondIP) {
		this.hasSencondIP = hasSencondIP;
	}

}
