package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    class DoublyLinkedListNode {
        int key;
        int value;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private Map<Integer, DoublyLinkedListNode> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        DoublyLinkedListNode node = cache.get(key);

        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DoublyLinkedListNode node) {
        if (node.prev == null)
            return;

        if (node.next == null) {
            tail = node.prev;
            tail.next = null;
            node.next = head;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = head;
            node.prev = null;
        }
        head.prev = node;
        head = node;
        head.prev = null;
    }

    public void put(int key, int value) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);

        if (cache.size() == 0) {
            head = node;
            tail = node;
            cache.put(key, node);
        } else if (cache.containsKey(key)) {
            DoublyLinkedListNode tempNode = cache.get(key);
            if (tempNode.prev == null)
                tempNode.value = value;
            else {
                moveToHead(tempNode);
                head.value = value;
            }
        } else {
            if (cache.size() < capacity){
                node.next = head;
                head.prev = node;
                head = node;

                removeFromTail();
            }else{
                node.next = head;
                head.prev = node;
                head = node;
            }
            cache.put(key, node);
        }
    }

    private void removeFromTail() {
        cache.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
