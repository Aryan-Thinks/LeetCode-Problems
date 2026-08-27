class Solution {
    
    // Brute Force Approach
    public static int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int answer = 1;

        for (int i = 1; i <= x / i; i++) {

            if (i * i <= x) {
                answer = i;
            } else {
                break;
            }
        }

        return answer;
    }


    // Optimized Approach - Binary Search
    public static int mySqrtOptimized(int x) {

        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x / 2;
        int answer = 1;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (mid * mid <= x) {

                answer = (int) mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return answer;
    }

}


/*
    Brute Force Approach:
    - Start checking numbers from 1.
    - Find the largest number whose square is <= x.
    - If i * i <= x, update answer.
    - Stop when i * i > x.

    Example:
    x = 8

    1 * 1 = 1  <= 8
    2 * 2 = 4  <= 8
    3 * 3 = 9  > 8

    Answer = 2

    Time Complexity: O(sqrt(n))
    Space Complexity: O(1)


    Optimized Approach - Binary Search:
    - Use Binary Search to find the square root.
    - Search between 1 and x / 2.
    - Calculate mid * mid.
    - If mid * mid <= x:
        - mid can be the answer.
        - Search on the right side for a bigger value.
    - If mid * mid > x:
        - mid is too large.
        - Search on the left side.
    - Return the largest valid value.

    Example:
    x = 8

    left = 1
    right = 4

    mid = 2
    2 * 2 = 4 <= 8
    answer = 2

    Search right side.

    mid = 3
    3 * 3 = 9 > 8

    Search left side.

    Answer = 2

    Important:
    - Use long for mid * mid to avoid integer overflow
      when x is large.

    Time Complexity: O(log(n))
    Space Complexity: O(1)
*/
