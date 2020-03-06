import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import javafx.scene.layout.*;
// import java.net.URL;
// import javafx.fxml.FXMLLoader;

/**
 * Write a description of JavaFX class Welcome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WelcomeController
{
    private ObservableList<String> priceChoices = 
        FXCollections.observableArrayList("apples", "oranges");
    
    @FXML
    private ChoiceBox priceRange;
    
    @FXML
    private void initialize(){
        priceRange.setItems(priceChoices);
    }
}