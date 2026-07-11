class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
      
        // leftMin[i] stores the minimum value to the left of index i
        int[] leftMin = new int[n];
        // rightMax[i] stores the maximum value to the right of index i
        int[] rightMax = new int[n];
      
        // Initialize first element (no elements to its left)
        leftMin[0] = Integer.MAX_VALUE;
        // Initialize last element (no elements to its right)
        rightMax[n - 1] = Integer.MIN_VALUE;
      
        // Build leftMin array: for each position, find minimum value before it
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i - 1]);
        }
      
        // Build rightMax array: for each position, find maximum value after it
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
        }
      
        // Check if there exists a triplet where leftMin[i] < nums[i] < rightMax[i]
        // This means we have found three indices j < i < k where nums[j] < nums[i] < nums[k]
        for (int i = 0; i < n; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }
      
        return false;
    }
}
