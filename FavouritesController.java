import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * Write a description of class FavouritesController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FavouritesController extends Controller
{
    @FXML private ListView favouritesList;
    @FXML private Label hostName;
    @FXML private Label neighbourhood;
    @FXML private Label roomType;
    @FXML private Label price;
    
    @FXML
    private void initialize()
    {
        
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
    private void presentDetailBtn(ActionEvent e)
    {
    
    }
}