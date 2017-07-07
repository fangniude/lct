package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.input.LongTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LongIndexGenField extends JPanel {
	private LongTextField indexField = new LongTextField();
	private JCheckBox isAuto = new JCheckBox();
	private IApplication fApplication;
	private SnmpTable fTable;
	private int offset;
	private Long[] index_value;
	
	public LongIndexGenField(IApplication app){
	    fApplication = app;
		init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		indexField.setValueScope(0, Long.MAX_VALUE);
	    this.add(indexField, BorderLayout.CENTER);
	    this.add(isAuto, BorderLayout.EAST);
	    isAuto.setText(fApplication.getActiveDeviceManager().getGuiComposer().getString("Generate Automatically"));
		isAuto.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			    indexField.setEditable(!isAuto.isSelected());
			}
		});
		indexField.setEditable(false);
		isAuto.setSelected(true);
	}
	
	public long getValue(int offset, Object[] index1_value){
	    if(isAuto.isSelected() && fTable != null) {
	        long max = 0;
	        SnmpTableModel model = (SnmpTableModel)fTable.getModel();
	        for(int i = 0; i < model.getRowCount(); i++) {
	            SnmpMibBean bean = model.getRow(i);
	            
	            boolean same = true;
	            for(int j = 0; index1_value != null && j < index1_value.length; j++) {
	                if(bean.getIndex(j) == null || !bean.getIndex(j).equals(index1_value[j])) {
	                    same = false;
	                    break;
	                }
	            }
	            
	            if(same) {
	                Long v = (Long)bean.getIndex(offset);
	                if(v > max) max = v;
	            }
	        }
	        return max+1;
	    } else {
	        return indexField.getValue();
	    }
	}
	
	public void setTable(SnmpTable aTable) {
	    fTable = aTable;
	}
	
	public void setValue(long aValue){
		indexField.setValue(aValue);
	}
	
	public void setEnabled(boolean isEnable){
		isAuto.setEnabled(isEnable);
		indexField.setEnabled(isEnable);
	}
	
	public boolean isEnabled(){
		return isAuto.isEnabled();
	}
	
	public void setValueScope(long min, long max) {
	    indexField.setValueScope(min, max);
	}
	
	public static void main(String[] args){
		
	}
	
	
}
