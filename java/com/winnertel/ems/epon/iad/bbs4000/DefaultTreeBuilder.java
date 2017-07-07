package com.winnertel.ems.epon.iad.bbs4000;

import com.winnertel.ems.epon.iad.bbs4000.gui.action.DynamicFunctionTreeNodeAction;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.device.IDeviceManager;
import com.winnertel.em.framework.gui.swing.tree.BaseNodeDecorator;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNode;
import com.winnertel.em.framework.gui.swing.tree.FunctionTreeNodeObject;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.net.URL;
import java.util.List;
import java.util.Properties;

public class DefaultTreeBuilder extends BaseNodeDecorator {
    private IDeviceManager fDeviceManager = null;

    public DefaultTreeBuilder(IApplication anApplication) {
        super(anApplication);
    }

    public void decorateNode(FunctionTreeNode aNode) {
        FunctionTreeNodeObject userObject = (FunctionTreeNodeObject) aNode.getUserObject();
        fDeviceManager = userObject.getDeviceManager();

        try {
            URL url = getClass().getClassLoader().getResource("com/winnertel/ems/epon/iad/bbs4000/FunctionTreeNode.xml");
            if (url != null) {
                String id = userObject.getId();
                String version = fDeviceManager.getVersion();

                SAXBuilder builder = new SAXBuilder();
                Element root = builder.build(url).getRootElement();

                List list = root.getChildren();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        Element neElement = (Element) list.get(i);

                        String neType = neElement.getAttributeValue("type");
                        String neVersion = neElement.getAttributeValue("version");
                        neVersion = neVersion.replace(';', ',');
                        String[] split = neVersion.split(",");

                        if(neType.equals(id) && isSupported(split, version)) {

                            List nodeList = neElement.getChildren();

                            for(int j = 0; j < nodeList.size(); j++) {
                                buildNode(aNode, (Element) nodeList.get(j));
                            }
                            
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isSupported(String[] versions, String version) {

        for(int i = 0; i < version.length(); i++) {
            if(versions[i].equals(version)) return true;
        }
        
        return false;
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