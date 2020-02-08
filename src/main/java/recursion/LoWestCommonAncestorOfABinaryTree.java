package recursion;

import tree.TreeNode;

/**
 * leetcode 236
 * 寻找任意两个点的公共祖先
 * 1、如果根节点为空，则返回null。如果根结点等于p或q，则返回根结点；
 * 2、按根结点的左右子树递归查找，如果命中p或q，则分别返回p、q，未命中返回null
 * 3、如果p、q均不为null，说明p、q分布在root的两别，返回root；
 * 4、如果只有p不为null，说明p、q分布在root的左子树，返回p；
 * 5、如果只有q不为null，说明p、q分布在root的左子树，返回q。
 */
public class LoWestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null||root == p||root == q)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null&&right!=null)
            return root;
        else if(left!=null)
            return left;
        else
            return right;
    }
}
