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
import java.util.ArrayList;
import java.util.OptionalDouble;
/**
 * Write a description of JavaFX class MapController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class StatisticsController extends Controller
{
    // Label for the first title box.
    @FXML private Label title1;
    // Label for the second title box.
    @FXML private Label title2;
    // Label for the third title box.
    @FXML private Label title3;
    // Label for the fourth title box.
    @FXML private Label title4;
    // Label for the first information box.
    @FXML private Label info1;
    // Label for the second information box.
    @FXML private Label info2;
    // Label for the third information box.
    @FXML private Label info3;
    // Label for the fourth information box.
    @FXML private Label info4;

    // An array of 8 title to show the properties
    private String[] title = new String[8];
    // An array of 8 information to show the properties
    private String[] information = new String[8];
    // An array of boolean to show shich information are being displayed
    private boolean[] isDisplayed = new boolean[8];
    // An array to show 4 information which are shown on the panel now
    private int[] boxIndex = new int[4];
    private int titleIndex;
    
    @FXML
    private void initialize()
    {
        for (int i = 0; i < 8; i++){
            isDisplayed[i] = false;
        }
        int numberOfPorperty = findAvailableProperty();
        int entiredHome = getNumberOfEntireHomesApartments();
        double averageReviews = getAverageReviews();
        title[0] = "Number of avalible property";
        title[1] = "Average number of reviews";
        title[2] = "The number of entire home";
        title[3] = "The most expensive borough";
        title[4] = "44";
        title[5] = "55";
        title[6] = "66";
        title[7] = "77";

        information[0] = Integer.toString(numberOfPorperty);
        information[1] = Double.toString(averageReviews);
        information[2] = Integer.toString(entiredHome);
        information[3] = getMostExpensiveEntireHomes();
        information[4] = "4";
        information[5] = "5";
        information[6] = "6";
        information[7] = "7";

        title1.setText(title[0]);
        info1.setText(information[0]);  
        boxIndex[0] = 0;
        isDisplayed[0] = true;

        title2.setText(title[1]);
        info2.setText(information[1]);
        isDisplayed[1] = true;
        boxIndex[1] = 1;

        title3.setText(title[2]);
        info3.setText(information[2]);
        isDisplayed[2] = true;
        boxIndex[2] = 2;

        title4.setText(title[3]);
        info4.setText(information[3]);
        isDisplayed[3] = true;
        boxIndex[3] = 3;
    }

    /**
     * Action for the previous button on every of the information box.
     * @param event The action event to trigger the action.
     */
    @FXML
    public void nextButtonAction(ActionEvent event){
        String source = event.getSource().toString();
        source = source.substring(source.indexOf('=') + 1, source.indexOf(','));
        switch (source){
            case "n1" : info1.setText(information[getNextStat(0, isDisplayed)]); 
                        title1.setText(title[titleIndex]);
            break;
            
            case "n2" : info2.setText(information[getNextStat(1, isDisplayed)]);
                        title2.setText(title[titleIndex]);
            break;
            
            case "n3" : info3.setText(information[getNextStat(2, isDisplayed)]);
                        title3.setText(title[titleIndex]);
            break;
            
            case "n4" : info4.setText(information[getNextStat(3, isDisplayed)]);
                        title4.setText(title[titleIndex]);
            break;
        }
    }

    /**
     * Action for the previous button on every of the information box.
     * @param event The action event to trigger the action.
     */
    @FXML
    public void previousButtonAction(ActionEvent event){
        String source = event.getSource().toString();
        source = source.substring(source.indexOf('=') + 1, source.indexOf(','));
        switch (source){
            case "p1" : info1.setText(information[getPrevStat(0, isDisplayed)]);
                        title1.setText(title[titleIndex]);
            break;
            
            case "p2" : info2.setText(information[getPrevStat(1, isDisplayed)]);
                        title2.setText(title[titleIndex]);
            break;
            
            case "p3" : info3.setText(information[getPrevStat(2, isDisplayed)]);
                        title3.setText(title[titleIndex]);
            break;
            
            case "p4" : info4.setText(information[getPrevStat(3, isDisplayed)]);
                        title4.setText(title[titleIndex]);
            break;
        }
    }

    /**
     * Return the index of the information which has not been displayed
     * on the panel as the new information.
     * @param boxNumber The number of box.
     * @param isDisplayed The boolean to show the information 
     * has been displayed or not.
     * @return statIndex The index of the suitable information.
     */
    public int getNextStat(int boxNumber, boolean[] isDisplayed){
        int statIndex = boxIndex[boxNumber];  
        isDisplayed[statIndex] = false;
        statIndex = (statIndex + 1) % 8;
        while(isDisplayed[statIndex]){
            statIndex = (statIndex + 1) % 8;
        }
        boxIndex[boxNumber] = statIndex;
        isDisplayed[statIndex] = true;
        this.titleIndex = statIndex;
        return statIndex;
    }
    
    /**
     * Return the index of the information which has not been displayed
     * on the panel as the new information.
     * @param boxNumber The number of box.
     * @param isDisplayed The boolean to show the information 
     * has been displayed or not.
     * @return statIndex The index of the suitable information.
     */
    public int getPrevStat(int statBoxNumber, boolean[] isDisplayed){
        int statIndex = boxIndex[statBoxNumber];
        isDisplayed[statIndex] = false;

        if (statIndex == 0)
            statIndex = 7;
        else
            --statIndex;

        while(isDisplayed[statIndex]){
            if (statIndex == 0)
                statIndex = 7;
            else
                --statIndex;
        }
        boxIndex[statBoxNumber] = statIndex;
        isDisplayed[statIndex] = true;
        this.titleIndex = statIndex;
        return statIndex;
    }

    /**
     * Click "Back to Map" and move to map panel.
     */
    @FXML
    private void backBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/map.fxml", "Map");
    }

    /**
     * Click "Go to My Favourites" and move to favourites panel.
     */
    @FXML
    private void nextBtnAction(ActionEvent e) throws IOException
    {
        changePanel(e, "./fxml/favourites.fxml", "My Favourites");
    }

    public int findAvailableProperty(){
        ArrayList<AirbnbListing> properties = new AirbnbDataLoader().priceRange_filter(getMinPrice(), getMaxPrice());
        return properties.size();
    }
    
    public double getAverageReviews() {     
        ArrayList<AirbnbListing> listings = new AirbnbDataLoader().priceRange_filter(getMinPrice(), getMaxPrice());
        OptionalDouble result = listings.stream().mapToInt(AirbnbListing::getNumberOfReviews).average();

        return result.getAsDouble();
    }
    
        public String getMostExpensiveEntireHomes() {
        ArrayList<AirbnbListing> properties = new AirbnbDataLoader().priceRange_filter(getMinPrice(), getMaxPrice());
        String highestPricedHome = "null";
        int highestPrice = 0;
        for (AirbnbListing property : properties) {
            if (property.getPrice() > highestPrice) {
                highestPricedHome = property.getName();
            }
        }
        return highestPricedHome;
    }
        public int getNumberOfEntireHomesApartments() {
        return new AirbnbDataLoader().priceRange_filter(getMinPrice(), getMaxPrice()).size();
    }
}