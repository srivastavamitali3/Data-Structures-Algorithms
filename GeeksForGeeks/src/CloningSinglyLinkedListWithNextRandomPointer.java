public class CloningSinglyLinkedListWithNextRandomPointer {
    private static class Node {
        int data;
        Node next, random;

        Node(int d) {
            data = d;
            next = random = null;
        }
    }

    static Node head;

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public static boolean validation(Node head, Node res, Node cloned_add,
                                     Node generated_add) {
        if (generated_add == cloned_add) return false;
        Node temp1 = head;
        Node temp2 = res;
        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        /*if lengths not equal */
        if (len1 != len2) return false;
        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            if (temp1.data != temp2.data) return false;
            if (temp1.random != null && temp2.random != null) {
                if (temp1.random.data != temp2.random.data) return false;
            } else if (temp1.random != null && temp2.random == null)
                return false;
            else if (temp1.random == null && temp2.random != null)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    //   public static void printList()
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Node generated_add = null;
            int n = sc.nextInt();
            int q = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Node tempA = head;
                int count = -1;
                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                }
                Node tempB = head;
                count = -1;
                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                }
                // when both a is greater than N
                if (a <= n) tempA.random = tempB;
            }
            generated_add = head;
            Node res = copyList(head);
            Node cloned_add = res;
            if (validation(head, res, cloned_add, generated_add) == true)
                System.out.println("1");
            else
                System.out.println("false");*/
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        Node cloned_list = copyList(start);
        print(cloned_list);


    }

    static void print(Node start) {
        Node ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data +
                    ", Random = " + ptr.random.data);
            ptr = ptr.next;
        }
    }

    private static Node copyList(Node head) {
        Node curr = head, temp = null;
        //inserting node after every node of original list
        while (curr != null) {
            temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        //adjusting random pointers of newly added nodes
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            // move to the next newly added node by
            // skipping an original node
            curr = (curr.next != null) ? curr.next.next : curr.next;
        }

        Node original = head, copy = head.next;
        //save start of the copied Linked list
        temp = copy;

        //separate original list and copied list
        while (original != null && copy != null) {
            original.next = (original.next != null) ? original.next.next : original.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }
}
