package com.winnertel.ems.epon.iad.inventory.model;
/*
 * inventory process;
 * IPaddress -> module(1..2)->oltport 1..4 ->onuport(1..32),iad(1..32);
 *
 */
public class NENode  extends InventoryNode{
    String name;
    String label;
    public NENode(String name){
       this.name = name;
    }

    public NENode(String name, String label)
    {
      this.name = name;
      this.label = label;
    }

    public String getName()
    {
      return name;
    }

    public String getSearchId() {
		  return label == null? name:label;
	  }

  	public String toString(){
      return "Node_" + getSearchId();
    }
}