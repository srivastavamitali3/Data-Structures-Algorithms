package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ActivitySelectionProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            System.out.println(new Activity().activitySelection(start, end, n));
        }
    }
}

// } Driver Code Ends
class Activity {
    static class Pair implements Comparable<Pair> {
        int start, finish;

        Pair(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Pair o) {
            return this.finish > o.finish ? 1 : -1;
        }
    }

    static int activitySelection(int start[], int end[], int n) {
        // add your code here
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Pair(start[i], end[i]);

        return getNumberOfActivities(arr, n);
    }

    private static int getNumberOfActivities(Pair[] arr, int n) {
        Arrays.sort(arr);
        int i = 0, count = 1;
        for (int j = 0; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                i = j;
                count++;
            }
        }
        return count;
    }
}
