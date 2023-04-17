import java.util.HashMap;

public class Ds3 implements Gauss {

    HashMap<Integer, Double>[] newMatrix;

    public Ds3(double[][] normalMatrix) {
        this.newMatrix = changeNormalMatrixToListOfColumns(normalMatrix);
    }

    private HashMap<Integer, Double>[] changeNormalMatrixToListOfColumns(double[][] normalMatrix) {
        HashMap<Integer, Double>[] matrixArrayOfHashmaps = new HashMap[normalMatrix.length];

        for (int row = 0; row < matrixArrayOfHashmaps.length; row++) {
            matrixArrayOfHashmaps[row] = new HashMap<>();
            for (int column = 0; column < normalMatrix[row].length; column++) {
                if(normalMatrix[column][row] != 0) {
                    matrixArrayOfHashmaps[row].put(column, normalMatrix[column][row]);
                }
            }
        }

        return matrixArrayOfHashmaps;
    }

    public void printNewMatrix(){
        for (int i = 0; i < newMatrix.length; i++) {
            for (Object key : newMatrix[i].keySet()) {
                System.out.println("column " + i + " row: " + key + " value: " + newMatrix[i].get(key));
            }
        }
    }

    public void a1() {

    }
    public void a2() {

    }
}
