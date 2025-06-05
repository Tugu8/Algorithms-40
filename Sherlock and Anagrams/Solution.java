import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        int totalPairs = 0;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                
                frequencyMap.put(sorted, frequencyMap.getOrDefault(sorted, 0) + 1);
            }
        }
        
        for (int count : frequencyMap.values()) {
            totalPairs += count * (count - 1) / 2;
        }
        
        return totalPairs;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}