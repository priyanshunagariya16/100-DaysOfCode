public class Solution {
    public int kInversePairs(int n, int k) {
        // Define a constant for modulo operation
        int MOD = 1000000007;

        // Create an array to store the dynamic programming values
        int[] dp = new int[k + 1];

        // Initialize dp[0] to 1 since there is only one way to have 0 inverse pairs
        dp[0] = 1;

        // Iterate from 2 to n (inclusive)
        for (int i = 2; i <= n; i++) {
            // Iterate from 1 to k
            for (int j = 1; j <= k; j++) {
                // Update dp[j] by adding the previous value dp[j] and dp[j-1]
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }

            // Iterate from k to i (inclusive) in reverse order
            for (int j = k; j >= i; j--) {
                // Update dp[j] by subtracting dp[j-i] and adding MOD, then taking modulo
                dp[j] = (dp[j] - dp[j - i] + MOD) % MOD;
            }
        }

        // Return the result stored in dp[k]
        return dp[k];
    }
}
