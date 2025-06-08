import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        // Precompute all possible M values up to the maximum possible N (40 as per constraints)
        int maxN = 40;
        int[] ways = new int[maxN + 1];
        computeWays(ways, maxN);
        
        // Precompute primes up to the maximum possible ways (ways[40] = 217286)
        int maxWays = ways[maxN];
        boolean[] isPrime = sieveOfEratosthenes(maxWays);
        int[] primeCount = new int[maxWays + 1];
        computePrimeCount(primeCount, isPrime);
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = ways[N];
            System.out.println(primeCount[M]);
        }
        scanner.close();
    }
    
    private static void computeWays(int[] ways, int maxN) {
        ways[0] = 1; // base case
        for (int i = 1; i <= maxN; i++) {
            ways[i] = ways[i - 1]; // place a vertical brick
            if (i >= 4) {
                ways[i] += ways[i - 4]; // place four horizontal bricks
            }
        }
    }
    
    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
    
    private static void computePrimeCount(int[] primeCount, boolean[] isPrime) {
        int count = 0;
        for (int i = 0; i < primeCount.length; i++) {
            if (i > 1 && isPrime[i]) {
                count++;
            }
            primeCount[i] = count;
        }
    }
}