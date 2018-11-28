package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.io.FilenameFilter;

public class ListFiles {

    BorderPane listFilesPane;
    Label title;
    ListView lv;
    ViewImage image;
    MainGUI mainGUI;

    ObservableList<String> list = FXCollections.observableArrayList();

    public ListFiles(ViewImage image, MainGUI mainGUI){
        updateList();
        lv = new ListView(list);
        lv.setItems(list);
        title = new Label("Choose Fractal Image");
        listFilesPane = new BorderPane();
        listFilesPane.setTop(title);
        listFilesPane.setCenter(lv);
        this.image = image;
        this.mainGUI = mainGUI;
    }

    public void updateList(){
        File folder = new File(System.getProperty("user.dir"));

        //Implementing FilenameFilter to retrieve only txt files

        FilenameFilter txtFileFilter = new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".jpg");
            }
        };

        //Passing txtFileFilter to listFiles() method to retrieve only txt files

        File[] files = folder.listFiles(txtFileFilter);

        for (File file : files) {
            list.add(file.getName());
        }
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
