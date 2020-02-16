package leetcode;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumThree {
    int target;

    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> map = new HashMap<>();
        target = sum;
        map.put(0,1);
        return findPathSum(root,0,map);
    }

    public int findPathSum(TreeNode root,int sum,Map<Integer,Integer>map){
        if(root==null)return 0;

        //求和，先序
        sum += root.val;

        int res = map.getOrDefault(sum-target,0);

        map.put(sum,map.getOrDefault(sum,0)+1);

        res += findPathSum(root.left,sum,map) + findPathSum(root.right,sum,map);

        //递归，自底向上递归。计算数值对应的次数只能用当前元素的父节点，而不能用当前元素之后的节点。因此需要把已经
        map.put(sum,map.get(sum)-1);

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;
        PathSumThree pathSumThree = new PathSumThree();
        pathSumThree.pathSum(treeNode1,3);
    }
}
