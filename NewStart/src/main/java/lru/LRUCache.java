package lru;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer,Node>hashMap = new HashMap<>();

    private Node head;

    private Node tail;

    private int capacity;

    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if(node == null)
            return -1;
        int value = node.value;
        moveNodeToHead(node);
        return value;
    }

    private void moveNodeToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        Node curHead = head.next;
        node.prev = head;
        node.next = curHead;
        head.next = node;
        curHead.prev = node;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);

        if(hashMap.containsKey(key)){
            Node existNode = hashMap.get(key);
            existNode.value = value;
            moveNodeToHead(existNode);
            hashMap.put(key,existNode);
            return;
        }

        if(count == capacity){
            removeLastNode();
            addToHead(newNode);
        }
        else {
            addToHead(newNode);
            count++;
        }

        hashMap.put(key,newNode);
    }

    private void addToHead(Node node){
        Node first = head.next;
        head.next = node;
        first.prev = node;

        node.prev = head;
        node.next = first;
    }

    private void removeLastNode(){
        Node last = tail.prev;
        last.prev.next = tail;

        tail.prev = last.prev;
        hashMap.remove(last.key);
    }

    class Node{
        Node next;

        Node prev;

        int key;

        int value;

        public Node() {
        }

        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }

/*    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 *//* capacity *//* );
        cache.get(2); // get -1
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);//update key 2
        cache.put(4, 1);//evict 1
        cache.get(1);//get -1
        cache.get(2);//get 3
    }*/
}
