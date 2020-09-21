import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.stream.IntStream;

class Animal {
    public void breathe() {
        System.out.println("Animal breathe");
    }
}

class Dog extends Animal {
    public void breathe() {
        super.breathe();
        System.out.println("Dog breathe");
        bark();
    }

    public void bark() {
        System.out.println("Dog barks");
    }
}

public class Test1 {

    public static void main(String[] args) {
        /*System.out.println("Hello Gullu !!!");
        int[] arr =  new int[]{9,1,8,2,7,3,6,4,5};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr)
            pq.add(i);

        String s ="I have the house built";
        String[] str = s.split(" ");
        for(String res : str)
            System.out.print(res+" ");*/

       /* List<Integer> llist = new ArrayList<>();
        IntStream.range(1,10).filter(t-> t%2==0).allMatch(t-> llist.add(t));
        llist.forEach(t -> System.out.println(t));

        Map<Integer, Integer> map = new HashMap<>();

        IntStream.range(1,10).forEach(t -> map.put(t,t*100));

        map.entrySet().stream().forEach(t-> {
            System.out.println(t +" : "+map.get(t));
        });*/

        Animal a = new Dog();
        a.breathe();

        Dog d = new Dog();
        d.bark();


    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }
        int[] countArray = new int[queries.length];
        int k = 0;
        for (String query : queries) {
            if (map.containsKey(query))
                countArray[k++] = map.get(query);
            else
                countArray[k++] = 0;
        }
        return countArray;
    }
}
