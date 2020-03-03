import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * The frame to set price range.
 * @author Liangjie Wang
 * @vision 3.3.2020
 */
public class SetRange extends JFrame
{
    static String min;
    static String max;
    /**
     * 类 SetRange 的对象的构造函数
     */
    public SetRange()
    {
        setBounds(200,200,300,200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        JLabel l1 = new JLabel("Min"),l2 = new JLabel("Max");
        JTextField j1 = new JTextField(),j2 = new JTextField();
        JButton btn = new JButton("Confirm");

        l1.setBounds(30,30,60,20);
        l2.setBounds(180,30,60,20);
        j1.setBounds(30,60,80,30);
        j2.setBounds(180,60,80,30);
        btn.setBounds(105,100,80,30);
        btn.setBackground(Color.PINK);
        c.add(l1);
        c.add(l2);
        c.add(j1);
        c.add(j2);
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                min = j1.getText();
                max = j2.getText();
                dispose();
            }
        });		
        setVisible(true);
    }
    
    public static String min(){
        return min;
    }
    
    public static String max(){
        return max;
    }
}
