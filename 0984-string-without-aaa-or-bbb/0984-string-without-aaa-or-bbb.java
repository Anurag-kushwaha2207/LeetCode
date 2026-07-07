class Solution {
    /**
     * Generate a string containing 'a' and 'b' characters without 3 consecutive same characters
     * @param a - count of 'a' characters to include
     * @param b - count of 'b' characters to include
     * @return a valid string with given counts of 'a' and 'b' without "aaa" or "bbb"
     */
    public String strWithout3a3b(int a, int b) {
        StringBuilder result = new StringBuilder();
      
        // Process while both counts are positive
        while (a > 0 && b > 0) {
            if (a > b) {
                // When 'a' count is greater, use two 'a's and one 'b'
                result.append("aab");
                a -= 2;
                b -= 1;
            } else if (a < b) {
                // When 'b' count is greater, use two 'b's and one 'a'
                result.append("bba");
                a -= 1;
                b -= 2;
            } else {
                // When counts are equal, alternate between 'a' and 'b'
                result.append("ab");
                a--;
                b--;
            }
        }
      
        // Append remaining 'a' characters if any
        if (a > 0) {
            result.append("a".repeat(a));
        }
      
        // Append remaining 'b' characters if any
        if (b > 0) {
            result.append("b".repeat(b));
        }
      
        return result.toString();
    }
}
