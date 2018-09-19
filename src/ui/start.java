package ui;

import Complex.Complex;
import Complex.Mandelbrot;

import java.util.InputMismatchException;
import java.util.Scanner;

public class start {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Type in the real part of the number");
            double real = scanner.nextDouble();
            System.out.println("Type in the imaginary part of the number");
            double imaginary = scanner.nextDouble();

            Complex c = new Complex(real, imaginary);

            if (Mandelbrot.is_mandelbrot(c))
                System.out.println("The number " + real + " +  i" + imaginary + " is part of the Mandelbrot set.");
            else
                System.out.println("The number " + real + " +  i" + imaginary + " is not part of the Mandelbrot set.");

            System.out.println("Press '0' and <enter> to continue, or press another key and <enter> to exit");
            try {
                int y = scanner.nextInt();
                if(y != 0)
                    break;
            } catch (InputMismatchException e){
                break;
            }
        } while(true);
    }
}
