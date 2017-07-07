package com.winnertel.ems.epon.iad.bbs4000.gui.r100.swing;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.action.BaseAction;
import com.winnertel.em.framework.gui.action.BaseChecker;
import com.winnertel.em.framework.gui.swing.UDialog;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.model.snmp.SnmpMibBean;
import com.winnertel.em.framework.resource.IResourceManager;
import com.winnertel.em.standard.Application;
import com.winnertel.em.standard.gui.util.InstanceCreator;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.snmp.gui.SnmpDialog;
import com.winnertel.em.standard.snmp.gui.SnmpField;
import com.winnertel.em.standard.snmp.gui.SnmpFieldReference;
import com.winnertel.em.standard.snmp.gui.SnmpTable;
import com.winnertel.em.standard.snmp.gui.SnmpTableButton;
import com.winnertel.em.standard.snmp.gui.SnmpTableModel;
import com.winnertel.em.standard.snmp.gui.SnmpTablePane;
import org.jdom.Element;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ViewComposer {
    protected IApplication fApplication;
    protected IResourceManager fResourceManager = null;
    protected Map fSnmpFieldCache = null;
    protected Map fStringCache = new HashMap();

    public ViewComposer(IApplication app) {
        fApplication = app;
        fResourceManager = fApplication.getActiveDeviceManager().getResourceManager();
        fSnmpFieldCache = fResourceManager.loadSnmpFieldMap();
        fStringCache = fResourceManager.loadStringMap();
    }

    public IconSnmpTablePane composeIconSnmpTablePane(String aName, Window win) {
        //the aName is the id, not bind locale
        Element ePanel = fResourceManager.loadTablePane(aName);
        Element eTable = ePanel.getChild("Table");
        String mibBeanClazz = eTable.getAttributeValue("mib_bean");
        SnmpMibBean bean = null;
        if (mibBeanClazz == null) {
            Element eMibBean = eTable.getChild("MibBean");
            mibBeanClazz = eMibBean.getAttributeValue("class");
        }

        bean = InstanceCreator.instantiateSnmpMibBean(fApplication.getSnmpProxy(), mibBeanClazz);

        String filterClazz = eTable.getAttributeValue("filter");
        String sMarkable = eTable.getAttributeValue("markable");
        boolean markable = false;
        if ("true".equals(sMarkable)) {
            markable = true;
        }

        // parse and set field list
        java.util.List fieldList = eTable.getChildren("Field");
        Vector vField = new Vector(fieldList.size());
        Iterator itField = fieldList.iterator();
        while (itField.hasNext()) {
            Element eField = (Element) itField.next();
            //these fields are always displayed as english
            String name = eField.getAttributeValue("name");
            String mibProperty = eField.getAttributeValue("mib_property");
            SnmpField field = (SnmpField) fSnmpFieldCache.get(name);
            translateFieldStrings(field);
            field.setMibProperty(mibProperty);

            // load field reference
            SnmpFieldReference ref = null;
            Element eRef = eField.getChild("Reference");
            if (eRef != null) {
                String mbeanClazz = eRef.getAttributeValue("mib_bean");
                String mibProp = eRef.getAttributeValue("mib_property");
                SnmpMibBean snmpMBean = InstanceCreator.instantiateSnmpMibBean(fApplication.getSnmpProxy(),
                    mbeanClazz);
                ref = new SnmpFieldReference(snmpMBean, mibProp);

                java.util.List conditionList = eRef.getChildren("Condition");
                Iterator itCondition = conditionList.iterator();
                while (itCondition.hasNext()) {
                    Element eCondtion = (Element) itCondition.next();
                    ref.addConditionItem(eCondtion.getAttributeValue("mib_property"),
                        eCondtion.getAttributeValue("ref_mib_property"));
                }
                field.setReference(ref);
            }
            vField.add(field);
        }

        final IconSnmpTablePane tablePane = new IconSnmpTablePane(fApplication);
        SnmpTable table = new SnmpTable(new SnmpTableModel(vField, bean, InstanceCreator.instantiateFilter(filterClazz), markable));
        tablePane.setTable(table);
        tablePane.setName(aName);
        if ("true".equals(eTable.getAttributeValue("multiple_selection"))) {
            table.setMultipleSelection(true);
        }

        Element eIdFormatter = eTable.getChild("MibBeanIdFormatter");
        if (eIdFormatter != null) {
            String className = eIdFormatter.getAttributeValue("class");
            String pattern = eIdFormatter.getAttributeValue("pattern");
            table.setRowIdFormatter(InstanceCreator.instantiateIdFormatter(fApplication, className, pattern));
        }

        // parse and set button list
        List buttonList = ePanel.getChildren("Button");
        Vector vButton = new Vector(buttonList.size());
        Iterator itButton = buttonList.iterator();
        boolean bConfigClose = false;
        while (itButton.hasNext()) {
            Element eButton = (Element) itButton.next();
            String id = eButton.getAttributeValue("id");
            String type = eButton.getAttributeValue("type");
            String text = eButton.getAttributeValue("text");
            String checker = eButton.getAttributeValue("business_checker");
            if (text == null) {
                text = type;
            }
            text = getString(text);
            String panelClazz = eButton.getAttributeValue("panel");
            String sTyle = eButton.getAttributeValue("style");
            String panelActionId = null;
            String panelTitle = null;
            if (panelClazz == null) {
                Element ePanel2 = eButton.getChild("Panel");
                if (ePanel2 != null) {
                    panelActionId = ePanel2.getAttributeValue("action_id");
                    panelClazz = ePanel2.getAttributeValue("class");
                    panelTitle = ePanel2.getAttributeValue("title");
                }
            }
            String dialogClazz = eButton.getAttributeValue("dialog");
            Element eAction = eButton.getChild("Action");
            String clazzName = null;
            if (eAction != null) {
                clazzName = eAction.getAttributeValue("class");
                id = eAction.getAttributeValue("id");
            }
            String visibleValue = eButton.getAttributeValue("visible");
            boolean bVisible = true;
            if (visibleValue != null && visibleValue.equalsIgnoreCase("false")) {
                bVisible = false;
            }
            if (SnmpAction.IType.CLOSE.equalsIgnoreCase(type)) {
                bConfigClose = true;
            }
            if (!bVisible) {
                continue;
            }
            SnmpAction act = createSnmpTableAction(id, type, clazzName, checker);
            SnmpTableButton btn = new SnmpTableButton(type, text, act);
            UPanel panel = InstanceCreator.instantiatePanel(fApplication, panelClazz);
            UDialog dlg = null;
            if (panel != null) {
                panel.setCommand(type);
                panel.setTable(table);
                if (SnmpAction.IType.ADD.equals(type) || SnmpAction.IType.MODIFY.equals(type)) {
                    //SnmpApplyButton applyButton = new SnmpApplyButton( fApplication, panel );
                    //applyButton.getAction().putValue( BaseAction.ID, panelActionId );
                    String title = fApplication.getGlobalStringMap().getString(type);
                    if(sTyle == null) sTyle = "O|C";
                    dlg = new SnmpDialog(win, fApplication, title, type, sTyle);
                    //( ( SnmpDialog ) dlg ).setApplyButton( applyButton );
                    ((SnmpDialog) dlg).setApplyId(panelActionId);
                    ((SnmpDialog) dlg).setTable(table);
                    //setPanel must be the end step
                    ((SnmpDialog) dlg).setPanel(panel);
                }
            } else if (SnmpAction.IType.EXPORT.equals(type)) {
                act.setTable(table);
            } else {
                dlg = InstanceCreator.instantiateDialog(fApplication, dialogClazz);
            }
            if (panelTitle != null) {
                dlg.setTitle(getString(panelTitle));
            }
            btn.setDialog(dlg);
            vButton.add(btn);
        }
        if (fApplication.getGUIStyle() == Application.EMBEDDED_STYLE) {
            tablePane.setButtonList(vButton);
        } else {
            tablePane.setButtonList(vButton);
        }

        return tablePane;
    }

    private SnmpAction createSnmpTableAction(String id, String type, String clazzName, String depend) {
        if (clazzName == null || clazzName.length() == 0) {
            if (type.equals(SnmpAction.IType.ADD)) {
                clazzName = SnmpAction.IAction.ADD;
            } else if (type.equals(SnmpAction.IType.MODIFY)) {
                clazzName = SnmpAction.IAction.MODIFY;
            } else if (type.equals(SnmpAction.IType.DELETE)) {
                clazzName = SnmpAction.IAction.DELETE;
            } else if (type.equals(SnmpAction.IType.REFRESH)) {
                clazzName = SnmpAction.IAction.REFRESH;
            } else if (type.equalsIgnoreCase(SnmpAction.IType.CLOSE)) {
                clazzName = SnmpAction.IAction.CLOSE;
            } else if (type.equals(SnmpAction.IType.EXPORT)) {
                clazzName = SnmpAction.IAction.EXPORT;
            }
        }

        return createSnmpActionInstance(id, type, clazzName, depend);
    }

    private SnmpAction createSnmpActionInstance(String anId, String aName, String aClazzName, String aChecker) {
        SnmpAction result = (SnmpAction) createActionInstance(anId, aName, aClazzName);
        if (result != null) {
            if (aChecker != null) {
                BaseChecker tChecker = InstanceCreator.instantiateCheker(fApplication, aChecker);
                if (tChecker != null) {
                    result.setChecker(tChecker);
                }
            }
        }
        return result;
    }

    private BaseAction createActionInstance(String anId, String aName, String aClazzName) {
        BaseAction result = InstanceCreator.instantiateBaseAction(fApplication, aClazzName);
        if (result != null) {
            setActionProperties(result, anId, aName);
        }
        return result;
    }

    private void setActionProperties(BaseAction aResult, String anId, String aName) {
        if (anId != null) {
            aResult.putValue(BaseAction.ID, anId);
        }
        if (aName != null) {
            aResult.putValue(BaseAction.NAME, aName);
        }
    }

    public SnmpTablePane composeSnmpTablePane(String aName) {
        //the aName is the id, not bind locale
        Element ePanel = fResourceManager.loadTablePane(aName);
        Element eTable = ePanel.getChild("Table");
        String mibBeanClazz = eTable.getAttributeValue("mib_bean");
        SnmpMibBean bean = null;
        if (mibBeanClazz == null) {
            Element eMibBean = eTable.getChild("MibBean");
            mibBeanClazz = eMibBean.getAttributeValue("class");
        }

        bean = InstanceCreator.instantiateSnmpMibBean(fApplication.getSnmpProxy(), mibBeanClazz);

        String filterClazz = eTable.getAttributeValue("filter");
        String sMarkable = eTable.getAttributeValue("markable");
        boolean markable = false;
        if ("true".equals(sMarkable)) {
            markable = true;
        }

        // parse and set field list
        java.util.List fieldList = eTable.getChildren("Field");
        Vector vField = new Vector(fieldList.size());
        Iterator itField = fieldList.iterator();
        while (itField.hasNext()) {
            Element eField = (Element) itField.next();
            //these fields are always displayed as english
            String name = eField.getAttributeValue("name");
            String mibProperty = eField.getAttributeValue("mib_property");
            SnmpField field = (SnmpField) fSnmpFieldCache.get(name);
            translateFieldStrings(field);
            field.setMibProperty(mibProperty);

            // load field reference
            SnmpFieldReference ref = null;
            Element eRef = eField.getChild("Reference");
            if (eRef != null) {
                String mbeanClazz = eRef.getAttributeValue("mib_bean");
                String mibProp = eRef.getAttributeValue("mib_property");
                SnmpMibBean snmpMBean = InstanceCreator.instantiateSnmpMibBean(fApplication.getSnmpProxy(),
                    mbeanClazz);
                ref = new SnmpFieldReference(snmpMBean, mibProp);

                java.util.List conditionList = eRef.getChildren("Condition");
                Iterator itCondition = conditionList.iterator();
                while (itCondition.hasNext()) {
                    Element eCondtion = (Element) itCondition.next();
                    ref.addConditionItem(eCondtion.getAttributeValue("mib_property"),
                        eCondtion.getAttributeValue("ref_mib_property"));
                }
                field.setReference(ref);
            }
            vField.add(field);
        }

        final SnmpTablePane tablePane = new SnmpTablePane(fApplication);
        SnmpTable table = new SnmpTable(new SnmpTableModel(vField, bean, InstanceCreator.instantiateFilter(filterClazz), markable));
        tablePane.setTable(table);
        tablePane.setName(aName);
        if ("true".equals(eTable.getAttributeValue("multiple_selection"))) {
            table.setMultipleSelection(true);
        }

        Element eIdFormatter = eTable.getChild("MibBeanIdFormatter");
        if (eIdFormatter != null) {
            String className = eIdFormatter.getAttributeValue("class");
            String pattern = eIdFormatter.getAttributeValue("pattern");
            table.setRowIdFormatter(InstanceCreator.instantiateIdFormatter(fApplication, className, pattern));
        }

        return tablePane;
    }

    private void translateFieldStrings(SnmpField aField) {
        if (aField.getLabel() != null) {
            aField.setLabel(getString(aField.getLabel()));
        }

        Map valueMap = aField.getValueMap();
        if (valueMap != null && valueMap.size() > 0) {
            Iterator it = valueMap.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                String value = (String) valueMap.get(key);
                valueMap.put(key, getString(value));
            }
        }
    }

    public String getString(String name) {
        String s = (String) fStringCache.get(name);

        //not found in dvm.
        if (s == null) {
            return fApplication.getGlobalStringMap().getString(name);
        }

        return s;
    }
}
