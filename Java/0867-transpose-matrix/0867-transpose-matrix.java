// https://leetcode.com/problems/transpose-matrix

/*
Approach:
1. Create a new matrix with swapped dimensions (cols x rows).
2. Traverse every element of the original matrix.
3. Place each element at its transposed position:
   matrix[row][col] -> newMatrix[col][row]

Time Complexity: O(rows * cols)
Space Complexity: O(rows * cols)
*/

class Solution {
    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] newMatrix = new int[cols][rows];

        // Copy elements to their transposed positions
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                newMatrix[col][row] = matrix[row][col];
            }
        }

        return newMatrix;
    }
}