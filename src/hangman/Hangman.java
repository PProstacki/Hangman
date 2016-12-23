package hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Hangman extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = (Pane) FXMLLoader.load(Hangman.class.getResource("FXML.fxml"));
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
    
}
