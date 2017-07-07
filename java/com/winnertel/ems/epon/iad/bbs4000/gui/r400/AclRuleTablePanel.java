/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.AclRuleTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IPAddressField;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.MacAddressField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AclRuleTablePanel extends UPanel {

    private IntegerTextField tfAclRuleIndex = new IntegerTextField();

    private JCheckBox cbMatchedSourseMac = new JCheckBox();
    private MacAddressField tfMatchedSourseMac = new MacAddressField();

    private JCheckBox cbMatchedDestinationMac = new JCheckBox();
    private MacAddressField tfMatchedDestinationMac = new MacAddressField();

    private JCheckBox cbMatchedVlanId = new JCheckBox();
    private IntegerTextField tfMatchedVlanId = new IntegerTextField();

    private JCheckBox cbMatchedEthernetType = new JCheckBox();
    private IntegerTextField tfMatchedEthernetType = new IntegerTextField();

    private JCheckBox cbMatchedSourseIP = new JCheckBox();
    private IPAddressField tfMatchedSourseIP = new IPAddressField();

    private JCheckBox cbMatchedDestinationIP = new JCheckBox();
    private IPAddressField tfMatchedDestinationIP = new IPAddressField();

    private JCheckBox cbMatchedIpMessageType = new JCheckBox();
    private IntegerTextField tfMatchedIpMessageType = new IntegerTextField();

    private JCheckBox cbMatchedDscp = new JCheckBox();
    private IntegerTextField tfMatchedDscp = new IntegerTextField();

    private JCheckBox cbMatchedSoursePort = new JCheckBox();
    private IntegerTextField tfMatchedSoursePort = new IntegerTextField();

    private JCheckBox cbMatchedDestinationPort = new JCheckBox();
    private IntegerTextField tfMatchedDestinationPort = new IntegerTextField();

/*
    //private StringTextField tfMatchedFieldSelection = new StringTextField();
    //value: 0 ~ 9
    private String[] matchedFieldSelectionVList = null;
    private JComboBox[] tfMatchedFieldSelection = null;
*/

    private int[] aclActionVList = new int[]{1, 2, 3,};
    private String[] aclActionTList = new String[]{
            fStringMap.getString("permit"), //1
            fStringMap.getString("deny"), //2
            fStringMap.getString("mark"), //3
    };
    private JComboBox tfAclAction = new JComboBox(aclActionTList);

    private int[] aclActionParameterTypeVList = new int[]{1, 2, 3, 4,};
    private String[] aclActionParameterTypeTList = new String[]{
            fStringMap.getString("801.1p"), //1
            fStringMap.getString("VLAN ID"), //2
            fStringMap.getString("TOS PRECEDENCE"), //3
            fStringMap.getString("DSCP"), //4
    };
    private JComboBox tfAclActionParameterType = new JComboBox(aclActionParameterTypeTList);
    private IntegerTextField tfAclActionParameterValue = new IntegerTextField();

    private final String aclRuleIndex = fStringMap.getString("aclRuleIndex") + " : ";
    private final String matchedSourseMac = fStringMap.getString("matchedSourseMac") + " : ";
    private final String matchedDestinationMac = fStringMap.getString("matchedDestinationMac") + " : ";
    private final String matchedVlanId = fStringMap.getString("matchedVlanId") + " : ";
    private final String matchedEthernetType = fStringMap.getString("matchedEthernetType") + " : ";
    private final String matchedSourseIP = fStringMap.getString("matchedSourseIP") + " : ";
    private final String matchedDestinationIP = fStringMap.getString("matchedDestinationIP") + " : ";
    private final String matchedIpMessageType = fStringMap.getString("matchedIpMessageType") + " : ";
    private final String matchedDscp = fStringMap.getString("matchedDscp") + " : ";
    private final String matchedSoursePort = fStringMap.getString("matchedSoursePort") + " : ";
    private final String matchedDestinationPort = fStringMap.getString("matchedDestinationPort") + " : ";
    //private final String matchedFieldSelection = fStringMap.getString("matchedFieldSelection") + " : ";
    private final String aclAction = fStringMap.getString("aclAction") + " : ";
    private final String aclActionParameter = fStringMap.getString("aclActionParameter") + " : ";
    private final String aclActionParameterType = fStringMap.getString("aclActionParameterType") + " : ";
    private final String aclActionParameterValue = fStringMap.getString("aclActionParameterValue") + " : ";

    public AclRuleTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(11, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(aclRuleIndex));
        tfAclRuleIndex.setName(fStringMap.getString("aclRuleIndex"));
        baseInfoPanel.add(tfAclRuleIndex);
        baseInfoPanel.add(new HSpacer());

        cbMatchedSourseMac.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedSourseMac.setEnabled(cbMatchedSourseMac.isSelected());
            }
        });
        cbMatchedSourseMac.setText(matchedSourseMac);
        tfMatchedSourseMac.setEnabled(false);
        baseInfoPanel.add(cbMatchedSourseMac);
        tfMatchedSourseMac.setName(fStringMap.getString("matchedSourseMac"));
        baseInfoPanel.add(tfMatchedSourseMac);
        baseInfoPanel.add(new HSpacer());

        cbMatchedDestinationMac.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedDestinationMac.setEnabled(cbMatchedDestinationMac.isSelected());
            }
        });
        cbMatchedDestinationMac.setText(matchedDestinationMac);
        tfMatchedDestinationMac.setEnabled(false);
        baseInfoPanel.add(cbMatchedDestinationMac);
        tfMatchedDestinationMac.setName(fStringMap.getString("matchedDestinationMac"));
        baseInfoPanel.add(tfMatchedDestinationMac);
        baseInfoPanel.add(new HSpacer());

        cbMatchedVlanId.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedVlanId.setEnabled(cbMatchedVlanId.isSelected());
            }
        });
        cbMatchedVlanId.setText(matchedVlanId);
        tfMatchedVlanId.setEnabled(false);
        baseInfoPanel.add(cbMatchedVlanId);
        tfMatchedVlanId.setName(fStringMap.getString("matchedVlanId"));
        baseInfoPanel.add(tfMatchedVlanId);
        baseInfoPanel.add(new HSpacer());

        cbMatchedEthernetType.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedEthernetType.setEnabled(cbMatchedEthernetType.isSelected());
            }
        });
        cbMatchedEthernetType.setText(matchedEthernetType);
        tfMatchedEthernetType.setEnabled(false);
        baseInfoPanel.add(cbMatchedEthernetType);
        tfMatchedEthernetType.setName(fStringMap.getString("matchedEthernetType"));
        baseInfoPanel.add(tfMatchedEthernetType);
        baseInfoPanel.add(new HSpacer());

        cbMatchedSourseIP.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedSourseIP.setEnabled(cbMatchedSourseIP.isSelected());
            }
        });
        cbMatchedSourseIP.setText(matchedSourseIP);
        tfMatchedSourseIP.setEnabled(false);
        baseInfoPanel.add(cbMatchedSourseIP);
        tfMatchedSourseIP.setName(fStringMap.getString("matchedSourseIP"));
        baseInfoPanel.add(tfMatchedSourseIP);
        baseInfoPanel.add(new HSpacer());

        cbMatchedDestinationIP.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedDestinationIP.setEnabled(cbMatchedDestinationIP.isSelected());
            }
        });
        cbMatchedDestinationIP.setText(matchedDestinationIP);
        tfMatchedDestinationIP.setEnabled(false);
        baseInfoPanel.add(cbMatchedDestinationIP);
        tfMatchedDestinationIP.setName(fStringMap.getString("matchedDestinationIP"));
        baseInfoPanel.add(tfMatchedDestinationIP);
        baseInfoPanel.add(new HSpacer());

        cbMatchedIpMessageType.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedIpMessageType.setEnabled(cbMatchedIpMessageType.isSelected());
            }
        });
        cbMatchedIpMessageType.setText(matchedIpMessageType);
        tfMatchedIpMessageType.setEnabled(false);
        baseInfoPanel.add(cbMatchedIpMessageType);
        tfMatchedIpMessageType.setName(fStringMap.getString("matchedIpMessageType"));
        baseInfoPanel.add(tfMatchedIpMessageType);
        baseInfoPanel.add(new HSpacer());

        cbMatchedDscp.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedDscp.setEnabled(cbMatchedDscp.isSelected());
            }
        });
        cbMatchedDscp.setText(matchedDscp);
        tfMatchedDscp.setEnabled(false);
        baseInfoPanel.add(cbMatchedDscp);
        tfMatchedDscp.setName(fStringMap.getString("matchedDscp"));
        baseInfoPanel.add(tfMatchedDscp);
        baseInfoPanel.add(new HSpacer());

        cbMatchedSoursePort.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedSoursePort.setEnabled(cbMatchedSoursePort.isSelected());
            }
        });
        cbMatchedSoursePort.setText(matchedSoursePort);
        tfMatchedSoursePort.setEnabled(false);
        baseInfoPanel.add(cbMatchedSoursePort);
        tfMatchedSoursePort.setName(fStringMap.getString("matchedSoursePort"));
        baseInfoPanel.add(tfMatchedSoursePort);
        baseInfoPanel.add(new HSpacer());

        cbMatchedDestinationPort.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tfMatchedDestinationPort.setEnabled(cbMatchedDestinationPort.isSelected());
            }
        });
        cbMatchedDestinationPort.setText(matchedDestinationPort);
        tfMatchedDestinationPort.setEnabled(false);
        baseInfoPanel.add(cbMatchedDestinationPort);
        tfMatchedDestinationPort.setName(fStringMap.getString("matchedDestinationPort"));
        baseInfoPanel.add(tfMatchedDestinationPort);
        baseInfoPanel.add(new HSpacer());

        //baseInfoPanel.add(new JLabel(matchedFieldSelection));
        //tfMatchedFieldSelection.setName(fStringMap.getString("matchedFieldSelection"));
        //baseInfoPanel.add(tfMatchedFieldSelection);
        //baseInfoPanel.add(new HSpacer());

