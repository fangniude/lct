package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;


public class PortInfo
{
	private String interfaceId;
	private Integer card;
	private Integer port;
	private Integer lg;
	private Integer vlan;
	private Integer subVlan;
	
	public void setInterfaceId(String interfaceValue)
	{
//		this.interfaceId = ConfigUtility.formatIfIndex( interfaceValue );
		interfaceId = interfaceValue;
		if( interfaceId.indexOf( "/" ) != -1 )
		{
			String[] interfaceArr = interfaceId.split( "/" );
			card = new Integer( interfaceArr[0] );
			port = new Integer( interfaceArr[1] );
		}
		else
		if( interfaceId.indexOf( "lg" ) != -1)
		{
			lg = new Integer( interfaceId.substring( 2 ) );
		}
		else
		if( interfaceId.indexOf( "vlan" ) != -1 )
		{
			vlan = new Integer( interfaceId.substring( 4 ) );
		}
	}
	
	public void setVlan( Integer vlan )
	{
		if( vlan == null )
		{
			this.vlan = vlan;
		}
		else
		{
			this.subVlan = this.vlan;
			this.vlan = vlan;
		}
	}

	public Integer getCard()
	{
		return card;
	}

	public Integer getLg()
	{
		return lg;
	}

	public Integer getPort()
	{
		return port;
	}

	public Integer getSubVlan()
	{
		return subVlan;
	}

	public Integer getVlan()
	{
		return vlan;
	}
	
	public String toString()
	{
		return interfaceId;
	}
	
}
