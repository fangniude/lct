package com.winnertel.ems.lct;

import java.util.Hashtable;

public class CommunityCtrlNode extends LctNode {
	@Override
	public void init( String neType, String ipAddr, Hashtable initInfo ) {				
		if( initInfo != null ) {
			try {
				fMeta.setReadCommunity( (String)initInfo.get( NodeMeta.KEY_READ_COMMUNITY ) );
				fMeta.setWriteCommunity( (String)initInfo.get( NodeMeta.KEY_WRITE_COMMUNITY ) );
			} catch ( Exception ex ) {
				throw new IllegalArgumentException("community is mandatory for " + ipAddr );
			}
		} else {
			throw new IllegalArgumentException("community is mandatory for " + ipAddr );
		}
		super.init( neType, ipAddr, initInfo );		
	}

    @Override
	protected void retrieveNodeVersion() {
		setNodeVersion("1.0.0");
	}

    @Override
	public boolean supportAccount() {
		return false;
	}

    @Override
	public String getReadCommunity() {
		return fMeta.getReadCommunity();
	}

    @Override
	public String getWriteCommunity() {
		return fMeta.getWriteCommunity();
	}

    @Override
	public boolean isVersionCheckingEnabled() {
		return false;
	}

    @Override
	public String toString() {

		return "IP=" + getNodeAddress() + ";TYPE=" + getNodeType() + ";"+NodeMeta.KEY_READ_COMMUNITY+"=" + 
					fMeta.getReadCommunity() + ";"+NodeMeta.KEY_WRITE_COMMUNITY+"=" + fMeta.getWriteCommunity();
	}

}
