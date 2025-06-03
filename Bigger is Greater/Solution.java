import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
    // Write your code here
        char[] chars = w.toCharArray();
        int n = chars.length;
        
        // Step 1: Find the pivot
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        if (pivot == -1) {
            return "no answer";
        }
        
        // Step 2: Find the smallest character greater than chars[pivot]
        int swapIndex = -1;
        for (int i = n - 1; i > pivot; i--) {
            if (chars[i] > chars[pivot]) {
                swapIndex = i;
                break;
            }
        }
        
        // Step 3: Swap
        swap(chars, pivot, swapIndex);
        
        // Step 4: Reverse the suffix
        reverse(chars, pivot + 1, n - 1);
        
        return new String(chars);
    }
    
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            String w = bufferedReader.readLine();

            String result = Result.biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}