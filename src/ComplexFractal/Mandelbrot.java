package ComplexFractal;

import Complex.ComplexNumber;


public class Mandelbrot extends ComplexSet {

    public Mandelbrot(double size, ComplexNumber center){
        super(255, 5000, 5000, size, center);
    }

    /**
     * // Effects:
     * @return The number of iterations before the Mandelbrot function starts bounding to infinity.
     * If the function returns a number equal to iterations, the number c is considered part of Mandelbrot set.
     */
    public int getIterations(ComplexNumber c){
        ComplexNumber result = new ComplexNumber(c.getRe(), c.getIm());
        for(int i = 0; i < iterations; i++) {
            if (result.lengthSquared() > 4) {
                return i * 255/iterations;
            }
            result.square();
            result.add(c);
        }
        return 255;
    }

}
