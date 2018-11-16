package ui;

import Complex.ComplexNumber;
import ComplexFractal.ComplexSet;
import ComplexFractal.Julia;
import ComplexFractal.Mandelbrot;
import ComplexFractal.RenderFractal;
import observer.Observer;

public class MakeFractal implements Observer {

    public void update(String s){
        System.out.println("File " + s + " is now complete.");
    }

    /**
     * // Effects:
     * Gets the user to input a complex number and prints whether the number is in the Mandelbrot set.
     * Then continues until the user wants to quit.
     */
    public void make_fractal(){
        IO io = new IO();
        do{
            int type = io.chooseFractal();
            double size = io.getSize();
            ComplexNumber center = io.getCenter();

            ComplexSet fractal;

            try {

                //Mandelbrot Set
                if (type == 0) {
                    fractal = new Mandelbrot(size, center);
                }

                //Julia Set
                else if (type == 1) {
                    ComplexNumber constant = io.getJuliaConstant();
                    fractal = new Julia(size, center, constant);
                } else {
                    throw new NullPointerException();
                }

                RenderFractal r = new RenderFractal(fractal, this);
                r.render();

            } catch (NullPointerException e){
                System.out.println("Error, invalid input");
            }

        } while(!io.quit());
    }
}
