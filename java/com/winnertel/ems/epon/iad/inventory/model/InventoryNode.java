package com.winnertel.ems.epon.iad.inventory.model;
import java.util.Vector;

public abstract class InventoryNode  {
   
    public Vector children;
    public int getIndex( InventoryNode child ) {
        return children.indexOf( child );
    }

    public Object getChildAt( int index ) {
        return children.get( index );
    }
    public Object searchChild(String searchId){
        if (children==null) return null;
        int size = children.size();
        for (int i = 0 ;i< size ;i++){
        	InventoryNode node =(InventoryNode)children.get(i);
            if (node.getSearchId().equals(searchId)) return node;
        }
        return null;
    }
    public abstract String getSearchId();
    
    boolean selected = false;
   
   
    public void addChild( InventoryNode child ) {
        if (children ==null) children = new Vector();
        int size = children.size();
        int index =0;
          for (;index< size ;index++){
        	  InventoryNode node = (InventoryNode)children.get(index);
            int nodeid = Integer.parseInt(node.getSearchId());
            int sourceid = Integer.parseInt(child.getSearchId());
            if (sourceid<nodeid) break;
          }
          children.insertElementAt(child,index);
          return;
    }
    public int getChildCount() {
        if ( children == null ) {
            return 0;
        }
        return children.size();
    }
  
   public boolean haveChild(){
       return true;
   };
  
   
}
