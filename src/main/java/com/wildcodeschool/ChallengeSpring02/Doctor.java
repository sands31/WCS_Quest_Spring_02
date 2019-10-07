package com.wildcodeschool.ChallengeSpring02;

public class Doctor {
	
	private String name;
	private int id;
	
	public Doctor(String name, int id) {
		this.name = name;
		this.id = id;		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId () {
		return this.id;
	}

}
