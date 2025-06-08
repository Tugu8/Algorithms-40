import java.util.Scanner;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // Number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = sc.nextInt();  // Number of elements in the array
            int k = sc.nextInt();  // Target sum

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] dp = new int[k + 1];  // DP array

            for (int i = 1; i <= k; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[j] <= i) {
                        dp[i] = Math.max(dp[i], dp[i - arr[j]] + arr[j]);
                    }
                }
            }

            System.out.println(dp[k]);
        }

        sc.close();
    }
}
