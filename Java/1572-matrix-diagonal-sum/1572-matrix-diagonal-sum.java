class Solution {
    public int diagonalSum(int[][] mat) {

        int sum = 0;
        int n = mat.length;

        // Add elements from both diagonals
        for (int i = 0; i < n; i++) {
            // Primary diagonal
            sum += mat[i][i];

            // Secondary diagonal
            sum += mat[i][n - 1 - i];
        }

        // If the matrix size is odd,
        // The center element is counted twice.
        // Remove it once.
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }

        return sum;
    }
}