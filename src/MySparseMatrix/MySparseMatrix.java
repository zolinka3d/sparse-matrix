package MySparseMatrix;

import java.util.ArrayList;
import java.util.HashMap;

// "MySparseMatrix" represents a matrix over the field of real numbers.
public class MySparseMatrix {
    public MySparseMatrix(){
        System.out.println("matrix machine has been set up");
    }
    private ArrayList<ArrayList<Double>> sparsified_matrix_ds2;
    private ArrayList<HashMap<Integer, Double>> sparsified_matrix_ds3;


    public ArrayList<ArrayList<Double>> get_sparsified_matrix_ds2() {
        return sparsified_matrix_ds2;
    }

    /**
     * DS2 arrayList in which each element describes one row of a matrix,
     * where a matrix row is another Arraylist.
     */

    public void sparsify_ds2(ArrayList<ArrayList<Double>> matrix){
        matrix.forEach(row -> row.removeIf(element -> element == 0.0));
        set_sparsified_matrix(matrix);
    }

    /**
     * DS3 arrayList in which each element describes one column of a matrix,
     * where a matrix column is a HashMap (dictionary).
     */

    public void sparsify_ds3(ArrayList<HashMap<Integer, Double>> matrix){
        matrix.forEach(row -> row.entrySet().removeIf(entry -> entry.getValue() == 0.0));
        set_sparsified_matrix_ds3(matrix);
    }

    private void set_sparsified_matrix_ds3(ArrayList<HashMap<Integer, Double>> sparsified_matrix) {
        this.sparsified_matrix_ds3 = sparsified_matrix;
    }

    private void set_sparsified_matrix(ArrayList<ArrayList<Double>> sparsified_matrix) {
        this.sparsified_matrix_ds2 = sparsified_matrix;
    }

    public ArrayList<HashMap<Integer, Double>> get_sparsified_matrix_ds3() {
        return sparsified_matrix_ds3;
    }
}
