package challenges.Problem1091;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    int[][] directions = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    boolean[][] visited;
    int[][] grid;

    List<int[]> getNeighbour(int row, int col) {
        List<int[]> li = new ArrayList<>();
        for(int[] direction: directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid.length
                    || grid[newRow][newCol] == 1 || visited[newRow][newCol]) continue;
            li.add(new int[]{newRow, newCol});
            visited[newRow][newCol] = true;
        }
        return li;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        this.grid = grid;
        visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        int ans = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] cell = queue.poll();
                if(cell[0] == n-1 && cell[1] == n-1) return ans;
                for(int[] neighbor: getNeighbour(cell[0], cell[1])) {
                    queue.add(new int[]{neighbor[0], neighbor[1]});
                }
            }
            ans++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 ob = new Solution1();
        System.out.println(ob.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }
}
