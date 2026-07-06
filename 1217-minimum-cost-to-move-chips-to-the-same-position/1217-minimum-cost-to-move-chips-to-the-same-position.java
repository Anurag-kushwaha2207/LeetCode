class Solution {
    public int minCostToMoveChips(int[] position) {
        // Count chips at odd positions
        int chipsAtOddPositions = 0;
      
        // Iterate through all chip positions
        for (int chipPosition : position) {
            // If position is odd, increment counter
            chipsAtOddPositions += chipPosition % 2;
        }
      
        // Calculate chips at even positions
        int chipsAtEvenPositions = position.length - chipsAtOddPositions;
      
        // Return minimum cost: move either all odd-positioned chips to even positions
        // or all even-positioned chips to odd positions
        return Math.min(chipsAtOddPositions, chipsAtEvenPositions);
    }
}