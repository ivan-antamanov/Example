package main;

/**
 * Created by iantaman on 17.10.2015.
 */
public class Matrix {
    int[][] matrix1;
    int[][] matrix2;
    int[][] matrix3;
    //matrix3 = matrix1*/+ matrix2
    private static final String delimiter = "*****";

    int[][] createMatrix(int rowNumbers, int column) {
        System.out.println("New matrix");
        int[][] matrix = new int[rowNumbers][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) ((Math.random() * 10));
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println(delimiter);
        return matrix;
    }

    public void multiplicationMatrix(int[][] matrix1, int[][] matrix2) {

        System.out.println("Multiplication matrix");
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
        } else {
            System.out.println("Matrix must be defined!\n" +
                    "Row numbers of first matrix have to equally column numbers of second matrix");
            System.out.println(delimiter);
        }


    }


    public void summaryOfMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("Summary of matrix");

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
        } else {
            System.out.println("Matrix must be defined!\n" +
                    "Size of first matrix have to equally size of second matrix");
            System.out.println(delimiter);
        }

    }


    public int[][] transposeMatrix(int[][] matrix) {
        System.out.println("Transpose matrix");
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];

            }
        }
        arrayToString(transposedMatrix);
        System.out.println();
        System.out.println(delimiter);
        return transposedMatrix;
    }

    public void arrayToString(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
        System.out.println(delimiter);
    }

    public static void main(String[] args) {
        Matrix arrays = new Matrix();

        arrays.matrix1 = arrays.createMatrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        arrays.matrix2 = arrays.createMatrix(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
        arrays.multiplicationMatrix(arrays.matrix1, arrays.matrix2);
        arrays.summaryOfMatrix(arrays.matrix1, arrays.matrix2);
        arrays.transposeMatrix(arrays.matrix1);
    }

}
