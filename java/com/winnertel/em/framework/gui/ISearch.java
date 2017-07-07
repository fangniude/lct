package com.winnertel.em.framework.gui;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Vector;

public interface ISearch {
    public void stopSearch();

    public Vector<TreePath> search(TreeNode context, String text);
}
