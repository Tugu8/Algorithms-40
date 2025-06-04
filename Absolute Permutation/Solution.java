import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
            return result;
        }
        if (n % (2 * k) != 0) {
            result.add(-1);
            return result;
        }
        int[] arr = new int[n + 1]; // Using 1-based index
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                arr[i] = i + k;
                arr[i + k] = i;
            }
        }
        for (int i = 1; i <= n; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            List<Integer> result = Result.absolutePermutation(n, k);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}