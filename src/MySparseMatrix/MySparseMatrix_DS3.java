package MySparseMatrix;

import java.util.HashMap;

public class MySparseMatrix_DS3 {

    HashMap<Integer, Double>[] newMatrix;

    public MySparseMatrix_DS3(double[][] normalMatrix) {
        this.newMatrix = changeNormalMatrixToListOfColumns(normalMatrix);
    }

    private HashMap<Integer, Double>[] changeNormalMatrixToListOfColumns(double[][] normalMatrix) {
        int rowCount = normalMatrix.length;
        int colCount = normalMatrix[0].length;

        HashMap<Integer, Double>[] matrixArrayOfHashmaps = new HashMap[colCount];

        for (int column = 0; column < normalMatrix[0].length; column++) {
            matrixArrayOfHashmaps[column] = new HashMap<>();
            for (int row = 0; row < normalMatrix.length; row++) {
                if (normalMatrix[row][column] != 0) {
                    matrixArrayOfHashmaps[column].put(row, normalMatrix[row][column]);
                }
            }
        }
        return matrixArrayOfHashmaps;
    }

    public void printNewMatrix() {
        for (int col = 0; col < newMatrix.length; col++) {
            for (Integer row : newMatrix[col].keySet()) {
                System.out.println("column: " + col + " row: " + row + " value: " + newMatrix[col].get(row));
            }
        }
    }

    public double[] solveWithoutPivotA1(double[] BOriginal) {
        double[] B = BOriginal.clone();
        int N = B.length;
        double[] x = new double[N];
        HashMap<Integer, Double>[] A = deepCopyMatrix(newMatrix);

        // Forward elimination
        for (int k = 0; k < N - 1; k++) {
            // Check if the pivot element is 0 and swap rows if necessary
            if (getValue(A, k, k) == 0) {
                for (int row = k + 1; row < N; row++) {
                    if (getValue(A, row, k) != 0) {
                        swapRowsInColumnHashMap(A, k, row);
                        double tmpB = B[k];
                        B[k] = B[row];
                        B[row] = tmpB;
                        break;
                    }
                }
            }

            for (int i = k + 1; i < N; i++) {
                double factor = getValue(A, i, k) / getValue(A, k, k);
                for (int j = k; j < N; j++) {
                    double value = getValue(A, k, j) * factor;
                    addToColumnHashMap(A[j], i, -value);
                }
                B[i] -= B[k] * factor;
            }
        }

        // Back substitution
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < N; j++) {
                sum += getValue(A, i, j) * x[j];
            }
            x[i] = (B[i] - sum) / getValue(A, i, i);
        }

        return x;
    }

    public double[] solveWithPivotA2(double[] BOriginal) {
        double[] B = BOriginal.clone();
        int N = B.length;
        double[] x = new double[N];

        HashMap<Integer, Double>[] A = deepCopyMatrix(newMatrix);


        for (int k = 0; k < N; k++) {
            // find pivot row, maximum in current column //
            double maxElement = 0;
            int maxRow = -1;
            for (int n = k; n < N; n++) {
                double value = getValue(A, n, k);
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
                swapRowsInColumnHashMap(A, maxRow, k);
                // swap corresponding values in constants matrix
                double tmpB = B[maxRow];
                B[maxRow] = B[k];
                B[k] = tmpB;
            }
            // pivot within A and B // elimination column below diagonal
            for (int i = k + 1; i < N; i++) {
                double factor = getValue(A, i, k) / maxElement;
                for (int columnIndex = k; columnIndex < N; columnIndex++) {
                    double value = getValue(A, k, columnIndex) * factor;
                    addToColumnHashMap(A[columnIndex], i, -value);
                }
                B[i] -= B[k] * factor;
            }
        }
        // back substitution // Wyznaczenie rozwiązania przez podstawienie wsteczne
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0;
            for (int columnIndex = i + 1; columnIndex < N; columnIndex++) {
                sum += getValue(A, i, columnIndex) * x[columnIndex];
            }
            x[i] = (B[i] - sum) / getValue(A, i, i);
        }
        return x;
    }

    private double getValue(HashMap<Integer, Double>[] A, int row, int column) {
        return A[column].getOrDefault(row, 0.0);
    }

    private static void addToColumnHashMap(HashMap<Integer, Double> column, int rowIndex, double value) {
        if (value == 0) {
            return;
        }

        double currentValue = column.getOrDefault(rowIndex, 0.0);
        double newValue = currentValue + value;

        if (newValue == 0) {
            column.remove(rowIndex);
        } else {
            column.put(rowIndex, newValue);
        }
    }

    private void swapRowsInColumnHashMap(HashMap<Integer, Double>[] A, int row1, int row2) {
        for (int column = 0; column < A.length; column++) {
            HashMap<Integer, Double> currentColumn = A[column];
            double temp = currentColumn.getOrDefault(row1, 0.0);
            if (currentColumn.containsKey(row2)) {
                currentColumn.put(row1, currentColumn.get(row2));
            } else {
                currentColumn.remove(row1);
            }
            if (temp != 0) {
                currentColumn.put(row2, temp);
            } else {
                currentColumn.remove(row2);
            }
        }
    }
    private HashMap<Integer, Double>[] deepCopyMatrix(HashMap<Integer, Double>[] originalMatrix) {
        HashMap<Integer, Double>[] copiedMatrix = new HashMap[originalMatrix.length];
        for (int i = 0; i < originalMatrix.length; i++) {
            copiedMatrix[i] = new HashMap<>(originalMatrix[i]);
        }
        return copiedMatrix;
    }

}
