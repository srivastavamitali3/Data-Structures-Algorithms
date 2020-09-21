package graphs;

public class TownJudge {
    public static void main(String[] args) {
        TownJudge obj = new TownJudge();
        System.out.println(obj.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
    }

    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];

        for (int[] arr : trust) {
            inDegree[arr[0]]--;
            inDegree[arr[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1)
                return i;
        }

        return -1;
    }
}
