package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SniBroadcastStormSuppressionTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
  * The SniBroadcastStormSuppressionTablePanel class.
  * Created by DVM Creator
*/
public class SniBroadcastStormSuppressionTablePanel extends UPanel {

             private JLabel  tfSniBroadcastStormSuppressionDeviceIndex = new JLabel();

     private JLabel  tfSniBroadcastStormSuppressionCardIndex = new JLabel();

     private JLabel  tfSniBroadcastStormSuppressionPortIndex = new JLabel();

     private int[] sniUnicastStormEnableVList =new int[]{
1,2,};
private String[] sniUnicastStormEnableTList =new String[]{
     fStringMap.getString("true"),
     fStringMap.getString("false"),
};
private JComboBox tfSniUnicastStormEnable = new JComboBox( sniUnicastStormEnableTList);
     private IntegerTextField  tfSniUnicastStormInPacketRate = new IntegerTextField();

     private IntegerTextField  tfSniUnicastStormOutPacketRate = new IntegerTextField();

     private int[] sniMulticastStormEnableVList =new int[]{
1,2,};
private String[] sniMulticastStormEnableTList =new String[]{
     fStringMap.getString("true"),
     fStringMap.getString("false"),
};
private JComboBox tfSniMulticastStormEnable = new JComboBox( sniMulticastStormEnableTList);
     private IntegerTextField  tfSniMulticastStormInPacketRate = new IntegerTextField();

     private IntegerTextField  tfSniMulticastStormOutPacketRate = new IntegerTextField();

     private int[] sniBroadcastStormEnableVList =new int[]{
1,2,};
private String[] sniBroadcastStormEnableTList =new String[]{
     fStringMap.getString("true"),
     fStringMap.getString("false"),
};
private JComboBox tfSniBroadcastStormEnable = new JComboBox( sniBroadcastStormEnableTList);
     private IntegerTextField  tfSniBroadcastStormInPacketRate = new IntegerTextField();

     private IntegerTextField  tfSniBroadcastStormOutPacketRate = new IntegerTextField();



             private final String sniBroadcastStormSuppressionDeviceIndex = fStringMap.getString("sniBroadcastStormSuppressionDeviceIndex")+" : ";
     private final String sniBroadcastStormSuppressionCardIndex = fStringMap.getString("sniBroadcastStormSuppressionCardIndex")+" : ";
     private final String sniBroadcastStormSuppressionPortIndex = fStringMap.getString("sniBroadcastStormSuppressionPortIndex")+" : ";
     private final String sniUnicastStormEnable = fStringMap.getString("sniUnicastStormEnable")+" : ";
     private final String sniUnicastStormInPacketRate = fStringMap.getString("sniUnicastStormInPacketRate")+" : ";
     private final String sniUnicastStormOutPacketRate = fStringMap.getString("sniUnicastStormOutPacketRate")+" : ";
     private final String sniMulticastStormEnable = fStringMap.getString("sniMulticastStormEnable")+" : ";
     private final String sniMulticastStormInPacketRate = fStringMap.getString("sniMulticastStormInPacketRate")+" : ";
     private final String sniMulticastStormOutPacketRate = fStringMap.getString("sniMulticastStormOutPacketRate")+" : ";
     private final String sniBroadcastStormEnable = fStringMap.getString("sniBroadcastStormEnable")+" : ";
     private final String sniBroadcastStormInPacketRate = fStringMap.getString("sniBroadcastStormInPacketRate")+" : ";
     private final String sniBroadcastStormOutPacketRate = fStringMap.getString("sniBroadcastStormOutPacketRate")+" : ";



            public SniBroadcastStormSuppressionTablePanel(IApplication app) {
               super(app);

               init();
              }
            public void initGui() {

            JPanel baseInfoPanel = new JPanel();
     NTLayout layout = new NTLayout(12, 3, NTLayout.FILL, NTLayout.CENTER, 5, 5);
     layout.setMargins(6, 10, 6, 10);
     baseInfoPanel.setLayout(layout);
     baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

                baseInfoPanel.add( new JLabel(sniBroadcastStormSuppressionDeviceIndex));
               baseInfoPanel.add( tfSniBroadcastStormSuppressionDeviceIndex) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniBroadcastStormSuppressionCardIndex));
               baseInfoPanel.add( tfSniBroadcastStormSuppressionCardIndex) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniBroadcastStormSuppressionPortIndex));
               baseInfoPanel.add( tfSniBroadcastStormSuppressionPortIndex) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniUnicastStormEnable));
               tfSniUnicastStormEnable.setName(fStringMap.getString("sniUnicastStormEnable")) ;
baseInfoPanel.add( tfSniUnicastStormEnable) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniUnicastStormInPacketRate));
               tfSniUnicastStormInPacketRate.setName(fStringMap.getString("sniUnicastStormInPacketRate")) ;
baseInfoPanel.add( tfSniUnicastStormInPacketRate) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniUnicastStormOutPacketRate));
               tfSniUnicastStormOutPacketRate.setName(fStringMap.getString("sniUnicastStormOutPacketRate")) ;
baseInfoPanel.add( tfSniUnicastStormOutPacketRate) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniMulticastStormEnable));
               tfSniMulticastStormEnable.setName(fStringMap.getString("sniMulticastStormEnable")) ;
