package GUI;

import Complex.ComplexNumber;
import ComplexFractal.ComplexSet;
import ComplexFractal.Julia;
import ComplexFractal.Mandelbrot;
import ComplexFractal.RenderFractal;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class AppMenu {

    private RootNode rootNode;

    MenuBar mb;
    private MenuItem exit;
    private MenuItem new_julia;
    private MenuItem new_mandelbrot;


    private Stage renderPopup;


    public AppMenu(RootNode rootNode){

        this.rootNode = rootNode;
        // Create the menu bar.
        mb = new MenuBar();

        // Create the File menu.
        Menu fileMenu = new Menu("File");
        Menu new_fractal = new Menu("New");
        new_julia = new MenuItem("Julia Set");
        new_mandelbrot = new MenuItem("Mandelbrot Set");
        exit = new MenuItem("Exit");
        new_fractal.getItems().addAll(new_julia, new_mandelbrot);
        fileMenu.getItems().addAll(new_fractal, new SeparatorMenuItem(), exit);

        // Add File menu to the menu bar.
        mb.getMenus().add(fileMenu);
    }

    public void MenuEvent() {
        // Create one event handler that will handle menu action events.
        EventHandler<ActionEvent> MEHandler = new EventHandler<>() {
            public void handle(ActionEvent ae) {
                String name = ((MenuItem) ae.getTarget()).getText();

                // If Exit is chosen, the program is terminated.
                if(name.equals("Exit")){
                    FileExit();
                }
                else if(name.equals("Julia Set")){
                    FileNewJuliaSet();
                }
                else if(name.equals("Mandelbrot Set")){
                    FileNewMandelbrotSet();
                }
            }
        };

        exit.setOnAction(MEHandler);
        new_julia.setOnAction(MEHandler);
        new_mandelbrot.setOnAction(MEHandler);
    }

    private void FileExit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Complex Fractal Generator");
        alert.setHeaderText("Exit Confirmation");
        alert.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    private void FileNewJuliaSet(){
        Stage stage = new Stage();
        VBox box = new VBox();
        box.setPadding((new Insets(15, 12, 15, 12)));
        box.setSpacing(5);

        Label labelRePart = new Label("Enter the real part of the Julia Set constant");
        TextField textRePart = new TextField();
        Label labelRePartErr = new Label();

        Label labelImPart = new Label("Enter the imaginary part of the Julia Set constant");
        TextField textImPart = new TextField();
        Label labelImPartErr = new Label();

        Label labelSpan = new Label("Enter the horizontal span of the Julia Set");
        TextField textSpan = new TextField();
        Label labelSpanErr = new Label();

        Label labelIterations = new Label("Enter the number of iterations");
        TextField textIterations = new TextField();
        Label labelIterationsErr = new Label();

        Label labelResolution = new Label("Enter the resolution of the fractal");
        TextField textResolution = new TextField();
        Label labelResolutionErr = new Label();

        HBox buttons = new HBox();
        buttons.setPadding(new Insets(15, 12, 15, 12));
        buttons.setSpacing(10);

        Button btnEnter = new Button();
        btnEnter.setText("Enter");

        btnEnter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s;
                boolean b = true;

                double Re = 0;
                double Im = 0;
                int iterations = 1;
                int resolution = 1;

                s = textRePart.getText();
                try { Re = Double.parseDouble(s); } catch (NumberFormatException e) {
                    labelRePartErr.setText("Error, must be a number");
                    b = false;
                }

                s = textImPart.getText();
                try { Im = Double.parseDouble(s); } catch (NumberFormatException e) {
                    labelImPartErr.setText("Error, must be a number");
                    b = false;
                }

                s = textIterations.getText();
                try {
                    iterations = Integer.parseInt(s);
                    if(iterations == 0){
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    labelIterationsErr.setText("Error, must be an Integer greater than 0");
                    b = false;
                }

                s = textResolution.getText();
                try {
                    resolution = Integer.parseInt(s);
                    if(iterations == 0){
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    labelResolutionErr.setText("Error, must be an Integer greater than 0");
                    b = false;
                }

                if (b) {
                    stage.close();
                    RenderPopup();
                    ComplexNumber c = new ComplexNumber(Re, Im);
                    ComplexSet fractal = new Julia(
                            4,
                            new ComplexNumber(0, 0),
                            c,
                            iterations,
                            resolution);
                    RenderFractal r = new RenderFractal(fractal);
                    r.render();
                    renderPopup.close();
                    FileNamePopup(r);
                }
            }
        });

        Button btnCancel = new Button();
        btnCancel.setText("Cancel");
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        buttons.getChildren().addAll(btnCancel, btnEnter);


        box.getChildren().addAll(labelRePart, textRePart, labelRePartErr);
        box.getChildren().addAll(labelImPart, textImPart, labelImPartErr);
        box.getChildren().addAll(labelSpan, textSpan, labelSpanErr);
        box.getChildren().addAll(labelIterations, textIterations, labelIterationsErr);
        box.getChildren().addAll(labelResolution, textResolution, labelResolutionErr);
        box.getChildren().add(buttons);

        Scene scene = new Scene(box, 400, 500);
        stage.setScene(scene);
        stage.show();
    }


    private void FileNewMandelbrotSet(){
        Stage stage = new Stage();
        VBox box = new VBox();

        Label labelRePart = new Label("Enter the real part of the Mandelbrot's center");
        TextField textRePart = new TextField();
        Label labelRePartErr = new Label();

        Label labelImPart = new Label("Enter the imaginary part of the Mandelbrot's center");
        TextField textImPart = new TextField();
        Label labelImPartErr = new Label();

        Label labelSpan = new Label("Enter the horizontal span of the Mandelbrot");
        TextField textSpan = new TextField();
        Label labelSpanErr = new Label();

        Label labelIterations = new Label("Enter the number of iterations");
        TextField textIterations = new TextField();
        Label labelIterationsErr = new Label();

        Label labelResolution = new Label("Enter the resolution of the fractal");
        TextField textResolution = new TextField();
        Label labelResolutionErr = new Label();

        HBox buttons = new HBox();
        buttons.setPadding(new Insets(15, 12, 15, 12));
        buttons.setSpacing(10);

        Button btnEnter = new Button();
        btnEnter.setText("Enter");

        btnEnter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s;
                boolean b = true;

                double Re = 0;
                double Im = 0;
                double span = 4;
                int iterations = 1;
                int resolution = 1;

                s = textRePart.getText();
                try { Re = Double.parseDouble(s); } catch (NumberFormatException e) {
                    labelRePartErr.setText("Error, must be a number");
                    b = false;
                }

                s = textImPart.getText();
                try { Im = Double.parseDouble(s); } catch (NumberFormatException e) {
                    labelImPartErr.setText("Error, must be a number");
                    b = false;
                }

                s = textSpan.getText();
                try {
                    span = Double.parseDouble(s);
                    if(span == 0){
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    labelIterationsErr.setText("Error, must be an Number greater than 0");
                    b = false;
                }

                s = textIterations.getText();
                try {
                    iterations = Integer.parseInt(s);
                    if(iterations == 0){
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    labelIterationsErr.setText("Error, must be an Integer greater than 0");
                    b = false;
                }

                s = textResolution.getText();
                try {
                    resolution = Integer.parseInt(s);
                    if(iterations == 0){
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    labelResolutionErr.setText("Error, must be an Integer greater than 0");
                    b = false;
                }

                if (b) {
                    stage.close();
                    RenderPopup();
                    ComplexNumber c = new ComplexNumber(Re, Im);
                    ComplexSet fractal = new Mandelbrot(
                            4,
                            c,
                            iterations,
                            resolution);
                    RenderFractal r = new RenderFractal(fractal);
                    r.render();
                    renderPopup.close();
                    FileNamePopup(r);
                }
            }
        });

        Button btnCancel = new Button();
        btnCancel.setText("Cancel");
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        buttons.getChildren().addAll(btnCancel, btnEnter);


        box.getChildren().addAll(labelRePart, textRePart, labelRePartErr);
        box.getChildren().addAll(labelImPart, textImPart, labelImPartErr);
        box.getChildren().addAll(labelSpan, textSpan, labelSpanErr);
        box.getChildren().addAll(labelIterations, textIterations, labelIterationsErr);
        box.getChildren().addAll(labelResolution, textResolution, labelResolutionErr);
        box.getChildren().add(buttons);

        Scene scene = new Scene(box, 400, 500);
        stage.setScene(scene);
        stage.show();
    }


    private void RenderPopup(){
        renderPopup = new Stage();
        BorderPane bp = new BorderPane();

        Label label = new Label("File is now rendering");
        Button button = new Button("Okay");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                renderPopup.close();
            }
        });

        bp.setCenter(label);
        bp.setBottom(button);
        Scene scene = new Scene(bp, 250, 300);
        renderPopup.setScene(scene);
        renderPopup.show();
    }

    private void FileNamePopup(RenderFractal r){
        ListFiles lf = new ListFiles(rootNode);
        ObservableList<String> list = lf.getList();

        Stage stage = new Stage();
        VBox vbox = new VBox();

        Label labelGetFileName = new Label("Enter filename");
        TextField textFilename = new TextField();

        Button btnEnter = new Button();
        btnEnter.setText("Enter");

        btnEnter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                r.makeJPG(textFilename.getText());
                ListFiles lf = new ListFiles(rootNode);
                lf.listEvent();
                rootNode.bp.setLeft(lf.getListFilesPanel());
                stage.close();
            }
        });

        vbox.getChildren().addAll(labelGetFileName, textFilename, btnEnter);
        Scene scene = new Scene(vbox, 250, 300);
        stage.setScene(scene);
        stage.show();
    }

}
