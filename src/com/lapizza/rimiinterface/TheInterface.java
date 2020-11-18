package com.lapizza.rimiinterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import com.lapizza.questions.Questions;



public interface TheInterface extends Remote {


	

	public boolean checkUser(String username, String password)throws RemoteException;
	
	public void one(Questions question1) throws RemoteException;
	
	public String QuestionNo1()throws RemoteException; 




}
