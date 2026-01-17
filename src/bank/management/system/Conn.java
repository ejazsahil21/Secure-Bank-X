package bank.management.system;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conn {
	
	Connection con;
	public Statement s;
	
	public Conn() {
		String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
		String password = "root21";
		String username = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			s = con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());

		}
	}
}
