import java.util.*;
public class Try{
   public static void diagonalPrint(int[][] M) {
    int numRows = M.length;
    int numCols = M[0].length;

    for (int diagonal = 0; diagonal < numRows + numCols - 1; diagonal++) {
        if (diagonal < numRows) {
            for (int row = diagonal; row >= 0; row--) {
                int col = diagonal - row;
                if (isValidIndex(row, col, numRows, numCols)) {
                    System.out.print(M[row][col] + " ");
                }
            }
        } else {
            for (int row = numRows - 1; row >= 0; row--) {
                int col = diagonal - row;
                if (isValidIndex(row, col, numRows, numCols)) {
                    System.out.print(M[row][col] + " ");
                }
            }
        }
    }
    System.out.println(); // Add a newline after printing the diagonals
}

// Helper method to check if row and column indices are within matrix bounds
private static boolean isValidIndex(int row, int col, int numRows, int numCols) {
    return row >= 0 && row < numRows && col >= 0 && col < numCols;
}

public static void main(String[] args) {
    int[][] matrix1 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    int[][] matrix2 = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };

    System.out.println("Matrix 1:");
    diagonalPrint(matrix1);

    System.out.println("\nMatrix 2:");
    diagonalPrint(matrix2);

    int[] A = {0, 2, 0, 2, 0, 2, 2, 1, 1, 0};
    int m = 3;
    int result = allNumsWithin(A, m);
    System.out.println("Minimum Length: " + result); // Output: 4

    int[] B = {0, 1, 1, 4, 0, 2, 0, 1, 0, 2};
    int l = 5;
    int result2 = allNumsWithin(B, l);
    System.out.println("Minimum Length: " + result2); // Output: 0
}


public static int allNumsWithin(int[] A, int k) {
    int[] count = new int[k];
    int left = 0;
    int uniqueCount = 0;
    int minLength = Integer.MAX_VALUE;

    for (int right = 0; right < A.length; right++) {
        if (A[right] >= 0 && A[right] < k && count[A[right]] == 0) {
            uniqueCount++;
        }
        count[A[right]]++;

        while (uniqueCount == k) {
            minLength = Math.min(minLength, right - left + 1);

            if (A[left] >= 0 && A[left] < k && count[A[left]] == 1) {
                uniqueCount--;
            }
            count[A[left]]--;
            left++;
        }
    }

    return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
}
    
}


