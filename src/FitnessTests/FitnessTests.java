package FitnessTests;

import MySparseMatrix.MySparseMatrix_DS2;

public class FitnessTests {
    
        public static void main(String[] args) {
            int size = 100;
            int band = 10;
            int density = 10;
    
            double[][] denseMatrixA = MatrixGenerator.DS2generateDenseMatrixA(size);
            double[][] bandMatrixA = MatrixGenerator.DS2generateBandMatrixA(size, band);
            double[][] sparseMatrixA = MatrixGenerator.DS2generateSparseMatrixA(size, density);
    
            double[] denseMatrixX = MatrixGenerator.generateMatrixX(size);
            double[] bandMatrixX = MatrixGenerator.generateMatrixX(size);
            double[] sparseMatrixX = MatrixGenerator.generateMatrixX(size);


            MySparseMatrix_DS2 denseMatrixSolver = new MySparseMatrix_DS2(denseMatrixA);
            MySparseMatrix_DS2 bandMatrixSolver = new MySparseMatrix_DS2(bandMatrixA);
            MySparseMatrix_DS2 sparseMatrixSolver = new MySparseMatrix_DS2(sparseMatrixA);

            double[] denseMatrixB = MatrixGenerator.multiplyMatrix(denseMatrixA, denseMatrixX);
            double[] bandMatrixB = MatrixGenerator.multiplyMatrix(bandMatrixA, bandMatrixX);
            double[] sparseMatrixB = MatrixGenerator.multiplyMatrix(sparseMatrixA, sparseMatrixX);

            // WITHOUT PIVOTING
            double[] denseMatrixSolved = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
            double[] bandMatrixSolved = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
            double[] sparseMatrixSolved = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);

            System.out.println("WITHOUT PIVOTING TESTS");
            System.out.println("Dense Matrix Accuracy: " + MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX));
            System.out.println("Band Matrix Accuracy: " + MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX));
            System.out.println("Sparse Matrix Accuracy: " + MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX));

            // WITH PIVOTING
            double[] denseMatrixPSolved = denseMatrixSolver.solveWithPivotA2(denseMatrixB);
            double[] bandMatrixPSolved = bandMatrixSolver.solveWithPivotA2(bandMatrixB);
            double[] sparseMatrixPSolved = sparseMatrixSolver.solveWithPivotA2(sparseMatrixB);

            System.out.println("PIVOTING TESTS");
            System.out.println("Dense Matrix Accuracy: " + MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX));
            System.out.println("Band Matrix Accuracy: " + MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX));
            System.out.println("Sparse Matrix Accuracy: " + MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX));




        }
}
