package leetcode;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode>deque = new LinkedList<>();
        if(root==null)return false;
        deque.offer(root);
        while (!deque.isEmpty()){
            int count = 0,lastLayerCount = deque.size();
            boolean hasX = false,hasY = false;
            while (count<lastLayerCount){
                TreeNode node = deque.pop();

                if(node.val == x)
                    hasX = true;
                if(node.val == y)
                    hasY = true;

                if(hasSameParent(node,x,y))
                    return false;
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }
                count++;
            }
            if(hasX && hasY)return true;
        }
        return false;
    }

    boolean hasSameParent(TreeNode node,int x,int y){
        if(node.left!=null && node.right!=null){
            return (node.left.val == x && node.right.val ==y)
                    ||(node.left.val == y && node.right.val == x);
        }
        return false;
    }
}
