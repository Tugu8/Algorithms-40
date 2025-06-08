import java.util.*;

public class Solution {

    static int[] maxSubarray(int[] arr) {
        int[] result = new int[2];
        
        // Kadane's algorithm for maximum contiguous subarray
        int maxCurrent = arr[0];
        int maxGlobal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }
        result[0] = maxGlobal;
        
        // Maximum non-contiguous subsequence (sum of all positives, or single max if all negatives)
        int maxNonContig = 0;
        int maxElement = Integer.MIN_VALUE;
        boolean hasPositive = false;
        
        for (int num : arr) {
            if (num > 0) {
                maxNonContig += num;
                hasPositive = true;
            }
            if (num > maxElement) {
                maxElement = num;
            }
        }
        
        result[1] = hasPositive ? maxNonContig : maxElement;
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            int[] result = maxSubarray(arr);
            System.out.println(result[0] + " " + result[1]);
        }
        scanner.close();
    }
}