import java.io.*;
import java.util.*;

class Result {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        List<Integer> containerSums = new ArrayList<>();
        List<Integer> ballSums = new ArrayList<>(Collections.nCopies(n, 0));

        for (List<Integer> row : container) {
            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            containerSums.add(sum);
        }

        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (List<Integer> row : container) {
                sum += row.get(j);
            }
            ballSums.set(j, sum);
        }

        Collections.sort(containerSums);
        Collections.sort(ballSums);

        return containerSums.equals(ballSums) ? "Possible" : "Impossible";
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] containerRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> containerRowItems = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowTempItems[j]);
                    containerRowItems.add(containerItem);
                }

                container.add(containerRowItems);
            }

            String result = Result.organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}