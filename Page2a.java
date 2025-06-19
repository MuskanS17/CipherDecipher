
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2a extends JFrame implements ActionListener {

    JFrame page1;
    JLabel label1;
    JTextField textField1, textField2 ;
    JRadioButton r1,r2;
    JButton next, button;

    Page2a(JFrame page1){
        super("Cipher-Decipher");

        this.page1 = page1;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Graphics/Image1.png"));
        Image i2=i1.getImage().getScaledInstance(300,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,5,280,150);
        add(image);

        label1 = new JLabel("Enter the text: ");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Ralway", Font.BOLD,25));
        label1.setBounds(150,210,375,30);
        add(label1);

        textField1 = new JTextField(15);
        textField1.setBounds(350,210,230,30);
        textField1.setFont(new Font("Arial",Font.BOLD,14));
        add(textField1);

//        label1 = new JLabel("Enter the key: ");
//        label1.setForeground(Color.BLACK);
//        label1.setFont(new Font("Ralway", Font.BOLD,25));
//        label1.setBounds(150,240,375,30);
//        add(label1);
//
//        textField2 = new JTextField(15);
//        textField2.setBounds(350,240,230,30);
//        textField2.setFont(new Font("Arial",Font.BOLD,14));
//        add(textField2);

        JLabel l1 = new JLabel("Conversion : ");
        l1.setFont(new Font("Raleway", Font.BOLD,25));
        l1.setBounds(150,260,180,30);
        add(l1);

        r1 = new JRadioButton("Encrypt");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBackground(new Color(252,208,76));
        r1.setBounds(350,290,100,30);
        add(r1);

        r2 = new JRadioButton("Decrypt");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBackground(new Color(252,208,76));
        r2.setBounds(350,320,100,30);
        add(r2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(r1);
        buttonGroup1.add(r2);

        button = new JButton("Calculate Caesar-Cipher");
        button.setFont(new Font("Raleway",Font.BOLD,18));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setBounds(150,400,300,30);
        button.addActionListener(this);
        add(button);

        next = new JButton("Back");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setBounds(570,400,100,30);
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

        String text = textField1.getText();
        //String key = textField2.getText();

        String operation = "";
        if (r1.isSelected()) {
            operation = "Encrypt";
        } else if (r2.isSelected()) {
            operation = "Decrypt";
        }


        try{

            if(e.getSource()==button){
                String ans;
                if(operation.equals("Encrypt")){
                    ans = Algo.caesarCipher(text);
                    JLabel label = new JLabel(ans);
                    label.setFont(new Font("Arial", Font.BOLD, 16));
                    label.setForeground(new Color(0, 102, 204));
                    JOptionPane.showMessageDialog(null, label, "Encrypted Text:", JOptionPane.INFORMATION_MESSAGE);
                    }
                else if(operation.equals("Decrypt")){
                    ans = Algo.caesarDecipher(text);
                    JLabel label = new JLabel(ans);
                    label.setFont(new Font("Arial", Font.BOLD, 16));
                    label.setForeground(new Color(0, 102, 204));
                    JOptionPane.showMessageDialog(null, label, "Decrypted Text:", JOptionPane.INFORMATION_MESSAGE);

                }



            }


            if(e.getSource()==next){
                page1.setVisible(true);
                this.dispose();
            }
        }catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {

        //new Page2a(new Page1());
    }
}