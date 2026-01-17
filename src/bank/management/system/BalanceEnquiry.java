package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1;
    String pin;

    BalanceEnquiry(String pin){

        this.pin = pin;

        /*------------ATM Image Background--------------*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        /*------------Balance Label--------------*/
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190, 350, 500, 35);
        l2.add(l1);

        /*------------Back Button--------------*/
        b1 = new JButton("BACK");
        b1.setBounds(390, 633, 150, 35);
        l2.add(b1);

        b1.addActionListener(this);

        /*------------Balance Calculation--------------*/
        int balance = 0;

        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        l1.setText("Your Current Account Balance is Rs " + balance);

        /*------------Frame Settings--------------*/
        setLayout(null);
        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args){
        new BalanceEnquiry("").setVisible(true);
    }
}
