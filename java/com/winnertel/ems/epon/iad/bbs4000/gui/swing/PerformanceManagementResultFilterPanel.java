package com.winnertel.ems.epon.iad.bbs4000.gui.swing;

import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.BaseModuleType;
import com.winnertel.ems.epon.iad.bbs4000.gui.shelfview.ModuleType;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.model.BBS4000NE;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.DvmStringMap;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

public class PerformanceManagementResultFilterPanel extends JPanel implements ActionListener {
    public static final String IS_INITIAL = "epon_dvm_filter_is_initial";
    public static final String LEVEL = "epon_dvm_filter_level";
    public static final String SLOT_LIST = "epon_dvm_filter_slot";
    public static final String PORT_COUNT = "epon_dvm_filter_port";
    public static final String ONU_COUNT = "epon_dvm_filter_onu";

    public static final String SLOT_ID = "OnuFilterPanel.moduleId";
    public static final String PORT_ID = "OnuFilterPanel.portId";
    public static final String ONU_ID = "OnuFilterPanel.onuId";

    protected IApplication fApplication = null;
    protected DvmStringMap fStringMap = null;

    protected JComboBox cmbMeasurementMO = new JComboBox();
    protected JComboBox cmbModule = new JComboBox();
    protected JComboBox cmbPort = new JComboBox();
    protected JComboBox cmbLogicalPort = new JComboBox();
    protected JComboBox cmbMeasurementGranularity = new JComboBox();
    
    protected int[] utsPerformanceStatVList = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    protected String[] utsPerformanceStatTList = new String[] { 
    		getString("utsPonIfExtSysFrameRxOk"), // 0
    		getString("utsPonIfExtSysFrameTxOk"), // 1
    		getString("utsPonIfExtSysFrameRxErr"), // 2
    		getString("utsPonIfExtSysOctetRxOk"), // 3
    		getString("utsPonIfExtSysOctetTxOk"), // 4
    		getString("utsPonIfExtPonOctetRxErr"), // 5
    		getString("utsPonIfExtEponFrameRxReport"), // 6
    		getString("utsPonIfExtEponFrameTxReport"), // 7
    	    getString("utsPonIfExtEponFrameRxGate"), // 8
    	    getString("utsPonIfExtEponFrameTxGate"), // 9
    	    getString("utsPonIfExtPonOctetRxOk"), // 10
    	    getString("utsPonIfExtPonOctetTxOk"), // 11
    	    getString("utsPonIfExtPonFrameTotalRxDropped"), // 12
    	    getString("utsPonIfExtPonFrameTotalTxDropped"), // 13
    	    getString("utsPonIfExtPonFrameRxOk"), // 14
    	    getString("utsPonIfExtPonFrameTxOk"), // 15
//    	getString("utsPonIfExtSysFrameTxOk"), // 0,1
//	    getString("utsPonIfExtSysFrameRxOk"), // 1,0
//	    getString("utsPonIfExtSysFrameTxErr"), // 2
//	    getString("utsPonIfExtSysFrameRxErr"), // 3,2
//	    getString("utsPonIfExtSysFrameTxUnicast"), // 4
//	    getString("utsPonIfExtSysFrameRxUnicast"), // 5
//	    getString("utsPonIfExtSysFrameTxMulticast"), // 6
//	    getString("utsPonIfExtSysFrameRxMulticast"), // 7
//	    getString("utsPonIfExtSysFrameTxBroadcast"), // 8
//	    getString("utsPonIfExtSysFrameRxBroadcast"), // 9
//	    getString("utsPonIfExtSysOctetTxOk"), // 10,4
//	    getString("utsPonIfExtSysOctetRxOk"), // 11,3
//	    getString("utsPonIfExtPonFrameTxOk"), // 12,15
//	    getString("utsPonIfExtPonFrameRxOk"), // 13,14
//	    getString("utsPonIfExtPonOctetTxOk"), // 14,11
//	    getString("utsPonIfExtPonOctetRxOk"), // 15,10
//	    getString("utsPonIfExtEponFrameRxReport"), // 16,6
//	    getString("utsPonIfExtEponFrameTxReport"), // 17,7
//	    getString("utsPonIfExtEponFrameRxGate"), // 18,8
//	    getString("utsPonIfExtEponFrameTxGate"), // 19,9
//	    getString("utsPonIfExtEponFrameRxRegReq"), // 20
//	    getString("utsPonIfExtEponFrameTxRegReq"), // 21
//	    getString("utsPonIfExtEponFrameRxReg"), // 22
//	    getString("utsPonIfExtEponFrameTxReg"), // 23
//	    getString("utsPonIfExtEponFrameRxRegAck"), // 24
//	    getString("utsPonIfExtEponFrameTxRegAck"), // 25
//	    getString("utsPonIfExtEponFrameCrc8Error"), // 26
//	    getString("utsPonIfExtEponFrameSldError"), // 27
//	    
//	    getString("utsPonIfExtPonOctetRxErr"), // 5
//	    getString("utsPonIfExtPonFrameTotalRxDropped"), // 12
//	    getString("utsPonIfExtPonFrameTotalTxDropped"), // 13
    };
    protected JComboBox cmbPerformanceStat = new JComboBox();

