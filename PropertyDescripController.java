import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.event.ActionEvent;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * Write a description of class PropertyDescrip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PropertyDescripController extends Controller
{
    @FXML Label propertyTitle;
    @FXML Label propertyId;
    @FXML Label propertyName;
    @FXML Label hostId;
    @FXML Label hostName;
    @FXML Label neighbourhood;
    @FXML Label price;
    @FXML Label roomType;
    @FXML Label minNights;
    @FXML Label reviewsNum;
    @FXML WebView propertyLocation;
    @FXML Button addToFavBtn;
    
    @FXML
    private void initialize()
    {
        addToFavBtn.setText(getIsFavouriteString());
        
        propertyTitle.setText(getSelectedProperty().getName());
        propertyId.setText(getSelectedProperty().getId());
        propertyName.setText(getSelectedProperty().getName());
        hostId.setText(getSelectedProperty().getHost_id());
        hostName.setText(getSelectedProperty().getHost_name());
        neighbourhood.setText(getSelectedProperty().getNeighbourhood());
        price.setText(Integer.toString(getSelectedProperty().getPrice()));
        roomType.setText(getSelectedProperty().getRoom_type());
        minNights.setText(Integer.toString(getSelectedProperty().getMinimumNights()));
        reviewsNum.setText(Integer.toString(getSelectedProperty().getNumberOfReviews()));
        
        WebEngine locEngine = propertyLocation.getEngine();
        String locURL = "https://www.google.com/maps/place/" + getSelectedProperty().getLatitude() + "," + getSelectedProperty().getLongitude();
        locEngine.load(locURL);
    }
    
    /**
     * Opens default browser to show the street view of current location.
     */
    @FXML
    private void streetView(ActionEvent e) throws Exception
    {
       URI uri = new URI("https://www.google.com/maps/@?api=1&map_action=pano&viewpoint=" + 
                                getSelectedProperty().getLatitude() + "," + getSelectedProperty().getLongitude() + 
                                "&heading=-45&pitch=0&fov=50");
       java.awt.Desktop.getDesktop().browse(uri);
    }
    
    @FXML
    private void addToFavourites(ActionEvent e)
    {
        FavouritesListing.toggleFavourite(getSelectedProperty());
        addToFavBtn.setText(getIsFavouriteString());
    }
    
    private String getIsFavouriteString()
    {
        if(FavouritesListing.isFavourite(getSelectedProperty()))
            return "Cancel Favourite";
        else
            return "Add to Favourites !";
    }
}