package ComplexFractal;

import Complex.ComplexNumber;

public class Iterator{
    private double width_step;
    private double height_step;
    private boolean has_next;
    private double re;
    private double im;
    private double x0;
    private double x1;
    private double y0;
    private double y1;
    private int width;
    private int height;
    private int i;
    private int j;


    public Iterator(int width, int height, double x0, double x1, double y0, double y1){
        this.width_step = (x1 - x0)/(width - 1);
        this.height_step = (y1 - y0)/(height - 1);
        this.has_next = true;
        this.re = x0;
        this.im = y1;
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
        this.width = width;
        this.height = height;
        this.i = 0;
        this.j = 0;

    }

    public boolean hasNext(){
        return has_next;
    }

    public ComplexNumber nextNumber(){
        ComplexNumber c = new ComplexNumber(re, im);
        if(i < width - 1){
            re += width_step;
            i++;
        }
        else if(j < height - 1){
            re = x0;
            im -= height_step;
            i = 0;
            j++;
        }
        else{
            has_next = false;
            re = x0;
            im = y1;
            i = 0;
            j = 0;
        }
        return c;
    }
}
