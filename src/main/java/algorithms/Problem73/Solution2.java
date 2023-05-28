package algorithms.Problem73;

import java.util.Arrays;

// In 2nd approach, we will set first row and first col of every cell which has value zero
//                if cell[i][j] == 0 {
//                    cell[i][0] = 0
//                    cell[0][j] = 0
//                }
// Later we will traverse and check if first row or first col is zero then set it to zero
// Time O(m x n) and Space O(1)
public class Solution2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isCol = false;
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) {
                isCol = true;
            }
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;

                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(isCol) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Solution2 ob = new Solution2();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        ob.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
