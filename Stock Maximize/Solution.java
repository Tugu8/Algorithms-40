import java.util.*;

public class Solution {
    public static long stockMaximize(int[] prices) {
        long profit = 0;
        int maxPrice = 0;
        
        // Traverse from right to left
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] >= maxPrice) {
                maxPrice = prices[i];  // Update max future price
            } else {
                profit += maxPrice - prices[i];  // Buy now and sell later at maxPrice
            }
        }
        
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();  // number of days
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }
            System.out.println(stockMaximize(prices));
        }
        sc.close();
    }
}
