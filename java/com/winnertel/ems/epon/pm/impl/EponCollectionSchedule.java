// CollectionScheduleRemoteImpl.java

package com.winnertel.ems.epon.pm.impl;


import com.winnertel.inms.upm.common.omcinterface.*;
import com.winnertel.inms.upm.common.job.entities.CollectionProperty;
import com.winnertel.inms.upm.common.job.entities.OmcParamWrapper;
import com.winnertel.inms.upm.common.job.entities.FtpProperty;

public class EponCollectionSchedule
{
  public EponCollectionSchedule()
  {}

  public CollectionScheduleResult startCollection(
      OmcParamWrapper omcParamWrapper,
      OidInMeasurementType oidInMeasurementType, FtpProperty ftpProperty,
      CollectionProperty collectionProperty, String lastAccessTime)
      throws Exception
  {
    /* Do nothing. */
    return null;
  }

}
