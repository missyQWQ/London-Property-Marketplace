import javafx.fxml.FXML;
import javafx.scene.control.*;
/**
 * Write a description of class PropertiesListController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PropertiesListController extends Controller
{
    @FXML private Label boroughName;
    
    @FXML
    private void initialize()
    {
        boroughName.setText(getSelectedBorough());
    }
}