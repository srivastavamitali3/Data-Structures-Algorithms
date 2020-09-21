package design;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));    // returns 1
        lfuCache.put(3, 3);    // evicts key 2
        System.out.println(lfuCache.get(2));     // returns -1 (not found)
        System.out.println(lfuCache.get(3));      // returns 3.
        lfuCache.put(4, 4);    // evicts key 1.
        System.out.println(lfuCache.get(1));     // returns -1 (not found)
        System.out.println(lfuCache.get(3));       // returns 3
        System.out.println(lfuCache.get(4));     // returns 4
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
    private Map<Integer, DoublyLinkedListNode> lfuCache;

    public LFUCache(int capacity) {
        this.lfuCache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!lfuCache.containsKey(key))
            return -1;

        DoublyLinkedListNode node = lfuCache.get(key);

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

        if (lfuCache.size() == 0) {
            head = node;
            tail = node;
            lfuCache.put(key, node);
        } else if (lfuCache.containsKey(key)) {
            DoublyLinkedListNode tempNode = lfuCache.get(key);
            if (tempNode.prev == null)
                tempNode.value = value;
            else {
                moveToHead(tempNode);
                head.value = value;
            }
        } else {
            if (lfuCache.size() < capacity) {
                node.next = head;
                head.prev = node;
                head = node;

                removeFromTail();
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            lfuCache.put(key, node);
        }
    }

    private void removeFromTail() {
        lfuCache.remove(tail.key);
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
