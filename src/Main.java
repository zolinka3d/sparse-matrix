import MySparseMatrix.MySparseMatrix_DS2;
import MySparseMatrix.MySparseMatrix_DS3;

public class Main {
    public static void main(String[] args) {
        double[] row1 = {1,0};
        double[] row2 = {2,0};
        double[][] matrix = new double[2][2];
        matrix = new double[][]{row1, row2};
        var matrixDs2 = new MySparseMatrix_DS2(matrix);
        var matrixDs3 = new MySparseMatrix_DS3(matrix);
        matrixDs2.printNewMatrix();
        matrixDs3.printNewMatrix();
//        System.out.println(matrixDs2.getNewMatrix());

    }
}
