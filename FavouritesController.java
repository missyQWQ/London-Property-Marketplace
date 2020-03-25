import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
/**
 * Write a description of class FavouritesController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FavouritesController extends Controller
{
    private ObservableList<String> favList;
    
    @FXML private ListView favouritesList;
    @FXML private Label hostName;
    @FXML private Label neighbourhood;
    @FXML private Label roomType;
    @FXML private Label price;
    
    @FXML
    private void initialize()
    {
        loadFavListView();
    }
    
    /**
     * Click "Back to Statistics" and move to statistics panel.
     */
    @FXML
    private void backBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/statistics.fxml", "Statistics");
    }
    
    /**
     * Click "Go to Welcome" and move to welcome panel.
     */
    @FXML
    private void nextBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/welcome.fxml", "Welcome");
    }
    
    @FXML
    private void displaySelected(MouseEvent e)
    {
        String selectedFav = (String)(favouritesList.getSelectionModel().getSelectedItem());
        if(selectedFav != null && !selectedFav.isEmpty()) {
            AirbnbListing selectedProperty = FavouritesListing.getProperty(selectedFav);
            hostName.setText(selectedProperty.getHost_name());
            neighbourhood.setText(selectedProperty.getNeighbourhood());
            roomType.setText(selectedProperty.getRoom_type());
            price.setText(Integer.toString(selectedProperty.getPrice()));
        }
    }
    
    @FXML
    private void presentDetailBtn(ActionEvent e)
    {
    
    }
    
    private void loadFavListView()
    {
        favList = FXCollections.observableArrayList(FavouritesListing.getFavList());
        favouritesList.getItems().addAll(favList);
    }
}