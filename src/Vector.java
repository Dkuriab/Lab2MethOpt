public class Vector {
    private double[] vector;

    public Vector(double[] vector) {
        this.vector = vector;
    }

    public double get(int position) {
        return position < size() ? vector[position] : 0;
    }

    public double[] getVector() {
        return vector;
    }

    public double norma() {
        double ans = 0;
        for (double x : vector) {
            ans += x * x;
        }
        return Math.sqrt(ans);
    }

    public Vector multiply(double x) {
        double[] answer = new double[vector.length];

        for (int i = 0; i < vector.length; i++) {
            answer[i] = vector[i] * x;
        }

        return new Vector(answer);
    }

    public Vector add(Vector x) {
        double[] answer = new double[vector.length];

        for (int i = 0; i < vector.length; i++) {
            answer[i] = get(i) + x.get(i);
        }

        return new Vector(answer);
    }

    public double scalarMultiply(Vector x) {
		double result = 0;
		for(int i = 0; i < size(); i++){
			result += get(i) * x.get(i);
		}
		return result;
    }

    public int size() {
        return vector.length;
    }
}
