package ComplexFractal;

import Complex.ComplexNumber;

public class Julia extends ComplexSet {
    public ComplexNumber constant;


    public Julia(double size, ComplexNumber center, ComplexNumber constant){
        super(255, 500, 500, size, center);
        this.constant = constant;
    }

    /**
     * // Effects:
     * @return The number of iterations before the Mandelbrot function starts bounding to infinity.
     * If the function returns a number equal to iterations, the number c is considered part of Mandelbrot set.
     */
    public int getIterations(ComplexNumber c){
        for(int i = 0; i < iterations; i++) {
            if (c.length() > 2) {
                return i;
            }
            c.square();
            c.add(constant);
        }
        return iterations;
    }

}
