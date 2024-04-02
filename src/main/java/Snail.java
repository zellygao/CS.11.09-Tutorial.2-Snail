public class Snail {

    /**
     * TODO 5
     * <p>
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     * <p>
     * Example:
     * <p>
     * Input:
     * <p>
     * {
     * {1,2,3},
     * {4,5,6},
     * {7,8,9}
     * }
     * <p>
     * Output:
     * <p>
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     * returns an empty array if array2d is not square.
     */

    public static int[] flattenSnail(int[][] array2d) {
        int[] empty = new int[0];
        if (array2d == null) {
            return empty;
        }
        for (int i = 0; i < array2d.length; i++) {
            if (array2d[i].length != array2d.length) {
                return empty;
            }
        }

        int n = array2d.length; // one side of the size
        int[] arr = new int[n * n];

        int topRow = 0;
        int bottomRow = n - 1;
        int leftCol = 0;
        int rightCol = n - 1;

        int index = 0;
        while (topRow <= bottomRow && leftCol <= rightCol) {
            // Traverse the top row going right
            for (int i = leftCol; i <= rightCol; i++) {
                if (topRow >= 0 && topRow < n && i >= 0 && i < n) {
                    arr[index] = array2d[topRow][i];
                    index++;
                }
            }
            topRow++;

            // Traverse down the right column
            for (int i = topRow; i <= bottomRow; i++) {
                if (i >= 0 && i < n && rightCol >= 0 && rightCol < n) {
                    arr[index] = array2d[i][rightCol];
                    index++;
                }
            }
            rightCol--;

            if (topRow <= bottomRow) {
                // Traverse the bottom row going left
                for (int i = rightCol; i >= leftCol; i--) {
                    if (bottomRow >= 0 && bottomRow < n && i >= 0 && i < n) {
                        arr[index] = array2d[bottomRow][i];
                        index++;
                    }
                }
                bottomRow--;
            }

            if (leftCol <= rightCol) {
                // Traverse up the left column
                for (int i = bottomRow; i >= topRow; i--) {
                    if (i >= 0 && i < n && leftCol >= 0 && leftCol < n) {
                        arr[index] = array2d[i][leftCol];
                        index++;
                    }
                }
                leftCol++;
            }
        }

        return arr;
}

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[]array1d) {
        if (array1d == null || array1d.length == 0 || !isPerfectSquare(array1d)) {
            int[][] empty = new int[0][0];
            return empty;
        }

        int n = (int) Math.sqrt(array1d.length);
        int[][] arr2d = new int[n][n];

        int a = 0; // current
        int b = 0;

        for (int i = 0; i < array1d.length; i++) {
            for (int x = 0; x < arr2d.length; ) {
                for (int y = 0; y < arr2d[x].length; ) {
                    arr2d[x][y] = array1d[i];
                    if (a == 0) {
                        if (y == n - 1 - b) {
                            a = 1;
                            x++; // move right
                        } else {
                            y++;
                        }
                    } else if (a == 2) {
                        if (y == b) {
                            a = 3;
                            x--;
                            b++;
                        } else {
                            y--;
                        }
                    } else {
                        if (x == a) {
                            a = 0;
                            y++;
                        } else {
                            x++;
                        }
                    }
                }
            }
        }
        return arr2d;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[]array1d) {
        for(int elem:array1d){
            System.out.println(elem);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for(int[] row:array2d){
            for(int col:row){
                System.out.println(col);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */

    private static boolean isPerfectSquare(int[] array1d) {
        int sqrt = (int) Math.sqrt (array1d.length);
        return array1d.length == sqrt;
    }

    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        for(int[]row:array2d){
            if(row.length != array2d.length){
                return false;
            }
        }
        return true;
    }

}
