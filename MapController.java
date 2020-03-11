import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
/**
 * Write a description of JavaFX class MapController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapController
{
    /**
     * When user click the "Back to Welcome" button, move to welcome panel.
     */
    @FXML
    private void backBtnAction(ActionEvent e) throws IOException
    {
        Pane welcomePanel = FXMLLoader.load(getClass().getResource("./fxml/welcome.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(welcomePanel));
    }
}
