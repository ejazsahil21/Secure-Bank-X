package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class OTPVerification extends JFrame implements ActionListener {

    JLabel heading, info;
    JTextField otpField;
    JButton verifyBtn, resendBtn;

    String pin;
    String email;
    String otp;

    OTPVerification(String pin, String email) {
        this.pin = pin;
        this.email = email;

        setTitle("OTP Verification");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        heading = new JLabel("Secure-BMS OTP Verification");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(60, 30, 350, 30);
        add(heading);

        info = new JLabel("OTP sent to: " + email);
        info.setFont(new Font("Arial", Font.PLAIN, 13));
        info.setBounds(60, 70, 350, 20);
        add(info);

        otpField = new JTextField();
        otpField.setBounds(60, 120, 200, 30);
        add(otpField);

        verifyBtn = new JButton("Verify OTP");
        verifyBtn.setBounds(270, 120, 120, 30);
        add(verifyBtn);

        resendBtn = new JButton("Resend OTP");
        resendBtn.setBounds(60, 170, 150, 30);
        add(resendBtn);

        verifyBtn.addActionListener(this);
        resendBtn.addActionListener(this);

        setSize(470, 280);
        setLocation(400, 200);
        setVisible(true);

        sendNewOTP(); // auto send OTP when page opens
    }

    private void sendNewOTP() {
        try {
            otp = String.valueOf(100000 + new Random().nextInt(900000));
            EmailOTPService.sendOTP(email, otp);
            JOptionPane.showMessageDialog(null, "OTP Sent Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "OTP sending failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == verifyBtn) {

            String enteredOtp = otpField.getText().trim();

            if (enteredOtp.equals(otp)) {
                JOptionPane.showMessageDialog(null, "OTP Verified Successfully!");
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid OTP");
            }

        } else if (ae.getSource() == resendBtn) {
            sendNewOTP();
        }
    }
}
