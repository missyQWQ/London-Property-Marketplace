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
        System.out.println("after add: "+favourites.entrySet());
    }
    
    public static void removeFromFav(AirbnbListing property)
    {
        favourites.remove(property.getName());
        System.out.println("after delete: "+favourites.entrySet());
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