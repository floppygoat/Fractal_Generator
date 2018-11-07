package ComplexFractal;

import ui.IO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RenderFractal {
    private ComplexSet fractal;
    private int width;
    private int height;
    private BufferedImage b;

    public RenderFractal(ComplexSet fractal){
        this.fractal = fractal;
        this.width = fractal.width;
        this.height = fractal.height;
        this.b = new BufferedImage(width, height, 1);
    }

    public void render(){
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                setPixel(i, j);
            }
        }
        System.out.println("Render Complete");
        makeJPG();
        System.out.println("JPG file is ready");
    }

    private void setPixel(int i, int j){
        int a = fractal.getNextIteration();
        Color newColor = new Color(a,a,a);
        b.setRGB(j, i, newColor.getRGB());
    }

    private void makeJPG(){
        IO io = new IO();
        String filename = io.getFileName();
        try {
            File myNewJPegFile = new File(filename);
            ImageIO.write(b, "jpg", myNewJPegFile);
        } catch (IOException e){
            System.out.println("error");
        }
        System.out.println("end");
    }


}
