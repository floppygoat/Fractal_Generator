package Complex;

/**
 * A class the represents a Complex Number.  Contains two variables representing the real part and the imaginary part.
 */
public class ComplexNumber{
    private double re;
    private double im;

    /**
     * // Modifies this
     * // Requires:
     * @param re (int) Real part of Complex Number
     * @param im (int) Imaginary part of Complex Number
     */
    public ComplexNumber(double re, double im){
        this.re = re;
        this.im = im;
    }

    public double getRe(){
        return re;
    }

    public double getIm(){
        return im;
    }

    public void changeRe(double re){
        this.re = re;
    }

    public void changeIm(double im){
        this.im = im;
    }

    /**
     * // Effects: Adds a complex number to this
     * // Modifies: this
     * // Requires:
     * @param c Complex number to add to this
     */
    public void add(ComplexNumber c){
        this.re += c.re;
        this.im += c.im;
    }

    /**
     * // Effects: Does the complex square of this
     * // Modifies: this
     */
    public void square(){
        double real = this.re * this.re - this.im * this.im;
        this.im = 2 * this.re * this.im;
        this.re = real;
    }

    /**
     * // Effects:
     * @return The modulus of this
     */
    public double length(){
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

}
