package Greedy;

import java.util.PriorityQueue;

/**
 * @author potato
 * @Date 2019/8/5 9:28
 *
 * Huffman Code is about make choices to encode character.But it aims to get the shortest
 * length of all words.
 *
 * frequency [1...n] to for all character frequency
 *
 *
 */
public class HuffmanCodes {

    BinaryTreeNode root;
    /**
     *  freq[char] = freq .A's frequency is 3.  freq['A'] = 3
     * @param s
     * @param freq
     */
    private static void buildCode(String s,int[] freq){
        char[] chars = s.toCharArray();

    }

}


class BinaryTreeNode{
    BinaryTreeNode left;

    BinaryTreeNode right;

    int frequency;

    public BinaryTreeNode(int frequency) {
        this.frequency = frequency;
    }
}
