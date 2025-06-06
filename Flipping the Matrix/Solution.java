import java.util.*;

public class Solution {
    public static int flippingMatrix(int[][] matrix) {
        int n = matrix.length / 2;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = matrix[i][j];
                int b = matrix[i][2 * n - j - 1];
                int c = matrix[2 * n - i - 1][j];
                int d = matrix[2 * n - i - 1][2 * n - j - 1];
                total += Math.max(Math.max(a, b), Math.max(c, d));
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); // number of test cases

        while (q-- > 0) {
            int n = sc.nextInt(); // n in 2n x 2n
            int[][] matrix = new int[2 * n][2 * n];

            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int result = flippingMatrix(matrix);
            System.out.println(result);
        }

        sc.close();
    }
}
