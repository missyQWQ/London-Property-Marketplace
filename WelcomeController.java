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
        FXCollections.observableArrayList("0", "40","60","90","140","7000");
    
    @FXML
    private ChoiceBox priceFrom;
    
    @FXML
    private ChoiceBox priceTo;
    
    @FXML
    private Button confirmBtn;
    
    @FXML
    private void initialize(){
        priceFrom.setItems(priceChoices);
        priceTo.setItems(priceChoices);
        
        confirmBtn.setDisable(true);
    }
    
    @FXML
    private void checkIfDisable()
    {
        if(priceFrom.getValue() != null && priceTo.getValue() != null) {
            confirmBtn.setDisable(false);
        }
    }
    
    @FXML
    public void confirmBtnAction(ActionEvent event) throws IOException{
        if(priceFrom.getValue() == null || priceTo.getValue() == null){
            createWarningBox();
        }else{
            
                Parent mapPanel = FXMLLoader.load(getClass().getResource("map.fxml"));
                Stage mapStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                mapStage.setScene(new Scene(mapPanel));
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