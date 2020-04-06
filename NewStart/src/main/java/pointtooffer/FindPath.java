package pointtooffer;

import java.util.ArrayList;
import tree.TreeNode;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        ArrayList<Integer>arrayList = new ArrayList<>();
        helper(res,arrayList,root,target);
        res.sort((o1, o2) -> o2.size() - o1.size());
        return res;
    }

    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, TreeNode root, int target) {
        if(root==null)return;
        int val = root.val;
        list.add(val);
        if(val == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }else {

            helper(res,list,root.left,target-val);
            helper(res,list,root.right,target-val);
        }
        //深度遍历回退
        list.remove(list.size()-1);
    }

}
