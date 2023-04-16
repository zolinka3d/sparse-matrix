import MySparseMatrix.MySparseMatrix;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<Double>> matrix1 = new ArrayList<>() {{
            add(new ArrayList<>() {{ add(1.0); add(1.0); add(0.0); }});
            add(new ArrayList<>() {{ add(2.0); add(0.0); add(0.0); }});
            add(new ArrayList<>() {{ add(0.0); add(3.0); add(3.0); }});
        }};

        ArrayList<HashMap<Integer, Double>> matrix2 = new ArrayList<>() {{
            add(new HashMap<>(){{
                put(0, 1.0);
                put(1, 1.0);
                put(2, 0.0);
            }});
            add(new HashMap<>(){{
                put(0, 2.0);
                put(1, 0.0);
                put(2, 0.0);
            }});
            add(new HashMap<>(){{
                put(0, 0.0);
                put(1, 3.0);
                put(2, 3.0);
            }});

        }};


        MySparseMatrix matrix_machine = new MySparseMatrix();

        matrix_machine.sparsify_ds2(matrix1);
        System.out.println(matrix_machine.get_sparsified_matrix_ds2());

        matrix_machine.sparsify_ds3(matrix2);
        System.out.println(matrix_machine.get_sparsified_matrix_ds3());




    }
}
