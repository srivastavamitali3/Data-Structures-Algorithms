package amazonOnlineAssessment;

import javafx.util.Pair;

import java.util.*;

public class FetchItemsToDisplay {
    static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, Pair> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber){

        if(items.size() == 0)
            return Collections.EMPTY_LIST;

        SortedSet<Map.Entry<String, Pair>> set = new TreeSet<>(new Comparator<Map.Entry<String, Pair>>() {
            @Override
            public int compare(Map.Entry<String, Pair> entry1, Map.Entry<String, Pair> entry2) {
                if(sortParameter == 0){
                    if(sortOrder == 0){
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return entry2.getKey().compareTo(entry1.getKey());
                }
                if(sortParameter == 1){
                    if(sortOrder == 0){
                        return (int)entry1.getValue().getKey() - (int)entry2.getValue().getKey();
                    }
                    return (int)entry2.getValue().getKey() - (int)entry1.getValue().getKey();
                }
                if(sortParameter == 2){
                    if(sortOrder == 0){
                        return (int)entry1.getValue().getValue() - (int)entry2.getValue().getValue();
                    }
                    return (int)entry2.getValue().getValue() - (int)entry1.getValue().getValue();
                }
                return 0;
            }
        });

        set.addAll(items.entrySet());

        List<String> result = new ArrayList<>();
        for(Map.Entry<String,Pair> entry : set){
            result.add(entry.getKey());
        }

        int start = pageNumber * itemsPerPage;
        int end = (start + itemsPerPage) > result.size() ? result.size() : start + itemsPerPage;

        return result.subList(start, end);
    }

    public static void main(String[] args) {
        HashMap<String, Pair> items = new HashMap<>();
        items.put("item1",new Pair(10,15));
        items.put("item2",new Pair(3,4));
        items.put("item3",new Pair(17,8));

        fetchItemsToDisplay(3,items,1,0,2,1)
                .forEach(l-> System.out.println(l));

        int numOfItems = 3;
        HashMap<String, int[]> items1= new HashMap<>();
        items1.put("item1", new int[]{10, 15});
        items1.put("item2", new int[]{3, 4});
        items1.put("item3", new int[]{17, 8});
       /* items1.put("item5", new int[]{1, 2});
        items1.put("item7", new int[]{12, 15});*/

        int sortParam = 1;
        int sortOrder = 0; //0 is Asc and 1 is Desc
        int itemsPerPage = 2;
        int pageNumber = 1;

        FetchItemsToDisplay f = new FetchItemsToDisplay();
        List<String> res = f.fetchItemsToDisplay1(numOfItems, items1, sortParam, sortOrder, itemsPerPage, pageNumber);

        System.out.println("List of items is: " + res);

        // Output: List of items is: [item1, item2]
        // Since the list is expected to be in descending order on the relevance value and needs items on Page1
    }


    public List<String> fetchItemsToDisplay1(int numOfItems, HashMap<String, int[]> items, int sortParameter,
                                    int sortOrder, int itemsPerPage, int pageNumber) {
        PriorityQueue<DisplayItems> pq = new PriorityQueue<>();
        if (sortOrder == 1)
            pq = new PriorityQueue<>(Collections.reverseOrder());

        //Since the int array has ["relevance_value", "price_value"]
        //If the sort parameter is 1, I am picking 0th value as my key in the pq else the 1st value (sortParameter - 1)
        for (Map.Entry<String, int[]> map : items.entrySet()) {
            pq.add(new DisplayItems(map.getValue()[sortParameter - 1], map.getKey()));
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.peek().itemName);
            pq.poll();
        }

        //Fetching the items on the given pageNumber
        int startIndex = pageNumber * itemsPerPage;
        int endIndex = (startIndex + itemsPerPage) > result.size() ? result.size() : startIndex + itemsPerPage;

        return result.subList(startIndex, endIndex);
    }

    public class DisplayItems implements Comparable<DisplayItems> {
        private String itemName;
        private Integer value;

        public DisplayItems(Integer value, String itemName) {
            this.itemName = itemName;
            this.value = value;
        }

        public String getItemName() {
            return itemName;
        }

        public Integer getValue() {
            return value;
        }

        @Override
        public int compareTo(DisplayItems o) {
            return this.getValue().compareTo(o.value);
        }
    }
}
