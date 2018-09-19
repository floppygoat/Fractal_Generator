package Complex;

import java.lang.Math;

public class Complex {
    public double re;
    public double im;

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    public void add(Complex c){
        this.re += c.re;
        this.im += c.re;
    }

    public void square(){
        double real = this.re * this.re - this.im * this.im;
        this.im = 2 * this.re * this.im;
        this.re = real;
    }

    public double length(){
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

}
