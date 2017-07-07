package com.winnertel.ems.epon.iad.framework.gui.shelfview;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.util.MessageDialog;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.em.standard.gui.util.InstanceCreator;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.factory.DefaultCardFactory;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.factory.DefaultShelfFactory;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.factory.IHolderFactory;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.model.BBS4000DataModel;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.model.Board;
import com.winnertel.ems.epon.iad.framework.gui.shelfview.model.IDataModel;
import com.winnertel.ems.epon.iad.framework.util.VersionUtil;
import com.winnertel.tgcl.PopupMenuFactory;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.tgcl.background.Background;
import com.winnertel.tgcl.background.PictureBackground;
import com.winnertel.tgcl.equipment.UEquipment;
import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.Shelf;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.swing.*;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class ShelfView {
    private ILogger fLogger = LoggerController.createLogger(ShelfView.class);

    IApplication fApplication;

    //shelfview equipment
    private UEquipment equipment;
    private String background;
    
    private UDataBox dataSource;

    IDataModel model = null;

    private IHolderFactory shelfFactory;
    
    private IHolderFactory cardFactory;

    private PopupMenuFactory menuFactory;

    public ShelfView(IApplication app) {
        fApplication = app;
    }

    public void init() {
        parseXmlFile();
        equipment = getEquipment();
    }

    //get the equipment
    public UEquipment getEquipment() {
        if (equipment == null) {
            long t1 = System.currentTimeMillis();

            equipment = new UEquipment(getDataBox(), getBackground());
            equipment.setAllowDragMove(false);
            //set the toolbar invisible of the equipment view
            equipment.setToolbarVisible(false);

            equipment.getCanvasScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            equipment.getCanvasScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

            if(menuFactory != null) {
                equipment.getInteractor().setPopupMenuFactory(menuFactory);
            }

            System.out.println("new IlpEquipment: " + (System.currentTimeMillis() - t1));
        }

        return equipment;
    }

    //using the default background.
    protected Background getBackground() {
        if(background != null) {
            URL url = DefaultShelfFactory.class.getClassLoader().getResource(background);
            if(url != null) {
                return new PictureBackground(url);
            }
        }

        return null;
    }

    protected UDataBox getDataBox() {
        if (dataSource == null) {
            dataSource = new UDataBox(fApplication.getActiveDeviceManager().getName());
        }

        return dataSource;
    }

    protected void parseXmlFile() {
        try {
            String neType = fApplication.getActiveDeviceManager().getType();
            String neVersion = fApplication.getActiveDeviceManager().getVersion();

            String xmlFile = "com/winnertel/ems/epon/iad/framework/gui/shelfview/config/" + neType + ".xml";
            URL url = getClass().getClassLoader().getResource(xmlFile);

            if (url == null) {
                fLogger.error("Can not find the config file: " + xmlFile);

                String err = fApplication.getActiveDeviceManager().getGuiComposer().getString("Chassis_Config_File_Not_Found");
                MessageDialog.showErrorMessageDialog(fApplication, err);
                return;
            }

            SAXBuilder builder = new SAXBuilder();
            Element rootnode = null;
            try {
                if (url == null) {
                    return;
                }
                Document doc = builder.build(url);
                rootnode = doc.getRootElement();
            }
            catch (JDOMException e) {
                e.printStackTrace();
            }

            List lDevice = rootnode.getChildren("device");
            Iterator it = lDevice.iterator();
            while (it.hasNext()) {
                Element eDevice = (Element) it.next();
                String type = eDevice.getAttributeValue("type");
                String version = eDevice.getAttributeValue("version");

                if (neType.equals(type) && VersionUtil.isSupported(version, neVersion)) {

                    //get the data model.
                    String dataClass = eDevice.getAttributeValue("datasource");
                    if (dataClass != null) {
                        model = (IDataModel) InstanceCreator.instantiateObject(fApplication, dataClass);
                    }
                    //the class is not specified or error when loading class.
                    if (model == null) {
                        model = new BBS4000DataModel(fApplication);
                    }

                    //get the menu factory.
                    String menuClass = eDevice.getAttributeValue("popupmenufactory");
                    if (menuClass != null) {
                        menuFactory = (PopupMenuFactory) InstanceCreator.instantiateObject(fApplication, menuClass);
                    }
                    if (menuFactory == null) {
                        menuFactory = new DefaultPopupMenuFactory(fApplication);
                    }

                    background = eDevice.getAttributeValue("background");

                    //
                    Element eShelf = eDevice.getChild("shelf");
                    String factoryClass = eShelf.getAttributeValue("factory");
                    if(factoryClass != null) {
                        shelfFactory = (IHolderFactory)InstanceCreator.instantiateObject(fApplication, factoryClass);
                    }
                    if(shelfFactory == null) {
                        shelfFactory = new DefaultShelfFactory(fApplication);
                    }
                    shelfFactory.parse(eShelf);

                    //
                    Element eModules = eDevice.getChild("modules");
                    factoryClass = eModules.getAttributeValue("factory");
                    if(factoryClass != null) {
                        cardFactory = (IHolderFactory)InstanceCreator.instantiateObject(fApplication, factoryClass);
                    }
                    if(cardFactory == null) {
                        cardFactory = new DefaultCardFactory(fApplication);
                    }
                    cardFactory.parse(eModules);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void assemble() {
        Shelf shelf = (Shelf)shelfFactory.create("1");

        dataSource.addElement(shelf);

        
        List<Board> list = model.getModule(1);

        for(Board board : list) {
            Card card = (Card)cardFactory.create(board.getType());
            card.setUserObject("" + board.getId());
            card.setLabel(board.getId() + " - " + board.getType());
            
            shelfFactory.addChild(dataSource, shelf, card);
        }
    }

    protected void clear() {
        dataSource = new UDataBox(fApplication.getActiveDeviceManager().getName());
        equipment.setDataBox(dataSource, true);
    }

    public void refresh() {
        clear();
        assemble();
    }
}

