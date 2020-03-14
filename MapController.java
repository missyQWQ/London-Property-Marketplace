import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Arrays;
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
        
        ArrayList<BoroughInfo> boroInfo = new ArrayList<>();
        boroInfo.addAll(Arrays.asList(new BoroughInfo(eali), new BoroughInfo(bren), new BoroughInfo(redb), new BoroughInfo(walt), new BoroughInfo(hrgy),
               new BoroughInfo(houn), new BoroughInfo(enfi), new BoroughInfo(barn), new BoroughInfo(hrrw), new BoroughInfo(hill), new BoroughInfo(rich),
               new BoroughInfo(king), new BoroughInfo(sutt), new BoroughInfo(croy), new BoroughInfo(brom), new BoroughInfo(bexl), new BoroughInfo(have),
               new BoroughInfo(bark), new BoroughInfo(lews), new BoroughInfo(gwch), new BoroughInfo(mert), new BoroughInfo(wand), new BoroughInfo(hamm), 
               new BoroughInfo(kens), new BoroughInfo(wstm), new BoroughInfo(camd), new BoroughInfo(isli), new BoroughInfo(city), new BoroughInfo(hack),
               new BoroughInfo(towh), new BoroughInfo(newh), new BoroughInfo(sthw), new BoroughInfo(lamb)));
        
        ArrayList<AirbnbListing> data_filterByPrice = priceRange_filter(getMinPrice(), getMaxPrice());
        
        for(AirbnbListing data : data_filterByPrice) {
            for(BoroughInfo boro : boroInfo) {
                if(data.getNeighbourhood().equals(boro.getFullName()))
                    boro.incPropertyNum();
            }
        }
        
        for(BoroughInfo boro2 : boroInfo) {
                System.out.println(boro2.getFullName() + " : " + boro2.getPropertyNum());
            }
        
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
    
    private ArrayList<AirbnbListing> priceRange_filter(int minPrice, int maxPrice)
    {
        ArrayList<AirbnbListing> totalData = new AirbnbDataLoader().load();
        ArrayList<AirbnbListing> data = new ArrayList<>();
        for(AirbnbListing list : totalData) {
            if(list.getPrice() >= minPrice && list.getPrice() <= maxPrice)
                data.add(list);
        }
        return data;
    }
}