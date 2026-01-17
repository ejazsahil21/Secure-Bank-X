package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JLabel l1;
    JTextField t1;
    JButton b1,b2;
    String pin;

    Deposit(String pin){

        this.pin = pin;

        /*------------ATM Image Background--------------*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 960, 1080);
        add(l2);

        /*------------Heading--------------*/
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190,350,400,35);
        l2.add(l1);

        /*------------TextField--------------*/
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(190,420,320,25);
        l2.add(t1);

        /*------------Buttons--------------*/
        b1 = new JButton("DEPOSIT");
        b1.setBounds(390,588,150,35);
        l2.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(390,633,150,35);
        l2.add(b2);

        /*------------Action Listeners--------------*/
        b1.addActionListener(this);
        b2.addActionListener(this);

        /*------------Frame Settings--------------*/
        setLayout(null);
        setSize(960,960);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        try{
            if(ae.getSource() == b1){

                String amount = t1.getText();
                Date date = new Date();

                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");

                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }

            }else if(ae.getSource() == b2){

                setVisible(false);
                new Transactions(pin).setVisible(true);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
