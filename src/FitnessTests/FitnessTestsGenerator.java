package FitnessTests;

import java.util.HashMap;
import java.util.Random;

public class FitnessTestsGenerator {

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


    public static double[] generateMatrixB (int size) {
        double[] matrixB = new double[size];
        for (int i = 0; i < size; i++) {
            matrixB[i] = getRandomDouble();
        }
        return matrixB;
    }

    private static double getRandomDouble() {
        Random random = new Random();
        double randomNumber = random.nextDouble();
        double randomDouble = random.nextDouble() * 2e16;
        if (randomNumber < 0.5) {
            randomDouble = -randomDouble;
        } else {
            randomDouble = randomDouble - 1;
        }
        return randomDouble;
    }
}
