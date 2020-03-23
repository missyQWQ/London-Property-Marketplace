import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Node;
import javafx.scene.Scene;
import java.io.IOException;

/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    protected void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }
    
    protected int getMinPrice()
    {
        return minPrice;
    }
    
    protected void setMaxPrice(int maxPrice)
    {
        this.maxPrice = maxPrice;
    }
    
    protected int getMaxPrice()
    {
        return maxPrice;
    }
    
    protected void setSelectedBorough(String selectedBorough)
    {
        this.selectedBorough = selectedBorough;
    }
    
    protected String getSelectedBorough()
    {
        return selectedBorough;
    }
    
    protected void setSelectedProperty(AirbnbListing selectedProperty)
    {
        this.selectedProperty = selectedProperty;
    }
    
    protected AirbnbListing getSelectedProperty()
    {
        return selectedProperty;
    }
}