package pointtooffer;

import tree.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 注意：局部的更小的树不用算进去
 */
public class IsSubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null)return false;

        return isSameTree(root1,root2)|| isSameTree(root1.left,root2)|| isSameTree(root1.right,root2);
    }

    private boolean isSameTree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }

        if(root1==null)
            return false;

        if(root1.val!=root2.val)
            return false;

        return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }
}
