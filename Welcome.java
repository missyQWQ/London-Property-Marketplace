import javax.swing.*;
import java.awt.*;
/**
 * 在这里给出对类 Welcome 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Welcome extends JFrame
{
    public Welcome()
    {
        setTitle("London Airbnb");
        setBounds(200,200,500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        JPanel westP = new JPanel();
        westP.setLayout(new FlowLayout());
        JLabel l = new JLabel("");
        Icon icon = new ImageIcon("C:/Users/Angela/Desktop/airbnb3.png");
        l.setIcon(icon);
        westP.setBounds(0,0,300,300);
        westP.add(l);
        c.add(westP);
                
        JLabel l1 = new JLabel("Username"), l2 = new JLabel("Password"),
        l3 = new JLabel("Welcome to London Airbnb app!");
        l1.setFont(new Font("微软雅黑",Font.BOLD,15));
        l2.setFont(new Font("微软雅黑",Font.BOLD,15));
        l3.setFont(new Font("微软雅黑",Font.BOLD,15));        
        JButton btn = new JButton("Hello Airbnb!");
        btn.setBackground(Color.PINK);
        
        JTextField jt = new JTextField();
        jt.setColumns(20);
        
        JPasswordField jp = new JPasswordField();
        jp.setEchoChar('\u2605');
        
        JPanel eastP = new JPanel();
        eastP.setLayout(new GridLayout(5,1,10,10));
        eastP.setBounds(300,60,170,180);
        eastP.add(l1);
        eastP.add(jt);
        eastP.add(l2);
        eastP.add(jp);
        eastP.add(btn);
        c.add(eastP);
        
        JPanel southP = new JPanel();
        southP.setLayout(new FlowLayout());
        southP.setBounds(100,310,300,100);
        southP.add(l3);
        c.add(southP);
        
        setVisible(true);
        
    }

}