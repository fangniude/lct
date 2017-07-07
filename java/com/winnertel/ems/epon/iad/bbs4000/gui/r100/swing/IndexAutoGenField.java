package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.util.gui.input.LongTextField;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class IndexAutoGenField implements ActionListener, FocusListener {

    private LongTextField[] indexFields;
    private JCheckBox[] isAutos;
    private JPanel[] panes;
    private IApplication fApplication;
    private SnmpTable fTable;
    private int number;
    private long[][] indexFieldsValueScope;
    private boolean ignoreCurrent = false;

    public IndexAutoGenField(IApplication app, int number) {
	fApplication = app;
	this.number = number;
	init();
    }

    private void init() {
	indexFields = new LongTextField[number];
	isAutos = new JCheckBox[number];
	panes = new JPanel[number];
	indexFieldsValueScope = new long[number][2];
	NTLayout layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.LEFT, 5, 5);
	for (int i = 0; i < number; i++) {
	    panes[i] = new JPanel();
	    panes[i].setLayout(layout);
	    indexFields[i] = new LongTextField();
	    isAutos[i] = new JCheckBox();
	    isAutos[i].setText(fApplication.getActiveDeviceManager().getGuiComposer().getString("Generate Automatically"));
	    isAutos[i].addActionListener(this);
	    isAutos[i].setSelected(true);
	    indexFields[i].setEditable(false);
	    indexFields[i].addFocusListener(this);
	    panes[i].add(indexFields[i]);
	    panes[i].add(isAutos[i]);

	    indexFieldsValueScope[i] = new long[2];
	    refresh();
	}

    }

    public JPanel getIndexPanel(int offset) {
	return panes[offset];
    }

    public void refresh() {
	if (fTable != null) {
	    generateValue(0);
	}
    }

    private boolean generateValue(int offset) {

	if (offset == number) { // the last index + 1
	    return !isExist();
	}

	if (!isAutos[offset].isSelected()) {// not auto
	    return generateValue(offset + 1);
	} else {// auto increase

	    long currentValue = indexFields[offset].getValue();

	    long nextValue = currentValue;

	    if (ignoreCurrent && offset == number - 1) {// if ignore current value
		nextValue++;
		ignoreCurrent = false;
	    }

	    while (nextValue <= indexFieldsValueScope[offset][1]) {// from the current value to the max
		indexFields[offset].setValue(nextValue);
		if (generateValue(offset + 1)) {// if has increased
		    return true;
		} else {
		    nextValue++;
		}
	    }

	    nextValue = indexFieldsValueScope[offset][0];// back to the min value

	    while (nextValue < currentValue) {// find to the current value
		indexFields[offset].setValue(nextValue);
		if (generateValue(offset + 1)) {// if has increased
		    return true;
		} else {
		    nextValue++;
		}
	    }

	    // the field has full, set it's value to min
	    indexFields[offset].setValue(indexFieldsValueScope[offset][0]);
	    return false;
	}

    }

    /**
     * if the current index is exist in table, return true
     * 
     * @return
     */
    private boolean isExist() {
	SnmpTableModel model = (SnmpTableModel) fTable.getModel();
	for (int i = 0; i < model.getRowCount(); i++) {// iterator all records in the table
	    SnmpMibBean bean = model.getRow(i);
	    int j;
	    for (j = 0; j < number; j++) {
		if (bean.getIndex(j) == null || Long.valueOf(bean.getIndex(j).toString()) != indexFields[j].getValue()) {
		    // if one index is not equal to the record
		    break;
		}
	    }
	    if (j == number) {// all index are equal to the record
		return true;
	    }
	}
	return false;
    }

    public void increaseIndexValue() {
	ignoreCurrent = true;
	refresh();
    }

    public long getValue(int offset) {
	return indexFields[offset].getValue();
    }

    public void setTable(SnmpTable aTable) {
	fTable = aTable;
    }

    public void setValue(int offset, long aValue) {
	indexFields[offset].setValue(aValue);
    }

    public void setEnabled(boolean isEnable) {
	for (int i = 0; i < number; i++) {
	    isAutos[i].setEnabled(isEnable);
	    indexFields[i].setEnabled(isEnable);
	}
    }

    public boolean isEnabled() {
	for (int i = 0; i < number; i++)
	    if (!isAutos[i].isEnabled() || !indexFields[i].isEnabled())
		return false;
	return true;
    }

    public void setValueScope(int offset, long min, long max) {
	indexFields[offset].setValueScope(min, max);
	indexFieldsValueScope[offset][0] = min;
	indexFieldsValueScope[offset][1] = max;
    }

    public void actionPerformed(ActionEvent e) {
	JCheckBox isAuto = (JCheckBox) e.getSource();
	int offset = 0;
	for (int i = 0; i < number; i++) {
	    if (isAuto == isAutos[i])
		offset = i;
	}
	indexFields[offset].setEditable(!isAutos[offset].isSelected());
	for (int j = offset; j < number; j++) {
	    if (isAutos[j].isSelected()) {
		refresh();
	    }
	}
    }

    public void focusGained(FocusEvent e) {

    }

    public void focusLost(FocusEvent e) {
	refresh();
    }
}
