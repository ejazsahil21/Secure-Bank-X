package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField tf1, tfOtp;
    JPasswordField pf2;
    JButton b1, b2, b3, bSendOtp, bVerifyOtp;

    String generatedOtp = "";
    String userEmail = "";

    public Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 10, 100, 100);
        add(l11);

        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200, 40, 450, 40);
        add(l1);

        /*-------------CARD NO-------------*/
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125, 150, 375, 30);
        add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(300, 150, 230, 30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        /*-------------PIN-------------*/
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125, 220, 375, 30);
        add(l3);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300, 220, 230, 30);
        add(pf2);

        /*-------------OTP field-------------*/
        l4 = new JLabel("OTP:");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(125, 290, 375, 30);
        add(l4);

        tfOtp = new JTextField(6);
        tfOtp.setBounds(300, 290, 230, 30);
        tfOtp.setFont(new Font("Arial", Font.BOLD, 14));
        add(tfOtp);

        bSendOtp = new JButton("SEND OTP");
        bSendOtp.setBackground(Color.BLACK);
        bSendOtp.setForeground(Color.WHITE);
        bSendOtp.setFont(new Font("Arial", Font.BOLD, 14));
        bSendOtp.setBounds(300, 340, 110, 30);
        add(bSendOtp);

        bVerifyOtp = new JButton("VERIFY OTP");
        bVerifyOtp.setBackground(Color.BLACK);
        bVerifyOtp.setForeground(Color.WHITE);
        bVerifyOtp.setFont(new Font("Arial", Font.BOLD, 14));
        bVerifyOtp.setBounds(420, 340, 110, 30);
        add(bVerifyOtp);

        /*-------------SignIn-------------*/
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300, 390, 100, 30);
        add(b1);

        /*-------------Clear-------------*/
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 390, 100, 30);
        add(b2);

        /*-------------SignUp-------------*/
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300, 440, 230, 30);
        add(b3);

        setLayout(null);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bSendOtp.addActionListener(this);
        bVerifyOtp.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 560);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {

            // ✅ SEND OTP
            if (ae.getSource() == bSendOtp) {

                Conn c1 = new Conn();
                String cardno = tf1.getText().trim();
                String pin = new String(pf2.getPassword()).trim();

                String q = "select * from login where cardno = '" + cardno + "' and pin = '" + pin + "'";
                ResultSet rs = c1.s.executeQuery(q);

                if (rs.next()) {

                    userEmail = rs.getString("email");

                    if (userEmail == null || userEmail.trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Email not found for this account!");
                        return;
                    }

                    generatedOtp = String.valueOf(100000 + new java.util.Random().nextInt(900000));

                    EmailOTPService.sendOTP(userEmail, generatedOtp);

                    JOptionPane.showMessageDialog(null, "OTP sent to: " + userEmail);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            }

            // ✅ VERIFY OTP
            else if (ae.getSource() == bVerifyOtp) {

                String enteredOtp = tfOtp.getText().trim();

                if (generatedOtp.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please click SEND OTP first!");
                    return;
                }

                if (enteredOtp.equals(generatedOtp)) {
                    JOptionPane.showMessageDialog(null, "OTP Verified ✅ Login Success!");

                    String pin = new String(pf2.getPassword()).trim();
                    setVisible(false);
                    new Transactions(pin).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid OTP ❌");
                }
            }

            // ❗SIGN IN should not bypass OTP
            else if (ae.getSource() == b1) {
                JOptionPane.showMessageDialog(null, "Please verify OTP first!");
            }

            // ✅ CLEAR
            else if (ae.getSource() == b2) {
                tf1.setText("");
                pf2.setText("");
                tfOtp.setText("");
                generatedOtp = "";
                userEmail = "";
            }

            // ✅ SIGN UP
            else if (ae.getSource() == b3) {
                setVisible(false);
                new SignupOne().setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
