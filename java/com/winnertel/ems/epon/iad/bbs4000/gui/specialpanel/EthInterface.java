package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.bbs4000.mib.EthIfExtTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.SecondIPAddressTable;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;

import java.util.Vector;

public class EthInterface 
{
	public static final int PORT = 1;
	public static final int LAG_PORT = 2;
	public static final int VLAN_PORT = 4;
	public static final int SUPER_VLAN_PORT = 5;
	
	public static final int layer2 = 1;
	public static final int layer3 = 2;

	private String ipAddress;
	private String mask;
	private Integer portType;
	private String interfaceID;
	private int switchMode;
	private int adminStatus;
	
	/**
	 * this method load data for EthIfExt table and IfSeconfdIp table
	 * so the ArpTableModel can use the return value as one data structure.
	 * 
	 * @return
	 */
	public static EthInterface[] getInterface( ISnmpProxy aSnmpProxy )
	{
		EthInterface[] result = new EthInterface[0];
		
		try
		{
			EthIfExtTable ethIf = new EthIfExtTable( aSnmpProxy );
			Vector ethIfVector = ethIf.retrieveRealAll();
			if( ethIfVector == null )
			{
				ethIfVector = new Vector();
			}
			EthIfExtTable[] ethIfData = new EthIfExtTable[ethIfVector.size()];
			
			for( int i=0; i<ethIfVector.size(); i++ )
			{
				ethIfData[i] = (EthIfExtTable)ethIfVector.get( i );
				
			}
			
			SecondIPAddressTable secondIp = new SecondIPAddressTable( aSnmpProxy );
			Vector secondVector = secondIp.retrieveAll();
			if( secondVector == null )
			{
				secondVector = new Vector();
			}
			
			SecondIPAddressTable[] secondData = new SecondIPAddressTable[secondVector.size()];
			
			for( int i=0; i<secondVector.size(); i++ )
			{
				secondData[i] = (SecondIPAddressTable)secondVector.get( i ); 
			}
			
			result = new EthInterface[ethIfData.length + secondData.length];
			
			for( int i=0; i<ethIfData.length; i++ )
			{
				result[i] = new EthInterface();
				result[i].setInterfaceID( ethIfData[i].getIfIndex().toString() );
				result[i].setIpAddress( ethIfData[i].getUtsEthIfExtIpAddress() );
				result[i].setMask( ethIfData[i].getUtsEthIfExtIpNetmask() );
				result[i].setPortType( ethIfData[i].getUtsEthIfExtPortType() );
				result[i].setSwitchMode( ethIfData[i].getUtsEthIfExtSwitchMode().intValue() );
				result[i].setAdminStatus( ethIfData[i].getUtsEthIfExtAdminStatus().intValue() );	
			}
			
			int length = ethIfData.length;
			for( int i=ethIfData.length; i<result.length; i++ )
			{
				
				Integer interfaceId = secondData[i-length].getUtsIfSecondIpIfIndex();
				
				for( int j=0; j<ethIfData.length; j++ )
				{
					if( interfaceId.equals( ethIfData[j].getIfIndex()))
					{
						result[i] = new EthInterface();
						
						result[i].setInterfaceID( result[j].getInterfaceIDNum() );
						result[i].setPortType( result[j].getPortType() );
						result[i].setSwitchMode( result[j].getSwitchMode() );
						result[i].setAdminStatus( result[j].getAdminStatus() );
						
						result[i].setIpAddress( secondData[i-length].getUtsIfSecondIpAddress() );
						result[i].setMask( secondData[i-length].getUtsIfSecondIpNetmask() );
					}
				}
			}
			
		} catch (MibBeanException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public static EthInterface[] getEthInterface( ISnmpProxy aSnmpProxy )
	{
		EthInterface[] result = new EthInterface[0];
		
		try
		{
			EthIfExtTable ethIf = new EthIfExtTable( aSnmpProxy );
			Vector ethIfVector = ethIf.retrieveRealAll();
			if( ethIfVector == null )
			{
				ethIfVector = new Vector();
			}
			EthIfExtTable[] ethIfData = new EthIfExtTable[ethIfVector.size()];
			
			for( int i=0; i<ethIfVector.size(); i++ )
			{
				ethIfData[i] = (EthIfExtTable)ethIfVector.get( i );
				
			}
			
			result = new EthInterface[ethIfData.length];
			
			for( int i=0; i<ethIfData.length; i++ )
			{
				result[i] = new EthInterface();
				result[i].setInterfaceID( ethIfData[i].getIfIndex().toString() );
				result[i].setIpAddress( ethIfData[i].getUtsEthIfExtIpAddress() );
				result[i].setMask( ethIfData[i].getUtsEthIfExtIpNetmask() );
				result[i].setPortType( ethIfData[i].getUtsEthIfExtPortType() );
				result[i].setSwitchMode( ethIfData[i].getUtsEthIfExtSwitchMode().intValue() );
				result[i].setAdminStatus( ethIfData[i].getUtsEthIfExtAdminStatus().intValue() );	
			}
			
		} catch (MibBeanException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public int getAdminStatus()
	{
		return adminStatus;
	}

	public void setAdminStatus(int adminStatus)
	{
		this.adminStatus = adminStatus;
	}

	public String getInterfaceID()
	{
		return ConfigUtility.formatIfIndex( interfaceID );
	}
	
	public String getInterfaceIDNum()
	{
		return interfaceID;
	}

	public void setInterfaceID(String interfaceID)
	{
		this.interfaceID = interfaceID;
	}

	public String getIpAddress()
	{
		return ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	public String getMask()
	{
		return mask;
	}

	public void setMask(String mask)
	{
		this.mask = mask;
	}

	public Integer getPortType()
	{
		return portType;
	}

	public void setPortType(Integer portType)
	{
		this.portType = portType;
	}

	public int getSwitchMode()
	{
		return switchMode;
	}

	public void setSwitchMode(int switchMode)
	{
		this.switchMode = switchMode;
	}

  public String toString()
  {
    StringBuffer sb = new StringBuffer(ConfigUtility.formatIfIndex(interfaceID));

    if(ipAddress != null)
    {
      sb.append("[").append(ipAddress).append("/").append(mask).append("]");
    }

    return sb.toString();
  }
}