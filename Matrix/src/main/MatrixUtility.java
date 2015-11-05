package main;

import main.MatrixExceptions.WrongMultiplicationMatrixException;
import main.MatrixExceptions.WrongSumMatrixException;

/**
 * Created by iantaman on 17.10.2015.
 */
public class MatrixUtility {

    private static final String delimiter = "*****";

    public static int[][] createMatrix(int rowNumbers, int column) {
        System.out.println("New matrix:");
        int[][] matrix = new int[rowNumbers][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Double(Math.random()*10).intValue();
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println(delimiter);
        return matrix;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) throws WrongMultiplicationMatrixException {
        System.out.println("Multiplication matrix:");
        int[][] matrix3;
        if (matrix1 != null && matrix2 != null && matrix1.length == matrix2[0].length) {
            matrix3 = new int[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix2.length; k++) {
                        matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];
                    }
                    System.out.print(matrix3[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(delimiter);
            return matrix3;
        } else throw new WrongMultiplicationMatrixException();

    }

    public static int[][] sumOfMatrix(int[][] matrix1, int[][] matrix2) throws WrongSumMatrixException {
        System.out.println("Summary of matrix:");
        int[][] matrix3;
        if (matrix1 != null && matrix2 != null && matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            matrix3 = new int[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix3.length; i++) {
                for (int j = 0; j < matrix3[0].length; j++) {
                    matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
                    System.out.print(matrix3[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(delimiter);
            return matrix3;
        } else throw new WrongSumMatrixException();

    }


    public static int[][] transposeMatrix(int[][] matrix) {
        System.out.println("Transpose matrix:");
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        matrixToString(transposedMatrix);
        System.out.println();
        return transposedMatrix;
    }

    public static void matrixToString(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
        System.out.print(delimiter);
    }


}
