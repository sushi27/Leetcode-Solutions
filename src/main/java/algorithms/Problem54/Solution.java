package algorithms.Problem54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int topRow = 0, bottomRow = matrix.length-1;
        int leftCol = 0, rightCol = matrix[0].length-1;

        List<Integer> ans = new ArrayList<>();
        while(topRow <= bottomRow && leftCol<=rightCol) {
            for(int i=leftCol; i<=rightCol; i++) {
                ans.add(matrix[topRow][i]);
            }
            topRow++;
            for(int i=topRow; i<=bottomRow; i++) {
                ans.add(matrix[i][rightCol]);
            }
            rightCol--;
            if(topRow > bottomRow) break;
            for(int i=rightCol; i>=leftCol; i--) {
                ans.add(matrix[bottomRow][i]);
            }
            bottomRow--;
            if(leftCol > rightCol) break;
            for(int i=bottomRow; i>=topRow; i--) {
                ans.add(matrix[i][leftCol]);
            }
            leftCol++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(ob.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
