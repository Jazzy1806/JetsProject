package com.skilldistillery.jets.entities;

public class Pilot {
	private String firstName;
	private String lastName;
	private String nickname;
	private int age;
	private int yearsExperience;
	
	public Pilot() {
		
	}

	public Pilot(String firstName, String lastName, String nickname, int age, int yearsExperience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.age = age;
		this.yearsExperience = yearsExperience;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getNickname() {
		return lastName;
	}

	public void setNickname(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getYearsExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	@Override
	public String toString() {
		return "Pilot name: " + firstName + " " + lastName + ", AKA " + nickname + ", Age: " + age + ", Years of Experience: "
				+ yearsExperience;
	}
}
