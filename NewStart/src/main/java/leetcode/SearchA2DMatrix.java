package leetcode;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0)return false;
        int n = matrix[0].length;
        if(n==0)return false;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int j = n - 1, small = lo, large = hi;
            for (int i = 0; i < m; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    large = Math.min(large, matrix[i][j]);
                    j--;
                }
                if (j > 0)
                    small = Math.max(small, matrix[i][j]);
            }
            if(mid<=target)
                lo = large;
            else
                hi = small;
        }
        return lo == target||hi == target;
    }

    public static void main(String[] args) {
/*        int[][] matrix = {
                {
                        1, 3, 5, 7
                },
                {
                        10, 11, 16, 20
                },
                {
                        23, 30, 34, 50
                }
        };*/
        int[][] matrix ={{1},{3},{5}};
        SearchA2DMatrix s = new SearchA2DMatrix();
        s.searchMatrix(matrix, 3);
    }
}
