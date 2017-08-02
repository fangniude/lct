package com.winnertel.ems.epon.topo.impl;

import com.winnertel.ems.epon.iad.bbs4000.ConfigUtility;
import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATDevInfoGroup;
import com.winnertel.ems.epon.iad.eoc.mib.ModEoCCBATNetworkAttrGroup;
import com.winnertel.ems.epon.topo.model.CBAT;
import com.winnertel.em.framework.model.snmp.ISnmpProxy;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.em.standard.snmp.SnmpProxy;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import com.winnertel.nms.lite.configfilereader.DVMInfo;
import com.winnertel.nms.lite.configfilereader.LiteReleaseInfoReader;
import com.winnertel.nms.lite.momodel.ManagedElement;
import com.winnertel.nms.lite.util.APIUtil;
import com.winnertel.nms.topodb.ULNode;
import com.winnertel.snmp.snmp2.SnmpOID;
import com.winnertel.snmp.snmp2.SnmpVarBind;

import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Rex
 * Date: 13-3-6
 * To change this template use File | Settings | File Templates.
 */
public class CreateFBW extends DefaultNodeCreator {
    static {
        SnmpUtility.addNETypeMapping(".1.3.6.1.4.1.45121.1.3.10.2.2", "FBW3000");
        SnmpUtility.addNETypeMapping(".1.3.6.1.4.1.45121.1.3.10.2.1", "FBW2000");
        SnmpUtility.addNETypeMapping(".1.3.6.1.4.1.45121.1.3.10.2.3", "FBW5000");
        SnmpUtility.addNETypeMapping(".1.3.6.1.4.1.17409.2.4.1.1.4", "CLT2161A");
    }

