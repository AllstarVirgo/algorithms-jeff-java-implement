package leetcode;

import tree.TreeNode;

/**
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 *
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 * leetcode 1315
 */
public class SumOfNodesWithEvenValuedGrandparent {
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        helper(root,null,null);
        return sum;
    }

    void helper(TreeNode root,TreeNode parent,TreeNode grandparent){
        if(root == null)return;
        if(grandparent!=null && grandparent.val%2 == 0)sum += root.val;
        //用parent迭代grandparent。递归+迭代
        helper(root.left,root,parent);
        helper(root.right,root,parent);
    }
}
