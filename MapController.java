import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
/**
 * Write a description of JavaFX class MapController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapController extends Controller
{
    @FXML private Label selectedPriceRange;
    @FXML private Circle eali, bren, redb, walt, hrgy, houn, enfi,
                         barn, hrrw, hill, rich, king, sutt, croy,
                         brom, bexl, have, bark, lews, gwch, mert,
                         wand, hamm, kens, wstm, camd, isli, city,
                         hack, towh, newh, sthw, lamb;
    
    @FXML
    private void initialize()
    {
        selectedPriceRange.setText(getMinPrice() + " - " + getMaxPrice());
        
        ArrayList<AirbnbListing> data_filterByPrice = AirbnbDataFilter.priceRange_filter(new AirbnbDataLoader().load(), getMinPrice(), getMaxPrice());
    }
    
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
    
    private String getFullName(String labelName)
    {
        switch(labelName) {
            case "eali": return "Ealing";
            case "bren": return "Brent";
            case "redb": return "Redbridge";
            case "walt": return "Waltham Forest";
            case "hrgy": return "Haringey";
            case "houn": return "Hounslow";
            case "enfi": return "Enfield";
            case "barn": return "Barnet";
            case "hrrw": return "Harrow";
            case "hill": return "Hillingdon";
            case "rich": return "Richmond upon Thames";
            case "king": return "Kingston upon Thames";
            case "sutt": return "Sutton";
            case "croy": return "Croydon";
            case "brom": return "Bromley";
            case "bexl": return "Bexley";
            case "have": return "Havering";
            case "bark": return "Barking and Dagenham";
            case "lews": return "Lewisham";
            case "gwch": return "Greenwich";
            case "mert": return "Merton";
            case "wand": return "Wandsworth";
            case "hamm": return "Hammersmith and Fulham";
            case "kens": return "Kensington and Chelsea";
            case "wstm": return "Westminster";
            case "camd": return "Camden";
            case "isli": return "Islington";
            case "city": return "City of London";
            case "hack": return "Hackney";
            case "towh": return "Tower Hamlets";
            case "newh": return "Newham";
            case "sthw": return "Southwark";
            case "lamb": return "Lambeth";
            default: return null;
        }
    }
}