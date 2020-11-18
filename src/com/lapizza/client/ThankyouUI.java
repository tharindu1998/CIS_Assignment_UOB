package com.lapizza.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ThankyouUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2135886072873116493L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThankyouUI frame = new ThankyouUI();
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
	public ThankyouUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBackground(Color.ORANGE);
		btnDone.setBounds(135, 153, 89, 23);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePageUI HpUI= new HomePageUI();
				HpUI.setVisible(true);
				HpUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				HpUI.setResizable(false);
				HpUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btnDone);
		
		JLabel lblHomepage = new JLabel("");
		lblHomepage.setIcon(new ImageIcon(ThankyouUI.class.getResource("/images/ThankYou.jpg")));
		lblHomepage.setBounds(0, 0, 552, 239);
		panel.add(lblHomepage);
	}
}
