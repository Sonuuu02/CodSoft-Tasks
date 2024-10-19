package application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener
{
    JButton start, back;
    String name;
    Rules(String name)
    {
        this.name = name;
        getContentPane().setBackground(new Color(228, 239, 147));
        setLayout(null);

        JLabel heading=new JLabel("Welcome " + name + " to Quiz - 2K24");
        heading.setBounds(160,20,700,30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(117, 58, 133));
        add(heading);

        JLabel rules=new JLabel();
        rules.setBounds(20,90,780,350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>"+
                        "1. You are trained to be a programmer and not a story teller, answer point to point." + "<br><br>" +
                        "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer." + "<br><br>" +
                        "3. You may have lot of options in life but here all the questions are compulsory." + "<br><br>" +
                        "4. Crying is allowed but please do so quietly." + "<br><br>" +
                        "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                        "6. Do not get nervous if your friend is answering more questions. " + "<br><br>" +
                        "7. Brace yourself, this paper is not for the faint hearted." + "<br><br>" +
                        "8. May you know more than what John Snow knows, Good Luck." + "<br><br>" +
                        "<html>"
        );
        add(rules);

        back=new JButton("Back");
        back.setBounds(250,500,140,50);
        back.setBackground(new Color(181, 16, 19));
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setForeground(Color.RED);
        add(back);
        back.addActionListener(this);

        start=new JButton("Start");
        start.setBounds(400,500,140,50);
        start.setBackground(new Color(3, 59, 78));
        start.setFont(new Font("Tahoma", Font.BOLD, 20));
        start.setForeground(Color.BLUE);
        add(start);
        start.addActionListener(this);

        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==start)
        {
            setVisible(false);
            new QuizStart(name);
        }
        else
        {
            setVisible(false);
            new Quiz();
        }
    }
    public static void main(String[] args)
    {
        new Rules("User ");
    }
}

