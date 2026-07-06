class Solution {

    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        // Binary Search
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Wrap around if no greater letter exists
        // Mod (%) keeps the index within array bounds
        // Example: start = 3, length = 3 → 3 % 3 = 0
        return letters[start % letters.length];
    }
}