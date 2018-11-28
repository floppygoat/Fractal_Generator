package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainGUI extends Application {
    BorderPane rootNode;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().
        launch(args);
    }

    // Override the start() method.
    public void start(Stage myStage) {

        // Give the stage a title.
        myStage.setTitle("Complex Fractal Generator");

        // Create a root node. In this case, a flow layout pane
        // is used, but several alternatives exist.
        rootNode = new BorderPane();

        // Create a scene.
        Scene myScene = new Scene(rootNode, 800, 800);

        // Set the scene on the stage.
        myStage.setScene(myScene);

        AppMenu appMenu = new AppMenu();
        ViewImage image = new ViewImage();
        ListFiles listFiles = new ListFiles(image, this);


        // Add the menu bar to the top of the border pane and
        // the response label to the center position.
        rootNode.setTop(appMenu.mb);
        rootNode.setCenter(image.fractal);
        rootNode.setLeft(listFiles.listFilesPane);

        appMenu.MenuEvent();
        listFiles.listEvent();

        // Show the stage and its scene.
        myStage.show();

    }

}