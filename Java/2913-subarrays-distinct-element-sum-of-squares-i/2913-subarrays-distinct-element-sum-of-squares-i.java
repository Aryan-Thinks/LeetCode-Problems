// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();

        // Fix the starting index of the subarray
        for (int i = 0; i < n; i++) {
            Set<Integer> distinctSet = new HashSet<>();

            // Extend the subarray to the right
            for (int j = i; j < n; j++) {
                distinctSet.add(nums.get(j));
                
                int distinctCount = distinctSet.size();
                totalSum += distinctCount * distinctCount;
            }
        }

        return totalSum;
    }
}

/*
    Approach:
    
    - Use nested loops to generate every possible contiguous subarray (starting at `i` and ending at `j`)
    - Use a HashSet for each starting position `i` to keep track of unique elements as we extend the ending index `j`
    - For every subarray, compute the square of the distinct element count (`size * size`) and add it to the total sum

    Time Complexity: O(n^2)
    Space Complexity: O(n)

    Important:
    - Given the small constraints ($n \le 100$), an $\mathcal{O}(n^2)$ nested loop approach with a HashSet is optimal and easily passes within the time limit.
    - Re-initializing the HashSet for each new starting index `i` ensures we correctly capture distinct counts for each fresh sequence.
*/