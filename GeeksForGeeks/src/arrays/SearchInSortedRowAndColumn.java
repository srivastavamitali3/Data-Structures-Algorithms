package arrays;

public class SearchInSortedRowAndColumn {
    public static void main(String[] args) {
        SearchInSortedRowAndColumn obj = new SearchInSortedRowAndColumn();
        System.out.println(obj.searchMatrix(new int[][]{{1, 3}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int i = 0, j = matrix[0].length - 1;
        int n = matrix.length;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
