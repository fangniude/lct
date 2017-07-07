package com.winnertel.ems.epon.iad.bbs4000;

import com.winnertel.ems.epon.iad.bbs4000.gui.action.DynamicFunctionTreeNodeAction;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.swing.tree.BaseNodeDecorator;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import com.winnertel.ems.epon.snmp.SnmpUtility;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.net.URL;
import java.util.List;
import java.util.Properties;

public class CMFunctionTreeBuilder extends BaseNodeDecorator {

    public static final String CM_BBS4000_NODE = "FBW5000";

    private IDeviceManager fDeviceManager = null;

    public CMFunctionTreeBuilder(IApplication anApplication) {
        super(anApplication);
    }

    public void decorateNode(FunctionTreeNode aNode) {
        FunctionTreeNodeObject userObject = (FunctionTreeNodeObject) aNode.getUserObject();
        fDeviceManager = userObject.getDeviceManager();
        String id = userObject.getId();
        if (id.equals(CM_BBS4000_NODE)) {
            buildTree(aNode);
        }
    }

    private void buildTree(FunctionTreeNode aNode) {
        try {
            URL url = getClass().getClassLoader().getResource("com/winnertel/ems/epon/iad/bbs4000/CMFunctionTreeNode.xml");
            if (url != null) {
                SAXBuilder builder = new SAXBuilder();
                Element root = builder.build(url).getRootElement();

                List list = root.getChildren();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        buildNode(aNode, (Element) list.get(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void buildNode(FunctionTreeNode node, Element element) {
        String id = element.getAttribute("id").getValue();
        String name = fDeviceManager.getGuiComposer().getString(id);
        String version = element.getAttributeValue("version");
        String neVersion = fDeviceManager.getVersion();

        //if the version is specified in xml file, check if the ne version is supported.
        if (version != null && version.indexOf(neVersion) == -1) {
            return;
        }

        if(version != null && version.equals("3.1.1.11") && neVersion.equals("3.1.1")) {
        	try {
				String ipAddress = fApplication.getSnmpProxy().getTargetHost();
				String getCommunity = fApplication.getSnmpProxy()
						.getReadCommunity();
				int port = fApplication.getSnmpProxy().getTargetPort();
				String neType = fDeviceManager.getType();
				String tVersion = SnmpUtility.getNeTotalVersion(fDeviceManager
						.getType(), ipAddress, port, getCommunity);
				if(tVersion!=null ) {
					String s = tVersion.substring(tVersion.lastIndexOf(".") + 1, tVersion.length());
					if("11".compareTo(s) > 0)
						return;
				}
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        }
        
        FunctionTreeNode childNode = createNode(id, name, fDeviceManager, fApplication, null, FunctionTreeNodeObject.BOARD);
        node.add(childNode);

        List list = element.getChildren();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                buildNode(childNode, (Element) list.get(i));
            }
        }
    }

    private static FunctionTreeNode createNode(String _nodeId, String _name, IDeviceManager _deviceManager, IApplication _application, Properties _keyContext, String _type) {
        FunctionTreeNodeObject nodeInfo;
        FunctionTreeNode node;
        DynamicFunctionTreeNodeAction action = new DynamicFunctionTreeNodeAction(_application);
        nodeInfo = new FunctionTreeNodeObject(_deviceManager, _nodeId, _name, action, null, _type);
        nodeInfo.setReadCommunity(_deviceManager.getReadCommunity());
        nodeInfo.setWriteCommunity(_deviceManager.getWriteCommunity());
        nodeInfo.setProperties(_keyContext);
        node = new FunctionTreeNode(nodeInfo);
        action.setFunctionTreeNode(node);

        return node;
    }

}