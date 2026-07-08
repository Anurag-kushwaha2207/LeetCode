class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
      
        // Create an array of lists to store elements from each diagonal
        // Total number of diagonals = rows + cols - 1, but we allocate rows + cols for simplicity
        // Each diagonal is identified by the expression: rows - rowIndex + colIndex
        List<Integer>[] diagonals = new List[rows + cols];
      
        // Initialize each list in the array
        Arrays.setAll(diagonals, index -> new ArrayList<>());
      
        // Collect all elements from the matrix and group them by their diagonal
        // Elements on the same diagonal have the same value of (rows - i + j)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int diagonalIndex = rows - i + j;
                diagonals[diagonalIndex].add(mat[i][j]);
            }
        }
      
        // Sort each diagonal in descending order
        // We use descending order because we'll remove elements from the end later (removeLast)
        for (List<Integer> diagonal : diagonals) {
            Collections.sort(diagonal, (a, b) -> b - a);
        }
      
        // Place the sorted elements back into the matrix
        // removeLast() gets the smallest element (since we sorted in descending order)
        // This ensures elements are placed back in ascending order along each diagonal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int diagonalIndex = rows - i + j;
                mat[i][j] = diagonals[diagonalIndex].removeLast();
            }
        }
      
        return mat;
    }
}