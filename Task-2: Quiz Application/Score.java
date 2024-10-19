package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(new Color(193, 230, 255));
        setLayout(null);

        JLabel heading = new JLabel("Thankyou " + name + " for playing Quiz 2k24");
        heading.setBounds(50, 150, 900, 50);
        heading.setForeground(new Color(3, 59, 78));
        heading.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(heading);

        JLabel lbscore = new JLabel("Your score is " + score);
        lbscore.setBounds(280, 210, 300, 50);
        lbscore.setForeground(new Color(3, 59, 78));
        lbscore.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(lbscore);

        JButton submit = new JButton("Play Again");
        submit.setBounds(325, 290, 140, 50);
        submit.setFont(new Font("Tahoma", Font.BOLD, 20));
        submit.setForeground(new Color(17, 136, 17));
        submit.setEnabled(true);
        submit.addActionListener(this);
        add(submit);

        JButton back = new JButton("Back");
        back.setBounds(325, 345, 140, 50);
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setForeground(new Color(181, 16, 19));
        back.setEnabled(true);
        back.addActionListener(this);
        add(back);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Quiz();
    }

    public static void main(String[] args) {
        new Score("user", 0);
    }
}
