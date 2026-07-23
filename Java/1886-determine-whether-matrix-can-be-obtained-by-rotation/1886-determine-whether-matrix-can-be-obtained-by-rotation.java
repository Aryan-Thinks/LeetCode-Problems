// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

class Solution {
    
    // Transpose the matrix: Swap matrix[i][j] with matrix[j][i]
    public static void transpose(int[][] mat) {

        // No need to change the dimensions
        // Swap only the upper triangular part with the lower triangular part
        for (int row = 0; row < mat.length; row++) {
            for (int col = row + 1; col < mat.length; col++) {

                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }
    }

    // Reverse each row: Swap matrix[i][j] with matrix[i][n - 1 - j]
    public static void reverseRow(int[][] mat) {

        for (int row = 0; row < mat.length; row++) {

            int left = 0;
            int right = mat[row].length - 1;

            while (left < right) {

                int temp = mat[row][left];
                mat[row][left] = mat[row][right];
                mat[row][right] = temp;

                left++;
                right--;
            }
        }
    }

    // Rotate the matrix by 90° clockwise
    // To rotate
    // 1 Transpose the matrix
    // 2 Reverse each row
    public static void rotate90(int[][] mat) {

        transpose(mat);
        reverseRow(mat);
    }

    public static boolean findRotation(int[][] mat, int[][] target) {

        // The minimum rotations required can be 0
        // Check all four possible rotations
        // 0°, 90°, 180°, and 270°
        for (int rotation = 0; rotation < 4; rotation++) {

            // Compare the current matrix with the target matrix
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }

            // Rotate the matrix by 90° clockwise
            rotate90(mat);
        }

        return false;
    }
}

/*
Approach:
    1. A matrix can be rotated only in four possible ways:
       0°, 90°, 180°, and 270°.

    2. Check if the current matrix is equal to the target matrix.

    3. To rotate the matrix by 90° clockwise:
       - Transpose the matrix: Swap matrix[i][j] with matrix[j][i].
       - Reverse each row: Swap matrix[i][j] with matrix[i][n - 1 - j].

    4. Repeat the rotation and comparison for all four possible rotations.

    5. If any rotation makes mat equal to target, return true.
       Otherwise, return false.

Time Complexity: O(n²)
- Each rotation takes O(n²) for transpose, reverse, and comparison.
- We perform at most 4 rotations, so 4 * O(n²) = O(n²).

Space Complexity: O(1)
- The matrix is modified in place.
- No extra matrix is created.
*/
