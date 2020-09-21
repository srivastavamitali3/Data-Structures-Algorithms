package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesII {
    public static void main(String[] args) {
        ParallelCoursesII obj = new ParallelCoursesII();
        int[][] dependencies = new int[][]{{2, 1}, {3, 1}, {4, 1}, {1, 5}};
        int n = 5;
        int k = 2;
        System.out.println(obj.minNumberOfSemesters(n, dependencies, k));
    }

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        HashMap<Integer, List<Integer>> map = buildMap(dependencies, n);
        int[] inDegree = buildInDegreeArray(dependencies, n);
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        Queue<Integer> Q = new LinkedList<>();
        int noOfSemesters = -1;

        for (int i = 1; i <= n; i++)
            if (inDegree[i] == 0) {
                Q.add(i);
                noOfSemesters++;
            }

        int counter = 0;
        int[] orderOfCourse = new int[n + 1];

        while (!Q.isEmpty()) {
            boolean levelFlag = false;
            int currentCourse = Q.poll();
            orderOfCourse[counter] = currentCourse;
            counter++;
            int sizeOfCurrentCourse = map.get(currentCourse).size();
            for (int neighbour : map.get(currentCourse)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    Q.add(neighbour);
                levelFlag = true;
            }
            if (levelFlag)
                levelMap.put(currentCourse, sizeOfCurrentCourse);
        }
        int count = 0;
        for (int i : levelMap.keySet()) {
            if (levelMap.get(i) < k)
                noOfSemesters++;
            else {
                int courses = levelMap.get(i);
                while (count < k) {
                    courses = Math.abs(courses - k);
                    noOfSemesters++;
                    count++;
                }
            }
        }
        return noOfSemesters;
    }

    private int[] buildInDegreeArray(int[][] dependencies, int noOfCourses) {
        int[] inDegree = new int[noOfCourses + 1];

        for (int[] dependent : dependencies) {
            int course = dependent[0];
            inDegree[course]++;
        }
        return inDegree;
    }

    private HashMap<Integer, List<Integer>> buildMap(int[][] dependencies, int noOfCourses) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 1; i <= noOfCourses; i++)
            map.put(i, new ArrayList<>());

        for (int[] dependants : dependencies) {
            int courseX = dependants[1];
            int courseDependsOnX = dependants[0];

            List<Integer> list = map.get(courseX);
            list.add(courseDependsOnX);
            map.put(courseX, list);
        }
        return map;
    }
}
