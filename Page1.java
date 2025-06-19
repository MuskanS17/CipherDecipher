
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Page1 extends JFrame implements ActionListener {

    JLabel label1;
    JButton next;
    JComboBox comboBox;

    Page1(){
        super("Cipher-Decipher");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Graphics/Image1.png"));
        Image i2=i1.getImage().getScaledInstance(400,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(230,10,400,300);
        add(image);

        label1 = new JLabel("Cipher-Decipher");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde", Font.BOLD,38));
        label1.setBounds(255,5,450,40);
        add(label1);

        JLabel l1 = new JLabel("Algorithm :");
        l1.setFont(new Font("Raleway", Font.BOLD,18));
        l1.setBounds(100,320,100,30);
        add(l1);

        String algo[] = {"Caesar-Cipher","Vigenere-Cipher","Vernam-Cipher","RailFence-Cipher","RowColumn-Cipher"};
        comboBox = new JComboBox(algo);
        comboBox.setBackground(new Color(252,208,76));
        comboBox.setFont(new Font("Raleway",Font.BOLD,14));
        comboBox.setBounds(300,320,320,30);
        add(comboBox);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(500,400,100,30);
        next.addActionListener(this);
        add(next);



        setLayout(null);
        setSize(850,500);
        setLocation(450,200);
        getContentPane().setBackground(new Color(222,255,228));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==next){
                String selectedValue = (String) comboBox.getSelectedItem();
                if(Objects.equals(selectedValue, "Caesar-Cipher"))
                    new Page2a(Page1.this);
                else if(Objects.equals(selectedValue, "Vigenere-Cipher"))
                    new Page2c(Page1.this);
                else if(Objects.equals(selectedValue, "Vernam-Cipher"))
                    new Page2b(Page1.this);
                else if(Objects.equals(selectedValue, "RailFence-Cipher"))
                    new Page2d(Page1.this);
                else if(Objects.equals(selectedValue, "RowColumn-Cipher"))
                    new Page2e(Page1.this);

            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Page1();
    }
}