    protected JButton btnRefresh = null;
    //    protected BBS4000NE ne = null;

    protected Map fCustomCache;
    protected Vector<BBS4000CardMibBean> fSlotList;
    protected Integer fPortCount;
    protected Integer fOnuCount;

    public PerformanceManagementResultFilterPanel(IApplication app) {
        fApplication = app;
        if (fApplication.getActiveDeviceManager() != null) {
            fStringMap = new DvmStringMap(fApplication.getActiveDeviceManager().getGuiComposer());
        }
        initData();
        init();
    }

    private void initData() {
        fCustomCache = fApplication.getActiveDeviceManager().getCustomCache();

        if (!Boolean.TRUE.equals(fCustomCache.get(IS_INITIAL))) {
            initCache(fApplication);
        }

        fSlotList = (Vector<BBS4000CardMibBean>) fCustomCache.get(SLOT_LIST);
        fPortCount = (Integer) fCustomCache.get(PORT_COUNT);
        fOnuCount = (Integer) fCustomCache.get(ONU_COUNT);
    }

    protected static void initCache(IApplication aApplication) {
        BBS4000CardMibBean bean = new BBS4000CardMibBean(aApplication.getSnmpProxy());
        Vector<BBS4000CardMibBean> slotList = BeanService.refreshTableBean(aApplication, bean);

        Map cache = aApplication.getActiveDeviceManager().getCustomCache();
        cache.put(SLOT_LIST, slotList);

        BBS4000NE ne = new BBS4000NE(aApplication);
        cache.put(PORT_COUNT, ne.getPortCount());
        cache.put(ONU_COUNT, ne.getPonSplitRatio());

        cache.put(IS_INITIAL, Boolean.TRUE);

        cache.put(PerformanceManagementResultFilterPanel.SLOT_ID, 1);
        cache.put(PerformanceManagementResultFilterPanel.PORT_ID, 1);
        cache.put(PerformanceManagementResultFilterPanel.ONU_ID, 1);
    }

    protected void init() {
        NTLayout layout = new NTLayout(1, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        setBorder(BorderFactory.createTitledBorder(getString("Filter")));

        JPanel conditionPanel = new JPanel(new FlowLayout());
        conditionPanel.add(new Label(getString("utsMeasurementMO") + ": "));
        conditionPanel.add(cmbMeasurementMO);
        conditionPanel.add(new Label(getString("Module ID") + ": "));
        conditionPanel.add(cmbModule);
        conditionPanel.add(new Label(getString("Port ID") + ": "));
        conditionPanel.add(cmbPort);
        conditionPanel.add(new Label(getString("Logical Port ID") + ": "));
        conditionPanel.add(cmbLogicalPort);
        conditionPanel.add(new Label(getString("Performance Stat Item") + ": "));
        conditionPanel.add(cmbPerformanceStat);

        add(conditionPanel, null);
        add(new HSpacer());
        add(getRefreshButton(), null);
        
        cmbMeasurementMO.removeActionListener(this);
        cmbMeasurementMO.removeAllItems();
        String[] utsMeasurementMOTList = new String[] {
        		getString("pon"), // 1
        		getString("onu"), // 2
        		getString("eth"), // 3
        };
        
        for (int i = 0; i < utsMeasurementMOTList.length; i++) {
        	cmbMeasurementMO.addItem(utsMeasurementMOTList[i]);
        }
        

        cmbModule.removeActionListener(this);
        cmbModule.removeAllItems();
//        cmbModule.addItem(getString("All"));

        BaseModuleType fModuleType = new ModuleType();

        if (fSlotList != null) {
            for (int i = 0; i < fSlotList.size(); i++) {
                BBS4000CardMibBean card = (BBS4000CardMibBean) fSlotList.get(i);
                if (card != null) {
                    if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
                        cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
                    } else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
                        cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
                    }
                    //else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
                    //   cmbModule.addItem(getString("Slot") + " " +
                    //   card.getUtsEponModuleBoardPhyId() + " - GEM");
                    //}
                }
            }
        }
        cmbModule.addActionListener(this);

