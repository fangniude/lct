package com.winnertel.ems.lct.impl;


import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.model.OperationObject;
import com.winnertel.em.standard.MainApplet;
import com.winnertel.em.standard.device.DeviceManager;
import com.winnertel.em.standard.device.DvmUtil;
import com.winnertel.em.standard.gui.GuiComposer;
import com.winnertel.em.standard.resource.ResourceManager;
import com.winnertel.em.standard.snmp.SnmpParameter;
import com.winnertel.ems.lct.CommunityCtrlNode;
import com.winnertel.ems.lct.ILctLaunch;
import com.winnertel.ems.lct.LctNeContext;
import com.winnertel.ems.lct.log.GOT6000LctLogger;
import org.apache.commons.collections.map.ListOrderedMap;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;

public class FBW2000LCTApplet extends MainApplet implements ILctLaunch {
    private LctNeContext _context = null;

    @Override
    public Component getUI() {
        return FBW2000LCTApplet.this;
    }

    @Override
    public String getParameter(String key) {
        if( "NE_LCT_LOGGER".equalsIgnoreCase(key)) {
            return GOT6000LctLogger.class.getName();
        }
        return super.getParameter( key );
    }

    protected void createDeviceManagerList() {
        if (_context == null) {
            return;
        }

        fDeviceManagerMap = new ListOrderedMap();

        IDeviceManager dvm = new DeviceManager(fApplication);
        String nodeVer = _context.getLctNode().getNodeVersion();
        dvm.setName(_context.getLctNode().getNodeAddress());
        dvm.setDisplayName(_context.getLctNode().getNodeAddress());
        String type = _context.getLctNode().getNodeType();
        dvm.setType(type);
        if (DvmUtil.setDvmResourcePathAndVersion(fApplication, dvm, type, nodeVer)) {
            ResourceManager rm = new ResourceManager(dvm.getResourcePath(), fApplication, getLocale());
            dvm.setResourceManager(rm);
            dvm.setGuiComposer(new GuiComposer(fApplication, rm));
            fDeviceManagerMap.put(dvm.getName(), dvm);
        } else {
            System.err.println("Can't find configuration file for " + _context.getLctNode());
        }
        dvm.setReadCommunity(_context.getLctNode().getMeta().getReadCommunity());
        dvm.setWriteCommunity(_context.getLctNode().getMeta().getWriteCommunity());

        OperationObject oo = new OperationObject();
        oo.setManagedObject(dvm.getDisplayName());
        dvm.setOperationObject(oo);
        dvm.setProperties(_context.getLctNode().getProperties());

        if (fDeviceManagerMap != null) {
            IDeviceManager[] dvmList = new IDeviceManager[fDeviceManagerMap.size()];
            fDeviceManagerMap.values().toArray(dvmList);
            fApplication.setDeviceManagerList(dvmList);
        } else {
            fApplication.setDeviceManagerList(null);
        }

    }

    public void initLctContext(final LctNeContext context) {
        _context = context;
        Properties dvmPara = new Properties();
        CommunityCtrlNode node = (CommunityCtrlNode) context.getLctNode();
        dvmPara.put("neType", node.getNodeType());
        dvmPara.put("NodeIPAddress", node.getNodeAddress());
        dvmPara.setProperty(MainApplet.PARAM_COUNTRY, Locale.getDefault().getCountry());
        dvmPara.setProperty(MainApplet.PARAM_LANGUAGE, Locale.getDefault().getLanguage());
        dvmPara.setProperty("swVersion", node.getNodeVersion());
        dvmPara.setProperty("ReadCommunity", node.getReadCommunity());
        dvmPara.setProperty("WriteCommunity", node.getWriteCommunity());
        dvmPara.setProperty("SnmpVersion", "v2");
        dvmPara.setProperty("SnmpPort", "161");

        dvmPara.put("Debug", Boolean.TRUE.toString());
        dvmPara.setProperty("LCT_OP_LOGGER", "com.winnertel.ems.lct.log.GOT6000LctLogger");
        try {
            dvmPara.setProperty("ClientHostIP", InetAddress.getLocalHost().getHostName());
            dvmPara.setProperty("ClientHostName", InetAddress.getLocalHost().getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setParameterMap(dvmPara);

        CommunityCtrlNode n = (CommunityCtrlNode) context.getLctNode();
        SnmpParameter parameter = new SnmpParameter(n.getNodeAddress());
        parameter.setReadCommunity(n.getReadCommunity());
        parameter.setWriteCommunity(n.getWriteCommunity());

        setSnmpParameter(parameter);
    }

    public void setParentFrame(JFrame frame) {
        URL url = getClass().getResource("/com/winnertel/ems/lct/images/mainFrameIcon.gif");
        if (url != null) {
            frame.setIconImage(new ImageIcon(url).getImage());
        }
        frame.add(this);
        init();
        start();
        launch();
        initFocus();
    }
}
