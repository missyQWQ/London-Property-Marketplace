import java.util.Set;
import java.util.HashMap;
/**
 * Write a description of class FavouritesListing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FavouritesListing
{
    private static HashMap<String, AirbnbListing> favourites = new HashMap<>();
    
    public static void addToFav(AirbnbListing property) 
    {
        favourites.put(property.getName(), property);
    }
    
    public static void removeFromFav(AirbnbListing property) 
    {
        favourites.remove(property.getName());
    }
    
    public static Set<String> getFavList()
    {
        return favourites.keySet();
    }
    
    public static void toggleFavourite(AirbnbListing property)
    {
        if(isFavourite(property))
            removeFromFav(property);
        else
            addToFav(property);
    }
    
    public static boolean isFavourite(AirbnbListing property)
    {
        if(favourites.containsKey(property.getName()))
            return true;
        else
            return false;
    }
    
    public static AirbnbListing getProperty(String propertyName)
    {
        return favourites.get(propertyName);
    }
}