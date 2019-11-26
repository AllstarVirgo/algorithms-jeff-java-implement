package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        List<List<Integer>>levelOrderResult = new LinkedList<>();
        if(root==null)
            return levelOrderResult;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer>list = new ArrayList<>();
            List<TreeNode>tempNodes = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                tempNodes.add(temp);
            }
            if(!tempNodes.isEmpty()) {
                for (TreeNode node :
                        tempNodes) {
                    list.add(node.val);
                    if(node.left!=null)
                        queue.offer(node.left);
                    if(node.right!=null)
                        queue.offer(node.right);
                }
                levelOrderResult.add(list);
            }
        }
        return levelOrderResult;
    }
}
