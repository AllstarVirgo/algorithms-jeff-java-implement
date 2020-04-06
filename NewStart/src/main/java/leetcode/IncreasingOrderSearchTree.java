package leetcode;

import tree.TreeNode;

/**
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree
 * is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 */
public class IncreasingOrderSearchTree {
    TreeNode head = new TreeNode(-1);

    TreeNode cur = head;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return head.right;
    }


    void helper(TreeNode root){
        if(root==null)return;
        helper(root.left);
        //这里修改了节点的right，不会形成环
        cur.right = root;
        cur = cur.right;
        root.left = null;

        helper(root.right);
    }
}
