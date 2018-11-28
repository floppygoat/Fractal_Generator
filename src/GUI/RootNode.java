package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootNode extends Application {
    BorderPane bp;

    // Override the start() method.
    public void start(Stage myStage) {

        // Give the stage a title.
        myStage.setTitle("Complex Fractal Generator");

        // Create a root node. In this case, a flow layout pane
        // is used, but several alternatives exist.
        bp = new BorderPane();

        // Create a scene.
        Scene myScene = new Scene(bp, 800, 800);

        // Set the scene on the stage.
        myStage.setScene(myScene);

        AppMenu appMenu = new AppMenu(this);
        ViewImage image = new ViewImage(this);
        ListFiles listFiles = new ListFiles(this);


        // Add the menu bar to the top of the border pane and
        // the response label to the center position.
        bp.setTop(appMenu.mb);
        bp.setCenter(image.getLabel());
        bp.setLeft(listFiles.getListFilesPanel());

        appMenu.MenuEvent();
        listFiles.listEvent();

        // Show the stage and its scene.
        myStage.show();

    }

}