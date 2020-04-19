package com.msglc.entites;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Personne{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int privileges;

	public Administrateur() {
		super();
	}

	public Administrateur(int privileges) {
		super();
		this.privileges = privileges;
	}

	public int getPrivileges() {
		return privileges;
	}

	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}
	
	
	
}
