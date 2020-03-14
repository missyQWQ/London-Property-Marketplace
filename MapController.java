import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

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
    @FXML private Label eali_l, bren_l, redb_l, walt_l, hrgy_l, houn_l, enfi_l,
                        barn_l, hrrw_l, hill_l, rich_l, king_l, sutt_l, croy_l,
                        brom_l, bexl_l, have_l, bark_l, lews_l, gwch_l, mert_l,
                        wand_l, hamm_l, kens_l, wstm_l, camd_l, isli_l, city_l,
                        hack_l, towh_l, newh_l, sthw_l, lamb_l;
    
    @FXML
    private void initialize()
    {
        selectedPriceRange.setText(getMinPrice() + " - " + getMaxPrice());
        
        ArrayList<BoroughInfo> boroInfo = new ArrayList<>();
        boroInfo.addAll(Arrays.asList(new BoroughInfo(eali, eali_l), new BoroughInfo(bren, bren_l), new BoroughInfo(redb, redb_l), 
            new BoroughInfo(walt, walt_l), new BoroughInfo(hrgy, hrgy_l), new BoroughInfo(houn, houn_l), new BoroughInfo(enfi, enfi_l), 
            new BoroughInfo(barn, barn_l), new BoroughInfo(hrrw, hrrw_l), new BoroughInfo(hill, hill_l), new BoroughInfo(rich, rich_l),
            new BoroughInfo(king, king_l), new BoroughInfo(sutt, sutt_l), new BoroughInfo(croy, croy_l), new BoroughInfo(brom, brom_l), 
            new BoroughInfo(bexl, bexl_l), new BoroughInfo(have, have_l), new BoroughInfo(bark, bark_l), new BoroughInfo(lews, lews_l), 
            new BoroughInfo(gwch, gwch_l), new BoroughInfo(mert, mert_l), new BoroughInfo(wand, wand_l), new BoroughInfo(hamm, hamm_l), 
            new BoroughInfo(kens, kens_l), new BoroughInfo(wstm, wstm_l), new BoroughInfo(camd, camd_l), new BoroughInfo(isli, isli_l), 
            new BoroughInfo(city, city_l), new BoroughInfo(hack, hack_l), new BoroughInfo(towh, towh_l), new BoroughInfo(newh, newh_l), 
            new BoroughInfo(sthw, sthw_l), new BoroughInfo(lamb, lamb_l)));
        
        // Filter Airbnb data by the selected price range.
        ArrayList<AirbnbListing> data_filterByPrice = priceRange_filter(getMinPrice(), getMaxPrice());
        
        // Calculate the number of properties in each borough within the selected price range.
        for(AirbnbListing data : data_filterByPrice) {
            for(BoroughInfo boro : boroInfo) {
                if(data.getNeighbourhood().equals(boro.getFullName()))
                    boro.incPropertyNum();
            }
        }
        
        // Sort the ArrayList "boroInfo" by the number of properties in an ascending order.
        Collections.sort(boroInfo, Comparator.comparing(BoroughInfo::getPropertyNum));
        // Visual indication of how many properties are available in each borough. A larger circle indicates there are more properties in the borough.
        int ori_radius = 10;
        int incNum = 0;
        for(BoroughInfo curBoro : boroInfo) {
            if(curBoro.getPropertyNum() == 0)
                curBoro.getCircle().setVisible(false);
            else {
                curBoro.getCircle().setRadius(ori_radius + incNum);
                incNum += 2;
            }
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