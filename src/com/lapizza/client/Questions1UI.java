package com.lapizza.client;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import com.lapizza.questions.Questions;
import com.lapizza.rimiinterface.TheInterface;


public class Questions1UI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3868210284601394460L;
	private JPanel contentPane;
	
	private final ButtonGroup Q1group = new ButtonGroup();
	private final ButtonGroup Q2group = new ButtonGroup();
	private final ButtonGroup Q3group = new ButtonGroup();
	private final ButtonGroup Q4group = new ButtonGroup();
	private final ButtonGroup Q5group = new ButtonGroup();
	private final ButtonGroup Q6group = new ButtonGroup();

	
	String question1;
	String question2;
	String question3;
	String question4;
	String question5;
	String question6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questions1UI frame = new Questions1UI();
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
	public Questions1UI() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 667, 626);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 658, 595);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnQ1Yes = new JRadioButton("Yes");
		Q1group.add(rdbtnQ1Yes);
		rdbtnQ1Yes.setBounds(82, 112, 109, 23);
		panel.add(rdbtnQ1Yes);
		
		JRadioButton rdbtnQ1No = new JRadioButton("No");
		Q1group.add(rdbtnQ1No);
		rdbtnQ1No.setBounds(207, 112, 109, 23);
		panel.add(rdbtnQ1No);
		
		JRadioButton rdbtnQ2Yes = new JRadioButton("Yes");
		Q2group.add(rdbtnQ2Yes);
		rdbtnQ2Yes.setBounds(82, 193, 109, 23);
		panel.add(rdbtnQ2Yes);
		
		JRadioButton rdbtnQ2No = new JRadioButton("No");
		Q2group.add(rdbtnQ2No);
		rdbtnQ2No.setBounds(207, 193, 109, 23);
		panel.add(rdbtnQ2No);
		
		JRadioButton rdbtnQ3Yes = new JRadioButton("Yes");
		Q3group.add(rdbtnQ3Yes);
		rdbtnQ3Yes.setBounds(82, 272, 109, 23);
		panel.add(rdbtnQ3Yes);
		
		JRadioButton rdbtnQ3No = new JRadioButton("No");
		Q3group.add(rdbtnQ3No);
		rdbtnQ3No.setBounds(207, 272, 109, 23);
		panel.add(rdbtnQ3No);
		
		JRadioButton rdbtnQ4Yes = new JRadioButton("Yes");
		Q4group.add(rdbtnQ4Yes);
		rdbtnQ4Yes.setBounds(82, 351, 109, 23);
		panel.add(rdbtnQ4Yes);
		
		JRadioButton rdbtnQ4No = new JRadioButton("No");
		Q4group.add(rdbtnQ4No);
		rdbtnQ4No.setBounds(207, 351, 109, 23);
		panel.add(rdbtnQ4No);
		
		JRadioButton rdbtnQ5Yes = new JRadioButton("Yes");
		Q5group.add(rdbtnQ5Yes);
		rdbtnQ5Yes.setBounds(82, 435, 109, 23);
		panel.add(rdbtnQ5Yes);
		
		JRadioButton rdbtnQ5No = new JRadioButton("No");
		Q5group.add(rdbtnQ5No);
		rdbtnQ5No.setBounds(207, 435, 109, 23);
		panel.add(rdbtnQ5No);
		
		JRadioButton rdbtnQ6Yes = new JRadioButton("Yes");
		Q6group.add(rdbtnQ6Yes);
		rdbtnQ6Yes.setBounds(82, 521, 109, 23);
		panel.add(rdbtnQ6Yes);
		
		JRadioButton rdbtnQ6No = new JRadioButton("No");
		Q6group.add(rdbtnQ6No);
		rdbtnQ6No.setBounds(207, 521, 109, 23);
		panel.add(rdbtnQ6No);
		
		JButton btnNext = new JButton("Submit");
		btnNext.setBackground(Color.ORANGE);
		btnNext.setBounds(523, 535, 89, 23);
		btnNext.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Enumeration<AbstractButton> bg1 = Q1group.getElements();
				while (bg1.hasMoreElements()) {
					JRadioButton jrdb1 = (JRadioButton) bg1.nextElement();
					if (jrdb1.isSelected()) {
						question1 = jrdb1.getText().toString();
						System.out.println(question1);
						
					}
				}
				Enumeration<AbstractButton> bg2 = Q2group.getElements();
				while (bg2.hasMoreElements()) {
					JRadioButton jrdb2 = (JRadioButton) bg2.nextElement();
					if (jrdb2.isSelected()) {
						question2 = jrdb2.getText().toString();
						System.out.println(question2);
						

					}

				}
				Enumeration<AbstractButton> bg3 = Q3group.getElements();
				while (bg3.hasMoreElements()) {
					JRadioButton jrdb3 = (JRadioButton) bg3.nextElement();
					if (jrdb3.isSelected()) {
						question3 = jrdb3.getText().toString();
						System.out.println(question3);
						

					}

				}
				Enumeration<AbstractButton> bg4 = Q4group.getElements();
				while (bg4.hasMoreElements()) {
					JRadioButton jrdb4 = (JRadioButton) bg4.nextElement();
					if (jrdb4.isSelected()) {
						question4 = jrdb4.getText().toString();
						System.out.println(question4);
						

					}

				}
				Enumeration<AbstractButton> bg5 = Q5group.getElements();
				while (bg5.hasMoreElements()) {
					JRadioButton jrdb5 = (JRadioButton) bg5.nextElement();
					if (jrdb5.isSelected()) {
						question5 = jrdb5.getText().toString();
						System.out.println(question3);
						

					}

				}
				Enumeration<AbstractButton> bg6 = Q6group.getElements();
				while (bg6.hasMoreElements()) {
					JRadioButton jrdb6 = (JRadioButton) bg6.nextElement();
					if (jrdb6.isSelected()) {
						question6 = jrdb6.getText().toString();
						System.out.println(question3);
						
					}

				}
				try {
					TheInterface questionset1 = (TheInterface) Naming.lookup("rmi://localhost:1099/LaPizza");
					questionset1.one(new Questions(question1,question2,question3,question4,question5,question6));

				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Run Server First", "ALERT", JOptionPane.WARNING_MESSAGE);
				}
				ThankyouUI TyUI= new ThankyouUI();
				TyUI.setVisible(true);
				TyUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				TyUI.setResizable(false);
				TyUI.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel.add(btnNext);
		
		JLabel lblHomepage = new JLabel("");
		lblHomepage.setIcon(new ImageIcon(Questions1UI.class.getResource("/images/Questions.jpg")));
		lblHomepage.setBounds(0, 0, 655, 591);
		panel.add(lblHomepage);
	}
}
