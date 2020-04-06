package leetcode;

import tree.TreeNode;

public class KthSmallestElementInABST {
    private int result;

    private int visited;

    public int kthSmallest(TreeNode root, int k) {
        midTravel(root,k);
        return result;
    }

    private void midTravel(TreeNode root,int k){
        if(root!=null){
            midTravel(root.left,k);
            visited++;
            if(visited==k) {
                result = root.val;
                return;
            }
            midTravel(root.right,k);
        }
    }

    public static void main(String[] args) {

        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        kthSmallestElementInABST.kthSmallest(treeNode,1);
    }
}
