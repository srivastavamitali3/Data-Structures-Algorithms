package greedy;

import java.util.Arrays;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoomsII {
    public static void main(String[] args) {
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        /*Integer[] startTime = new Integer[intervals.length];
        Integer[] endTime = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        Arrays.sort(endTime, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        int startPtr = 0, endPtr = 0, usedRooms = 0;
        while (startPtr < intervals.length) {
            // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
            if (startTime[startPtr] >= endTime[endPtr]) {
                usedRooms--;
                endPtr++;
            }
            // We do this irrespective of whether a room frees up or not.
            // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms
            usedRooms++;
            startPtr++;
        }
        return usedRooms;*/
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int endItr = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[endItr]) {
                rooms++;
            } else {
                endItr++;
            }
        }
        return rooms;
    }
}
