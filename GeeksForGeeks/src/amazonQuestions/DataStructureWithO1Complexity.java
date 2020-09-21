package amazonQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//Design a custom data structure that supports insert, search, delete and getRandom operation in O(1) time.
public class DataStructureWithO1Complexity {
    List<Integer> arr;
    Map<Integer, Integer> map;

    DataStructureWithO1Complexity() {
        arr = new ArrayList<>();
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        DataStructureWithO1Complexity ds = new DataStructureWithO1Complexity();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }

    private int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(arr.size());
        return arr.get(index);
    }

    private void remove(int x) {

        Integer index = arr.indexOf(x);
        if (index == null)
            return;
        map.remove(x);
        int sizeofArray = arr.size();
        Integer last = arr.get(sizeofArray - 1);
        Collections.swap(arr, index, sizeofArray - 1);

        arr.remove(sizeofArray - 1);
        map.put(last, index);
    }

    private Integer search(int x) {
        return map.get(x);
    }

    private void add(int x) {
        if (map.get(x) != null)
            return;
        int sizeOfArray = arr.size();
        arr.add(x);
        map.put(x, sizeOfArray);
    }
}
