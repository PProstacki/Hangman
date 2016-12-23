package hangman;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    @FXML
    Button bStart;
    @FXML
    Label lCategory;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void startGame(ActionEvent e){
        GameCourse game = new GameCourse();
        game.setWords();
        lCategory.setText("Kategoria: " + game.getCategory());
        
    }
    
}
//button.arm/disarm - wklikniecie 