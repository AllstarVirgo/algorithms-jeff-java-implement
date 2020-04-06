package leetcode;

import tree.TreeNode;

public class DiameterOfBinaryTree {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root){
        if(root!=null){
            int left = 0,right = 0;
            if(root.left!=null)
                left = 1 + helper(root.left);
            if(root.right!=null)
                right = 1 + helper(root.right);
            int path = left + right ;
            if(path>res){
                res = path;
            }
            return Math.max(left,right);
        }else
            return 0;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        diameterOfBinaryTree.diameterOfBinaryTree(treeNode1);
    }
}
