package FitnessTests;

import MySparseMatrix.MySparseMatrix_DS2;
import MySparseMatrix.MySparseMatrix_DS3;

public class FitnessTests {
    
        public static void main(String[] args) {
            int size = 10;
            int band = 3;
            int density = 40;

            double[][] denseMatrixA = MatrixGenerator.DS2generateDenseMatrixA(size);
            double[][] bandMatrixA = MatrixGenerator.DS2generateBandMatrixA(size, band);
            double[][] sparseMatrixA = MatrixGenerator.DS2generateSparseMatrixA(size, density);

            double[] denseMatrixX = MatrixGenerator.generateMatrixX(size);
            double[] bandMatrixX = MatrixGenerator.generateMatrixX(size);
            double[] sparseMatrixX = MatrixGenerator.generateMatrixX(size);

            // PRINT THOSE MATRICES
            System.out.println("===== DENSE MATRIX =====");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(denseMatrixA[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("===== BAND =====");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(bandMatrixA[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("===== SPARSE =====");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(sparseMatrixA[i][j] + " ");
                }
                System.out.println();
            }


            double[] denseMatrixB = MatrixGenerator.multiplyMatrix(denseMatrixA, denseMatrixX);
            double[] bandMatrixB = MatrixGenerator.multiplyMatrix(bandMatrixA, bandMatrixX);
            double[] sparseMatrixB = MatrixGenerator.multiplyMatrix(sparseMatrixA, sparseMatrixX);


              System.out.println("\n\n===== DS2 =====");
            {
                MySparseMatrix_DS2 denseMatrixSolver = new MySparseMatrix_DS2(denseMatrixA);
                MySparseMatrix_DS2 bandMatrixSolver = new MySparseMatrix_DS2(bandMatrixA);
                MySparseMatrix_DS2 sparseMatrixSolver = new MySparseMatrix_DS2(sparseMatrixA);

                // WITHOUT PIVOTING
                double[] denseMatrixSolved = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
                double[] bandMatrixSolved = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
                double[] sparseMatrixSolved = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);

                System.out.println("\n===== WITHOUT PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX));
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX));
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX));

                // WITH PIVOTING
                double[] denseMatrixPSolved = denseMatrixSolver.solveWithPivotA2(denseMatrixB);
                double[] bandMatrixPSolved = bandMatrixSolver.solveWithPivotA2(bandMatrixB);
                double[] sparseMatrixPSolved = sparseMatrixSolver.solveWithPivotA2(sparseMatrixB);

                System.out.println("\n===== PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX));
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX));
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX));
            }

                System.out.println("\n\n===== DS3 =====");
            {
                MySparseMatrix_DS3 denseMatrixSolver = new MySparseMatrix_DS3(denseMatrixA);
                MySparseMatrix_DS3 bandMatrixSolver = new MySparseMatrix_DS3(bandMatrixA);
                MySparseMatrix_DS3 sparseMatrixSolver = new MySparseMatrix_DS3(sparseMatrixA);

                // WITHOUT PIVOTING
                double[] denseMatrixSolved = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
                double[] bandMatrixSolved = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
                double[] sparseMatrixSolved = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);

                System.out.println("\n===== WITHOUT PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX));
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX));
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX));

                // WITH PIVOTING
                double[] denseMatrixPSolved = denseMatrixSolver.solveWithPivotA2(denseMatrixB);
                double[] bandMatrixPSolved = bandMatrixSolver.solveWithPivotA2(bandMatrixB);
                double[] sparseMatrixPSolved = sparseMatrixSolver.solveWithPivotA2(sparseMatrixB);

                System.out.println("\n===== PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX));
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX));
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX));



            }



        }
}
