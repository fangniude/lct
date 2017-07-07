package com.winnertel.ems.epon.iad.bbs4000.gui.specialpanel;

import com.winnertel.ems.epon.iad.bbs4000.mib.SuperSVITable;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;

import java.util.Vector;

public class SuperVlanInterface
{
	private String vlanId;
	private byte[] vlanMember;
	
	public static SuperVlanInterface[] getSuperVlanInterface( ISnmpProxy aSnmpProxy )
	{
		SuperVlanInterface[] vlanInterface = null;
		SuperSVITable vlan = new SuperSVITable( aSnmpProxy );
		SuperSVITable[] vlanData = null;
		try
		{
			Vector superVlanVector = vlan.retrieveAll();
			if( superVlanVector == null )
			{
				superVlanVector = new Vector();
			}
			vlanData = new SuperSVITable[superVlanVector.size()];
			for( int i=0; i<vlanData.length; i++ )
			{
				vlanData[i] = (SuperSVITable)superVlanVector.get( i );
			}
			vlanInterface = new SuperVlanInterface[superVlanVector.size()];
			for( int i=0; i<vlanInterface.length; i++ )
			{
				vlanInterface[i] =  new SuperVlanInterface();
				
				vlanInterface[i].setVlanId( vlanData[i].getUtsIntfSuperSVIVlanId().toString() );
				vlanInterface[i].setVlanMember( vlanData[i].getUtsIntfSuperSVIVlanMemberBitmap() );
			}
		} catch (MibBeanException e)
		{
			e.printStackTrace();
		}
		return vlanInterface;	
	}

	public String getVlanId()
	{
		return vlanId;
	}

	public void setVlanId(String vlanId)
	{
		this.vlanId = vlanId;
	}

	public byte[] getVlanMember()
	{
		return vlanMember;
	}

	public void setVlanMember(byte[] vlanMember)
	{
		this.vlanMember = vlanMember;
	}
	
	
}
