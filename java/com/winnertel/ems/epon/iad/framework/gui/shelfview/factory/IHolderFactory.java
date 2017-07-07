package com.winnertel.ems.epon.iad.framework.gui.shelfview.factory;

import org.jdom.Element;
import com.winnertel.tgcl.model.Holder;
import com.winnertel.tgcl.UDataBox;

public interface IHolderFactory {

    public void parse(Element element);

    public Holder create(String id);

    public void addChild(UDataBox box, Holder parent, Holder child);
}
