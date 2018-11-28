package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FilenameFilter;

public class ListFractalFiles {

    ObservableList<String> list;

    public ListFractalFiles(){
        list = FXCollections.observableArrayList();
    }

    public ObservableList<String> getList() {
        return list;
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


}
