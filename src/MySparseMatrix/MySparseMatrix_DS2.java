package MySparseMatrix;

import java.util.ArrayList;

public class MySparseMatrix_DS2 {
    public ArrayList<double[]>[] newMatrix;

    public MySparseMatrix_DS2(double[][] normalMatrix) {

        this.newMatrix = changeNormalMatrixToListOfRows(normalMatrix);
    }

    public void printNewMatrix(){
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].size(); j++) {
                System.out.println("row: " + i + " col: " +  (int)newMatrix[i].get(j)[0] + " val: " + newMatrix[i].get(j)[1] );
            }
        }
    }

    public double[] solveWithPivotA2(double[] B) {
        int BLength = B.length;
        double[] x = new double[BLength];

        ArrayList<double[]>[] A = newMatrix;
        for (int k = 0; k < BLength; k++) {
            // find pivot row, maximum in current column //
            double maxElement = 0;
            int maxRow = -1;
            for (int n = k; n < BLength; n++) {
                double value = getValue(A[n], k);
                if (Math.abs(value) > Math.abs(maxElement)) {
                    maxElement = value;
                    maxRow = n;
                }
            }

            if (maxRow == -1 || maxElement == 0) {
                throw new RuntimeException("Macierz jest osobliwa");
            }
            System.out.println("maxElement: " + maxElement + " for column " + k + " maxRow: " + maxRow);

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
            eliminationColumnBelowDiagonal(B, BLength, A, k, maxElement);
        }
        // back substitution // Wyznaczenie rozwiązania przez podstawienie wsteczne
        return backSubstitution(B, BLength, x, A);
    }

    private double[] backSubstitution(double[] B, int BLength, double[] x, ArrayList<double[]>[] a) {
        for (int i = BLength -1; i >=0; i-- ) {
            double sum = 0;
            for (double[] entry : a[i]) {
                int columnIndex = (int) entry[0];
                if( columnIndex > i ) {
                    sum += entry[1] * x[columnIndex];
                }
            }
            x[i] = (B[i] - sum) / getValue(a[i], i);
        }
        return x;
    }

    private void eliminationColumnBelowDiagonal(double[] B, int BLength, ArrayList<double[]>[] a, int k, double maxElement) {
        for (int i = k + 1; i < BLength; i++) {
            double factor = getValue(a[i], k) / maxElement;
            for (double[] entry : a[k]) {
                int columnIndex = (int) entry[0];
                double value = entry[1] * factor;
                addToRow(a[i], columnIndex, -value);
            }
            B[i] -= B[k] * factor;
        }
    }

    public double[] solveWithoutPivotA1(double[] B) {
        int BLength = B.length;
        double[] x = new double[BLength];

        ArrayList<double[]>[] A = newMatrix;
        for (int k = 0; k < BLength; k++) {

            double pivot = getValue(A[k], k);
            if (pivot == 0) {
                // find a non-zero pivot in the same column
                int newRow = -1;
                for (int i = k + 1; i < BLength; i++) {
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

                pivot = getValue(A[k], k);
            }

            // pivot within A and B // elimination column below diagonal
            eliminationColumnBelowDiagonal(B, BLength, A, k, pivot);
        }

        // back substitution // Wyznaczenie rozwiązania przez podstawienie wsteczne
        return backSubstitution(B, BLength, x, A);
    }

    private static double getValue(ArrayList<double[]> row, int columnIndex) {
        for (double[] entry : row) {
            if ((int) entry[0] == columnIndex) {
                return entry[1];
            }
        }
        return 0;
    }
    private static void addToRow(ArrayList<double[]> row, int columnIndex, double value) {
        if (value == 0) {
            return;
        }

        for (double[] entry : row) {
            if ((int) entry[0] == columnIndex) {
                entry[1] += value;
                if (entry[1] == 0) {
                    row.remove(entry);
                }
                return;
            }
        }
        row.add(new double[]{columnIndex, value});
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
}
