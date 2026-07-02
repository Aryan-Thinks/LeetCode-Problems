class Solution {

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (hasEvenDigits(num)) {
                count++;
            }
        }

        return count;
    }

    // Checks whether a number has an even number of digits
    private boolean hasEvenDigits(int num) {

        // Method 1: Convert number to String

        // String n = Integer.toString(Math.abs(num));
        // return n.length() % 2 == 0;

        // Method 2: Count the digits
        
        num = Math.abs(num);

        if (num == 0) {
            return false; // 0 has 1 digit
        }

        int count = 0;

        while (num > 0) {
            count++;
            num /= 10;
        }

        return count % 2 == 0;
    }
}