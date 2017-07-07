package com.winnertel.ems.epon.pm.bridge;

import java.rmi.server.UnicastRemoteObject;
import com.winnertel.inms.upm.common.omcinterface.GroupCombMemberGetRemoteIntf;
import java.util.List;
import java.rmi.RemoteException;
import com.winnertel.inms.upm.common.util.PmException;

public class GroupCombMemberGetRemoteImpl extends UnicastRemoteObject implements
    GroupCombMemberGetRemoteIntf
{

  public GroupCombMemberGetRemoteImpl() throws RemoteException
  {}

  public List getCandidateGroupMembers(int groupType) throws RemoteException,
      PmException
  {
    return null;
  }

  public List getCandidateCombMembers(int combType, int memberType)
      throws RemoteException, PmException
  {
    return null;
  }
}
