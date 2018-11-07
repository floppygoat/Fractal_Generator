package ui;

import Complex.ComplexNumber;

import java.util.Scanner;

public class IO {

    private Scanner scanner;

    public IO(){
        scanner = new Scanner(System.in);
    }

    public int chooseFractal(){
        System.out.println("Press '0' for the Mandelbrot set, else press 1 for the Julia set");
        return scanner.nextInt();
    }

    public double getSize(){
        System.out.println("Type in the size of the fractal");
        return scanner.nextDouble();
    }

    public ComplexNumber getCenter(){
        System.out.println("Type in the real part of the of the fractal's center");
        double re = scanner.nextDouble();
        System.out.println("Type in the imaginary part of the of the fractal's center");
        double im = scanner.nextDouble();
        return new ComplexNumber(re, im);
    }

    public ComplexNumber getJuliaConstant(){
        System.out.println("Type in the real part of the of the Julia Set's constant");
        double re = scanner.nextDouble();
        System.out.println("Type in the imaginary part of the of the Julia Set's constant");
        double im = scanner.nextDouble();
        return new ComplexNumber(re, im);
    }

    public String getFileName(){
        System.out.println("Type in the filename _________.jpg");
        StringBuilder filename = new StringBuilder(scanner.next()).append(".jpg");
        return filename.toString();
    }

    public boolean quit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press '0' to quit, press '1' to continue.");
        int y = scanner.nextInt();
        return y == 0;
    }
}
