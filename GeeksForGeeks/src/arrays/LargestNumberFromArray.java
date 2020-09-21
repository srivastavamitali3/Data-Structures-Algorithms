package arrays;

import java.util.*;

public class LargestNumberFromArray {
    public static void main(String[] args) {
        int[] arr = new int[]{54, 546, 548, 60};
        //  printLargest(arr);
        Vector<String> arr1;
        arr1 = new Vector<>();

        //output should be 6054854654 
        arr1.add("54");
        arr1.add("546");
        arr1.add("548");
        arr1.add("60");
        printLargest1(arr1);
        System.out.println();
        printLargest(arr);

    }

    private static void printLargest1(Vector<String> arr) {
        Collections.sort(arr, new Comparator<String>() {

            // A comparison function which is used by
            // sort() in printLargest()
            @Override
            public int compare(String X, String Y) {

                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                // Now see which of the two formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }

    private static void printLargest(int[] arr) {
        List<String> str = new ArrayList<String>();
        String[] strings = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            strings[i] = (String.valueOf(arr[i]));
        for (int i = 0; i < arr.length; i++)
            str.add(String.valueOf(arr[i]));
        Arrays.sort(strings, new Comparator<String>() {

            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? 1 : -1;
            }
        });

        Iterator itr = str.iterator();
        while (itr.hasNext())
            System.out.print(itr.next());

    }
}
