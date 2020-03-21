import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * Write a description of class PropertiesListController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PropertiesListController extends Controller
{
    @FXML private Label boroughName;
    @FXML private TableView propertiesTable;
    @FXML private TableColumn propertyName;
    @FXML private TableColumn hostName;
    @FXML private TableColumn price;
    @FXML private TableColumn numOfReviews;
    @FXML private TableColumn minNights;
    
    @FXML
    private void initialize()
    {
        boroughName.setText(getSelectedBorough());
        
        ArrayList<AirbnbListing> data_filterByPriceAndBorough = new AirbnbDataLoader().priceAndBorough_filter(getMinPrice(), getMaxPrice(), getSelectedBorough());
        ObservableList<AirbnbListing> properties = FXCollections.observableArrayList(data_filterByPriceAndBorough);
        
        propertyName.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("name"));
        hostName.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("host_name"));
        price.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("price"));
        numOfReviews.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("numberOfReviews"));
        minNights.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("minimumNights"));
        
        propertiesTable.setItems(properties);
    }
}