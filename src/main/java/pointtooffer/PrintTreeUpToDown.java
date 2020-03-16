package pointtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import tree.TreeNode;

public class PrintTreeUpToDown {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer>result = new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            result.add(n.val);
            if(n.left!=null)
                queue.offer(n.left);
            if(n.right!=null)
                queue.offer(n.right);
        }
        return result;
    }

    private void test(){
        List<Character>list = new ArrayList<>();
        list.add('1');
        String s ="";
        for (int i = 0; i < list.size(); i++) {
            s += list.get(i);
        }
    }
}
