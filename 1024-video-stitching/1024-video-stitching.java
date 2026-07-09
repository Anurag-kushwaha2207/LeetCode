class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] farthestReach = new int[time];
      
        for (int[] clip : clips) {
            int startTime = clip[0];
            int endTime = clip[1];
          
            if (startTime < time) {
                farthestReach[startTime] = Math.max(farthestReach[startTime], endTime);
            }
        }
      
        int numClips = 0;         
        int maxReachable = 0;        
        int currentIntervalEnd = 0; 
        for (int currentTime = 0; currentTime < time; currentTime++) {
      
            maxReachable = Math.max(maxReachable, farthestReach[currentTime]);
          
            if (maxReachable <= currentTime) {
                return -1;
            }
          
          
            if (currentIntervalEnd == currentTime) {
                numClips++;
                currentIntervalEnd = maxReachable;
            }
        }
      
        return numClips;
    }
}
