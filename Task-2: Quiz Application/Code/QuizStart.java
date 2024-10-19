package application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizStart extends JFrame implements ActionListener
{
    String questions[][]=new String[10][5];
    String answers[][]=new String[10][2];
    String useranswers[][]=new String[10][1];
    String name;

    ImageIcon i1;
    JLabel qno, question;
    JRadioButton rb1, rb2, rb3, rb4;
    ButtonGroup grouprb;
    JButton next, lifeline, submit;
    public static int timer=30;
    public static int ans_given =0;
    public static int count=0;
    public static int score=0;
    QuizStart(String name)
    {
        this.name=name;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(new Color(243, 241, 179));
        setLayout(null);

//        i1=new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
//        JLabel image=new JLabel(i1);
//        image.setBounds(0,0,1440,392);
//        add(image);

        qno=new JLabel();
        qno.setBounds(100,150,80,50);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 35));
        add(qno);

        question=new JLabel();
        question.setBounds(150,150,1400,50);
        question.setFont(new Font("Tahoma", Font.PLAIN, 35));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "Who is the Father of Java?";
        questions[7][1] = "Dennis Ritchie";
        questions[7][2] = "James Ghosling";
        questions[7][3] = "Ken Thompson";
        questions[7][4] = "Martin Richards";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "James Ghosling";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        rb1=new JRadioButton();
        rb1.setBounds(170,230,900,50);
        rb1.setBackground(Color.WHITE);
        rb1.setFont(new Font("Dialog", Font.PLAIN, 32));
        add(rb1);

        rb2=new JRadioButton();
        rb2.setBounds(170,300,900,50);
        rb2.setBackground(Color.WHITE);
        rb2.setFont(new Font("Dialog", Font.PLAIN, 32));
        add(rb2);

        rb3=new JRadioButton();
        rb3.setBounds(170,370,900,50);
        rb3.setBackground(Color.WHITE);
        rb3.setFont(new Font("Dialog", Font.PLAIN, 32));
        add(rb3);

        rb4=new JRadioButton();
        rb4.setBounds(170,440,900,50);
        rb4.setBackground(Color.WHITE);
        rb4.setFont(new Font("Dialog", Font.PLAIN, 32));
        add(rb4);

        grouprb =new ButtonGroup();
        grouprb.add(rb1);
        grouprb.add(rb2);
        grouprb.add(rb3);
        grouprb.add(rb4);

        next=new JButton("Next");
        next.setBounds(150,600,160,50);
        next.setFont(new Font("Tahoma", Font.PLAIN, 30));
        next.setForeground(new Color(7, 52, 120));
        next.addActionListener(this);
        add(next);

        lifeline=new JButton("50-50 Lifeline");
        lifeline.setBounds(330,600,220,50);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lifeline.setForeground(new Color(17, 136, 17));
        lifeline.addActionListener(this);
        add(lifeline);

        submit=new JButton("Submit");
        submit.setBounds(1200,600,160,50);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setForeground(new Color(120, 7, 7));
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==next)
        {
            repaint();
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
            rb4.setEnabled(true);

            ans_given=1;
            if(grouprb.getSelection() == null)
            {
                useranswers[count][0]="";
            }
            else
            {
                useranswers[count][0]=grouprb.getSelection().getActionCommand();
            }

            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }

        else if(e.getSource()==lifeline)
        {
            if (count==2 || count==4 || count==6 || count==8 || count==9)
            {
                rb2.setEnabled(false);
                rb3.setEnabled(false);
            }
            else
            {
                rb1.setEnabled(false);
                rb4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }

        else if(e.getSource()==submit)
        {
            ans_given=1;
            if(grouprb.getSelection() == null)
            {
                useranswers[count][0]="";
            }
            else
            {
                useranswers[count][0]=grouprb.getSelection().getActionCommand();
            }
            for(int i=0;i<useranswers.length;i++)
            {
                if(useranswers[i][0].equals(answers[i][1])){
                    score +=10;
                }
                else{
                    score +=0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        String time="Time left " + timer + " seconds"; //30
        g.setFont(new Font("Tahoma", Font.PLAIN, 25));
        g.setColor(Color.red);

        if(timer > 0)
        {
            g.drawString(time, 1100, 110);
        }
        else
        {
            g.drawString("Times up!!", 1100, 500 );
        }
        timer--; //29
        
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }

        if(ans_given == 1)
        {
            ans_given = 0;
            timer = 30;
        }
        else if(timer < 0)
        {
            timer=30;
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
            rb4.setEnabled(true);

            if(count==8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if(count==9) //Submit button
            {
                if(grouprb.getSelection() == null)
                {
                    useranswers[count][0]="";
                }
                else
                {
                    useranswers[count][0]=grouprb.getSelection().getActionCommand();
                }
                for(int i=0;i<useranswers.length;i++)
                {
                    if(useranswers[i][0].equals(answers[i][1])){
                        score +=10;
                    }
                    else{
                        score +=0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            }

            else //Next Button
            {
                if (grouprb.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = grouprb.getSelection().getActionCommand();
                }
                count++; //0//1
                start(count);
            }
        }
    }


    public void start(int count)
    {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        rb1.setText(questions[count][1]);
        rb1.setActionCommand(questions[count][1]);
        rb2.setText(questions[count][2]);
        rb2.setActionCommand(questions[count][2]);
        rb3.setText(questions[count][3]);
        rb3.setActionCommand(questions[count][3]);
        rb4.setText(questions[count][4]);
        rb4.setActionCommand(questions[count][4]);
        grouprb.clearSelection();
    }
    public static void main (String [] args)
    {
        new QuizStart("user");
    }
}