baseInfoPanel.add( tfSniMulticastStormEnable) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniMulticastStormInPacketRate));
               tfSniMulticastStormInPacketRate.setName(fStringMap.getString("sniMulticastStormInPacketRate")) ;
baseInfoPanel.add( tfSniMulticastStormInPacketRate) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniMulticastStormOutPacketRate));
               tfSniMulticastStormOutPacketRate.setName(fStringMap.getString("sniMulticastStormOutPacketRate")) ;
baseInfoPanel.add( tfSniMulticastStormOutPacketRate) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniBroadcastStormEnable));
               tfSniBroadcastStormEnable.setName(fStringMap.getString("sniBroadcastStormEnable")) ;
baseInfoPanel.add( tfSniBroadcastStormEnable) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniBroadcastStormInPacketRate));
               tfSniBroadcastStormInPacketRate.setName(fStringMap.getString("sniBroadcastStormInPacketRate")) ;
baseInfoPanel.add( tfSniBroadcastStormInPacketRate) ;
               baseInfoPanel.add(new HSpacer());


                baseInfoPanel.add( new JLabel(sniBroadcastStormOutPacketRate));
               tfSniBroadcastStormOutPacketRate.setName(fStringMap.getString("sniBroadcastStormOutPacketRate")) ;
baseInfoPanel.add( tfSniBroadcastStormOutPacketRate) ;
               baseInfoPanel.add(new HSpacer());



          JPanel allPanel = new JPanel();
     layout = new NTLayout(2, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
     layout.setMargins(6, 10, 6, 10);
     allPanel.setLayout(layout);
     allPanel.add(baseInfoPanel);
     allPanel.add(new VSpacer());
     setLayout(new BorderLayout());
     add(allPanel, BorderLayout.CENTER);



          }
           protected void initForm() {













           }
           public void refresh() {

              SniBroadcastStormSuppressionTable mbean = (SniBroadcastStormSuppressionTable) getModel();

           tfSniBroadcastStormSuppressionDeviceIndex.setText(mbean.getSniBroadcastStormSuppressionDeviceIndex().toString());
   tfSniBroadcastStormSuppressionCardIndex.setText(mbean.getSniBroadcastStormSuppressionCardIndex().toString());
   tfSniBroadcastStormSuppressionPortIndex.setText(mbean.getSniBroadcastStormSuppressionPortIndex().toString());
   tfSniUnicastStormEnable.setSelectedIndex(getIndexFromValue(sniUnicastStormEnableVList,mbean.getSniUnicastStormEnable().intValue()));
   tfSniUnicastStormInPacketRate.setValue(mbean.getSniUnicastStormInPacketRate().intValue());
   tfSniUnicastStormOutPacketRate.setValue(mbean.getSniUnicastStormOutPacketRate().intValue());
   tfSniMulticastStormEnable.setSelectedIndex(getIndexFromValue(sniMulticastStormEnableVList,mbean.getSniMulticastStormEnable().intValue()));
   tfSniMulticastStormInPacketRate.setValue(mbean.getSniMulticastStormInPacketRate().intValue());
   tfSniMulticastStormOutPacketRate.setValue(mbean.getSniMulticastStormOutPacketRate().intValue());
   tfSniBroadcastStormEnable.setSelectedIndex(getIndexFromValue(sniBroadcastStormEnableVList,mbean.getSniBroadcastStormEnable().intValue()));
   tfSniBroadcastStormInPacketRate.setValue(mbean.getSniBroadcastStormInPacketRate().intValue());
   tfSniBroadcastStormOutPacketRate.setValue(mbean.getSniBroadcastStormOutPacketRate().intValue());

           }
           public void updateModel() {

               SniBroadcastStormSuppressionTable mbean = (SniBroadcastStormSuppressionTable) getModel();




   mbean.setSniUnicastStormEnable(new Integer(sniUnicastStormEnableVList[tfSniUnicastStormEnable.getSelectedIndex()]));
   mbean.setSniUnicastStormInPacketRate( new Integer(tfSniUnicastStormInPacketRate.getValue()));
   mbean.setSniUnicastStormOutPacketRate( new Integer(tfSniUnicastStormOutPacketRate.getValue()));
   mbean.setSniMulticastStormEnable(new Integer(sniMulticastStormEnableVList[tfSniMulticastStormEnable.getSelectedIndex()]));
   mbean.setSniMulticastStormInPacketRate( new Integer(tfSniMulticastStormInPacketRate.getValue()));
   mbean.setSniMulticastStormOutPacketRate( new Integer(tfSniMulticastStormOutPacketRate.getValue()));
   mbean.setSniBroadcastStormEnable(new Integer(sniBroadcastStormEnableVList[tfSniBroadcastStormEnable.getSelectedIndex()]));
   mbean.setSniBroadcastStormInPacketRate( new Integer(tfSniBroadcastStormInPacketRate.getValue()));
   mbean.setSniBroadcastStormOutPacketRate( new Integer(tfSniBroadcastStormOutPacketRate.getValue()));


       }
           public int getIndexFromValue(int[] list,int v){
               for (int i = 0 ; i!=list.length; i++)
                {
                  if ( list[i] == v ) return i;
                }
                return 0;
           }

}
