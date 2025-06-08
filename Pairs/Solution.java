import java.util.*;

public class Solution {

    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = 1;
        int n = arr.length;
        
        while (j < n) {
            int diff = arr[j] - arr[i];
            if (diff == k) {
                count++;
                i++;
                j++;
            } else if (diff < k) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        scanner.close();
    }
}