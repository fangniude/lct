package com.winnertel.ems.epon.iad.bbs4000.gui.r100;

import java.util.Vector;

public class VlanPriorityBitMapModel {

	private Vector<String> priorityBitMap = new Vector<String>();
	
	
	public VlanPriorityBitMapModel(){
//		  Bit0  Priority 0
//	 	  Bit1  Priority 1
//	 	  Bit2  Priority 2
//	 	  Bit3  Priority 3
//	 	  Bit4  Priority 4
//	 	  Bit5  Priority 5
//	 	  Bit6  Priority 6
//	 	  Bit7  Priority 7
		for(int i=0;i<8;i++)
			priorityBitMap.add("Priority "+i);
	}
	
	public Vector<String> getPriorityBitMap(){
		return priorityBitMap;
	}
	
	public int priorityBitMapToLong(Vector<String> bitMap){
		
		int value = 0;
		if(bitMap.contains("Priority 0")) value += 1;
		if(bitMap.contains("Priority 1")) value += 2;
		if(bitMap.contains("Priority 2")) value += 4;
		if(bitMap.contains("Priority 3")) value += 8;
		if(bitMap.contains("Priority 4")) value += 16;
		if(bitMap.contains("Priority 5")) value += 32;
		if(bitMap.contains("Priority 6")) value += 64;
		if(bitMap.contains("Priority 7")) value += 128;
		
		return value;
	}
	
	public Vector<String> priorityBitMapToVector(long value){
		Vector<String> bitMap = new Vector<String>();
		if((value&1) != 0) bitMap.add("Priority 0");
		if((value&2) != 0) bitMap.add("Priority 1");
		if((value&4) != 0) bitMap.add("Priority 2");
		if((value&8) != 0) bitMap.add("Priority 3");
		if((value&16) != 0) bitMap.add("Priority 4");
		if((value&32) != 0) bitMap.add("Priority 5");
		if((value&64) != 0) bitMap.add("Priority 6");
		if((value&128) != 0) bitMap.add("Priority 7");
				
		return bitMap;
	
	}
}
