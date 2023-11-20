import java.util.*;

public class MatrixMult {

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        int rows1 = firstMatrix.length;
        int columns1 = firstMatrix[0].length;
        int rows2 = secondMatrix.length;
        int columns2 = secondMatrix[0].length;

        if (columns1 != rows2) {
            System.out.println("Matrix multiplication is not legal. " + "Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return null;
        }

        double[][] result = new double[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                double sum = 0;
                for (int k = 0; k < columns1; k++) {
                    sum += firstMatrix[i][k] * secondMatrix[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns for the first matrix: ");
        int columns1 = scanner.nextInt();

        System.out.print("Enter the number of rows for the second matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for the second matrix: ");
        int columns2 = scanner.nextInt();

        if (columns1 != rows2) {
            System.out.println("Matrix multiplication is not legal. " + "Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return;
        }

        double[][] matrix1 = new double[rows1][columns1];
        double[][] matrix2 = new double[rows2][columns2];

        System.out.println("Enter the elements of the first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns1; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix1[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter the elements of the second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < columns2; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix2[i][j] = scanner.nextDouble();
            }
        }

        double[][] product = multiplyMatrices(matrix1, matrix2);

        if (product != null) {
            System.out.println("Result of matrix multiplication:");
            for (double[] row : product) {
                System.out.println(Arrays.toString(row));
            }
        }

        scanner.close();
    }
}