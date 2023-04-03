public class Main {
    public static void main(String[] args) {
        double[] row1 = {1,0};
        double[] row2 = {2,0};
        double[][] matrix = new double[2][2];
        matrix = new double[][]{row1, row2};
        MySparseMatrix matrices = new MySparseMatrix(matrix);
        matrices.printMatrixD2();
        matrices.printMatrixD3();
    }
}
