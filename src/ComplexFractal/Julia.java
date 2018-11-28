package ComplexFractal;

import Complex.ComplexNumber;

public class Julia extends ComplexSet {
    public ComplexNumber constant;


    public Julia(double span, ComplexNumber center, ComplexNumber constant, int iterations, int resolution){
        super(iterations, resolution, resolution, span, center);
        this.constant = constant;
    }

    /**
     * // Effects:
     * @return The number of iterations before the Mandelbrot function starts bounding to infinity.
     * If the function returns a number equal to iterations, the number c is considered part of Mandelbrot set.
     */
    public int getIterations(ComplexNumber c){
        for(int i = 0; i < iterations; i++) {
            if (c.lengthSquared() > 4) {
                return i * 255 / iterations;
            }
            c.square();
            c.add(constant);
        }
        return 255;
    }

}
