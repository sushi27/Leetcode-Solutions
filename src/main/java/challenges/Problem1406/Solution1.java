package challenges.Problem1406;

public class Solution1 {
    int[] pilesOfStone;
    Integer[][] memo;
    int dp(int i, int isAlice){
        if(i == pilesOfStone.length) return 0;
        if(memo[i][isAlice] != null) return memo[i][isAlice];

        int ans = (isAlice == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum = 0;
        for(int index = i; index < Math.min(i+3,pilesOfStone.length); index++){
            sum += pilesOfStone[index];
            if(isAlice == 0) {
                ans = Math.max(ans, dp(index+1, 1)+sum);
            }
            else {
                ans = Math.min(ans, dp(index+1, 0)-sum);
            }
        }
        memo[i][isAlice] = ans;
        return memo[i][isAlice];
    }

    public String stoneGameIII(int[] stoneValue) {
        this.pilesOfStone = stoneValue;
        memo = new Integer[stoneValue.length][2];
        int ans = dp(0, 0);
        if(ans == 0)
            return "Tie";
        else if(ans > 0)
            return "Alice";
        else
            return "Bob";
    }
    public static void main(String[] args) {
        Solution1 ob  = new Solution1();
        System.out.println(ob.stoneGameIII(new int[]{1,2,3,7}));
        System.out.println(ob.stoneGameIII(new int[]{1,2,3,-9}));
        System.out.println(ob.stoneGameIII(new int[]{1,2,3,6}));
    }
}
