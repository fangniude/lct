package com.winnertel.ems.epon.iad.framework.gui.shelfview.layout;

import org.jdom.Element;
import com.winnertel.tgcl.model.Holder;
import com.winnertel.tgcl.UDataBox;


public interface ILayout {
    public void parse(Element element);
    public void locate(UDataBox box, Holder parent, Holder holder);
}
