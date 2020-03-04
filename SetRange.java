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
    static int min = 0;
    static int max = 100;
    /**
     * 
     */
    public SetRange(JFrame frame)
    {
        super(frame,"Warning!",true);
        setBounds(400,400,400,150);
        Container c = getContentPane();
        JLabel l = new JLabel("Please enter the date range.");
        l.setFont(new Font("Arial",Font.BOLD,15));
        c.setLayout(new FlowLayout());
        c.add(l);
    }
    
    public static void newDialog(){
        JFrame f = new JFrame("Welcome to the London Airbnb!");
        f.setBounds(100,100,1000,700);
        f.setDefaultCloseOperation(HIDE_ON_CLOSE);
        Container c = f.getContentPane();
        c.setLayout(null);
        JLabel l1 = new JLabel("Price range:"),l2 = new JLabel("Minimum no. of nights:"),
        l3 = new JLabel("Welcome to the London Airbnb App!"),
        l4 = new JLabel("1.Please select the price range."),
        l5 = new JLabel("2.Please select the minimum no. of nights to stay."),
        l6 = new JLabel("3.Finally, click 'Confirm' to view the list.");
        
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial",Font.BOLD,12));
        l2.setFont(new Font("Arial",Font.BOLD,12));
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l4.setFont(new Font("Arial",Font.BOLD,15));
        l5.setFont(new Font("Arial",Font.BOLD,15));
        l6.setFont(new Font("Arial",Font.BOLD,15));

        JPanel instructions = new JPanel();
        instructions.setLayout(new GridLayout(4,1,5,5));
        instructions.add(l3);
        instructions.add(l4);
        instructions.add(l5);
        instructions.add(l6);
        instructions.setBackground(Color.DARK_GRAY);
        instructions.setBounds(100,50,700,300);
        
        String priceRanges[] = {"0-100","100-200","200-300","300+"};
        JComboBox<String> cb1 = new JComboBox<>(priceRanges);
        cb1.setFocusable(true);
        
        JTextField j1 = new JTextField("");
        cb1.setToolTipText("Select the price per night.");
        j1.setFocusable(true);
        j1.setToolTipText("Select the minimum number of nights to stay.");
        
        JButton btn = new JButton("Confirm");
        btn.setBackground(Color.PINK);
        btn.setFocusable(true);
        btn.setToolTipText("hi");
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(j1.getText().equals("")){
                        SetRange sr = new SetRange(f);
                        sr.setVisible(true);
                    }else{
                        if(cb1.getSelectedIndex() == 1){
                            min = 100;
                            max = 200;
                        }else if(cb1.getSelectedIndex() == 2){
                            min = 200;
                            max = 300;
                        }else if(cb1.getSelectedIndex() == 3){
                            min = 300;
                            max = 5000;
                        }
                        //f.dispose();
                    }
            }
        }); 
        
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1,5,10,10));
        jp.add(l1);
        jp.add(cb1);
        jp.add(l2);
        jp.add(j1);
        jp.add(btn);
        jp.setBounds(250,5,700,30);
        jp.setBackground(Color.DARK_GRAY);
        c.add(jp);
        c.add(instructions);
        c.setBackground(Color.DARK_GRAY);
        f.setVisible(true);
    }
    
    public static int min(){
        return min;
    }
    
    public static int max(){
        return max;
    }
}
