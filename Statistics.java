import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * 
 *
 * @author (Runlin Zhou)
 * @version (2020.3.6)
 */
public class Statistics extends JFrame
{
    /**
     * Constructor for objects of class Statics
     */
    public Statistics()
    {
        setTitle("Statistics");
        setBounds(300,200,1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JPanel A = new JPanel();
        A.setLayout(new FlowLayout());
        
        
        A.setBounds(0,0,640,300);
        A.setBackground(Color.red);
        c.add(A);
        
        JPanel B = new JPanel();
        B.setLayout(new FlowLayout());
        
        
        B.setBounds(640,0,640,300);
        B.setBackground(Color.green);
        c.add(B);
        
        JPanel C = new JPanel();
        C.setLayout(new FlowLayout());
        
        
        C.setBounds(0,300,640,300);
        C.setBackground(Color.pink);
        c.add(C);
        
        JPanel D = new JPanel();
        D.setLayout(new FlowLayout());
        
        
        D.setBounds(640,300,640,300);
        D.setBackground(Color.yellow);
        c.add(D);
        
        
        setVisible(true);
    }
}
