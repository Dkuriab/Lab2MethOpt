public class Function {
/**
     * Matrix of square terms. A_{ij}=A_{ji}, A_{ii} = 2 * x{i}^2
     */
    final double[][] A;
    /**
     * Vector of one-dimensional terms
     */
    final double[] B;
    /**
     * Constant of function
     */
    final double C;

    /**
     * Standard constructor of matrix representation of function
     * @param a {@link #A}
     * @param b {@link #B}
     * @param c {@link #C}
     */
    public Function(double[][] a, double[] b, double c) {
        A = a;
        B = b;
        C = c;
    }

    public Vector runGradient(Vector x) {
        return new Vector(subtract(multiply(A, x.getVector()), B));
    }

    public Vector multiply(Vector x) {
        return new Vector(multiply(A, x.getVector()));
    }

    private static double[] multiply(double[][] matrix, double[] vector) {
		int dimension = matrix.length;
		double[] result = new double[dimension];
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				result[i] += matrix[i][j] * vector[j];
			}
		}
		return result;
	}

	private static double[] subtract(double[] vector1, double[] vector2) {
		double[] result = new double[vector1.length];

		for (int i = 0; i < vector1.length; ++i) {
			result[i] = vector1[i] - vector2[i];
		}
		return result;
	}
}