        // Port
        cmbPort.removeAllItems();
//        cmbPort.addItem(getString("All"));
        for (int i = 1; i <= fPortCount; i++) {
            cmbPort.addItem(getString("Port") + " " + i);
        }

        // Logical Port
        cmbLogicalPort.removeAllItems();
//        cmbLogicalPort.addItem(getString("All"));
        for (int i = 1; i <= fOnuCount; i++) {
            cmbLogicalPort.addItem(getString("ONU") + " " + i);
        }
        
        cmbPerformanceStat.removeAllItems();
//        int[] utsPerformanceStatVList = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28 };
        String[] utsPerformanceStatTList = new String[] {
        		getString("utsPonIfExtSysFrameRxOk"), // 0
        		getString("utsPonIfExtSysFrameTxOk"), // 1
        		getString("utsPonIfExtSysFrameRxErr"), // 2
        		getString("utsPonIfExtSysOctetRxOk"), // 3
        		getString("utsPonIfExtSysOctetTxOk"), // 4
        		getString("utsPonIfExtPonOctetRxErr"), // 5
        		getString("utsPonIfExtEponFrameRxReport"), // 6
        		getString("utsPonIfExtEponFrameTxReport"), // 7
        	    getString("utsPonIfExtEponFrameRxGate"), // 8
        	    getString("utsPonIfExtEponFrameTxGate"), // 9
        	    getString("utsPonIfExtPonOctetRxOk"), // 10
        	    getString("utsPonIfExtPonOctetTxOk"), // 11
        	    getString("utsPonIfExtPonFrameTotalRxDropped"), // 12
        	    getString("utsPonIfExtPonFrameTotalTxDropped"), // 13
        	    getString("utsPonIfExtPonFrameRxOk"), // 14
        	    getString("utsPonIfExtPonFrameTxOk"), // 15
//        	getString("utsPonIfExtSysFrameTxOk"), // 1
//    	    getString("utsPonIfExtSysFrameRxOk"), // 2
//    	    getString("utsPonIfExtSysFrameTxErr"), // 3
//    	    getString("utsPonIfExtSysFrameRxErr"), // 4
//    	    getString("utsPonIfExtSysFrameTxUnicast"), // 5
//    	    getString("utsPonIfExtSysFrameRxUnicast"), // 6
//    	    getString("utsPonIfExtSysFrameTxMulticast"), // 7
//    	    getString("utsPonIfExtSysFrameRxMulticast"), // 8
//    	    getString("utsPonIfExtSysFrameTxBroadcast"), // 9
//    	    getString("utsPonIfExtSysFrameRxBroadcast"), // 10
//    	    getString("utsPonIfExtSysOctetTxOk"), // 11
//    	    getString("utsPonIfExtSysOctetRxOk"), // 12
//    	    getString("utsPonIfExtPonFrameTxOk"), // 13
//    	    getString("utsPonIfExtPonFrameRxOk"), // 14
//    	    getString("utsPonIfExtPonOctetTxOk"), // 15
//    	    getString("utsPonIfExtPonOctetRxOk"), // 16
//    	    getString("utsPonIfExtEponFrameRxReport"), // 17
//    	    getString("utsPonIfExtEponFrameTxReport"), // 18
//    	    getString("utsPonIfExtEponFrameRxGate"), // 19
//    	    getString("utsPonIfExtEponFrameTxGate"), // 20
//    	    getString("utsPonIfExtEponFrameRxRegReq"), // 21
//    	    getString("utsPonIfExtEponFrameTxRegReq"), // 22
//    	    getString("utsPonIfExtEponFrameRxReg"), // 23
//    	    getString("utsPonIfExtEponFrameTxReg"), // 24
//    	    getString("utsPonIfExtEponFrameRxRegAck"), // 25
//    	    getString("utsPonIfExtEponFrameTxRegAck"), // 26
//    	    getString("utsPonIfExtEponFrameCrc8Error"), // 27
//    	    getString("utsPonIfExtEponFrameSldError"), // 28
        };
        for (int i = 0; i < utsPerformanceStatTList.length; i++) {
        	cmbPerformanceStat.addItem(utsPerformanceStatTList[i]);
        }

