class Solution {
    public int numSquares(int n) {
        // Calculate the maximum perfect square that could be used (sqrt of n)
        int maxSquareRoot = (int) Math.sqrt(n);
        int[][] dp = new int[maxSquareRoot + 1][n + 1];
      
        // Initialize all values to a large number (infinity)
        for (int[] row : dp) {
            Arrays.fill(row, 1 << 30); // Using bit shift for large value (2^30)
        }
      
        // Base case: 0 squares needed to sum to 0
        dp[0][0] = 0;
      
        // Fill the DP table
        for (int i = 1; i <= maxSquareRoot; i++) {
            int currentSquare = i * i; // The current perfect square being considered
          
            for (int j = 0; j <= n; j++) {
             
                dp[i][j] = dp[i - 1][j];
              
                if (j >= currentSquare) {
            
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - currentSquare] + 1);
                }
            }
        }
      
        return dp[maxSquareRoot][n];
    }
}
