package FitnessTests;

import MySparseMatrix.MySparseMatrix_DS2;
import MySparseMatrix.MySparseMatrix_DS3;
import org.apache.commons.math3.linear.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FitnessTests {

    public static void main(String[] args) throws IOException {
        int size = 30;
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

//        System.out.println("\n\n===== DS2 =====");


        File ds2_dense_without_pivot = new File("./test_data/DS2_dense_without_pivot.txt");
        try {
            ds2_dense_without_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds2_dense_without_pivot_writer = new FileWriter("./test_data/DS2_dense_without_pivot.txt");
        ds2_dense_without_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds2_band_without_pivot = new File("./test_data/DS2_band_without_pivot.txt");
        try {
            ds2_band_without_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds2_band_without_pivot_writer = new FileWriter("./test_data/DS2_band_without_pivot.txt");
        ds2_band_without_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds2_sparse_without_pivot = new File("./test_data/DS2_sparse_without_pivot.txt");
        try {
            ds2_sparse_without_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds2_sparse_without_pivot_writer = new FileWriter("./test_data/DS2_sparse_without_pivot.txt");
        ds2_sparse_without_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds2_dense_with_pivot = new File("./test_data/DS2_dense_with_pivot.txt");
        try {
            ds2_dense_with_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds2_dense_with_pivot_writer = new FileWriter("./test_data/DS2_dense_with_pivot.txt");
        ds2_dense_with_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds2_band_with_pivot = new File("./test_data/DS2_band_with_pivot.txt");
        try {
            ds2_band_with_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds2_band_with_pivot_writer = new FileWriter("./test_data/DS2_band_with_pivot.txt");
        ds2_band_with_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds2_sparse_with_pivot = new File("./test_data/DS2_sparse_with_pivot.txt");
        try {
            ds2_sparse_with_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds2_sparse_with_pivot_writer = new FileWriter("./test_data/DS2_sparse_with_pivot.txt");
        ds2_sparse_with_pivot_writer.write("Absolute Error, Relative Error, Time\n");

//        size = 30;
//        band = 3;
//        density = 40;

        for (int i = 0; i < 1000; i++) {

//            System.out.println("ds2 iteracja");
//            System.out.println(i);
//
//            size = size + i;
//            band = band + i;
//            density = density + i;

            denseMatrixA = MatrixGenerator.DS2generateDenseMatrixA(size);
            bandMatrixA = MatrixGenerator.DS2generateBandMatrixA(size, band);
            sparseMatrixA = MatrixGenerator.DS2generateSparseMatrixA(size, density);

            denseMatrixX = MatrixGenerator.generateMatrixX(size);
            bandMatrixX = MatrixGenerator.generateMatrixX(size);
            sparseMatrixX = MatrixGenerator.generateMatrixX(size);

            denseMatrixB = MatrixGenerator.multiplyMatrix(denseMatrixA, denseMatrixX);
            bandMatrixB = MatrixGenerator.multiplyMatrix(bandMatrixA, bandMatrixX);
            sparseMatrixB = MatrixGenerator.multiplyMatrix(sparseMatrixA, sparseMatrixX);

            MySparseMatrix_DS2 denseMatrixSolver = new MySparseMatrix_DS2(denseMatrixA);
            MySparseMatrix_DS2 bandMatrixSolver = new MySparseMatrix_DS2(bandMatrixA);
            MySparseMatrix_DS2 sparseMatrixSolver = new MySparseMatrix_DS2(sparseMatrixA);

            // CZAS MOZNA MIERZYC DLA WIEKSZYCH MACIERZY JAKO SYSTEM.CURRENTTIMEMILLIS()
            // WITHOUT PIVOTING

            // DS2 DENSE WITHOUT PIVOT

            double start1 = System.nanoTime();
            double[] denseMatrixSolved = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
            double finish1 = System.nanoTime();
            double timeElapsed1 = finish1 - start1;
            ds2_dense_without_pivot_writer.write(MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX) + ", " + timeElapsed1 + "\n");

            // DS2 BAND WITHOUT PIVOT

            long start2 = System.nanoTime();
            double[] bandMatrixSolved = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
            long finish2 = System.nanoTime();
            long timeElapsed2 = finish2 - start2;
            ds2_band_without_pivot_writer.write(MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX) + ", " + timeElapsed2 + "\n");

            // DS2 SPARSE WITHOUT PIVOT

            long start3 = System.nanoTime();
            double[] sparseMatrixSolved = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);
            long finish3 = System.nanoTime();
            long timeElapsed3 = finish3 - start3;
            ds2_sparse_without_pivot_writer.write(MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX) + ", " + timeElapsed3 + "\n");

//                System.out.println("\n===== WITHOUT PIVOTING TESTS ===== \n");
//                System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX) + "\nTime: " + timeElapsed1);
//                System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX) + "\nTime: " + timeElapsed2);
//                System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX) + "\nTime: " + timeElapsed3);

            // WITH PIVOTING
            long startp1 = System.nanoTime();
            double[] denseMatrixPSolved = denseMatrixSolver.solveWithPivotA2(denseMatrixB);
            long finishp1 = System.nanoTime();
            long timeElapsedp1 = finishp1 - startp1;
            ds2_dense_with_pivot_writer.write(MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX) + ", " + timeElapsedp1 + "\n");

            long startp2 = System.nanoTime();
            double[] bandMatrixPSolved = bandMatrixSolver.solveWithPivotA2(bandMatrixB);
            long finishp2 = System.nanoTime();
            long timeElapsedp2 = finishp2 - startp2;
            ds2_band_with_pivot_writer.write(MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX) + ", " + timeElapsedp2 + "\n");

            long startp3 = System.nanoTime();
            double[] sparseMatrixPSolved = sparseMatrixSolver.solveWithPivotA2(sparseMatrixB);
            long finishp3 = System.nanoTime();
            long timeElapsedp3 = finishp3 - startp3;
            ds2_sparse_with_pivot_writer.write(MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX) + ", " + timeElapsedp3 + "\n");


//            System.out.println("\n===== PIVOTING TESTS ===== \n");
//            System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX) + "\nTime: " + timeElapsedp1);
//            System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX) + "\nTime: " + timeElapsedp2);
//            System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX) + "\nTime: " + timeElapsedp3);
        }

        ds2_dense_without_pivot_writer.close();
        ds2_band_without_pivot_writer.close();
        ds2_sparse_without_pivot_writer.close();
        ds2_dense_with_pivot_writer.close();
        ds2_band_with_pivot_writer.close();
        ds2_sparse_with_pivot_writer.close();


        File ds3_dense_without_pivot = new File("./test_data/DS3_dense_without_pivot.txt");
        try {
            ds3_dense_without_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds3_dense_without_pivot_writer = new FileWriter("./test_data/DS3_dense_without_pivot.txt");
        ds3_dense_without_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds3_band_without_pivot = new File("./test_data/DS3_band_without_pivot.txt");
        try {
            ds3_band_without_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds3_band_without_pivot_writer = new FileWriter("./test_data/DS3_band_without_pivot.txt");
        ds3_band_without_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds3_sparse_without_pivot = new File("./test_data/DS3_sparse_without_pivot.txt");
        try {
            ds3_sparse_without_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds3_sparse_without_pivot_writer = new FileWriter("./test_data/DS3_sparse_without_pivot.txt");
        ds3_sparse_without_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds3_dense_with_pivot = new File("./test_data/DS3_dense_with_pivot.txt");
        try {
            ds3_dense_with_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds3_dense_with_pivot_writer = new FileWriter("./test_data/DS3_dense_with_pivot.txt");
        ds3_dense_with_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds3_band_with_pivot = new File("./test_data/DS3_band_with_pivot.txt");
        try {
            ds3_band_with_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds3_band_with_pivot_writer = new FileWriter("./test_data/DS3_band_with_pivot.txt");
        ds3_band_with_pivot_writer.write("Absolute Error, Relative Error, Time\n");


        File ds3_sparse_with_pivot = new File("./test_data/DS3_sparse_with_pivot.txt");
        try {
            ds3_sparse_with_pivot.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter ds3_sparse_with_pivot_writer = new FileWriter("./test_data/DS3_sparse_with_pivot.txt");
        ds3_sparse_with_pivot_writer.write("Absolute Error, Relative Error, Time\n");

//        size = 30;
//        band = 3;
//        density = 40;

        for (int i = 0; i < 1000; i++) {

//            System.out.println("ds3 iteracja");
//            System.out.println(i);
//
//            size = size + i;
//            band = band + i;
//            density = density + i;

            denseMatrixA = MatrixGenerator.DS2generateDenseMatrixA(size);
            bandMatrixA = MatrixGenerator.DS2generateBandMatrixA(size, band);
            sparseMatrixA = MatrixGenerator.DS2generateSparseMatrixA(size, density);

            denseMatrixX = MatrixGenerator.generateMatrixX(size);
            bandMatrixX = MatrixGenerator.generateMatrixX(size);
            sparseMatrixX = MatrixGenerator.generateMatrixX(size);

            denseMatrixB = MatrixGenerator.multiplyMatrix(denseMatrixA, denseMatrixX);
            bandMatrixB = MatrixGenerator.multiplyMatrix(bandMatrixA, bandMatrixX);
            sparseMatrixB = MatrixGenerator.multiplyMatrix(sparseMatrixA, sparseMatrixX);

            MySparseMatrix_DS3 denseMatrixSolver = new MySparseMatrix_DS3(denseMatrixA);
            MySparseMatrix_DS3 bandMatrixSolver = new MySparseMatrix_DS3(bandMatrixA);
            MySparseMatrix_DS3 sparseMatrixSolver = new MySparseMatrix_DS3(sparseMatrixA);

            // WITHOUT PIVOTING
            long start1 = System.nanoTime();
            double[] denseMatrixSolved = denseMatrixSolver.solveWithoutPivotA1(denseMatrixB);
            long finish1 = System.nanoTime();
            long timeElapsed1 = finish1 - start1;
            ds3_dense_without_pivot_writer.write(MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX) + ", " + timeElapsed1 + "\n");

            long start2 = System.nanoTime();
            double[] bandMatrixSolved = bandMatrixSolver.solveWithoutPivotA1(bandMatrixB);
            long finish2 = System.nanoTime();
            long timeElapsed2 = finish2 - start2;
            ds3_band_without_pivot_writer.write(MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX) + ", " + timeElapsed2 + "\n");

            long start3 = System.nanoTime();
            double[] sparseMatrixSolved = sparseMatrixSolver.solveWithoutPivotA1(sparseMatrixB);
            long finish3 = System.nanoTime();
            long timeElapsed3 = finish3 - start3;
            ds3_sparse_without_pivot_writer.write(MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX) + ", " + timeElapsed3 + "\n");


//            System.out.println("\n===== WITHOUT PIVOTING TESTS ===== \n");
//            System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixSolved, denseMatrixX) + "\nTime: " + timeElapsed1);
//            System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixSolved, bandMatrixX) + "\nTime: " + timeElapsed2);
//            System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixSolved, sparseMatrixX) + "\nTime: " + timeElapsed3);

            // WITH PIVOTING
            long startp1 = System.nanoTime();
            double[] denseMatrixPSolved = denseMatrixSolver.solveWithPivotA2(denseMatrixB);
            long finishp1 = System.nanoTime();
            long timeElapsedp1 = finishp1 - startp1;
            ds3_dense_with_pivot_writer.write(MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX) + ", " + timeElapsedp1 + "\n");

            long startp2 = System.nanoTime();
            double[] bandMatrixPSolved = bandMatrixSolver.solveWithPivotA2(bandMatrixB);
            long finishp2 = System.nanoTime();
            long timeElapsedp2 = finishp2 - startp2;
            ds3_band_with_pivot_writer.write(MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX) + ", " + timeElapsedp2 + "\n");

            long startp3 = System.nanoTime();
            double[] sparseMatrixPSolved = sparseMatrixSolver.solveWithPivotA2(sparseMatrixB);
            long finishp3 = System.nanoTime();
            long timeElapsedp3 = finishp3 - startp3;
            ds3_sparse_with_pivot_writer.write(MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX) + ", " + timeElapsedp3 + "\n");

//            System.out.println("\n===== PIVOTING TESTS ===== \n");
//            System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(denseMatrixPSolved, denseMatrixX) + "\nTime: " + timeElapsedp1);
//            System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(bandMatrixPSolved, bandMatrixX) + "\nTime: " + timeElapsedp2);
//            System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(sparseMatrixPSolved, sparseMatrixX) + "\nTime: " + timeElapsedp3);
        }

        ds3_dense_without_pivot_writer.close();
        ds3_band_without_pivot_writer.close();
        ds3_sparse_without_pivot_writer.close();
        ds3_dense_with_pivot_writer.close();
        ds3_band_with_pivot_writer.close();
        ds3_sparse_with_pivot_writer.close();


        File apache_dense = new File("./test_data/apache_dense.txt");
        try {
            apache_dense.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter apache_dense_writer = new FileWriter("./test_data/apache_dense.txt");
        apache_dense_writer.write("Absolute Error, Relative Error, Time\n");


        File apache_band = new File("./test_data/apache_band.txt");
        try {
            apache_band.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter apache_band_writer = new FileWriter("./test_data/apache_band.txt");
        apache_band_writer.write("Absolute Error, Relative Error, Time\n");


        File apache_sparse = new File("./test_data/apache_sparse.txt");
        try {
            apache_sparse.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter apache_sparse_writer = new FileWriter("./test_data/apache_sparse.txt");
        apache_sparse_writer.write("Absolute Error, Relative Error, Time\n");

//        size = 30;
//        band = 3;
//        density = 40;

        for (int i = 0; i < 1000; i++) {

//            System.out.println("apache iteracja");
//            System.out.println(i);

//            size = size + i;
//            band = band + i;
//            density = density + i;


            denseMatrixA = MatrixGenerator.DS2generateDenseMatrixA(size);
            bandMatrixA = MatrixGenerator.DS2generateBandMatrixA(size, band);
            sparseMatrixA = MatrixGenerator.DS2generateSparseMatrixA(size, density);

            denseMatrixX = MatrixGenerator.generateMatrixX(size);
            bandMatrixX = MatrixGenerator.generateMatrixX(size);
            sparseMatrixX = MatrixGenerator.generateMatrixX(size);

            denseMatrixB = MatrixGenerator.multiplyMatrix(denseMatrixA, denseMatrixX);
            bandMatrixB = MatrixGenerator.multiplyMatrix(bandMatrixA, bandMatrixX);
            sparseMatrixB = MatrixGenerator.multiplyMatrix(sparseMatrixA, sparseMatrixX);


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

            long start1 = System.nanoTime();
            RealVector vectorDense = denseMatrixSolver2.solve(dMatrixB);
            long finish1 = System.nanoTime();
            long timeElapsed1 = finish1 - start1;
            apache_dense_writer.write(MatrixGenerator.getAccuracy(vectorDense.toArray(), denseMatrixX) + ", " + timeElapsed1 + "\n");

            long start2 = System.nanoTime();
            RealVector vectorBand = bandMatrixSolver2.solve(bMatrixB);
            long finish2 = System.nanoTime();
            long timeElapsed2 = finish2 - start2;
            apache_band_writer.write(MatrixGenerator.getAccuracy(vectorBand.toArray(), bandMatrixX) + ", " + timeElapsed2 + "\n");

            long start3 = System.nanoTime();
            RealVector vectorSparse = sparseMatrixSolver2.solve(sMatrixB);
            long finish3 = System.nanoTime();
            long timeElapsed3 = finish3 - start3;
            apache_sparse_writer.write(MatrixGenerator.getAccuracy(vectorSparse.toArray(), sparseMatrixX) + ", " + timeElapsed3 + "\n");

//
//            System.out.println("Dense Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(vectorDense.toArray(), denseMatrixX) + "\nTime: " + timeElapsed1);
//            System.out.println("Band Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(vectorBand.toArray(), bandMatrixX) + "\nTime: " + timeElapsed2);
//            System.out.println("Sparse Matrix Accuracy: \n" + MatrixGenerator.getAccuracy(vectorSparse.toArray(), sparseMatrixX) + "\nTime: " + timeElapsed3);


        }

        apache_dense_writer.close();
        apache_sparse_writer.close();
        apache_band_writer.close();


    }
}
