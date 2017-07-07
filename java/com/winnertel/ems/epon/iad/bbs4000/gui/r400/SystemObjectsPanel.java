package com.winnertel.ems.epon.iad.bbs4000.gui.r400;

import com.winnertel.ems.epon.iad.bbs4000.mib.r400.SystemGlobalObjects;
import com.winnertel.em.framework.IApplication;
import com.winnertel.em.framework.gui.swing.UPanel;
import com.winnertel.em.standard.util.gui.layout.NTLayout;
import com.winnertel.em.standard.util.gui.layout.VSpacer;

public class SystemObjectsPanel extends UPanel {
    UPanel system = new SystemGlobalObjectsPanel(fApplication);
    UPanel inband = new SystemInbandObjectsPanel(fApplication);
    UPanel outband = new SystemOutbandObjectsPanel(fApplication);

    public SystemObjectsPanel(IApplication app) {
        super(app);
        setModel(new SystemGlobalObjects(app.getSnmpProxy()));
        init();
    }

    public void initGui() {
        NTLayout layout = new NTLayout(4, 1, NTLayout.FILL, NTLayout.FILL, 5, 3);
        layout.setMargins(6, 10, 6, 10);
        setLayout(layout);
        add(system);
        add(inband);
        add(outband);
        add(new VSpacer());
    }

    public void refresh() {
        system.refresh();
        inband.refresh();
        outband.refresh();
    }
}