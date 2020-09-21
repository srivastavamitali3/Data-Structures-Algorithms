package amazonQuestions;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
    static Deque<Integer> dq;
    static Set<Integer> set;
    static int cacheSize;

    LRUCache(int cacheSize) {
        dq = new LinkedList<>();
        set = new HashSet<>();
        this.cacheSize = cacheSize;
    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }

    private void display() {
        Iterator itr = dq.iterator();
        while (itr.hasNext())
            System.out.print(itr.next() + " ");
    }

    private void refer(int x) {
        if (!set.contains(x)) {
            if (dq.size() == cacheSize) {
                int last = dq.removeLast();
                set.remove(last);
            }
        } else {
            int index = 0, i = 0;
            Iterator itr = dq.iterator();
            while (itr.hasNext()) {
                if ((int) itr.next() == x) {
                    index = i;
                    break;
                }
                i++;
            }
            dq.remove(index);
        }
        dq.push(x);
        set.add(x);
    }
}
