class Solution {
    /**
     * Given an array nums, for each nums[i], find the number of elements smaller than it.
     * @param nums the input array
     * @return array where each element represents count of smaller numbers than the corresponding element in nums
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Create a copy of the original array for sorting
        int[] sortedArray = nums.clone();
      
        // Sort the copied array in ascending order
        Arrays.sort(sortedArray);
      
        // For each element in the original array, find its position in the sorted array
        // The position represents the count of smaller elements
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = search(sortedArray, nums[i]);
        }
      
        return nums;
    }

    /**
     * Binary search to find the leftmost position of target value in a sorted array.
     * This position equals the count of elements smaller than the target.
     * @param nums the sorted array to search in
     * @param target the value to search for
     * @return the index of the first occurrence of target (count of smaller elements)
     */
    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
      
        // Binary search for the leftmost position of target
        while (left < right) {
            int mid = (left + right) >> 1;  // Equivalent to (left + right) / 2
          
            if (nums[mid] >= target) {
                // Target is in the left half or at mid, narrow down the right boundary
                right = mid;
            } else {
                // Target is in the right half, narrow down the left boundary
                left = mid + 1;
            }
        }
      
        return left;
    }
}