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
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Write a description of JavaFX class MapController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class StatisticsController extends Controller
{

    private MapController mapData;

    @FXML private Label info1;
    @FXML private Label info2;
    @FXML private Label info3;
    @FXML private Label info4;

    @FXML
    private void initialize()
    {
        
    }

    /**
     * Click "Back to Map" and move to map panel.
     */
    @FXML
    protected void backBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/map.fxml", "Map");
    }

    /**
     * Click "Go to Welcome" and move to welcome panel.
     */
    @FXML
    protected void nextBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/welcome.fxml", "Welcome");
    }

    public int findAvailableProperty(){
        ArrayList<AirbnbListing> properties = mapData.priceRange_filter(getMinPrice(), getMaxPrice());
        return properties.size();  
    }
}