package src.main.java.challenges.Problem837;

public class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double sum = k == 0 ? 0 : 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = sum / maxPts;
            if(i < k) {
                sum += dp[i];
            }
            if(i-maxPts >= 0 && i-maxPts < k) {
                sum -= dp[i-maxPts];
            }
        }
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution ob = new Solution();
        System.out.println(ob.new21Game(21, 17, 10));
    }
}
