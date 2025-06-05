import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    private static int totalSum;
    private static int minDiff;
    private static List<Integer> data;
    private static List<List<Integer>> tree;
    private static boolean[] visited;

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        int n = data.size();
        Result.data = data;
        minDiff = Integer.MAX_VALUE;

        // Calculate total sum of all nodes
        totalSum = data.stream().mapToInt(Integer::intValue).sum();

        // Build the tree as an adjacency list
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        visited = new boolean[n + 1];
        dfs(1);

        return minDiff;
    }

    private static int dfs(int node) {
        visited[node] = true;
        int sum = data.get(node - 1); // node values are 1-based in the tree

        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                sum += dfs(neighbor);
            }
        }

        // Calculate the difference when cutting the edge above this node
        int diff = Math.abs(totalSum - 2 * sum);
        if (diff < minDiff && node != 1) { // Ensure we don't consider the root's "parent edge" which doesn't exist
            minDiff = diff;
        }

        return sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            List<Integer> edge = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            edges.add(edge);
        }

        int result = Result.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}