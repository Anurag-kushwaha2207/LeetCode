class Solution {
    public int movesToMakeZigzag(int[] nums) {
        // Store the number of moves needed for each strategy:
        // movesNeeded[0]: moves to make even-indexed elements smaller (peaks at odd indices)
        // movesNeeded[1]: moves to make odd-indexed elements smaller (peaks at even indices)
        int[] movesNeeded = new int[2];
        int arrayLength = nums.length;
      
        // Try both strategies: starting from index 0 (even) and index 1 (odd)
        for (int startIndex = 0; startIndex < 2; startIndex++) {
            // Process elements at positions: startIndex, startIndex+2, startIndex+4, ...
            // These are the elements we want to make smaller than their neighbors
            for (int currentIndex = startIndex; currentIndex < arrayLength; currentIndex += 2) {
                int decrementNeeded = 0;
              
                // Check left neighbor: ensure current element is smaller than left neighbor
                if (currentIndex > 0) {
                    // Calculate how much to decrease current element to be smaller than left neighbor
                    decrementNeeded = Math.max(decrementNeeded, nums[currentIndex] - nums[currentIndex - 1] + 1);
                }
              
                // Check right neighbor: ensure current element is smaller than right neighbor
                if (currentIndex < arrayLength - 1) {
                    // Calculate how much to decrease current element to be smaller than right neighbor
                    decrementNeeded = Math.max(decrementNeeded, nums[currentIndex] - nums[currentIndex + 1] + 1);
                }
              
                // Accumulate the total moves needed for this strategy
                movesNeeded[startIndex] += decrementNeeded;
            }
        }
      
        // Return the minimum moves between the two strategies
        return Math.min(movesNeeded[0], movesNeeded[1]);
    }
}
