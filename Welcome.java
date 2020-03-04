import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * A welcome page
 * @author Liangjie Wang
 * @Vision 3.3.2020
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

        JLabel  l1 = new JLabel("Username"), 
                l2 = new JLabel("Password"),
                l3 = new JLabel("Welcome to London Airbnb app!");
        l1.setFont(new Font("Arial",Font.BOLD,15));
        l2.setFont(new Font("Arial",Font.BOLD,15));
        l3.setFont(new Font("Lucida Calligraphy",Font.BOLD,15));
        l3.setForeground(new Color(0,0,128));
        JButton btn = new JButton("Hello Airbnb!");
        btn.setBackground(Color.PINK);
        btn.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setRange();
                    dispose();
                }
            }

        );

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
        southP.setBounds(100,300,300,100);
        southP.add(l3);
        c.add(southP);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Help");
        menuBar.add(menu);

        JMenuItem item = new JMenuItem("???");
        //item.addActionListener(e -> setRange());

        menu.add(item);

        setVisible(true);

    }

    private void setRange(){
        SetRange.newDialog();
    }

}