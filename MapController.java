import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
/**
 * Write a description of JavaFX class MapController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapController extends Controller
{
    /**
     * Click "Back to Welcome" and move to welcome panel.
     */
    @FXML
    protected void backBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/welcome.fxml", "Welcome");
    }
    
    /**
     * Click "Go to Statistics" and move to statistics panel.
     */
    @FXML
    protected void nextBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/statistics.fxml", "Statistics");
    }
}