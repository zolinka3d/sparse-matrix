import java.util.ArrayList;
import java.util.HashMap;

public class MySparseMatrix {

    ArrayList<double[]>[] ds2;
    HashMap<Integer, Double>[] ds3;

    public MySparseMatrix(double[][] normalMatrix) {
        this.ds2 = changeNormalMatrixToListOfRows(normalMatrix);
        this.ds3 = changeNormalMatrixToListOfColumns(normalMatrix);
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

    private static HashMap<Integer, Double>[] changeNormalMatrixToListOfColumns(double[][] normalMatrix) {
        HashMap<Integer, Double>[] hashMapArray = new HashMap[normalMatrix.length];

        for (int i = 0; i < hashMapArray.length; i++) {
            hashMapArray[i] = new HashMap<>();
            for (int j = 0; j < normalMatrix[i].length; j++) {
                if(normalMatrix[j][i] != 0) {
                    hashMapArray[i].put(j, normalMatrix[j][i]);
                }
            }
        }

        return hashMapArray;
    }

    public void printMatrixD2(){
        for (int i = 0; i < ds2.length; i++) {
            for (int j =0; j < ds2[i].size(); j++) {
                System.out.println("wiersz: " + i + " kolumna: " +  ds2[i].get(j)[0] + " wartość:  " + ds2[i].get(j)[1] );
            }
        }
    }

    public void printMatrixD3(){
        for (int i = 0; i < ds3.length; i++) {
            for (int j = 0; j < ds3[i].size(); j++) {
                System.out.println("kolumna: " + i + " wiersz: " +  j + " wartość:  " + ds3[i].get(j));
            }
        }
    }
}
