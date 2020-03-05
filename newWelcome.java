import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.*;
import javax.swing.*;

import java.io.IOException;

/**
 * 
 */
public class newWelcome
{
    @FXML private ComboBox priceRange;

    // Goes to the next panel
    @FXML private Button confirm;

    // Allows the user to enter the minimum number of nights
    @FXML private TextField minNights;

    /**
     * Creates the Welcome Panel using the welcome.fxml
     */
    @FXML
    public void createWelcomePanel(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomePanel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);   // So that the window cannot be resized
        stage.show();
         
        
    }
    @FXML
    private void initialize(){
        minNights.setTooltip(new Tooltip("Minimum Number of Nights for Stay"));
        priceRange.setItems(FXCollections.observableArrayList(
                "Upto 25", "25 - 50", "50 - 75", "75 - 100", "100 - 150", "Above 150")
        );
        priceRange.setTooltip(new Tooltip("Select the per night price range for the properties"));

        confirm.setTooltip(new Tooltip("Preview the results on a map"));
        confirm.setDisable(true);
    }
    
    
}


