import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import javafx.scene.input.MouseEvent;

/**
 * A window to show some information of all the properties 
 * from the selected borough.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class PropertiesListController extends Controller
{
    private ObservableList<String> sortChoices = 
            FXCollections.observableArrayList("Number of reviews (ascending)", "Number of reviews (descending)", 
            "Price (ascending)", "Price (descending)", "Host name (a-z)", "Host name (z-a)");
    private ObservableList<AirbnbListing> properties;
    
    @FXML private Label boroughName;
    @FXML private ChoiceBox sortBy;
    @FXML private TableView propertiesTable;
    @FXML private TableColumn propertyName;
    @FXML private TableColumn hostName;
    @FXML private TableColumn price;
    @FXML private TableColumn numOfReviews;
    @FXML private TableColumn minNights;
    
    @FXML
    private void initialize()
    {
        // Initialize borough's full name as title.
        boroughName.setText(getSelectedBorough());
        
        // Initialize choice box of sorting method.
        sortBy.setItems(sortChoices);
        
        // Prepare data which need to be shown in table.
        ArrayList<AirbnbListing> data_filterByPriceAndBorough = new AirbnbDataLoader().priceAndBorough_filter(getMinPrice(), getMaxPrice(), getSelectedBorough());
        properties = FXCollections.observableArrayList(data_filterByPriceAndBorough);
        
        propertyName.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("name"));
        hostName.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("host_name"));
        price.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("price"));
        numOfReviews.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("numberOfReviews"));
        minNights.setCellValueFactory(new PropertyValueFactory<AirbnbListing, String>("minimumNights"));
        
        propertiesTable.setItems(properties);
    }
    
    /**
     *  Sort the properties list when making a selection from the choice box.
     */
    @FXML
    private void sortList()
    {
        if(sortBy.getValue() != null) {
            switch(sortBy.getValue().toString()) {
                case "Number of reviews (ascending)": 
                    Collections.sort(properties, Comparator.comparing(AirbnbListing::getNumberOfReviews)); 
                    break;
                case "Number of reviews (descending)":
                    Collections.sort(properties, Comparator.comparing(AirbnbListing::getNumberOfReviews));
                    Collections.reverse(properties);
                    break;
                case "Price (ascending)":
                    Collections.sort(properties, Comparator.comparing(AirbnbListing::getPrice)); 
                    break;
                case "Price (descending)":
                    Collections.sort(properties, Comparator.comparing(AirbnbListing::getPrice));
                    Collections.reverse(properties);
                    break;
                case "Host name (a-z)":
                    Collections.sort(properties, Comparator.comparing(AirbnbListing::getHost_name)); 
                    break;
                case "Host name (z-a)":
                    Collections.sort(properties, Comparator.comparing(AirbnbListing::getHost_name));
                    Collections.reverse(properties);
                    break;
                default:
                    System.out.println("Invalid sorting method.");
            }
        }
        propertiesTable.setItems(properties);
    }
    
    /**
     * Showing description of the property in a new window when one of 
     * the properties is clicked.
     * @param e Mouse event.
     */
    @FXML
    private void showProperty(MouseEvent e) throws IOException
    {
        setSelectedProperty((AirbnbListing)(propertiesTable.getSelectionModel().getSelectedItem()));
        newWindow("./fxml/propertyDescrip.fxml", "Property Description");
    }
}