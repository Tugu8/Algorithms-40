import java.util.*;

public class Solution {

    static int steadyGene(String gene) {
        int n = gene.length();
        int limit = n / 4;
        int[] count = new int[26];
        
        // Count frequency of each character
        for (char c : gene.toCharArray()) {
            count[c - 'A']++;
        }
        
        // If already steady, return 0
        if (isSteady(count, limit)) {
            return 0;
        }
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        // Sliding window approach
        for (int right = 0; right < n; right++) {
            char c = gene.charAt(right);
            count[c - 'A']--;
            
            while (isSteady(count, limit)) {
                minLen = Math.min(minLen, right - left + 1);
                char leftChar = gene.charAt(left);
                count[leftChar - 'A']++;
                left++;
            }
        }
        
        return minLen;
    }
    
    static boolean isSteady(int[] count, int limit) {
        return count['A' - 'A'] <= limit && 
               count['C' - 'A'] <= limit && 
               count['T' - 'A'] <= limit && 
               count['G' - 'A'] <= limit;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String gene = in.next();
        int result = steadyGene(gene);
        System.out.println(result);
        in.close();
    }
}