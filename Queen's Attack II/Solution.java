import java.io.*;
import java.util.*;

class Result {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Directions: up, down, left, right, up-left, up-right, down-left, down-right
        int[] dr = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        
        // Initialize the closest obstacles in each direction
        int[] closest = new int[8];
        Arrays.fill(closest, Integer.MAX_VALUE);
        
        // Calculate the maximum distance to the board edge in each direction
        int up = n - r_q;
        int down = r_q - 1;
        int left = c_q - 1;
        int right = n - c_q;
        int upLeft = Math.min(up, left);
        int upRight = Math.min(up, right);
        int downLeft = Math.min(down, left);
        int downRight = Math.min(down, right);
        
        int[] maxDistances = {up, down, left, right, upLeft, upRight, downLeft, downRight};
        
        for (List<Integer> obstacle : obstacles) {
            int r = obstacle.get(0);
            int c = obstacle.get(1);
            int deltaR = r - r_q;
            int deltaC = c - c_q;
            
            // Check if the obstacle is in any of the 8 directions
            if (deltaR == 0 || deltaC == 0 || Math.abs(deltaR) == Math.abs(deltaC)) {
                int direction = -1;
                if (deltaR > 0 && deltaC == 0) direction = 0; // up
                else if (deltaR < 0 && deltaC == 0) direction = 1; // down
                else if (deltaR == 0 && deltaC < 0) direction = 2; // left
                else if (deltaR == 0 && deltaC > 0) direction = 3; // right
                else if (deltaR > 0 && deltaC < 0) direction = 4; // up-left
                else if (deltaR > 0 && deltaC > 0) direction = 5; // up-right
                else if (deltaR < 0 && deltaC < 0) direction = 6; // down-left
                else if (deltaR < 0 && deltaC > 0) direction = 7; // down-right
                
                if (direction != -1) {
                    int distance = Math.max(Math.abs(deltaR), Math.abs(deltaC)) - 1;
                    if (distance < closest[direction]) {
                        closest[direction] = distance;
                    }
                }
            }
        }
        
        int total = 0;
        for (int i = 0; i < 8; i++) {
            if (closest[i] == Integer.MAX_VALUE) {
                total += maxDistances[i];
            } else {
                total += closest[i];
            }
        }
        
        return total;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);
        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> obstaclesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowTempItems[j]);
                obstaclesRowItems.add(obstaclesItem);
            }

            obstacles.add(obstaclesRowItems);
        }

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}