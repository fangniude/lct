package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.gui.swing.NeFileChooser;
import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtProfileImportTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.standard.snmp.action.SnmpAction;
import com.winnertel.em.standard.util.BeanService;
import com.winnertel.em.standard.util.gui.input.IntegerTextField;
import com.winnertel.em.standard.util.gui.input.StringTextField;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * The AclExtProfileImportTablePanel class. Created by DVM Creator
 */
public class AclExtProfileImportTablePanel extends UPanel implements ActionListener
{

	private IntegerTextField tfUtsAclExtProfileImportProfileId = new IntegerTextField();

	private StringTextField tfUtsAclExtProfileImportFileName = new StringTextField();

	private final String utsAclExtProfileImportProfileId = fStringMap
			.getString("utsAclExtProfileImportProfileId")
			+ " : ";

	private final String utsAclExtProfileImportFileName = fStringMap
			.getString("utsAclExtProfileImportFileName")
			+ " : ";

	public AclExtProfileImportTablePanel(IApplication app)
	{
		super(app);
        setModel(new AclExtProfileImportTable(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{
		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(3, 3, NTLayout.FILL, NTLayout.CENTER, 5,
				5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsAclExtProfileImportProfileId));
		tfUtsAclExtProfileImportProfileId.setName(fStringMap
				.getString("utsAclExtProfileImportProfileId"));
		baseInfoPanel.add(tfUtsAclExtProfileImportProfileId);
		baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileImportFileName));
		tfUtsAclExtProfileImportFileName.setName(fStringMap
				.getString("utsAclExtProfileImportFileName"));
		baseInfoPanel.add(tfUtsAclExtProfileImportFileName);
    JButton browseButton = new JButton("...");
    browseButton.setPreferredSize(new Dimension(20, 20));
    browseButton.setFocusPainted(false);
    browseButton.addActionListener(this);

    JPanel filechoose = new JPanel();
    layout = new NTLayout(1, 2, NTLayout.FILL, NTLayout.CENTER, 5, 5);
    filechoose.setLayout(layout);
    filechoose.add(tfUtsAclExtProfileImportFileName);
    filechoose.add(browseButton);
    baseInfoPanel.add(filechoose) ;
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

	protected void initForm()
	{
        tfUtsAclExtProfileImportProfileId.setValueScope(1,32);
		tfUtsAclExtProfileImportFileName.setLenScope(0, 63);

	}

	public void refresh()
	{
		if (SnmpAction.IType.ADD.equals(fCommand)) {


            return;
        }
		AclExtProfileImportTable mbean = (AclExtProfileImportTable) getModel();

		tfUtsAclExtProfileImportProfileId.setValue(mbean
				.getUtsAclExtProfileImportProfileId().intValue());
		tfUtsAclExtProfileImportFileName.setValue(mbean
				.getUtsAclExtProfileImportFileName());
//		tfUtsAclExtProfileImportStatus.setSelectedIndex(getIndexFromValue(
//				utsAclExtProfileImportStatusVList, mbean
//						.getUtsAclExtProfileImportStatus().intValue()));

	}

    public boolean validateFrom(){
        AclExtProfileImportTable mbean = (AclExtProfileImportTable) getModel();
        Vector v = BeanService.refreshTableBean(fApplication,mbean);
        if(v!=null){
            for(int i=0;i<v.size();i++){
                AclExtProfileImportTable one = (AclExtProfileImportTable)v.get(i);
                if(one.getUtsAclExtProfileImportProfileId().intValue() == tfUtsAclExtProfileImportProfileId.getValue()){
                    String error = fStringMap.getString("Err_Duplicate_Profile");
                    MessageDialog.showErrorMessageDialog(fApplication, error);
                    return false;

                }
            }
        }
        return true;
    }

	public void updateModel()
	{

		if (SnmpAction.IType.ADD.equals(fCommand))
			setModel(new AclExtProfileImportTable(fApplication.getSnmpProxy()));

		AclExtProfileImportTable mbean = (AclExtProfileImportTable) getModel();

		 if (SnmpAction.IType.ADD.equals(fCommand)) {
		    mbean.setUtsAclExtProfileImportProfileId(new Integer(tfUtsAclExtProfileImportProfileId.getValue()));
		 }

        mbean.setUtsAclExtProfileImportProfileId(new Integer(tfUtsAclExtProfileImportProfileId.getValue()));
		mbean.setUtsAclExtProfileImportFileName(new String(
				tfUtsAclExtProfileImportFileName.getValue()));
//		mbean.setUtsAclExtProfileImportStatus(new Integer(
//						utsAclExtProfileImportStatusVList[tfUtsAclExtProfileImportStatus
//								.getSelectedIndex()]));
	}

	public int getIndexFromValue(int[] list, int v)
	{
		for (int i = 0; i != list.length; i++)
		{
			if (list[i] == v)
				return i;
		}
		return 0;
	}

  public void actionPerformed(ActionEvent actionEvent)
  {
    NeFileChooser chooser = new NeFileChooser(fApplication, (JDialog)SwingUtilities.getWindowAncestor(this));
    chooser.show();
    if(chooser.getSelectedFile() != null)
    {
      tfUtsAclExtProfileImportFileName.setValue(chooser.getSelectedFile().getAbsoluteName());
    }
  }
}
