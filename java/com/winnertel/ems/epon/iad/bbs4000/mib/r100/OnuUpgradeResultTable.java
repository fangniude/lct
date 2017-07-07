package com.winnertel.ems.epon.iad.bbs4000.mib.r100;

import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;

import java.util.Vector;

public class OnuUpgradeResultTable extends SnmpMibBean {
  private long index = 0;
  private int target = 0;
  private int method = 0;
  private String ontName = null;
  private String imageInstance = null;
  private String onuUpgradeResult = null;
  private int active = 0;
  private int commit = 0;
    
  public OnuUpgradeResultTable(ISnmpProxy aSnmpProxy) {
    super(aSnmpProxy);
    init();
  }

  protected void init() {
  }

  public long getOnuUpgradeTaskandResultIndex() {
    return index;
  }

  public void setOnuUpgradeTaskandResultIndex(long aOnuUpgradeTaskandResultIndex) {
    index = aOnuUpgradeTaskandResultIndex;
  }


  public int getOnuUpgradeTaskandResultOnuUpgradeTarget() {
    return target;
  }

  public void setOnuUpgradeTaskandResultOnuUpgradeTarget(int aOnuUpgradeTaskandResultOnuUpgradeTarget) {
    target = aOnuUpgradeTaskandResultOnuUpgradeTarget;
  }

  public int getOnuUpgradeTaskandResultOnuUpgradeMethod() {
    return method;
  }

  public void setOnuUpgradeTaskandResultOnuUpgradeMethod(int aOnuUpgradeTaskandResultOnuUpgradeMethod) {
    method = aOnuUpgradeTaskandResultOnuUpgradeMethod;
  }

  public String getOntName() {
    return ontName;
  }

  public void setOntName(String name) {
    ontName = name;
  }

  public String getImageInstance() {
    return imageInstance;
  }

  public void setImageInstance(String instance) {
    imageInstance = instance;
  }

  public String getOnuUpgradeResult() {
    return onuUpgradeResult;
  }

  public void setOnuUpgradeResult(String result) {
    onuUpgradeResult = result;
  }

    public int getOnuUpgradeProgressActivate() {
      return active;
    }

    public void setOnuUpgradeProgressActivate(int active) {
        this.active = active;
    }

    public int getOnuUpgradeProgressCommit() {
      return commit;
    }

    public void setOnuUpgradeProgressCommit(int commit) {
        this.commit = commit;
    }

  public Vector retrieveAll() throws MibBeanException {
    OnuUpgradeTandRTable task = new OnuUpgradeTandRTable(fSnmpProxy);
    task.setOnuUpgradeTaskandResultIndex(getOnuUpgradeTaskandResultIndex());
    task.setOnuUpgradeTaskandResultOnuUpgradeTarget(getOnuUpgradeTaskandResultOnuUpgradeTarget());
    task.setOnuUpgradeTaskandResultOnuUpgradeMethod(getOnuUpgradeTaskandResultOnuUpgradeMethod());

    task.retrieve();

    Vector v = new Vector();

/*
    It��s assumed that each slot has 4 OLT PON ports and each OLT PON port has 64 ONUs. Nonexist ports in the port
         list bit map should be reserved and set to 0 if the actual capacity of PON ports and ONUs of the line card
         in the slot is less than the above maximum assumption.
*/
    byte[] instance = task.getOnuUpgradeParticipantPortListBitMap();
    byte[] image = task.getOnuUpgradeImageInstancePortListBitMap();
    byte[] download = task.getOnuUpgradeProgressDownloadPortListBitMap();
    byte[] active = task.getOnuUpgradeProgressActivatePortListBitMap();
    byte[] commit = task.getOnuUpgradeProgressCommitPortListBitMap();
    byte[] finish = task.getOnuUpgradeProgressFinalPortListBitMap();
    byte[] failure = task.getOnuUpgradeResultPortListBitMap();

    if (instance != null && image != null && download != null && active != null &&
        commit != null && finish != null && failure != null) {

      for (int i = 0; i < instance.length; i++) {
        int mask = 128;
        for (int j = 0; j < 8; j++) {
          //The Onu is selected.
          if ((instance[i] & mask) != 0) {
            OnuUpgradeResultTable one = new OnuUpgradeResultTable(fSnmpProxy);
            int card = i/32 + 1;
            int port = (i%32)/8 + 1;
            int onu = (i%8)*8 + j + 1;
            one.setOntName(card + "/" + port + "/" + onu);

            //indicate which image instace is upgraded.
            if ((image[i] & mask) != 0) {
              one.setImageInstance("imageinstance1");
            } else {
              one.setImageInstance("imageinstance0");
            }

              //onu is in the active list.
              if ((active[i] & mask) != 0) {
                one.setOnuUpgradeProgressActivate(1);
              } else {
                one.setOnuUpgradeProgressActivate(2);
              }

              //onu is in the commit list.
              if ((commit[i] & mask) != 0) {
                one.setOnuUpgradeProgressCommit(1);
              } else {
                one.setOnuUpgradeProgressCommit(2);
              }

            //onu is in the fail list.
            if ((failure[i] & mask) != 0) {
              one.setOnuUpgradeResult("failed");
            } else {
              //onu is in the final list.
              if ((finish[i] & mask) != 0) {
                one.setOnuUpgradeResult("success");
              } else {
                  //onu is in the download list.
                  if ((download[i] & mask) != 0) {
                    one.setOnuUpgradeResult("download");
                  } else {
                    one.setOnuUpgradeResult("wait");
                  }
              }
            }

            v.add(one);
          }
          mask = mask >> 1;
        }
      }
    }

    return v;
  }
}
