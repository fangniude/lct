package com.winnertel.ems.epon.iad.util.text;

import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.JFrame;

import com.winnertel.em.standard.MainApplet;

public class textOpenDvm {
	public static void main(String[] args) {
        MainApplet applet = new MainApplet(true);
        applet.setParameterMap(parseArguments(args));
        JFrame frame = (JFrame) applet.getTopMostFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        applet.init();
        applet.start();
        frame.setVisible(true);
        applet.launch();
    }
	
	private static Properties parseArguments(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No argument passed to main method");
        }

        Properties paramList = new Properties();
        try {
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                StringTokenizer st = new StringTokenizer(arg, "=");
                paramList.put(st.nextToken(), st.nextToken());
            }
        } catch (Exception ex) {
            showUsage();
        }

        return paramList;
    }
	
	private static void showUsage() {
        System.out.println("Usage: java MainApplet " + "param1=value1 param2=value2 ...");
    }
}
