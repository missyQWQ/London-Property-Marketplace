import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * The frame to set price range.
 * @author Liangjie Wang
 * @vision 4.3.2020
 */
public class SetRange extends JDialog
{
    static int min;
    static int max;
    /**
     * 
     */
    public SetRange(JFrame frame)
    {
        super(frame,"Warning!",true);
        setBounds(400,400,400,150);
        Container c = getContentPane();
        JLabel l = new JLabel("Please enter both min and max.");
        l.setFont(new Font("Arial",Font.BOLD,15));
        c.setLayout(new FlowLayout());
        c.add(l);
    }
    
    public static void newDialog(){
        JFrame f = new JFrame("Set price range");
        f.setBounds(200,200,300,200);
        f.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Container c = f.getContentPane();
        c.setLayout(null);
        JLabel l1 = new JLabel("Min"),l2 = new JLabel("Max"), l3 = new JLabel("Which price range would you expect?");
        l3.setFont(new Font("Lucida Calligraphy",Font.BOLD,12));
        JTextField j1 = new JTextField(),j2 = new JTextField();
        JButton btn = new JButton("Confirm");

        l1.setBounds(30,30,60,20);
        l2.setBounds(180,30,60,20);
        l3.setBounds(5,5,300,20);
        j1.setBounds(30,60,80,30);
        j2.setBounds(180,60,80,30);
        btn.setBounds(105,100,80,30);
        btn.setBackground(Color.PINK);
        c.add(l3);
        c.add(l1);
        c.add(l2);
        c.add(j1);
        c.add(j2);
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(j1.getText().equals("")||j2.getText().equals("")){
                        SetRange sr = new SetRange(f);
			sr.setVisible(true);
                    }else{
                        min = Integer.valueOf(j1.getText()).intValue();
                        max = Integer.valueOf(j2.getText()).intValue();
                        if(max < min){
                            int temp = min;
                            min = max;
                            max = temp;
                        }
                        f.dispose();
                    }
            }
        });		
        f.setVisible(true);
    }

    public static int min(){
        return min;
    }
    
    public static int max(){
        return max;
    }
}
