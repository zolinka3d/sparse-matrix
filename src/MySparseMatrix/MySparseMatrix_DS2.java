package MySparseMatrix;

import java.util.ArrayList;

public class MySparseMatrix_DS2 {
    public ArrayList<double[]>[] newMatrix;

    public MySparseMatrix_DS2(double[][] normalMatrix) {

        this.newMatrix = changeNormalMatrixToListOfRows(normalMatrix);
    }

    private ArrayList<double[]>[] changeNormalMatrixToListOfRows(double[][] normalMatrix) {
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
            for (int j = 0; j < newMatrix[i].size(); j++) {
                System.out.println("row: " + i + " col: " +  newMatrix[i].get(j)[0] + " val: " + newMatrix[i].get(j)[1] );
            }
        }
    }

    public double[] solveWithPivotA2(double[] BOriginal) {
        double[] B = BOriginal.clone();
        int N = B.length;
        double[] x = new double[N];

        ArrayList<double[]>[] A = deepCopyMatrix(newMatrix);
        for (int k = 0; k < N; k++) {
            // find pivot row, maximum in current column //
            double maxElement = 0;
            int maxRow = -1;
            for (int n = k; n < N; n++) {
                double value = getValue(A[n], k);
                if (Math.abs(value) > Math.abs(maxElement)) {
                    maxElement = value;
                    maxRow = n;
                }
            }

            if (maxRow == -1 || maxElement == 0) {
                throw new RuntimeException("Macierz jest osobliwa");
            }
//            System.out.println("maxElement: " + maxElement + " for column " + k + " maxRow: " + maxRow);

            // swap row in A matrix
            if (maxRow != k) {
                ArrayList<double[]> tmpRow = A[maxRow];
                A[maxRow] = A[k];
                A[k] = tmpRow;
                // swap corresponding values in constants matrix
                double tmpB = B[maxRow];
                B[maxRow] = B[k];
                B[k] = tmpB;
            }
            // pivot within A and B // elimination column below diagonal
            for (int i = k + 1; i < N; i++) {
                double factor = getValue(A[i], k) / maxElement;
                for (double[] entry : A[k]) {
                    int columnIndex = (int) entry[0];
                    double value = entry[1] * factor;
                    addToRow(A[i], columnIndex, -value);
                }
                B[i] -= B[k] * factor;
            }
        }
        // back substitution // Wyznaczenie rozwiązania przez podstawienie wsteczne
        for (int i = N -1; i >=0; i-- ) {
            double sum = 0;
            for (double[] entry : A[i]) {
                int columnIndex = (int) entry[0];
                if( columnIndex > i ) {
                    sum += entry[1] * x[columnIndex];
                }
            }
            x[i] = (B[i] - sum) / getValue(A[i], i);
        }
        return x;

    }
    public double[] solveWithoutPivotA1(double[] BOriginal) {
        double[] B = BOriginal.clone();
        int N = B.length;
        double[] x = new double[N];

        ArrayList<double[]>[] A = deepCopyMatrix(newMatrix);

        for (int k = 0; k < N; k++) {

            double pivot = getValue(A[k], k);
            if (pivot == 0) {
                // find a non-zero pivot in the same column
                int newRow = -1;
                for (int i = k + 1; i < N; i++) {
                    if (getValue(A[i], k) != 0) {
                        newRow = i;
                        break;
                    }
                }

                if (newRow == -1) {
                    throw new RuntimeException("Macierz jest osobliwa");
                }

                // swap row in A matrix
                ArrayList<double[]> tmpRow = A[newRow];
                A[newRow] = A[k];
                A[k] = tmpRow;
                // swap corresponding values in constants matrix
                double tmpB = B[newRow];
                B[newRow] = B[k];
                B[k] = tmpB;

                // Update the pivot variable after swapping
                pivot = getValue(A[k], k);
            }

            // pivot within A and B // elimination column below diagonal
            for (int i = k + 1; i < N; i++) {
                double factor = getValue(A[i], k) / pivot;
                for (double[] entry : A[k]) {
                    int columnIndex = (int) entry[0];
                    double value = entry[1] * factor;
                    addToRow(A[i], columnIndex, -value);
                }
                B[i] -= B[k] * factor;
            }
        }

        // back substitution // Wyznaczenie rozwiązania przez podstawienie wsteczne
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0;
            for (double[] entry : A[i]) {
                int columnIndex = (int) entry[0];
                if (columnIndex > i) {
                    sum += entry[1] * x[columnIndex];
                }
            }
            x[i] = (B[i] - sum) / getValue(A[i], i);
        }
        return x;
    }



    private static double getValue(ArrayList<double[]> row, int columnIndex) {
        for (double[] entry : row) {
            if ((int) entry[0] == columnIndex) {
                return entry[1];
            }
        }
        return 0;
    }

    public void addToRow(ArrayList<double[]> row, int columnIndex, double value) {
        boolean found = false;
        for (double[] entry : row) {
            if ((int) entry[0] == columnIndex) {
                entry[1] += value;
                found = true;
                if (entry[1] == 0) {
                    row.remove(entry);
                }
                break;
            }
        }
        // If the column index is not found and the value is not zero, add a new entry to the row
        if (!found && value != 0) {
            row.add(new double[]{columnIndex, value});
        }
    }

    private ArrayList<double[]>[] deepCopyMatrix(ArrayList<double[]>[] originalMatrix) {
        ArrayList<double[]>[] copiedMatrix = new ArrayList[originalMatrix.length];
        for (int i = 0; i < originalMatrix.length; i++) {
            copiedMatrix[i] = new ArrayList<>();
            for (double[] entry : originalMatrix[i]) {
                copiedMatrix[i].add(new double[]{entry[0], entry[1]});
            }
        }
        return copiedMatrix;
    }



}
