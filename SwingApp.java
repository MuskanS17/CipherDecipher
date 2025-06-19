import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Swing Algorithm Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a text field for input
        JTextField inputField = new JTextField(15);

        // Create two radio buttons
        JRadioButton algo1Button = new JRadioButton("Algorithm 1");
        JRadioButton algo2Button = new JRadioButton("Algorithm 2");

        // Group the radio buttons so only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(algo1Button);
        group.add(algo2Button);

        // Create a button to trigger the selected algorithm
        JButton executeButton = new JButton("Execute");

        // Add ActionListener to the execute button
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input value from the text field
                String input = inputField.getText();

                // Check which radio button is selected and perform the corresponding algorithm
                if (algo1Button.isSelected()) {
                    performAlgo1(input);
                } else if (algo2Button.isSelected()) {
                    performAlgo2(input);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select an algorithm!");
                }
            }
        });

        // Add components to the panel
        panel.add(new JLabel("Enter value:"));
        panel.add(inputField);
        panel.add(algo1Button);
        panel.add(algo2Button);
        panel.add(executeButton);

        // Add panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Example algorithm 1
    public static void performAlgo1(String input) {
        JOptionPane.showMessageDialog(null, "Algorithm 1 executed with input: " + input);
        // Add your custom algorithm logic here
    }

    // Example algorithm 2
    public static void performAlgo2(String input) {
        JOptionPane.showMessageDialog(null, "Algorithm 2 executed with input: " + input);
        // Add your custom algorithm logic here
    }
}
