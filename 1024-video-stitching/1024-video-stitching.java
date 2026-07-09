class Solution {
    public int videoStitching(int[][] clips, int time) {
        // Array to store the farthest point each position can reach
        // last[i] represents the maximum end time that can be reached from position i
        int[] farthestReach = new int[time];
      
        // Preprocess clips to find the farthest reach from each starting position
        for (int[] clip : clips) {
            int startTime = clip[0];
            int endTime = clip[1];
          
            // Only consider clips that start before our target time
            if (startTime < time) {
                farthestReach[startTime] = Math.max(farthestReach[startTime], endTime);
            }
        }
      
        // Variables for greedy algorithm
        int numClips = 0;           // Number of clips used
        int maxReachable = 0;        // Maximum position reachable so far
        int currentIntervalEnd = 0;  // End of current selected interval
      
        // Iterate through each time point to find minimum clips needed
        for (int currentTime = 0; currentTime < time; currentTime++) {
            // Update the maximum reachable position from current and previous positions
            maxReachable = Math.max(maxReachable, farthestReach[currentTime]);
          
            // If we cannot reach beyond current position, it's impossible to cover
            if (maxReachable <= currentTime) {
                return -1;
            }
          
            // If we've reached the end of our current interval, select a new clip
            if (currentIntervalEnd == currentTime) {
                numClips++;
                currentIntervalEnd = maxReachable;
            }
        }
      
        return numClips;
    }
}
