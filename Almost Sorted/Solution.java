import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static void almostSorted(List<Integer> arr) {
        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);
        
        if (arr.equals(sortedArr)) {
            System.out.println("yes");
            return;
        }
        
        int n = arr.size();
        int left = -1;
        int right = -1;
        
        // Find the left and right indices where the array is not sorted
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                left = i;
                break;
            }
        }
        
        for (int i = n - 1; i > 0; i--) {
            if (arr.get(i) < arr.get(i - 1)) {
                right = i;
                break;
            }
        }
        
        // Try swapping left and right
        List<Integer> temp = new ArrayList<>(arr);
        Collections.swap(temp, left, right);
        
        if (temp.equals(sortedArr)) {
            System.out.println("yes");
            System.out.println("swap " + (left + 1) + " " + (right + 1));
            return;
        }
        
        // Try reversing the segment between left and right
        temp = new ArrayList<>(arr);
        int l = left;
        int r = right;
        while (l < r) {
            Collections.swap(temp, l, r);
            l++;
            r--;
        }
        
        if (temp.equals(sortedArr)) {
            System.out.println("yes");
            System.out.println("reverse " + (left + 1) + " " + (right + 1));
            return;
        }
        
        System.out.println("no");
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}