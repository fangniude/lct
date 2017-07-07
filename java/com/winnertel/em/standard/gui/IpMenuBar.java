package com.winnertel.em.standard.gui;

import com.winnertel.em.framework.IApplication;
import com.winnertel.em.standard.gui.action.ExitAction;

import javax.swing.*;

public class IpMenuBar extends JMenuBar {

    public IpMenuBar(final IApplication anApplication) {
        JMenu mnuFile = new JMenu(anApplication.getGlobalStringMap().getString("File"));
        mnuFile.setMnemonic('f');
        add(mnuFile);

        JMenuItem mniExit = new JMenuItem(anApplication.getGlobalStringMap().getString("Exit"));
        mniExit.setMnemonic('x');
        mniExit.addActionListener(new ExitAction(anApplication));
        mnuFile.add(mniExit);
    }

}
