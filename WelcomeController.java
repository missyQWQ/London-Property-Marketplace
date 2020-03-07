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
    private ObservableList<Integer> priceChoices = 
            FXCollections.observableArrayList(0, 40, 60, 90, 140, 7000);
    
    @FXML private ChoiceBox priceFrom;
    @FXML private ChoiceBox priceTo;
    @FXML private Button confirmBtn;
    @FXML private Button backBtn;
    
    @FXML
    private void initialize()
    {
        priceFrom.setItems(priceChoices);
        priceTo.setItems(priceChoices);
        // Set buttons initially disabled.
        confirmBtn.setDisable(true);
        backBtn.setDisable(true);
    }
    
    /**
     * Enable the buttons when both of minimum and maximum prices have been selected.
     */
    @FXML
    private void checkIfDisable()
    {
        if(priceFrom.getValue() != null && priceTo.getValue() != null) {
            confirmBtn.setDisable(false);
            backBtn.setDisable(false);
        }
    }
    
    /**
     * When user click the "confrim" button,
     * alert user if the price range they selected is invalid.
     * Otherwise, move to next panel.
     */
    @FXML
    private void confirmBtnAction(ActionEvent event) throws IOException
    {
        if((Integer)priceFrom.getValue() >= (Integer)priceTo.getValue())
            alertWarning();
        else {
            Parent mapPanel = FXMLLoader.load(getClass().getResource("./fxml/map.fxml"));
            Stage mapStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            mapStage.setScene(new Scene(mapPanel));
        }
    }
    
    /**
     * Pop up the warning window.
     */
    private void alertWarning() throws IOException
    {
        Parent warning = FXMLLoader.load(getClass().getResource("./fxml/warning.fxml"));
        Stage warningWindow = new Stage();
        warningWindow.setScene(new Scene(warning));
        warningWindow.initModality(Modality.APPLICATION_MODAL);
        warningWindow.setResizable(false);
        warningWindow.setTitle("Error");
        warningWindow.show();
    }
}