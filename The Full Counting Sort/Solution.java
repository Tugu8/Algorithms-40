import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        int n = arr.size();
        int half = n / 2;
        
        // Find the maximum integer value in the array
        int max = 0;
        for (List<String> pair : arr) {
            int num = Integer.parseInt(pair.get(0));
            if (num > max) {
                max = num;
            }
        }
        
        // Initialize a list of lists to store strings for each number
        List<List<String>> count = new ArrayList<List<String>>();
        for (int i = 0; i <= max; i++) {
            count.add(new ArrayList<String>());
        }
        
        // Populate the count array
        for (int i = 0; i < n; i++) {
            List<String> pair = arr.get(i);
            int num = Integer.parseInt(pair.get(0));
            String s = pair.get(1);
            
            // Replace strings from first half with '-'
            if (i < half) {
                s = "-";
            }
            
            count.get(num).add(s);
        }
        
        // Build the output string
        StringBuilder sb = new StringBuilder();
        for (List<String> list : count) {
            for (String s : list) {
                sb.append(s).append(" ");
            }
        }
        
        // Print the result
        System.out.println(sb.toString().trim());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        Result.countSort(arr);

        bufferedReader.close();
    }
}