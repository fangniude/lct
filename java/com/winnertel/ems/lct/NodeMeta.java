package com.winnertel.ems.lct;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class NodeMeta {
	private String fNodeType;
	private String fNodeAddress;
	
	private Hashtable fAddition = new Hashtable();
	
	public NodeMeta() {
		super();
	}

	public String getNodeType() {
		return fNodeType;
	}

	public void setNodeType( String aNodeType ) {
		fNodeType = aNodeType;
	}

	public String getNodeAddress() {
		return fNodeAddress;
	}

	public void setNodeAddress( String aNodeAddress ) {
		fNodeAddress = aNodeAddress;
	}
	
	public String toString() {
		return getNodeAddress()+" ("+getNodeType().replace('_', ' ')+")";
	}

	public static NodeMeta toMeta( String str ) {
		String tIP = null;
		String tType = null;
		Hashtable ht = new Hashtable();
		
		StringTokenizer tokenizer = new StringTokenizer(str, ";");
		while( tokenizer.hasMoreTokens() ) {
			String token = tokenizer.nextToken();
			int i = token.indexOf("=");
			if( i != -1 ) {
				String key = token.substring( 0, i );
				String value = token.substring( i + 1 );
				if( "IP".equals( key ) ) {
					tIP = value;
				} else if ( "TYPE".equals( key ) ) {
					tType = value;
				} else {
					ht.put( key, value  );
				}
			}
		}
		
		if( tIP != null && tType != null ) {			
			return NodeMeta.createMeta( tType, tIP, ht );
		}
		return null;
	}
	
	private static NodeMeta createMeta( String type, String addr, Hashtable ht ) {
		NodeMeta meta = new NodeMeta( );
		meta.setNodeAddress( addr );
		meta.setNodeType( type );
		if( ht != null ) {
			meta.fAddition.putAll( ht );
		}		
		return meta;
	}
	
	public Map toMap() {
		
		HashMap map = new HashMap();
		map.put("TYPE", getNodeType() );
		map.put("IP", getNodeAddress() );	
		map.putAll( fAddition );
		
		return map;
	}
	

	public static final String KEY_READ_COMMUNITY = "read_community";
	public static final String KEY_WRITE_COMMUNITY = "write_community";

	
	public String getReadCommunity() {		
		return (String) fAddition.get(KEY_READ_COMMUNITY);
	}
	
	public String getWriteCommunity() {
		return (String) fAddition.get(KEY_WRITE_COMMUNITY);
	}
	
	public void setReadCommunity( String read ) {
		fAddition.put( KEY_READ_COMMUNITY, read );
	}
	
	public void setWriteCommunity( String write ) {
		fAddition.put( KEY_WRITE_COMMUNITY, write );
	}
	
}
