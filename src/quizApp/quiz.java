package quizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quiz extends JFrame implements ActionListener {

    public static int count = 0;
    public static int given_ans = 0;
    public static int timer = 15;
    public static int score = 0;

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String user_answers[][] = new String[10][1];

    JLabel qno, question, timeLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton next, submit, help;
    String name;
    Timer quizTimer;

    quiz(String name) {
        this.name = name;

        setTitle("Quiz Application");
        setLayout(null); // Using absolute positioning
        getContentPane().setBackground(Color.white);

        // Image at the top
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 1366, 250);
        add(img);

        // Questions and answers initialization
        initializeQuestionsAndAnswers();

        // Labels setup
        qno = new JLabel();
        qno.setBounds(50, 300, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(100, 300, 1200, 30);  // Adjusted width
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // Radio buttons setup
        opt1 = new JRadioButton();
        opt1.setBounds(170, 350, 500, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 390, 500, 30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 430, 500, 30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 470, 500, 30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        // Button group setup
        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        // Buttons setup
        next = new JButton("Next");
        next.setBounds(600, 550, 150, 30);
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(800, 550, 150, 30);
        submit.setBackground(new Color(255, 215, 0));
        submit.setForeground(Color.black);
        submit.addActionListener(this);
        submit.setEnabled(false); // Initially disabled
        add(submit);

        help = new JButton("Help");
        help.setBounds(1000, 550, 150, 30);
        help.setBackground(new Color(22, 99, 54));
        help.setForeground(Color.white);
        help.addActionListener(this);
        add(help);

        // Timer label setup
        timeLabel = new JLabel("Time left: " + timer + " seconds");
        timeLabel.setBounds(1100, 500, 200, 30);
        timeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        timeLabel.setForeground(Color.RED);
        add(timeLabel);

        // Timer setup
        quizTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer--;
                timeLabel.setText("Time left: " + timer + " seconds");

                if (timer <= 0) {
                    timer = 15;
                    given_ans = 1;
                    if (count == 9) {
                        endQuiz();
                    } else {
                        nextQuestion();
                    }
                }
            }
        });

        start(count);
        quizTimer.start();

        setSize(1366, 768);
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setVisible(true);
    }

    private void initializeQuestionsAndAnswers() {
        questions[0][0] = "Number of primitive data types in Java are.?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        questions[1][0] = "What is the size of float and double in java.?";
        questions[1][1] = "32 and 64";
        questions[1][2] = "32 and 32";
        questions[1][3] = "64 and 64";
        questions[1][4] = "64 and 32";

        questions[2][0] = "Automatic type conversion is possible in which of the possible cases?";
        questions[2][1] = "Byte to int";
        questions[2][2] = "Int to Long";
        questions[2][3] = "Long to int";
        questions[2][4] = "Short to int";

        questions[3][0] = "When an array is passed to a method, what does the method receive?";
        questions[3][1] = "The reference of the array";
        questions[3][2] = "A copy of the array";
        questions[3][3] = "Length of the array";
        questions[3][4] = "Copy of first element";

        questions[4][0] = "Arrays in java are.?";
        questions[4][1] = "Object References";
        questions[4][2] = "Objects";
        questions[4][3] = "Primitive data type";
        questions[4][4] = "None";

        questions[5][0] = "When is the object created with new keyword?";
        questions[5][1] = "At run time";
        questions[5][2] = "At compile time";
        questions[5][3] = "Depends on the code";
        questions[5][4] = "None";

        questions[6][0] = "Identify the corrected definition of a package.?";
        questions[6][1] = "A package is a collection of editing tools";
        questions[6][2] = "A package is a collection of Classes";
        questions[6][3] = "A package is a collection of Classes and interfaces";
        questions[6][4] = "A package is a collection of interfaces";

        questions[7][0] = "compareTo() returns";
        questions[7][1] = "True";
        questions[7][2] = "False";
        questions[7][3] = "An int value";
        questions[7][4] = "None";

        questions[8][0] = "To which of the following does the class string belong to.";
        questions[8][1] = "java.lang";
        questions[8][2] = "java.awt";
        questions[8][3] = "java.applet";
        questions[8][4] = "java.String";

        questions[9][0] = "Total constructor string class have.?";
        questions[9][1] = "3";
        questions[9][2] = "7";
        questions[9][3] = "13";
        questions[9][4] = "20";

        answers[0][1] = "8";
        answers[1][1] = "32 and 64";
        answers[2][1] = "Int to Long";
        answers[3][1] = "The reference of the array";
        answers[4][1] = "Objects";
        answers[5][1] = "At run time";
        answers[6][1] = "A package is a collection of Classes and interfaces";
        answers[7][1] = "An int value";
        answers[8][1] = "java.lang";
        answers[9][1] = "13";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            given_ans = 1;
            nextQuestion();
        } else if (e.getSource() == submit) {
            given_ans = 1;
            endQuiz();
        } else if (e.getSource() == help) {
            if (count == 2 || count == 4 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            help.setEnabled(false);
        }
    }

    private void nextQuestion() {
        if (group.getSelection() == null) {
            user_answers[count][0] = "";
        } else {
            user_answers[count][0] = group.getSelection().getActionCommand();
        }

        count++;
        if (count == 9) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        start(count);
        timer = 15;
    }

    private void endQuiz() {
        quizTimer.stop();
        if (group.getSelection() == null) {
            user_answers[count][0] = "";
        } else {
            user_answers[count][0] = group.getSelection().getActionCommand();
        }

        for (int i = 0; i < user_answers.length; i++) {
            if (user_answers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }

        setVisible(false);
        new score(name, score);
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    public static void main(String[] args) {
        new quiz("user");
    }
}
