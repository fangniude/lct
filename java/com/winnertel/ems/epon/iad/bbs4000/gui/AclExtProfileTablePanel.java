package com.winnertel.ems.epon.iad.bbs4000.gui;

import com.winnertel.ems.epon.iad.bbs4000.mib.AclExtProfileTable;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.HSpacer;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

import javax.swing.*;
import java.awt.*;

/**
 * The AclExtProfileTablePanel class. Created by DVM Creator
 */
public class AclExtProfileTablePanel extends UPanel
{

	private JLabel tfUtsAclExtProfileId = new JLabel();

	private JLabel tfUtsAclExtProfileFieldId = new JLabel();

	private JLabel tfUtsAclExtProfileRuleId = new JLabel();

	private JLabel tfUtsAclExtProfileName = new JLabel();

	private JLabel tfUtsAclExtProfileFieldName = new JLabel();

	private JLabel tfUtsAclExtProfileRuleName = new JLabel();

	private JLabel tfUtsAclExtProfileFieldBitmap = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskDstMac = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskSrcMac = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskArpTargetMac = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskArpSendMac = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskSrcIp = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskDstIp = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskVlan = new JLabel();

	private int[] utsAclExtProfileFieldMaskEtherTypeVList = new int[]
	{ 3, 1, 4, 2, };

	private String[] utsAclExtProfileFieldMaskEtherTypeTList = new String[]
	{ fStringMap.getString("etherII"), fStringMap.getString("tag"),
			fStringMap.getString("eight02dot3"), fStringMap.getString("untag"), };

	private JComboBox tfUtsAclExtProfileFieldMaskEtherType = new JComboBox(
			utsAclExtProfileFieldMaskEtherTypeTList);

	private JLabel tfUtsAclExtProfileFieldMaskTcpSrcPort = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskTcpDstPort = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskTagPri = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskDscp = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskProtocol = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskNewDscp = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskNewTagPri = new JLabel();

	private JLabel tfUtsAclExtProfileFieldMaskNewRateLimit = new JLabel();

	private int[] utsAclExtProfileFieldMaskActionVList = new int[]
	{ 4, 2, 5, 1, 3, };

	private String[] utsAclExtProfileFieldMaskActionTList = new String[]
	{ fStringMap.getString("remark-priority"), fStringMap.getString("deny"),
			fStringMap.getString("rate-limit"), fStringMap.getString("permit"),
			fStringMap.getString("remark-dscp"), };

	private JComboBox tfUtsAclExtProfileFieldMaskAction = new JComboBox(
			utsAclExtProfileFieldMaskActionTList);

	private JLabel tfUtsAclExtProfileRuleValDstMac = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValSrcMac = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValArpTargetMac = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValArpSendMac = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValSrcIp = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValDstIp = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValVlan = new JLabel();

	private int[] utsAclExtProfileRuleValEtherTypeVList = new int[]
	{ 3, 1, 4, 2, };

	private String[] utsAclExtProfileRuleValEtherTypeTList = new String[]
	{ fStringMap.getString("etherII"), fStringMap.getString("tag"),
			fStringMap.getString("eight02dot3"), fStringMap.getString("untag"), };

	private JComboBox tfUtsAclExtProfileRuleValEtherType = new JComboBox(
			utsAclExtProfileRuleValEtherTypeTList);

	private JLabel tfUtsAclExtProfileRuleValTcpSrcPort = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValTcpDstPort = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValTagPri = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValDscp = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValProtocol = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValNewDscp = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValNewTagPri = new JLabel();

	private JLabel tfUtsAclExtProfileRuleValNewRateLimit = new JLabel();

	private int[] utsAclExtProfileRuleValActionVList = new int[]
	{ 4, 2, 5, 1, 3, };

	private String[] utsAclExtProfileRuleValActionTList = new String[]
	{ fStringMap.getString("remark-priority"), fStringMap.getString("deny"),
			fStringMap.getString("rate-limit"), fStringMap.getString("permit"),
			fStringMap.getString("remark-dscp"), };

	private JComboBox tfUtsAclExtProfileRuleValAction = new JComboBox(
			utsAclExtProfileRuleValActionTList);

