class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
      
        // Create pairs of [value, label] for sorting
        int[][] valueLabelPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            valueLabelPairs[i] = new int[] {values[i], labels[i]};
        }
      
        // Sort pairs in descending order by value (greedy approach - pick highest values first)
        Arrays.sort(valueLabelPairs, (a, b) -> b[0] - a[0]);
      
        // Track how many times each label has been used
        Map<Integer, Integer> labelUsageCount = new HashMap<>();
      
        int totalSum = 0;
        int itemsSelected = 0;
      
        // Iterate through sorted pairs and select values greedily
        for (int i = 0; i < n && itemsSelected < numWanted; i++) {
            int currentValue = valueLabelPairs[i][0];
            int currentLabel = valueLabelPairs[i][1];
          
            // Check if we can still use this label (haven't reached useLimit)
            if (labelUsageCount.getOrDefault(currentLabel, 0) < useLimit) {
                // Update label usage count
                labelUsageCount.merge(currentLabel, 1, Integer::sum);
              
                // Add value to result and increment selected items counter
                itemsSelected++;
                totalSum += currentValue;
            }
        }
      
        return totalSum;
    }
}
