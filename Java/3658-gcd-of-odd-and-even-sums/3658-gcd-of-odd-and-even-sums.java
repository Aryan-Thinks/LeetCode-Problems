class Solution {

    public int gcdOfOddEvenSums(int n) {

        // Sum of first n odd numbers = n * n
        int oddSum = n * n;

        // Sum of first n even numbers = n * (n + 1)
        int evenSum = n * (n + 1);

        // Return the GCD of the two sums
        return gcd(oddSum, evenSum);
    }

    public int gcd(int a, int b) {

        // The GCD cannot be greater than the smaller number
        int min = Math.min(a, b);

        // Check from the smaller number down to 1
        for (int i = min; i >= 1; i--) {

            // If both numbers are divisible by i, it is the GCD
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }

        // 1 is always the GCD if no larger common divisor is found
        return 1;
    }

     // Euclidean Algorithm
    public int gcd2(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }
}