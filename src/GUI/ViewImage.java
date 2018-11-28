package GUI;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewImage {
    private RootNode rootNode;
    private ImageView fractal;
    private Label label;

    public ViewImage(RootNode rootNode){
        this.rootNode = rootNode;
        label = new Label("Click on a file to the left to see image, or mke");
    }

    public void updateImage(String s) {
        Image f = new Image("file:" + s);
        fractal = new ImageView(f);
        fractal.setFitHeight(400);
        fractal.setFitWidth(400);
        fractal.setPreserveRatio(true);
        rootNode.bp.setCenter(fractal);
    }

    public Label getLabel(){
        return label;
    }
}
