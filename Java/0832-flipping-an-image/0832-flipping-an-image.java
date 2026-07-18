class Solution {
    // Flipping the image horizontally
    // Image is reversed, [0,1,2] -> [2,1,0]
    /*
    public static int[][] flipImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {

            int start = 0;
            int end = image[i].length - 1;

            while (start < end) {

                int temp = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = temp;

                start++;
                end--;
            }
        }

        return image;
    }

    // Inverting the image
    // 0 -> 1 and 1 -> 0
    public static int[][] invertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {

                if (image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }

            }
        }

        return image;
    }

    public static int[][] flipAndInvertImage(int[][] image) {

        flipImage(image);
        invertImage(image);
        return image;
    }
    */

    public static int[][] flipAndInvertImage(int[][] image) {

    for (int i = 0; i < image.length; i++) {

        int left = 0;
        int right = image[i].length - 1;

        while (left <= right) {

            int leftVal = image[i][left];
            int rightVal = image[i][right];

            // Place inverted right value on the left
            image[i][left] = (rightVal == 0) ? 1 : 0;

            // Place inverted left value on the right
            image[i][right] = (leftVal == 0) ? 1 : 0;

            left++;
            right--;
        }
    }

    return image;
    }
}