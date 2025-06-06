import java.util.*;

public class KnightLOnAChessboard {

    static int[][] knightlOnAChessboard(int n) {
        int[][] result = new int[n - 1][n - 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                result[i - 1][j - 1] = bfs(n, i, j);
            }
        }

        return result;
    }

    static int bfs(int n, int a, int b) {
        int[][] directions = {
            { a, b }, { a, -b }, { -a, b }, { -a, -b },
            { b, a }, { b, -a }, { -b, a }, { -b, -a }
        };

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], steps = curr[2];

            if (x == n - 1 && y == n - 1) {
                return steps;
            }

            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, steps + 1});
                }
            }
        }

        return -1; // If unreachable
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] res = knightlOnAChessboard(n);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
