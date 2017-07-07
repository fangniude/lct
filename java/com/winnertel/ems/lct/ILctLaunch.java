package com.winnertel.ems.lct;

import java.awt.Component;

import javax.swing.JFrame;

public interface ILctLaunch {
	void initLctContext(LctNeContext context);
	void setParentFrame(JFrame frame);
	Component getUI();
}	
