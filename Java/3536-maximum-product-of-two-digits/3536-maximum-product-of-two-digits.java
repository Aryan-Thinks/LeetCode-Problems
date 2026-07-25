class Solution {

    static int maxProduct(int n) {

        int largest = -1;
        int secondLargest = -1;

        // Traverse all digits
        while (n > 0) {

            int digit = n % 10;
            n = n / 10;

            // If current digit is the largest
            if (digit >= largest) {
                secondLargest = largest;
                largest = digit;
            }

            // If current digit is the second largest
            else if (digit > secondLargest) {
                secondLargest = digit;
            }
        }

        // Return maximum product
        return largest * secondLargest;
    }
}