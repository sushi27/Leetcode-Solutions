package algorithms.Problem73;

import java.util.Arrays;
import java.util.HashSet;

//we are using HashSet to store rows and columns which are going to be zero
// Time O(m x n) and Space O(m + n)
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int row: rows) {
            for(int j=0; j<matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
        for(int col: cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Solution1 ob = new Solution1();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        ob.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
