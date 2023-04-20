package FitnessTests;

import MySparseMatrix.MySparseMatrix_DS2;
import MySparseMatrix.MySparseMatrix_DS3;
import org.apache.commons.math3.linear.*;

public class FitnessTests {
    
        public static void main(String[] args) {
            int size = 20;
            int band = 3;
            int density = 40;

            double[][] denseMatrixA = MatrixGenerator.DS2generateDenseMatrixA(size);
            double[][] bandMatrixA = MatrixGenerator.DS2generateBandMatrixA(size, band);
            double[][] sparseMatrixA = MatrixGenerator.DS2generateSparseMatrixA(size, density);

            double[] denseMatrixX = MatrixGenerator.generateMatrixX(size);
            double[] bandMatrixX = MatrixGenerator.generateMatrixX(size);
            double[] sparseMatrixX = MatrixGenerator.generateMatrixX(size);

            // PRINT THOSE MATRICES
//            {
//                System.out.println("===== DENSE MATRIX =====");
//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print(denseMatrixA[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("===== BAND =====");
//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print(bandMatrixA[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("===== SPARSE =====");
//            for (int i = 0; i < size; i++) {
//                for (int j = 0; j < size; j++) {
//                    System.out.print(sparseMatrixA[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }

            double[] denseMatrixB = MatrixGenerator.multiplyMatrix(denseMatrixA, denseMatrixX);
            double[] bandMatrixB = MatrixGenerator.multiplyMatrix(bandMatrixA, bandMatrixX);
            double[] sparseMatrixB = MatrixGenerator.multiplyMatrix(sparseMatrixA, sparseMatrixX);

            System.out.println("\n\n===== DS2 =====");
            {
                MySparseMatrix_DS2 denseMatrixSolver = new MySparseMatrix_DS2(denseMatrixA);
                MySparseMatrix_DS2 bandMatrixSolver = new MySparseMatrix_DS2(bandMatrixA);
                MySparseMatrix_DS2 sparseMatrixSolver = new MySparseMatrix_DS2(sparseMatrixA);

                // CZAS MOZNA MIERZYC DLA WIEKSZYCH MACIERZY JAKO SYSTEM.CURRENTTIMEMILLIS()
                // WITHOUT PIVOTING
                double start1=System.nanoTime();
                    double[] denseMatrixSolved = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
                double finish1=System.nanoTime();
                double timeElapsed1 = finish1 - start1;

                long start2 = System.nanoTime();
                    double[] bandMatrixSolved = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
                long finish2 = System.nanoTime();
                long timeElapsed2 = finish2 - start2;

                long start3 = System.nanoTime();
                    double[] sparseMatrixSolved = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);
                long finish3 = System.nanoTime();
                long timeElapsed3 = finish3 - start3;

                System.out.println("\n===== WITHOUT PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX) + "\nTime: " + timeElapsed1);
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX) + "\nTime: " + timeElapsed2);
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX) + "\nTime: " + timeElapsed3);

                // WITH PIVOTING
                long startp1 = System.nanoTime();
                    double[] denseMatrixPSolved = denseMatrixSolver.solveWithPivotA2(denseMatrixB);
                long finishp1 = System.nanoTime();
                long timeElapsedp1 = finishp1 - startp1;

                long startp2 = System.nanoTime();
                    double[] bandMatrixPSolved = bandMatrixSolver.solveWithPivotA2(bandMatrixB);
                long finishp2 = System.nanoTime();
                long timeElapsedp2 = finishp2 - startp2;

                long startp3 = System.nanoTime();
                    double[] sparseMatrixPSolved = sparseMatrixSolver.solveWithPivotA2(sparseMatrixB);
                long finishp3 = System.nanoTime();
                long timeElapsedp3 = finishp3 - startp3;


                System.out.println("\n===== PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX) + "\nTime: " + timeElapsedp1);
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX) + "\nTime: " + timeElapsedp2);
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX) + "\nTime: " + timeElapsedp3);
            }

            System.out.println("\n\n===== DS3 =====");
            {
                MySparseMatrix_DS3 denseMatrixSolver = new MySparseMatrix_DS3(denseMatrixA);
                MySparseMatrix_DS3 bandMatrixSolver = new MySparseMatrix_DS3(bandMatrixA);
                MySparseMatrix_DS3 sparseMatrixSolver = new MySparseMatrix_DS3(sparseMatrixA);

                // WITHOUT PIVOTING
                long start1=System.nanoTime();
                    double[] denseMatrixSolved = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
                long finish1=System.nanoTime();
                long timeElapsed1 = finish1 - start1;

                long start2 = System.nanoTime();
                    double[] bandMatrixSolved = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
                long finish2 = System.nanoTime();
                long timeElapsed2 = finish2 - start2;

                long start3 = System.nanoTime();
                    double[] sparseMatrixSolved = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);
                long finish3 = System.nanoTime();
                long timeElapsed3 = finish3 - start3;


                System.out.println("\n===== WITHOUT PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX) + "\nTime: " + timeElapsed1);
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX) + "\nTime: " + timeElapsed2);
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX) + "\nTime: " + timeElapsed3);

                // WITH PIVOTING
                long startp1 = System.nanoTime();
                    double[] denseMatrixPSolved = denseMatrixSolver.solveWithPivotA2(denseMatrixB);
                long finishp1 = System.nanoTime();
                long timeElapsedp1 = finishp1 - startp1;

                long startp2 = System.nanoTime();
                    double[] bandMatrixPSolved = bandMatrixSolver.solveWithPivotA2(bandMatrixB);
                long finishp2 = System.nanoTime();
                long timeElapsedp2 = finishp2 - startp2;

                long startp3 = System.nanoTime();
                    double[] sparseMatrixPSolved = sparseMatrixSolver.solveWithPivotA2(sparseMatrixB);
                long finishp3 = System.nanoTime();
                long timeElapsedp3 = finishp3 - startp3;

                System.out.println("\n===== PIVOTING TESTS ===== \n");
                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX) + "\nTime: " + timeElapsedp1);
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX) + "\nTime: " + timeElapsedp2);
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX) + "\nTime: " + timeElapsedp3);
            }

            System.out.println("\n\n===== Apache math3 =====");
            {

                RealMatrix dMatrixA = MatrixUtils.createRealMatrix(denseMatrixA);
                RealVector dMatrixB = MatrixUtils.createRealVector(denseMatrixB);

                RealMatrix bMatrixA = MatrixUtils.createRealMatrix(bandMatrixA);
                RealVector bMatrixB = MatrixUtils.createRealVector(bandMatrixB);

                RealMatrix sMatrixA = MatrixUtils.createRealMatrix(sparseMatrixA);
                RealVector sMatrixB = MatrixUtils.createRealVector(sparseMatrixB);

                LUDecomposition denseMatrixSolver = new LUDecomposition(dMatrixA);
                LUDecomposition bandMatrixSolver = new LUDecomposition(bMatrixA);
                LUDecomposition sparseMatrixSolver = new LUDecomposition(sMatrixA);

                DecompositionSolver denseMatrixSolver2 = denseMatrixSolver.getSolver();
                DecompositionSolver bandMatrixSolver2 = bandMatrixSolver.getSolver();
                DecompositionSolver sparseMatrixSolver2 = sparseMatrixSolver.getSolver();

                long start1=System.nanoTime();
                    RealVector vectorDense = denseMatrixSolver2.solve(dMatrixB);
                long finish1=System.nanoTime();
                long timeElapsed1 = finish1 - start1;

                long start2=System.nanoTime();
                    RealVector vectorBand = bandMatrixSolver2.solve(bMatrixB);
                long finish2=System.nanoTime();
                long timeElapsed2 = finish2 - start2;

                long start3=System.nanoTime();
                    RealVector vectorSparse = sparseMatrixSolver2.solve(sMatrixB);
                long finish3=System.nanoTime();
                long timeElapsed3 = finish3 - start3;


                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(vectorDense.toArray(), denseMatrixX) + "\nTime: " + timeElapsed1);
                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(vectorBand.toArray(), bandMatrixX) + "\nTime: " + timeElapsed2);
                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(vectorSparse.toArray(), sparseMatrixX) + "\nTime: " + timeElapsed3);


            }


        }
}
