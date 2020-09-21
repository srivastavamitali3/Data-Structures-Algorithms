package linkedlist;

import java.util.Scanner;

public class DeleteWithoutHeadPointer {
    ListNode head;

    void printList(ListNode head) {
        ListNode tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    void addToTheLast(ListNode node) {

        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    ListNode search_Node(ListNode head, int k) {
        ListNode current = head;
        while (current != null) {
            if (current.data == k)
                break;
            current = current.next;
        }
        return current;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            DeleteWithoutHeadPointer llist = new DeleteWithoutHeadPointer();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            ListNode head = new ListNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new ListNode(a));
            }

            int k = sc.nextInt();
            ListNode del = llist.search_Node(llist.head, k);

            if (del != null && del.next != null) {
                llist.deleteNode(del);
            }
            llist.printList(llist.head);
            t--;
        }
    }

    private void deleteNode(ListNode node) {
        if (node == null || node.next == null)
            return;
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
/*
Test Case
2
2
1 2
1
4
10 20 4 30
20
*/
