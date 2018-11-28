package GUI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewImage {
    ImageView fractal;

    public ViewImage(){
        Image f = new Image("file:M10.jpg");
        fractal = new ImageView(f);
        fractal.setFitHeight(400);
        fractal.setFitWidth(400);
        fractal.setPreserveRatio(true);
    }

    public void updateImage(String s, MainGUI mainGUI) {
        Image f = new Image("file:" + s);
        fractal = new ImageView(f);
        fractal.setFitHeight(400);
        fractal.setFitWidth(400);
        fractal.setPreserveRatio(true);
        mainGUI.rootNode.setCenter(fractal);
    }
}
