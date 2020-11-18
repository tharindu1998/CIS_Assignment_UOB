package com.lapizza.client;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.JButton;


public class HomePageUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7051876008673163183L;
	/**
	 * 
	 */

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageUI frame = new HomePageUI();
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
	public HomePageUI() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 350);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAddCustomerReview = new JButton("Add Customer Review");
		btnAddCustomerReview.setBackground(Color.ORANGE);
		btnAddCustomerReview.setBounds(236, 142, 166, 44);
		btnAddCustomerReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questions1UI Q1= new Questions1UI();
				Q1.setVisible(false);
				Q1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Q1.setResizable(false);
				Q1.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btnAddCustomerReview);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBackground(Color.ORANGE);
		btnAdminLogin.setBounds(624, 286, 152, 23);
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginUI AL= new AdminLoginUI();
				AL.setVisible(false);
				AL.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				AL.setResizable(false);
				AL.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btnAdminLogin);
		
		JLabel lblHomepage = new JLabel("");
		lblHomepage.setIcon(new ImageIcon(HomePageUI.class.getResource("/images/HomeUI.jpg")));
		lblHomepage.setBounds(0, 0, 800, 350);
		panel.add(lblHomepage);
	}
}
