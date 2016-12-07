package ie.gmit.sw;

import java.rmi.Naming;

public class ResultClient /*implements Runnable*/{
	
	private static String s = "String";
	private static String t = "StrangyString";
	private static String algo = "Levenshtein";
	
	public static void main(String[] args){
		// needs to be a main class to run
		try{
			// makes a stringservice objects related to the binding on the port created
			StringService ss = (StringService) Naming.lookup("rmi://localhost:1099/StringService");
			// runs the comparason
			Resultator r = ss.compare(s, t, algo);
			// prints out the result
			System.out.println("Result is: " + r.getResult());
		}catch(Exception e){
			System.err.println("String Service Error");
			e.printStackTrace();
		}
	}

	/*@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
	}*/
	
}
