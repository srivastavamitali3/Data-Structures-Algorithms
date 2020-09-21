package graphs;

public class IslandPerimeter {
    int perimeter = 0;

    public static void main(String[] args) {
        IslandPerimeter obj = new IslandPerimeter();
        int[][] grid = new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(obj.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        // checking boundries
        /*if (grid == null || grid[0].length == 0)
            return 0;
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;                        // adding every island
                    if (i > 0 && grid[i - 1][j] == 1)   // checking neighbours and substracting
                        perimeter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1)      // checking neighbours and substracting
                        perimeter -= 2;
                }
            }
        }
        return perimeter;*/
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                if (i == n - 1 || grid[i + 1][j] == 0) perimeter++;
                if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                if (j == m - 1 || grid[i][j + 1] == 0) perimeter++;
            }
        return perimeter;
    }

    public int islandPerimeter1(int[][] grid) {

        boolean[][] visited = new boolean[grid.length + 1][grid.length + 1];
        int row = grid.length, col = grid.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                if (!visited[i][j] && grid[i][j] == 1) {
                    if (grid[i][j] == 1) {
                        dfs(i, j, visited, grid, row, col);
                    }
                }
        }
        return perimeter;
    }

    private void dfs(int x, int y, boolean[][] visited, int[][] grid, int row, int col) {
        System.out.println("Grid coordinates having 1 : x=" + x + " and y :" + y);
        perimeter++;
        int[] rowNbr = new int[]{0, 0, 1, -1};
        int[] colNbr = new int[]{1, -1, 0, 0};
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int x1 = x + rowNbr[i];
            int y1 = y + colNbr[i];
            if (isSafe(x1, y1, grid, visited, row, col))
                dfs(x1, y1, visited, grid, row, col);
        }
    }

    private boolean isSafe(int x1, int y1, int[][] grid, boolean[][] visited, int row, int col) {
        return ((x1 >= 0 && x1 < row) && (y1 >= 0 && y1 < col) && (grid[x1][y1] == 1) & (!visited[x1][y1]));
    }
}
