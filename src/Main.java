public class Main {
    public static void main(String[] args) {
        double[] row1 = {1,0};
        double[] row2 = {2,0};
        double[][] matrix = new double[2][2];
        matrix = new double[][]{row1, row2};
        Ds2 matrixDs2 = new Ds2(matrix);
        Ds3 matrixDs3 = new Ds3(matrix);
        matrixDs2.printNewMatrix();
        matrixDs3.printNewMatrix();
//        System.out.println(matrixDs2.getNewMatrix());

    }
}
