// https://leetcode.com/problems/count-days-spent-together

class Solution {

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        // Find the overlapping start and end dates
        String start = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        // Convert dates into day numbers
        int startMonth = Integer.parseInt(start.substring(0, 2));
        int startDay = Integer.parseInt(start.substring(3));

        int endMonth = Integer.parseInt(end.substring(0, 2));
        int endDay = Integer.parseInt(end.substring(3));

        int startDate = days[startMonth - 1] + startDay;
        int endDate = days[endMonth - 1] + endDay;

        // Return the number of overlapping days
        return Math.max(endDate - startDate + 1, 0);
    }
}

/*
    Approach:

    - Find the later arrival date of Alice and Bob
    - Find the earlier departure date of Alice and Bob
    - Convert both dates into day numbers using cumulative month days
    - Calculate the overlapping days, including both start and end dates
    - Return 0 if there is no overlap

    Time Complexity: O(1)
    Space Complexity: O(1)

    Important:
    - Dates in MM-DD format can be compared using compareTo()
    - Add 1 because both arrival and departure dates are included
    - Math.max() ensures the answer is never negative
*/
