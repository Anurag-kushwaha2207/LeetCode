class Solution {
    public int lengthLongestPath(String input) {
        int currentIndex = 0;
        int inputLength = input.length();
        int maxPathLength = 0;
        Deque<Integer> directoryLengthStack = new ArrayDeque<>();
      
        while (currentIndex < inputLength) {
            int indentationLevel = 0;
            while (currentIndex < inputLength && input.charAt(currentIndex) == '\t') {
                indentationLevel++;
                currentIndex++;
            }
          
            int currentNameLength = 0;
            boolean isFile = false;
            while (currentIndex < inputLength && input.charAt(currentIndex) != '\n') {
                currentNameLength++;
                if (input.charAt(currentIndex) == '.') {
                    isFile = true;
                }
                currentIndex++;
            }
          
            currentIndex++;
            while (!directoryLengthStack.isEmpty() && directoryLengthStack.size() > indentationLevel) {
                directoryLengthStack.pop();
            }
            int cumulativePathLength = currentNameLength;
            if (!directoryLengthStack.isEmpty()) {
                cumulativePathLength += directoryLengthStack.peek() + 1;
            }
            if (!isFile) {
                directoryLengthStack.push(cumulativePathLength);
            } else {
                maxPathLength = Math.max(maxPathLength, cumulativePathLength);
            }
        }
      
        return maxPathLength;
    }
}