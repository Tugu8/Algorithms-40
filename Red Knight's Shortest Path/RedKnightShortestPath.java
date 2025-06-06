import java.util.*;

public class RedKnightShortestPath {

    static class Position {
        int x, y;
        List<String> path;

        Position(int x, int y, List<String> path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    static String[] directions = {"UL", "UR", "R", "LR", "LL", "L"};
    static int[] dx = {-2, -2, 0, 2, 2, 0};
    static int[] dy = {-1, 1, 2, 1, -1, -2};

    public static void printShortestPath(int n, int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[n][n];
        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(startX, startY, new ArrayList<>()));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            if (pos.x == endX && pos.y == endY) {
                System.out.println(pos.path.size());
                for (String dir : pos.path) {
                    System.out.print(dir + " ");
                }
                return;
            }

            for (int i = 0; i < 6; i++) {
                int newX = pos.x + dx[i];
                int newY = pos.y + dy[i];

                if (isValid(newX, newY, n) && !visited[newX][newY]) {
                    List<String> newPath = new ArrayList<>(pos.path);
                    newPath.add(directions[i]);
                    queue.add(new Position(newX, newY, newPath));
                    visited[newX][newY] = true;
                }
            }
        }

        System.out.println("Impossible");
    }

    static boolean isValid(int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();

        printShortestPath(n, startX, startY, endX, endY);
    }
}
