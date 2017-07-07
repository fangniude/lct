package com.winnertel.ems.epon.pm.collector.job.bbs4000;

import com.winnertel.ems.epon.pm.collector.mo.NePmJobCenter;
import com.winnertel.ems.epon.pm.collector.mo.NePmJobInfo;
import com.winnertel.ems.epon.pm.collector.parser.PmFileWriter;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.net.tftp.TFTP;
import com.winnertel.net.tftp.TFTPClient;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;
import java.util.List;
import java.util.TimeZone;

public class BBS4kCollectorJob implements Job
{
  static Logger log = Logger.getLogger(BBS4kCollectorJob.class.getName());

  public BBS4kCollectorJob()
  {}
  
  protected long getTimeFile(NePmJobInfo nePmJobInfo){
	   long t = (System.currentTimeMillis() + TimeZone.getDefault().getOffset(0))/1000;
	   String nodeversion=null;
	   if(nePmJobInfo.getNeType().toUpperCase().startsWith("BBS4000")){
			try {
				nodeversion = SnmpUtility.getNeTotalVersion("BBS4000", nePmJobInfo.getIp(), nePmJobInfo.getSnmpPort(), nePmJobInfo.getGetCommunity());
				log.debug("get version from node. IP:"+nePmJobInfo.getIp()+" version:"+nodeversion);
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("BBS4kCollectorJob.getTimeFile for BBS4000 error:"+e.toString()+".  get NE version error");
				return -1;
			}
		    if(nodeversion!=null){
			    if(nodeversion.startsWith("3")){
//			    	if(VersionSupport.versionCompared(nodeversion, "3.1.1.6")>=0){
			    		//local time
			    		t = (System.currentTimeMillis() + TimeZone.getDefault().getOffset(0))/1000;
//			    	}
//			    	else{
//			    		gmt
//			    		t = (System.currentTimeMillis())/1000;
//			    	}
			    }
//			    if(nodeversion.startsWith("2")){
//			    	if(VersionSupport.versionCompared(nodeversion, "2.2.1.8")>=0){
//			    		t = (System.currentTimeMillis() + TimeZone.getDefault().getOffset(0))/1000;
//			    	}
//			    	else{
//			    		t = (System.currentTimeMillis())/1000;
//			    	}
//			    }
		    }
	   }
	   else if(nePmJobInfo.getNeType().toUpperCase().startsWith("BBS1000")){

			try {
				nodeversion = SnmpUtility.getNeTotalVersion("BBS1000",nePmJobInfo.getIp(),nePmJobInfo.getSnmpPort(),nePmJobInfo.getGetCommunity());
				log.debug("get version from node. IP:"+nePmJobInfo.getIp()+" version:"+nodeversion);
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("BBS4kCollectorJob.getTimeFile for BBS1000 error:"+e.toString()+".  get NE version error");
				return -1;
			}
		    if(nodeversion!=null){
//		    	if(VersionSupport.versionCompared(nodeversion, "3.4.1.2")>=0){
		    		//local time
		    		t = (System.currentTimeMillis() + TimeZone.getDefault().getOffset(0))/1000;
//		    	}
//		    	else{
		    		//gmt
//		    		t = (System.currentTimeMillis())/1000;
//		    	}
		    }
	   
	   }
	    t = t - 3600 - t%3600;
	    return t;
  }

  public void execute(JobExecutionContext context) throws JobExecutionException
  {
    List nePmJobList = NePmJobCenter.getInstance().getNePmJobList();
    //String nodeversion=context.getJobDetail().getJobDataMap().get("NodeVersion").toString();
    
    TFTPClient tftpClient = new TFTPClient();
    PmFileWriter fileWriter = new PmFileWriter();
    BBS4kPmDataParser parser = new BBS4kPmDataParser();

    log.debug("Collect thread is started, there are " + nePmJobList.size() + " NEs to download file.");
    for(int i = 0; i < nePmJobList.size(); i++)
    {
      NePmJobInfo nePmJobInfo = (NePmJobInfo)nePmJobList.get(i);
      String ip = nePmJobInfo.getIp();

      String[] remoteFileName = null;
      String[] localFileName = null;

      long t=getTimeFile(nePmJobInfo);
      
      int trycount=0;
      while(t<0 && trycount<5){
    	  t=getTimeFile(nePmJobInfo);
    	  trycount++;
    	  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
      }
      //error get version
      if(t<0){
    	  log.debug("try 5 time to get version ,but failed. IP="+ip);
    	  continue;
      }
      
      if(nePmJobInfo.getNeType() != null && nePmJobInfo.getNeType().startsWith("ONU")) {
          remoteFileName = new String[2];
          remoteFileName[0] = "_pm_1_1.0_" + t + "_1";//VOIP
          remoteFileName[1] = "_pm_1_1.0_" + t + "_3";//Switch

          localFileName = new String[2];
          localFileName[0] = "download/"+ ip + "_pm_1_1.0_" + t + "_1";
          localFileName[1] = "download/"+ ip + "_pm_1_1.0_" + t + "_3";
      } else {
          remoteFileName = new String[1];
          remoteFileName[0] = "nvm:_pm_4_2.0_" + t + "_40000007_4.gz";

          localFileName = new String[1];
          localFileName[0] = "download/"+ ip + "_pm_4_2.0_" + t + "_40000007_4.gz";
      }

      log.debug("Begin to get the PM data files from NE[" + nePmJobInfo.getNeType() + ", " + ip + "] in list.");

      for(int j = 0; j < remoteFileName.length; j++) {
          //delete the local file.
          File file = new File(localFileName[j]);
          if(file.exists())
            file.delete();

          log.debug("Try to download the PM file from NE: " + ip);
          //receive the file from NE.
          tftpClient.setSocketTimeout(5000);
          tftpClient.setMaxTimeoutCount(3);
          tftpClient.getFile(ip, TFTP.BINARY_MODE, remoteFileName[j], localFileName[j]);

          log.debug("Try to parse the PM file: " + localFileName[j]);

          fileWriter.setNePmJobInfo(nePmJobInfo);
          parser.setPmFileWriter(fileWriter);
          try
          {
            parser.parser(localFileName[j]);
          }
          catch(Exception e)
          {
            e.printStackTrace();
            log.error("Can't parse the PM file: " + localFileName[j]);
          }
      }

      //delete the tftp file which is older than 1 day.
      long time = System.currentTimeMillis();
      File dir = new File("download");
      File[] files = dir.listFiles();
      for(int j = 0; j < files.length; j++)
      {
        if((time - files[j].lastModified()) > 86400000)
          files[j].delete();
      }
    }

    //
    log.debug("Finish to get the PM data file from NEs in list.");
    tftpClient.close();
  }
}
