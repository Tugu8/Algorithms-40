import java.util.*;

public class PrimsMST {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int prims(int n, List<List<Edge>> adj, int start) {
        boolean[] visited = new boolean[n + 1]; // 1-based indexing
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int totalWeight = 0;

        // Start with the initial node
        visited[start] = true;
        pq.addAll(adj.get(start));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (!visited[edge.to]) {
                visited[edge.to] = true;
                totalWeight += edge.weight;
                for (Edge next : adj.get(edge.to)) {
                    if (!visited[next.to]) {
                        pq.add(next);
                    }
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();

            // Undirected graph
            adj.get(u).add(new Edge(v, weight));
            adj.get(v).add(new Edge(u, weight));
        }

        int start = sc.nextInt(); // starting node
        System.out.println(prims(n, adj, start));
    }
}
