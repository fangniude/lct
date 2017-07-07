package com.winnertel.ems.epon.iad.bbs1000.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.ems.epon.iad.bbs4000.mib.r200.Dot3Onu2TrafficProfTable;
import com.winnertel.ems.epon.iad.bbs1000.gui.swing.OnuTreePanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-11-7
 * Time: 12:33:19
 * To change this template use File | Settings | File Templates.
 */
public class BatchModifyTrafficProfPanel extends UPanel {
  private OnuTreePanel treePanel;

  private IntegerTextField tfUtsDot3OnuUpstreamPir = new IntegerTextField();
  private IntegerTextField tfUtsDot3OnuDownstreamPir = new IntegerTextField();
  private IntegerTextField tfUtsDot3OnuUpstreamCir = new IntegerTextField();
  private IntegerTextField tfUtsDot3OnuDownstreamCir = new IntegerTextField();
  private IntegerTextField tfUtsDot3OnuUpstreamMaxBurstSize = new IntegerTextField();
  private IntegerTextField tfUtsDot3OnuDownstreamMaxBurstSize = new IntegerTextField();
  private IntegerTextField tfUtsDot3OnuUpstreamWeight = new IntegerTextField();
  private IntegerTextField tfUtsDot3OnuUpstreamFir = new IntegerTextField();

  private final String utsDot3OnuUpstreamPir = fStringMap.getString("utsDot3OnuUpstreamPir") + " : ";
  private final String utsDot3OnuDownstreamPir = fStringMap.getString("utsDot3OnuDownstreamPir") + " : ";
  private final String utsDot3OnuUpstreamCir = fStringMap.getString("utsDot3OnuUpstreamCir") + " : ";
  private final String utsDot3OnuDownstreamCir = fStringMap.getString("utsDot3OnuDownstreamCir") + " : ";
  private final String utsDot3OnuUpstreamMaxBurstSize = fStringMap.getString("utsDot3OnuUpstreamMaxBurstSize") + " : ";
  private final String utsDot3OnuDownstreamMaxBurstSize = fStringMap.getString("utsDot3OnuDownstreamMaxBurstSize") + " : ";
  private final String utsDot3OnuUpstreamWeight = fStringMap.getString("utsDot3OnuUpstreamWeight") + " : ";
  private final String utsDot3OnuUpstreamFir = fStringMap.getString("utsDot3OnuUpstreamFir") + " : ";

  public BatchModifyTrafficProfPanel(IApplication app) {
    super(app);
    init();
  }

