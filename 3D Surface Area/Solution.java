import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int surfaceArea(List<List<Integer>> A) {
        int H = A.size();
        if (H == 0) return 0;
        int W = A.get(0).size();
        int surface = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int height = A.get(i).get(j);
                if (height == 0) continue;
                // Each cube contributes 4 sides (top and bottom are handled separately)
                surface += 2; // top and bottom
                surface += 4 * height; // four sides

                // Subtract the adjacent cubes
                // Up (i-1, j)
                if (i > 0) {
                    int adjacent = A.get(i - 1).get(j);
                    surface -= 2 * Math.min(height, adjacent);
                }
                // Left (i, j-1)
                if (j > 0) {
                    int adjacent = A.get(i).get(j - 1);
                    surface -= 2 * Math.min(height, adjacent);
                }
            }
        }
        return surface;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);
        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String[] rowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> row = new ArrayList<>();
            for (String item : rowItems) {
                row.add(Integer.parseInt(item));
            }
            A.add(row);
        }

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}