package leetcode;

import tree.TreeNode;

public class SumofRootToLeafBinaryNumbers {
    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        getSum(root,"");
        return res;
    }

    void getSum(TreeNode root,String s){
        if(root == null)return;
        s = s + root.val;
        if(root.left == null && root.right == null){
            int i=Integer.parseUnsignedInt(s,2);
            res += i;
            return;
        }
        if(root.left!=null){
            getSum(root.left,s);
        }
        if(root.right!=null){
            getSum(root.right,s);
        }
    }

    /**
     * leetcode
     * @param root
     * @return
     */
    public int sumRootToLeafLC(TreeNode root) {
        getSum(root,0);
        return res;
    }

    /**
     * leetcode
     * 优化，加法的实质，或运算 + 进位
     * @param root
     * @param val
     */
    void getSum(TreeNode root,int val){
        if(root == null)return;
        val = val<<1|root.val;
        if(root.left == null && root.right == null){
            res += val;
            return;
        }
        if(root.left!=null){
            getSum(root.left,val);
        }
        if(root.right!=null){
            getSum(root.right,val);
        }
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(1);
        TreeNode t12 = new TreeNode(1);
        TreeNode t13 = new TreeNode(1);
        TreeNode t14 = new TreeNode(1);
        TreeNode t01 = new TreeNode(0);
        TreeNode t02 = new TreeNode(0);
        TreeNode t03 = new TreeNode(0);
        TreeNode t04 = new TreeNode(0);
        t11.left = t01;t11.right = t12;t01.left = t02;t01.right = t13;
        t12.left = t03;
        t12.right = t14;
        SumofRootToLeafBinaryNumbers sumofRootToLeafBinaryNumbers = new SumofRootToLeafBinaryNumbers();
        sumofRootToLeafBinaryNumbers.sumRootToLeaf(t11);
    }
}
