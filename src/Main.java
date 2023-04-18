import MySparseMatrix.MySparseMatrix_DS2;
import MySparseMatrix.MySparseMatrix_DS3;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n====> Set up matrix A v1 \n");
        double[][] matrix = {
                {2,0,0},
                {0,1,0},
                {0,0,10}
        };
        printMatrix(matrix);


        System.out.println("\n====> Matrix ds2 \n");
        var matrixDs2 = new MySparseMatrix_DS2(matrix);
        matrixDs2.printNewMatrix();


        System.out.println("\n====> Matrix ds3 \n");
        var matrixDs3 = new MySparseMatrix_DS3(matrix);
        matrixDs3.printNewMatrix();

        System.out.println("\n====> Set up B matrix (vector) \n");
        double[] B = {1,1,1};
        for (double v : B) {
            System.out.println("====> " + v);
        }
        double[] solvedDS2p = matrixDs2.solveWithPivotA2(B);
        double[] solvedDS2 = matrixDs2.solveWithoutPivotA1(B);
        double[] solvedDS3p = matrixDs3.solveWithPivotA2(B);
        double[] solvedDS3 = matrixDs3.solveWithoutPivotA1(B);

        System.out.println("\n====> Solved DS2 without pivot \n");
        for (double v : solvedDS2) {
            System.out.println("====> " + v);
        }

        System.out.println("\n====> Solved DS2 with pivot \n");
        for (double v : solvedDS2p) {
            System.out.println("====> " + v);
        }

        System.out.println("\n====> Solved DS3 without pivot \n");
        for (double v : solvedDS3) {
            System.out.println("====> " + v);
        }

        System.out.println("\n====> Solved DS3 with pivot \n");
        for (double v : solvedDS3p) {
            System.out.println("====> " + v);
        }


        System.out.println("\n====> Set up matrix A v2 \n");
        double[][] matrix2 = {
                {0,1,1},
                {2,4,-2},
                {0,3,15}
        };
        printMatrix(matrix2);

        System.out.println("\n====> Matrix2 ds2 \n");
        var matrixDS2v2 = new MySparseMatrix_DS2(matrix2);
        matrixDS2v2.printNewMatrix();

        System.out.println("\n====> Matrix2 ds3 \n");
        var matrixDs3v2 = new MySparseMatrix_DS3(matrix2);
        matrixDs3v2.printNewMatrix();

        System.out.println("\n====> Set up B matrix2(vector) \n");
        double[] B2 = {4,2,36};
        for (double v : B2) {
            System.out.println("====> " + v);
        }
        double[] solvedDS2v2p = matrixDS2v2.solveWithPivotA2(B2);
        double[] solvedDS2v2 = matrixDS2v2.solveWithoutPivotA1(B2);
        double[] solvedDS3v2p = matrixDs3v2.solveWithPivotA2(B2);
        double[] solvedDS3v2 = matrixDs3v2.solveWithoutPivotA1(B2);

        System.out.println("\n====> Solved DS2v2 without pivot \n");
        for (double v : solvedDS2v2) {
            System.out.println(v);
        }

        System.out.println("\n====> Solved DS2v2 with pivot \n");
        for (double v : solvedDS2v2p) {
            System.out.println(v);
        }

        System.out.println("\n====> Solved DS3v2 without pivot \n");
        for (double v : solvedDS3v2) {
            System.out.println(v);
        }

        System.out.println("\n====> Solved DS3v2 with pivot \n");
        for (double v : solvedDS3v2p) {
            System.out.println(v);
        }

    }
    private static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }
}
