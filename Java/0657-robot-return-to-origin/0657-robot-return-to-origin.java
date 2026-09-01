// https://leetcode.com/problems/robot-return-to-origin/

class Solution {
    // Brute Force Approach
    public static boolean judgeCircle(String moves) {

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < moves.length(); i++) {

            char move = moves.charAt(i);

            if (move == 'U') {
                up++;
            } else if (move == 'D') {
                down++;
            } else if (move == 'L') {
                left++;
            } else if (move == 'R') {
                right++;
            }
        }

        return up == down && left == right;
    }


    // Optimized Approach
    public static boolean judgeCircleOptimized(String moves) {

        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {

            char move = moves.charAt(i);

            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }
}



/*
    Brute Force Approach:
    - Keep a separate counter for each direction.
    - Count how many times the robot moves Up, Down, Left, and Right.
    - For the robot to return to the origin:
        Up    must equal Down.
        Left  must equal Right.
    - If both conditions are true, return true.

    Example:
        moves = "UDLR"

        U = 1
        D = 1
        L = 1
        R = 1

        Since U == D and L == R,
        the robot returns to the origin.

    Time Complexity: O(n)
    Space Complexity: O(1)


    Optimized Approach:
    - Represent the robot's position using x and y coordinates.
    - Start at (0, 0).
    - U -> y++
    - D -> y--
    - L -> x--
    - R -> x++
    - After processing all moves, check whether
      the robot is back at (0, 0).

    Example:
        moves = "UDLR"

        Start: (0, 0)

        U -> (0, 1)
        D -> (0, 0)
        L -> (-1, 0)
        R -> (0, 0)

        Final position = (0, 0)
        Therefore, return true.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/
