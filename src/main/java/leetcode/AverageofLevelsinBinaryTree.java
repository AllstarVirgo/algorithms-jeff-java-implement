package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tree.TreeNode;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()){
            int i = 0,tempCount = 0;
            double sum = 0;
            while (i<count){
                TreeNode node = queue.pop();
                sum += node.val;
                if(node.left!=null) {
                    queue.offer(node.left);
                    tempCount++;
                }
                if(node.right!=null) {
                    queue.offer(root.right);
                    tempCount++;
                }
                i++;
            }
            result.add(sum/count);
            count = tempCount;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        AverageofLevelsinBinaryTree averageofLevelsinBinaryTree = new AverageofLevelsinBinaryTree();
        averageofLevelsinBinaryTree.averageOfLevels(treeNode3);
    }
}
