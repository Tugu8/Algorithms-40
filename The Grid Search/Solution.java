import java.io.*;
import java.util.*;


class Result {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
        if (G == null || P == null || G.isEmpty() || P.isEmpty()) {
            return "NO";
        }
        
        int gridRows = G.size();
        int gridCols = G.get(0).length();
        int patternRows = P.size();
        int patternCols = P.get(0).length();
        
        for (int i = 0; i <= gridRows - patternRows; i++) {
            for (int j = 0; j <= gridCols - patternCols; j++) {
                if (checkPattern(G, P, i, j)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static boolean checkPattern(List<String> G, List<String> P, int row, int col) {
        int r = P.size();
        int c = P.get(0).length();
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (G.get(row + i).charAt(col + j) != P.get(i).charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int R = Integer.parseInt(firstMultipleInput[0]);

            List<String> G = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                String GItem = bufferedReader.readLine();
                G.add(GItem);
            }

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int r = Integer.parseInt(secondMultipleInput[0]);

            List<String> P = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                String PItem = bufferedReader.readLine();
                P.add(PItem);
            }

            String result = Result.gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
