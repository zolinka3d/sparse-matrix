import java.util.ArrayList;

public class MySpaceMatrix {

    ArrayList<int[]> ds2;
    ArrayList<int[]> ds3;

    public MySpaceMatrix(int[][] normalMatrix) {
        this.ds2 = changeNormalMatrixToListOfRows(normalMatrix);
        this.ds3 = changeNormalMatrixToListOfColumns(normalMatrix);
    }


    private static ArrayList<int[]> changeNormalMatrixToListOfRows(int[][] normalMatrix) {
        ArrayList<int[]> listOfRows = new ArrayList<>();

        for (int[] matrix : normalMatrix) {
            for (int j = 0; j < normalMatrix[0].length; j++) {
                if (matrix[j] != 0) {
                    int[] element = {j, matrix[j]};
                    listOfRows.add(element);
                }
            }
        }
        return listOfRows;
    }

    private static ArrayList<int[]> changeNormalMatrixToListOfColumns(int[][] normalMatrix) {
        ArrayList<int[]> listOfRows = new ArrayList<>();

        for (int i = 0; i < normalMatrix.length; i++) {
            for (int j = 0; j < normalMatrix[i].length; j++) {
                if (normalMatrix[i][j] != 0) {
                    int[] element = {i, normalMatrix[i][j]};
                    listOfRows.add(element);
                }
            }
        }
        return listOfRows;
    }

}
