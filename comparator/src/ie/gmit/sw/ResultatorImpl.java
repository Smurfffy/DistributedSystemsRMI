package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator {
	
	//Serial Id is for marshaling purposes
	public static final long serialVersionUID = 1L;
	private String result;
	private boolean process;
	
	// Result is gotten from the comparison algorithms(distance) set in this class so that the servlet can retreive it 
	//process is initially false because no comparison has been made. when comparison is made in stringserviceImpl it is set to true 
	public ResultatorImpl() throws RemoteException {
		//this.result = null;
		this.process = false;
	}
	
	
	// gets the result 
	@Override
	public String getResult() throws RemoteException {
		// TODO Auto-generated method stub
		return this.result;
	}

	//set the result
	@Override
	public void setResult(String result) throws RemoteException {
		// TODO Auto-generated method stub
		this.result = result;
	}

	// checks if its been processed. ie. if process = false
	@Override
	public boolean isProcessed() throws RemoteException {
		// TODO Auto-generated method stub
		return this.process;
	}

	// When comparison is made call this to set the process as being completed
	@Override
	public void setProcessed() throws RemoteException {
		// TODO Auto-generated method stub
		this.process = true;
	}

	
}
