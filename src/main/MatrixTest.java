package main;

import main.MatrixExceptions.WrongMultiplicationMatrixException;
import main.MatrixExceptions.WrongSumMatrixException;

/**
 * Created by iantaman on 19.10.2015.
 */
public class MatrixTest {
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] matrix3; //matrix3 = matrix1 * matrix2
    private int[][] matrix4; //matrix4 = matrix1 + matrix2


    public static void main(String[] args) {
        MatrixTest matrixTest = new MatrixTest();

        matrixTest.matrix1 = MatrixUtility.createMatrix(5, 8);
        matrixTest.matrix2 = MatrixUtility.createMatrix(3, 5);
        try {
            matrixTest.matrix3 = MatrixUtility.multiplicationMatrix(matrixTest.matrix1, matrixTest.matrix2);
            MatrixUtility.transposeMatrix(matrixTest.matrix3);
            matrixTest.matrix4 = MatrixUtility.sumOfMatrix(matrixTest.matrix1, matrixTest.matrix2);
        } catch (WrongMultiplicationMatrixException | WrongSumMatrixException ex1) {
            ex1.printStackTrace();
        }
    }
}