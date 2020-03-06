import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

// import javafx.application.Application;
 import javafx.event.ActionEvent;
 import javafx.event.EventHandler;
 import javafx.scene.Node;
 import javafx.scene.Scene;
 import javafx.scene.Parent;
 import javafx.stage.Stage;
 import javafx.stage.Modality;
// import javafx.scene.layout.*;
// import java.net.URL;
 import javafx.fxml.FXMLLoader;
import java.io.IOException;

/**
 * Write a description of JavaFX class Welcome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WelcomeController
{
    private ObservableList<String> priceChoices = 
        FXCollections.observableArrayList("below 50", "50-100","100-150","150-200","over 200");
    
    @FXML
    private ChoiceBox priceRange;
    
    @FXML
    private TextField minNights;
    
    @FXML
    private Button confirm;
    @FXML
    private void initialize(){
        priceRange.setItems(priceChoices);
    }
    
    @FXML
    public void confirmAction(ActionEvent event) throws IOException{
        if(priceRange.getValue() == null){
            createWarningBox();
        }else{
            if(minNights.getText().isEmpty()){
                Parent mapPanel = FXMLLoader.load(getClass().getResource("map.fxml"));
                Stage mapStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                mapStage.setScene(new Scene(mapPanel));
            }
        }
    }
    
    private void createWarningBox() throws IOException{
        Parent warning = FXMLLoader.load(getClass().getResource("warning.fxml"));
        Stage warningBox = new Stage();
        warningBox.setTitle("Error!");
        warningBox.initModality(Modality.APPLICATION_MODAL);
        warningBox.setScene(new Scene(warning));
        warningBox.setResizable(false);
        warningBox.show();
    }
}