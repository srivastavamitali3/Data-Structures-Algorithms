package design;

import java.util.*;

public class InsertDeleteGetRandom_O_1 {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom_O_1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val);
        int temp = list.get(list.size() - 1);
        list.set(index, temp);
        list.remove(list.size() - 1);
        map.put(temp, index);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
