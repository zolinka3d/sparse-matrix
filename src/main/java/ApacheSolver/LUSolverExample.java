package ApacheSolver;

import org.apache.commons.math3.linear.*;

public class LUSolverExample {
    public static void main(String[] args) {
        double[][] A = { {2, 3}, {4, 5} };
        double[] B = { 5, 6 };

        RealMatrix matrixA = MatrixUtils.createRealMatrix(A);
        RealVector vectorB = MatrixUtils.createRealVector(B);

        // Bez wyboru elementu podstawowego (pivota)
        LUDecomposition luDecomposition1 = new LUDecomposition(matrixA, 0);
        DecompositionSolver solver1 = luDecomposition1.getSolver();
        RealVector vectorX1 = solver1.solve(vectorB);

        // Z częściowym wyborem elementu podstawowego (pivota)
        LUDecomposition luDecomposition2 = new LUDecomposition(matrixA);
        DecompositionSolver solver2 = luDecomposition2.getSolver();
        RealVector vectorX2 = solver2.solve(vectorB);

        System.out.println("Solution without pivot selection: " + vectorX1);
        System.out.println("Solution with partial pivot selection: " + vectorX2);
    }
}