/*
        JPanel matchedFieldSelectionPanel = new JPanel();
        NTLayout layout3 = new NTLayout(5, 6, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout3.setMargins(6, 10, 6, 10);
        matchedFieldSelectionPanel.setLayout(layout3);
        matchedFieldSelectionPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(matchedFieldSelection)));

        matchedFieldSelectionVList = new String[10];
        for (int i = 0; i < matchedFieldSelectionVList.length; i++) {
            matchedFieldSelectionVList[i] = "" + i;
        }
        tfMatchedFieldSelection = new JComboBox[10];
        for (int i = 0; i < tfMatchedFieldSelection.length; i++) {
            tfMatchedFieldSelection[i] = new JComboBox(matchedFieldSelectionVList);
            String itemName = "";
            switch (i) {
                case 0:
                    itemName = fStringMap.getString("sourceMac");
                    break;
                case 1:
                    itemName = fStringMap.getString("destinationMac");
                    break;
                case 2:
                    itemName = fStringMap.getString("vlanId");
                    break;
                case 3:
                    itemName = fStringMap.getString("etherType");
                    break;
                case 4:
                    itemName = fStringMap.getString("sourceIp");
                    break;
                case 5:
                    itemName = fStringMap.getString("destinationIp");
                    break;
                case 6:
                    itemName = fStringMap.getString("ipProtocolType");
                    break;
                case 7:
                    itemName = fStringMap.getString("dscp");
                    break;
                case 8:
                    itemName = fStringMap.getString("sourceProtocolPort");
                    break;
                case 9:
                    itemName = fStringMap.getString("destinationProtocolPort");
                    break;
                default:
                    itemName = "";
            }
            matchedFieldSelectionPanel.add(new JLabel(itemName));
            matchedFieldSelectionPanel.add(tfMatchedFieldSelection[i]);
            matchedFieldSelectionPanel.add(new HSpacer());
        }
*/

        JPanel aclActionParameterPanel = new JPanel();
        NTLayout layout1 = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout1.setMargins(6, 10, 6, 10);
        aclActionParameterPanel.setLayout(layout1);
        aclActionParameterPanel.setBorder(BorderFactory.createTitledBorder(fStringMap.getString(aclActionParameter)));

        aclActionParameterPanel.add(new JLabel(aclAction));
        tfAclAction.setName(fStringMap.getString("aclAction"));
        aclActionParameterPanel.add(tfAclAction);
        aclActionParameterPanel.add(new HSpacer());

        aclActionParameterPanel.add(new JLabel(aclActionParameterType));
        tfAclActionParameterType.setName(fStringMap.getString("aclActionParameterType"));
        aclActionParameterPanel.add(tfAclActionParameterType);
        aclActionParameterPanel.add(new HSpacer());
        tfAclActionParameterType.setEnabled(false);

        aclActionParameterPanel.add(new JLabel(aclActionParameterValue));
        tfAclActionParameterValue.setName(fStringMap.getString("aclActionParameterValue"));
        aclActionParameterPanel.add(tfAclActionParameterValue);
        aclActionParameterPanel.add(new HSpacer());
        tfAclActionParameterValue.setEnabled(false);

        tfAclAction.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (tfAclAction.getSelectedIndex() == 2) { //mark
                    tfAclActionParameterType.setEnabled(true);
                    tfAclActionParameterValue.setEnabled(true);
                    tfAclActionParameterValue.setValue(0);
                } else {
                    tfAclActionParameterType.setEnabled(false);
                    tfAclActionParameterValue.setEnabled(false);
                }
            }
        });

        tfAclActionParameterType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int markType = tfAclActionParameterType.getSelectedIndex() + 1;
                tfAclActionParameterType.setEnabled(tfAclActionParameterType.isEnabled() && (markType >= 1 && markType <= 4));
                switch (markType) {
                    case 1:
                        tfAclActionParameterValue.setValueScope(0, 7);
                        break;
                    case 2:
                        tfAclActionParameterValue.setValueScope(1, 4094);
                        break;
                    case 3:
                        tfAclActionParameterValue.setValueScope(0, 7);
                        break;
                    case 4:
                        tfAclActionParameterValue.setValueScope(0, 63);
                        break;
                    default:
                        tfAclActionParameterValue.setValue(0);
                }
            }
        });

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(baseInfoPanel);
        //allPanel.add(matchedFieldSelectionPanel);
        allPanel.add(aclActionParameterPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfMatchedIpMessageType.setValueScope(0, 255);
        tfMatchedDscp.setValueScope(0, 63);
    }

    public void refresh() {
        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfAclRuleIndex.setEditable(true);
            return;
        }

        AclRuleTable mbean = (AclRuleTable) getModel();
        if (mbean == null)
            return;

        tfAclRuleIndex.setEditable(false);
        tfAclRuleIndex.setValue(mbean.getAclRuleIndex());

        setMatchedFieldSelection(mbean.getMatchedFieldSelection());

        tfMatchedSourseMac.setValue(mbean.getMatchedSourseMac());
        tfMatchedDestinationMac.setValue(mbean.getMatchedDestinationMac());
        tfMatchedVlanId.setValue(mbean.getMatchedVlanId());
        tfMatchedEthernetType.setValue(mbean.getMatchedEthernetType());
        tfMatchedSourseIP.setValue(mbean.getMatchedSourseIP());
        tfMatchedDestinationIP.setValue(mbean.getMatchedDestinationIP());
        tfMatchedIpMessageType.setValue(mbean.getMatchedIpMessageType());
        tfMatchedDscp.setValue(mbean.getMatchedDscp());
        tfMatchedSoursePort.setValue(mbean.getMatchedSoursePort());
        tfMatchedDestinationPort.setValue(mbean.getMatchedDestinationPort());

        tfAclAction.setSelectedIndex(mbean.getAclAction() - 1);

        byte[] actionParameter = mbean.getAclActionParameter();
        if (mbean.getAclAction() == 3 && actionParameter != null && actionParameter.length > 0) {                
            tfAclActionParameterType.setSelectedIndex(actionParameter[0] - 1);
            int value = actionParameter[3] * 256 + actionParameter[4];
            tfAclActionParameterValue.setValue(value);
        }
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new AclRuleTable(fApplication.getSnmpProxy()));

        AclRuleTable mbean = (AclRuleTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            mbean.setAclRuleIndex(new Integer(tfAclRuleIndex.getValue()));
        }

        if (cbMatchedSourseMac.isSelected())
            mbean.setMatchedSourseMac(tfMatchedSourseMac.getValue());
        if (cbMatchedDestinationMac.isSelected())
            mbean.setMatchedDestinationMac(tfMatchedDestinationMac.getValue());
        if (cbMatchedVlanId.isSelected())
            mbean.setMatchedVlanId(new Integer(tfMatchedVlanId.getValue()));
        if (cbMatchedEthernetType.isSelected())
            mbean.setMatchedEthernetType(new Integer(tfMatchedEthernetType.getValue()));
        if (cbMatchedSourseIP.isSelected())
            mbean.setMatchedSourseIP(tfMatchedSourseIP.getIPString());
        if (cbMatchedDestinationIP.isSelected())
            mbean.setMatchedDestinationIP(tfMatchedDestinationIP.getIPString());
        if (cbMatchedIpMessageType.isSelected())
            mbean.setMatchedIpMessageType(new Integer(tfMatchedIpMessageType.getValue()));
        if (cbMatchedDscp.isSelected())
            mbean.setMatchedDscp(new Integer(tfMatchedDscp.getValue()));
        if (cbMatchedSoursePort.isSelected())
            mbean.setMatchedSoursePort(new Integer(tfMatchedSoursePort.getValue()));
        if (cbMatchedDestinationPort.isSelected())
            mbean.setMatchedDestinationPort(new Integer(tfMatchedDestinationPort.getValue()));

        mbean.setMatchedFieldSelection(getMatchedFieldSelection());

        mbean.setAclAction(new Integer(aclActionVList[tfAclAction.getSelectedIndex()]));
        if (tfAclAction.getSelectedIndex() == 2) //mark
            mbean.setAclActionParameter(getAclActionParameter());
    }

    private byte[] getAclActionParameter() {
        //
        //  Description:
        //        ACL����������ֻ��aclActionΪmaerk(3)��Ч������aclAction����ֵ��
        //        �˶����ֹ���ã�getʱ����NULL��
        //
        //        ����INTERNET˳��������ҵķ������У���һ��ΪOCTET0����n��ΪOCTET
        //        [n-1]��
        //
        //        OCTET 0 ��ʾ MARK ���͡������OCTET ��ʾ�������͵�MARK��Ŀ��ֵ����
        //        �Ƿ���ЩOCTET�ĳ���ȡ����MARK���ͣ������Ӧ�ڸ�MARK���͵Ĳ����SYNTAX
        //        ΪINTEGER������Ҫ4���ֽڣ���ʾ��Ӧ����ֵ��
        //
        //        MARK����		Ŀ��ֵ��SYNTAX				����
        //        -------------------------------------------------------------------
        //        0					                    Reserved
        //        1               INTEGER	(0..7)			MARK 801.1p��ֵ�����VLAN��
        //        2				INTEGER	(1..4094)		MARK VLAN ID�����VLAN��
        //        3				INTEGER	(0..7)			MARK TOS PRECEDENCE
        //        4				INTEGER	(0..63)			MARK DSCP
        //        5..255				                    Reserved
        //
        //        �����޸�VLAN IDΪ100����Ӧ��ֵΪ��02 00 00 00 64
        //

        if (tfAclActionParameterType.isEnabled() && tfAclActionParameterValue.isEnabled()) {
            byte[] actionParameter = new byte[5];
            for (int i = 0; i < actionParameter.length; i++)
                actionParameter[i] = 0x00;
            int markType = aclActionParameterTypeVList[tfAclActionParameterType.getSelectedIndex()];
            switch (markType) {
                case 1:
                    actionParameter[0] = 0x01;
                    break;
                case 2:
                    actionParameter[0] = 0x02;
                    break;
                case 3:
                    actionParameter[0] = 0x03;
                    break;
                case 4:
                    actionParameter[0] = 0x04;
                    break;
            }
            int markValue = tfAclActionParameterValue.getValue();
            actionParameter[3] = new Integer(markValue / 256).byteValue();
            actionParameter[4] = new Integer(markValue % 256).byteValue();

            return actionParameter;
        }

        return null;
    }

    private byte[] getMatchedFieldSelection() {
        byte[] data = new byte[4];

        if (data.length >= 4) {
            if (cbMatchedSourseMac.isSelected())
                data[0] += 0x80; //sourseMac: 0x80
            if (cbMatchedDestinationMac.isSelected())
                data[0] += 0x40; //destinationMac: 0x40
            if (cbMatchedVlanId.isSelected())
                data[0] += 0x20; //vlanId: 0x20
            if (cbMatchedEthernetType.isSelected())
                data[0] += 0x10; //ethernetType: 0x10
            if (cbMatchedSourseIP.isSelected())
                data[0] += 0x08; //sourceIp: 0x08
            if (cbMatchedDestinationIP.isSelected())
                data[0] += 0x04; //destinationIp: 0x04
            if (cbMatchedIpMessageType.isSelected())
                data[0] += 0x02; //ipMessageType: 0x02
            if (cbMatchedDscp.isSelected())
                data[0] += 0x01; //dscp: 0x01
            if (cbMatchedSoursePort.isSelected())
                data[1] += 0x80; //soursePort: 0x00 0x80
            if (cbMatchedDestinationPort.isSelected())
                data[1] += 0x40; //destinationPort: 0x00 0x40
        }

        return data;
    }

    private void setMatchedFieldSelection(byte[] data) {
        if (data != null && data.length >= 4) {
            cbMatchedSourseMac.setSelected((data[0] & 0x80) != 0);
            cbMatchedDestinationMac.setSelected((data[0] & 0x40) != 0);
            cbMatchedVlanId.setSelected((data[0] & 0x20) != 0);
            cbMatchedEthernetType.setSelected((data[0] & 0x10) != 0);
            cbMatchedSourseIP.setSelected((data[0] & 0x08) != 0);
            cbMatchedDestinationIP.setSelected((data[0] & 0x04) != 0);
            cbMatchedIpMessageType.setSelected((data[0] & 0x02) != 0);
            cbMatchedDscp.setSelected((data[0] & 0x01) != 0);
            cbMatchedSoursePort.setSelected((data[1] & 0x80) != 0);
            cbMatchedDestinationPort.setSelected((data[1] & 0x40) != 0);
        }
    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}