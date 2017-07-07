package com.winnertel.ems.epon.iad.bbs4000.gui;


import com.winnertel.ems.epon.iad.bbs4000.constant.CommonConstant;
import com.winnertel.ems.epon.iad.bbs4000.mib.Dot3DbaSlaTable;
import com.winnertel.ems.epon.util.ConfigUtility;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.model.MibBeanException;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: hz21047
 * Date: 2006-11-7
 * Time: 12:33:19
 * To change this template use File | Settings | File Templates.
 */
public class BatchModifyDbaSlaPanel extends UPanel {

    private CheckNodeTreePanel treePanel;

    private IntegerTextField tfUtsDot3DbaSlaUpCommittedBandwidth = new IntegerTextField();

    private IntegerTextField tfUtsDot3DbaSlaUpMaxBandwidth = new IntegerTextField();

    private int[] utsDot3DbaSlaUNIMaxMACAddressVList = new int[]
    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 30, 62, 126, 254, 8190};

    private String[] utsDot3DbaSlaUNIMaxMACAddressTList = new String[]
    {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "30", "62", "126", "254", "NO Limit"};

    private JComboBox tfUtsDot3DbaSlaUNIMaxMACAddress = new JComboBox(utsDot3DbaSlaUNIMaxMACAddressTList);

    private int[] utsDot3DbaSlaPlatoClassVList = new int[]
    {0, 1, 2, 3, 4, 5, 6, 7};
    private String[] utsDot3DbaSlaPlatoClassTList = new String[]
    {"0", "1", "2", "3", "4", "5", "6", "7"};
    private JComboBox tfUtsDot3DbaSlaPlatoClass = new JComboBox(utsDot3DbaSlaPlatoClassTList);

    private int[] utsDot3DbaSlaDownPolicingEnableVList = new int[]
    {2, 1, };

    private String[] utsDot3DbaSlaDownPolicingEnableTList = new String[]
    {fStringMap.getString("disable"), fStringMap.getString("enable"), };

    private JComboBox tfUtsDot3DbaSlaDownPolicingEnable = new JComboBox(utsDot3DbaSlaDownPolicingEnableTList);

    private IntegerTextField tfUtsDot3DbaSlaDownMaxBandwidth = new IntegerTextField();

    private IntegerTextField tfUtsDot3DbaSlaDownMaxBurstSize = new IntegerTextField();

    private final String utsDot3DbaSlaUpCommittedBandwidth = fStringMap
            .getString("utsDot3DbaSlaUpCommittedBandwidth")
            + " : ";

    private final String utsDot3DbaSlaUpMaxBandwidth = fStringMap
            .getString("utsDot3DbaSlaUpMaxBandwidth")
            + " : ";

    private final String utsDot3DbaSlaUNIMaxMACAddress = fStringMap
            .getString("utsDot3DbaSlaUNIMaxMACAddress")
            + " : ";

    private final String utsDot3DbaSlaPlatoClass = fStringMap
            .getString("utsDot3DbaSlaPlatoClass")
            + " : ";

    private final String utsDot3DbaSlaDownPolicingEnable = fStringMap
            .getString("utsDot3DbaSlaDownPolicingEnable")
            + " : ";

    private final String utsDot3DbaSlaDownMaxBandwidth = fStringMap
            .getString("utsDot3DbaSlaDownMaxBandwidth")
            + " : ";

    private final String utsDot3DbaSlaDownMaxBurstSize = fStringMap
            .getString("utsDot3DbaSlaDownMaxBurstSize")
            + " : ";

    public BatchModifyDbaSlaPanel(IApplication app) {
        super(app);
        init();
    }

    public void initGui() {

        treePanel = new CheckNodeTreePanel(getRoot(), "ONU Tree List");
        treePanel.setPreferredSize(new Dimension(200, 300));

        JPanel componentPanel = new JPanel();
        NTLayout layout = new NTLayout(7, 4, NTLayout.FILL, NTLayout.CENTER, 5, 5);
        componentPanel.setBorder(BorderFactory.createEtchedBorder());
        componentPanel.setLayout(layout);

        componentPanel.add(new HSpacer());
        componentPanel.add(new JLabel(utsDot3DbaSlaUpCommittedBandwidth));
        tfUtsDot3DbaSlaUpCommittedBandwidth.setName(fStringMap
                .getString("utsDot3DbaSlaUpCommittedBandwidth"));
        componentPanel.add(tfUtsDot3DbaSlaUpCommittedBandwidth);
        componentPanel.add(new HSpacer());

        componentPanel.add(new HSpacer());
        componentPanel.add(new JLabel(utsDot3DbaSlaUpMaxBandwidth));
        tfUtsDot3DbaSlaUpMaxBandwidth.setName(fStringMap
                .getString("utsDot3DbaSlaUpMaxBandwidth"));
        componentPanel.add(tfUtsDot3DbaSlaUpMaxBandwidth);
        componentPanel.add(new HSpacer());

        componentPanel.add(new HSpacer());
        componentPanel.add(new JLabel(utsDot3DbaSlaUNIMaxMACAddress));
        tfUtsDot3DbaSlaUNIMaxMACAddress.setName(fStringMap
                .getString("utsDot3DbaSlaUNIMaxMACAddress"));
        componentPanel.add(tfUtsDot3DbaSlaUNIMaxMACAddress);
        componentPanel.add(new HSpacer());

        componentPanel.add(new HSpacer());
        componentPanel.add(new JLabel(utsDot3DbaSlaPlatoClass));
        tfUtsDot3DbaSlaPlatoClass.setName(fStringMap
                .getString("utsDot3DbaSlaPlatoClass"));
        componentPanel.add(tfUtsDot3DbaSlaPlatoClass);
        componentPanel.add(new HSpacer());

        componentPanel.add(new HSpacer());
        componentPanel.add(new JLabel(utsDot3DbaSlaDownPolicingEnable));
        tfUtsDot3DbaSlaDownPolicingEnable.setName(fStringMap
                .getString("utsDot3DbaSlaDownPolicingEnable"));
        componentPanel.add(tfUtsDot3DbaSlaDownPolicingEnable);
        componentPanel.add(new HSpacer());

        componentPanel.add(new HSpacer());
        componentPanel.add(new JLabel(utsDot3DbaSlaDownMaxBandwidth));
        tfUtsDot3DbaSlaDownMaxBandwidth.setName(fStringMap
                .getString("utsDot3DbaSlaDownMaxBandwidth"));
        componentPanel.add(tfUtsDot3DbaSlaDownMaxBandwidth);
        componentPanel.add(new HSpacer());

        componentPanel.add(new HSpacer());
        componentPanel.add(new JLabel(utsDot3DbaSlaDownMaxBurstSize));
        tfUtsDot3DbaSlaDownMaxBurstSize.setName(fStringMap
                .getString("utsDot3DbaSlaDownMaxBurstSize"));
        componentPanel.add(tfUtsDot3DbaSlaDownMaxBurstSize);
        componentPanel.add(new HSpacer());

        JPanel allPanel = new JPanel();
        layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        allPanel.setLayout(layout);
        allPanel.add(treePanel);
        allPanel.add(componentPanel);
        setLayout(new BorderLayout());
        add(allPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(650, 300));
    }

    public void initForm()
    {
/*      Upstream Committed bandwidth (Range: 1~1000000K) , default value: 10000K
        Upstream Max bandwidth (Range: 1~1000000K) , default value: 100000K
        Plato Traffic Priority (Range: 0~7), default value: 0
        Max ONU UNI MAC address (Range: 1~16, 30, 62, 126, 254, 8190. 8190 means to remove MAC address limitation) , default value: No Limit(8190)

        Downstream Policing Status (Enable or Disable), default value: Disable
        Downstream Max Bandwidth (Range: 0~1000000 Kbps), default value: 1000000
        Downstream Max Burst Size (Range: 0~8192 KB), The default value is 256
*/
      tfUtsDot3DbaSlaUpCommittedBandwidth.setValueScope(1, 1000000);
      tfUtsDot3DbaSlaUpCommittedBandwidth.setValue(10000);

      tfUtsDot3DbaSlaUpMaxBandwidth.setValueScope(1, 1000000);
      tfUtsDot3DbaSlaUpMaxBandwidth.setValue(100000);

      tfUtsDot3DbaSlaUNIMaxMACAddress.setSelectedIndex(0);
      tfUtsDot3DbaSlaUNIMaxMACAddress.setSelectedIndex(20);

      tfUtsDot3DbaSlaDownPolicingEnable.setSelectedIndex(0);

      tfUtsDot3DbaSlaDownMaxBandwidth.setValueScope(0, 1000000);
      tfUtsDot3DbaSlaDownMaxBandwidth.setValue(1000000);

      tfUtsDot3DbaSlaDownMaxBurstSize.setValueScope(0, 8192);
      tfUtsDot3DbaSlaDownMaxBurstSize.setValue(256);
    }

    public void refresh() {
    }

    public boolean validateFrom() {
        for(int i=0;i<4;i++){
            int totalcommi=0,total=0;
            Vector v = treePanel.getCheckRootChild(i);
            if (v != null&&v.size()!=0) {
                String index = (String)v.get(i);
                StringTokenizer tokens = new StringTokenizer(index,"/");
                String strCard = tokens.nextElement().toString();
                String strPort = tokens.nextElement().toString();
                int moduleID = Integer.parseInt(strCard.substring(strCard.indexOf(' ')+1));
                int portID = Integer.parseInt(strPort.substring(strPort.indexOf(' ')+1));
                Dot3DbaSlaTable mbean = new Dot3DbaSlaTable(fApplication.getSnmpProxy());
                Vector mv = new Vector();
                try {
                    int startindex = ConfigUtility.generateIfIndex(moduleID + "/" + portID);
                    mbean.setIndex(0,new Integer(startindex));
                    mv = mbean.retrieveAll();
                } catch (MibBeanException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                for (int j = 0; j < mv.size(); j++) {
                    Dot3DbaSlaTable one = (Dot3DbaSlaTable) mv.get(j);
                    if (one.getUtsDot3DbaSlaModuleId().intValue() == moduleID
                        && one.getUtsDot3DbaSlaPortId().intValue() == portID) {
                        totalcommi += one.getUtsDot3DbaSlaUpCommittedBandwidth().intValue();
                        for(int t=0;t<v.size();t++){
                            String onuindex = (String)v.get(i);
                            StringTokenizer onutokens = new StringTokenizer(index,"/");
                            onutokens.nextElement();
                            onutokens.nextElement();
                            onuindex = onutokens.nextElement().toString();
                            int onuID = Integer.parseInt(onuindex.substring(onuindex.indexOf(' ')+1));
                            if(one.getUtsDot3DbaSlaLogicalPortId().intValue() == onuID){
                                total+=one.getUtsDot3DbaSlaUpCommittedBandwidth().intValue();
                                break;
                            }
                        }
                    }
                }
                int leftcommi = 1000000 - totalcommi;
                if (totalcommi-total+ tfUtsDot3DbaSlaUpCommittedBandwidth.getValue()*v.size()> 1000000) {
                    String error = fStringMap.getString("Err_No_Enough_Bandwidth_1") +
                            leftcommi + fStringMap.getString("Err_No_Enough_Bandwidth_2");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;
                }
            }


            totalcommi += tfUtsDot3DbaSlaUpCommittedBandwidth.getValue();

            if (tfUtsDot3DbaSlaUpMaxBandwidth.getValue() > 1000000) {
                String error = fStringMap.getString("Err_Maximum_Bandwidth");
                MessageDialog.showErrorMessageDialog(fApplication, error);
                return false;
            }
        }
        return true;
    }

    public void updateModel() {
        if (SnmpAction.IType.ADD.equals(fCommand))
            setModel(new Dot3DbaSlaTable(fApplication.getSnmpProxy()));


        Vector v = treePanel.getCheckNodes();
        Dot3DbaSlaTable mbean = new Dot3DbaSlaTable(fApplication.getSnmpProxy());
        try {
            mbean.BatchModify(v, tfUtsDot3DbaSlaUpCommittedBandwidth.getValue(),
                    tfUtsDot3DbaSlaUpMaxBandwidth.getValue(),
                    utsDot3DbaSlaUNIMaxMACAddressVList[tfUtsDot3DbaSlaUNIMaxMACAddress.getSelectedIndex()],
                    tfUtsDot3DbaSlaDownMaxBandwidth.getValue(),
                    tfUtsDot3DbaSlaDownMaxBurstSize.getValue(),
                    utsDot3DbaSlaDownPolicingEnableVList[tfUtsDot3DbaSlaDownPolicingEnable.getSelectedIndex()],
                    utsDot3DbaSlaPlatoClassVList[tfUtsDot3DbaSlaPlatoClass.getSelectedIndex()]);
        } catch (MibBeanException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    CheckNode getRoot() {
        String sSlotId = fApplication.getActiveDeviceManager().getProperties().getProperty(CommonConstant.CURRENT_SLOT_ID);

        CheckNode root = new CheckNode("Card " + sSlotId);
        CheckNode[] ports = new CheckNode[4];
        for (int j = 0; j < 4; j++) {
            ports[j] = new CheckNode("Port " + (j + 1));
            CheckNode[] onus = new CheckNode[32];
            for (int t = 0; t < 32; t++) {
                onus[t] = new CheckNode("ONU " + (t + 1));
                ports[j].insert(onus[t], t);
            }
            root.insert(ports[j], j);
        }

        return root;

    }

    public int getIndexFromValue(int[] list, int v) {
        for (int i = 0; i != list.length; i++) {
            if (list[i] == v) return i;
        }
        return 0;
    }

}
