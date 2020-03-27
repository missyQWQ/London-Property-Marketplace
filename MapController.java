import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import javafx.scene.input.MouseEvent;

/**
 * The map panel to show the geographical view of boroughs 
 * and the number of matched properties they have by using 
 * different size of circles over the boroughs.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
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
        ArrayList<AirbnbListing> data_filterByPrice = new AirbnbDataLoader().priceRange_filter(getMinPrice(), getMaxPrice());

        // Calculate the number of properties in each borough within the selected price range.
        for(AirbnbListing data : data_filterByPrice) {
            for(BoroughInfo boro : boroInfo) {
                if(data.getNeighbourhood().equals(getFullName(boro.getCircleName())))
                    boro.incPropertyNum();
            }
        }

        // Sort the ArrayList "boroInfo" by the number of properties in an ascending order.
        Collections.sort(boroInfo, Comparator.comparing(BoroughInfo::getPropertyNum));

        // Visual indication of how many properties are available in each borough. 
        // A larger circle indicates more properties in the borough.
        // Each borough's full name and the number of properties will be shown in the tooltip.
        int ori_radius = 10;
        int incNum = 0;
        for(BoroughInfo curBoro : boroInfo) {
            if(curBoro.getPropertyNum() == 0) {
                curBoro.getCircle().setVisible(false);
                curBoro.getLabel().setTooltip(new Tooltip(getFullName(curBoro.getCircleName()) + ": no property found."));
            }
            else {
                curBoro.getCircle().setRadius(ori_radius + incNum);
                incNum += 2;
                curBoro.getLabel().setTooltip(new Tooltip(getFullName(curBoro.getCircleName()) + ": " + curBoro.getPropertyNum() + " properties found."));
            }
        }
    }

    /**
     * Click "Back to Welcome" and move to welcome panel.
     * @param e Action event.
     */
    @FXML
    private void backBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/welcome.fxml", "Welcome");
    }

    /**
     * Click "Go to Statistics" and move to statistics panel.
     * @param e Action event.
     */
    @FXML
    private void nextBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/statistics.fxml", "Statistics");
    }

    /**
     *  Click borough's label to see more about the properties in 
     *  that speciﬁc borough.
     *  @param e Mouse event.
     */
    @FXML
    private void presentInfo(MouseEvent e) throws IOException
    {
        String selectedBorough = getFullName(((Node)e.getSource()).getId());
        setSelectedBorough(selectedBorough);
        newWindow("./fxml/propertiesList.fxml", getSelectedBorough());
    }
    
    /**
     *  For different boroughs, return different full name.
     *  @param name The abbreviation of selected borough.
     *  @return The full name of selected borough or null if default.
     */
    private String getFullName(String name)
    {
        switch(name) {
            case "eali_l": case "eali": return "Ealing";
            case "bren_l": case "bren": return "Brent";
            case "redb_l": case "redb": return "Redbridge";
            case "walt_l": case "walt": return "Waltham Forest";
            case "hrgy_l": case "hrgy": return "Haringey";
            case "houn_l": case "houn": return "Hounslow";
            case "enfi_l": case "enfi": return "Enfield";
            case "barn_l": case "barn": return "Barnet";
            case "hrrw_l": case "hrrw": return "Harrow";
            case "hill_l": case "hill": return "Hillingdon";
            case "rich_l": case "rich": return "Richmond upon Thames";
            case "king_l": case "king": return "Kingston upon Thames";
            case "sutt_l": case "sutt": return "Sutton";
            case "croy_l": case "croy": return "Croydon";
            case "brom_l": case "brom": return "Bromley";
            case "bexl_l": case "bexl": return "Bexley";
            case "have_l": case "have": return "Havering";
            case "bark_l": case "bark": return "Barking and Dagenham";
            case "lews_l": case "lews": return "Lewisham";
            case "gwch_l": case "gwch": return "Greenwich";
            case "mert_l": case "mert": return "Merton";
            case "wand_l": case "wand": return "Wandsworth";
            case "hamm_l": case "hamm": return "Hammersmith and Fulham";
            case "kens_l": case "kens": return "Kensington and Chelsea";
            case "wstm_l": case "wstm": return "Westminster";
            case "camd_l": case "camd": return "Camden";
            case "isli_l": case "isli": return "Islington";
            case "city_l": case "city": return "City of London";
            case "hack_l": case "hack": return "Hackney";
            case "towh_l": case "towh": return "Tower Hamlets";
            case "newh_l": case "newh": return "Newham";
            case "sthw_l": case "sthw": return "Southwark";
            case "lamb_l": case "lamb": return "Lambeth";
            default: return null;
        }
    }
}