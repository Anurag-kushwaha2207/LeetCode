class Solution {
    public int trap(int[] height) {
        // Get the length of the height array
        int n = height.length;
      
        // Arrays to store the maximum height to the left and right of each position
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
      
        // Initialize the first element of leftMax and last element of rightMax
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
      
        // Fill both arrays in a single pass
        // leftMax[i] stores the maximum height from index 0 to i
        // rightMax[i] stores the maximum height from index i to n-1
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - i - 1]);
        }
      
        // Calculate the total trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            // Water trapped at position i is determined by the minimum of
            // the maximum heights on both sides minus the current height
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
      
        return totalWater;
    }
}
