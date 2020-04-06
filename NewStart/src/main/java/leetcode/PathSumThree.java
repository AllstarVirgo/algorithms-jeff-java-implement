package leetcode;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀求和法：当前前缀 (sum-target) 的值，如果在之前的前缀和中存在。
 * For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3,
 * let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2} ways
 *
 * 注：多个前缀和的值相同，则这多个值可以公用多个路径
 */
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
        //使用过的前缀丢弃
        map.put(sum,map.get(sum)-1);

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(-1);
        TreeNode treeNode4 = new TreeNode(-1);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode4.left = treeNode5;
        PathSumThree pathSumThree = new PathSumThree();
        System.out.println(pathSumThree.pathSum(treeNode1,2));
        pathSumThree.travel(treeNode1);
    }

    void travel(TreeNode root){
        if(root==null)return;
        System.out.println(root.val);
        travel(root.left);
        travel(root.right);
    }
}
