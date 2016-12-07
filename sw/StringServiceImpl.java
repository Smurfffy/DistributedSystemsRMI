package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServiceImpl extends UnicastRemoteObject implements StringService{
	
	// Serial version Id for unmarshaling
	public static final long serialVersionUID = 1L;
	private Resultator res; // object it returns
	private Levenshtein levenshtein = new Levenshtein(); // comparison algorithm
	private int distance; //result of Levenshtein
	
	protected StringServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	//runs the comparison by calling comparison algorithm and setting the result and the process
	@Override
	public Resultator compare(String s, String t, String algo) throws RemoteException {
		// TODO Auto-generated method stub
		
		// for every new comparison it needs a new resultator object
		res = new ResultatorImpl();
		
		// toLowerCase() is used so the dropdown menu can be different 
		if (algo.toLowerCase() == "levenshtein distance") {
			
			// setting the class variable distance by calling the distance method in the algorithm
			distance = levenshtein.distance(s, t);
			//sets the result and converts the integer to a string so it matches with setResult() variables
			res.setResult(Integer.toString(distance));
			
			//thread.sleep will go here
			
			// sets the process to true
			res.setProcessed();
		}
		
		// returns the resultator object
		return res;
	}
	
	

}
