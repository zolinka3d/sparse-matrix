import java.util.ArrayList;

public class Ds2 implements Gauss {
    ArrayList<double[]>[] newMatrix;
    public Ds2(double[][] normalMatrix) {

        this.newMatrix = changeNormalMatrixToListOfRows(normalMatrix);
    }

    private static ArrayList<double[]>[] changeNormalMatrixToListOfRows(double[][] normalMatrix) {
        ArrayList<double[]>[] arrayLists = new ArrayList[normalMatrix.length];

        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
            for (int j = 0; j < normalMatrix[0].length; j ++) {
                if (normalMatrix[i][j] != 0) {
                    double[] element = {j, normalMatrix[i][j]};
                    arrayLists[i].add(element);
                }
            }
        }
        return arrayLists;
    }

    public void printNewMatrix(){
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j =0; j < newMatrix[i].size(); j++) {
                System.out.println("row: " + i + " col: " +  newMatrix[i].get(j)[0] + " val: " + newMatrix[i].get(j)[1] );
            }
        }
    }
    @Override
    public void a1() {

    }

    @Override
    public void a2() {

    }
}
