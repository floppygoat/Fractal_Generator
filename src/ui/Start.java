package ui;

import Complex.ComplexNumber;
import Complex.Mandelbrot;

import java.util.Scanner;

public class Start {

    // TODO Make this method make the fractal

    /**
     * // Effects:
     * Gets the user to input a complex number and prints whether the number is in the Mandelbrot set.
     * Then continues until the user wants to quit.
     */
    private void make_fractal(){
        do {
            ComplexNumber c = get_input();
            print_result(c);
            if( quit()){
                break;
            }
        } while(true);
    }

    /**
     * // Effects:
     * Prints on the screen if the given complex number is in the mandelbrot set.
     * Requires:
     * @param c A complex number
     */
    private void print_result(ComplexNumber c){
        Mandelbrot m = new Mandelbrot(c);
        if (m.is_mandelbrot())
            System.out.println("The number " + c.re + " + i" + c.im + " is part of the Mandelbrot set.");
        else
            System.out.println("The number " + c.re + " + i" + c.im + " is not part of the Mandelbrot set.");
    }

    /**
     * // Effects
     * @return The user's Complex number
     */
    private ComplexNumber get_input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in the real part of the number");
        double real = scanner.nextDouble();
        System.out.println("Type in the imaginary part of the number");
        double imaginary = scanner.nextDouble();

        return new ComplexNumber(real, imaginary);
    }

    /**
     * // Effects
     * @return True if user wants to quit program, False otherwise
     */
    private boolean quit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press '0' and <enter> to quit, press <enter> to continue.");
        int y = scanner.nextInt();
        return y == 0;
    }

    public static void main(String args[]){
        Start s = new Start();
        s.make_fractal();
    }
}
