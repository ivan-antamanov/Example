package main.MatrixExceptions;

/**
 * Created by iantaman on 20.10.2015.
 */
public class WrongMultiplicationMatrixException extends Exception {

    public WrongMultiplicationMatrixException() {
        System.out.println("Matrix must be defined!\n" +
                "Row numbers of first matrix have to equally column numbers of second matrix");
    }
}