	private final String utsAclExtProfileId = fStringMap
			.getString("utsAclExtProfileId")
			+ " : ";

	private final String utsAclExtProfileFieldId = fStringMap
			.getString("utsAclExtProfileFieldId")
			+ " : ";

	private final String utsAclExtProfileRuleId = fStringMap
			.getString("utsAclExtProfileRuleId")
			+ " : ";

	private final String utsAclExtProfileName = fStringMap
			.getString("utsAclExtProfileName")
			+ " : ";

	private final String utsAclExtProfileFieldName = fStringMap
			.getString("utsAclExtProfileFieldName")
			+ " : ";

	private final String utsAclExtProfileRuleName = fStringMap
			.getString("utsAclExtProfileRuleName")
			+ " : ";

	private final String utsAclExtProfileFieldBitmap = fStringMap
			.getString("utsAclExtProfileFieldBitmap")
			+ " : ";

	private final String utsAclExtProfileFieldMaskDstMac = fStringMap
			.getString("utsAclExtProfileFieldMaskDstMac")
			+ " : ";

	private final String utsAclExtProfileFieldMaskSrcMac = fStringMap
			.getString("utsAclExtProfileFieldMaskSrcMac")
			+ " : ";

	private final String utsAclExtProfileFieldMaskArpTargetMac = fStringMap
			.getString("utsAclExtProfileFieldMaskArpTargetMac")
			+ " : ";

	private final String utsAclExtProfileFieldMaskArpSendMac = fStringMap
			.getString("utsAclExtProfileFieldMaskArpSendMac")
			+ " : ";

	private final String utsAclExtProfileFieldMaskSrcIp = fStringMap
			.getString("utsAclExtProfileFieldMaskSrcIp")
			+ " : ";

	private final String utsAclExtProfileFieldMaskDstIp = fStringMap
			.getString("utsAclExtProfileFieldMaskDstIp")
			+ " : ";

	private final String utsAclExtProfileFieldMaskVlan = fStringMap
			.getString("utsAclExtProfileFieldMaskVlan")
			+ " : ";

	private final String utsAclExtProfileFieldMaskEtherType = fStringMap
			.getString("utsAclExtProfileFieldMaskEtherType")
			+ " : ";

	private final String utsAclExtProfileFieldMaskTcpSrcPort = fStringMap
			.getString("utsAclExtProfileFieldMaskTcpSrcPort")
			+ " : ";

	private final String utsAclExtProfileFieldMaskTcpDstPort = fStringMap
			.getString("utsAclExtProfileFieldMaskTcpDstPort")
			+ " : ";

	private final String utsAclExtProfileFieldMaskTagPri = fStringMap
			.getString("utsAclExtProfileFieldMaskTagPri")
			+ " : ";

	private final String utsAclExtProfileFieldMaskDscp = fStringMap
			.getString("utsAclExtProfileFieldMaskDscp")
			+ " : ";

	private final String utsAclExtProfileFieldMaskProtocol = fStringMap
			.getString("utsAclExtProfileFieldMaskProtocol")
			+ " : ";

	private final String utsAclExtProfileFieldMaskNewDscp = fStringMap
			.getString("utsAclExtProfileFieldMaskNewDscp")
			+ " : ";

	private final String utsAclExtProfileFieldMaskNewTagPri = fStringMap
			.getString("utsAclExtProfileFieldMaskNewTagPri")
			+ " : ";

	private final String utsAclExtProfileFieldMaskNewRateLimit = fStringMap
			.getString("utsAclExtProfileFieldMaskNewRateLimit")
			+ " : ";

	private final String utsAclExtProfileFieldMaskAction = fStringMap
			.getString("utsAclExtProfileFieldMaskAction")
			+ " : ";

	private final String utsAclExtProfileRuleValDstMac = fStringMap
			.getString("utsAclExtProfileRuleValDstMac")
			+ " : ";

	private final String utsAclExtProfileRuleValSrcMac = fStringMap
			.getString("utsAclExtProfileRuleValSrcMac")
			+ " : ";

	private final String utsAclExtProfileRuleValArpTargetMac = fStringMap
			.getString("utsAclExtProfileRuleValArpTargetMac")
			+ " : ";

