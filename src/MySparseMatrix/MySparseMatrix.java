package MySparseMatrix;

import java.util.ArrayList;

// "MySparseMatrix" represents a matrix over the field of real numbers.
public class MySparseMatrix {
    public MySparseMatrix(){
        System.out.println("matrix machine has been set up");
    }
    private ArrayList<ArrayList<Double>> sparsified_matrix;

    private void set_sparsified_matrix(ArrayList<ArrayList<Double>> sparsified_matrix) {
        this.sparsified_matrix = sparsified_matrix;
    }

    public ArrayList<ArrayList<Double>> get_sparsified_matrix() {
        return sparsified_matrix;
    }

    /**
     * DS2 arrayList in which each element describes one row of a matrix,
     * where a matrix row can be another list or a dictionary.
     */
    //

    public void sparsify_ds2(ArrayList<ArrayList<Double>> matrix){
        matrix.forEach(row -> row.removeIf(element -> element == 0.0));
        set_sparsified_matrix(matrix);
    }

    public void sparsify_ds3(ArrayList<ArrayList<Number>> matrix){
        // TODO
    }

}
