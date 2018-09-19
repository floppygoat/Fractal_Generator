package Complex;

public class Mandelbrot {

    public static boolean is_mandelbrot(Complex c){
        final int iterations = 500;
        Complex result = new Complex(c.re, c.im);
        for(int i = 0; i < iterations; i++){
            if(c.length() > 2){
                return false;
            }
            result.square();
            result.add(c);
        }
        return true;
    }

}
