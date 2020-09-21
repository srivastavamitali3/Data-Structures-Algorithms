import java.util.ArrayList;
import java.util.List;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 12345678);
        obj.put(3, 567);
        int param_2 = obj.get(1);
        System.out.println(param_2);
        obj.remove(1);
    }
}

class MyHashMap {
    class Container {
        int key;
        int value;

        public void insert(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Container> recordList;
    private Container container;

    public MyHashMap() {
        recordList = new ArrayList<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        this.container = new Container();
        container.insert(key, value);
        for (int i = 0; i < recordList.size(); i++) {
            Container c1 = recordList.get(i);
            if (c1.key == key) {
                remove(i);
                break;
            }
        }
        recordList.add(container);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        for (int i = 0; i < recordList.size(); i++) {
            Container con = recordList.get(i);
            if (con.key == key)
                return con.value;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        recordList.remove(key);
    }
}
