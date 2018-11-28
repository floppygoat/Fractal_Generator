package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ListFiles {

    private BorderPane listFilesPanel;
    private Label title;
    private ListView lv;
    private RootNode rootNode;

    ObservableList<String> list = FXCollections.observableArrayList();

    public ListFiles(RootNode rootNode){
        ListFractalFiles listFractalFiles = new ListFractalFiles();
        listFractalFiles.updateList();
        list = listFractalFiles.getList();
        lv = new ListView(list);
        lv.setItems(list);
        title = new Label("Choose Fractal Image");
        listFilesPanel = new BorderPane();
        listFilesPanel.setTop(title);
        listFilesPanel.setCenter(lv);
        this.rootNode = rootNode;
    }

    public BorderPane getListFilesPanel(){
        return listFilesPanel;
    }

    public ObservableList<String> getList(){
        return list;
    }

    public void listEvent(){
        lv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ViewImage image = new ViewImage(rootNode);
                image.updateImage(lv.getSelectionModel().getSelectedItem().toString());
            }
        });
    }
}
