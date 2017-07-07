package com.winnertel.ems.epon.iad.inventory.model;

public class PortNode extends InventoryNode  {
    String portId;
    String fLabel;
    public PortNode(String portId,String aLabel){
        this.portId = portId;
        
        fLabel =aLabel;
    }
    public String getSearchId() {
        return portId;
    }
//  public#OLTchassis:1#OLTmodule:1#OLTport:1#ONU:1
    public String toString(){
        return fLabel;
    }
 
}