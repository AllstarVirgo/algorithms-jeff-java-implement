package tree;

public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.contains(ch))
                node.put(ch,new TrieNode());
            node = node.getNode(ch);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(node.contains(ch))
                node = node.getNode(ch);
            else
                return false;
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(node.contains(ch))
                node = node.getNode(ch);
            else
                return false;
        }
        return !node.isEnd;
    }


    /**
     * 每个TrieNode包括1个标志位，1个大小为26个字母的数组
     *
     *
     */
    class TrieNode{
        TrieNode[] links;

        boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[R];
        }

        public static final int R = 26;

        public void put(char ch,TrieNode node){
            links[ch-'a'] = node;
        }


        public boolean contains(char ch) {
            return links[ch-'a']!=null;
        }

        public TrieNode getNode(char ch) {
            return links[ch - 'a'];
        }

        void setEnd(){
            this.isEnd = true;
        }
    }
}
