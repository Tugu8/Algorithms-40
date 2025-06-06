import java.util.*;

public class SnakesAndLadders {

    public static int quickestWayUp(Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        boolean[] visited = new boolean[101]; // squares 1 to 100
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0}); // {position, moves}
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int moves = current[1];

            if (position == 100) {
                return moves;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = position + dice;
                if (next > 100) continue;

                if (ladders.containsKey(next)) {
                    next = ladders.get(next);
                } else if (snakes.containsKey(next)) {
                    next = snakes.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, moves + 1});
                }
            }
        }

        return -1; // if unreachable
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // number of ladders
            Map<Integer, Integer> ladders = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                ladders.put(start, end);
            }

            int m = scanner.nextInt(); // number of snakes
            Map<Integer, Integer> snakes = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                snakes.put(start, end);
            }

            int result = quickestWayUp(ladders, snakes);
            System.out.println(result);
        }

        scanner.close();
    }
}
