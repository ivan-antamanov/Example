package main.MatrixExceptions;

/**
 * Created by iantaman on 20.10.2015.
 */
public class WrongSumMatrixException extends Exception {
    public WrongSumMatrixException() {
        System.out.println("Matrix must be defined!\n" +
                "Size of first matrix have to equally size of second matrix");
    }
}
