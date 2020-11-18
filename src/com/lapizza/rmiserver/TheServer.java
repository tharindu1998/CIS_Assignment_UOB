/**
 * 
 */
package com.lapizza.rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.lapizza.rimiinterface.TheInterface;
/**
 * @author Tharindu
 *
 */
public class TheServer {

	/**
	 * @param args
	 */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	public static void main(String[] args) {
		System.out.println("Attempting to start the LaPizzaServer"); 
		try {
			TheInterface users = new TheImplementation();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("LaPizza",users);

			System.out.println("Service started. Welcome to the RMI LaPizzaService!");

		} catch (RemoteException e) {
			System.out.println("An error occured: "+e.toString()); 
			e.printStackTrace();
		} 


	}

}
