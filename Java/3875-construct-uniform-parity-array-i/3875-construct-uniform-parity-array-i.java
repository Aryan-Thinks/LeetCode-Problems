// https://leetcode.com/problems/construct-uniform-parity-array-i/

class Solution {

    // Brute Force Approach
    public static boolean uniformArray(int[] nums1) {

        boolean canMakeOdd = true;
        boolean canMakeEven = true;

        for (int i = 0; i < nums1.length; i++) {

            // Check if nums1[i] is odd
            if (nums1[i] % 2 != 0) {

                // An odd number can stay odd by choosing nums1[i].
                // But it cannot become even by subtracting another
                // number unless there is an even number available.
                boolean foundEven = false;

                for (int j = 0; j < nums1.length; j++) {

                    if (i != j && nums1[j] % 2 == 0) {
                        foundEven = true;
                        break;
                    }
                }

                if (!foundEven) {
                    // Keep nums1[i] as it is.
                    // So making everything odd is still possible.
                    canMakeEven = false;
                }
            }
        }

        // We can always make the array all odd.
        // If there is an odd number, keep it as it is.
        // Every even number can subtract that odd number.
        //
        // If there is no odd number, all numbers are already even.

        return canMakeOdd || canMakeEven;
    }


    // Optimized Approach
    public static boolean uniformArrayOptimized(int[] nums1) {

        boolean hasOdd = false;

        // Check whether the array contains at least one odd number.
        for (int i = 0; i < nums1.length; i++) {

            if (nums1[i] % 2 != 0) {
                hasOdd = true;
                break;
            }
        }

        /*
            If there is at least one odd number:

            - Keep every odd number unchanged.
            - For every even number, subtract the odd number.

              even - odd = odd

            Therefore, all elements can become odd.

            If there is no odd number:
            - Every element is already even.
            - Keep every element unchanged.

            Therefore, the answer is always true.
        */

        return true;
    }
}


/*
    Brute Force Approach:
    - Check the parity of each element.
    - We can keep an element unchanged.
    - If there is an odd number, we can use it to change
      every even number into an odd number.

        even - odd = odd

    - Odd numbers can simply remain unchanged.

    Example:
        nums1 = [2, 3]

        For 2:
            2 - 3 = -1 -> odd

        For 3:
            Keep 3 -> odd

        nums2 = [-1, 3]

        Both elements are odd.

    Time Complexity: O(n^2)
    Space Complexity: O(1)


    Optimized Approach:
    - We only need to know whether the array contains
      at least one odd number.
    - If there is an odd number:
        Keep odd numbers unchanged.
        Subtract that odd number from every even number.

        even - odd = odd

        Therefore, all elements become odd.

    - If there is no odd number:
        All elements are already even.
        Keep them unchanged.

    Therefore, it is ALWAYS possible to construct nums2.

    Example 1:
        nums1 = [2, 3]

        2 - 3 = -1 -> odd
        3          -> odd

        nums2 = [-1, 3]

    Example 2:
        nums1 = [2, 4, 6]

        Keep all elements:

        nums2 = [2, 4, 6]

        All elements are even.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/
