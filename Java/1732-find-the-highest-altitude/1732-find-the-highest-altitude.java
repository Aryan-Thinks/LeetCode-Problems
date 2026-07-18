// https://leetcode.com/problems/find-the-highest-altitude/

class Solution {
    public int largestAltitude(int[] gain) {

        int sum = 0;
        int max = 0; // Starting altitude

        for (int i = 0; i < gain.length; i++) {

            // Current altitude
            sum = sum + gain[i];

            // Update highest altitude
            max = Math.max(max, sum);
        }

        return max;
    }
}