package com.winnertel.ems.epon.iad.bbs4000.gui.r310.swing;

import com.winnertel.broadband.tftp.protocol.TFTPClient;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.PerformanceManagementResultFilterPanel;
import com.winnertel.ems.epon.iad.bbs4000.gui.swing.OnLineSlotFilterPanel;
import com.winnertel.ems.epon.iad.bbs4000.mgr.ReadTxtFile;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.IGuiComposer;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import com.winnertel.net.tftp.TFTP;
import com.winnertel.nms.lite.LiteContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import org.jfree.chart.*;
import org.jfree.data.time.*; 
import org.jfree.chart.axis.DateAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.XYPlot; 
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.tree.TreePath;

import org.jfree.data.xy.XYDataset;  

public class PerformanceManagementResultTablePanel extends UPanel implements ActionListener {
//  private OnLineSlotFilterPanel modulePanel = null;

//  private SnmpTablePane snmpPanel;
	
  private String TFTP_ROOT_DIR = LiteContext.getRootDir() +"tftp_root_dir";
  private String tftpFile = "_pm_4_2.0_0_0.txt";
  private String localFile = TFTP_ROOT_DIR + File.separator + tftpFile;
  private ChartPanel resultPanel;
  
  protected JButton refreshButton;
  
  private PerformanceManagementResultFilterPanel modulePanel = null;

  public PerformanceManagementResultTablePanel(IApplication app) {
    super(app);
    
    File root = new File(TFTP_ROOT_DIR);

    if (!root.exists()) {
        root.mkdir();
    }
    
    init();
  }

  public void initGui() {
    modulePanel = new PerformanceManagementResultFilterPanel(fApplication);
    modulePanel.addActionListener(this);
    
    refreshButton = modulePanel.getRefreshButton();

    setLayout(new BorderLayout());
    add(modulePanel, BorderLayout.NORTH);
//    add(snmpPanel, BorderLayout.CENTER);
  }

  public void refresh() {
	//download the file;

	  TFTPClient tftpClient = new TFTPClient();
	//receive the file from NE.
      tftpClient.setSocketTimeout(5000);
      tftpClient.setMaxTimeoutCount(3);
	  
	  tftpClient.getFile(fApplication.getActiveDeviceManager().getDisplayName(), TFTP.BINARY_MODE, tftpFile, localFile);
	  
      if(resultPanel == null) {
    	  oltTimeSeriesChart();
          add(resultPanel, BorderLayout.CENTER);
      }
      
      

      modulePanel.refresh();


    //force the table pane refresh the data.
//    actionPerformed(null);
//    qosTablePanel.refresh();
  }

  public void actionPerformed(ActionEvent e) {
//    SnmpMibBean bean = (SnmpMibBean) snmpPanel.getModel();
////    if(modulePanel.getSelectedSlotId() == 0) {//select all
////      bean.setIndex(0, "0");
////      bean.setIndex(1, "1");
////      bean.setIndex(2, "4");
////
////      bean.setRowsToFetch(0); //set 0 to disable this attribute.
////    } else {
////      bean.setIndex(0, "" + (modulePanel.getSelectedSlotId() -1));
////      bean.setIndex(1, "1");
////      bean.setIndex(2, "4");
////
////      bean.setRowsToFetch(4);
////    }
//    Object[] index = generateIndex(getName());
//    if(index != null) {
//      for(int i = 0; i < index.length; i++) {
//        bean.setIndex(i, index[i]);
//      }
//    }
//
//    bean.setRowsToFetch(getRowsToFetch(getName()));
//    bean.setIndexPrefix(getIndexPrefix(getName()));
//
//    snmpPanel.refresh();
	  
	  int SlotId = modulePanel.getSelectedSlotId();
	  int PortId = modulePanel.getSelectedPortId();
	  int PerformanceStatId = modulePanel.getSelectedPerformanceStatId();
	  
	  if(resultPanel != null) {
//		  super.repaint();
		  remove(resultPanel);
    	  oltTimeSeriesChart();
          add(resultPanel, BorderLayout.CENTER);
          updateUI();
      }
  }

