import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
/**
 * Write a description of class BoroughInfo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoroughInfo
{
    private Circle circle;
    private Label label;
    private String name;
    private String fullName;
    private int propertyNumber;
    
    /**
     * Constructor for objects of class BoroughInfo
     */
    public BoroughInfo(Circle circle, Label label)
    {
        this.circle = circle;
        this.label = label;
        name = circle.getId();
        fullName = getFullName(name);
        propertyNumber = 0;
    }

    public String getFullName()
    {
        return fullName;
    }
    
    public int getPropertyNum()
    {
        return propertyNumber;
    }
    
    public void incPropertyNum()
    {
        propertyNumber++;
    }
    
    public Circle getCircle()
    {
        return circle;
    }
    
    public Label getLabel()
    {
        return label;
    }
    
    private String getFullName(String name)
    {
        switch(name) {
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