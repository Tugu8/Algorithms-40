import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static String countLuck(List<String> matrix, int k) {
        int n = matrix.size();
        int m = matrix.get(0).length();
        int startX = -1, startY = -1;
        int endX = -1, endY = -1;

        // Find the positions of 'M' and '*'
        for (int i = 0; i < n; i++) {
            String row = matrix.get(i);
            for (int j = 0; j < m; j++) {
                if (row.charAt(j) == 'M') {
                    startX = i;
                    startY = j;
                } else if (row.charAt(j) == '*') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;
        int[][] decisionCount = new int[n][m];
        decisionCount[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                break;
            }

            List<int[]> nextCells = new ArrayList<>();
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    char cell = matrix.get(newX).charAt(newY);
                    if (cell == '.' || cell == '*') {
                        nextCells.add(new int[]{newX, newY});
                    }
                }
            }

            if (nextCells.size() > 1) {
                for (int[] cell : nextCells) {
                    decisionCount[cell[0]][cell[1]] = decisionCount[x][y] + 1;
                }
            } else if (nextCells.size() == 1) {
                decisionCount[nextCells.get(0)[0]][nextCells.get(0)[1]] = decisionCount[x][y];
            }

            for (int[] cell : nextCells) {
                visited[cell[0]][cell[1]] = true;
                queue.add(cell);
            }
        }

        if (decisionCount[endX][endY] == k) {
            return "Impressed";
        } else {
            return "Oops!";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);

            List<String> matrix = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                matrix.add(bufferedReader.readLine());
            }

            int k = Integer.parseInt(bufferedReader.readLine().trim());

            String result = Result.countLuck(matrix, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}