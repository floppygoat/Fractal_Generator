package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import ui.ListFractalFiles;

public class ListFiles {

    BorderPane listFilesPane;
    Label title;
    ListView lv;
    ViewImage image;
    MainGUI mainGUI;

    ObservableList<String> list = FXCollections.observableArrayList();

    public ListFiles(ViewImage image, MainGUI mainGUI){
        ListFractalFiles listFractalFiles = new ListFractalFiles();
        listFractalFiles.updateList();
        list = listFractalFiles.getList();
        lv = new ListView(list);
        lv.setItems(list);
        title = new Label("Choose Fractal Image");
        listFilesPane = new BorderPane();
        listFilesPane.setTop(title);
        listFilesPane.setCenter(lv);
        this.image = image;
        this.mainGUI = mainGUI;
    }


    public void listEvent(){
        lv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                image.updateImage(lv.getSelectionModel().getSelectedItem().toString(), mainGUI);
            }
        });
    }
}
