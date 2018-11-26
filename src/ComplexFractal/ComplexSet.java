package ComplexFractal;

import Complex.ComplexNumber;

public abstract class ComplexSet{

    protected int iterations;
    protected int width;
    protected int height;
    protected double x0;
    protected double y0;
    protected double x1;
    protected double y1;
    private Iterator iter;


    public ComplexSet(int iterations, int width, int height, double size, ComplexNumber center){
        this.iterations = iterations;
        this.width = width;
        this.height = height;
        this.x0 = center.getRe() - size/2;
        this.y0 = center.getIm() - size/2;
        this.x1 = center.getRe() + size/2;
        this.y1 = center.getIm() + size/2;
        this.iter = new Iterator(width, height, x0, x1, y0, y1);
    }

    public int getNextIteration(){
        ComplexNumber c;
        if(iter.hasNext()) {
            c = iter.nextNumber();
            return getIterations(c);
        }
        c = new ComplexNumber(0, 0);
        return getIterations(c);
    }

    abstract int getIterations(ComplexNumber c);

}
