// https://leetcode.com/problems/reshape-the-matrix/

class Solution {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        // Reshape is not possible
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        int row = 0;
        int col = 0;

        // Fill the reshaped matrix
        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {

                result[row][col] = mat[i][j];
                col++;

                // Column limit reached
                // Move to the next row
                if (col == c) {
                    row++;
                    col = 0;
                }
            }
        }

        return result;
    }
}


/*
Approach:
    1. Check if reshape is possible by comparing the total number of elements.
    2. Create a new matrix of size r × c.
    3. Traverse the original matrix row by row.
    4. Copy each element into the new matrix.
    5. Move to the next row when the current row is filled.
    6. Return the reshaped matrix.

Time Complexity: O(m * n)
Space Complexity: O(r * c)
*/