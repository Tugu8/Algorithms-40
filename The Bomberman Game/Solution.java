import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) {
            return grid;
        }
        
        int rows = grid.size();
        int cols = grid.get(0).length();
        
        // States repeat every 4 seconds starting from n=3
        if (n % 2 == 0) {
            return createFullGrid(rows, cols);
        }
        
        // For odd n >=3, determine if it's n=3,7,... or n=5,9,...
        List<String> stateAfterFirstDetonation = detonate(grid);
        List<String> stateAfterSecondDetonation = detonate(stateAfterFirstDetonation);
        
        if (n % 4 == 3) {
            return stateAfterFirstDetonation;
        } else {
            return stateAfterSecondDetonation;
        }
    }
    
    private static List<String> createFullGrid(int rows, int cols) {
        String fullRow = new String(new char[cols]).replace('\0', 'O');
        List<String> fullGrid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            fullGrid.add(fullRow);
        }
        return fullGrid;
    }
    
    private static List<String> detonate(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] current = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            current[i] = grid.get(i).toCharArray();
        }
        
        char[][] next = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(next[i], 'O');
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (current[i][j] == 'O') {
                    next[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                            next[ni][nj] = '.';
                        }
                    }
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            result.add(new String(next[i]));
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}