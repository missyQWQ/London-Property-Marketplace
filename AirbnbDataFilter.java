import java.util.ArrayList;
/**
 * Write a description of class AirbnbDataFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AirbnbDataFilter
{
    public static ArrayList<AirbnbListing> priceRange_filter(ArrayList<AirbnbListing> totalData, int minPrice, int maxPrice)
    {
        ArrayList<AirbnbListing> data = new ArrayList<>();
        for(AirbnbListing list : totalData) {
            if(list.getPrice() >= minPrice && list.getPrice() <= maxPrice)
                data.add(list);
        }
        return data;
    }
    
    public static ArrayList<AirbnbListing> borough_filter(ArrayList<AirbnbListing> totalData, String boroughName)
    {
        ArrayList<AirbnbListing> data = new ArrayList<>();
        for(AirbnbListing list : totalData) {
            if(list.getNeighbourhood().equals(boroughName))
                data.add(list);
        }
        return data;
    }
}