package com.winnertel.ems.epon.iad.inventory.model;
import java.util.Vector;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * @author hz03530
 */
public class InventoryTreeModel implements  TreeModel {
        NENode root;
        private Vector listeners;
        /*
         * only for test 
         * */
        public InventoryTreeModel(){
            /*root = new NENode("root");
              ModuleNode nnode = new ModuleNode("1");
               PortNode snode = new PortNode("4");
                 LogicalPortNode bnode = new LogicalPortNode("32");
                  IADNode pnode = new IADNode("32");
                  bnode.addChild(pnode);
                 snode.addChild(bnode);
               nnode.addChild(snode);
            root.addChild(nnode);*/
        }
        public InventoryTreeModel( NENode root ) {
            this.root = root;
        }

        public Object getRoot() {
            return root;
        }

        public Object getChild( Object parent, int index ) {
            InventoryNode node = ( InventoryNode ) parent;
            Object object =node.getChildAt( index );
            return object;
        }

        public int getChildCount( Object parent ) {
        	InventoryNode node = ( InventoryNode ) parent;
            return node.getChildCount();
        }

        public boolean isLeaf( Object node ) {
        	InventoryNode anode = ( InventoryNode ) node;
            return !anode.haveChild();
        }

        public void valueForPathChanged( TreePath path, Object newValue ) {
            System.out.println( ">>>>>>>>>>>>" );
        }

        public int getIndexOfChild( Object parent, Object child ) {
        	InventoryNode node = ( InventoryNode ) parent;
            return node.getIndex( ( InventoryNode )child );
        }

        public void addTreeModelListener( TreeModelListener l ) {
            //listeners.add(l);
        }

        public void removeTreeModelListener( TreeModelListener l ) {
            if (listeners==null) return;
            listeners.remove( l );
        }
    }
