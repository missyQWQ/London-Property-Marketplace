import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;

/**
 * The panel to welcome the user gives instructions and 
 * choices.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class WelcomeController extends Controller
{
    private ObservableList<Integer> priceChoices = 
        FXCollections.observableArrayList(0, 40, 60, 90, 140, 7000);

    @FXML private ChoiceBox priceFrom;
    @FXML private ChoiceBox priceTo;
    @FXML private Button confirmBtn;
    @FXML private Button backBtn;
    @FXML private Button infoButton; 
    @FXML
    private void initialize()
    {
        // Initialize the choices of price range.
        priceFrom.setItems(priceChoices);
        priceTo.setItems(priceChoices);
        // Set buttons initially disabled.
        confirmBtn.setDisable(true);
        backBtn.setDisable(true);
        // Show which price range is currently selected.
        if(getMinPrice() != -1 && getMaxPrice() != -1) {
            priceFrom.setValue(getMinPrice());
            priceTo.setValue(getMaxPrice());
        }
    }

    /**
     * Enable the buttons when price range has been selected.
     */
    @FXML
    private void checkIfDisable()
    {
        if(priceFrom.getValue() != null && priceTo.getValue() != null) {
            confirmBtn.setDisable(false);
            backBtn.setDisable(false);
        }
    }

    /**
     * Click "Back to My Favourites" and move to favourites panel.
     * Alert user if the price range they selected is invalid.
     * @param e Action event.
     */
    @FXML
    private void backBtnAction(ActionEvent e) throws IOException
    {
        if((Integer)priceFrom.getValue() >= (Integer)priceTo.getValue())
            alertWarning();
        else {
            setMinPrice((Integer)priceFrom.getValue());
            setMaxPrice((Integer)priceTo.getValue());
            changePanel(e, "./fxml/favourites.fxml", "My Favourites");
        }
    }

    /**
     * Click "Confrim" and move to map panel.
     * Alert user if the price range they selected is invalid.
     * @param e Action event.
     */
    @FXML
    private void nextBtnAction(ActionEvent e) throws IOException
    {
        if((Integer)priceFrom.getValue() >= (Integer)priceTo.getValue())
            alertWarning();
        else {
            setMinPrice((Integer)priceFrom.getValue());
            setMaxPrice((Integer)priceTo.getValue());
            changePanel(e, "./fxml/map.fxml", "Map");
        }
    }

    /**
     * Click and get instructions of how to use this app. 
     */
    @FXML
    public void showInstruction() throws IOException{
        newWindow("./fxml/userInstruction.fxml", "Instruction");
    }

    /**
     * Pop up a warning window.
     */
    private void alertWarning() throws IOException
    {
        newWindow("./fxml/warning.fxml", "Warning");
    }
}