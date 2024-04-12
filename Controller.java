import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Node;
import javafx.scene.Scene;
import java.io.IOException;

/**
 * Give methods to be used or implemented in the subclasses 
 * of controller.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public abstract class Controller
{
    // Set default as -1 indicating no price range has been selected yet.
    private static int minPrice = -1;
    private static int maxPrice = -1;
    private static String selectedBorough = null;
    private static AirbnbListing selectedProperty = null;

    /**
     * Move to another panel.
     * @param e Current action event
     * @param url Address of the panel's fxml file
     * @param title Panel's title
     * @throws IOException
     */
    protected void changePanel(ActionEvent e, String url, String title) throws IOException
    {
        Parent panel = FXMLLoader.load(getClass().getResource(url));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(panel));
        stage.setTitle(title);
    }
    
    /**
     * Create a new window.
     * @param url Address of the window's fxml file
     * @param title Window's title
     * @throws IOException
     */
    protected void newWindow(String url, String title) throws IOException
    {
        Parent panel = FXMLLoader.load(getClass().getResource(url));
        Stage window = new Stage();
        window.setScene(new Scene(panel));
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setResizable(false);
        window.show();
    }
    
    /**
     * Set min price.
     * @param minPrice The min price.
     */
    protected void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }
    
    /**
     * Get min price.
     * @return minPrice
     */
    protected int getMinPrice()
    {
        return minPrice;
    }
    
    /**
     * Set max price.
     * @param maxPrice The max price.
     */
    protected void setMaxPrice(int maxPrice)
    {
        this.maxPrice = maxPrice;
    }
    
    /**
     * Get max price.
     * @return maxPrice
     */
    protected int getMaxPrice()
    {
        return maxPrice;
    }
    
    /**
     * Set selected borough.
     * @param selectedBorough The selected borough.
     */
    protected void setSelectedBorough(String selectedBorough)
    {
        this.selectedBorough = selectedBorough;
    }
    
    /**
     * Get selected borough.
     * @return selectedBorough
     */
    protected String getSelectedBorough()
    {
        return selectedBorough;
    }
    
    /**
     * Set selected property.
     * @param selectedProperty The selected property.
     */
    protected void setSelectedProperty(AirbnbListing selectedProperty)
    {
        this.selectedProperty = selectedProperty;
    }
    
    /**
     * Get selected property.
     * @return selectedProperty
     */
    protected AirbnbListing getSelectedProperty()
    {
        return selectedProperty;
    }
}