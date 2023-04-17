import MySparseMatrix.MySparseMatrix_DS2;
import MySparseMatrix.MySparseMatrix_DS3;

public class Main {
    public static void main(String[] args) {
        double[] row1 = {2,0,0};
        double[] row2 = {0,1,0};
        double[] row3 = {0,0,10};
        double[][] matrix;
        matrix = new double[][]{row1, row2, row3};
        var matrixDs2 = new MySparseMatrix_DS2(matrix);
        var matrixDs3 = new MySparseMatrix_DS3(matrix);
        matrixDs2.printNewMatrix();
        matrixDs3.printNewMatrix();

        double[] B = {1,1,1};
//        double[] x = matrixDs2.solveWithPivotA2(B);
//        double[] y = matrixDs2.solveWithoutPivotA1(B);
//
        double[][] matrix2 = {
                { 0, 1,  1 },
                { 2, 4, -2 },
                { 0, 3, 15 }
        };
        double[] B2 = {4,2,36};
//        var matrixDs2v2 = new MySparseMatrix_DS2(matrix2);
        var matrixDs3v2 = new MySparseMatrix_DS3(matrix2);
////        double[] y2 = matrixDs2v2.solveWithoutPivotA1(B2);
////        double[] x2 = matrixDs2v2.solveWithPivotA2(B2);
        double[] y2 = matrixDs3v2.solveWithPivotA2(B2);
        double[] x2 = matrixDs3v2.solveWithoutPivotA1(B2);
//
//        double[] x22 = matrixDs3v2.solveWithPivotA2(B2);
//        double[] y22 = matrixDs3v2.solveWithoutPivotA1(B2);
        for (int i = 0 ; i < y2.length; i++) {
            System.out.println(y2[i]);
        }

        for (int i = 0 ; i < x2.length; i++) {
            System.out.println(x2[i]);
        }
    }
}
