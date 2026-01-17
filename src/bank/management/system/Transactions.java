package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    JLabel backgroundLabel;   // ATM background image label
    ImageIcon atmIcon;        // original image icon

    Transactions(String pin) {

        this.pin = pin;

        setTitle("Transactions");
        setLayout(null);

        // ✅ Window size like your Application Form
        int frameWidth = 900;
        int frameHeight = 900;

        setSize(frameWidth, frameHeight);
        setLocation(350, 0);
        setUndecorated(true);

        /*------------ATM Image Background--------------*/
        atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

        Image scaledImg = atmIcon.getImage().getScaledInstance(frameWidth, frameHeight, Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(scaledImg));
        backgroundLabel.setBounds(0, 0, frameWidth, frameHeight);
        add(backgroundLabel);

        /*------------Heading--------------*/
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(210, 285, 350, 30);  // ✅ changed position
        backgroundLabel.add(l1);

        /*------------Buttons--------------*/
        b1 = new JButton("DEPOSIT");
        b1.setBounds(152, 417, 160, 30);   // ✅ beside left arrows
        backgroundLabel.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(360, 417, 160, 30);   // ✅ beside right arrows
        backgroundLabel.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(152,453 , 160, 30);   // ✅ beside left arrows
        backgroundLabel.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(360, 453, 160, 30);   // ✅ beside right arrows
        backgroundLabel.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(152, 489, 160, 30);   // ✅ beside left arrows
        backgroundLabel.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(360, 489, 160, 30);   // ✅ beside right arrows
        backgroundLabel.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(250, 520, 160, 30);   // ✅ bottom center exit
        backgroundLabel.add(b7);

        /*------------Action Listeners--------------*/
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);

        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);

        } else if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(pin).setVisible(true);

        } else if (ae.getSource() == b4) {
            new MiniStatement(pin).setVisible(true);

        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);

        } else if (ae.getSource() == b6) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);

        } else if (ae.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
