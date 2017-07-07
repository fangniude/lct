package com.winnertel.ems.epon.pm.bridge;

import com.winnertel.inms.upm.common.job.interfaces.JobInformRemoteIntf;
import com.winnertel.inms.upm.common.nbi.intf.DnManipulationRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.CollectionScheduleRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.GroupCombMemberGetRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.IndexInstanceGetRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.JobScheduleRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.OMCPMMainRemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.OMCTCARemoteIntf;
import com.winnertel.inms.upm.common.omcinterface.TopoInfoGetRemoteIntf;
import com.winnertel.inms.upm.common.util.PmException;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class OMCPMMainRemoteImpl extends UnicastRemoteObject implements
    OMCPMMainRemoteIntf
{
  private EponNEListener eponNeListener = new EponNEListener();
  private static OMCPMMainRemoteImpl thisInstance = null;
  private DnManipulationRemoteIntf dnManipulationRemoteIntf = null;
  private OMCTCARemoteIntf tcaRemoteIntf = null;
  private TopoInfoGetRemoteIntf topoInfoIntf = null;

//private CollectionScheduleRemoteIntf collectionScheduleRemoteIntf = null;
//private GroupCombMemberGetRemoteIntf groupCombMemberGetRemoteIntf = null;
//private IndexInstanceGetRemoteIntf indexInstanceIntf = null;
//private JobScheduleRemoteIntf jobScheduleRemoteIntf = null;

  private OMCPMMainRemoteImpl() throws RemoteException
  {
    dnManipulationRemoteIntf = new DnManipulationRemoteImpl();
    tcaRemoteIntf = new OMCTCARemoteImpl();
    topoInfoIntf = new TopoInfoGetRemoteImpl();

//    collectionScheduleRemoteIntf = new CollectionScheduleRemoteImpl();
//    groupCombMemberGetRemoteIntf = new GroupCombMemberGetRemoteImpl();
//    indexInstanceIntf = new IndexInstanceGetRemoteImpl();
//    jobScheduleRemoteIntf = new JobScheduleRemoteImpl();
  }

  /**
   * 
   * @return OMCPMMainRemoteImpl
   */
  public static synchronized OMCPMMainRemoteImpl getInstance()
  {
    if(thisInstance == null)
    {
      try
      {
        thisInstance = new OMCPMMainRemoteImpl();
      }
      catch (Exception e)
      {
        e.printStackTrace();
        System.err.println("Construct OMCPMMainRemoteImpl Exception:" + e.getMessage());
      }
    }
    return thisInstance;
  }

  /**
   * NMS will call this method to register JobInformRemoteIntf to OMC module, by
   * which NMS can receive the call from OMC.
   * 
   * @param pmListener
   *          JobInformRemoteIntf. It will be implemented by NMS to receive
   *          OMCs' call.
   * 
   * @return long . The key for the JobInformRemoteIntf. If fail to register, -1
   *         will be returned
   * @throws java.rmi.RemoteException
   * @throws com.winnertel.inms.upm.common.util.PmException
   *           The common exception defined by NMS-PM module
   */
  public long register(JobInformRemoteIntf pmListener) throws RemoteException,
      PmException
  {
    return this.eponNeListener.regiester(pmListener);
  }

  /**
   * NMS calls this method to deregister JobInformRemoteIntf by key from OMC
   * 
   * @param key
   *          The key is the return value of register method.
   * @throws java.rmi.RemoteException
   * @throws PmException
   * @return boolean
   */
  public boolean deregister(long key) throws RemoteException, PmException
  {
    return this.eponNeListener.deregister(key);
  }

  /**
   * according to NEType name, get TopoInfoGetRemoteIntf interface of this OMC
   * 
   * @return TopoInfoGetRemoteIntf
   * @throws java.rmi.RemoteException
   * @throws com.winnertel.inms.upm.common.util.PmException
   */
  public TopoInfoGetRemoteIntf getTopoInfoGetIntf() throws RemoteException,
      PmException
  {
    return this.topoInfoIntf;
  }

  /**
   * get GroupCombMemberGetRemoteIntf of this OMC
   * 
   * @return GroupCombMemberGetRemoteIntf
   * @throws java.rmi.RemoteException
   * @throws com.winnertel.inms.upm.common.util.PmException
   */
  public GroupCombMemberGetRemoteIntf getGroupCombMemberGetIntf()
      throws RemoteException
  {
    // return this.groupCombMemberGetRemoteIntf;
    return null;
  }

  /**
   * get IndexInstanceGetRemoteIntf of this OMC
   * 
   * @return IndexInstanceGetRemoteIntf
   * @throws java.rmi.RemoteException
   * @throws com.winnertel.inms.upm.common.util.PmException
   */
  public IndexInstanceGetRemoteIntf getIndexInstanceGetIntf()
      throws RemoteException, PmException
  {
    // return this.indexInstanceIntf;
    return null;
  }

  public JobScheduleRemoteIntf getJobScheduleRemoteIntf()
      throws RemoteException, PmException
  {
    // return this.jobScheduleRemoteIntf;
    return null;
  }

  public DnManipulationRemoteIntf getDnManipulationRemoteIntf()
      throws RemoteException, PmException
  {
    return dnManipulationRemoteIntf;
  }

  public CollectionScheduleRemoteIntf getCollectionScheduleRemoteIntf()
      throws RemoteException, PmException
  {
    // return collectionScheduleRemoteIntf;
    return null;
  }

  public OMCTCARemoteIntf getOMCTCARemoteIntf() throws RemoteException,
      PmException
  {
    return this.tcaRemoteIntf;
  }

  public static void main(String args[])
  {
    String port = "1099";
    String servicename = "UTOMCDPM";
    int iPort = Integer.parseInt(port);
    OMCPMMainRemoteImpl omcPMMainRemoteImpl = null;
    try
    {
      omcPMMainRemoteImpl = new OMCPMMainRemoteImpl();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    String rmiURL = "//localhost:" + port + "/" + servicename;
    try
    {
      LocateRegistry.createRegistry(iPort);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    try
    {
      Naming.rebind(rmiURL, omcPMMainRemoteImpl);
      System.out.println(rmiURL + " is rebound");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
