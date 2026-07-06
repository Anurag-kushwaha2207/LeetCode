class Solution {
    // Memoization table for storing results of subproblems
    private Integer[][] memo;
  
    // Table for storing maximum values in subarrays
    private int[][] maxInRange;

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
      
        // Initialize memoization table
        memo = new Integer[n][n];
      
        // Initialize table to store maximum values in each subarray
        maxInRange = new int[n][n];
      
        // Precompute maximum values for all subarrays
        for (int start = n - 1; start >= 0; start--) {
            // Maximum of single element is the element itself
            maxInRange[start][start] = arr[start];
          
            // Calculate maximum for all subarrays starting at 'start'
            for (int end = start + 1; end < n; end++) {
                maxInRange[start][end] = Math.max(maxInRange[start][end - 1], arr[end]);
            }
        }
      
        // Start the recursive calculation from the entire array
        return calculateMinSum(0, n - 1);
    }

    private int calculateMinSum(int left, int right) {
        // Base case: single leaf node has no non-leaf sum
        if (left == right) {
            return 0;
        }
      
        // Return memoized result if already computed
        if (memo[left][right] != null) {
            return memo[left][right];
        }
      
        // Initialize minimum sum to a large value
        int minSum = Integer.MAX_VALUE;
      
        // Try all possible split points
        for (int splitPoint = left; splitPoint < right; splitPoint++) {
            // Calculate sum for current split:
            // left subtree sum + right subtree sum + product of max values
            int currentSum = calculateMinSum(left, splitPoint) + 
                           calculateMinSum(splitPoint + 1, right) + 
                           maxInRange[left][splitPoint] * maxInRange[splitPoint + 1][right];
          
            // Update minimum sum
            minSum = Math.min(minSum, currentSum);
        }
      
        // Memoize and return the result
        memo[left][right] = minSum;
        return minSum;
    }
}
