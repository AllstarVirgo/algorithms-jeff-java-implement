package pointtooffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import tree.TreeNode;

public class TreePrintByLayer {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            Deque<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                list.add(node.val);
                if (node.left != null)
                    temp.offer(node.left);
                if (node.right != null)
                    temp.offer(node.right);
            }
            while (!temp.isEmpty()) {
                queue.offer(temp.pop());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreePrintByLayer tpb = new TreePrintByLayer();

    }
}
