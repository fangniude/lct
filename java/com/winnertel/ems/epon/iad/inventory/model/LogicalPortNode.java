package com.winnertel.ems.epon.iad.inventory.model;
/*
 * 1..32
 * */
public class LogicalPortNode extends InventoryNode  {
    String logicalPortId;
    String fLabel;
    public LogicalPortNode(String logicalPortId,String aLabel){
        this.logicalPortId = logicalPortId;
        fLabel = aLabel;
    }
    public String getSearchId() {
        return logicalPortId;
    }

  //public#OLTchassis:1#OLTmodule:1#OLTport:1#ONU:1
    public String toString(){
        return fLabel;
    }
 
}