  private Object[] generateIndex(String panel)
  {
    Object[] result = null;

    if(panel.equals("Interface_table")) {
      result = new Integer[1];

      if(modulePanel.getSelectedSlotId() != 0) {
        int ifIndex = ConfigUtility.generateIfIndex(modulePanel.getSelectedSlotId() + "/1");
        result[0] = new Integer((ifIndex - 29664));
      }

      //if select all module(getSelectedSlotId() == 0), don't initialize the array,  use null to erase the index list.
    }
    else if(panel.equals("SwitchPortExtTable_Panel") || panel.equals("QosExtDscpTrustTable_Panel")) {
      result = new String[1];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = "" + (modulePanel.getSelectedSlotId() -1) * 4;
      }
    }
    else if(panel.equals("IntfRateControlTable_Panel") || panel.equals("Dot3OltOpmOltDataTable_Panel")) {
      result = new String[2];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = "" + (modulePanel.getSelectedSlotId() - 1);
        result[1] = "4";
      }
    }
    else if(panel.equals("Dot3Olt2PortDiagnosisTable_Panel")) {
      result = new Integer[3];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = new Integer(modulePanel.getSelectedSlotId());
        result[1] = new Integer(1);
        result[2] = new Integer(0);
      }
    }
    else if(panel.equals("QosExtCosQueueSchedTable_Panel"))
    {
      result = new String[2];

      if(modulePanel.getSelectedSlotId() != 0) {
        result[0] = "" + (modulePanel.getSelectedSlotId() -1) * 4;
        result[1] = "7";
      }
    }

    return result;
  }

  private int getRowsToFetch(String panel)
  {
    if(modulePanel.getSelectedSlotId() == 0) { //if select all module, use 0 to erase the row count.
      return 0;
    }

    if(panel.equals("SwitchPortExtTable_Panel") || panel.equals("QosExtDscpTrustTable_Panel"))
    {
      return 4;
    }

    if(panel.equals("QosExtCosQueueSchedTable_Panel")) {
      return 32;
    }

    return 0;
  }

  private String getIndexPrefix(String panel)
  {
    if(modulePanel.getSelectedSlotId() == 0) {//if select all module, use 0 to erase the row count.
      return null;
    }

    if(panel.equals("SwitchPortExtTable_Panel") || panel.equals("QosExtDscpTrustTable_Panel")
        || panel.equals("QosExtCosQueueSchedTable_Panel")) {
      return null;
    }

    return "" + modulePanel.getSelectedSlotId();
  }
  
  private void oltTimeSeriesChart()
  {
	  XYDataset xydataset = createOltDataset();  
      JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(getString("OltPerformanceStatchart"), getString("Time"), getString(modulePanel.getSelectedPerformanceStat()),xydataset, true, true, true);  
      XYPlot xyplot = (XYPlot) jfreechart.getPlot();  
      DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();  
      dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy.MM.dd HH:mm"));  
      resultPanel=new ChartPanel(jfreechart,true);  
  }
  
  private XYDataset createOltDataset() {
	  int PerformanceStatId = modulePanel.getSelectedPerformanceStatId();
      TimeSeries timeseries = new TimeSeries(""+modulePanel.getSelectedSlotId()+"-"+modulePanel.getSelectedPortId()+getString(modulePanel.getSelectedPerformanceStat())+getString("OltPerformanceStatLine"),  
              org.jfree.data.time.Minute.class);  
      ReadTxtFile trt = new ReadTxtFile();
		try {
			String[] line = trt.readfile(localFile);
//			String road = LiteContext.getRootDir() +"tftp_root_dir";
//			System.out.println(road);
			for (int i = 0; i < line.length; i++) {
//				System.out.print(line[i].toString());
				String text = line[i].toString().trim();
//				if (text.startsWith("result")) {
//					String[] data = text.split(":");
//					String time = data[1];
//					String[] times = time.split("/");
////					int SlotId = modulePanel.getSelectedSlotId();
////					int PortId = modulePanel.getSelectedPortId();
//					timeseries.add(new Minute(
//							Integer.parseInt(times[4]),
//							Integer.parseInt(times[3]),
//							Integer.parseInt(times[2]),
//							Integer.parseInt(times[1]),
//							Integer.parseInt(times[0])), Integer.parseInt(data[PerformanceStatId+1]));
//				}
				
				if (text.startsWith("#header: OltInterface:15 minutes")) {
					for (i++; i < line.length; i++) {
						String timeLine = line[i].toString().trim();
						
						if (timeLine.startsWith("#endtable")) {
							break;
						}
						
						//add chart data
						if (timeLine.startsWith("#period:")) {
							Integer year = Integer.parseInt(timeLine.substring(8, 12));
							Integer month = Integer.parseInt(timeLine.substring(12, 14));
							Integer day = Integer.parseInt(timeLine.substring(14, 16));
							Integer hour = Integer.parseInt(timeLine.substring(16, 18));
							Integer minute = Integer.parseInt(timeLine.substring(18, 20));
							
							for (i++; i < line.length; i++) {
								String dataLine = line[i].toString().trim();
								if (dataLine.startsWith("0-"+modulePanel.getSelectedSlotId()+"-"+modulePanel.getSelectedPortId())) {
//									System.out.println(""+year+month+day+hour+minute);
									String[] data = dataLine.split(":");
									timeseries.add(new Minute(minute,hour,day,month,year), Integer.parseInt(data[PerformanceStatId+3]));
								}
								
								if (dataLine.startsWith("#endperiod")) {
									break;
								}
							}
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//      timeseries.add(new Minute(30,16,12,06,2014), 181.80000000000001D);  
//      timeseries.add(new Minute(45,16,12,06,2014), 167.30000000000001D);  
//      timeseries.add(new Minute(00,17,12,06,2014), 153.80000000000001D);  
//      timeseries.add(new Minute(15,17,12,06,2014), 167.59999999999999D);  
//      timeseries.add(new Minute(30,17,12,06,2014), 158.80000000000001D);  
//      timeseries.add(new Minute(45,17,12,06,2014), 148.30000000000001D);  
//      timeseries.add(new Minute(00,18,12,06,2014), 153.90000000000001D);  
//      timeseries.add(new Minute(15,18,12,06,2014), 142.69999999999999D);  
//      timeseries.add(new Minute(30,18,12,06,2014), 123.2D);  
//      timeseries.add(new Minute(45,18,12,06,2014), 131.80000000000001D);  
//      timeseries.add(new Minute(00,19,12,06,2014), 139.59999999999999D);  
//      timeseries.add(new Minute(15,19,12,06,2014), 142.90000000000001D);  
//      timeseries.add(new Minute(30,19,12,06,2014), 138.69999999999999D);  
//      timeseries.add(new Minute(45,19,12,06,2014), 137.30000000000001D);  
//      timeseries.add(new Minute(00,20,12,06,2014), 143.90000000000001D);  
//      timeseries.add(new Minute(15,20,12,06,2014), 139.80000000000001D);  
//      timeseries.add(new Minute(30,20,12,06,2014), 137D);  
//      timeseries.add(new Minute(45,20,12,06,2014), 132.80000000000001D);  
      TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();  
      timeseriescollection.addSeries(timeseries);  
      return timeseriescollection;  
	}

	public String getString(String s) {
		return (s == null || s.length() <= 0) ? s
				: fStringMap != null ? fStringMap.getString(s) : s;
	}
	
}