  public void initGui() {
    treePanel = new OnuTreePanel(fApplication);
    treePanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString("ONU_Tree")));
    treePanel.setPreferredSize(new Dimension(200, 300));

    JPanel baseInfoPanel = new JPanel();
    NTLayout layout = new NTLayout(4, 6, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());
    baseInfoPanel.setLayout(layout);

    baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamPir));
    tfUtsDot3OnuUpstreamPir.setName(fStringMap.getString("utsDot3OnuUpstreamPir"));
    baseInfoPanel.add(tfUtsDot3OnuUpstreamPir);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamPir));
    tfUtsDot3OnuDownstreamPir.setName(fStringMap.getString("utsDot3OnuDownstreamPir"));
    baseInfoPanel.add(tfUtsDot3OnuDownstreamPir);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamCir));
    tfUtsDot3OnuUpstreamCir.setName(fStringMap.getString("utsDot3OnuUpstreamCir"));
    baseInfoPanel.add(tfUtsDot3OnuUpstreamCir);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamCir));
    tfUtsDot3OnuDownstreamCir.setName(fStringMap.getString("utsDot3OnuDownstreamCir"));
    baseInfoPanel.add(tfUtsDot3OnuDownstreamCir);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamMaxBurstSize));
    tfUtsDot3OnuUpstreamMaxBurstSize.setName(fStringMap.getString("utsDot3OnuUpstreamMaxBurstSize"));
    baseInfoPanel.add(tfUtsDot3OnuUpstreamMaxBurstSize);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuDownstreamMaxBurstSize));
    tfUtsDot3OnuDownstreamMaxBurstSize.setName(fStringMap.getString("utsDot3OnuDownstreamMaxBurstSize"));
    baseInfoPanel.add(tfUtsDot3OnuDownstreamMaxBurstSize);
    baseInfoPanel.add(new HSpacer());


    baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamFir));
    tfUtsDot3OnuUpstreamFir.setName(fStringMap.getString("utsDot3OnuUpstreamFir"));
    baseInfoPanel.add(tfUtsDot3OnuUpstreamFir);
    baseInfoPanel.add(new HSpacer());

    baseInfoPanel.add(new JLabel(utsDot3OnuUpstreamWeight));
    tfUtsDot3OnuUpstreamWeight.setName(fStringMap.getString("utsDot3OnuUpstreamWeight"));
    baseInfoPanel.add(tfUtsDot3OnuUpstreamWeight);
    baseInfoPanel.add(new HSpacer());


    JPanel allPanel = new JPanel();
    layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
    layout.setMargins(6, 10, 6, 10);
    allPanel.setLayout(layout);
    allPanel.add(baseInfoPanel);
    allPanel.add(treePanel);
    setLayout(new BorderLayout());
    add(allPanel, BorderLayout.CENTER);
    this.setPreferredSize(new Dimension(800, 500));
  }

  public void initForm() {
    tfUtsDot3OnuUpstreamPir.setValueScope(16, 1000000);
    tfUtsDot3OnuDownstreamPir.setValueScope(16, 1000000);
    tfUtsDot3OnuUpstreamCir.setValueScope(16, 1000000);
    tfUtsDot3OnuDownstreamCir.setValueScope(16, 1000000);
    tfUtsDot3OnuUpstreamMaxBurstSize.setValueScope(16, 1024);
    tfUtsDot3OnuDownstreamMaxBurstSize.setValueScope(16, 1024);
    tfUtsDot3OnuUpstreamWeight.setValueScope(1, 10);
    tfUtsDot3OnuUpstreamFir.setValueScope(0, 1000000);

    //set the default value.
    tfUtsDot3OnuUpstreamPir.setDefaultValue(100000);
    tfUtsDot3OnuUpstreamCir.setDefaultValue(10000);
    tfUtsDot3OnuUpstreamMaxBurstSize.setDefaultValue(16);
    tfUtsDot3OnuUpstreamFir.setDefaultValue(10000);
    
    tfUtsDot3OnuDownstreamPir.setDefaultValue(100000);
    tfUtsDot3OnuDownstreamCir.setDefaultValue(10000);
    tfUtsDot3OnuDownstreamMaxBurstSize.setDefaultValue(16);
  }

  public void refresh() {
  }

  public boolean validateFrom() {
    if (tfUtsDot3OnuUpstreamCir.getValue() > tfUtsDot3OnuUpstreamPir.getValue()) {
      String error = fStringMap.getString("Err_Us_Cir_Greater_Than_Pir");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }

    if (tfUtsDot3OnuDownstreamCir.getValue() > tfUtsDot3OnuDownstreamPir.getValue()) {
      String error = fStringMap.getString("Err_Ds_Cir_Greater_Than_Pir");
      MessageDialog.showErrorMessageDialog(fApplication, error);
      return false;
    }

    Vector v = treePanel.getSelectedOnuIndices();

    HashMap map = new HashMap();
    for(int i = 0; i < v.size(); i++)
    {
      String index = (String) v.get(i);
      String[] split = index.split("/");

      String key = split[0] + "/" + split[1];
      ArrayList list = (ArrayList)map.get(key);

      if(list == null)
      {
        list = new ArrayList();
        map.put(key, list);
      }

      list.add(index);
    }

    Iterator iterator = map.keySet().iterator();

    while(iterator.hasNext())
    {
      String key = (String)iterator.next();
      ArrayList list = (ArrayList)map.get(key);
      String[] split = key.split("/");

      Dot3Onu2TrafficProfTable mbean = new Dot3Onu2TrafficProfTable(fApplication.getSnmpProxy());
      mbean.setUtsDot3OnuTProfModuleId(new Integer(split[0]));
      mbean.setUtsDot3OnuTProfDeviceId(1);
      mbean.setUtsDot3OnuTProfPortId(new Integer(split[1]));
      mbean.setUtsDot3OnuTProfLogicalPortId(0);

      mbean.setIndexPrefix(split[0] + ".1." + split[1]);

      try {
        int newUsTotalCommit = tfUtsDot3OnuUpstreamCir.getValue() * list.size();
        int newDsTotalCommit = tfUtsDot3OnuDownstreamCir.getValue() * list.size();

        if(newUsTotalCommit > 1000000)
        {
          String error = fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_1")
              + split[0] + "/" + split[1] + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_2");
          MessageDialog.showErrorMessageDialog(fApplication, error);
          return false;
        }

        if(newDsTotalCommit > 1000000)
        {
          String error = fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_1")
              + split[0] + "/" + split[1] + fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_2");
          MessageDialog.showErrorMessageDialog(fApplication, error);
          return false;
        }

        int usTotalCommit = 0;
        int dsTotalCommit = 0;

        Vector mbeanTable = mbean.retrieveAll();
        if (mbeanTable != null) {
          for (int i = 0; i < mbeanTable.size(); i++) {
            Dot3Onu2TrafficProfTable one = (Dot3Onu2TrafficProfTable) mbeanTable.get(i);

            StringBuffer sb = new StringBuffer();
            sb.append(one.getUtsDot3OnuTProfModuleId()).append("/").append(one.getUtsDot3OnuTProfPortId()).append("/").append(one.getUtsDot3OnuTProfLogicalPortId());

            if(!list.contains(sb.toString()))
            {
              usTotalCommit += one.getUtsDot3OnuUpstreamCir().intValue();
              dsTotalCommit += one.getUtsDot3OnuDownstreamCir().intValue();
            }
          }
        }

        int usLeftCommit = 1000000 - usTotalCommit;
        int dsLeftCommit = 1000000 - dsTotalCommit;
        if (newUsTotalCommit > usLeftCommit) {
          String error = fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_1")
                   + split[0] + "/" + split[1] + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_2")
                   + "\r\n" + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_3") +
                   + usLeftCommit + fStringMap.getString("Err_Total_Committed_Bandwidth_Exceed_Limit_4");

          MessageDialog.showErrorMessageDialog(fApplication, error);
          return false;
        }

        if (newDsTotalCommit > dsLeftCommit) {
          String error = fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_1")
              + split[0] + "/" + split[1] + fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_2")
              + "\r\n" + fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_3") +
              + usLeftCommit + fStringMap.getString("Err_Total_Downstream_Committed_Bandwidth_Exceed_Limit_4");

          MessageDialog.showErrorMessageDialog(fApplication, error);
          return false;
        }
      } catch (MibBeanException e) {
        e.printStackTrace();
      }
    }

    return true;
  }



  public void updateModel() {
    setModel(new Dot3Onu2TrafficProfTable(fApplication.getSnmpProxy()));

    Vector v = treePanel.getSelectedOnuIndices();
    Dot3Onu2TrafficProfTable mbean = new Dot3Onu2TrafficProfTable(fApplication.getSnmpProxy());
    try {
      for(int i = 0; i < v.size(); i++)
      {
        String index = (String)v.get(i);
        String[] split = index.split("/");

        mbean.setUtsDot3OnuTProfModuleId(new Integer(split[0]));
        mbean.setUtsDot3OnuTProfDeviceId(1);
        mbean.setUtsDot3OnuTProfPortId(new Integer(split[1]));
        mbean.setUtsDot3OnuTProfLogicalPortId(new Integer(split[2]));
        mbean.setUtsDot3OnuUpstreamPir(new Integer(tfUtsDot3OnuUpstreamPir.getValue()));
        mbean.setUtsDot3OnuDownstreamPir(new Integer(tfUtsDot3OnuDownstreamPir.getValue()));
        mbean.setUtsDot3OnuUpstreamCir(new Integer(tfUtsDot3OnuUpstreamCir.getValue()));
        mbean.setUtsDot3OnuDownstreamCir(new Integer(tfUtsDot3OnuDownstreamCir.getValue()));
        mbean.setUtsDot3OnuUpstreamMaxBurstSize(new Integer(tfUtsDot3OnuUpstreamMaxBurstSize.getValue()));
        mbean.setUtsDot3OnuDownstreamMaxBurstSize(new Integer(tfUtsDot3OnuDownstreamMaxBurstSize.getValue()));
        mbean.setUtsDot3OnuUpstreamWeight(new Integer(tfUtsDot3OnuUpstreamWeight.getValue()));
        mbean.setUtsDot3OnuUpstreamFir(new Integer(tfUtsDot3OnuUpstreamFir.getValue()));

        mbean.modify();
      }

    } catch (MibBeanException e) {
      MessageDialog.showOperationFailedDialog( fApplication );
      e.printStackTrace();
    }
  }
}
