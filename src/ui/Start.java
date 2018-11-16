package ui;

import java.io.IOException;

public class Start{

    public static void main(String args[]){
        MakeFractal s = new MakeFractal();
        try {
            ReadWebPageEx.readURL();
        } catch (IOException e){}
        s.make_fractal();
    }
}
