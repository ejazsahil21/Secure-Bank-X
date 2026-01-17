package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;

    // ✅ Generate only once and reuse
    String cardno;
    String pin;

    SignupThree(String formno){

        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        /*------------Logo--------------*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l13 = new JLabel(i3);
        l13.setBounds(150, 0, 100, 100);
        add(l13);

        /*------------Heading--------------*/
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        /*------------Account Type--------------*/
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100,140,200,30);
        add(l2);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,200,30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,300,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,300,30);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        /*------------Card Number--------------*/
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100,300,200,30);
        add(l3);

        l4 = new JLabel("XXXX-XXXX-XXXX-XXXX");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(330,300,400,30);
        add(l4);

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100,330,200,20);
        add(l5);

        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(330,330,500,20);
        add(l6);

        /*------------PIN--------------*/
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100,370,200,30);
        add(l7);

        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(330,370,200,30);
        add(l8);

        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(100,400,200,20);
        add(l9);

        /*------------Services Required--------------*/
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100,450,200,30);
        add(l10);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,680,650,20);
        add(c7);

        /*------------Form No--------------*/
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(700,10,70,30);
        add(l11);

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(770,10,60,30);
        add(l12);

        /*------------Buttons--------------*/
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,720,100,30);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(420,720,100,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        // ✅ Generate Card + PIN once when page opens
        generateCardAndPin();

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,0);
        setVisible(true);
    }

    // ✅ Generates card + pin and display on UI
    private void generateCardAndPin() {
        Random ran = new Random();

        long first7 = (Math.abs(ran.nextLong()) % 90000000L) + 5040936000000000L;
        cardno = "" + first7;

        long first3 = (Math.abs(ran.nextLong()) % 9000L) + 1000L;
        pin = "" + first3;

        // ✅ Show values on screen
        l4.setText(cardno);
        l8.setText(pin);
    }

    public void actionPerformed(ActionEvent ae){

        String atype = "";
        if(r1.isSelected()){
            atype = "Saving Account";
        }else if(r2.isSelected()){
            atype = "Fixed Deposit Account";
        }else if(r3.isSelected()){
            atype = "Current Account";
        }else if(r4.isSelected()){
            atype = "Recurring Deposit Account";
        }

        String facility = "";
        if(c1.isSelected()){ facility += " ATM Card"; }
        if(c2.isSelected()){ facility += " Internet Banking"; }
        if(c3.isSelected()){ facility += " Mobile Banking"; }
        if(c4.isSelected()){ facility += " EMAIL Alerts"; }
        if(c5.isSelected()){ facility += " Cheque Book"; }
        if(c6.isSelected()){ facility += " E-Statement"; }

        try{
            if(ae.getSource() == b1){

                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                    return;
                }

                Conn c1 = new Conn();

                // ✅ Fetch email from signup table
                String email = "";
                ResultSet rs = c1.s.executeQuery("select email from signup where formno = '"+formno+"'");
                if(rs.next()){
                    email = rs.getString("email");
                }

                // ✅ Insert into signupthree table
                String q1 = "insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";
                c1.s.executeUpdate(q1);

                // ✅ Insert into login table (with email)
                String q2 = "insert into login(formno, cardno, pin, email) values('"+formno+"','"+cardno+"','"+pin+"','"+email+"')";
                c1.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,
                        "Account Created Successfully!\n\nCard Number: " + cardno +
                        "\nPin: " + pin +
                        "\nEmail: " + email);

                // ✅ Go to Login page
                setVisible(false);
                new Login().setVisible(true);

            } else if(ae.getSource() == b2){
                System.exit(0);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new SignupThree("").setVisible(true);
    }
}
