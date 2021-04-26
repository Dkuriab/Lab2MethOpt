import java.io.*;
import java.util.*;

public class ConjugateGradientMethod {
    private double epsilon;

    public ConjugateGradientMethod(double epsilon) {
        this.epsilon = epsilon;
    }

    /**
     * Finds minimum
     * 
     * @param fun         function, minimum to find
     * @param startValues start point
     * @return the coordinates of the minimum
     */
    public double[] findMinimum(Function fun, double[] startValues) {
        Vector answer = new Vector(startValues);
        answer = iterate(fun, answer);

        return answer.getVector();
    }

    public Vector iterate(Function function, Vector coordinates) {
        
        Vector gradient = function.runGradient(coordinates);
        double gradientNorma = gradient.norma();
        Vector prevP = gradient.multiply(-1);
        for (int i = 1; i < coordinates.size() && gradientNorma >= epsilon; i++) {
            Vector mulApPrev = function.multiply(prevP);
            double aPrev = gradientNorma * gradientNorma / mulApPrev.scalarMultiply(prevP);
            Vector nextX = coordinates.add(prevP.multiply(aPrev));
            Vector nextGrad = gradient.add(mulApPrev.multiply(aPrev));
            double normNextGrad = nextGrad.norma();
            double b = normNextGrad * normNextGrad / gradientNorma / gradientNorma;
            Vector nextP = nextGrad.multiply(-1).add(prevP.multiply(b));

            prevP = nextP;
            gradient = nextGrad;
            coordinates = nextX;
            gradientNorma = normNextGrad;
//            log(coordinates, gradient);
        }
        return coordinates;
    }
}