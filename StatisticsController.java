import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
/**
 * Write a description of JavaFX class MapController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StatisticsController extends Controller
{
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
}