	private final String utsAclExtProfileRuleValArpSendMac = fStringMap
			.getString("utsAclExtProfileRuleValArpSendMac")
			+ " : ";

	private final String utsAclExtProfileRuleValSrcIp = fStringMap
			.getString("utsAclExtProfileRuleValSrcIp")
			+ " : ";

	private final String utsAclExtProfileRuleValDstIp = fStringMap
			.getString("utsAclExtProfileRuleValDstIp")
			+ " : ";

	private final String utsAclExtProfileRuleValVlan = fStringMap
			.getString("utsAclExtProfileRuleValVlan")
			+ " : ";

	private final String utsAclExtProfileRuleValEtherType = fStringMap
			.getString("utsAclExtProfileRuleValEtherType")
			+ " : ";

	private final String utsAclExtProfileRuleValTcpSrcPort = fStringMap
			.getString("utsAclExtProfileRuleValTcpSrcPort")
			+ " : ";

	private final String utsAclExtProfileRuleValTcpDstPort = fStringMap
			.getString("utsAclExtProfileRuleValTcpDstPort")
			+ " : ";

	private final String utsAclExtProfileRuleValTagPri = fStringMap
			.getString("utsAclExtProfileRuleValTagPri")
			+ " : ";

	private final String utsAclExtProfileRuleValDscp = fStringMap
			.getString("utsAclExtProfileRuleValDscp")
			+ " : ";

	private final String utsAclExtProfileRuleValProtocol = fStringMap
			.getString("utsAclExtProfileRuleValProtocol")
			+ " : ";

	private final String utsAclExtProfileRuleValNewDscp = fStringMap
			.getString("utsAclExtProfileRuleValNewDscp")
			+ " : ";

	private final String utsAclExtProfileRuleValNewTagPri = fStringMap
			.getString("utsAclExtProfileRuleValNewTagPri")
			+ " : ";

	private final String utsAclExtProfileRuleValNewRateLimit = fStringMap
			.getString("utsAclExtProfileRuleValNewRateLimit")
			+ " : ";

	private final String utsAclExtProfileRuleValAction = fStringMap
			.getString("utsAclExtProfileRuleValAction")
			+ " : ";

	public AclExtProfileTablePanel(IApplication app)
	{
		super(app);
        setModel(new AclExtProfileTable(app.getSnmpProxy()));
		init();
	}

