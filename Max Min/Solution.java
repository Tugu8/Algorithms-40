import java.util.*;

public class Solution {

    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - k; i++) {
            int currentUnfairness = arr[i + k - 1] - arr[i];
            if (currentUnfairness < minUnfairness) {
                minUnfairness = currentUnfairness;
            }
        }
        return minUnfairness;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = maxMin(k, arr);
        System.out.println(result);
        scanner.close();
    }
}