class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
       
        List<Integer> result = new ArrayList<>();
      
        for (int startDigit = 1; startDigit < 9; ++startDigit) {
           
            int currentNumber = startDigit;
            for (int nextDigit = startDigit + 1; nextDigit < 10; ++nextDigit) {
                
                currentNumber = currentNumber * 10 + nextDigit;
                if (currentNumber >= low && currentNumber <= high) {
                    result.add(currentNumber);
                }
            }
        }
      
        Collections.sort(result);
      
        return result;
    }
}