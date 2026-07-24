// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

class Solution {

    public static List<Integer> minPerRow(int[][] matrix) {

        List<Integer> rowMinimums = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {

            int minimum = matrix[row][0];

            for (int col = 1; col < matrix[row].length; col++) {

                if (matrix[row][col] < minimum) {
                    minimum = matrix[row][col];
                }
            }

            rowMinimums.add(minimum);
        }

        return rowMinimums;
    }

    public static List<Integer> maxPerCol(int[][] matrix) {

        List<Integer> columnMaximums = new ArrayList<>();

        for (int col = 0; col < matrix[0].length; col++) {

            int maximum = matrix[0][col];

            for (int row = 1; row < matrix.length; row++) {

                if (matrix[row][col] > maximum) {
                    maximum = matrix[row][col];
                }
            }

            columnMaximums.add(maximum);
        }

        return columnMaximums;
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {

        List<Integer> luckyNumbers = new ArrayList<>();

        // Get all row minimums and column maximums
        List<Integer> rowMinimums = minPerRow(matrix);
        List<Integer> columnMaximums = maxPerCol(matrix);

        // Check which row minimum is also a column maximum
        for (int row = 0; row < rowMinimums.size(); row++) {

            int number = rowMinimums.get(row);

            if (columnMaximums.contains(number)) {
                luckyNumbers.add(number);
            }
        }

        return luckyNumbers;
    }
}

/*
Approach:
    1. Find the minimum element from every row and store them in a list.
    2. Find the maximum element from every column and store them in another list.
    3. Compare the row minimums with the column maximums.
    4. If a number exists in both lists, it is a lucky number.
    5. Store all such lucky numbers in the result list.

Time Complexity: O(m * n)
Space Complexity: O(m + n)
*/