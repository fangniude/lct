package com.winnertel.ems.epon.iad.bbs4000.checker;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

public class DeleteSuperSVIChecker extends BaseChecker
{
	IApplication fApplication;
	public DeleteSuperSVIChecker( IApplication app )
	{
		super( app );
		this.fApplication = app;
	}
	
	public boolean doCheck(SnmpMibBean[] data, SnmpMibBean[] selectedMibBeans)
	{
//		HostRouteTable host = new HostRouteTable( fApplication.getSnmpProxy() );
//		try
//		{
//			Vector hostVec = host.retrieveAll();
//			if( hostVec == null )
//			{
//				return true;
//			}
//
//			SuperSVITable select = ( SuperSVITable )selectedMibBeans[0];
//			for( int i=0; i<hostVec.size(); i++ )
//			{
//				HostRouteTable record = ( HostRouteTable )hostVec.get( i );
//
//				if( select.getUtsIntfSuperSVIVlanId().equals( record.getUtsHostRouteVlanId() ) )
//				{
//					MessageDialog.showInfoMessageDialog( fApplication, "Delete Error. Super SVI already used in HostRoute Table." );
//					return false;
//				}
//			}
//		} catch (MibBeanException e)
//		{
//			e.printStackTrace();
//		}
		return true;
		
	}
}
