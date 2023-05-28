package challenges.Problem1547;

import java.util.Arrays;

public class Solution1 {
    int[] newCuts;
    Integer[][] memo;
    int dp(int start, int end) {
        if(start+1 == end) return 0;
        if(memo[start][end] != null) return memo[start][end];

        int ans = Integer.MAX_VALUE;
        for(int i=start+1; i<end; i++) {
            ans = Math.min(ans, dp(start, i) + dp(i, end) + newCuts[end] - newCuts[start]);
        }
        memo[start][end] = ans;
        return memo[start][end];
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        newCuts = new int[m+2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m+1] = n;
        Arrays.sort(newCuts);
        memo = new Integer[m+2][m+2];
        return dp(0, newCuts.length-1);
    }
    public static void main(String[] args) {
        Solution1 ob = new Solution1();
        System.out.println(ob.minCost(9, new int[]{5,6,1,4,2}));
    }
}
