package com.lapizza.rmiserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import com.lapizza.questions.Questions;
import com.lapizza.rimiinterface.TheInterface;




public class TheImplementation extends UnicastRemoteObject implements TheInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8704625249855359597L;
	
	static Connection conn;
	
	protected TheImplementation() throws RemoteException {
		super();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lapizza", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}




	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub

		String sql="SELECT username, password FROM users WHERE username=? and password=?";
		

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(null, "Error" + e.toString());
		}
		return false;
	}


	@Override
	public void one(Questions questionset1) throws RemoteException {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO `questionset1`(`Q1`, `Q2`, `Q3`, `Q4`, `Q5`, `Q6`) VALUES (?,?,?,?,?,?)";

		try {
			PreparedStatement pst = conn.prepareStatement(sql);

			pst.setString(1, questionset1.getQuestion1());
			pst.setString(2, questionset1.getQuestion2());
			pst.setString(3, questionset1.getQuestion3());
			pst.setString(4, questionset1.getQuestion4());
			pst.setString(5, questionset1.getQuestion5());
			pst.setString(6, questionset1.getQuestion6());
			pst.executeUpdate();

		} catch (Exception e) {
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(null, "error");

		}
		
	}


	@Override
	public String QuestionNo1() throws RemoteException {
		String answerOne = "", answerTwo = "", question = "";

		String sql = "SELECT COUNT(`Question1`)  FROM `questionset1` WHERE `Question1`='Yes'";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				answerOne = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "ERROR:");

		}

		String sql1 = "SELECT COUNT(`Question1`)  FROM `questionset1` WHERE `Question1`='No'";
		try {
			PreparedStatement pst = conn.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				answerTwo = rs.getString(1);
			}
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
			JOptionPane.showMessageDialog(null, "ERROR:");

		}

		
		try {

			question = "https://quickchart.io/chart?bkg=white&c={ type: 'outlabeledPie', data: { datasets: [ { data: [\'" + answerOne +"\', \'" + answerTwo + "\'], backgroundColor: [ 'rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)',], label: 'Dataset 1', }, ], labels: ['Yes', 'No'], }, options: { title: { display: true, text: 'QUESTION 01', }, },}";


			question = question.replace(" ", "");

		} catch (Exception e) {

		}

		return question;
		
	}

	

	

}