        cmbMeasurementMO.addActionListener(this);
        cmbModule.addActionListener(this);
        cmbPort.addActionListener(this);
        cmbLogicalPort.addActionListener(this);
    }

    public JButton getRefreshButton() {
        if (btnRefresh == null) {
            btnRefresh = new JButton();
            btnRefresh.setText(getString("Refresh"));
        }

        return btnRefresh;
    }

    public void refresh() {
        Integer module = (Integer) fCustomCache.get(PerformanceManagementResultFilterPanel.SLOT_ID);
        Integer port = (Integer) fCustomCache.get(PerformanceManagementResultFilterPanel.PORT_ID);
        Integer onu = (Integer) fCustomCache.get(PerformanceManagementResultFilterPanel.ONU_ID);

        if (cmbModule.getSelectedIndex() == 0) {
            cmbModule.setSelectedIndex(0);
        }

//        setSelectedOnu(String.format("%s-%s-%s", module, port, onu));
        if (port == 0) {
            cmbPort.setSelectedIndex(0);
        }
        
        cmbPerformanceStat.setSelectedIndex(0);
        cmbLogicalPort.setEnabled(false);
//        if (onu == 0) {
//            cmbLogicalPort.setSelectedIndex(0);
//        }


        //        int oldModule = getOldSelectedIndex(cmbModule, module);
        //        if (oldModule > 0) {
        //            cmbModule.setSelectedIndex(oldModule);
        //
        //            int oldPort = getOldSelectedIndex(cmbPort, port);
        //            if (oldPort > 0) {
        //                cmbPort.setSelectedIndex(oldPort);
        //
        //                int oldOnu = getOldSelectedIndex(cmbLogicalPort, onu);
        //                if (oldOnu > 0) {
        //                    cmbLogicalPort.setSelectedIndex(oldOnu);
        //                } else {
        //                    cmbLogicalPort.setSelectedIndex(1);
        //                }
        //            } else {
        //                cmbPort.setSelectedIndex(1);
        //                cmbLogicalPort.setSelectedIndex(1);
        //            }
        //        } else {
        //            if (cmbModule.getItemCount() > 1) {
        //                cmbModule.setSelectedIndex(1);
        //            }
        //            cmbPort.setSelectedIndex(1);
        //            cmbLogicalPort.setSelectedIndex(1);
        //        }
    }

    protected static int getOldSelectedIndex(JComboBox checkBox, Object item) {
        int result = 0;
        for (int i = 0; i < checkBox.getItemCount(); i++) {
            if (checkBox.getItemAt(i).equals(item)) {
                return i;
            }
        }
        return result;
    }

    public int[] getAllSlotId() {
        int[] result = new int[cmbModule.getItemCount() - 1];

        for (int i = 1; i < cmbModule.getItemCount(); i++) {
            String item = (String) cmbModule.getItemAt(i);
            result[i - 1] = Integer.parseInt(item.split(" ")[1]);
        }

        return result;
    }

    public int getSelectedSlotId() {
        if (cmbModule.getSelectedItem() != null) {
            String item = (String) cmbModule.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedPortId() {
        if (cmbPort.getSelectedItem() != null) {
            String item = (String) cmbPort.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }

    public int getSelectedOnuId() {
        if (cmbLogicalPort.getSelectedIndex() != 0 && cmbLogicalPort.getSelectedItem() != null) {
            String item = (String) cmbLogicalPort.getSelectedItem();
            return (Integer.parseInt(item.split(" ")[1]));
        }

        return 0;
    }
    
    public int getSelectedPerformanceStatId() {
        if (cmbPerformanceStat.getSelectedIndex() != 0 && cmbPerformanceStat.getSelectedItem() != null) {
            return (new Integer(
            		utsPerformanceStatVList[cmbPerformanceStat
    				         						.getSelectedIndex()]));
        }

        return (new Integer(utsPerformanceStatVList[0]));
    }
    
    public String getSelectedPerformanceStat() {
        if (cmbPerformanceStat.getSelectedIndex() != 0 && cmbPerformanceStat.getSelectedItem() != null) {
//            String item = (String) cmbPerformanceStat.getSelectedItem();
//            return item;
        	return ((utsPerformanceStatTList[cmbPerformanceStat.getSelectedIndex()]));
        }

        return utsPerformanceStatTList[0];
    }
    
    public int getIndexFromValue(int[] list, int v) {
    	for (int i = 0; i != list.length; i++) {
    	    if (list[i] == v)
    		return i;
    	}

    	return 0;
    }

    public void addActionListener(ActionListener l) {
        btnRefresh.addActionListener(l);
    }

    public void removeActionListener(ActionListener l) {
        btnRefresh.removeActionListener(l);
    }

    public void actionPerformed(ActionEvent e) {
        //        if (fApplication == null || fApplication.getActiveDeviceManager() == null)
        //            return;

        //        fApplication.getActiveDeviceManager().getProperties().setProperty("OnuFilterPanel.moduleId", cmbModule.getSelectedItem() != null ? (String) cmbModule.getSelectedItem() : "");
        //        fApplication.getActiveDeviceManager().getProperties().setProperty("OnuFilterPanel.portId", cmbPort.getSelectedItem() != null ? (String) cmbPort.getSelectedItem() : "");
        //        fApplication.getActiveDeviceManager().getProperties().setProperty("OnuFilterPanel.onuId", cmbLogicalPort.getSelectedItem() != null ? (String) cmbLogicalPort.getSelectedItem() : "");
        fCustomCache.put(PerformanceManagementResultFilterPanel.SLOT_ID, getSelectedSlotId());
        fCustomCache.put(PerformanceManagementResultFilterPanel.PORT_ID, getSelectedPortId());
        fCustomCache.put(PerformanceManagementResultFilterPanel.ONU_ID, getSelectedOnuId());

        if (e.getSource().equals(cmbMeasurementMO)) {
        	BaseModuleType fModuleType = new ModuleType();
        	switch (cmbMeasurementMO.getSelectedIndex()) {
        	case 0:
        		
        		//slot
        		cmbModule.removeAllItems();
        		
        		
        		if (fSlotList != null) {
        			for (int i = 0; i < fSlotList.size(); i++) {
        				BBS4000CardMibBean card = (BBS4000CardMibBean) fSlotList.get(i);
        				if (card != null) {
        					if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
        						cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
        					} else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
        						cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
        					}
        				}
        			}
        		}
        		
        		//port
//        		cmbPort.removeAllItems();
//        		for (int i = 1; i <= fPortCount; i++) {
//        			cmbPort.addItem(getString("Port") + " " + i);
//        		}
        		
        		//Logical Port
        		cmbLogicalPort.setEnabled(false);
        		
        		//PerformanceStat
        		cmbPerformanceStat.removeAllItems();
        		String[] utsPerformanceStatPonTList = new String[] {
        				getString("utsPonIfExtSysFrameRxOk"), // 0
        				getString("utsPonIfExtSysFrameTxOk"), // 1
        				getString("utsPonIfExtSysFrameRxErr"), // 2
        				getString("utsPonIfExtSysOctetRxOk"), // 3
        				getString("utsPonIfExtSysOctetTxOk"), // 4
        				getString("utsPonIfExtPonOctetRxErr"), // 5
        				getString("utsPonIfExtEponFrameRxReport"), // 6
        				getString("utsPonIfExtEponFrameTxReport"), // 7
        				getString("utsPonIfExtEponFrameRxGate"), // 8
        				getString("utsPonIfExtEponFrameTxGate"), // 9
        				getString("utsPonIfExtPonOctetRxOk"), // 10
        				getString("utsPonIfExtPonOctetTxOk"), // 11
        				getString("utsPonIfExtPonFrameTotalRxDropped"), // 12
        				getString("utsPonIfExtPonFrameTotalTxDropped"), // 13
        				getString("utsPonIfExtPonFrameRxOk"), // 14
        				getString("utsPonIfExtPonFrameTxOk"), // 15
        		};
        		for (int i = 0; i < utsPerformanceStatPonTList.length; i++) {
        			cmbPerformanceStat.addItem(utsPerformanceStatPonTList[i]);
        		}
        		break;
        	case 1:
        		//slot
        		cmbModule.removeAllItems();
        		
        		
        		if (fSlotList != null) {
        			for (int i = 0; i < fSlotList.size(); i++) {
        				BBS4000CardMibBean card = (BBS4000CardMibBean) fSlotList.get(i);
        				if (card != null) {
        					if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
        						cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
        					} else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
        						cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
        					}
        				}
        			}
        		}
//        		cmbPort.removeAllItems();
        		cmbLogicalPort.setEnabled(true);
        		
        		//PerformanceStat
        		cmbPerformanceStat.removeAllItems();
        		String[] utsPerformanceStatOnuTList = new String[] {
        				getString("utsPonIfExtSysFrameRxOk"), // 0
        				getString("utsPonIfExtSysFrameTxOk"), // 1
        				getString("utsPonIfExtSysFrameRxErr"), // 2
        				getString("utsPonIfExtSysOctetRxOk"), // 3
        				getString("utsPonIfExtSysOctetTxOk"), // 4
        				getString("utsPonIfExtPonOctetRxErr"), // 5
        				getString("utsPonIfExtEponFrameRxReport"), // 6
        				getString("utsPonIfExtEponFrameTxReport"), // 7
        				getString("utsPonIfExtEponFrameRxGate"), // 8
        				getString("utsPonIfExtEponFrameTxGate"), // 9
        				getString("utsPonIfExtPonOctetRxOk"), // 10
        				getString("utsPonIfExtPonOctetTxOk"), // 11
        				getString("utsPonIfExtPonFrameTotalRxDropped"), // 12
        				getString("utsPonIfExtPonFrameTotalTxDropped"), // 13
        				getString("utsPonIfExtPonFrameRxOk"), // 14
        				getString("utsPonIfExtPonFrameTxOk"), // 15
        		};
        		for (int i = 0; i < utsPerformanceStatOnuTList.length; i++) {
        			cmbPerformanceStat.addItem(utsPerformanceStatOnuTList[i]);
        		}
        		break;
        	case 2:
        		cmbModule.removeAllItems();
//        		BaseModuleType fModuleType = new ModuleType();
        		
        		if (fSlotList != null) {
        			for (int i = 0; i < fSlotList.size(); i++) {
        				BBS4000CardMibBean card = (BBS4000CardMibBean) fSlotList.get(i);
        				if (card != null) {
        					if (fModuleType.isEPMModule(card.getUtsEponModuleBoardType())) {
        						cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - EPM");
        					} else if (fModuleType.isGPMModule(card.getUtsEponModuleBoardType())) {
        						cmbModule.addItem(getString("Slot") + " " + card.getUtsEponModuleBoardPhyId() + " - GPM");
        					}
        					else if (fModuleType.isGEMModule(card.getUtsEponModuleBoardType())) {
        						cmbModule.addItem(getString("Slot") + " " +
        								card.getUtsEponModuleBoardPhyId() + " - GEM");
        					}
        				}
        			}
        		}
//        		cmbPort.removeAllItems();
        		cmbLogicalPort.setEnabled(false);
        		//PerformanceStat
        		cmbPerformanceStat.removeAllItems();
        		String[] utsPerformanceStatEthTList = new String[] {
        				getString("utsEthIfHCInOctets"), // 0
        				getString("utsEthIfHCOutOctets"), // 1
        				getString("utsEthIfHCInMulticastPkts"), // 2
        				getString("utsEthIfHCOutMulticastPkts"), // 3
        				getString("utsEthIfHCInBroadcastPkts"), // 4
        				getString("utsEthIfHCOutBroadcastPkts"), // 5
        				getString("utsEthIfHCInUcastPkts"), // 6
        				getString("utsEthIfHCOutUcastPkts"), // 7
        				getString("utsEthIfHCInDiscardedPkts"), // 8
        				getString("utsEthIfHCOutDiscardedPkts"), // 9
        				getString("utsEthIfHCInErrorPkts"), // 10
        				getString("utsEthIfHCOutErrorPkts"), // 11
        				getString("utsEthIfHCAlignmentErrorPkts"), // 12
        				getString("utsEthIfHCFcsErrorPkts"), // 13
        				getString("utsEthIfHCShortPkts"), // 14
        				getString("utsEthIfHCGiantPkts"), // 15
        				getString("utsEthIfHCCollisionsPkts"), // 16
        				getString("utsEthIfHCTxPausePkts"), // 17
        				getString("utsEthIfHCRxPausePkts"), // 18
        				getString("utsEthIfHCTx64Pkts"), // 19
        				getString("utsEthIfHCTx65_127Pkts"), // 20
        				getString("utsEthIfHCTx128_255Pkts"), // 21
        				getString("utsEthIfHCTx256_511Pkts"), // 22
        				getString("utsEthIfHCTx512_1023Pkts"), // 23
        				getString("utsEthIfHCTx1024_1518Pkts"), // 24
        				getString("utsEthIfHCTx1519_1522Pkts"), // 25
        				getString("utsEthIfHCTx1523_2047Pkts"), // 26
        				getString("utsEthIfHCRx64Pkts"), // 27
        				getString("utsEthIfHCRx65_127Pkts"), // 28
        				getString("utsEthIfHCRx128_255Pkts"), // 29
        				getString("utsEthIfHCRx256_511Pkts"), // 30
        				getString("utsEthIfHCRx512_1023Pkts"), // 31
        				getString("utsEthIfHCRx1024_1518Pkts"), // 32
        				getString("utsEthIfHCRx1519_1522Pkts"), // 33
        				getString("utsEthIfHCRx1523_2047Pkts"), // 34
        				getString("utsEthIfHCTxPpsPkts"), // 35
        				getString("utsEthIfHCRxPpsPkts"), // 36
        				getString("utsEthIfHCTxBpsPkts"), // 37
        				getString("utsEthIfHCRxBpsPkts"), // 38
        				getString("utsEthIfHCTxPeakPkts"), // 39
        				getString("utsEthIfHCRxPeakPkts"), // 40
        		};
        		for (int i = 0; i < utsPerformanceStatEthTList.length; i++) {
        			cmbPerformanceStat.addItem(utsPerformanceStatEthTList[i]);
        		}
        		break;
        		
        	default:
        		break;
        	}
			
		}
        
