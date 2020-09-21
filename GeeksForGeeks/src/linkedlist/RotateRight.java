package linkedlist;

public class RotateRight {
    private static ListNode head;

    public static void main(String[] args) {
        RotateRight llist = new RotateRight();

        // create a list 10->20->30->40->50->60
        for (int i = 5; i >= 1; i--)
            llist.push(i);

        System.out.println("Given list");
        llist.printList();

        llist.rotate(head, 2);

        System.out.println("Rotated Linked List");
        llist.printList();
    }

    private ListNode rotate(ListNode head, int k) {
        ListNode current = head, prev = null, temp = head;
        int count = 1;
        while (current != null && count <= k) {
            ListNode temp1 = current;
            current.next = temp;
            count++;
            current = current.next;
        }

        return head;
    }

    void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        ListNode new_node = new ListNode(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}


