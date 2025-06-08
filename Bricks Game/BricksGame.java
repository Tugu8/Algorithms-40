import java.util.*;

public class BricksGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n + 5];  // padded to avoid index issues

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong(); // No reverse this time
            }

            long[] suffixSum = new long[n + 5];
            for (int i = n - 1; i >= 0; i--) {
                suffixSum[i] = arr[i] + suffixSum[i + 1];
            }

            long[] dp = new long[n + 5];
            for (int i = n - 1; i >= 0; i--) {
                long pick1 = suffixSum[i] - dp[i + 1];
                long pick2 = suffixSum[i] - dp[i + 2];
                long pick3 = suffixSum[i] - dp[i + 3];
                dp[i] = Math.max(pick1, Math.max(pick2, pick3));
            }

            System.out.println(dp[0]);
        }

        sc.close();
    }
}
