package Complex;

// TODO Make grid of Complex numbers with containing the number of iterations for each number.
public class Mandelbrot {

    private final int iterations = 1000;
    private ComplexNumber c;

    /**
     * // Effects:
     * Determines if a given number is in the Mandelbrot set
     * // Requires:
     * @param c The complex number which to check if in the Mandelbrot set.
     */
    public Mandelbrot(ComplexNumber c){
        this.c = c;
    }

    /**
     * // Effects:
     * @return True if part of the Mandelbrot set, False otherwise
     */
    public boolean is_mandelbrot(){
        return get_iterations() == iterations;
    }

    /**
     * // Effects:
     * @return The number of iterations before the Mandelbrot function starts bounding to infinity.
     * If the function returns a number equal to iterations, the number c is considered part of Mandelbrot set.
     */
    private int get_iterations(){
        ComplexNumber result = new ComplexNumber(c.re, c.im);
        for(int i = 0; i < iterations; i++) {
            if (c.length() > 2) {
                return i;
            }
            result.square();
            result.add(c);
        }
        return iterations;
    }

}
