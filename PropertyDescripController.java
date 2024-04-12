import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.event.ActionEvent;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
/**
 * A window to show all the information of the selected
 * property from the list of properties. It can also show 
 * the map view of the location on painted view or the 
 * real street view, and add to favourites if you like it.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
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
     * @param e Action event.
     */
    @FXML
    private void streetView(ActionEvent e) throws Exception
    {
       URI uri = new URI("https://www.google.com/maps/@?api=1&map_action=pano&viewpoint=" + 
                                getSelectedProperty().getLatitude() + "," + getSelectedProperty().getLongitude() + 
                                "&heading=-45&pitch=0&fov=50");
       java.awt.Desktop.getDesktop().browse(uri);
    }
    
    /**
     * Click 'Add to Favourites !' button and add the clicked 
     * property to the facourites list.
     * @param e Action event.
     */
    @FXML
    private void addToFavourites(ActionEvent e)
    {
        FavouritesListing.toggleFavourite(getSelectedProperty());
        addToFavBtn.setText(getIsFavouriteString());
    }
    
    /**
     * The string on the button will change to 'Cancel Favourite',
     * if the selected property is already the user's favourite.
     * @return String The string to represent different states.
     */
    private String getIsFavouriteString()
    {
        if(FavouritesListing.isFavourite(getSelectedProperty()))
            return "Cancel Favourite";
        else
            return "Add to Favourites !";
    }
}