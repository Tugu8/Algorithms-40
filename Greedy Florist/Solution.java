import java.util.*;

public class Solution {

    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int totalCost = 0;
        int n = c.length;
        for (int i = 0; i < n; i++) {
            int multiplier = (i / k) + 1;
            totalCost += c[n - 1 - i] * multiplier;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        int result = getMinimumCost(k, c);
        System.out.println(result);
        scanner.close();
    }
}