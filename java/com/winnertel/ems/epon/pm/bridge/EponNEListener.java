package com.winnertel.ems.epon.pm.bridge;

import com.winnertel.ems.epon.pm.impl.EponTCAJobImpl;
import com.winnertel.common.notification.UNotificationEvent;
import com.winnertel.common.notification.UNotificationFilter;
import com.winnertel.common.notification.UNotificationTypeDef;
import com.winnertel.common.notification.nc.UNotificationClient;
import com.winnertel.common.notification.nc.UNotificationClientListener;
import com.winnertel.ems.epon.topo.impl.PropertyConstant;
import com.winnertel.inms.upm.common.job.entities.MeasurementObject;
import com.winnertel.inms.upm.common.job.interfaces.JobInformRemoteIntf;
import com.winnertel.nms.lite.momodel.ManagedElement;
import com.winnertel.nms.lite.topo.TopoAPI;
import com.winnertel.nms.lite.util.APIUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EponNEListener implements UNotificationClientListener//ULTopoActionListener
{
  private EponTCAJobImpl tcaImpl = new EponTCAJobImpl();
  private HashMap lsnrMap = new HashMap();

  public EponNEListener()
  {
    this.registerToTopo();
  }

  public long regiester(JobInformRemoteIntf lstener)
  {
    Long id = new Long(lstener.hashCode());
    lsnrMap.put(id, lstener);
    return id.longValue();
  }

  public boolean deregister(long id)
  {
    Long ID = new Long(id);
    lsnrMap.remove(ID);
    return true;
  }

  /**
   * implemente the method of UNotificationClientListener listener
   *
   * @param event UNotificationEvent event
   */
  public void processNotification(UNotificationEvent event)
  {
    if(event.getEventType() == UNotificationTypeDef.TOPO_MIX_ACTION)
    {
      // process all events in mix event
      List events = (List)event.getObj();
      for(int i = 0; i < events.size(); i++)
      {
        UNotificationEvent e = (UNotificationEvent)events.get(i);
        processEvent(e);
      }
    }
    else
    {
      processEvent(event);
    }
  }

  /**
   * process the single UNotificationEvent whose obj is a String really.
   * @param event
   */
  void processEvent(UNotificationEvent event)
  {
    try
    {
      ManagedElement ne = null;
      Object obj = event.getObj();
      if(obj instanceof String)
      {
        String dn = (String)event.getObj();
        TopoAPI topoApi = APIUtil.getTopoAPI();
        Object mo = topoApi.getMOByDN(dn);

        //
        if(!(mo instanceof ManagedElement)) return;

        ne = (ManagedElement)topoApi.getMOByDN(dn);
      }
      else if(obj instanceof ManagedElement)
      {
        ne = (ManagedElement)obj;
      }
      else
      {
        //not interest in others event, such as NEStatus.
        return;
      }

      String neType = ne.getType();
      if(neType != null && (neType.startsWith("BBS") || neType.startsWith("ONU")))
      {
        if(event.getOpType() == UNotificationTypeDef.TOPO_ADD)
        {
          notifyUpm(ne, JobInformRemoteIntf.JOB_SYNC_DISCOVERY);
        }
        else if(event.getOpType() == UNotificationTypeDef.TOPO_DELETE)
        {
          notifyUpm(ne, JobInformRemoteIntf.JOB_SYNC_DELETED);

          //notify tca to delete the job list.
          tcaImpl.deleteAllTCAJobForNe(ne.getType(), ne.getMOName(), ne.getSwVersion());
        }
        else if(event.getOpType() == UNotificationTypeDef.TOPO_MODIFY)
        {
          notifyUpm(ne, JobInformRemoteIntf.JOB_SYNC_UPDATE);
        }
        else if(event.getOpType() == UNotificationTypeDef.TOPO_MAINTENANCESTATUS)
        {
          if(ne.getMaintenanceState() == ManagedElement.MAINTENANCE)
          {
            notifyUpm(ne, JobInformRemoteIntf.JOB_SYNC_DISCOVERY);
          }
          else
          {
            notifyUpm(ne, JobInformRemoteIntf.JOB_SYNC_DELETED);

            //notify tca to delete the job list.
            tcaImpl.deleteAllTCAJobForNe(ne.getType(), ne.getMOName(), ne.getSwVersion());
          }
        }
        else if(event.getOpType() == UNotificationTypeDef.TOPO_STATUSCHANGE)
        {
          if(ne.getUsageState() == ManagedElement.USAGE_REACHABLE)
          {
            notifyUpm(ne, JobInformRemoteIntf.JOB_SYNC_RECONNECTIOIN);
          }
          else
          {
            notifyUpm(ne, JobInformRemoteIntf.JOB_SYNC_DISCONNECTION);
          }
        }
      }
      else
      {
      }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }

  void notifyUpm(ManagedElement ne, int opt)
  {
    String neName = ne.getMOName();
    String neType = ne.getType();
    String neVersion = ne.getSwVersion();

    MeasurementObject mo = new MeasurementObject(null, neName, MeasurementObject.Node_Type);
    HashMap moProp = new HashMap();
    moProp.put(MeasurementObject.Extend_Node_Type, neType);
    moProp.put(MeasurementObject.Extend_Node_Version, neVersion);
    if(ne.getUsageState() == ManagedElement.USAGE_REACHABLE)
    {
      moProp.put(MeasurementObject.Extend_Node_State, MeasurementObject.Extend_Node_State_Normal);
    }
    else
    {
      moProp.put(MeasurementObject.Extend_Node_State, MeasurementObject.Extend_Node_State_AbNormal);
    }
    moProp.put(PropertyConstant.NE_IP_ADDRESS, ne.getIpAddress());
    moProp.put(PropertyConstant.NE_SNMP_PORT, ""+ne.getSnmpPort());
    moProp.put(PropertyConstant.NE_GET_COMMUNITY, ne.getReadCommunity());
    moProp.put(PropertyConstant.NE_WRITE_COMMUNITY, ne.getWriteCommunity());

    mo.setExtendInfo(moProp);

    fireListeners(mo, opt);
  }

  void fireListeners(MeasurementObject mo, int type)
  {
    try
    {
      Iterator it = this.lsnrMap.keySet().iterator();
      while(it.hasNext())
      {
        Long id = (Long)it.next();
        JobInformRemoteIntf lsnr = (JobInformRemoteIntf)this.lsnrMap.get(id);
        lsnr.synchronizeMeasurementObject(mo, type);
      }
    }
    catch(Throwable e)
    {

        e.printStackTrace();
    }
  }

  private void registerToTopo()
  {
    try
    {
      //register to local NS and receive topo events
      UNotificationClient nsc = new UNotificationClient("#localhost", new UNotificationFilter(UNotificationTypeDef.TOPO, UNotificationTypeDef.TOPO_MIX_ACTION), true);
      nsc.register(this, null);
    }
    catch(Exception e)
    {
      e.printStackTrace();

    }
  }
}
