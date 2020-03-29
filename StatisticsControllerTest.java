
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StatisticsControllerTest.
 *
 * @Runlin Zhou, Liangjie Wang, Yichun Zhang, Zejin Deng
 * @27.03.2020
 */
public class StatisticsControllerTest
{
    /**
     * Default constructor for test class StatisticsControllerTest
     */
    public StatisticsControllerTest()
    {
    }

    @Test
    public void testNextInfomation() {
        StatisticsController test1 = new StatisticsController();
        boolean[] isDisplayed = new boolean[8];
        for (int i = 0; i < 8; i++){
            if(i <= 3)
                isDisplayed[i] = true;
            else
                isDisplayed[i]= false;
        }
        int result = test1.getNextStat(1, isDisplayed);
        assertEquals(4 ,result);
    }
    
    @Test
    public void testPrevInfomation() {
        StatisticsController test2 = new StatisticsController();
        boolean[] isDisplayed = new boolean[8];
        for (int i = 0; i < 8; i++){
            if(i <= 3)
                isDisplayed[i] = true;
            else
                isDisplayed[i]= false;
        }
        int result2 = test2.getPrevStat(3, isDisplayed);
        assertEquals(7, result2);
    }
    
    @Before
    public void setUp()
    {
    }
    @After
    public void tearDown()
    {
    }
}
