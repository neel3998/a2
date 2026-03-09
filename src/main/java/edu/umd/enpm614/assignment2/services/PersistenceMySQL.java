package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Persistence;

public class PersistenceMySQL implements Persistence {
	@Override
	public String getType() {
		return "MySQL Persistence";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		
		return true;
	}
}
