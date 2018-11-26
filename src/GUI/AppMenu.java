package GUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import java.util.Optional;

public class AppMenu {

    MenuBar mb;
    MenuItem exit;


    public AppMenu(){
        // Create the menu bar.
        mb = new MenuBar();

        // Create the File menu.
        Menu fileMenu = new Menu("File");
        MenuItem open = new MenuItem("Open");
        MenuItem close = new MenuItem("Close");
        MenuItem save = new MenuItem("Save");
        exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(open, close, save,
                new SeparatorMenuItem(), exit);

        // Add File menu to the menu bar.
        mb.getMenus().add(fileMenu);
    }

    public void MenuEvent() {
        // Create one event handler that will handle menu action events.
        EventHandler<ActionEvent> MEHandler = new EventHandler<>() {
            public void handle(ActionEvent ae) {
                String name = ((MenuItem) ae.getTarget()).getText();

                // If Exit is chosen, the program is terminated.
                if (name.equals("Exit")) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Complex Fractal Generator");
                    alert.setHeaderText("Exit Confirmation");
                    alert.setContentText("Are you sure you want to exit?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        Platform.exit();
                    }
                }
            }
        };

        exit.setOnAction(MEHandler);
    }

}
