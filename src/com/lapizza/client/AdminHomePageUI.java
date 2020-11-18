package com.lapizza.client;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lapizza.rimiinterface.TheInterface;

public class AdminHomePageUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8449564438978661649L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePageUI frame = new AdminHomePageUI();
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
	public AdminHomePageUI() {
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
		
		JButton btnViewAnalytics = new JButton("View Analytics");
		btnViewAnalytics.setBackground(Color.ORANGE);
		btnViewAnalytics.setBounds(286, 173, 144, 23);
		panel.add(btnViewAnalytics);
		btnViewAnalytics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String question = "";
				//BufferedImage image = null;
				BufferedImage image = null;
				try {

					TheInterface questionone = (TheInterface) Naming.lookup("rmi://localhost:1099/LaPizza");

					question = questionone.QuestionNo1();

					URL url = new URL(question);

					HttpURLConnection con = (HttpURLConnection) url.openConnection();

					con.setRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

					image = ImageIO.read(con.getInputStream());

					JFrame frame = new JFrame();
					frame.setForeground(Color.WHITE);
					// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ComplainsUI.class.getResource("/images/cupcake.png")));
					frame.setResizable(false);
					frame.setBackground(Color.WHITE);
					frame.setSize(1030, 670);
					JLabel label = new JLabel(new ImageIcon(image));
					frame.getContentPane().add(label);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Run Server First", "ALERT", JOptionPane.WARNING_MESSAGE);

				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				GraphUI graph= new GraphUI();
//				graph.setVisible(true);
//				graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//				graph.setResizable(false);
//				dispose();
			}
		});
		
		JButton btnNewCustomerReview = new JButton("Add Customer Review");
		btnNewCustomerReview.setBackground(Color.ORANGE);
		btnNewCustomerReview.setBounds(286, 124, 144, 23);
		btnNewCustomerReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Questions1UI Q1UI= new Questions1UI();
				Q1UI.setVisible(true);
				Q1UI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Q1UI.setResizable(false);
				Q1UI.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btnNewCustomerReview);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.ORANGE);
		btnLogout.setBounds(481, 236, 89, 23);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePageUI HpUI= new HomePageUI();
				HpUI.setVisible(true);
				HpUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				HpUI.setResizable(false);
				HpUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btnLogout);
		
		JLabel lblAdminHomepage = new JLabel("");
		lblAdminHomepage.setIcon(new ImageIcon(AdminHomePageUI.class.getResource("/images/AdminHomePageUI.jpg")));
		lblAdminHomepage.setBounds(0, 0, 580, 277);
		panel.add(lblAdminHomepage);
	}
}
