public class MergePointsOfLinkedList {
    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        MergePointsOfLinkedList list = new MergePointsOfLinkedList();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + list.getNode(head1, head2));
    }

    private int getNode(Node headA, Node headB) {
        int c1 = getCount(headA);
        int c2 = getCount(headB);
        int d;
        if (c1 > c2) {
            d = c1 - c2;
            return getIntersectionPoint(d, headA, headB);
        } else {
            d = c2 - c1;
            return getIntersectionPoint(d, headA, headB);
        }
    }

    private int getCount(Node head) {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    private int getIntersectionPoint(int d, Node headA, Node headB) {
        Node curr1 = headA;
        Node curr2 = headB;
        for (int i = 0; i < d; i++) {
            if (curr1 == null)
                return -1;
            curr1 = curr1.next;
        }
        while (curr1 != null && curr2 != null) {
            if (curr1.data == curr2.data)
                return curr1.data;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return -1;
    }
}
