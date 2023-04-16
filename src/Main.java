import MySparseMatrix.MySparseMatrix;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<Double>> matrix = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(1.0); add(1.0); add(0.0); }});
            add(new ArrayList<>() {{ add(2.0); add(0.0); add(0.0); }});
            add(new ArrayList<>() {{ add(0.0); add(3.0); add(3.0); }});
        }};

        MySparseMatrix matrix_ds2 = new MySparseMatrix();

        matrix_ds2.sparsify_ds2(matrix);
        System.out.println(matrix_ds2.get_sparsified_matrix());




    }
}