    @Override
    public boolean isForNEType(String neType) {
        neType = neType.trim();
        Iterator iterator = LiteReleaseInfoReader.getEMSInfo("epon").dvms.iterator();
        while( iterator.hasNext() ) {
            DVMInfo dvm = (DVMInfo) iterator.next();
            if( dvm.getSupportNEType().equalsIgnoreCase( neType ) ) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void checkValid(Properties neProperty) throws Exception {
        String installedNeType = neProperty
                .getProperty(PropertyConstant.NE_TYPE);
        System.out.println("CreateFBW:" + installedNeType );
        if( "CLT2161A".equalsIgnoreCase( installedNeType) ) {
            String neIP = neProperty.getProperty(PropertyConstant.NE_IP_ADDRESS)
                    .trim();


            if (isIpAddressInUse(neIP)) {
                throw new Exception("The specified IP " + neIP + " has existed.");
            }

            String community = neProperty.getProperty(
                    PropertyConstant.NE_GET_COMMUNITY, "public").trim();

            // SNMP ping ip address before add NE
            if (!SnmpUtility.snmpPing(neIP, 161, community)) {
                throw new Exception("The specified IP " + neIP + " is inactive.");
            }

        } else {

            super.checkValid(neProperty);
        }

    }


    @Override
    protected Vector createImpl(ULNode tmpNode) throws Exception {
        System.err.println("CreateImpl: " + tmpNode );
        if( "CLT2161A".equalsIgnoreCase(tmpNode.getType()) ) {
            tmpNode.getProperties().remove("typecategory");
        }

        Vector retVec = new Vector();
        if( "CLT2161A".equalsIgnoreCase(tmpNode.getType()) ) {
            ManagedElement cbat = toME( tmpNode );
            retVec.add( APIUtil.getTopoAPI().addMO( cbat ) );
        } else {
            retVec.addAll( super.createImpl( tmpNode ) );
        }
        System.err.println("CreateImpl: " + retVec.size() );
        return retVec;
    }

    protected boolean syncImpl( ULNode node) throws Exception {
        if( "CLT2161A".equalsIgnoreCase( node.getType()) ) {
            ManagedElement cbat = toME( node );
            APIUtil.getTopoAPI().updateMO( cbat );
            return true;
        } else {
            return super.syncImpl( node );
        }
    }

    private ManagedElement toME( ULNode node ) throws Exception {
        ModEoCCBATDevInfoGroup mbean = null;
        ModEoCCBATNetworkAttrGroup mbean1 = null;
        try{
            mbean = new ModEoCCBATDevInfoGroup(getSnmpProxy(node.getIpAddress(), node.getSnmpport(), node.getCommunity()));
            mbean1 = new ModEoCCBATNetworkAttrGroup(getSnmpProxy(node.getIpAddress(), node.getSnmpport(), node.getCommunity()));
            mbean.retrieve();
            mbean1.retrieve();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("The specified IP " + node.getIpAddress() + " is inactive.");
        }

        String mibVersion = "4.0.0";
        CBAT cbat= new CBAT();

        cbat.setType(node.getType());
        cbat.setMibVersion(mibVersion);
        String swVersion = mbean.getModEoCCBATAdminSoftwareVersion();
        if (swVersion == null || "".equals(swVersion)){
            swVersion = "1.0.0";
        }
        cbat.setSoftwareVersion(swVersion);

        cbat.setVenderVersion(swVersion);
        cbat.setManufactoryInfo(mbean.getModEoCCBATAdminManufactoryInfo());
        cbat.setSerialNumber(mbean.getModEoCCBATAdminSerialNumber());
        cbat.setHardwareVersion(mbean.getModEoCCBATAdminHardwareVersion());
        cbat.setAdminModelNumber(mbean.getModEoCCBATAdminModelNumber());
        cbat.setMacAddress(ConfigUtility.OctetToMacAddress(mbean1.getModEoCCBATAdminMACAddress()));

        cbat.setIpAddress(node.getIpAddress());
        cbat.setMOName(node.getName());
        cbat.setUserLabel(node.getDisplayName());
        cbat.setSelectedDomainId(node.getProperty("SelectedDomainId"));
        cbat.setReadCommunity( node.getCommunity() );
        cbat.setWriteCommunity( node.getWriteCommunity() );
        cbat.setSnmpPort(node.getSnmpport());
        cbat.setSnmpVersion(node.getSnmpVersion());
        cbat.setOperationalState(1);
        cbat.setCommunicationState(ManagedElement.USAGE_REACHABLE);
        cbat.setOnuName("default onu name");

        Properties otherProps = (Properties)node.getProperties().clone();
        otherProps.remove(CBAT.s_SWVersion);
        otherProps.remove(CBAT.s_ReadCommunity);
        otherProps.remove(CBAT.s_WriteCommunity);
        otherProps.remove(CBAT.n_SNMPPort);
        otherProps.remove(CBAT.s_SNMPVersion);
        cbat.setProperties(otherProps);
        return cbat;
    }

    private ISnmpProxy getSnmpProxy(String ipAddress, int snmpport, String community) {
        SnmpParameter param = new SnmpParameter(ipAddress, snmpport);
        param.setReadCommunity(community);
        return new SnmpProxy(param);
    }

    @Override
    protected String getNeVersion( String neType, String ip, int port, String getCommunity ) throws Exception {
        com.winnertel.snmp.beans.SnmpTarget target = new com.winnertel.snmp.beans.SnmpTarget();
        target.setTimeout(1);
        target.setRetries(0);
        target.setAttemptPartial(true);

        target.setTargetHost(ip);
        target.setCommunity(getCommunity);
        target.setTargetPort(port);

        String version = "";

        try {
            if (neType.equalsIgnoreCase("FBW5000")) {
                String[] oidList = new String[]{
                        ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.6.13",
                        ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.12.13",
                        ".1.3.6.1.4.1.45121.1.3.10.200.6.2.1.1.1.1.12.14"
                };

                target.setObjectIDList(oidList);

                SnmpVarBind[] varBind = target.snmpGetVariableBindings();

                if (varBind[0].getVariable().getVarObject().toString().equals("2")) {
                    version = varBind[1].getVariable().getVarObject().toString();
                } else {
                    version = varBind[2].getVariable().getVarObject().toString();
                }
            } else if (neType.equalsIgnoreCase("FBW3000") || neType.equalsIgnoreCase("FBW2000") ){
                target.setSnmpOID(new SnmpOID(".1.3.6.1.4.1.45121.1800.2.1.1.1.1.7.3"));

                Object result = target.snmpGet();
                if (result != null) {
                    version = result.toString();
                }
            } else {
                version = "1.1.0";
            }
        } catch (Throwable e) {

            throw new Exception("NE can't support the NE version information.");
        }

        return trimVersion(version);
    }

    private static String trimVersion(String version) {
        version = version.substring(version.lastIndexOf("_") + 1);
        System.out.println("string after '_': " + version);
        StringTokenizer tokenizer = new StringTokenizer(version, ".");
        String s = "";
        version = "";
        int count = tokenizer.countTokens() < 3 ? tokenizer.countTokens() : 3;
        for (int i = 0; i < count; i++) {
            s = tokenizer.nextToken();
            try {
                version = version + "." + Integer.parseInt(s);
            } catch (NumberFormatException e) {
                version = version + "." + s;
            }
        }

        if (version.startsWith("."))
            version = version.substring(1);

        return version;
    }
}
