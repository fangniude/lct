package com.winnertel.ems.epon.iad.framework.gui.shelfview.factory;

import com.winnertel.tgcl.model.Card;
import com.winnertel.tgcl.model.TypeInfo;
import com.winnertel.tgcl.model.Holder;
import com.winnertel.tgcl.UDataBox;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.util.log.ILogger;
import com.winnertel.em.framework.util.log.LoggerController;
import com.winnertel.ems.epon.iad.framework.util.VersionUtil;

import java.util.HashMap;
import java.util.List;
import java.net.URL;
import java.awt.*;

import org.jdom.Element;

import javax.swing.*;

public class DefaultCardFactory implements IHolderFactory {
    private ILogger fLogger = LoggerController.createLogger(DefaultCardFactory.class);

    private IApplication fApplication;
    private HashMap<String, ImageIcon> cache = new HashMap<String, ImageIcon>();

    public DefaultCardFactory(IApplication app) {
        fApplication = app;
    }

    public void parse(Element element) {
        cache.clear();

        if(element == null) return;
        
        String neVersion = fApplication.getActiveDeviceManager().getVersion();
        List<Element> lModule = element.getChildren("module");

        for (Element eModule : lModule) {
            String name = eModule.getAttributeValue("name");
            String icon = eModule.getAttributeValue("icon");
            String version = eModule.getAttributeValue("version");

            if (version == null || VersionUtil.isSupported(version, neVersion)) {

                ImageIcon image = createImage(icon);

                if (image != null) {
                    cache.put(name, image);
                } else {
                    fLogger.error("Can't create icon: " + icon);
                }
            }
        }
    }

    protected static ImageIcon createImage(String imgfile) {
        URL url = DefaultCardFactory.class.getClassLoader().getResource(imgfile);
        if(url != null) {
            return new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
        }

        return null;
    }

    public Card create(String type) {
        Card card = new Card();

        card.setTypeInfo(new TypeInfo(type));
        card.setImage(cache.get(type));

        return card;
    }

    public void addChild(UDataBox box, Holder parent, Holder child) {
    }
}
