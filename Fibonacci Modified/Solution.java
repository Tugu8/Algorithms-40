import java.util.*;
import java.math.BigInteger;

public class Solution {

    static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.valueOf(t1);
        dp[2] = BigInteger.valueOf(t2);
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1].pow(2));
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        int n = scanner.nextInt();
        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result);
        scanner.close();
    }
}