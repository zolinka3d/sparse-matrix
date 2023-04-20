package FitnessTests;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MatrixGenerator {

    public static double[][] DS2generateDenseMatrixA (int size) {
        double[][] matrixA = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixA[i][j] = getRandomDouble();
            }
        }
        return matrixA;
    }

    public static HashMap<Integer, Double>[] DS3generateDenseMatrixA (int size) {
        HashMap<Integer, Double>[] matrixA = new HashMap[size];
        for (int i = 0; i < size; i++) {
            matrixA[i] = new HashMap<>();
            for (int j = 0; j < size; j++) {
                matrixA[i].put(j, getRandomDouble());
            }
        }
        return matrixA;
    }

    public static double[][] DS2generateBandMatrixA (int size, int band) {
        double[][] matrixA = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Math.abs(i - j) <= band) {
                    matrixA[i][j] = getRandomDouble();
                }
            }
        }
        return matrixA;
    }

    public static HashMap<Integer, Double>[] DS3generateBandMatrixA (int size, int band) {
        HashMap<Integer, Double>[] matrixA = new HashMap[size];
        for (int i = 0; i < size; i++) {
            matrixA[i] = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (Math.abs(i - j) <= band) {
                    matrixA[i].put(j, getRandomDouble());
                }
            }
        }
        return matrixA;
    }

    public static double[][] DS2generateSparseMatrixA (int size, int density) {
        double[][] matrixA = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (getRandomInt() <= density) {
                    matrixA[i][j] = getRandomDouble();
                }
            }
        }
        return matrixA;
    }

    public static HashMap<Integer, Double>[] DS3generateSparseMatrixA (int size, int density) {
        HashMap<Integer, Double>[] matrixA = new HashMap[size];
        for (int i = 0; i < size; i++) {
            matrixA[i] = new HashMap<>();
            for (int j = 0; j < size; j++) {
                if (getRandomInt() <= density) {
                    matrixA[i].put(j, getRandomDouble());
                }
            }
        }
        return matrixA;
    }

    private static int getRandomInt() {
        Random random = new Random();
        return random.nextInt(100);
    }


    public static double[] generateMatrixX (int size) {
        double[] matrixX = new double[size];
        for (int i = 0; i < size; i++) {
            matrixX[i] = getRandomDouble();
        }
        return matrixX;
    }

    private static double getRandomDouble() {
        var myRandom = ThreadLocalRandom.current().nextDouble(-2^16, 2^16-1);
        return myRandom / (2^16);
    }

    public static double[] multiplyMatrix(double[][] MatrixA, double[] MatrixX) {
        double[] denseMatrixAX = new double[MatrixA.length];
        for (int i = 0; i < MatrixA.length; i++) {
            for (int j = 0; j < MatrixA.length; j++) {
                denseMatrixAX[i] += MatrixA[i][j] * MatrixX[j];
            }
        }
        return denseMatrixAX;
    }

    public static String getAccuracy(double[] denseMatrixSolved, double[] denseMatrixX) {
        double absoluteError = 0;
        double relativeError = 0;
        for (int i = 0; i < denseMatrixSolved.length; i++) {
            double difference = Math.abs(denseMatrixSolved[i] - denseMatrixX[i]);
            absoluteError += difference;
            if(denseMatrixSolved[i] != 0) {
                relativeError += difference / Math.abs(denseMatrixSolved[i]);
            }
        }
        absoluteError = absoluteError / denseMatrixSolved.length;
        relativeError = relativeError / denseMatrixSolved.length;
        return "\tAbsolute Error: " + absoluteError +
                "\n\tRelative Error: " + relativeError;
    }


    // getAccuracy should print value for matrix Solved, MatrixX and then percentage of accuracy



}
