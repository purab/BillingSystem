package bs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class MainPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField name_field;
	private JTextField username_field;
	private JTextField org_field;
	private JTextField date_field;
	private JTextField mobile_field;
	private JPanel panel;
	private JPasswordField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}
	
	private Connection connection=null;
	
	//create table in db
	public void createTableNew() {
		try {
			DatabaseMetaData dmd = connection.getMetaData();
			ResultSet set= dmd.getTables(null, null, "USERTABLE", null);
			if(set.next()) {
				//if table exists in db then do nothing
			} else {
				String creat_table = "create table USERTABLE("
						+"name varchar2(20), username varchar2(14),password varchar2(15)"
						+",organization varchar2(20), dateofbirth varchar2(20),mobile varchar2(15))";
				PreparedStatement statement = connection.prepareStatement(creat_table);
				statement.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Table created");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//create database connection, am using h2 embeded database
		//add Jdbc jar your project 
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection ("jdbc:h2:~/test", "sa",""); 
			
			JOptionPane.showMessageDialog(null, "connection Succesful");
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PK Billing System");
		lblNewLabel.setBounds(156, 21, 405, 50);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		btnNewButton.setBounds(69, 117, 211, 50);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(570, 133, 133, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(570, 161, 133, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setBounds(488, 133, 72, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(488, 164, 72, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(591, 192, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Already User");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(570, 82, 125, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New User");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(134, 82, 111, 32);
		frame.getContentPane().add(lblNewLabel_4);
		
		panel = new JPanel();
		
		panel.setVisible(false);
		// make variable global
		panel.setBounds(26, 244, 677, 266);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		name_field = new JTextField();
		//make your textfield field variable global, so you can access them within application
		//by default they are global here
		name_field.setBounds(146, 8, 131, 20);
		panel.add(name_field);
		name_field.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setBounds(23, 14, 46, 14);
		panel.add(lblNewLabel_5);
		
		username_field = new JTextField();
		username_field.setBounds(146, 39, 131, 20);
		panel.add(username_field);
		username_field.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Create Username");
		lblNewLabel_6.setBounds(23, 45, 95, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Choose Password");
		lblNewLabel_7.setBounds(23, 73, 95, 14);
		panel.add(lblNewLabel_7);
		
		org_field = new JTextField();
		org_field.setBounds(146, 101, 131, 20);
		panel.add(org_field);
		org_field.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Organization");
		lblNewLabel_8.setBounds(23, 104, 95, 14);
		panel.add(lblNewLabel_8);
		
		date_field = new JTextField();
		date_field.setBounds(146, 132, 131, 20);
		panel.add(date_field);
		date_field.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("DAte of Birth");
		lblNewLabel_9.setBounds(23, 129, 95, 14);
		panel.add(lblNewLabel_9);
		
		mobile_field = new JTextField();
		mobile_field.setBounds(445, 8, 124, 20);
		panel.add(mobile_field);
		mobile_field.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Mobile");
		lblNewLabel_10.setBounds(363, 11, 46, 14);
		panel.add(lblNewLabel_10);
		
		JButton create_account = new JButton("Create Account");
		create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String insert_data = "INSERT INTO USERTABLE values(?,?,?,?,?,?)";
					PreparedStatement statement =  connection.prepareStatement(insert_data);
					statement.setString(1, name_field.getText());
					statement.setString(2, username_field.getText());
					statement.setString(3, password_field.getText());
					statement.setString(4, org_field.getText());
					statement.setString(5, date_field.getText());
					statement.setString(6, mobile_field.getText());
					
					int data_entered = statement.executeUpdate();
					if(data_entered >0) {
						JOptionPane.showMessageDialog(null, "data added");
					} else {
						JOptionPane.showMessageDialog(null, "error in data adding");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		create_account.setBounds(363, 58, 205, 49);
		panel.add(create_account);
		
		password_field = new JPasswordField();
		password_field.setBounds(146, 70, 131, 20);
		panel.add(password_field);
		
		//called create table
		//createTableNew();
	}
}
