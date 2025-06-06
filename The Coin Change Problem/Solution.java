import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();        // amount
        int m = sc.nextInt();        // number of coin types
        
        int[] coins = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextInt();
        }

        long[] dp = new long[n + 1];
        dp[0] = 1; // base case: there's one way to make amount 0

        // Bottom-up DP
        for (int coin : coins) {
            for (int amount = coin; amount <= n; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        System.out.println(dp[n]);
        sc.close();
    }
}
