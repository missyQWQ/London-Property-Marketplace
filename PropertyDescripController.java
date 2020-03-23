import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
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
    @FXML WebView propertyStreetView;
    
    @FXML
    private void initialize()
    {
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
    }
}
