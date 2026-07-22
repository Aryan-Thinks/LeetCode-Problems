// https://leetcode.com/problems/maximum-population-year/

class Solution {
    public static int maximumPopulation(int[][] logs) {

        int maxPopulation = 0;
        int answerYear = 1950;

        for (int year = 1950; year <= 2050; year++) {

            int currentPopulation = 0;

            for (int[] person : logs) {

                int birthYear = person[0];
                int deathYear = person[1];

                /*
                 Example: [1993, 1999]

                 Checking 1995:
                 1993 <= 1995  -> true
                 1999 > 1995   -> true
                 So the person is counted.

                 Checking 1999:
                 1993 <= 1999  -> true
                 1999 > 1999   -> false
                 So the person is NOT counted.

                 Birth year is counted, death year is not.
                */
                if (birthYear <= year && deathYear > year) {
                    currentPopulation++;
                }
            }

            /*
             Use > instead of >= to keep the earliest year.

             Example:
             1993 -> population 1
             1994 -> population 1

             At 1994, 1 > 1 is false,
             so 1993 remains the answer.
            */
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                answerYear = year;
            }
        }

        return answerYear;
    }
}


/*
Approach:
    1. Check every year from 1950 to 2050.
    2. For each year, check every person in logs.
    3. Count the person if they are alive in that year.
    4. Keep track of the year with the maximum population.
    5. If there is a tie, keep the earliest year.

Time Complexity: O(101 * n) = O(n)
- For each year, we check all n people.

Space Complexity: O(1)
- We only use a few variables.
*/