	public void initGui()
	{

		JPanel baseInfoPanel = new JPanel();
		NTLayout layout = new NTLayout(26, 4, NTLayout.FILL, NTLayout.CENTER,
				5, 5);
		layout.setMargins(6, 10, 6, 10);
		baseInfoPanel.setLayout(layout);
		baseInfoPanel.setBorder(BorderFactory.createEtchedBorder());

		baseInfoPanel.add(new JLabel(utsAclExtProfileId));
		baseInfoPanel.add(tfUtsAclExtProfileId);

		baseInfoPanel.add(new JLabel(utsAclExtProfileName));
		baseInfoPanel.add(tfUtsAclExtProfileName);

        baseInfoPanel.add(new JLabel(utsAclExtProfileFieldId));
		baseInfoPanel.add(tfUtsAclExtProfileFieldId);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldName));
		baseInfoPanel.add(tfUtsAclExtProfileFieldName);

        baseInfoPanel.add(new JLabel(utsAclExtProfileRuleId));
		baseInfoPanel.add(tfUtsAclExtProfileRuleId);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleName));
		baseInfoPanel.add(tfUtsAclExtProfileRuleName);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldBitmap));
		baseInfoPanel.add(tfUtsAclExtProfileFieldBitmap);
		baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskDstMac));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskDstMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskSrcMac));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskSrcMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskArpTargetMac));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskArpTargetMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskArpSendMac));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskArpSendMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskSrcIp));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskSrcIp);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskDstIp));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskDstIp);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskVlan));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskVlan);
        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskEtherType));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskEtherType);
        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskTcpSrcPort));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskTcpSrcPort);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskTcpDstPort));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskTcpDstPort);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskTagPri));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskTagPri);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskNewTagPri));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskNewTagPri);

        baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskDscp));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskDscp);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskNewDscp));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskNewDscp);

        baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskProtocol));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskProtocol);


		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskNewRateLimit));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskNewRateLimit);

		baseInfoPanel.add(new JLabel(utsAclExtProfileFieldMaskAction));
		baseInfoPanel.add(tfUtsAclExtProfileFieldMaskAction);
        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValDstMac));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValDstMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValSrcMac));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValSrcMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValArpTargetMac));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValArpTargetMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValArpSendMac));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValArpSendMac);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValSrcIp));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValSrcIp);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValDstIp));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValDstIp);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValVlan));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValVlan);
        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValEtherType));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValEtherType);
        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValTcpSrcPort));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValTcpSrcPort);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValTcpDstPort));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValTcpDstPort);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValTagPri));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValTagPri);
		baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValDscp));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValDscp);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValProtocol));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValProtocol);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValNewDscp));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValNewDscp);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValNewTagPri));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValNewTagPri);

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValNewRateLimit));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValNewRateLimit);
        baseInfoPanel.add(new HSpacer());
        baseInfoPanel.add(new HSpacer());

		baseInfoPanel.add(new JLabel(utsAclExtProfileRuleValAction));
		baseInfoPanel.add(tfUtsAclExtProfileRuleValAction);



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

		// tfUtsAclExtProfileFieldMaskDstMac.setEditable(false);
		// tfUtsAclExtProfileFieldMaskSrcMac.setEditable(false);
		// tfUtsAclExtProfileFieldMaskArpTargetMac.setEditable(false);
		// tfUtsAclExtProfileFieldMaskArpSendMac.setEditable(false);
		//
		// tfUtsAclExtProfileRuleValDstMac.setEditable(false);
		// tfUtsAclExtProfileRuleValSrcMac.setEditable(false);
		// tfUtsAclExtProfileRuleValArpTargetMac.setEditable(false);
		// tfUtsAclExtProfileRuleValArpSendMac.setEditable(false);

	}

	public void refresh()
	{

		AclExtProfileTable mbean = (AclExtProfileTable) getModel();

		tfUtsAclExtProfileId.setText(mbean.getUtsAclExtProfileId().toString());
		tfUtsAclExtProfileFieldId.setText(mbean.getUtsAclExtProfileFieldId()
				.toString());
		tfUtsAclExtProfileRuleId.setText(mbean.getUtsAclExtProfileRuleId()
				.toString());
		tfUtsAclExtProfileName.setText(mbean.getUtsAclExtProfileName());
		tfUtsAclExtProfileFieldName.setText(mbean
				.getUtsAclExtProfileFieldName());
		tfUtsAclExtProfileRuleName.setText(mbean.getUtsAclExtProfileRuleName());
		tfUtsAclExtProfileFieldBitmap.setText(mbean
				.getUtsAclExtProfileFieldBitmap().toString());
//		tfUtsAclExtProfileFieldMaskDstMac.setText(mbean
//				.getUtsAclExtProfileFieldMaskDstMac());
//		tfUtsAclExtProfileFieldMaskSrcMac.setText(mbean
//				.getUtsAclExtProfileFieldMaskSrcMac());
//		tfUtsAclExtProfileFieldMaskArpTargetMac.setText(mbean
//				.getUtsAclExtProfileFieldMaskArpTargetMac());
//		tfUtsAclExtProfileFieldMaskArpSendMac.setText(mbean
//				.getUtsAclExtProfileFieldMaskArpSendMac());
		tfUtsAclExtProfileFieldMaskSrcIp.setText(mbean
				.getUtsAclExtProfileFieldMaskSrcIp());
		tfUtsAclExtProfileFieldMaskDstIp.setText(mbean
				.getUtsAclExtProfileFieldMaskDstIp());
		tfUtsAclExtProfileFieldMaskVlan.setText(mbean
				.getUtsAclExtProfileFieldMaskVlan().toString());
		tfUtsAclExtProfileFieldMaskEtherType
				.setSelectedIndex(getIndexFromValue(
						utsAclExtProfileFieldMaskEtherTypeVList, mbean
								.getUtsAclExtProfileFieldMaskEtherType()
								.intValue()));
		tfUtsAclExtProfileFieldMaskTcpSrcPort.setText(mbean
				.getUtsAclExtProfileFieldMaskTcpSrcPort().toString());
		tfUtsAclExtProfileFieldMaskTcpDstPort.setText(mbean
				.getUtsAclExtProfileFieldMaskTcpDstPort().toString());
		tfUtsAclExtProfileFieldMaskTagPri.setText(mbean
				.getUtsAclExtProfileFieldMaskTagPri().toString());
		tfUtsAclExtProfileFieldMaskDscp.setText(mbean
				.getUtsAclExtProfileFieldMaskDscp().toString());
		tfUtsAclExtProfileFieldMaskProtocol.setText(mbean
				.getUtsAclExtProfileFieldMaskProtocol().toString());
		tfUtsAclExtProfileFieldMaskNewDscp.setText(mbean
				.getUtsAclExtProfileFieldMaskNewDscp().toString());
		tfUtsAclExtProfileFieldMaskNewTagPri.setText(mbean
				.getUtsAclExtProfileFieldMaskNewTagPri().toString());
		tfUtsAclExtProfileFieldMaskNewRateLimit.setText(mbean
				.getUtsAclExtProfileFieldMaskNewRateLimit().toString());
//		tfUtsAclExtProfileFieldMaskAction.setSelectedIndex(getIndexFromValue(
//				utsAclExtProfileFieldMaskActionVList, mbean
//						.getUtsAclExtProfileFieldMaskAction().intValue()));
//		tfUtsAclExtProfileRuleValDstMac.setText(mbean
//				.getUtsAclExtProfileRuleValDstMac());
//		tfUtsAclExtProfileRuleValSrcMac.setText(mbean
//				.getUtsAclExtProfileRuleValSrcMac());
//		tfUtsAclExtProfileRuleValArpTargetMac.setText(mbean
//				.getUtsAclExtProfileRuleValArpTargetMac());
//		tfUtsAclExtProfileRuleValArpSendMac.setText(mbean
//				.getUtsAclExtProfileRuleValArpSendMac());
		tfUtsAclExtProfileRuleValSrcIp.setText(mbean
				.getUtsAclExtProfileRuleValSrcIp());
		tfUtsAclExtProfileRuleValDstIp.setText(mbean
				.getUtsAclExtProfileRuleValDstIp());
		tfUtsAclExtProfileRuleValVlan.setText(mbean
				.getUtsAclExtProfileRuleValVlan().toString());
		tfUtsAclExtProfileRuleValEtherType.setSelectedIndex(getIndexFromValue(
				utsAclExtProfileRuleValEtherTypeVList, mbean
						.getUtsAclExtProfileRuleValEtherType().intValue()));
		tfUtsAclExtProfileRuleValTcpSrcPort.setText(mbean
				.getUtsAclExtProfileRuleValTcpSrcPort().toString());
		tfUtsAclExtProfileRuleValTcpDstPort.setText(mbean
				.getUtsAclExtProfileRuleValTcpDstPort().toString());
		tfUtsAclExtProfileRuleValTagPri.setText(mbean
				.getUtsAclExtProfileRuleValTagPri().toString());
		tfUtsAclExtProfileRuleValDscp.setText(mbean
				.getUtsAclExtProfileRuleValDscp().toString());
		tfUtsAclExtProfileRuleValProtocol.setText(mbean
				.getUtsAclExtProfileRuleValProtocol().toString());
		tfUtsAclExtProfileRuleValNewDscp.setText(mbean
				.getUtsAclExtProfileRuleValNewDscp().toString());
		tfUtsAclExtProfileRuleValNewTagPri.setText(mbean
				.getUtsAclExtProfileRuleValNewTagPri().toString());
		tfUtsAclExtProfileRuleValNewRateLimit.setText(mbean
				.getUtsAclExtProfileRuleValNewRateLimit().toString());
		tfUtsAclExtProfileRuleValAction.setSelectedIndex(getIndexFromValue(
				utsAclExtProfileRuleValActionVList, mbean
						.getUtsAclExtProfileRuleValAction().intValue()));

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

}
