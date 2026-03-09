package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Persistence;
import org.springframework.stereotype.Component;

public class PersistenceOracle implements Persistence {
	@Override
	public String getType() {
		return "Oracle Persistence";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
