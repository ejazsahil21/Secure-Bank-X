package bank.management.system;

import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupOne extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton male,female,r3,r4,r5;
    JButton next;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    SignupOne(){

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");

        /*------------Logo--------------*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(20, 0, 100, 100);
        add(l14);

        /*------------Heading--------------*/
        l1 = new JLabel("APPLICATION FORM NO. " + first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        l1.setBounds(140,20,600,40);
        add(l1);

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(290,80,600,30);
        add(l2);

        /*------------Name--------------*/
        l3 = new JLabel("Name:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100,140,100,30);
        add(l3);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(300,140,400,30);
        add(t1);

        /*------------Father Name--------------*/
        l4 = new JLabel("Father's Name:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100,190,200,30);
        add(l4);

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(300,190,400,30);
        add(t2);

        /*------------DOB--------------*/
        l5 = new JLabel("Date of Birth:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100,240,200,30);
        add(l5);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);

        /*------------Gender--------------*/
        l6 = new JLabel("Gender:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(100,290,200,30);
        add(l6);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBackground(Color.WHITE);
        male.setBounds(300,290,80,30);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(450,290,100,30);
        add(female);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(female);

        /*------------Email--------------*/
        l7 = new JLabel("Email Address:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100,340,200,30);
        add(l7);

        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        t3.setBounds(300,340,400,30);
        add(t3);

        /*------------Marital Status--------------*/
        l8 = new JLabel("Marital Status:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100,390,200,30);
        add(l8);

        r3 = new JRadioButton("Married");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(300,390,100,30);
        add(r3);

        r4 = new JRadioButton("Unmarried");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(450,390,120,30);
        add(r4);

        r5 = new JRadioButton("Other");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);
        r5.setBounds(620,390,100,30);
        add(r5);

        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);

        /*------------Address--------------*/
        l9 = new JLabel("Address:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(100,440,200,30);
        add(l9);

        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        t4.setBounds(300,440,400,30);
        add(t4);

        /*------------City--------------*/
        l10 = new JLabel("City:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        l10.setBounds(100,490,200,30);
        add(l10);

        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        t5.setBounds(300,490,400,30);
        add(t5);

        /*------------Pin Code--------------*/
        l11 = new JLabel("Pin Code:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        l11.setBounds(100,540,200,30);
        add(l11);

        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        t6.setBounds(300,540,400,30);
        add(t6);

        /*------------State--------------*/
        l12 = new JLabel("State:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));
        l12.setBounds(100,590,200,30);
        add(l12);

        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        t7.setBounds(300,590,400,30);
        add(t7);

        /*------------Next Button--------------*/
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        add(next);

        next.addActionListener(this);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String formno = first;
        String name = t1.getText();
        String fname = t2.getText();

        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = "";
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }

        String email = t3.getText();

        String marital = "";
        if(r3.isSelected()){
            marital = "Married";
        }else if(r4.isSelected()){
            marital = "Unmarried";
        }else if(r5.isSelected()){
            marital = "Other";
        }

        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();

        try{
            if(name.equals("") || fname.equals("") || dob.equals("") || gender.equals("") || pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
                return;
            }

            Conn c1 = new Conn();
            String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
            c1.s.executeUpdate(q1);

            new SignupTwo(formno).setVisible(true);
            setVisible(false);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new SignupOne().setVisible(true);
    }
}
