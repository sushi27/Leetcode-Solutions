package challenges.Problem1376;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    int[] informTime;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int dfs(int head) {
        int time = 0;
        for(int sub: adj.getOrDefault(head, new ArrayList<>())) {
            time = Math.max(time, dfs(sub));
        }
        return time + informTime[head];
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        for(int i=0; i<n; i++) {
            if(manager[i] == -1) continue;
            adj.putIfAbsent(manager[i], new ArrayList<>());
            adj.get(manager[i]).add(i);
        }
        return dfs(headID);
    }

    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(ob.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }
}
