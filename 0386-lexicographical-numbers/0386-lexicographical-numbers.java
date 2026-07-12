class Solution {
   
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
      
        int currentNumber = 1;
      
        for (int i = 0; i < n; i++) {
            result.add(currentNumber);
          
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber + 1 > n) {
                    currentNumber /= 10;
                }
                currentNumber++;
            }
        }
      
        return result;
    }
}