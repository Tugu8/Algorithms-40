import java.util.*;

public class Solution {
    // Method to determine the winner
    public static String gamingArray(List<Integer> arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxCount = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > maxSoFar) {
                maxSoFar = arr.get(i);
                maxCount++;
            }
        }

        // If maxCount is odd, "BOB" wins (first player)
        // If even, "ANDY" wins
        return (maxCount % 2 == 1) ? "BOB" : "ANDY";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        while (g-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            System.out.println(gamingArray(arr));
        }
        sc.close();
    }
}
