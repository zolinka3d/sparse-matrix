import java.util.ArrayList;

public class MySpaceMatrix {

    ArrayList<double[]> ds2;
    ArrayList<double[]> ds3;

    public MySpaceMatrix(double[][] normalMatrix) {
        this.ds2 = changeNormalMatrixToListOfRows(normalMatrix);
        this.ds3 = changeNormalMatrixToListOfColumns(normalMatrix);
    }


    private static ArrayList<double[]> changeNormalMatrixToListOfRows(double[][] normalMatrix) {
        ArrayList<double[]> listOfRows = new ArrayList<>();

        for (double[] matrix : normalMatrix) {
            for (int j = 0; j < normalMatrix[0].length; j++) {
                if (matrix[j] != 0) {
                    double[] element = {j, matrix[j]};
                    listOfRows.add(element);
                }
            }
        }
        return listOfRows;
    }

    private static ArrayList<double[]> changeNormalMatrixToListOfColumns(double[][] normalMatrix) {
        ArrayList<double[]> listOfRows = new ArrayList<>();

        for (int i = 0; i < normalMatrix.length; i++) {
            for (int j = 0; j < normalMatrix[i].length; j++) {
                if (normalMatrix[i][j] != 0) {
                    double[] element = {i, normalMatrix[i][j]};
                    listOfRows.add(element);
                }
            }
        }
        return listOfRows;
    }

}
