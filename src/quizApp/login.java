package quizApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {


    JTextField text;     // declaring text field
    JButton next,exit;      //declaring button
    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // setting background image for login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i = i1.getImage().getScaledInstance(550,500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(450,0,550,500);
        add(image);


        // Setting Heading for Login Page
        JLabel heading = new JLabel("Quiz App");
        heading.setBounds(140,60,300,45);
        heading.setFont(new Font("Futura",Font.BOLD,40));
        heading.setForeground(new Color(22,99,54));
        add(heading);

        // Setting Name for login
        JLabel name = new JLabel("Please Enter Your Name");
        name.setBounds(130,150,300,20);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
        name.setForeground(new Color(22,99,54));
        add(name);

        //setting textfield for name's input
        text = new JTextField();
        text.setBounds(80,200,300,25);
        text.setFont(new Font("Time New Roman",Font.BOLD,18));
        add(text);

        //setting buttons
        next = new JButton("Next");
        next.setBounds(85,270,120,25);
        next.setBackground(new Color(22,99,54));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        exit = new JButton("Exit");
        exit.setBounds(250,270,120,25);
        exit.setBackground(new Color(22,99,54));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);


        //Setting up GUI screen
        setSize(1000,500);
        setLocation(200,150);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next){
            String name = text.getText();
            setVisible(false);
            new Rules(name);
        } else if (e.getSource() == exit) {
            System.exit(50);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
