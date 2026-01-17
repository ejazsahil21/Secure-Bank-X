package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JButton b1;

    MiniStatement(String pin) {

        setTitle("Mini Statement");
        setLayout(null);

        // ✅ Page background light blue
        getContentPane().setBackground(new Color(173, 216, 230)); // Light Blue

        /*==================== Header Panel ====================*/
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBounds(30, 20, 520, 70);
        headerPanel.setBackground(new Color(255, 255, 255)); // white
        headerPanel.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        add(headerPanel);

        l2 = new JLabel("SECURE BMS BANK - MINI STATEMENT", JLabel.CENTER);
        l2.setFont(new Font("System", Font.BOLD, 18));
        l2.setForeground(new Color(0, 51, 153));
        l2.setBounds(10, 15, 500, 40);
        headerPanel.add(l2);

        /*==================== Card Panel ====================*/
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBounds(30, 110, 520, 60);
        cardPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        cardPanel.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        add(cardPanel);

        l3 = new JLabel("Card Number: ");
        l3.setFont(new Font("System", Font.BOLD, 14));
        l3.setBounds(20, 15, 480, 30);
        cardPanel.add(l3);

        /*==================== Transaction Panel ====================*/
        JPanel txnPanel = new JPanel();
        txnPanel.setLayout(null);
        txnPanel.setBounds(30, 190, 520, 320);
        txnPanel.setBackground(new Color(255, 255, 255));
        txnPanel.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        add(txnPanel);

        JLabel txnTitle = new JLabel("Transaction History");
        txnTitle.setFont(new Font("System", Font.BOLD, 16));
        txnTitle.setForeground(new Color(0, 51, 153));
        txnTitle.setBounds(20, 10, 200, 25);
        txnPanel.add(txnTitle);

        l1 = new JLabel();
        l1.setFont(new Font("Monospaced", Font.PLAIN, 13));
        l1.setBounds(20, 45, 480, 250);
        txnPanel.add(l1);

        /*==================== Balance Panel ====================*/
        JPanel balancePanel = new JPanel();
        balancePanel.setLayout(null);
        balancePanel.setBounds(30, 530, 520, 60);
        balancePanel.setBackground(new Color(230, 255, 230)); // light green
        balancePanel.setBorder(new LineBorder(new Color(0, 153, 0), 2));
        add(balancePanel);

        l4 = new JLabel("Your total Balance is Rs ");
        l4.setFont(new Font("System", Font.BOLD, 15));
        l4.setForeground(new Color(0, 102, 0));
        l4.setBounds(20, 15, 480, 30);
        balancePanel.add(l4);

        /*==================== Exit Button ====================*/
        b1 = new JButton("Exit");
        b1.setBounds(230, 610, 120, 35);
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.setBackground(new Color(0, 102, 204));
        b1.setForeground(Color.WHITE);
        b1.setFocusPainted(false);
        add(b1);

        b1.addActionListener(this);

        /*------------ Fetch Card Number --------------*/
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pin + "'");

            while (rs.next()) {
                String cardno = rs.getString("cardno");
                l3.setText("Card Number: " + cardno.substring(0, 4) + "XXXXXXXX" + cardno.substring(12));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*------------ Fetch Transactions + Balance --------------*/
        try {
            int balance = 0;

            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {

                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                // ✅ Better formatted output
                l1.setText(l1.getText() +
                        "<html>" + date +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + type +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + amount +
                        "<br><br><html>");

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            l4.setText("Your total Balance is Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*------------ Frame Settings --------------*/
        setSize(600, 720);     // ✅ Larger window
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
