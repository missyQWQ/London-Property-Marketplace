import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
/**
 * Show the information of boroughs.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class BoroughInfo
{
    private Circle circle;
    private Label label;
    private String circleName;
    private int propertyNumber;
    
    /**
     * Constructor for objects of class BoroughInfo
     */
    public BoroughInfo(Circle circle, Label label)
    {
        this.circle = circle;
        this.label = label;
        circleName = circle.getId();
        propertyNumber = 0;
    }
    
    /**
     * Get the name of circle.
     * @return circleName
     */
    public String getCircleName()
    {
        return circleName;
    }
    
    /**
     * Get the number of property.
     * @return propertyNumber
     */
    public int getPropertyNum()
    {
        return propertyNumber;
    }
    
    /**
     * Increment the number of properties.
     */
    public void incPropertyNum()
    {
        propertyNumber++;
    }
    
    /**
     * Get the circle.
     * @return circle
     */
    public Circle getCircle()
    {
        return circle;
    }
    
    /**
     * Get the label.
     * @return label
     */
    public Label getLabel()
    {
        return label;
    }
    
}