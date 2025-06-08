import java.util.*;

public class Solution {

    static int pylons(int k, int[] arr) {
        int n = arr.length;
        int result = 0;
        int pos = 0;
        
        while (pos < n) {
            int nextPos = -1;
            // Find the farthest city within k distance that can have a power plant
            int end = Math.min(pos + k - 1, n - 1);
            for (int i = end; i >= Math.max(pos - k + 1, 0); i--) {
                if (arr[i] == 1) {
                    nextPos = i;
                    break;
                }
            }
            
            if (nextPos == -1) {
                return -1;
            }
            
            result++;
            pos = nextPos + k;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = pylons(k, arr);
        System.out.println(result);
        scanner.close();
    }
}