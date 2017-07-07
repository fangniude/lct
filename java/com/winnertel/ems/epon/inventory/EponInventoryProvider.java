package com.winnertel.ems.epon.inventory;

import com.winnertel.ems.epon.iad.bbs1000.mib.BBS1000CardMibBean;
import com.winnertel.ems.epon.iad.bbs4000.formatter.r210.ModuleHwVerFormatter;
import com.winnertel.ems.epon.iad.bbs4000.mib.BBS4000CardMibBean;
import com.winnertel.em.broadband.common.inventory.InventoryProvider;
import com.winnertel.em.broadband.common.inventory.model.Board;
import com.winnertel.em.broadband.common.inventory.model.Chassis;
import com.winnertel.em.broadband.common.inventory.model.GeponONU;
import com.winnertel.em.broadband.common.inventory.model.Onu;
import com.winnertel.em.broadband.common.inventory.model.Port;
import com.winnertel.em.broadband.common.inventory.model.Slot;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.nms.topodb.ULManagedObject;
import com.winnertel.nms.topodb.ULNode;

import java.util.List;
import java.util.Vector;

public class EponInventoryProvider extends InventoryProvider {


	public EponInventoryProvider() {
	}

	public List getChassisList(ULManagedObject ULManagedObject) {
		Vector chassisList = new Vector();
		Chassis chassis = null;

		chassis = new Chassis();
		chassis.setIndex("1");
		chassis.setState(GeponInventoryConstants.STATE_ACCEPTABLE);

		chassisList.add(chassis);

		return chassisList;
	}

	public List getSlotList(ULManagedObject ULManagedObject, Chassis chassis) {
		String type = getNodeType(ULManagedObject);
		if (type.startsWith("FBW3000") || type.startsWith("FBW2000")) {
			return getBBS1000SlotList(ULManagedObject, chassis);
		} else if (type.equals("FBW5000")) {
			return getFBW5000SlotList(ULManagedObject, chassis);
		} else {
			System.out.println("Unsupported NE Type: " + type);
			return null;
		}
	}

	protected List getBBS1000SlotList(ULManagedObject obj, Chassis chassis) {
		Vector slotList = new Vector();

		try {
			SnmpParameter param = new SnmpParameter(getNodeAddr(obj),
					getNodePort(obj));
			param.setReadCommunity(getReadCommunity(obj));
			SnmpProxy proxy = new SnmpProxy(param);

			BBS1000CardMibBean bean = new BBS1000CardMibBean(proxy);
			Vector list = bean.retrieveAll();

			for (int i = 0; i < list.size(); i++) {
				BBS1000CardMibBean mBean = (BBS1000CardMibBean) list.get(i);

				Slot slot = new Slot();
				slot.setIndex("" + mBean.getUtsEponModuleBoardPhyId());

				if (mBean.getUtsEponModuleBoardState() == 3) { // active
					slot.setState(GeponInventoryConstants.STATE_ACCEPTABLE);
				} else {
					slot.setState(GeponInventoryConstants.STATE_EMPTY);
				}

				slotList.add(slot);
			}
		} catch (Exception e) {
			
		}

		return slotList;
	}

