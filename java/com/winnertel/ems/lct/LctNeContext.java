package com.winnertel.ems.lct;

public class LctNeContext {

    private String neType;

	public LctNeContext ( LctNode aNode ) {
		lctNode = aNode;
		neType = aNode.getNodeType();
	}
	
	private LctNode lctNode = null;

	public LctNode getLctNode() {
		return lctNode;
	}
	
	public String getNodeType() {
		return lctNode.getNodeType();
	}
	
	public String getNodeAddress() {
		return lctNode.getNodeAddress();
	}
	
	public String getNodeVersion() {
		return lctNode.getNodeVersion();
	}

}
