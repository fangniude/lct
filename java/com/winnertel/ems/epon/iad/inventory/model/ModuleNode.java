package com.winnertel.ems.epon.iad.inventory.model;
/*
 * 1-2 On OLT;
 * */
public class ModuleNode extends InventoryNode{
    String moduleId;
    String fLabel ; 
    public ModuleNode(String moduleId,String aLabel){
        this.moduleId = moduleId;
        fLabel  = aLabel;
    }
    public String getSearchId() {
        return moduleId;
    }
//  public#OLTchassis:1#OLTmodule:1#OLTport:1#ONU:1 
    public String toString(){
        return fLabel;
    }
}