//        if (cmbModule.getSelectedIndex() == 0) {
//            if (cmbPort.getItemCount() > 0) {
//                cmbPort.setSelectedIndex(0);
//                cmbPort.setEnabled(false);
//            }
//        } else {
//            cmbPort.setEnabled(true);
//        }
//        if (cmbPort.getSelectedIndex() == 0) {
//            if (cmbLogicalPort.getItemCount() > 0) {
//                cmbLogicalPort.setSelectedIndex(0);
//                cmbLogicalPort.setEnabled(false);
//            }
//        } else {
//            cmbLogicalPort.setEnabled(true);
//        }
    }

    public void setSelectedOnu(String string) {
        String[] split = string.split("-");

        // 1. set slot
        int itemCount = cmbModule.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) cmbModule.getItemAt(i);
            if (item.startsWith(getString("Slot") + " " + split[0] + " -")) {
                cmbModule.setSelectedIndex(i);
            }
        }

        itemCount = cmbPort.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) cmbPort.getItemAt(i);
            if (item.startsWith(getString("Port") + " " + split[1])) {
                cmbPort.setSelectedIndex(i);
            }
        }

        itemCount = cmbLogicalPort.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            String item = (String) cmbLogicalPort.getItemAt(i);
            if (item.startsWith(getString("ONU") + " " + split[2])) {
                cmbLogicalPort.setSelectedIndex(i);
                return;
            }
        }
    }

    public String getString(String s) {
        return (s == null || s.length() <= 0) ? s : fStringMap != null ? fStringMap.getString(s) : s;
    }

}