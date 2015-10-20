package main;

import main.MatrixExceptions.WrongMultiplicationMatrixException;
import main.MatrixExceptions.WrongSumMatrixException;

/**
 * Created by iantaman on 19.10.2015.
 */
public class MatrixTest {
    private static int[][] matrix1;
    private static int[][] matrix2;
    private static int[][] matrix3; //matrix3 = matrix1 * matrix2
    private static int[][] matrix4; //matrix4 = matrix1 + matrix2


    public static void main(String[] args) {

        matrix1 = MatrixUtility.createMatrix(5, 8);
        matrix2 = MatrixUtility.createMatrix(3, 5);
        try {
            matrix3 = MatrixUtility.multiplicationMatrix(matrix1, matrix2);
            MatrixUtility.transposeMatrix(matrix3);
            matrix2 = MatrixUtility.createMatrix(5, 8);
            matrix4 = MatrixUtility.sumOfMatrix(matrix1, matrix2);
        } catch (WrongMultiplicationMatrixException | WrongSumMatrixException ex1) {
            ex1.printStackTrace();
        }
    }
}