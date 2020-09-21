package linkedlist;

import java.util.Scanner;

public class ReorderList {
    ListNode head;  // head of lisl

    /* Linked list Node*/


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();
            int a1 = sc.nextInt();
            ListNode head = new ListNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new ListNode(a));
            }

            llist.head = llist.reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }

    private ListNode reorderlist(ListNode head) {
        ListNode node = head;
        if (node == null)
            return null;

        ListNode slow = node, fast = slow.next;
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode node1 = node;
        ListNode node2 = slow.next;
        slow.next = null;

        node2 = reverseList(node);

        node = new ListNode(0);

        ListNode current = node;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                current.next = node1;
                current = current.next;
                node1 = node1.next;
            }
            if (node2 != null) {
                current.next = node2;
                current = current.next;
                node2 = node2.next;
            }
        }

        node = node.next;
        head = node;
        return head;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null, curr = node, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
}
