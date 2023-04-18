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
    
            double[] denseMatrixB = MatrixGenerator.generateMatrixB(size);
            double[] bandMatrixB = MatrixGenerator.generateMatrixB(size);
            double[] sparseMatrixB = MatrixGenerator.generateMatrixB(size);

            MySparseMatrix_DS2 denseMatrixSolver = new MySparseMatrix_DS2(denseMatrixA);
            MySparseMatrix_DS2 bandMatrixSolver = new MySparseMatrix_DS2(bandMatrixA);
            MySparseMatrix_DS2 sparseMatrixSolver = new MySparseMatrix_DS2(sparseMatrixA);
    
            // WITHOUT PIVOTING
            double[] denseMatrixX = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
            double[] bandMatrixX = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
            double[] sparseMatrixX = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);

            double[] denseMatrixAX = MatrixGenerator.multiplyMatrix(denseMatrixA, denseMatrixX);
            double[] bandMatrixAX = MatrixGenerator.multiplyMatrix(bandMatrixA, bandMatrixX);
            double[] sparseMatrixAX = MatrixGenerator.multiplyMatrix(sparseMatrixA, sparseMatrixX);

//            System.out.println("Dense Matrix Accuracy: " + MatrixGenerator.getAccuracy(denseMatrixAX, denseMatrixB));
//            System.out.println("Band Matrix Accuracy: " + MatrixGenerator.getAccuracy(bandMatrixAX, bandMatrixB));
//            System.out.println("Sparse Matrix Accuracy: " + MatrixGenerator.getAccuracy(sparseMatrixAX, sparseMatrixB));
        }
}
