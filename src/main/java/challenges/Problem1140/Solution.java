package challenges.Problem1140;

public class Solution {
    int[] piles;
    Integer[][][] memo;
    int dp(int i, int M, int isAlice) {
        if(i == piles.length) return 0;
        if(memo[i][M][isAlice] != null) return memo[i][M][isAlice];
        int ans = isAlice == 0 ? -1 : 1000000;
        int sum = 0;
        for(int X=1; X<=Math.min(2 * M, piles.length - i); X++) {
            sum += piles[i+X-1];
            if(isAlice == 0) {
                ans = Math.max(ans, dp(i+X, Math.max(M, X), 1) + sum);
            }
            else ans = Math.min(ans, dp(i+X, Math.max(M, X), 0));
        }
        memo[i][M][isAlice] = ans;
        return memo[i][M][isAlice];
    }
    public int stoneGameII(int[] piles) {
        this.piles = piles;
        memo = new Integer[piles.length+1][piles.length+1][2];
        return dp(0, 1, 0);
    }
    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(ob.stoneGameII(new int[]{1,2,3,4,5,100}));
    }
}