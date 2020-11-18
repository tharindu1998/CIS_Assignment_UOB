package com.lapizza.client;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lapizza.rimiinterface.TheInterface;

import javax.swing.JButton;
import javax.swing.JDialog;


public class AdminLoginUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -66970503805974473L;
	
	private JPanel contentPane;
	private JTextField UserNameTextField;
	private JTextField PasswordTextField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginUI frame = new AdminLoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AdminLoginUI() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 580, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 580, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		UserNameTextField = new JTextField();
		UserNameTextField.setBounds(157, 132, 254, 20);
		panel.add(UserNameTextField);
		UserNameTextField.setColumns(10);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setBounds(157, 185, 254, 20);
		panel.add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setBounds(387, 234, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = UserNameTextField.getText();
				String password = PasswordTextField.getText();
				
				if (password.isEmpty() || username.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Username or Password Field can't be Empty", "Error", 1);									
				}
				else{
					try {
						TheInterface s = (TheInterface)Naming.lookup("rmi://localhost:1099/LaPizza");
						  if(s.checkUser(username,password)){
							  
							    
							
							  	AdminHomePageUI AHP =new AdminHomePageUI();
							  	AHP.setVisible(true);
							  	AHP.setLocationRelativeTo(null);
						        dispose();
						  }else{
								final JDialog dialog = new JDialog();
								dialog.setAlwaysOnTop(true);    
								JOptionPane.showMessageDialog(null,"User Name or Password  Invalid");
							}
						
					} catch (MalformedURLException | RemoteException | NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						 JOptionPane.showMessageDialog(null,"Please Run The Server First",
								 "ALERT",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
		panel.add(btnLogin);
		JLabel lblHomepage = new JLabel("");
		lblHomepage.setIcon(new ImageIcon(AdminLoginUI.class.getResource("/images/Login.jpg")));
		lblHomepage.setBounds(0, 0, 580, 277);
		panel.add(lblHomepage);
	}
}
