package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfname;

    Quiz() {
        // Setting background color and layout
        getContentPane().setBackground(new Color(169, 213, 243));
        setLayout(null);

        // Adding the heading
        JLabel heading = new JLabel("Quiz App - 2k24");
        heading.setBounds(660, 120, 700, 70);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 55));
        heading.setForeground(new Color(3, 59, 78));
        add(heading);

        // Adding the label for name input
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(785, 220, 400, 22);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        name.setForeground(new Color(3, 59, 78));
        add(name);

        // Adding the text field for name input
        tfname = new JTextField();
        tfname.setBounds(740, 250, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        // Creating the "Rules" button with improved visibility
        rules = new JButton("Rules");
        rules.setBounds(765, 290, 120, 40);
        rules.setFont(new Font("Tahoma", Font.BOLD, 20));
        rules.setForeground(new Color(7, 52, 120)); // White text color for better contrast
        rules.addActionListener(this);
        add(rules);

        // Creating the "Back" button with improved visibility
        back = new JButton("Back");
        back.setBounds(895, 290, 120, 40);
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setForeground(new Color(140, 22, 22)); // White text color for better contrast
        back.addActionListener(this);
        add(back);

        // Adding the image (make sure to add it last so it stays in the background)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 480);
        add(image);

        // Setting the frame properties
        setLocation(150, 150);
        setSize(1200, 500);
        setVisible(true);
        setBackground(Color.cyan);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name); // Assuming Rules is another class that takes 'name' as an argument
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Quiz();
    }
}
