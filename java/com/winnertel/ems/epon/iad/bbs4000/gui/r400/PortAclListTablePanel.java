/**
 * Created by Zhou Chao, 2010/3/5
 */

package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.AclManagementTable;
import com.winnertel.ems.epon.iad.bbs4000.mib.r400.PortAclListTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PortAclListTablePanel extends UPanel {

    private EponDeviceIndexPanel tfAclDeviceIndex = new EponDeviceIndexPanel(fStringMap, fApplication);

    private JComboBox tfPortAclListIndex = new JComboBox();

//    private int[] aclPortDirectionVList = new int[]{0, 1,};
//    private String[] aclPortDirectionTList = new String[]{
//            fStringMap.getString("ingress"), //0
//            fStringMap.getString("egress"), //1
//    };
//    private JComboBox tfAclPortDirection = new JComboBox(aclPortDirectionTList);

    private JCheckBox cbAclPortDirectionIngress = new JCheckBox(); //0x80
    private JCheckBox cbAclPortDirectionEgress = new JCheckBox(); //0x40

    /*
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
    */

//    private final String aclDeviceIndex = fStringMap.getString("aclDeviceIndex") + " : ";
//    private final String aclCardIndex = fStringMap.getString("aclCardIndex") + " : ";
//    private final String aclPortIndex = fStringMap.getString("aclPortIndex") + " : ";
    private final String portAclListIndex = fStringMap.getString("portAclListIndex") + " : ";
    private final String aclPortDirection = fStringMap.getString("aclPortDirection") + " : ";
    /*
    private final String aclAction = fStringMap.getString("aclAction") + " : ";
    private final String aclActionParameter = fStringMap.getString("aclActionParameter") + " : ";
    private final String aclActionParameterType = fStringMap.getString("aclActionParameterType") + " : ";
    private final String aclActionParameterValue = fStringMap.getString("aclActionParameterValue") + " : ";
    */

    public PortAclListTablePanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {
        JPanel baseInfoPanel = new JPanel();
        NTLayout layout = new NTLayout(2, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        layout.setMargins(6, 10, 6, 10);
        baseInfoPanel.setLayout(layout);
        baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

        baseInfoPanel.add(new JLabel(portAclListIndex));
        baseInfoPanel.add(tfPortAclListIndex);
        baseInfoPanel.add(new HSpacer());

        baseInfoPanel.add(new JLabel(aclPortDirection));

        JPanel portDirectionPanel = new JPanel();
        NTLayout layout2 = new NTLayout(1, 2, NTLayout.FILL, NTLayout.FILL, 5, 5);
        portDirectionPanel.setLayout(layout2);
        portDirectionPanel.add(cbAclPortDirectionEgress);
        portDirectionPanel.add(cbAclPortDirectionIngress);
        cbAclPortDirectionEgress.setText(fStringMap.getString("egress"));
        cbAclPortDirectionIngress.setText(fStringMap.getString("ingress"));
        baseInfoPanel.add(portDirectionPanel);
        baseInfoPanel.add(new HSpacer());

        /*
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
        */

        JPanel allPanel = new JPanel();
        layout = new NTLayout(3, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(tfAclDeviceIndex);
        allPanel.add(baseInfoPanel);
        //allPanel.add(aclActionParameterPanel);
        allPanel.add(new VSpacer());
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
    }

    protected void initForm() {
        tfAclDeviceIndex.initData();
    }

    private Vector getAclListIndex() throws Exception {
        Vector allAclListIndex = new Vector();

        AclManagementTable aclManagementTableMBean = new AclManagementTable(fApplication.getSnmpProxy());
        Vector v = BeanService.refreshTableBean(fApplication, aclManagementTableMBean);
        for (int i = 0; i < v.size(); i++) {
            int aclListIndex = ((AclManagementTable) v.get(i)).getAclListIndex();
            allAclListIndex.add(aclListIndex);
        }

        return allAclListIndex;
    }

    public void refresh() {
        try {
            Vector aclListIndexSet = getAclListIndex();
            if (aclListIndexSet.size() > 0)
                tfPortAclListIndex.setModel(new DefaultComboBoxModel(aclListIndexSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        cbAclPortDirectionEgress.setSelected(false);
        cbAclPortDirectionIngress.setSelected(false);

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            tfAclDeviceIndex.setEnabled(true);
        } else {
            tfAclDeviceIndex.setEnabled(false);

            PortAclListTable mbean = (PortAclListTable) getModel();
            if (mbean == null)
                return;

            tfAclDeviceIndex.setEponDeviceIndex(mbean.getAclDeviceIndex());
            tfAclDeviceIndex.setOnuCardId(mbean.getAclCardIndex());
            tfAclDeviceIndex.setOnuPortId(mbean.getAclPortIndex());
            tfPortAclListIndex.setEditable(false);
            tfPortAclListIndex.addItem(mbean.getPortAclListIndex());
            tfPortAclListIndex.getModel().setSelectedItem(mbean.getPortAclListIndex());

            //tfAclPortDirection.setSelectedIndex(getIndexFromValue(aclPortDirectionVList, mbean.getAclPortDirection()));
            byte[] direction = mbean.getAclPortDirection();
            if (direction != null && direction.length > 0) {
                cbAclPortDirectionEgress.setSelected((direction[0] & 0x40) != 0);
                cbAclPortDirectionIngress.setSelected((direction[0] & 0x80) != 0);
            }
        }
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new PortAclListTable(fApplication.getSnmpProxy()));

        PortAclListTable mbean = (PortAclListTable) getModel();
        if (mbean == null)
            return;

        if (SnmpAction.IType.ADD.equals(fCommand)) {
            // here set the value of index
            mbean.setAclDeviceIndex((int)tfAclDeviceIndex.getEponDeviceIndex());
            mbean.setAclCardIndex((int)tfAclDeviceIndex.getOnuCardId());
            mbean.setAclPortIndex(tfAclDeviceIndex.getOnuPortId());
            try {
                if (tfPortAclListIndex.getSelectedItem() != null) {
                    mbean.setPortAclListIndex(Integer.parseInt(tfPortAclListIndex.getSelectedItem().toString()));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        if (tfPortAclListIndex.getSelectedIndex() < 0)
            return;

        //mbean.setAclPortDirection(new Integer(aclPortDirectionVList[tfAclPortDirection.getSelectedIndex()]));
        byte[] direction = new byte[1];
        if (cbAclPortDirectionEgress.isSelected())
            direction[0] += 0x40; //egress: 0x40
        if (cbAclPortDirectionIngress.isSelected())
            direction[0] += 0x80; //ingress: 0x80
        mbean.setAclPortDirection(direction);

        /*
        mbean.setAclAction(new Integer(aclActionVList[tfAclAction.getSelectedIndex()]));
        mbean.setAclActionParameter(getAclActionParameter());
        */
    }

    /*
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

        byte[] actionParameter = new byte[5];

        if (tfAclActionParameterType.isEnabled() && tfAclActionParameterValue.isEnabled()) {
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
        }

        return actionParameter;
    }
    */

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v)
                return i;
        }

        return 0;
    }

}