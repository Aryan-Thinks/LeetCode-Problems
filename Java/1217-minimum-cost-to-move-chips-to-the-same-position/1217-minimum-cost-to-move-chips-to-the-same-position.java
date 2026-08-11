// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

class Solution {
    public static int minCostToMoveChips(int[] position) {

        int evenCount = 0;
        int oddCount = 0;

        // Count chips at even and odd positions
        for (int pos : position) {

            if (pos % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Move the smaller group
        return Math.min(evenCount, oddCount);
    }
}

/*
    Approach: Odd-Even Counting

    - Moving a chip by 2 positions costs 0.
    - So chips at even positions can be grouped for free.
    - Chips at odd positions can also be grouped for free.
    - Count chips at even and odd positions.
    - Move the smaller group to the other group.

    Answer = min(evenCount, oddCount)

    Complexity:
    Time: O(n)
    Space: O(1)
*/
