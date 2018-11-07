package ui;

import Complex.ComplexNumber;
import ComplexFractal.ComplexSet;
import ComplexFractal.Julia;
import ComplexFractal.Mandelbrot;
import ComplexFractal.RenderFractal;

public class Start {

    /**
     * // Effects:
     * Gets the user to input a complex number and prints whether the number is in the Mandelbrot set.
     * Then continues until the user wants to quit.
     */
    private void make_fractal(){
        IO io = new IO();
        do{
            int type = io.chooseFractal();
            double size = io.getSize();
            ComplexNumber center = io.getCenter();
            ComplexSet fractal;

            //Mandelbrot Set
            if(type == 0){
                fractal = new Mandelbrot(size, center);
                RenderFractal r = new RenderFractal(fractal);
                r.render();
            }

            //Julia Set
            if (type == 1) {
                ComplexNumber constant = io.getJuliaConstant();
                fractal = new Julia(size, center, constant);
                RenderFractal r = new RenderFractal(fractal);
                r.render();
            }

        } while(!io.quit());
    }


    public static void main(String args[]){
        Start s = new Start();
        s.make_fractal();
    }
}
