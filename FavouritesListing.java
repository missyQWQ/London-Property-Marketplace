import java.util.Set;
import java.util.HashMap;
/**
 * Show the list of favourite properties.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class FavouritesListing
{
    private static HashMap<String, AirbnbListing> favourites = new HashMap<>();
    
    /**
     * Put the related property into the hashmap.
     * @param property The selected property.
     */
    public static void addToFav(AirbnbListing property) 
    {
        favourites.put(property.getName(), property);
    }
    
    /**
     * Remove the related property from the hashmap.
     * @param property The selected property.
     */
    public static void removeFromFav(AirbnbListing property) 
    {
        favourites.remove(property.getName());
    }
    
    /**
     * Get the key set of the hashmap.
     * @return The key set.
     */
    public static Set<String> getFavList()
    {
        return favourites.keySet();
    }
    
    /**
     * The toggle for the property that remove it from or add it 
     * to the hashmap.
     * @param property The selected property.
     */
    public static void toggleFavourite(AirbnbListing property)
    {
        if(isFavourite(property))
            removeFromFav(property);
        else
            addToFav(property);
    }
    
    /**
     * The boolean to show the property is the favourite or not.
     * @param property The selected property.
     * @return If true, return true, or false otherwise.
     */
    public static boolean isFavourite(AirbnbListing property)
    {
        if(favourites.containsKey(property.getName()))
            return true;
        else
            return false;
    }
    
    /**
     * Get the property
     * @param propertyName The name of the property.
     * @return Get the property from favourites.
     */
    public static AirbnbListing getProperty(String propertyName)
    {
        return favourites.get(propertyName);
    }
}