	protected List getFBW5000SlotList(ULManagedObject obj, Chassis chassis) {
        Vector slotList = new Vector();

        SnmpParameter param = new SnmpParameter( getNodeAddr(obj),
                getNodePort(obj));
        param.setReadCommunity(getReadCommunity(obj));
        SnmpProxy proxy = new SnmpProxy(param);

        BBS4000CardMibBean bean = new BBS4000CardMibBean(proxy);

        try {
            Vector v = bean.retrieveAll();

            int cardCount = v.size();

            for (int i = 0; i < cardCount; i++) {
                Slot slot = new Slot();
                BBS4000CardMibBean card = (BBS4000CardMibBean) v.get(i);

                slot.setIndex(getDisSlotIndex(
                        card.getUtsEponModuleBoardPhyId(), "FBW5000", ""));
                if (card.getUtsEponModulePhyPresenceStat() != null
                        && card.getUtsEponModulePhyPresenceStat() == 1) { // installed
                    slot.setState(GeponInventoryConstants.STATE_ACCEPTABLE);
                } else {
                    slot.setState(GeponInventoryConstants.STATE_EMPTY);
                }

                slotList.add(slot);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return slotList;

    }

	public List getBoardList(ULManagedObject obj, Chassis chassis, Slot slot) {
		String neType = getNodeType(obj);
		Vector boardList = new Vector(1);
		Board board = new Board();
		board.setIndex(slot.getIndex());
		if (neType.startsWith("FBW3000") || neType.equals("FBW3000")) {
			return getBBS1000BoardList(obj, chassis, slot);
		} else if (neType.equals("FBW5000")) {
			return getFBW5000BoardList(obj, chassis, slot);
		} else {

			return boardList;
		}
	}

	protected List getBBS1000BoardList(ULManagedObject obj, Chassis chassis,
			Slot slot) {
		Vector boardList = new Vector(1);

		SnmpParameter param = new SnmpParameter(getNodeAddr(obj),
				getNodePort(obj));
		param.setReadCommunity(getReadCommunity(obj));
		SnmpProxy proxy = new SnmpProxy(param);

		BBS1000CardMibBean bean = new BBS1000CardMibBean(proxy);
		bean.setUtsEponModuleBoardPhyId(getSlotNumber(slot.getIndex()));

		try {
			bean.retrieve();

			if (bean.getUtsEponModuleBoardState() == 3) { // active
				Board board = new Board();
				board.setIndex(slot.getIndex());

				// 1: other(1)
				// 2: gsm(2)
				// 3: epm04a(3)
				// 4: epm04b(4)
				// 5: ltm(20)
				// 6: ltm6(21)

				int type = bean.getUtsEponModuleBoardType();
				if (type == 2) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_GSM);
					board.setSpecificType(GeponInventoryConstants.BOARD_ST_GSM);
				} else if (type == 3) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_LTM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_EPM04A);
				} else if (type == 4) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_LTM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_EPM04B);
				} else if (type == 20) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_LTM);
					board.setSpecificType(GeponInventoryConstants.BOARD_ST_LTM);
				} else if (type == 21) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_LTM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_LTM6);
				} else if (type == 11) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_LTM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_EPM04D);
					board.setPortCount((byte) 4);
				} else {
					return null;
				}

				board.setPortCount((byte) 4);
				board.setHardwareVersion("None");
				board.setSoftwareVersion(bean.getUtsEponModuleBoardSwVer());
				board.setSerialNumber("0.0");
				board
						.setInstallStatus(GeponInventoryConstants.INSTALL_STATUS_INSTALLED);
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return boardList;
	}

	protected List getFBW5000BoardList(ULManagedObject obj, Chassis chassis,
			Slot slot) {
		Vector boardList = new Vector(1);

		SnmpParameter param = new SnmpParameter(getNodeAddr(obj),
				getNodePort(obj));
		param.setReadCommunity(getReadCommunity(obj));
		SnmpProxy proxy = new SnmpProxy(param);

		BBS4000CardMibBean bean = new BBS4000CardMibBean(proxy);
		bean.setUtsEponModuleBoardPhyId(getSlotNumber(slot.getIndex()));

		try {
			bean.retrieve();

			if (bean.getUtsEponModulePhyPresenceStat() == 1) { // installed
				Board board = new Board();
				board.setIndex(slot.getIndex());

				// 1: other(1)
				// 2: csm(2)
				// 3: epm04a(3)
				// 4: epm04b(4)
				// 5: epm04c(5)
				// 6: gem04a(6)
				// 7: gem04b(7)

				/*
				 * Description: The line card type. In FBW5000, the following
				 * board types are supported: csm(2) -- controller and switch
				 * fabric card, epm04a(3) -- epon service access line card using
				 * the Passave Chip, epm04b(4) -- epon service access line card
				 * using the ImmenStar Chip, epm04c(5) -- epon service access
				 * line card(reserved), gem04a(6) -- giga Ethernet service card
				 * with opper port only, gem04b(7) -- 1G uplink card, SFP.
				 * xgm01a(8) -- 10G uplink card. osm04a(9) -- Optical service
				 * module. gpm02a(10) -- GPON line card. epm04d(11) -- EPON line
				 * card, supports the Optical layer supervision (OLS) function.
				 * gem04c(12) -- 1G uplink card, SFP.
				 */

				int type = bean.getUtsEponModuleBoardType();
				if (type == 2) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_CSM);
					board.setSpecificType(GeponInventoryConstants.BOARD_ST_CSM);
					board.setPortCount((byte) 0);
				} else if (type == 3) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_EPM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_EPM04A);
					board.setPortCount((byte) 4);
				} else if (type == 4) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_EPM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_EPM04B);
					board.setPortCount((byte) 4);
				} else if (type == 5) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_EPM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_EPM04C);
					board.setPortCount((byte) 4);
				} else if (type == 6) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_GEM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_GEM04A);
					board.setPortCount((byte) 4);
				} else if (type == 7) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_GEM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_GEM04B);
					board.setPortCount((byte) 4);
				} else if (type == 8) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_GEM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_XGM01A);
					board.setPortCount((byte) 4);
				} else if (type == 9) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_GEM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_OSM04A);
					board.setPortCount((byte) 4);
				} else if (type == 10) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_GPM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_GPM02A);
					board.setPortCount((byte) 2);
				} else if (type == 11) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_EPM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_EPM04D);
					board.setPortCount((byte) 4);
				} else if (type == 12) {
					board.setType(GeponInventoryConstants.BOARD_TYPE_GEM);
					board
							.setSpecificType(GeponInventoryConstants.BOARD_ST_GEM04C);
					board.setPortCount((byte) 4);
				} else {
					return null;
				}

				board.setHardwareVersion(ModuleHwVerFormatter.format(bean
						.getUtsEponModuleBoardHwVer()));
				board.setSoftwareVersion(bean.getUtsEponModuleBoardSwVer());
                String sn = bean.getUtsEponModuleBoardSerialNumber();
                StringBuffer sb = new StringBuffer("");
                for( int x = 0; x < sn.length(); x++ ) {
                    if( sn.charAt(x) !='\u0000' ) {
                        sb.append(sn.charAt(x));
                    }
                }
                board.setSerialNumber(sb.toString());
				board
						.setInstallStatus(GeponInventoryConstants.INSTALL_STATUS_INSTALLED);
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return boardList;
	}

	public List getPortList(ULManagedObject ULManagedObject, Chassis chassis,
			Slot slot, Board board) {
		Vector portList = new Vector();
		final int type = board.getType();
		if (type == GeponInventoryConstants.BOARD_TYPE_GSM
				|| type == GeponInventoryConstants.BOARD_TYPE_GEM
				|| type == GeponInventoryConstants.BOARD_TYPE_XGM
                || type == 103 ) {
			portList = getOltPort(board);
		} else if (type == GeponInventoryConstants.BOARD_TYPE_LTM
//				|| type == GeponInventoryConstants.BOARD_TYPE_EPM
				|| type == GeponInventoryConstants.BOARD_TYPE_GPM ) {
			portList = getGePort(board);
		}

		final int specType = board.getType();
		if ( type == GeponInventoryConstants.BOARD_TYPE_CSM && 
				specType == GeponInventoryConstants.BOARD_ST_CSM1B ) {
			portList = getGePort(board);
		}
		
		return portList;
	}

	private Vector getOltPort(Board board) {
		Vector portList = new Vector();
		for (int i = 1; i <= board.getPortCount(); i++) {
			Port port = new Port();
			port.setIndex(Integer.toString(i));
			
			int specType = board.getSpecificType();
			if ( specType == GeponInventoryConstants.BOARD_ST_GPM1A ) {
				port.setBandwidth(GeponInventoryConstants.PORT_SPEED_1000M);
			} else {
				port.setBandwidth(GeponInventoryConstants.PORT_SPEED_2500M);
			}
			
			port.setInterfaceType(GeponInventoryConstants.PORT_INTERFACE_TDM);
			port.setMediaType(GeponInventoryConstants.PORT_MEDIA_FIBER);
			port
					.setApplicationType(GeponInventoryConstants.PORT_APPLICATION_ACCESS);
			portList.add(port);
		}

		return portList;
	}

	private Vector getGePort(Board board) {
		Vector portList = new Vector();

		for (int i = 1; i <= board.getPortCount(); i++) {
			Port port = new Port();
			port.setIndex(Integer.toString(i));
			port.setBandwidth(GeponInventoryConstants.PORT_SPEED_1000M);
			port
					.setInterfaceType(GeponInventoryConstants.PORT_INTERFACE_ETHERNET);
			port.setMediaType(GeponInventoryConstants.PORT_MEDIA_FIBER);
			port
					.setApplicationType(GeponInventoryConstants.PORT_APPLICATION_UPLINK);
			portList.add(port);
		}

		return portList;
	}

	String getNodeAddr(ULManagedObject mo) {
		return ((ULNode) mo).getIpAddress();
	}

	int getNodePort(ULManagedObject mo) {
		return ((ULNode) mo).getSnmpport();
	}

	String getNodeVersion(ULManagedObject mo) {
		return ((ULNode) mo).getVersion();
	}

	String getNodeType(ULManagedObject mo) {
		return mo.getType();
	}

	String getReadCommunity(ULManagedObject mo) {
		return ((ULNode) mo).getCommunity();
	}

	private String getDisSlotIndex(int slot, String neType, String neVersion) {
		if (neType.equals("FBW5000")) {
			if (slot == 13) {
				return "A";
			}
			if (slot == 14) {
				return "B";
			}
			return String.valueOf(slot);
		}

		return String.valueOf(slot);
	}

	private int getSlotNumber(String slot) {
		if (slot.equals("A")) {
			return 13;
		}
		if (slot.equals("B")) {
			return 14;
		}

		return Integer.parseInt(slot);
	}

	public List getOnuList(ULManagedObject aManagedObject, Chassis chassis) {
		ULNode node = (ULNode) aManagedObject;
		try {
			String neType = node.getType();
			String neVersion = SnmpUtility.getNeVersion(neType, node
                    .getIpAddress(), node.getSnmpport(), node.getCommunity());
			System.out.println("NE Type: " + neType);

			if (neType.equals("FBW5000")) {

					return getOnuListByNewMib(aManagedObject, chassis);

			} else if (neType.equals("FBW3000") || neType.equals("FBW2000")) {

					return getOnuListByNewMib(aManagedObject, chassis);

			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return null;
	}

	private List getOnuListByNewMib(ULManagedObject aManagedObject,
			Chassis chassis) {
		Vector v = new Vector();
		SnmpParameter param = new SnmpParameter(
				getNodeAddr(aManagedObject), getNodePort(aManagedObject));
		param.setReadCommunity(getReadCommunity(aManagedObject));
		SnmpProxy proxy = new SnmpProxy(param);

		OnuTrafficProfileTable mbean = new OnuTrafficProfileTable(proxy);

		try {
			Vector mibVector = mbean.retrieveAll();
			for (int i = 0; i < mibVector.size(); i++) {
				OnuTrafficProfileTable bean = (OnuTrafficProfileTable) mibVector
						.get(i);
                //remove such restrict to make all onu available on inventory data model
//                int interfaceType = OnuMODHelper.getOnuInterfaceType(bean.getUtsDot3Onu2CtcOnuModel());
//                if (interfaceType == 200){
//                    continue;
//                }

                /*
				Onu onu = new Onu();
				onu.setChassisIndex("1");
				onu.setBoardIndex("" + bean.getUtsDot3OnuTProfModuleId());
				onu.setPortIndex("" + bean.getUtsDot3OnuTProfPortId());
				onu.setIndex("" + bean.getUtsDot3OnuTProfLogicalPortId());

				onu.setInterfaceType(OnuMODHelper.getOnuInterfaceType(bean
						.getUtsDot3Onu2CtcOnuModel()));
				onu.setDownCommittedBandwidth(""
						+ bean.getUtsDot3OnuDownstreamCir());
				onu.setDownMaxBandwidth("" + bean.getUtsDot3OnuDownstreamPir());
				onu.setDownMaxBurstSize(""
						+ bean.getUtsDot3OnuDownstreamMaxBurstSize());
				onu.setUpCommittedBandwidth(""
						+ bean.getUtsDot3OnuUpstreamCir());
				onu.setUpMaxBandwidth("" + bean.getUtsDot3OnuUpstreamPir());
				onu.setUpMaxBurstSize(""
						+ bean.getUtsDot3OnuUpstreamMaxBurstSize());

                */

                GeponONU onu = new GeponONU();

                onu.setFChassisIndex("1");
                onu.setFBoardIndex("" + bean.getUtsDot3OnuTProfModuleId());
                onu.setFPortIndex("" + bean.getUtsDot3OnuTProfPortId());
                onu.setFIndex("" + bean.getUtsDot3OnuTProfLogicalPortId());

//                onu.setHardwareType(bean.getUtsDot3Onu2CtcOnuModel());
//                onu.setHardwareVersion(new String(bean.getUtsDot3Onu2CtcSerialNumber()));
				v.add(onu);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return v;
	}


	protected int getOnuInterfaceType(long type) {
		if (type == 1) // ONT101
			return 41;

		if (type == 2) // ONT408t
			return 42;

		return 200; // Unknown
	}

	protected int getOnuUniPort(String model) {
		if (model != null) {
			if (model.equals("A002")) // ONU204i
				return 4;

			if (model.equals("A003")) // ONU404i
				return 4;

			if (model.equals("A004")) // ONU804i
				return 4;

			if (model.equals("A005")) // ONU208i
				return 8;

			if (model.equals("A007")) // ONU2004i
				return 4;

			if (model.equals("A008")) // CLT2060
				return 8;

			if (model.equals("A009")) // ONU2024i
				return 24;

			if (model.equals("A00A")) // ONU408T(ONU4024i actually)
				return 8;

			if (model.equals("A018")) // ONU408t
				return 8;

			if (model.equals("A022")) // ONU4024t
				return 24;
		}

		return 1; // default value
	}

	protected int getOnuUniPort(long model) {
		if (model == 2)
			return 8;

		return 1; // default value
	}

	private int getOnuUsedUniPort(ULManagedObject aManagedObject, int module,
			int port, int onu, int totalUniPort, String onuType) {
		if (totalUniPort > 1) {
			int usedUniPort = 0;

			if (onuType.equalsIgnoreCase("A019")) { // B1205-Y
				return 1;
			} else if (onuType.equalsIgnoreCase("A003")) { // ONU404i
				SnmpParameter param = new SnmpParameter(
						getNodeAddr(aManagedObject),
						getNodePort(aManagedObject));
				StringBuffer sb = new StringBuffer(
						getReadCommunity(aManagedObject));
				sb.append("#OLTchassis:1");
				sb.append("#OLTmodule:").append(module);
				sb.append("#OLTport:").append(port);
				sb.append("#ONU:").append(onu);
				param.setReadCommunity(sb.toString());
				SnmpProxy proxy = new SnmpProxy(param);

				String[] oid = new String[] { ".1.3.6.1.4.1.41355.1.3.10.100.17.3.1.1.1.2" };
				try {
					Vector v = proxy.loadTable(oid, new int[] { 1 }, 1);
					for (int i = 0; i < v.size(); i++) {
						Object[] row = (Object[]) v.get(i);
						if ((Integer) row[0] <= totalUniPort
								&& (Integer) row[1] == 1) { // 1:up.
							usedUniPort++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (onuType.equals("A018")) { // ONU408t
				SnmpParameter param = new SnmpParameter(
						getNodeAddr(aManagedObject),
						getNodePort(aManagedObject));
				StringBuffer sb = new StringBuffer(
						getReadCommunity(aManagedObject));
				sb.append("#OLTchassis:1");
				sb.append("#OLTmodule:").append(module);
				sb.append("#OLTport:").append(port);
				sb.append("#ONU:").append(onu);
				param.setReadCommunity(sb.toString());
				SnmpProxy proxy = new SnmpProxy(param);

				String[] oid = new String[] { ".1.3.6.1.4.1.41355.1.3.10.100.19.3.1.1.1.2" };
				try {
					Vector v = proxy.loadTable(oid, new int[] { 1 }, 1);
					for (int i = 0; i < v.size(); i++) {
						Object[] row = (Object[]) v.get(i);
						if ((Integer) row[0] <= totalUniPort
								&& (Integer) row[1] == 1) { // 1:up.
							usedUniPort++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (onuType.equals("A022")) { // ONU408t
				SnmpParameter param = new SnmpParameter(
						getNodeAddr(aManagedObject),
						getNodePort(aManagedObject));
				StringBuffer sb = new StringBuffer(
						getReadCommunity(aManagedObject));
				sb.append("#OLTchassis:1");
				sb.append("#OLTmodule:").append(module);
				sb.append("#OLTport:").append(port);
				sb.append("#ONU:").append(onu);
				param.setReadCommunity(sb.toString());
				SnmpProxy proxy = new SnmpProxy(param);

				String[] oid = new String[] { ".1.3.6.1.2.1.2.2.1.7" };
				try {
					Vector v = proxy.loadTable(oid, new int[] { 1 }, 1);
					for (int i = 0; i < v.size(); i++) {
						Object[] row = (Object[]) v.get(i);
						if ((Integer) row[0] <= totalUniPort
								&& (Integer) row[1] == 1) { // 1:up.
							usedUniPort++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (onuType.equals("A00A")) { // ONU408T (ONU4024i
				// actually)
				SnmpParameter param = new SnmpParameter(
						getNodeAddr(aManagedObject),
						getNodePort(aManagedObject));
				StringBuffer sb = new StringBuffer(
						getReadCommunity(aManagedObject));
				sb.append("#OLTchassis:1");
				sb.append("#OLTmodule:").append(module);
				sb.append("#OLTport:").append(port);
				sb.append("#ONU:").append(onu);
				param.setReadCommunity(sb.toString());
				SnmpProxy proxy = new SnmpProxy(param);

				String[] oid = new String[] { ".1.3.6.1.4.1.41355.1.3.10.100.4024.3.1.1.1.2" };
				try {
					Vector v = proxy.loadTable(oid, new int[] { 1 }, 1);
					for (int i = 0; i < v.size() && i < 8; i++) {
						Object[] row = (Object[]) v.get(i);
						if ((Integer) row[0] <= totalUniPort
								&& (Integer) row[1] == 1) { // 1:up.
							usedUniPort++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return usedUniPort;
		}

		return 1;
	}
	
    public List<GeponONU> getGeponONUList( ULManagedObject ulMO, Chassis chassis ) {

		return null;
    }

}