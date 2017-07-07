package com.winnertel.ems.lct;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class LctFrame extends JFrame {
	
	public LctFrame() {
		super("Frame0");
	}
	
	public void setLctComponent( Component c ) {
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(c, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(940, 640);
	}
	
	public void setLctNode( LctNode node ) {
        String nodeVersion = node.getNodeVersion();

		setTitle(node.getNodeType() + " " + nodeVersion + " - " + node.getNodeAddress());
	}
	
	public void dispose() {
        super.dispose();
        LctLogin.show();
    }
}
