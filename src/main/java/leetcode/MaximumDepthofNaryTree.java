package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if(root==null)return 0;
        return 1+ getMaxPath(root);
    }


    int getMaxPath(Node root){
        if(root == null)return 0;
        List<Node>list = root.children;
        int n = list.size();
        int[] array = new int[n];
        for(int i = 0;i<n;i++){
            array[i] = 1 + getMaxPath(list.get(i));
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            if(array[i]>max)
                max = array[i];
        }
        return max;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        List<Node>list = new ArrayList<>();
        Node root = new Node(1,new ArrayList<>());

        Node node1 = new Node(2,new ArrayList<>());
        list.add(node1);

        root.children = list;

        MaximumDepthofNaryTree maximumDepthofNaryTree = new MaximumDepthofNaryTree();
        System.out.println(maximumDepthofNaryTree.maxDepth(root));
    }
}