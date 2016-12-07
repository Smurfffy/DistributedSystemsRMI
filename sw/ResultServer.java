package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

//sets up the rmi registry
public class ResultServer {
	// needs to be a main class to run
	public static void main(String[] args) throws Exception{
		
		//creates a new object for StringService
		// creates the port for tomcat to listen on
		// binds the stringService object to a human readable name so it can be found by the client
		StringService ss =  new StringServiceImpl();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("StringService", ss);
		
		// Output to verify its running
		System.out.println("String Service Bound");
	}

}
