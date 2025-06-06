import java.util.*;

public class BFSShortestReach {

    public static List<Integer> bfs(int n, List<List<Integer>> adj, int start) {
        int[] distances = new int[n + 1]; // 1-based index
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();

        distances[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adj.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 6;
                    queue.add(neighbor);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != start) {
                result.add(distances[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // number of queries

        for (int t = 0; t < q; t++) {
            int n = scanner.nextInt(); // number of nodes
            int m = scanner.nextInt(); // number of edges

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int start = scanner.nextInt();
            List<Integer> result = bfs(n, adj, start);

            for (int dist : result) {
                System.out.print(dist + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
