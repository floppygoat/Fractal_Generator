package ComplexFractal;

import Complex.ComplexNumber;

public class Iterator{
    double width_step;
    double height_step;
    private boolean has_next;
    double re;
    double im;
    double x0;
    double x1;
    double y0;
    double y1;


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
    }

    public boolean hasNext(){
        return has_next;
    }

    public ComplexNumber nextNumber(){
        ComplexNumber c = new ComplexNumber(re, im);
        if(re <= x1){
            re += width_step;
        }
        else if(im >= y0){
            re = x0;
            im -= height_step;
        }
        else{
            has_next = false;
            re = x0;
            im = y1;
        }
        return c;
    }
}
