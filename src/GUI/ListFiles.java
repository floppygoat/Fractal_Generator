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

    private BorderPane listFilesPane;
    private Label title;
    private ListView lv;
    private ViewImage image;
    private RootNode mainGUI;

    ObservableList<String> list = FXCollections.observableArrayList();

    public ListFiles(RootNode mainGUI){
        ListFractalFiles listFractalFiles = new ListFractalFiles();
        listFractalFiles.updateList();
        list = listFractalFiles.getList();
        lv = new ListView(list);
        lv.setItems(list);
        title = new Label("Choose Fractal Image");
        listFilesPane = new BorderPane();
        listFilesPane.setTop(title);
        listFilesPane.setCenter(lv);
        this.mainGUI = mainGUI;
    }

    public BorderPane getListFilesPane(){
        return listFilesPane;
    }

    public void listEvent(){
        lv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                image.updateImage(lv.getSelectionModel().getSelectedItem().toString());
            }
        });
    }
}
