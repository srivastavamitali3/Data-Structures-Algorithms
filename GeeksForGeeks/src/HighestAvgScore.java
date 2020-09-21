import java.util.*;

public class HighestAvgScore {
    public static void main(String[] args) {
        String s[][] = {{"James", "-66"}, {"Fernando", "-88"}, {"Nick", "0"}, {"James", "0"}, {"Nick", "0"}, {"Nick", "-6"}, {"Rick", "-2.1"}};
        // String s[][] = {{"James", "-70"}, {"Fernando", "-90"}, {"Nick", "-60"}, {"James", "30"}, {"James", "-20"}};
        maxAvg(s);

        String str = "geeksforgeeks";
        firstNonRepeat(str);

        int[] arr = new int[]{7, 4, 0, 9};
        int n = 4;
        trappingRainwater(arr, n);

        int[] arr1 = new int[]{54, 546, 548, 60};
        List<String> list = new ArrayList<>();
        for (int i : arr1)
            list.add(String.valueOf(i));
        printLargest(list);

        String encodeWord = "open";
        String key = "123";
        //xencodeWord(encodeWord, key);
    }

    private static void printLargest(List<String> list) {
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator itr = list.iterator();
        while (itr.hasNext())
            System.out.print(itr.next());
    }

    private static void trappingRainwater(int[] arr, int n) {
        int low = 0, high = n - 1, left_max = 0, right_max = 0, water = 0;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > left_max)
                    left_max = arr[low];
                else {
                    water += left_max - arr[low];
                    low++;
                }
            } else {
                if (arr[high] > right_max)
                    right_max = arr[high];
                else {
                    water += right_max - arr[high];
                    high--;
                }
            }
        }
        System.out.println(water);
    }

    private static void firstNonRepeat(String str) {
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                System.out.println(str.charAt(i));
                return;
            }
        }
    }

    private static void maxAvg(String[][] s) {

        class Pair {
            int numOfSubjects;
            double averageMarks;

            public Pair(int numOfSubjects, double averageMarks) {
                this.numOfSubjects = numOfSubjects;
                this.averageMarks = averageMarks;
            }
        }
        Map<String, Pair> map = new HashMap<>();

        double maximumAverageMarks = 0;
        String studentWithMaxAvgMArks = "";
        for (int i = 0; i < s.length; i++) {
            String key = s[i][0];
            double value = Double.parseDouble(s[i][1]);
            if (map.containsKey(key)) {
                Pair p = map.get(key);
                int count = p.numOfSubjects;
                double marks = count * p.averageMarks;
                int j = count + 1;
                double avgValue = (marks + value) / j;
                if (Math.abs(avgValue) > maximumAverageMarks) {
                    maximumAverageMarks = avgValue;
                    studentWithMaxAvgMArks = key;
                }
                map.put(key, new Pair(j, avgValue));
            } else {
                if ((value) > maximumAverageMarks) {
                    maximumAverageMarks = value;
                    studentWithMaxAvgMArks = key;
                }
                map.put(key, new Pair(1, value));
            }
        }

        System.out.println("Aayush max name : " + studentWithMaxAvgMArks + " marks = " + Math.floor(maximumAverageMarks));
    }
}
