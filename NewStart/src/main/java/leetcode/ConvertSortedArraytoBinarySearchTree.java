package leetcode;

import tree.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0,nums.length-1,nums);
    }


    TreeNode helper(int left,int right,int[] nums){
        if(left>right)return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(left <= (mid-1))
            root.left = helper(left,mid-1,nums);
        if((mid+1)<=right)
            root.right = helper(mid+1,right,nums);
        return root;
    }

    public static void main(String[] args) {
        int[] demo = {-10,-3,0,5,9};
        ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new ConvertSortedArraytoBinarySearchTree();
        TreeNode node = convertSortedArraytoBinarySearchTree.sortedArrayToBST(demo);
    }
}
