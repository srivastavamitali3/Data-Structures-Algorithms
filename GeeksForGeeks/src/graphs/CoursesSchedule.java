package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoursesSchedule {
    public static void main(String[] args) {
        CoursesSchedule obj = new CoursesSchedule();
        //System.out.println(obj.canFinish(2, new int[][]{{0, 1},{1, 0}}));

        int[] arr = obj.findOrder(5, new int[][]{{2,1},{3,1},{4,1},{1,5}});
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = buildMap(numCourses, prerequisites);
        int[] inDegree = buildIndegreeArray(numCourses, prerequisites);
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                Q.add(i);

        int counter = 0;
        while (!Q.isEmpty()) {
            int currentCourse = Q.poll();
            counter++;
            for (int neighbor : map.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    Q.add(neighbor);
            }
        }

        return counter == numCourses;
    }

    private int[] buildIndegreeArray(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        for (int[] arr : prerequisites) {
            int course = arr[0];
            inDegree[course]++;
        }
        return inDegree;
    }

    private HashMap<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList<>());

        for (int[] arr : prerequisites) {
            int courseX = arr[1];
            int courseThatDependsOnX = arr[0];

            List<Integer> list = map.get(courseX);
            list.add(courseThatDependsOnX);
            map.put(courseX, list);
        }

        return map;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = buildMap(numCourses, prerequisites);
        int[] inDegree = buildIndegreeArray(numCourses, prerequisites);
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                Q.add(i);

            int counter = 0;
            int[] orderOfCourse = new int[numCourses];
            while (!Q.isEmpty()) {
                int currentCourse = Q.poll();
                orderOfCourse[counter] = currentCourse;
                counter++;
                for (int neighbor : map.get(currentCourse)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0)
                        Q.add(neighbor);
                }
            }
            return (counter == numCourses) ? orderOfCourse : new int[]{};
    }
}
