class Solution {
    /**
     * Finds the maximum number of non-overlapping palindromic substrings
     * that can be formed by decomposing the given text.
     * The decomposition works by finding matching prefixes and suffixes.
     * 
     * @param text the input string to decompose
     * @return the maximum number of substrings in the decomposition
     */
    public int longestDecomposition(String text) {
        int decompositionCount = 0;
        int leftPointer = 0;
        int rightPointer = text.length() - 1;
      
        // Process the string from both ends towards the middle
        while (leftPointer <= rightPointer) {
            boolean matchFound = false;
          
            // Try to find matching substrings of increasing length
            for (int substringLength = 1; 
                 leftPointer + substringLength - 1 < rightPointer - substringLength + 1; 
                 substringLength++) {
              
                // Check if the substring starting at leftPointer matches
                // the substring starting at (rightPointer - substringLength + 1)
                if (areSubstringsEqual(text, leftPointer, rightPointer - substringLength + 1, substringLength)) {
                    // Found matching prefix and suffix
                    decompositionCount += 2;  // Count both prefix and suffix
                    leftPointer += substringLength;
                    rightPointer -= substringLength;
                    matchFound = true;
                    break;
                }
            }
          
            // If no matching prefix and suffix found, the remaining middle part
            // forms a single substring in the decomposition
            if (!matchFound) {
                decompositionCount++;
                break;
            }
        }
      
        return decompositionCount;
    }
  
    /**
     * Checks if two substrings of given length are equal.
     * 
     * @param text the string containing the substrings
     * @param startIndex1 starting index of the first substring
     * @param startIndex2 starting index of the second substring
     * @param length the length of substrings to compare
     * @return true if the substrings are equal, false otherwise
     */
    private boolean areSubstringsEqual(String text, int startIndex1, int startIndex2, int length) {
        // Compare characters one by one
        for (int offset = 0; offset < length; offset++) {
            if (text.charAt(startIndex1 + offset) != text.charAt(startIndex2 + offset)) {
                return false;
            }
        }
        return true;
    }
}