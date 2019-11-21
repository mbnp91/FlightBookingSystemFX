package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.*;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Computer Science Module Project By Maria Broe Nyberg Pedersen");

        // create a button
        Button b = new Button("show");

        // create a tile pane
        TilePane r = new TilePane();

        // create a label
        Label l = new Label("This is a choice box");

        // string array
        String st[] = {"Arnab", "Andrew", "Ankit", "None"};

        // create a choiceBox
        ChoiceBox<String> c = new ChoiceBox<>(FXCollections.observableArrayList(st));

        // add ChoiceBox
        r.getChildren().add(l);
        r.getChildren().add(c);

        primaryStage.setScene(new Scene(root, 450, 300));
        primaryStage.show();

    }

}


