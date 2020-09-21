package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

class Node1 {
    public int val;
    public Node1 prev;
    public Node1 next;
    public Node1 child;
}

public class FlatDoublyLL {
    public static void main(String[] args) {

    }

    public Node1 flatten(Node1 head) {
        if (head == null) return null;
        Deque<Node1> stack = new ArrayDeque<>();
        Node1 cur = head;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null)
                    stack.push(cur.next);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                cur.next.prev = cur;
            }

            cur = cur.next;
        }
        return head;
    }
}
